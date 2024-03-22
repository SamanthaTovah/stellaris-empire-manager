package io.github.samanthatovah.stellaris.empiremanager.domain.statistic;

import lombok.extern.log4j.Log4j2;

import java.util.Set;

@Log4j2
public record Statistic(
        String name,
        int count,
        Set<Long> empireIds,
        int elo
) implements Comparable<Statistic> {

    @Override
    public int compareTo(Statistic statistic) {
        return statistic.count - count; // large to small
    }
}
