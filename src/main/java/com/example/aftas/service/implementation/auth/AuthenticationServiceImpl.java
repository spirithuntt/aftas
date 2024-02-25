package com.example.aftas.service.implementation.auth;

import com.example.aftas.domain.Member;
import com.example.aftas.service.auth.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.aftas.dto.requests.auth.AuthenticationRequest;
import com.example.aftas.dto.requests.auth.RegisterRequest;
import com.example.aftas.dto.responses.auth.AuthenticationResponse;
import com.example.aftas.repository.auth.UserRepository;
import com.example.aftas.security.JwtService;
import com.example.aftas.service.auth.AuthenticationService;
import com.example.aftas.service.auth.RoleService;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final RoleService roleService;
    private final RefreshTokenService refreshTokenService;

    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        Random random = new Random();
        long randomNumber;
        boolean numberExists;

        do {
            randomNumber = random.nextInt(10000); // Generate a random number up to 10000
            numberExists = userRepository.existsById(randomNumber); // Check if the number already exists
        } while (numberExists); // if it does generate another number

        var user = Member.builder()
                .name(request.getName())
                .number((int) randomNumber)
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(roleService.findDefaultRole().orElse(null))
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = refreshTokenService.createRefreshToken(user.getEmail());
        return AuthenticationResponse.builder().token(jwtToken).refreshToken(refreshToken.getToken()).name(user.getName()).email(user.getEmail()).role(user.getRole()).build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        System.out.println(request);
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = refreshTokenService.createRefreshToken(user.getEmail());
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .refreshToken(refreshToken.getToken())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }
}