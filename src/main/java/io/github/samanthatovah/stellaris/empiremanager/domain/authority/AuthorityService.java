package io.github.samanthatovah.stellaris.empiremanager.domain.authority;

import io.github.samanthatovah.stellaris.empiremanager.domain.empire.EmpireRepository;
import io.github.samanthatovah.stellaris.empiremanager.domain.statistic.Statistic;
import io.github.samanthatovah.stellaris.empiremanager.domain.statistic.StatisticFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
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
        List<Object[]> rawData = empireRepository.findAuthorityStatistics();
        List<Statistic> statistics = new ArrayList<>(statisticFactory.fromRaw(rawData));

        Set<String> existingAuthorities = statistics.stream()
                .map(Statistic::getName)
                .collect(Collectors.toSet());

        EnumSet.allOf(Authority.class).forEach(authority -> {
            if (!existingAuthorities.contains(authority.name())) {
                statistics.add(statisticFactory.createStatistic(authority.name()));
            }
        });

        return statistics;
    }
}
