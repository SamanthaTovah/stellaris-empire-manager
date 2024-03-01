package io.github.samanthatovah.stellaris.empiremanager.controller;

import io.github.samanthatovah.stellaris.empiremanager.model.*;
import io.github.samanthatovah.stellaris.empiremanager.repository.*;
import io.github.samanthatovah.stellaris.empiremanager.service.EmpireValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
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
    private final CivicRepository civicRepository;
    private final GovernmentRepository governmentRepository;
    private final EmpireValidator empireValidator;

    public EmpireController(EmpireRepository empireRepository, OriginRepository originRepository,
                            AppearanceRepository appearanceRepository, PlanetClassRepository planetClassRepository,
                            TraitRepository traitRepository, SpeciesRepository speciesRepository,
                            HomeworldRepository homeworldRepository, CivicRepository civicRepository,
                            GovernmentRepository governmentRepository, EmpireValidator empireValidator) {
        this.empireRepository = empireRepository;
        this.originRepository = originRepository;
        this.appearanceRepository = appearanceRepository;
        this.planetClassRepository = planetClassRepository;
        this.traitRepository = traitRepository;
        this.speciesRepository = speciesRepository;
        this.homeworldRepository = homeworldRepository;
        this.civicRepository = civicRepository;
        this.governmentRepository = governmentRepository;
        this.empireValidator = empireValidator;
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
        populateEmpireFormModel(model);

        return "empire-form";
    }

    @PostMapping("/create-empire")
    public String createEmpire(@ModelAttribute Empire empire, BindingResult result, Model model) {
        empireValidator.validate(empire, result);

        if (result.hasErrors()) {
            populateEmpireFormModel(model);
            return "empire-form";
        }

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

    private void populateEmpireFormModel(Model model) {
        model.addAttribute("appearances", appearanceRepository.findAll().stream().sorted());
        model.addAttribute("traits", traitRepository.findAll().stream().sorted());
        model.addAttribute("planetClasses", planetClassRepository.findAll().stream().sorted());
        model.addAttribute("origins", originRepository.findAll().stream().sorted());
        model.addAttribute("ethics", Arrays.stream(Ethic.values()).toList());
        model.addAttribute("authorities", Arrays.stream(Authority.values()).toList());
        model.addAttribute("civics", civicRepository.findAll().stream().sorted());
        model.addAttribute("governments", governmentRepository.findAll().stream().sorted());
    }
}
