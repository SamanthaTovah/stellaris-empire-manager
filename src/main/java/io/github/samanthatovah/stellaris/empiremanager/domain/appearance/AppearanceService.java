package io.github.samanthatovah.stellaris.empiremanager.domain.appearance;

import io.github.samanthatovah.stellaris.empiremanager.domain.statistic.Statistic;
import io.github.samanthatovah.stellaris.empiremanager.domain.empire.Empire;
import io.github.samanthatovah.stellaris.empiremanager.domain.empire.EmpireRepository;
import io.github.samanthatovah.stellaris.empiremanager.domain.statistic.StatisticFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AppearanceService {

    private final AppearanceRepository appearanceRepository;
    private final EmpireRepository empireRepository;
    private final StatisticFactory statisticFactory;

    public AppearanceService(AppearanceRepository appearanceRepository, EmpireRepository empireRepository,
                             StatisticFactory statisticFactory) {
        this.appearanceRepository = appearanceRepository;
        this.empireRepository = empireRepository;
        this.statisticFactory = statisticFactory;
    }

    public List<Statistic> getCountStats() {
        List<Appearance> allAppearances = appearanceRepository.findAll();
        List<Statistic> stats = new ArrayList<>();

        for (Appearance appearance : allAppearances) {
            Set<Long> empireIds = getEmpireIds(appearance.getName());
            stats.add(statisticFactory.createStatistic(appearance.getName(), empireIds));
        }

        Collections.sort(stats);

        return stats;
    }

    private Set<Long> getEmpireIds(String appearanceName) {
        Appearance appearance = appearanceRepository.findByName(appearanceName);

        return empireRepository.findAll().stream()
                .filter(e -> e.getSpecies().getAppearance().equals(appearance))
                .map(Empire::getId)
                .collect(Collectors.toSet());
    }
}
