package io.github.samanthatovah.stellaris.empiremanager.repository;

import io.github.samanthatovah.stellaris.empiremanager.model.Trait;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraitRepository extends JpaRepository<Trait, Long> {

}
