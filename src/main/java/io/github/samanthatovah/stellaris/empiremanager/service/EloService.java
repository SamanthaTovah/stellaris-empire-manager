package io.github.samanthatovah.stellaris.empiremanager.service;

import io.github.samanthatovah.stellaris.empiremanager.model.Empire;
import io.github.samanthatovah.stellaris.empiremanager.repository.EmpireRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class EloService {

    private final EmpireRepository empireRepository;

    public EloService(EmpireRepository empireRepository) {
        this.empireRepository = empireRepository;
    }

    public void updateElo(Long winnerId, Long loserId) {
        Empire winner = empireRepository.findById(winnerId).orElseThrow();
        Empire loser = empireRepository.findById(loserId).orElseThrow();
        int winnerOldElo = winner.getElo();
        int loserOldElo = loser.getElo();

        int RA = winner.getElo();
        int RB = loser.getElo();
        double EA = 1 / (1.0 + Math.pow(10, (RB - RA) / 400.0));

        int K = 32;
        int change = (int) (K * (1 - EA));

        winner.setElo(RA + change);
        loser.setElo(RB - change);
        winner.setEloComparisons(winner.getEloComparisons() + 1);
        loser.setEloComparisons(loser.getEloComparisons() + 1);

        log.info("{}: {} -> {} (+{})", winner.getName(), winnerOldElo, winner.getElo(), change);
        log.info("{}: {} -> {} (-{})", loser.getName(), loserOldElo, loser.getElo(), change);

        empireRepository.save(winner);
        empireRepository.save(loser);
    }

}
