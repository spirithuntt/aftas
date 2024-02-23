package com.example.aftas.domain.enums;

public enum AuthorityEnum {

    GRANT_AUTHORITY_TO_ROLE,
    REVOKE_AUTHORITY_FROM_ROLE,
    ASSIGN_ROLE_TO_USER,
    CREATE_ROLE,
    UPDATE_ROLE,
    DELETE_ROLE,
    VIEW_ROLES,
    UPDATE_USERS,
    VIEW_USERS,
    DELETE_USERS,
    VIEW_AUTHORITIES,

    // authorities for Member
    VIEW_COMPETITIONS_LIST,
    CHECK_PARTICIPATIONS,
    ACCESS_PODIUM_INFORMATION,

    // authorities for Jury
    MANAGE_COMPETITIONS,
    ORGANIZE_COMPETITION_TASKS,
    EVALUATE_COMPETITION,
    VIEW_HUNTING_RESULTS,

    // authorities for Manager
    MANAGE_USERS_ACCOUNTS,
    MANAGE_USERS_ACTIONS,
    MANAGE_OTHER_USERS_ROLES,

    //other authorities





}