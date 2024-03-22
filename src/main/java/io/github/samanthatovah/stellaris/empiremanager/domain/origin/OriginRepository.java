package io.github.samanthatovah.stellaris.empiremanager.domain.origin;

import io.github.samanthatovah.stellaris.empiremanager.domain.origin.Origin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OriginRepository extends JpaRepository<Origin, Long> {

    Origin findByName(String originName);
}
