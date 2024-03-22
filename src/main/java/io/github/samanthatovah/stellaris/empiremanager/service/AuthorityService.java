package io.github.samanthatovah.stellaris.empiremanager.service;

import io.github.samanthatovah.stellaris.empiremanager.dto.Statistic;
import io.github.samanthatovah.stellaris.empiremanager.model.Authority;
import io.github.samanthatovah.stellaris.empiremanager.model.Empire;
import io.github.samanthatovah.stellaris.empiremanager.repository.EmpireRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AuthorityService {
    private final EmpireRepository empireRepository;

    public AuthorityService(EmpireRepository empireRepository) {
        this.empireRepository = empireRepository;
    }

    public List<Statistic> getCountStats() {
        List<Authority> allAuthorities = Arrays.stream(Authority.values()).toList();
        List<Statistic> stats = new ArrayList<>();

        for (Authority authority : allAuthorities) {
            Set<Long> empireIds = getEmpireIds(authority);
            stats.add(new Statistic(authority.toString(), empireIds));
        }

        Collections.sort(stats);

        return stats;
    }

    private Set<Long> getEmpireIds(Authority authority) {
        return empireRepository.findAll().stream()
                .filter(e -> e.getAuthority().equals(authority))
                .map(Empire::getId)
                .collect(Collectors.toSet());
    }
}
