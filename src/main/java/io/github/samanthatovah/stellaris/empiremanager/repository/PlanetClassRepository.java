package io.github.samanthatovah.stellaris.empiremanager.repository;

import io.github.samanthatovah.stellaris.empiremanager.model.PlanetClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetClassRepository extends JpaRepository<PlanetClass, Long> {

    PlanetClass findByName(String planetClassName);
}
