package io.github.samanthatovah.stellaris.empiremanager.domain.ethic;

import io.github.samanthatovah.stellaris.empiremanager.domain.statistic.Statistic;
import io.github.samanthatovah.stellaris.empiremanager.domain.empire.Empire;
import io.github.samanthatovah.stellaris.empiremanager.domain.empire.EmpireRepository;
import io.github.samanthatovah.stellaris.empiremanager.domain.statistic.StatisticFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EthicService {
    private final EmpireRepository empireRepository;
    private final StatisticFactory statisticFactory;

    public EthicService(EmpireRepository empireRepository, StatisticFactory statisticFactory) {
        this.empireRepository = empireRepository;
        this.statisticFactory = statisticFactory;
    }

    public List<Statistic> getCountStats() {
        List<String> allEthics = Arrays.stream(Ethic.values())
                .map(Ethic::getBase)
                .distinct()
                .toList();
        List<Statistic> stats = new ArrayList<>();

        for (String ethic : allEthics) {
            Set<Long> empireIds = getEmpireIds(ethic);
            stats.add(statisticFactory.createStatistic(ethic, empireIds));
        }

        Collections.sort(stats);

        return stats;
    }

    private Set<Long> getEmpireIds(String ethic) {
        return empireRepository.findAll().stream()
                .filter(e -> e.getEthics().stream()
                        .anyMatch(ee -> ee.getBase().equals(ethic)))
                .map(Empire::getId)
                .collect(Collectors.toSet());
    }
}
