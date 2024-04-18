package io.github.samanthatovah.stellaris.empiremanager.domain.government;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GovernmentRepository extends JpaRepository<Government, Long> {

    @Query(value = """
            SELECT
            g.name AS GovernmentName,
            GROUP_CONCAT(DISTINCT e.id ORDER BY e.id) AS AllEmpireIDs,
            GROUP_CONCAT(DISTINCT CASE
                WHEN e.won_small_galaxy = 1 OR e.won_medium_galaxy = 1 OR e.won_large_galaxy = 1 THEN e.id
                ELSE NULL
            END ORDER BY e.id) AS WinningEmpireIDs,
            COALESCE(AVG(e.elo), 1000) AS AverageEloScore
            FROM government g
            LEFT JOIN empire e ON e.government = g.id
            GROUP BY g.id, g.name
            """, nativeQuery = true)
    List<Object[]> findGovernmentStatistics();
}
