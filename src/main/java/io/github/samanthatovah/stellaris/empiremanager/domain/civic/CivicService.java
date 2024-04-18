package io.github.samanthatovah.stellaris.empiremanager.domain.civic;

import io.github.samanthatovah.stellaris.empiremanager.domain.statistic.Statistic;
import io.github.samanthatovah.stellaris.empiremanager.domain.statistic.StatisticFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CivicService {

    private final CivicRepository civicRepository;
    private final StatisticFactory statisticFactory;

    public CivicService(CivicRepository civicRepository, StatisticFactory statisticFactory) {
        this.civicRepository = civicRepository;
        this.statisticFactory = statisticFactory;
    }

    public List<Statistic> getCountStats() {
        return statisticFactory.fromRaw(civicRepository.findCivicStatistics());
    }
}
