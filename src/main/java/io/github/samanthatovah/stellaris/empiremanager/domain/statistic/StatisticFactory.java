package io.github.samanthatovah.stellaris.empiremanager.domain.statistic;

import io.github.samanthatovah.stellaris.empiremanager.domain.empire.EmpireService;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class StatisticFactory {
    private final StatisticService statisticService;
    private final EmpireService empireService;

    public StatisticFactory(StatisticService statisticService, EmpireService empireService) {
        this.statisticService = statisticService;
        this.empireService = empireService;
    }

    public Statistic createStatistic(String name, Set<Long> empireIds) {
        int elo = statisticService.getAverageElo(empireIds);
        int count = empireIds.size();
        long wins = empireService.getWinsFromIds(empireIds);

        return new Statistic(name, count, empireIds, elo, wins);
    }
}
