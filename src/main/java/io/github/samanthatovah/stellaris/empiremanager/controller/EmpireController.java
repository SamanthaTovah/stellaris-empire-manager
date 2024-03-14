package io.github.samanthatovah.stellaris.empiremanager.controller;

import io.github.samanthatovah.stellaris.empiremanager.model.*;
import io.github.samanthatovah.stellaris.empiremanager.repository.*;
import io.github.samanthatovah.stellaris.empiremanager.service.EmpireValidator;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Log4j2
@Controller
public class EmpireController {

    private static final String EMPIRE = "empire";
    private static final String TITLE = "title";
    private static final String EMPIRE_FORM = "empire-form";
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
        empires.sort(Comparator.comparing(Empire::getElo));
        model.addAttribute("empires", empires);
        return "empire-table";
    }

    @GetMapping("/empire/{id}")
    public String showEmpireDetails(@PathVariable("id") Long id, Model model) {
        Optional<Empire> empire = empireRepository.findById(id);
        model.addAttribute(EMPIRE, empire.orElseThrow());
        return "empire-details";
    }

    @GetMapping("/create-empire")
    public String showCreateEmpireForm(Model model) {
        Empire newEmpire = new Empire();
        newEmpire.setHomeworld(new Homeworld());
        newEmpire.setSpecies(new Species());

        model.addAttribute(EMPIRE, newEmpire);
        model.addAttribute(TITLE, "Create New Empire");
        populateEmpireFormModel(model);

        return EMPIRE_FORM;
    }

    @GetMapping("/edit-empire/{id}")
    public String showEditEmpireForm(@PathVariable("id") Long id, Model model) {
        Empire empire = empireRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid empire Id:" + id));

        model.addAttribute(EMPIRE, empire);
        model.addAttribute(TITLE, "Edit " + empire.getName());
        populateEmpireFormModel(model);

        return EMPIRE_FORM;
    }


    @PostMapping("/create-empire")
    public String createOrUpdateEmpire(@ModelAttribute Empire empire, BindingResult result, Model model) {
        empireValidator.validate(empire, result);

        if (result.hasErrors()) {
            log.error(result.getAllErrors());
            populateEmpireFormModel(model);
            return EMPIRE_FORM;
        }

        Long id = empire.getId();
        if (id != null && empireRepository.existsById(id)) {
            Empire oldEmpire = empireRepository.findById(id).orElseThrow();
            log.info("Editing existing empire (id: {}, old name: {})",
                    id, oldEmpire.getName());
            empire.setElo(oldEmpire.getElo());
            empire.setEloComparisons(oldEmpire.getEloComparisons());
        } else {
            log.info("Creating new empire (id: {}, name: {}", id, empire.getName());
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
