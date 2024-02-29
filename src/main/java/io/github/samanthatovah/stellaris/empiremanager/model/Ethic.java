package io.github.samanthatovah.stellaris.empiremanager.model;

public enum Ethic {
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

    public final int points;

    Ethic(int points) {
        this.points = points;
    }
}
