package com.example.aftas.repository;

import com.example.aftas.domain.Competition;
import com.example.aftas.domain.Fish;
import com.example.aftas.domain.Hunting;
import com.example.aftas.domain.Member;

import java.util.List;

public interface HuntingRepository {

    Hunting save(Hunting hunting);

    List<Hunting> getAll();

    Hunting getById(Long id);

    Hunting update(Hunting hunting);

    void delete(Long id);

}
