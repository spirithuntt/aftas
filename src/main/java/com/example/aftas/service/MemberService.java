package com.example.aftas.service;

import com.example.aftas.domain.Member;
import com.example.aftas.dto.requests.MemberRequestDTO;
import com.example.aftas.dto.responses.MemberResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MemberService {

    MemberResponseDTO save(MemberRequestDTO member);

    List<MemberResponseDTO> getAll();

    MemberResponseDTO getById(Long id);

    MemberResponseDTO update(MemberRequestDTO member, Long id);

    void delete(Long id);

    List<MemberResponseDTO> getByName(String name);

    MemberResponseDTO getByIdentityNumber(String identityNumber);

    List<MemberResponseDTO> getByNameOrFamilyNameOrNumber(String searchParam);

}
