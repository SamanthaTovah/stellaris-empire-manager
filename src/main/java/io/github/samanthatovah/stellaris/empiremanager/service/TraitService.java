package io.github.samanthatovah.stellaris.empiremanager.service;

import io.github.samanthatovah.stellaris.empiremanager.dto.Statistic;
import io.github.samanthatovah.stellaris.empiremanager.model.Empire;
import io.github.samanthatovah.stellaris.empiremanager.model.Trait;
import io.github.samanthatovah.stellaris.empiremanager.repository.EmpireRepository;
import io.github.samanthatovah.stellaris.empiremanager.repository.TraitRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TraitService {

    private final TraitRepository traitRepository;
    private final EmpireRepository empireRepository;
    private final StatisticFactory statisticFactory;

    public TraitService(TraitRepository traitRepository, EmpireRepository empireRepository,
                        StatisticFactory statisticFactory) {
        this.traitRepository = traitRepository;
        this.empireRepository = empireRepository;
        this.statisticFactory = statisticFactory;
    }

    public List<Statistic> getCountStats() {
        List<Trait> allTraits = traitRepository.findAll();
        List<Statistic> stats = new ArrayList<>();

        for (Trait trait : allTraits) {
            Set<Long> empireIds = getEmpireIds(trait.getName());
            stats.add(statisticFactory.createStatistic(trait.getName(), empireIds));
        }

        Collections.sort(stats);

        return stats;
    }

    private Set<Long> getEmpireIds(String traitName) {
        Trait trait = traitRepository.findByName(traitName);

        return empireRepository.findAll().stream()
                .filter(e -> e.getSpecies().getTraits().contains(trait))
                .map(Empire::getId)
                .collect(Collectors.toSet());
    }
}
