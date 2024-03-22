package io.github.samanthatovah.stellaris.empiremanager.domain.planetclass;

import io.github.samanthatovah.stellaris.empiremanager.domain.statistic.Statistic;
import io.github.samanthatovah.stellaris.empiremanager.domain.empire.Empire;
import io.github.samanthatovah.stellaris.empiremanager.domain.empire.EmpireRepository;
import io.github.samanthatovah.stellaris.empiremanager.domain.statistic.StatisticFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PlanetClassService {

    private final PlanetClassRepository planetClassRepository;
    private final EmpireRepository empireRepository;
    private final StatisticFactory statisticFactory;

    public PlanetClassService(PlanetClassRepository planetClassRepository, EmpireRepository empireRepository,
                              StatisticFactory statisticFactory) {
        this.planetClassRepository = planetClassRepository;
        this.empireRepository = empireRepository;
        this.statisticFactory = statisticFactory;
    }

    public List<Statistic> getCountStats() {
        List<PlanetClass> allPlanetClasss = planetClassRepository.findAll();
        List<Statistic> stats = new ArrayList<>();

        for (PlanetClass planetClass : allPlanetClasss) {
            Set<Long> empireIds = getEmpireIds(planetClass.getName());
            stats.add(statisticFactory.createStatistic(planetClass.getName(), empireIds));
        }

        Collections.sort(stats);

        return stats;
    }

    private Set<Long> getEmpireIds(String planetClassName) {
        PlanetClass planetClass = planetClassRepository.findByName(planetClassName);

        return empireRepository.findAll().stream()
                .filter(e -> e.getHomeworld().getPlanetClass().equals(planetClass))
                .map(Empire::getId)
                .collect(Collectors.toSet());
    }
}
