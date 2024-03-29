package io.github.samanthatovah.stellaris.empiremanager.domain.civic;

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
public class CivicService {

    private final CivicRepository civicRepository;
    private final EmpireRepository empireRepository;
    private final StatisticFactory statisticFactory;

    public CivicService(CivicRepository civicRepository, EmpireRepository empireRepository,
                        StatisticFactory statisticFactory) {
        this.civicRepository = civicRepository;
        this.empireRepository = empireRepository;
        this.statisticFactory = statisticFactory;
    }

    public List<Statistic> getCountStats() {
        List<Civic> allCivics = civicRepository.findAll();
        List<Statistic> stats = new ArrayList<>();

        for (Civic civic : allCivics) {
            Set<Long> empireIds = getEmpireIds(civic.getName());
            stats.add(statisticFactory.createStatistic(civic.getName(), empireIds));
        }

        Collections.sort(stats);

        return stats;
    }

    private Set<Long> getEmpireIds(String civicName) {
        Civic civic = civicRepository.findByName(civicName);

        return empireRepository.findAll().stream()
                .filter(e -> e.getCivics().contains(civic))
                .map(Empire::getId)
                .collect(Collectors.toSet());
    }
}
