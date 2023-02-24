package lat.fercejor.fercejorapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import lat.fercejor.fercejorapp.model.Cargo;
import lat.fercejor.fercejorapp.model.Cliente;
import lat.fercejor.fercejorapp.model.Cuenta;

@SpringBootTest
@ActiveProfiles("tst")
public class ClienteServiceTest {

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private CargoService cargoService;
    @Autowired
    private CuentaService cuentaService;

    @BeforeEach
    public void setUp() {
        // Creando un cargo en la base de datos
        Cargo cargo = new Cargo();
        cargo.setId(1L);
        cargo.setNombreCargo("Cliente");
        cargo.setEstadoCargo(true);
        cargoService.crearCargo(cargo);
        // Creando una cuenta para el cliente
        Cuenta cuenta = new Cuenta();
        cuenta.setClave("123456");
        cuenta.setUsuario("12345678");
        cuenta.setEstadoCuenta(true);
        cuenta.setCargo(cargo);
        cuentaService.crearCuenta(cuenta);
    }

    @Test
    @Transactional
    public void testVerClienteGuardado() {
        Cuenta cuenta = cuentaService.obtenerCuentaPorId(1L).get();
        System.out.println("Cuenta: " + cuenta.getUsuario());

        Cliente cliente = new Cliente();
        cliente.setId(12345678L);
        cliente.setNombreCliente("Ricardo");
        cliente.setApellidoPaternoCliente("Nomberto");
        cliente.setApellidoMaternoCliente("Galindo");
        cliente.setCorreoCliente("ricardo@mail.com");
        cliente.setCelularCliente("987987987");
        cliente.setDireccionCliente("Av. Siempre Viva 123");
        cliente.setFechaNacimientoCliente(LocalDate.parse("1990-01-01", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        cliente.setCredito(1000.00);
        cliente.setCuenta(cuenta);

        clienteService.crearCliente(cliente);

        Cliente clienteObtenido = new Cliente();

        clienteObtenido = clienteService.obtenerClientePorId(12345678L).orElse(null);

        // Imprimir cliente y cliente obtenido
        System.out.println("Cliente: " + cliente.toString());
        System.out.println("Cliente obtenido: " + clienteObtenido.toString());

        assertEquals(cliente, clienteObtenido);
    }

}
