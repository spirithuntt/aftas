package com.example.aftas.service.implementation.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.example.aftas.domain.Authority;
import com.example.aftas.domain.enums.AuthorityEnum;
import com.example.aftas.repository.auth.AuthorityRepository;
import com.example.aftas.service.auth.AuthorityService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorityServiceImpl implements AuthorityService {

    private final AuthorityRepository authorityRepository;

    @Override
    public List<Authority> getAllByName(List<AuthorityEnum> authorities) {
        List<String> usersAuthorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
        if (usersAuthorities.contains(AuthorityEnum.VIEW_AUTHORITIES.toString())) {
            return authorityRepository.findAllByName(authorities);
        }
        return null;
    }
    @Override
    public Optional<Authority> getByName(AuthorityEnum authorityEnum) {
        return authorityRepository.findByName(authorityEnum);
    }

    @Override
    public Optional<Authority> getById(Long id) {
        return authorityRepository.findById(id);
    }
}
