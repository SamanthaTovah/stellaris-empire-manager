package io.github.samanthatovah.stellaris.empiremanager.service;

import io.github.samanthatovah.stellaris.empiremanager.dto.Statistic;
import io.github.samanthatovah.stellaris.empiremanager.repository.HomeworldRepository;
import io.github.samanthatovah.stellaris.empiremanager.repository.OriginRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OriginService {

    private final OriginRepository originRepository;
    private final HomeworldRepository homeworldRepository;

    public OriginService(OriginRepository originRepository, HomeworldRepository homeworldRepository) {
        this.originRepository = originRepository;
        this.homeworldRepository = homeworldRepository;
    }

    public List<Statistic> getCountStats() {

        Map<String, Long> counts = homeworldRepository.findAll().stream()
                .collect(Collectors.groupingBy(homeworld -> homeworld.getOrigin().getName(), Collectors.counting()));

        originRepository.findAll().forEach(origin -> counts.putIfAbsent(origin.getName(), 0L));

        return counts.entrySet().stream()
                .map(entry -> new Statistic(entry.getKey(), entry.getValue()))
                .sorted()
                .toList();
    }
}
