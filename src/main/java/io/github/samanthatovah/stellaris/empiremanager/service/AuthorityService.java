package io.github.samanthatovah.stellaris.empiremanager.service;

import io.github.samanthatovah.stellaris.empiremanager.dto.Statistic;
import io.github.samanthatovah.stellaris.empiremanager.model.Authority;
import io.github.samanthatovah.stellaris.empiremanager.repository.EmpireRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AuthorityService {
    private final EmpireRepository empireRepository;

    public AuthorityService(EmpireRepository empireRepository) {
        this.empireRepository = empireRepository;
    }

    public List<Statistic> getCountStats() {
        Map<String, Long> counts = empireRepository.findAll().stream()
                .collect(Collectors.groupingBy(empire -> empire.getAuthority().name(), Collectors.counting()));

        Arrays.stream(Authority.values()).forEach(authority -> counts.putIfAbsent(authority.name(), 0L));

        return counts.entrySet().stream()
                .map(entry -> new Statistic(entry.getKey(), entry.getValue()))
                .sorted()
                .toList();
    }
}
