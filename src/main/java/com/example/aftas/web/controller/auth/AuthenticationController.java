package com.example.aftas.web.controller.auth;

import com.example.aftas.dto.requests.auth.RefreshTokenRequestDTO;
import com.example.aftas.dto.responses.auth.RefreshTokenResponse;
import com.example.aftas.security.JwtService;
import com.example.aftas.service.auth.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.aftas.dto.requests.auth.AuthenticationRequest;
import com.example.aftas.dto.requests.auth.RegisterRequest;
import com.example.aftas.dto.responses.auth.AuthenticationResponse;
import com.example.aftas.service.auth.AuthenticationService;
import com.example.aftas.domain.RefreshToken;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final RefreshTokenService refreshTokenService;
    private final JwtService jwtService;


    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @PostMapping("/refreshToken")
    public RefreshTokenResponse refreshToken(@RequestBody RefreshTokenRequestDTO refreshTokenRequestDTO) {
        return refreshTokenService.refreshToken(refreshTokenRequestDTO);
    }

}
