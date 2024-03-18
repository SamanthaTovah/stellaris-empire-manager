package io.github.samanthatovah.stellaris.empiremanager.controller;

import io.github.samanthatovah.stellaris.empiremanager.model.Empire;
import io.github.samanthatovah.stellaris.empiremanager.repository.EmpireRepository;
import io.github.samanthatovah.stellaris.empiremanager.service.EloService;
import io.github.samanthatovah.stellaris.empiremanager.util.EloComparator;
import lombok.extern.log4j.Log4j2;
import org.hibernate.FetchNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

@Log4j2
@Controller
public class EloController extends ApplicationController {

    private final EloService eloService;
    private final EmpireRepository empireRepository;
    private final Queue<Long> previousWinnersId = new ArrayDeque<>();
    private Long pickedEloEmpireId1 = null;
    private Long pickedEloEmpireId2 = null;

    public EloController(EloService eloService, EmpireRepository empireRepository) {
        this.eloService = eloService;
        this.empireRepository = empireRepository;
    }

    @GetMapping("/elo")
    public String showEmpires(Model model) {
        List<Empire> empires = empireRepository.findAll();
        empires.sort(new EloComparator(previousWinnersId));
        Empire empire1 = empires.get(0);
        Empire empire2 = empires.get(1);
        for (int i = 0; i < 5 && i < empires.size(); i++) {
            Empire empire = empires.get(i);
            log.debug("{}:\t{}\t{}", empire.getEloComparisons(), empire.getElo(), empire.getName());
        }
        log.info("Matching {} ({} elo, {} comps) vs {} ({} elo, {} comps)",
                empire1.getName(), empire1.getElo(), empire1.getEloComparisons(),
                empire2.getName(), empire2.getElo(), empire2.getEloComparisons());
        this.pickedEloEmpireId1 = empire1.getId();
        this.pickedEloEmpireId2 = empire2.getId();

        model.addAttribute("empire1", empire1);
        model.addAttribute("empire2", empire2);
        model.addAttribute(CONTENT, "fragment/elo");
        addGitInfo(model);

        return MAIN_LAYOUT;
    }

    @PostMapping("/elo")
    public String processEloUpdate(@RequestParam("winnerId") Long winnerId) {
        long loserId;
        if (Objects.equals(winnerId, pickedEloEmpireId1)) {
            loserId = pickedEloEmpireId2;
        } else if (Objects.equals(winnerId, pickedEloEmpireId2)) {
            loserId = pickedEloEmpireId1;
        } else {
            throw new FetchNotFoundException("Unknown", winnerId);
        }
        eloService.updateElo(winnerId, loserId);
        if (previousWinnersId.size() >= 5) {
            previousWinnersId.remove();
        }
        previousWinnersId.add(winnerId);
        log.info("Previous winners not eligible for picking: {}",
                previousWinnersId.stream()
                        .map(id -> empireRepository.findById(id).orElseThrow().getName())
                        .toList());

        return "redirect:/elo";
    }
}
