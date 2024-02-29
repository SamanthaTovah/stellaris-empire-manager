package io.github.samanthatovah.stellaris.empiremanager.controller;

import io.github.samanthatovah.stellaris.empiremanager.model.Empire;
import io.github.samanthatovah.stellaris.empiremanager.model.Origin;
import io.github.samanthatovah.stellaris.empiremanager.repository.EmpireRepository;
import io.github.samanthatovah.stellaris.empiremanager.repository.OriginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmpireController {

    @Autowired
    private EmpireRepository empireRepository;

    @Autowired
    private OriginRepository originRepository;

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
}
