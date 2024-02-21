package com.example.aftas.service.auth;

import org.springframework.stereotype.Component;
import com.example.aftas.domain.Role;

import java.util.List;
import java.util.Optional;

@Component
public interface RoleService {

    Role save(Role role, boolean isSeed);

    Optional<Role> findDefaultRole();

    Role update(Role role, Long id);

    Optional<Role> getById(Long id);

    Optional<Role> getByName(String name);

    void delete(Long id);

    List<Role> getAll();

    Role grantAuthorities(Long authorityId, Long roleId);

    Role revokeAuthorities(Long authorityId, Long roleId);

}