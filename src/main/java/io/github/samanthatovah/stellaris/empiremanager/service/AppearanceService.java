package io.github.samanthatovah.stellaris.empiremanager.service;

import io.github.samanthatovah.stellaris.empiremanager.dto.Statistic;
import io.github.samanthatovah.stellaris.empiremanager.model.Appearance;
import io.github.samanthatovah.stellaris.empiremanager.model.Empire;
import io.github.samanthatovah.stellaris.empiremanager.repository.AppearanceRepository;
import io.github.samanthatovah.stellaris.empiremanager.repository.EmpireRepository;
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

    public AppearanceService(AppearanceRepository appearanceRepository, EmpireRepository empireRepository) {
        this.appearanceRepository = appearanceRepository;
        this.empireRepository = empireRepository;
    }

    public List<Statistic> getCountStats() {
        List<Appearance> allAppearances = appearanceRepository.findAll();
        List<Statistic> stats = new ArrayList<>();

        for (Appearance appearance : allAppearances) {
            Set<Long> empireIds = getEmpireIds(appearance.getName());
            stats.add(new Statistic(appearance.getName(), empireIds));
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
