package io.github.samanthatovah.stellaris.empiremanager.service;

import io.github.samanthatovah.stellaris.empiremanager.dto.Statistic;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class StatisticFactory {
    private final StatisticService statisticService;

    public StatisticFactory(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    public Statistic createStatistic(String name, Set<Long> empireIds) {
        int elo = statisticService.getAverageElo(empireIds);
        int count = empireIds.size();

        return new Statistic(name, count, empireIds, elo);
    }
}
