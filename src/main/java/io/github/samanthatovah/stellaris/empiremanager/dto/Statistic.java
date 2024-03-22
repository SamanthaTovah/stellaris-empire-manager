package io.github.samanthatovah.stellaris.empiremanager.dto;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.util.Set;

@Log4j2
@Data
public class Statistic implements Comparable<Statistic> {

    public final String name;
    public final int count;
    public final Set<Long> empireIds;

    public Statistic(String name, Set<Long> empireIds) {
        this.name = name;
        this.empireIds = empireIds;
        this.count = empireIds.size();
    }

    @Override
    public int compareTo(Statistic statistic) {
        return statistic.count - count; // large to small
    }
}
