package com.example.aftas.service.auth;

import com.example.aftas.domain.RefreshToken;
import com.example.aftas.dto.requests.auth.RefreshTokenRequestDTO;
import com.example.aftas.dto.responses.auth.AuthenticationResponse;
import com.example.aftas.dto.responses.auth.RefreshTokenResponse;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface RefreshTokenService {
     RefreshToken createRefreshToken(String email);

     RefreshToken verifyExpiration(RefreshToken token);

     Optional<RefreshToken> findByToken(String token);

     RefreshTokenResponse refreshToken(RefreshTokenRequestDTO refreshTokenRequestDTO);
}