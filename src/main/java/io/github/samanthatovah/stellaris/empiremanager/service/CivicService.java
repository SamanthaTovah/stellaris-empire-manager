package io.github.samanthatovah.stellaris.empiremanager.service;

import io.github.samanthatovah.stellaris.empiremanager.dto.Statistic;
import io.github.samanthatovah.stellaris.empiremanager.model.Civic;
import io.github.samanthatovah.stellaris.empiremanager.repository.CivicRepository;
import io.github.samanthatovah.stellaris.empiremanager.repository.EmpireRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CivicService {

    private final CivicRepository civicRepository;
    private final EmpireRepository empireRepository;

    public CivicService(CivicRepository civicRepository, EmpireRepository empireRepository) {
        this.civicRepository = civicRepository;
        this.empireRepository = empireRepository;
    }

    public List<Statistic> getCountStats() {

        Map<String, Long> counts = empireRepository.findAll().stream()
                .flatMap(empire -> empire.getCivics().stream())
                .map(Civic::getName)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        civicRepository.findAll().forEach(civic -> counts.putIfAbsent(civic.getName(), 0L));

        return counts.entrySet().stream()
                .map(entry -> new Statistic(entry.getKey(), entry.getValue()))
                .sorted()
                .toList();
    }
}
