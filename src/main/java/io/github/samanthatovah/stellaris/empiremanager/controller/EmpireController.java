package io.github.samanthatovah.stellaris.empiremanager.controller;

import io.github.samanthatovah.stellaris.empiremanager.model.Empire;
import io.github.samanthatovah.stellaris.empiremanager.repository.EmpireRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EmpireController {

    private final EmpireRepository empireRepository;

    public EmpireController(EmpireRepository empireRepository) {
        this.empireRepository = empireRepository;
    }

    @GetMapping("/empires")
    public String showEmpireTable(Model model) {
        List<Empire> empires = empireRepository.findAll();
        model.addAttribute("empires", empires);
        return "empire-table";
    }
}
