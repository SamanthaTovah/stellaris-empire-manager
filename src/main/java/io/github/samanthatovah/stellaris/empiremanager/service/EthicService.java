package io.github.samanthatovah.stellaris.empiremanager.service;

import io.github.samanthatovah.stellaris.empiremanager.dto.Statistic;
import io.github.samanthatovah.stellaris.empiremanager.model.Ethic;
import io.github.samanthatovah.stellaris.empiremanager.repository.EmpireRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EthicService {
    private final EmpireRepository empireRepository;

    public EthicService(EmpireRepository empireRepository) {
        this.empireRepository = empireRepository;
    }

    public List<Statistic> getCountStats() {
        Map<String, Long> counts = empireRepository.findAll().stream()
                .flatMap(empire -> empire.getEthics().stream())
                .collect(Collectors.groupingBy(
                        Ethic::getBase,
                        Collectors.summingLong(Ethic::getPoints)
                ));

        Arrays.stream(Ethic.values()).forEach(ethic -> counts.putIfAbsent(ethic.getBase(), 0L));

        return counts.entrySet().stream()
                .map(entry -> new Statistic(entry.getKey(), entry.getValue()))
                .sorted()
                .toList();
    }

}
