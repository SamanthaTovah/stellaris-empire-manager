package io.github.samanthatovah.stellaris.empiremanager.domain.planetclass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanetClassRepository extends JpaRepository<PlanetClass, Long> {

    @Query(value = """
            SELECT
            p.name AS PlanetClassName,
            GROUP_CONCAT(DISTINCT e1.id ORDER BY e1.id) AS AllEmpireIDs,
            GROUP_CONCAT(DISTINCT CASE
                WHEN e2.won_small_galaxy = 1 OR e2.won_medium_galaxy = 1 OR e2.won_large_galaxy = 1 THEN e2.id
                ELSE NULL
            END ORDER BY e2.id) AS WinningEmpireIDs,
            COALESCE(AVG(e1.elo), 1000) AS AverageEloScore
            FROM planet_class p
            LEFT JOIN homeworld h ON h.planet_class = p.id
            LEFT JOIN empire e1 ON e1.homeworld = h.id
            LEFT JOIN empire e2 ON e2.homeworld = h.id AND (e2.won_small_galaxy = 1 OR e2.won_medium_galaxy = 1 OR e2.won_large_galaxy = 1)
            GROUP BY p.id
            """, nativeQuery = true)
    List<Object[]> findPlanetClassStatistics();
}
