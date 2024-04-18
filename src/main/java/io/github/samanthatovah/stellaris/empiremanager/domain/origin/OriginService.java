package io.github.samanthatovah.stellaris.empiremanager.domain.origin;

import io.github.samanthatovah.stellaris.empiremanager.domain.statistic.Statistic;
import io.github.samanthatovah.stellaris.empiremanager.domain.statistic.StatisticFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OriginService {

    private final OriginRepository originRepository;
    private final StatisticFactory statisticFactory;

    public OriginService(OriginRepository originRepository, StatisticFactory statisticFactory) {
        this.originRepository = originRepository;
        this.statisticFactory = statisticFactory;
    }

    public List<Statistic> getCountStats() {
        return statisticFactory.fromRaw(originRepository.findOriginStatistics());
    }
}
