package io.github.samanthatovah.stellaris.empiremanager.service;

import io.github.samanthatovah.stellaris.empiremanager.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.Errors;

import java.util.List;
import java.util.Set;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EmpireValidatorTest {

    @Mock
    private Errors errors;

    @InjectMocks
    private EmpireValidator validator;

    private Empire empire;

    @BeforeEach
    void setUp() {
        empire = new Empire();
        empire.setName("Saathid Directorate");
        empire.setSpecies(new Species());
        empire.getSpecies().setName("Saathid");
        empire.getSpecies().setAppearance(new Appearance());
        empire.getSpecies().getAppearance().setName("Arthropoid");
        empire.setHomeworld(new Homeworld());
        empire.getHomeworld().setHomeworldName("Saathurna");
        empire.getHomeworld().setStarName("Saathar");
        empire.getHomeworld().setPlanetClass(new PlanetClass());
        empire.getHomeworld().getPlanetClass().setName("Shattered Ring World");
        empire.getHomeworld().setOrigin(new Origin());
        empire.getHomeworld().getOrigin().setName("Shattered Ring");
        empire.setEthics(List.of(Ethic.XENOPHOBE, Ethic.MATERIALIST, Ethic.PACIFIST));
        empire.setAuthority(Authority.OLIGARCHIC);
        Civic technocracy = new Civic();
        technocracy.setName("Technocracy");
        Civic inwardPerfection = new Civic();
        inwardPerfection.setName("Inward Perfection");
        empire.setCivics(Set.of(technocracy, inwardPerfection));
    }

    @Test
    void validateWithValidEmpire() {
        validator.validate(empire, errors);
        verify(errors, never()).rejectValue(anyString(), anyString(), anyString());
    }

    @Test
    void validateWithEmptyEmpireName() {
        empire.setName("");
        validator.validate(empire, errors);
        verify(errors).rejectValue(eq("name"), eq("name.empty"), anyString());
    }

    @Test
    void validateWithEmptyAppearance() {
        empire.getSpecies().setAppearance(null);
        validator.validate(empire, errors);
        verify(errors).rejectValue(eq("species.appearance"), eq("appearance.empty"), anyString());
    }

    @Test
    void validateWithEmptyHomeworldName() {
        empire.getHomeworld().setHomeworldName("");
        validator.validate(empire, errors);
        verify(errors).rejectValue(eq("homeworld.homeworldName"), eq("homeworld_name.empty"), anyString());
    }

    @Test
    void validateWithEmptyHPlanetClass() {
        empire.getHomeworld().setPlanetClass(null);
        validator.validate(empire, errors);
        verify(errors).rejectValue(eq("homeworld.planetClass"), eq("planet_class.empty"), anyString());
    }

    @Test
    void validateWithEmptyHomeworldOrigin() {
        empire.getHomeworld().setOrigin(null);
        validator.validate(empire, errors);
        verify(errors).rejectValue(eq("homeworld.origin"), eq("origin.empty"), anyString());
    }

    @Test
    void validateWithEmptyEthics() {
        empire.setEthics(null);
        validator.validate(empire, errors);
        verify(errors).rejectValue(eq("ethics"), eq("ethics.empty"), anyString());
    }

    @Test
    void validateWithInvalidEthicsPoints() {
        // Adjusting ethics to make them invalid
        empire.setEthics(List.of(Ethic.FANATIC_XENOPHILE, Ethic.FANATIC_MILITARIST));
        validator.validate(empire, errors);
        verify(errors).rejectValue(eq("ethics"), eq("ethics.invalid_sum"), anyString());
    }

    @Test
    void validateWithEmptySpeciesName() {
        empire.getSpecies().setName("");
        validator.validate(empire, errors);
        verify(errors).rejectValue(eq("species.name"), eq("species_name.empty"), anyString());
    }

    @Test
    void validateWithEmptyAuthorities() {
        empire.setAuthority(null);
        validator.validate(empire, errors);
        verify(errors).rejectValue(eq("authority"), eq("authority.empty"), anyString());
    }

    @Test
    void validateWithInvalidCivicAmount() {
        empire.setCivics(Set.of(new Civic()));
        validator.validate(empire, errors);
        verify(errors).rejectValue(eq("civics"), eq("civics.invalid_amount"), anyString());
    }

}