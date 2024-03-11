package io.github.samanthatovah.stellaris.empiremanager.controller;

import io.github.samanthatovah.stellaris.empiremanager.model.Empire;
import io.github.samanthatovah.stellaris.empiremanager.repository.EmpireRepository;
import io.github.samanthatovah.stellaris.empiremanager.service.EloService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

@Controller
public class EloController {

    private final EloService eloService;
    private final EmpireRepository empireRepository;
    private final Comparator<Empire> eloThenRandomComparator = new Comparator<>() {
        private final long seed = new Random().nextLong();

        @Override
        public int compare(Empire e1, Empire e2) {
            int result = e1.getEloComparisons().compareTo(e2.getEloComparisons());
            if (result == 0) {
                long e1Value = new Random(seed * e1.getId() * e1.getElo()).nextLong();
                long e2Value = new Random(seed * e2.getId() * e2.getElo()).nextLong();
                result = Long.compare(e1Value, e2Value);
            }
            return result;
        }
    };

    private long e1;
    private long e2;

    public EloController(EloService eloService, EmpireRepository empireRepository) {
        this.eloService = eloService;
        this.empireRepository = empireRepository;
    }

    @GetMapping("/elo")
    public String showEmpires(Model model) {
        List<Empire> empires = empireRepository.findAll();
        empires.sort(eloThenRandomComparator);
        Empire empire1 = empires.get(0);
        Empire empire2 = empires.get(1);
        model.addAttribute("empires", List.of(empire1, empire2));
        this.e1 = empire1.getId();
        this.e2 = empire2.getId();
        return "elo";
    }

    @PostMapping("/elo")
    public String processEloUpdate(@RequestParam("winnerId") Long winnerId) {
        long loserId;
        if (winnerId == e1) {
            loserId = e2;
        } else if (winnerId == e2) {
            loserId = e1;
        } else {
            throw new RuntimeException();
        }
        eloService.updateElo(winnerId, loserId);
        return "redirect:/elo";
    }
}
