package io.github.samanthatovah.stellaris.empiremanager.service;

import io.github.samanthatovah.stellaris.empiremanager.dto.Statistic;
import io.github.samanthatovah.stellaris.empiremanager.model.Empire;
import io.github.samanthatovah.stellaris.empiremanager.model.PlanetClass;
import io.github.samanthatovah.stellaris.empiremanager.repository.EmpireRepository;
import io.github.samanthatovah.stellaris.empiremanager.repository.PlanetClassRepository;
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

    public PlanetClassService(PlanetClassRepository planetClassRepository, EmpireRepository empireRepository) {
        this.planetClassRepository = planetClassRepository;
        this.empireRepository = empireRepository;
    }

    public List<Statistic> getCountStats() {
        List<PlanetClass> allPlanetClasss = planetClassRepository.findAll();
        List<Statistic> stats = new ArrayList<>();

        for (PlanetClass planetClass : allPlanetClasss) {
            Set<Long> empireIds = getEmpireIds(planetClass.getName());
            stats.add(new Statistic(planetClass.getName(), empireIds));
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
