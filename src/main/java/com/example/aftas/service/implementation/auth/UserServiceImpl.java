package com.example.aftas.service.implementation.auth;

import com.example.aftas.domain.Member;
import com.example.aftas.handler.exception.CustomException;
import com.example.aftas.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.aftas.domain.Role;
import com.example.aftas.repository.auth.RoleRepository;
import com.example.aftas.repository.auth.UserRepository;
import com.example.aftas.service.auth.UserService;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final MemberRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public Role grantRoleToUser(Long userId, Long roleId) {
        List<String> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
        if (authorities.contains("ASSIGN_ROLE_TO_USER")) {
            Role role = roleRepository.findById(roleId).orElse(null);
            Member user = userRepository.findById(userId).orElse(null);
            if (role != null && user != null) {
                user.setRole(role);
                userRepository.save(user);
                return role;
            }
            throw new CustomException("Role or user not found", HttpStatus.NOT_FOUND);
        } throw new CustomException("Insufficient authorities", HttpStatus.UNAUTHORIZED);
    }

    @Override
    public Optional<Member> getById(Long id) {
        return Optional.empty();
    }


    @Override
    public void unlockAccount(Integer number) {
        Member member = userRepository.findByNumber(number);
        System.out.println("testttt"+member);
        if (member == null) throw new UsernameNotFoundException("User not found");
        member.unlockAccount();
        userRepository.save(member);
    }
}
