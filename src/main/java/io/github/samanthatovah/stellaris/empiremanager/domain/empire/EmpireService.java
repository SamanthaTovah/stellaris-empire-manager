package io.github.samanthatovah.stellaris.empiremanager.domain.empire;

import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmpireService {

    private final EmpireRepository empireRepository;

    public EmpireService(EmpireRepository empireRepository) {
        this.empireRepository = empireRepository;
    }

    public Set<Long> getIdsWonFromIds(Set<Long> empireIds) {
        return empireIds.stream()
                .map(id -> empireRepository.findById(id).orElseThrow())
                .filter(e -> e.getWonSmallGalaxy() || e.getWonMediumGalaxy() || e.getWonLargeGalaxy())
                .map(Empire::getId)
                .collect(Collectors.toSet());
    }
}
