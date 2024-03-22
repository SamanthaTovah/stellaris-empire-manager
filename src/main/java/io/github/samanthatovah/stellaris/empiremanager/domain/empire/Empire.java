package io.github.samanthatovah.stellaris.empiremanager.domain.empire;

import io.github.samanthatovah.stellaris.empiremanager.domain.authority.Authority;
import io.github.samanthatovah.stellaris.empiremanager.domain.civic.Civic;
import io.github.samanthatovah.stellaris.empiremanager.domain.ethic.Ethic;
import io.github.samanthatovah.stellaris.empiremanager.domain.government.Government;
import io.github.samanthatovah.stellaris.empiremanager.domain.homeworld.Homeworld;
import io.github.samanthatovah.stellaris.empiremanager.domain.species.Species;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "empire")
public class Empire {

    transient String winClass;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "species", nullable = false)
    private Species species;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "homeworld", nullable = false)
    private Homeworld homeworld;

    @ElementCollection(targetClass = Ethic.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "empire_ethics", joinColumns = @JoinColumn(name = "empire"))
    @Column(name = "ethic", nullable = false)
    private List<Ethic> ethics = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Authority authority;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "empire_civic",
            joinColumns = @JoinColumn(name = "empire_id"),
            inverseJoinColumns = @JoinColumn(name = "civic_id")
    )
    private Set<Civic> civics = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "government", nullable = false)
    private Government government;

    @Column(nullable = false)
    private Integer elo = 1000;

    @Column(name = "elo_comparisons", nullable = false)
    private Integer eloComparisons = 0;

    @Column(name = "won_small_galaxy", nullable = false)
    private Boolean wonSmallGalaxy = false;

    @Column(name = "won_medium_galaxy", nullable = false)
    private Boolean wonMediumGalaxy = false;

    @Column(name = "won_large_galaxy", nullable = false)
    private Boolean wonLargeGalaxy = false;
}
