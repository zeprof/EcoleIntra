package org.example.presentation;

import jakarta.validation.Valid;
import org.example.service.EcoleService;
import org.example.service.dto.ProfDto;
import org.example.service.dto.ProfDtoNew;
import org.example.service.dto.UnDtoAvecDate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
public class RootController {
    private final EcoleService ecoleService;

    public RootController(EcoleService ecoleService) {
        this.ecoleService = ecoleService;
    }

    @GetMapping("/ajouteprof")
    public String ajoutProf(Model model){
        model.addAttribute("prof", new ProfDtoNew());
        return "ajouteProf";
    }

    @PostMapping("/ajouteprof")
    public String ajouteProf(@Valid @ModelAttribute("prof") ProfDtoNew prof, BindingResult result){
        if (result.hasErrors()) {
            return "ajouteProf";
        }
        ecoleService.createProf(prof.getNomProf());

        return "redirect:/profs";
    }

    @GetMapping("/profs")
    public String listProfs(Model model){
        final List<ProfDto> allProfs = ecoleService.findAllProfs();
        model.addAttribute("profs", allProfs);
        return "profs";
    }

    @GetMapping("/prof/{id}")
    public String editProf(@PathVariable("id") long id, Model model){
        Optional<ProfDto> prof = ecoleService.getProf(id);
        prof.ifPresent(
            p -> model.addAttribute("prof", p));

        return "editProf";
    }

    @PostMapping("/editprof")
    public String editProf(@Valid @ModelAttribute("prof") ProfDto prof, BindingResult result){
        if (result.hasErrors()) {
            return "editprof";
        }
        ecoleService.saveProf(prof);

        return "redirect:/profs";
    }

    @GetMapping("/dateexamples")
    public String dateExammples(Model model) {
        model.addAttribute("localDateTime", LocalDateTime.now());
        model.addAttribute("localDate", LocalDate.now());
        model.addAttribute("timestamp", Instant.now());
        model.addAttribute("unDtoAvecDate", new UnDtoAvecDate());
        return "datesExample";
    }

    @PostMapping("/undtoavecdate")
    public String unDtoAvecDate(@ModelAttribute("unDtoAvecDate")UnDtoAvecDate unDtoAvecDate) {
        return "redirect:/dateexamples";
    }
}
