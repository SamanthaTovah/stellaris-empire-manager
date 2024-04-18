package io.github.samanthatovah.stellaris.empiremanager.domain.government;

import io.github.samanthatovah.stellaris.empiremanager.domain.statistic.Statistic;
import io.github.samanthatovah.stellaris.empiremanager.domain.statistic.StatisticFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GovernmentService {

    private final GovernmentRepository governmentRepository;
    private final StatisticFactory statisticFactory;

    public GovernmentService(GovernmentRepository governmentRepository, StatisticFactory statisticFactory) {
        this.governmentRepository = governmentRepository;
        this.statisticFactory = statisticFactory;
    }

    public List<Statistic> getCountStats() {
        return statisticFactory.fromRaw(governmentRepository.findGovernmentStatistics());
    }
}
