package io.github.samanthatovah.stellaris.empiremanager.controller;

import io.github.samanthatovah.stellaris.empiremanager.model.Empire;
import io.github.samanthatovah.stellaris.empiremanager.model.Origin;
import io.github.samanthatovah.stellaris.empiremanager.repository.EmpireRepository;
import io.github.samanthatovah.stellaris.empiremanager.repository.OriginRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmpireController {

    private final EmpireRepository empireRepository;

    private final OriginRepository originRepository;

    public EmpireController(EmpireRepository empireRepository, OriginRepository originRepository) {
        this.empireRepository = empireRepository;
        this.originRepository = originRepository;
    }

    @GetMapping("/empires")
    public String showEmpireTable(Model model) {
        List<Empire> empires = empireRepository.findAll();
        model.addAttribute("empires", empires);
        return "empire-table";
    }

    @GetMapping("/create-empire")
    public String showCreateEmpireForm(Model model) {
        List<Origin> origins = originRepository.findAll();
        model.addAttribute("empire", new Empire());
        model.addAttribute("origins", origins);
        return "empire-form";
    }

    @PostMapping("/create-empire")
    public String createEmpire(@ModelAttribute Empire empire) {
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
