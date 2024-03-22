package io.github.samanthatovah.stellaris.empiremanager.domain.authority;

import io.github.samanthatovah.stellaris.empiremanager.domain.statistic.Statistic;
import io.github.samanthatovah.stellaris.empiremanager.domain.empire.Empire;
import io.github.samanthatovah.stellaris.empiremanager.domain.empire.EmpireRepository;
import io.github.samanthatovah.stellaris.empiremanager.domain.statistic.StatisticFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AuthorityService {
    private final EmpireRepository empireRepository;
    private final StatisticFactory statisticFactory;

    public AuthorityService(EmpireRepository empireRepository, StatisticFactory statisticFactory) {
        this.empireRepository = empireRepository;
        this.statisticFactory = statisticFactory;
    }

    public List<Statistic> getCountStats() {
        List<Authority> allAuthorities = Arrays.stream(Authority.values()).toList();
        List<Statistic> stats = new ArrayList<>();

        for (Authority authority : allAuthorities) {
            Set<Long> empireIds = getEmpireIds(authority);
            stats.add(statisticFactory.createStatistic(authority.toString(), empireIds));
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
