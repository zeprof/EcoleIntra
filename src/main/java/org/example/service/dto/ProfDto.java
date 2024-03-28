package org.example.service.dto;

import org.example.modele.Prof;

public record ProfDto(long id, String nomProf) {
    public static ProfDto toProfDto(Prof prof) {
        return new ProfDto(prof.getId(), prof.getNomProf());
    }
}
