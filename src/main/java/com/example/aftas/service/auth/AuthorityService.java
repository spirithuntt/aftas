package com.example.aftas.service.auth;

import org.springframework.stereotype.Component;
import com.example.aftas.domain.Authority;
import com.example.aftas.domain.enums.AuthorityEnum;

import java.util.List;
import java.util.Optional;

@Component
public interface AuthorityService {
    List<Authority> getAllByName(List<AuthorityEnum> authorities);
    Optional<Authority> getByName(AuthorityEnum authorityEnum);

    Optional<Authority> getById(Long id);
}

