package io.github.samanthatovah.stellaris.empiremanager.domain.civic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CivicRepository extends JpaRepository<Civic, Long> {

    @Query(value = """
            SELECT
            c.name AS CivicName,
            GROUP_CONCAT(DISTINCT e.id ORDER BY e.id) AS AllEmpireIDs,
            GROUP_CONCAT(DISTINCT CASE
                WHEN e.won_small_galaxy = 1 OR e.won_medium_galaxy = 1 OR e.won_large_galaxy = 1 THEN e.id
                ELSE NULL
            END ORDER BY e.id) AS WinningEmpireIDs,
            COALESCE(AVG(e.elo), 1000) AS AverageEloScore
            FROM civic c
            LEFT JOIN empire_civic ec ON ec.civic_id = c.id
            LEFT JOIN empire e ON ec.empire_id = e.id
            GROUP BY c.id""", nativeQuery = true)
    List<Object[]> findCivicStatistics();
}
