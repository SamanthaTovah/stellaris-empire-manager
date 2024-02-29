package io.github.samanthatovah.stellaris.empiremanager.controller;

import io.github.samanthatovah.stellaris.empiremanager.model.Empire;
import io.github.samanthatovah.stellaris.empiremanager.model.Homeworld;
import io.github.samanthatovah.stellaris.empiremanager.model.Species;
import io.github.samanthatovah.stellaris.empiremanager.repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmpireController {

    private final EmpireRepository empireRepository;
    private final OriginRepository originRepository;
    private final AppearanceRepository appearanceRepository;
    private final PlanetClassRepository planetClassRepository;
    private final TraitRepository traitRepository;
    private final SpeciesRepository speciesRepository;
    private final HomeworldRepository homeworldRepository;

    public EmpireController(EmpireRepository empireRepository, OriginRepository originRepository,
                            AppearanceRepository appearanceRepository, PlanetClassRepository planetClassRepository,
                            TraitRepository traitRepository, SpeciesRepository speciesRepository,
                            HomeworldRepository homeworldRepository) {
        this.empireRepository = empireRepository;
        this.originRepository = originRepository;
        this.appearanceRepository = appearanceRepository;
        this.planetClassRepository = planetClassRepository;
        this.traitRepository = traitRepository;
        this.speciesRepository = speciesRepository;
        this.homeworldRepository = homeworldRepository;
    }

    @GetMapping("/empires")
    public String showEmpireTable(Model model) {
        List<Empire> empires = empireRepository.findAll();
        model.addAttribute("empires", empires);
        return "empire-table";
    }

    @GetMapping("/create-empire")
    public String showCreateEmpireForm(Model model) {
        Empire newEmpire = new Empire();
        newEmpire.setHomeworld(new Homeworld());
        newEmpire.setSpecies(new Species());

        model.addAttribute("empire", newEmpire);
        model.addAttribute("appearances", appearanceRepository.findAll());
        model.addAttribute("traits", traitRepository.findAll());
        model.addAttribute("planetClasses", planetClassRepository.findAll());
        model.addAttribute("origins", originRepository.findAll());

        return "empire-form";
    }

    @PostMapping("/create-empire")
    public String createEmpire(@ModelAttribute Empire empire) {
        speciesRepository.save(empire.getSpecies());
        homeworldRepository.save(empire.getHomeworld());
        empireRepository.save(empire);
        return "redirect:/empires";
    }

    @DeleteMapping("/delete-empire/{id}")
    @ResponseBody
    public String deleteEmpire(@PathVariable("id") Long id) {
        empireRepository.deleteById(id);
        return "redirect:/empires";
    }
}
