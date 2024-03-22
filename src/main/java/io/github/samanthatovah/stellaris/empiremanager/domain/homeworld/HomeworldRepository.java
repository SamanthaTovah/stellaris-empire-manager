package io.github.samanthatovah.stellaris.empiremanager.domain.homeworld;

import io.github.samanthatovah.stellaris.empiremanager.domain.homeworld.Homeworld;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeworldRepository extends JpaRepository<Homeworld, Long> {

}
