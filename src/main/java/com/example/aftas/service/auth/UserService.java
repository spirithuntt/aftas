package com.example.aftas.service.auth;

import org.springframework.stereotype.Component;
import com.example.aftas.domain.Role;
import com.example.aftas.domain.User;

import java.util.Optional;

@Component
public interface UserService {
    Optional<User> getById(Long id);

    Role grantRoleToUser(Long userId, Long roleId);
}
