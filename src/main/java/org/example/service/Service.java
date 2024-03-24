package org.example.service;

import org.example.dao.EcoleRepositoryJpa;
import org.example.modele.Prof;

import java.util.Objects;

public class Service {
    private final EcoleRepositoryJpa ecoleRepository;

    public Service(EcoleRepositoryJpa ecoleRepository) {
        this.ecoleRepository = ecoleRepository;
    }

    public Prof createProf(Prof prof) {
        Objects.requireNonNull(prof);
        return ecoleRepository.save(prof);
    }

    public Prof findProf(String prof) {
        Objects.requireNonNull(prof);
        return ecoleRepository.findProf(prof);
    }
}
