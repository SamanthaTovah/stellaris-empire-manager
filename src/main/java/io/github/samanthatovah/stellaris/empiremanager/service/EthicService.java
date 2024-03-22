package io.github.samanthatovah.stellaris.empiremanager.service;

import io.github.samanthatovah.stellaris.empiremanager.dto.Statistic;
import io.github.samanthatovah.stellaris.empiremanager.model.Empire;
import io.github.samanthatovah.stellaris.empiremanager.model.Ethic;
import io.github.samanthatovah.stellaris.empiremanager.repository.EmpireRepository;
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
