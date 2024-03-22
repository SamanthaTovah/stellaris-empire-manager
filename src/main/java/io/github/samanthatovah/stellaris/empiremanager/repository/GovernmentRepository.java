package io.github.samanthatovah.stellaris.empiremanager.repository;

import io.github.samanthatovah.stellaris.empiremanager.model.Government;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GovernmentRepository extends JpaRepository<Government, Long> {

    Government findByName(String governmentName);
}
