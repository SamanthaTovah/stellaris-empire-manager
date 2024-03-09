package io.github.samanthatovah.stellaris.empiremanager.dto;

public record Statistic(
        String name,
        Long count
) implements Comparable<Statistic> {

    @Override
    public int compareTo(Statistic statistic) {
        return statistic.count.compareTo(count); // large to small
    }
}
