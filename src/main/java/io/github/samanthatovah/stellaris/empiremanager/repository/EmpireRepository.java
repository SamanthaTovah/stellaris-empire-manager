package io.github.samanthatovah.stellaris.empiremanager.repository;

import io.github.samanthatovah.stellaris.empiremanager.model.Empire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpireRepository extends JpaRepository<Empire, Long> {

}
