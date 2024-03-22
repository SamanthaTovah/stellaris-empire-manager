package io.github.samanthatovah.stellaris.empiremanager.domain.elo;

import io.github.samanthatovah.stellaris.empiremanager.domain.empire.Empire;

import java.util.Comparator;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

public class EloComparator implements Comparator<Empire> {

    private final long seed = new Random().nextLong();
    private final Queue<Long> previousWinnersId;

    public EloComparator(Queue<Long> previousWinnersId) {
        this.previousWinnersId = previousWinnersId;
    }

    @Override
    public int compare(Empire e1, Empire e2) {
        // Prevent picking the previous winner
        if (previousWinnersId.containsAll(Set.of(e1.getId(), e2.getId()))) {
            return 0;
        }
        if (previousWinnersId.contains(e1.getId())) {
            return 1;
        } else if (previousWinnersId.contains(e2.getId())) {
            return -1;
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
