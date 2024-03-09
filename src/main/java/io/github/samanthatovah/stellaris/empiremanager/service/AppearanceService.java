package io.github.samanthatovah.stellaris.empiremanager.service;

import io.github.samanthatovah.stellaris.empiremanager.dto.Statistic;
import io.github.samanthatovah.stellaris.empiremanager.repository.AppearanceRepository;
import io.github.samanthatovah.stellaris.empiremanager.repository.SpeciesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AppearanceService {

    private final AppearanceRepository appearanceRepository;
    private final SpeciesRepository speciesRepository;

    public AppearanceService(AppearanceRepository appearanceRepository, SpeciesRepository speciesRepository) {
        this.appearanceRepository = appearanceRepository;
        this.speciesRepository = speciesRepository;
    }

    public List<Statistic> getCountStats() {
        Map<String, Long> counts = speciesRepository.findAll().stream()
                .collect(Collectors.groupingBy(species -> species.getAppearance().getName(), Collectors.counting()));

        appearanceRepository.findAll().forEach(appearance -> counts.putIfAbsent(appearance.getName(), 0L));

        return counts.entrySet().stream()
                .map(entry -> new Statistic(entry.getKey(), entry.getValue()))
                .sorted()
                .toList();
    }
}
