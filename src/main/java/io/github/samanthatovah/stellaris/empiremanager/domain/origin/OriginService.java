package io.github.samanthatovah.stellaris.empiremanager.domain.origin;

import io.github.samanthatovah.stellaris.empiremanager.domain.statistic.Statistic;
import io.github.samanthatovah.stellaris.empiremanager.domain.empire.Empire;
import io.github.samanthatovah.stellaris.empiremanager.domain.empire.EmpireRepository;
import io.github.samanthatovah.stellaris.empiremanager.domain.statistic.StatisticFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OriginService {

    private final OriginRepository originRepository;
    private final EmpireRepository empireRepository;
    private final StatisticFactory statisticFactory;

    public OriginService(OriginRepository originRepository, EmpireRepository empireRepository,
                         StatisticFactory statisticFactory) {
        this.originRepository = originRepository;
        this.empireRepository = empireRepository;
        this.statisticFactory = statisticFactory;
    }

    public List<Statistic> getCountStats() {
        List<Origin> allOrigins = originRepository.findAll();
        List<Statistic> stats = new ArrayList<>();

        for (Origin origin : allOrigins) {
            Set<Long> empireIds = getEmpireIds(origin.getName());
            stats.add(statisticFactory.createStatistic(origin.getName(), empireIds));
        }

        Collections.sort(stats);

        return stats;
    }

    private Set<Long> getEmpireIds(String originName) {
        Origin origin = originRepository.findByName(originName);

        return empireRepository.findAll().stream()
                .filter(e -> e.getHomeworld().getOrigin().equals(origin))
                .map(Empire::getId)
                .collect(Collectors.toSet());
    }
}
