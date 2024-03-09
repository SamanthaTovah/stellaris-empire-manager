package io.github.samanthatovah.stellaris.empiremanager.service;

import io.github.samanthatovah.stellaris.empiremanager.dto.Statistic;
import io.github.samanthatovah.stellaris.empiremanager.repository.EmpireRepository;
import io.github.samanthatovah.stellaris.empiremanager.repository.GovernmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GovernmentService {

    private final GovernmentRepository governmentRepository;
    private final EmpireRepository empireRepository;

    public GovernmentService(GovernmentRepository governmentRepository, EmpireRepository empireRepository) {
        this.governmentRepository = governmentRepository;
        this.empireRepository = empireRepository;
    }

    public List<Statistic> getCountStats() {

        Map<String, Long> counts = empireRepository.findAll().stream()
                .collect(Collectors.groupingBy(empire -> empire.getGovernment().getName(), Collectors.counting()));

        governmentRepository.findAll().forEach(government -> counts.putIfAbsent(government.getName(), 0L));

        return counts.entrySet().stream()
                .map(entry -> new Statistic(entry.getKey(), entry.getValue()))
                .sorted()
                .toList();
    }
}
