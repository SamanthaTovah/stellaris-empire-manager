package io.github.samanthatovah.stellaris.empiremanager.domain.trait;

import io.github.samanthatovah.stellaris.empiremanager.domain.trait.Trait;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraitRepository extends JpaRepository<Trait, Long> {

    Trait findByName(String traitName);
}
