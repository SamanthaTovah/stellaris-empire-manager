package io.github.samanthatovah.stellaris.empiremanager.domain.appearance;

import io.github.samanthatovah.stellaris.empiremanager.domain.statistic.Statistic;
import io.github.samanthatovah.stellaris.empiremanager.domain.statistic.StatisticFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppearanceService {

    private final AppearanceRepository appearanceRepository;
    private final StatisticFactory statisticFactory;

    public AppearanceService(AppearanceRepository appearanceRepository, StatisticFactory statisticFactory) {
        this.appearanceRepository = appearanceRepository;
        this.statisticFactory = statisticFactory;
    }

    public List<Statistic> getCountStats() {
        return statisticFactory.fromRaw(appearanceRepository.findAppearanceStatistics());
    }
}
