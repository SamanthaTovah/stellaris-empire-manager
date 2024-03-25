package io.github.samanthatovah.stellaris.empiremanager.domain.statistic;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.util.Set;

@Log4j2
@Data
public class Statistic implements Comparable<Statistic> {

    private final String name;
    private final int elo;
    private final Set<Long> empireIds;
    private final Set<Long> empireIdsWon;
    private final int count;
    private final int wins;

    Statistic(String name, int elo, Set<Long> empireIds, Set<Long> empireIdsWon) {
        this.name = name;
        this.elo = elo;
        this.empireIds = empireIds;
        this.empireIdsWon = empireIdsWon;
        this.count = empireIds.size();
        this.wins = empireIdsWon.size();
    }

    @Override
    public int compareTo(Statistic statistic) {
        return statistic.count - count; // large to small
    }
}
