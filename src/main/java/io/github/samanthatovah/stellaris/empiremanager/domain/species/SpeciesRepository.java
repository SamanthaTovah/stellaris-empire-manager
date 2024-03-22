package io.github.samanthatovah.stellaris.empiremanager.domain.species;

import io.github.samanthatovah.stellaris.empiremanager.domain.species.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, Long> {

}
