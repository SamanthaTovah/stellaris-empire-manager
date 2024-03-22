package io.github.samanthatovah.stellaris.empiremanager.service;

import io.github.samanthatovah.stellaris.empiremanager.dto.Statistic;
import io.github.samanthatovah.stellaris.empiremanager.model.Empire;
import io.github.samanthatovah.stellaris.empiremanager.model.Government;
import io.github.samanthatovah.stellaris.empiremanager.repository.EmpireRepository;
import io.github.samanthatovah.stellaris.empiremanager.repository.GovernmentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GovernmentService {

    private final GovernmentRepository governmentRepository;
    private final EmpireRepository empireRepository;
    private final StatisticFactory statisticFactory;

    public GovernmentService(GovernmentRepository governmentRepository, EmpireRepository empireRepository,
                             StatisticFactory statisticFactory) {
        this.governmentRepository = governmentRepository;
        this.empireRepository = empireRepository;
        this.statisticFactory = statisticFactory;
    }

    public List<Statistic> getCountStats() {
        List<Government> allGovernments = governmentRepository.findAll();
        List<Statistic> stats = new ArrayList<>();

        for (Government government : allGovernments) {
            Set<Long> empireIds = getEmpireIds(government.getName());
            stats.add(statisticFactory.createStatistic(government.getName(), empireIds));
        }

        Collections.sort(stats);

        return stats;
    }

    private Set<Long> getEmpireIds(String governmentName) {
        Government government = governmentRepository.findByName(governmentName);

        return empireRepository.findAll().stream()
                .filter(e -> e.getGovernment().equals(government))
                .map(Empire::getId)
                .collect(Collectors.toSet());
    }
}
