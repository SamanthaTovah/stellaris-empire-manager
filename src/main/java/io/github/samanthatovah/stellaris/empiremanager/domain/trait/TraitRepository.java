package io.github.samanthatovah.stellaris.empiremanager.domain.trait;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TraitRepository extends JpaRepository<Trait, Long> {

    @Query(value = """
            SELECT
            t.name AS TraitName,
            GROUP_CONCAT(DISTINCT e.id ORDER BY e.id) AS AllEmpireIDs,
            GROUP_CONCAT(DISTINCT CASE
            WHEN e.won_small_galaxy = 1 OR e.won_medium_galaxy = 1 OR e.won_large_galaxy = 1 THEN e.id
            ELSE NULL
            END ORDER BY e.id) AS WinningEmpireIDs,
            COALESCE(AVG(e.elo), 1000) AS AverageEloScore
            FROM trait t
            LEFT JOIN species_trait st ON t.id = st.trait_id
            LEFT JOIN species s ON s.id = st.species_id
            LEFT JOIN empire e ON s.id = e.species
            GROUP BY t.id
            """, nativeQuery = true)
    List<Object[]> findTraitStatistics();
}
