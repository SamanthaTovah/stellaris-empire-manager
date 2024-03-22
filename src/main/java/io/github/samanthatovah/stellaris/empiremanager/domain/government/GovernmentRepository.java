package io.github.samanthatovah.stellaris.empiremanager.domain.government;

import io.github.samanthatovah.stellaris.empiremanager.domain.government.Government;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GovernmentRepository extends JpaRepository<Government, Long> {

    Government findByName(String governmentName);
}
