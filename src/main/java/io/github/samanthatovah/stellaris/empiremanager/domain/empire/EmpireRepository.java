package io.github.samanthatovah.stellaris.empiremanager.domain.empire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpireRepository extends JpaRepository<Empire, Long> {

    @Query(value = """
            SELECT
            e.authority AS AuthorityName,
            GROUP_CONCAT(DISTINCT e.id ORDER BY e.id) AS AllEmpireIDs,
            GROUP_CONCAT(DISTINCT CASE
                WHEN e.won_small_galaxy = 1 OR e.won_medium_galaxy = 1 OR e.won_large_galaxy = 1 THEN e.id
                ELSE NULL
            END ORDER BY e.id) AS WinningEmpireIDs,
            COALESCE(AVG(e.elo), 1000) AS AverageEloScore
            FROM empire e
            GROUP BY e.authority
            """, nativeQuery = true)
    List<Object[]> findAuthorityStatistics();

    @Query(value = """
            SELECT
                CASE
                    WHEN e.ethic LIKE 'FANATIC_%' THEN SUBSTRING(e.ethic, 9)
                    ELSE e.ethic
                END AS EthicName,
                GROUP_CONCAT(DISTINCT e1.id ORDER BY e1.id) AS AllEmpireIDs,
                GROUP_CONCAT(DISTINCT CASE
                    WHEN e1.won_small_galaxy = 1 OR e1.won_medium_galaxy = 1 OR e1.won_large_galaxy = 1 THEN e1.id
                    ELSE NULL
                END ORDER BY e1.id) AS WinningEmpireIDs,
                COALESCE(AVG(e1.elo), 1000) AS AverageEloScore
            FROM
                empire_ethics e
            JOIN
                empire e1 ON e1.id = e.empire
            GROUP BY
                EthicName
            """, nativeQuery = true)
    List<Object[]> findEthicStatistics();
}
