package lat.fercejor.fercejorapp.model;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("tst")
public class ClienteTest {

    @Test
    public void testValidacionDatos() {
        Cliente cliente = new Cliente();

        cliente.setId(12345678L);
        cliente.setNombreCliente("Ricardo");

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        Set<ConstraintViolation<Cliente>> violations = validator.validate(cliente);

        // List<String> errorMessages = violations.stream().map(ConstraintViolation::getMessage)
        //         .collect(Collectors.toList());
        for (ConstraintViolation<Cliente> violation : violations) {
            System.out.println(violation.getMessage());
        }

    }

}
