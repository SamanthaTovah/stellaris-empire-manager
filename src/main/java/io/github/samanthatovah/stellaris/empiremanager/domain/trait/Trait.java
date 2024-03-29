package io.github.samanthatovah.stellaris.empiremanager.domain.trait;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "trait")
public class Trait implements Comparable<Trait> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Override
    public int compareTo(Trait trait) {
        return getName().compareTo(trait.getName());
    }
}
