package io.github.samanthatovah.stellaris.empiremanager.domain.statistic;

import io.github.samanthatovah.stellaris.empiremanager.common.ApplicationController;
import io.github.samanthatovah.stellaris.empiremanager.domain.appearance.AppearanceService;
import io.github.samanthatovah.stellaris.empiremanager.domain.authority.AuthorityService;
import io.github.samanthatovah.stellaris.empiremanager.domain.civic.CivicService;
import io.github.samanthatovah.stellaris.empiremanager.domain.ethic.EthicService;
import io.github.samanthatovah.stellaris.empiremanager.domain.government.GovernmentService;
import io.github.samanthatovah.stellaris.empiremanager.domain.origin.OriginService;
import io.github.samanthatovah.stellaris.empiremanager.domain.planetclass.PlanetClassService;
import io.github.samanthatovah.stellaris.empiremanager.domain.trait.TraitService;
import io.github.samanthatovah.stellaris.empiremanager.infrastructure.monitoring.QueryCounterAspect;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@Controller
public class StatisticController extends ApplicationController {

    private final QueryCounterAspect queryCounterAspect;
    private final AppearanceService appearanceService;
    private final TraitService traitService;
    private final PlanetClassService planetClassService;
    private final OriginService originService;
    private final EthicService ethicService;
    private final AuthorityService authorityService;
    private final GovernmentService governmentService;
    private final CivicService civicService;

    public StatisticController(QueryCounterAspect queryCounterAspect, AppearanceService appearanceService,
                               TraitService traitService, PlanetClassService planetClassService,
                               OriginService originService, EthicService ethicService,
                               AuthorityService authorityService, GovernmentService governmentService,
                               CivicService civicService) {
        this.queryCounterAspect = queryCounterAspect;
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
        queryCounterAspect.resetCount();
        model.addAttribute("appearanceStats", appearanceService.getCountStats());
        model.addAttribute("traitStats", traitService.getCountStats());
        model.addAttribute("planetClassStats", planetClassService.getCountStats());
        model.addAttribute("originStats", originService.getCountStats());
        model.addAttribute("ethicStats", ethicService.getCountStats());
        model.addAttribute("authorityStats", authorityService.getCountStats());
        model.addAttribute("governmentStats", governmentService.getCountStats());
        model.addAttribute("civicStats", civicService.getCountStats());
        model.addAttribute(CONTENT, "fragment/statistics");
        addGitInfo(model);
        log.debug("/statistics call took {} SQL queries.", queryCounterAspect.getQueryCount());

        return MAIN_LAYOUT;
    }

}
