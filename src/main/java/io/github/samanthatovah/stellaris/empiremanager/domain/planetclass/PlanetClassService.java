package io.github.samanthatovah.stellaris.empiremanager.domain.planetclass;

import io.github.samanthatovah.stellaris.empiremanager.domain.statistic.Statistic;
import io.github.samanthatovah.stellaris.empiremanager.domain.statistic.StatisticFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetClassService {

    private final PlanetClassRepository planetClassRepository;
    private final StatisticFactory statisticFactory;

    public PlanetClassService(PlanetClassRepository planetClassRepository, StatisticFactory statisticFactory) {
        this.planetClassRepository = planetClassRepository;
        this.statisticFactory = statisticFactory;
    }

    public List<Statistic> getCountStats() {
        return statisticFactory.fromRaw(planetClassRepository.findPlanetClassStatistics());
    }
}
