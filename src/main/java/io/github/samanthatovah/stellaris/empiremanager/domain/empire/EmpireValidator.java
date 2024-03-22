package io.github.samanthatovah.stellaris.empiremanager.domain.empire;

import io.github.samanthatovah.stellaris.empiremanager.domain.empire.Empire;
import io.github.samanthatovah.stellaris.empiremanager.domain.ethic.Ethic;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

@Service
public class EmpireValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Empire.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Empire empire = (Empire) target;

        if (empire.getName() == null || empire.getName().isEmpty()) {
            errors.rejectValue("name", "name.empty", "The empire name cannot be empty.");
        }

        if (empire.getSpecies().getName() == null || empire.getSpecies().getName().isEmpty()) {
            errors.rejectValue("species.name", "species_name.empty", "The species name cannot be empty.");
        }

        if (empire.getSpecies().getAppearance() == null) {
            errors.rejectValue("species.appearance", "appearance.empty", "The species appearance name cannot be empty.");
        }

        if (empire.getHomeworld().getHomeworldName() == null || empire.getHomeworld().getHomeworldName().isEmpty()) {
            errors.rejectValue("homeworld.homeworldName", "homeworld_name.empty", "The homeworld name cannot be empty.");
        }

        if (empire.getHomeworld().getPlanetClass() == null) {
            errors.rejectValue("homeworld.planetClass", "planet_class.empty", "The planet class cannot be empty.");
        }

        if (empire.getHomeworld().getOrigin() == null) {
            errors.rejectValue("homeworld.origin", "origin.empty", "The origin cannot be empty.");
        }

        if (empire.getEthics() == null || empire.getEthics().isEmpty()) {
            errors.rejectValue("ethics", "ethics.empty", "The ethics cannot be empty.");
        } else if (!validateEthicsPoints(empire.getEthics())) {
            errors.rejectValue("ethics", "ethics.invalid_sum", "The total amount of ethics points must be 3.");
        }

        if (empire.getAuthority() == null) {
            errors.rejectValue("authority", "authority.empty", "The authority cannot be empty.");
        }

        if (empire.getCivics() == null || empire.getCivics().size() != 2) {
            errors.rejectValue("civics", "civics.invalid_amount", "An empire must have two civics.");
        }
    }

    private boolean validateEthicsPoints(List<Ethic> ethics) {
        int sum = 0;
        for (Ethic ethic : ethics) {
            sum += ethic.getPoints();
        }
        return sum == 3;
    }

}
