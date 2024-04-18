package io.github.samanthatovah.stellaris.empiremanager.domain.trait;

import io.github.samanthatovah.stellaris.empiremanager.domain.statistic.Statistic;
import io.github.samanthatovah.stellaris.empiremanager.domain.statistic.StatisticFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraitService {

    private final TraitRepository traitRepository;
    private final StatisticFactory statisticFactory;

    public TraitService(TraitRepository traitRepository, StatisticFactory statisticFactory) {
        this.traitRepository = traitRepository;
        this.statisticFactory = statisticFactory;
    }

    public List<Statistic> getCountStats() {
        return statisticFactory.fromRaw(traitRepository.findTraitStatistics());
    }
}
