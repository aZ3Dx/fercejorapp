package lat.fercejor.fercejorapp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("tst")
public class CuentaTest {

    @Test
    public void testValidacionDatosCuenta() {
        Cuenta cuenta = new Cuenta();

        cuenta.setUsuario("Fercejor");
        cuenta.setClave("123456");
        cuenta.setEstadoCuenta(true);
        
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        Set<ConstraintViolation<Cuenta>> violations = validator.validate(cuenta);

        for (ConstraintViolation<Cuenta> violation : violations) {
            System.out.println(violation.getMessage());
        }

        assertEquals(1, violations.size());
        assertEquals("La clave debe tener al menos 8 caracteres", violations.iterator().next().getMessage());
    }

}
