package io.github.samanthatovah.stellaris.empiremanager.domain.statistic;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.util.Set;

@Log4j2
@Data
public class Statistic implements Comparable<Statistic> {

    private final String name;
    private final int count;
    private final Set<Long> empireIds;
    private final int elo;

    Statistic(String name, int count, Set<Long> empireIds, int elo) {
        this.name = name;
        this.count = count;
        this.empireIds = empireIds;
        this.elo = elo;
    }

    @Override
    public int compareTo(Statistic statistic) {
        return statistic.count - count; // large to small
    }
}
