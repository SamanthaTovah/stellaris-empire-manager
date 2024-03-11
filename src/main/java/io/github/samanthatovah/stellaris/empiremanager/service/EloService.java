package io.github.samanthatovah.stellaris.empiremanager.service;

import io.github.samanthatovah.stellaris.empiremanager.model.Empire;
import io.github.samanthatovah.stellaris.empiremanager.repository.EmpireRepository;
import org.springframework.stereotype.Service;

@Service
public class EloService {

    private final EmpireRepository empireRepository;

    public EloService(EmpireRepository empireRepository) {
        this.empireRepository = empireRepository;
    }

    public void updateElo(Long winnerId, Long loserId) {
        Empire winner = empireRepository.findById(winnerId).orElseThrow();
        Empire loser = empireRepository.findById(loserId).orElseThrow();

        int RA = winner.getElo();
        int RB = loser.getElo();
        double EA = 1 / (1.0 + Math.pow(10, (RB - RA) / 400.0));

        int K = 32;
        int change = (int) (K * (1 - EA));

        winner.setElo(RA + change);
        loser.setElo(RB - change);
        winner.setEloComparisons(winner.getEloComparisons() + 1);
        loser.setEloComparisons(loser.getEloComparisons() + 1);
        empireRepository.save(winner);
        empireRepository.save(loser);
    }

}
