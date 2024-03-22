package io.github.samanthatovah.stellaris.empiremanager.service;

import io.github.samanthatovah.stellaris.empiremanager.dto.Statistic;
import io.github.samanthatovah.stellaris.empiremanager.model.Empire;
import io.github.samanthatovah.stellaris.empiremanager.model.Origin;
import io.github.samanthatovah.stellaris.empiremanager.repository.EmpireRepository;
import io.github.samanthatovah.stellaris.empiremanager.repository.OriginRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OriginService {

    private final OriginRepository originRepository;
    private final EmpireRepository empireRepository;

    public OriginService(OriginRepository originRepository, EmpireRepository empireRepository) {
        this.originRepository = originRepository;
        this.empireRepository = empireRepository;
    }

    public List<Statistic> getCountStats() {
        List<Origin> allOrigins = originRepository.findAll();
        List<Statistic> stats = new ArrayList<>();

        for (Origin origin : allOrigins) {
            Set<Long> empireIds = getEmpireIds(origin.getName());
            stats.add(new Statistic(origin.getName(), empireIds));
        }

        Collections.sort(stats);

        return stats;
    }

    private Set<Long> getEmpireIds(String originName) {
        Origin origin = originRepository.findByName(originName);

        return empireRepository.findAll().stream()
                .filter(e -> e.getHomeworld().getOrigin().equals(origin))
                .map(Empire::getId)
                .collect(Collectors.toSet());
    }
}
