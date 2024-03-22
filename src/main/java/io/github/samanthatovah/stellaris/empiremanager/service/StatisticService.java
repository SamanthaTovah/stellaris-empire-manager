package io.github.samanthatovah.stellaris.empiremanager.service;

import io.github.samanthatovah.stellaris.empiremanager.repository.EmpireRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StatisticService {

    private final EmpireRepository empireRepository;

    public StatisticService(EmpireRepository empireRepository) {
        this.empireRepository = empireRepository;
    }

    public int getAverageElo(Collection<Long> empireIds) {
        return (int) empireIds.stream()
                .mapToInt(id -> empireRepository.findById(id).orElseThrow().getElo())
                .average()
                .orElse(1000);
    }
}
