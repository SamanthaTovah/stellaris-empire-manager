package io.github.samanthatovah.stellaris.empiremanager.domain.empire;

import io.github.samanthatovah.stellaris.empiremanager.domain.empire.Empire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpireRepository extends JpaRepository<Empire, Long> {

}
