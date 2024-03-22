package io.github.samanthatovah.stellaris.empiremanager.domain.appearance;

import io.github.samanthatovah.stellaris.empiremanager.domain.appearance.Appearance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppearanceRepository extends JpaRepository<Appearance, Long> {

    Appearance findByName(String appearanceName);
}
