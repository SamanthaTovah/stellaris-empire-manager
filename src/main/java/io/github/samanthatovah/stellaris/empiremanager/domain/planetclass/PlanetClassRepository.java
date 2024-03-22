package io.github.samanthatovah.stellaris.empiremanager.domain.planetclass;

import io.github.samanthatovah.stellaris.empiremanager.domain.planetclass.PlanetClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetClassRepository extends JpaRepository<PlanetClass, Long> {

    PlanetClass findByName(String planetClassName);
}
