package com.example.aftas.web.controller.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.example.aftas.domain.Role;
import com.example.aftas.dto.requests.auth.GrantAuthoritiesRequestDto;
import com.example.aftas.dto.requests.auth.GrantRoleToUserRequestDto;
import com.example.aftas.dto.requests.auth.RoleRequestDTO;
import com.example.aftas.dto.responses.auth.RoleResponseDTO;
import com.example.aftas.service.auth.RoleService;
import com.example.aftas.service.auth.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<RoleResponseDTO>> getAll() {
        List<Role> roles = roleService.getAll();
        if (roles.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else return new ResponseEntity<>(roles.stream().map(RoleResponseDTO::fromRole).toList(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RoleResponseDTO> save(@RequestBody RoleRequestDTO roleToSave) {
        Role role = roleService.save(roleToSave.toRole(), false);
        if (role == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else return new ResponseEntity<>(RoleResponseDTO.fromRole(role), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('GRANT_AUTHORITY_TO_ROLE')")
    @PutMapping("/grant_authorities")
    public ResponseEntity<RoleResponseDTO> grantAuthorities(@RequestBody GrantAuthoritiesRequestDto rolesAuthorities) {
        Role role = roleService.grantAuthorities(rolesAuthorities.getAuthorityId(), rolesAuthorities.getRoleId());
        if (role == null) {
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else return new ResponseEntity<>(RoleResponseDTO.fromRole(role), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('REVOKE_AUTHORITY_FROM_ROLE')")
    @PutMapping("/revoke_authorities")
    public ResponseEntity<RoleResponseDTO> revokeAuthorities(@RequestBody GrantAuthoritiesRequestDto rolesAuthorities) {
        Role role = roleService.revokeAuthorities(rolesAuthorities.getAuthorityId(), rolesAuthorities.getRoleId());
        if (role == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        else return new ResponseEntity<>(RoleResponseDTO.fromRole(role), HttpStatus.OK);
    }

    //grant role to user
    @PreAuthorize("hasAnyAuthority('ASSIGN_ROLE_TO_USER')")
    @PostMapping("/grant_role_to_user")
    public ResponseEntity<RoleResponseDTO> grantRoleToUser(@RequestBody GrantRoleToUserRequestDto grantRoleToUserRequestDto) {
        Role role = userService.grantRoleToUser(grantRoleToUserRequestDto.getUserId(), grantRoleToUserRequestDto.getRoleId());

        if (role == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(RoleResponseDTO.fromRole(role), HttpStatus.OK);
        }
    }

    @PreAuthorize("hasAnyAuthority('DELETE_ROLE')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (roleService.getById(id).isPresent()) {
            roleService.delete(id);
            return ResponseEntity.ok().build();
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PreAuthorize("hasAnyAuthority('MANAGE_USERS_ACCOUNTS')")
    @PutMapping("/unlock/{userId}")
    public ResponseEntity<Void> unlockAccount(@PathVariable Long userId) {
        userService.unlockAccount(userId);
        return ResponseEntity.ok().build();
    }
}

