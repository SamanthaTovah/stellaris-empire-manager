package io.github.samanthatovah.stellaris.empiremanager.domain.statistic;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class StatisticFactory {

    public Statistic createStatistic(String name) {
        return new Statistic(name, Set.of(), Set.of(), 1000);
    }

    public List<Statistic> fromRaw(List<Object[]> rawData) {
        return rawData.stream()
                .map(this::convertToObjectArrayToStatistic)
                .toList();
    }

    private Statistic convertToObjectArrayToStatistic(Object[] result) {
        String name = (String) result[0];
        Set<Long> allEmpireIds = convertCSVToSetLong((String) result[1]);
        Set<Long> winningEmpireIds = convertCSVToSetLong((String) result[2]);
        int averageElo = ((BigDecimal) result[3]).intValue();
        return new Statistic(name, allEmpireIds, winningEmpireIds, averageElo);
    }

    private Set<Long> convertCSVToSetLong(String csv) {
        if (csv == null || csv.isEmpty()) {
            return Set.of();
        }
        return Arrays.stream(csv.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(Long::parseLong)
                .collect(Collectors.toSet());
    }
}
