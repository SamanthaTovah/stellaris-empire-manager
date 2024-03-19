package io.github.samanthatovah.stellaris.empiremanager.model;

import lombok.Getter;

import java.util.Comparator;

@Getter
public enum Ethic implements Comparable<Ethic> {
    FANATIC_MILITARIST(2),
    MILITARIST(1),
    PACIFIST(1),
    FANATIC_PACIFIST(2),
    FANATIC_AUTHORITARIAN(2),
    AUTHORITARIAN(1),
    EGALITARIAN(1),
    FANATIC_EGALITARIAN(2),
    GESTALT_CONSCIOUSNESS(3),
    FANATIC_XENOPHOBE(2),
    XENOPHOBE(1),
    XENOPHILE(1),
    FANATIC_XENOPHILE(2),
    FANATIC_MATERIALIST(2),
    MATERIALIST(1),
    SPIRITUALIST(1),
    FANATIC_SPIRITUALIST(2),
    ;

    public static final Comparator<Ethic> comparator = (e1, e2) -> {
        if (e1.isFanatic() && !e2.isFanatic()) {
            return -1;
        } else if (!e1.isFanatic() && e2.isFanatic()) {
            return 1;
        }

        return getOrder(e1.getBase()) - getOrder(e2.getBase());
    };

    private final int points;

    Ethic(int points) {
        this.points = points;
    }

    private static int getOrder(String base) {
        return switch (base) {
            case "GESTALT_CONSCIOUSNESS":
                yield 0;
            case "MILITARIST", "PACIFIST":
                yield 1;
            case "AUTHORITARIAN", "EGALITARIAN":
                yield 2;
            case "XENOPHOBE", "XENOPHILE":
                yield 3;
            case "MATERIALIST", "SPIRITUALIST":
                yield 4;
            default:
                throw new IllegalStateException("Unexpected value: " + base);
        };
    }

    public String getBase() {
        if (isFanatic()) {
            return name().split("FANATIC_")[1];
        } else {
            return name();
        }
    }

    private boolean isFanatic() {
        return name().contains("FANATIC");
    }
}
