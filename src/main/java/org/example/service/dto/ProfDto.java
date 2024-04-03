package org.example.service.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;
import org.example.modele.Prof;

@Data
@Builder
public class ProfDto {
    private long id;
    @NotEmpty(message = "Doit avoir un nom")
    private String nomProf;

    public static ProfDto toProfDto(Prof prof) {
        return ProfDto.builder()
                .id(prof.getId())
                .nomProf(prof.getNomProf())
                .build();
    }
}
