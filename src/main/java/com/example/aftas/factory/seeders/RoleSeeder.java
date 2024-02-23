package com.example.aftas.factory.seeders;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.aftas.domain.Authority;
import com.example.aftas.domain.Role;
import com.example.aftas.domain.enums.AuthorityEnum;
import com.example.aftas.repository.auth.RoleRepository;
import com.example.aftas.service.auth.AuthorityService;
import com.example.aftas.service.auth.RoleService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Component
public class RoleSeeder implements CommandLineRunner {

    private final RoleService roleService;
    private final AuthorityService authorityService;
    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) {
        if (roleRepository.count() == 0) {
            seedRoles();
        }
    }

    private void seedRoles() {
        //? authorities for Member
        Authority viewCompetitionsList = authorityService.getByName(AuthorityEnum.VIEW_COMPETITIONS_LIST)
                .orElseThrow(() -> new RuntimeException("VIEW_COMPETITIONS_LIST authority not found"));

        Authority checkParticipations = authorityService.getByName(AuthorityEnum.CHECK_PARTICIPATIONS)
                .orElseThrow(() -> new RuntimeException("CHECK_PARTICIPATIONS authority not found"));

        Authority accessPodiumInformation = authorityService.getByName(AuthorityEnum.ACCESS_PODIUM_INFORMATION)
                .orElseThrow(() -> new RuntimeException("ACCESS_PODIUM_INFORMATION authority not found"));

        //? authorities for Jury
        Authority manageCompetitions = authorityService.getByName(AuthorityEnum.MANAGE_COMPETITIONS)
                .orElseThrow(() -> new RuntimeException("MANAGE_COMPETITIONS authority not found"));

        Authority organizeCompetitionTasks = authorityService.getByName(AuthorityEnum.ORGANIZE_COMPETITION_TASKS)
                .orElseThrow(() -> new RuntimeException("ORGANIZE_COMPETITION_TASKS authority not found"));

        Authority evaluateCompetition = authorityService.getByName(AuthorityEnum.EVALUATE_COMPETITION)
                .orElseThrow(() -> new RuntimeException("EVALUATE_COMPETITION authority not found"));

        Authority viewRoles = authorityService.getByName(AuthorityEnum.VIEW_ROLES)
                .orElseThrow(() -> new RuntimeException("VIEW_ROLES authority not found"));

        Authority viewUsers = authorityService.getByName(AuthorityEnum.VIEW_USERS)
                .orElseThrow(() -> new RuntimeException("VIEW_USERS authority not found"));


        //? Create roles and associate authorities
        Role userRole = Role.builder()
                .name("MEMBER")
                .isDefault(true)
                .authorities(Arrays.asList(viewCompetitionsList, checkParticipations, accessPodiumInformation))
                .build();

        Role juryRole = Role.builder()
                .name("JURY")
                .authorities(Arrays.asList(manageCompetitions, organizeCompetitionTasks, evaluateCompetition, viewRoles, viewUsers, viewCompetitionsList, checkParticipations, accessPodiumInformation))
                .build();

        Role managerRole = Role.builder()
                .name("MANAGER")
                .authorities(getAllAuthorities())
                .build();

        roleService.save(userRole, true);
        roleService.save(juryRole, true);
        roleService.save(managerRole, true);
    }

    private List<Authority> getAllAuthorities() {
        List<Authority> authorities = new ArrayList<>();
        for (AuthorityEnum authorityEnum : AuthorityEnum.values()) {
            Authority authority = authorityService.getByName(authorityEnum)
                    .orElseThrow(() -> new RuntimeException(authorityEnum + " authority not found"));
            authorities.add(authority);
        }
        return authorities;
    }

}
