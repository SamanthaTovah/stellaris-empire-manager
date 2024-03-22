package io.github.samanthatovah.stellaris.empiremanager.domain.appearance;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "appearance")
public class Appearance implements Comparable<Appearance> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Override
    public int compareTo(Appearance appearance) {
        return getName().compareTo(appearance.getName());
    }
}
