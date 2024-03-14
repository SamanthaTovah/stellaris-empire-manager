package io.github.samanthatovah.stellaris.empiremanager.util;

import io.github.samanthatovah.stellaris.empiremanager.model.Empire;

import java.util.Comparator;
import java.util.Random;

public class EloComparator implements Comparator<Empire> {

    private final long seed = new Random().nextLong();
    private final Long previousWinnerId;

    public EloComparator(Long previousWinnerId) {
        this.previousWinnerId = previousWinnerId;
    }

    @Override
    public int compare(Empire e1, Empire e2) {
        // Prevent picking the previous winner
        if (previousWinnerId != null) {
            if (e1.getId().equals(previousWinnerId)) {
                return 1;
            } else if (e2.getId().equals(previousWinnerId)) {
                return -1;
            }
        }

        // Pick empires with the lowest amount of Elo comparisons first
        int result = e1.getEloComparisons().compareTo(e2.getEloComparisons());

        // Break ties randomly
        if (result == 0) {
            long e1Value = new Random(seed * e1.getId() * e1.getElo()).nextLong();
            long e2Value = new Random(seed * e2.getId() * e2.getElo()).nextLong();
            result = Long.compare(e1Value, e2Value);
        }

        return result;
    }
}
