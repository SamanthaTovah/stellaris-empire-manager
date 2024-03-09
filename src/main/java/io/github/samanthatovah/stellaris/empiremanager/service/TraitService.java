package io.github.samanthatovah.stellaris.empiremanager.service;

import io.github.samanthatovah.stellaris.empiremanager.dto.Statistic;
import io.github.samanthatovah.stellaris.empiremanager.model.Trait;
import io.github.samanthatovah.stellaris.empiremanager.repository.SpeciesRepository;
import io.github.samanthatovah.stellaris.empiremanager.repository.TraitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class TraitService {

    private final TraitRepository traitRepository;
    private final SpeciesRepository speciesRepository;

    public TraitService(TraitRepository traitRepository, SpeciesRepository speciesRepository) {
        this.traitRepository = traitRepository;
        this.speciesRepository = speciesRepository;
    }

    public List<Statistic> getCountStats() {

        Map<String, Long> counts = speciesRepository.findAll().stream()
                .flatMap(species -> species.getTraits().stream())
                .map(Trait::getName)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        traitRepository.findAll().forEach(appearance -> counts.putIfAbsent(appearance.getName(), 0L));

        return counts.entrySet().stream()
                .map(entry -> new Statistic(entry.getKey(), entry.getValue()))
                .sorted()
                .toList();
    }
}
