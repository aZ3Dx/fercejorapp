package lat.fercejor.fercejorapp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Set;

import javax.validation.Validator;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;

import lat.fercejor.fercejorapp.repository.CargoRepository;

@SpringBootTest
@ActiveProfiles("tst")
public class CargoTest {

    @Autowired
    private CargoRepository cargoRepository;

    @Test
    public void testValidacionDatos() {
        Cargo cargo = new Cargo();

        cargo.setNombreCargo("Gerente de Operaciones y Logística");
        cargo.setDescripcionCargo(null);
        cargo.setEstadoCargo(true);
        
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        Set<ConstraintViolation<Cargo>> violations = validator.validate(cargo);

        // List<String> errorMessages = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
        // for (ConstraintViolation<Cargo> violation : violations) {
        //     System.out.println(violation.getMessage());
        // }

        // assertTrue(errorMessages.contains("String"));
        assertEquals(1, violations.size());
        assertEquals("El nombre del cargo no puede tener más de 15 caracteres", violations.iterator().next().getMessage());
    }

    @Test
    @Transactional
    public void testNombreCargoUnico() {
        Cargo cargo1 = new Cargo();
        Cargo cargo2 = new Cargo();

        cargo1.setNombreCargo("Administrador");
        cargo1.setEstadoCargo(true);
        cargo2.setNombreCargo("Administrador");
        cargo2.setEstadoCargo(true);

        cargoRepository.save(cargo1);

        try {
            cargoRepository.save(cargo2);
            fail("No se lanzó la excepción esperada");
        } catch (DataIntegrityViolationException e) {
            System.out.println("Se lanzó la excepción esperada");
            System.out.println(e.getMessage());
            assertTrue(e.getMessage().contains("cargos.UK"));
        }
    }

}
