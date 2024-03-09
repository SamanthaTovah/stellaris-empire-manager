package io.github.samanthatovah.stellaris.empiremanager.service;

import io.github.samanthatovah.stellaris.empiremanager.dto.Statistic;
import io.github.samanthatovah.stellaris.empiremanager.repository.HomeworldRepository;
import io.github.samanthatovah.stellaris.empiremanager.repository.PlanetClassRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PlanetClassService {

    private final PlanetClassRepository planetClassRepository;
    private final HomeworldRepository homeworldRepository;

    public PlanetClassService(PlanetClassRepository planetClassRepository, HomeworldRepository homeworldRepository) {
        this.planetClassRepository = planetClassRepository;
        this.homeworldRepository = homeworldRepository;
    }

    public List<Statistic> getCountStats() {

        Map<String, Long> counts = homeworldRepository.findAll().stream()
                .collect(Collectors.groupingBy(homeworld -> homeworld.getPlanetClass().getName(), Collectors.counting()));

        planetClassRepository.findAll().forEach(planetClass -> counts.putIfAbsent(planetClass.getName(), 0L));

        return counts.entrySet().stream()
                .map(entry -> new Statistic(entry.getKey(), entry.getValue()))
                .sorted()
                .toList();
    }
}
