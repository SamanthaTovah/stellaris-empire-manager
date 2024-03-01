package io.github.samanthatovah.stellaris.empiremanager.repository;

import io.github.samanthatovah.stellaris.empiremanager.model.Civic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CivicRepository extends JpaRepository<Civic, Long> {

}
