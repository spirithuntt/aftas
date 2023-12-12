package com.example.aftas.service.implementation;

import com.example.aftas.dto.requests.MemberRequestDTO;
import com.example.aftas.dto.responses.MemberResponseDTO;
import com.example.aftas.service.MemberService;

import java.util.List;

public class MemberServiceImpl implements MemberService {
    @Override
    public MemberResponseDTO save(MemberRequestDTO member) {
        return null;
    }

    @Override
    public List<MemberResponseDTO> getAll() {
        return null;
    }

    @Override
    public MemberResponseDTO getById(Long id) {
        return null;
    }

    @Override
    public MemberResponseDTO update(MemberRequestDTO member, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<MemberResponseDTO> getByName(String name) {
        return null;
    }

    @Override
    public MemberResponseDTO getByIdentityNumber(String identityNumber) {
        return null;
    }

    @Override
    public List<MemberResponseDTO> getByNameOrFamilyNameOrNumber(String searchParam) {
        return null;
    }
}
