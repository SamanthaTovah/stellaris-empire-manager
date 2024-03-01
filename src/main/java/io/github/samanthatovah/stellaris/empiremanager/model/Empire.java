package io.github.samanthatovah.stellaris.empiremanager.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "empire")
public class Empire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "species", nullable = false)
    private Species species;

    @ManyToOne
    @JoinColumn(name = "homeworld", nullable = false)
    private Homeworld homeworld;

    @ElementCollection(targetClass = Ethic.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "empire_ethics", joinColumns = @JoinColumn(name = "empire"))
    @Column(name = "ethic", nullable = false)
    private Set<Ethic> ethics = new HashSet<>();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Authority authority;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "empire_civic",
            joinColumns = @JoinColumn(name = "empire_id"),
            inverseJoinColumns = @JoinColumn(name = "civic_id")
    )
    private Set<Civic> civics = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "government", nullable = false)
    private Government government;
}
