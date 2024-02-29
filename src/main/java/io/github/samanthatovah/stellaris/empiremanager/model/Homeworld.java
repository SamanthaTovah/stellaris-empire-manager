package io.github.samanthatovah.stellaris.empiremanager.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Homeworld {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String homeworldName;

    @Column(nullable = false)
    private String starName;

    @ManyToOne
    @JoinColumn(name = "planet_class", nullable = false)
    private PlanetClass planetClass;

    @ManyToOne
    @JoinColumn(name = "origin", nullable = false)
    private Origin origin;
}