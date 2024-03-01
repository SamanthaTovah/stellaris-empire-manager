package io.github.samanthatovah.stellaris.empiremanager.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Government implements Comparable<Government> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Override
    public int compareTo(Government government) {
        return getName().compareTo(government.getName());
    }
}
