package io.github.samanthatovah.stellaris.empiremanager.domain.government;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "government")
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
