package com.example.aftas.service.auth;

import org.springframework.stereotype.Component;
import com.example.aftas.dto.requests.auth.AuthenticationRequest;
import com.example.aftas.dto.requests.auth.RegisterRequest;
import com.example.aftas.dto.responses.auth.AuthenticationResponse;


@Component
public interface AuthenticationService {

    AuthenticationResponse register(RegisterRequest user);

    AuthenticationResponse authenticate(AuthenticationRequest user);

}

