package io.github.samanthatovah.stellaris.empiremanager.domain.ethic;

import io.github.samanthatovah.stellaris.empiremanager.domain.empire.EmpireRepository;
import io.github.samanthatovah.stellaris.empiremanager.domain.statistic.Statistic;
import io.github.samanthatovah.stellaris.empiremanager.domain.statistic.StatisticFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
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
        List<Object[]> rawData = empireRepository.findEthicStatistics();
        List<Statistic> statistics = new ArrayList<>(statisticFactory.fromRaw(rawData));

        Set<String> existingEthics = statistics.stream()
                .map(Statistic::getName)
                .collect(Collectors.toSet());

        EnumSet.allOf(Ethic.class).forEach(ethic -> {
            String ethicName = ethic.name();
            if (ethicName.startsWith("FANATIC_")) {
                return;
            }

            if (!existingEthics.contains(ethicName)) {
                statistics.add(statisticFactory.createStatistic(ethicName));
            }
        });

        return statistics;
    }
}
