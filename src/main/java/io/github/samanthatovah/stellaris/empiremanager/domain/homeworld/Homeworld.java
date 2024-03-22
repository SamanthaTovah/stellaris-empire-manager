package io.github.samanthatovah.stellaris.empiremanager.domain.homeworld;

import io.github.samanthatovah.stellaris.empiremanager.domain.origin.Origin;
import io.github.samanthatovah.stellaris.empiremanager.domain.planetclass.PlanetClass;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "homeworld")
public class Homeworld {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "homeworld_name", nullable = false)
    private String homeworldName;

    @Column(name = "star_name") // allowed to be null because not visible in Empire overview screen
    private String starName;

    @ManyToOne
    @JoinColumn(name = "planet_class", nullable = false)
    private PlanetClass planetClass;

    @ManyToOne
    @JoinColumn(name = "origin", nullable = false)
    private Origin origin;
}
