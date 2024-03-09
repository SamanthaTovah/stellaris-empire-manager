package io.github.samanthatovah.stellaris.empiremanager.controller;

import io.github.samanthatovah.stellaris.empiremanager.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatisticsController {

    private final AppearanceService appearanceService;
    private final TraitService traitService;
    private final PlanetClassService planetClassService;
    private final OriginService originService;
    private final EthicService ethicService;
    private final AuthorityService authorityService;
    private final GovernmentService governmentService;
    private final CivicService civicService;

    public StatisticsController(AppearanceService appearanceService, TraitService traitService,
                                PlanetClassService planetClassService, OriginService originService,
                                EthicService ethicService, AuthorityService authorityService,
                                GovernmentService governmentService, CivicService civicService) {
        this.appearanceService = appearanceService;
        this.traitService = traitService;
        this.planetClassService = planetClassService;
        this.originService = originService;
        this.ethicService = ethicService;
        this.authorityService = authorityService;
        this.governmentService = governmentService;
        this.civicService = civicService;
    }

    @GetMapping("/statistics")
    public String showStatistics(Model model) {
        model.addAttribute("appearanceStats", appearanceService.getCountStats());
        model.addAttribute("traitStats", traitService.getCountStats());
        model.addAttribute("planetClassStats", planetClassService.getCountStats());
        model.addAttribute("originStats", originService.getCountStats());
        model.addAttribute("ethicStats", ethicService.getCountStats());
        model.addAttribute("authorityStats", authorityService.getCountStats());
        model.addAttribute("governmentStats", governmentService.getCountStats());
        model.addAttribute("civicStats", civicService.getCountStats());
        return "statistics";
    }

}
