package io.github.samanthatovah.stellaris.empiremanager.domain.civic;

import io.github.samanthatovah.stellaris.empiremanager.domain.civic.Civic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CivicRepository extends JpaRepository<Civic, Long> {

    Civic findByName(String civicName);
}
