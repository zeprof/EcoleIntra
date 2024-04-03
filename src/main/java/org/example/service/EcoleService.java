package org.example.service;

import org.example.dao.CoursRepository;
import org.example.dao.EtudiantRepository;
import org.example.dao.ProfRepository;
import org.example.modele.Prof;
import org.example.service.dto.ProfDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EcoleService {

    private final ProfRepository profRepository;

    public EcoleService(ProfRepository profRepository) {
        this.profRepository = profRepository;
    }


    public Prof createProf(Prof prof) {
        Objects.requireNonNull(prof);
        return profRepository.save(prof);
    }

    public ProfDto createProf(String nomProf) {
        Objects.requireNonNull(nomProf);
        return ProfDto.toProfDto(profRepository.save(new Prof(nomProf)));
    }

//    public Prof findProf(String prof) {
//        Objects.requireNonNull(prof);
//        return profRepository.findByNomProf(prof)
//                .orElse(null);
//    }

    public ProfDto findProf(String nomProf) {
        Objects.requireNonNull(nomProf);
        return ProfDto.toProfDto(profRepository.findByNomProf(nomProf)
                      .orElse(null));
    }

    public List<ProfDto> findAllProfs() {
        return profRepository.findAll()
                .stream()
                .map(ProfDto::toProfDto)
                .toList();
    }

    public Optional<ProfDto> getProf(long id) {
        return profRepository.findById(id)
                .map(ProfDto::toProfDto);

    }

    public Optional<ProfDto> saveProf(ProfDto profDto) {
        final Optional<Prof> profOpt = profRepository.findById(profDto.getId());
        if (profOpt.isPresent()) {
            Prof p = profOpt.get();
            p.setNomProf(profDto.getNomProf());
            final Prof saved = profRepository.save(p);
            return Optional.of(ProfDto.toProfDto(saved));
        }
        return Optional.of(null);
    }
}
