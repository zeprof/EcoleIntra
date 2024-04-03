package org.example.service.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ProfDtoNew {
    @NotEmpty(message = "Doit avoir un nom")
    private String nomProf;
}
