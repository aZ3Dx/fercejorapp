package lat.fercejor.fercejorapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import lat.fercejor.fercejorapp.model.Cargo;
import lat.fercejor.fercejorapp.repository.CargoRepository;

@SpringBootTest
@ActiveProfiles("tst")
public class CargoServiceTest {

    @Autowired
    private CargoService cargoService;

    @MockBean
    private CargoRepository cargoRepository;

    @Test
    public void testObtenerTodosLosCargos() {
        List<Cargo> cargos = new ArrayList<>();
        cargos.add(new Cargo(1L, "Gerente", "Gerente general", true, null));
        cargos.add(new Cargo(2L, "Administrador", "Administrador general", true, null));
        cargos.add(new Cargo(3L, "Vendedor", "Vendedor general", true, null));

        Mockito.when(cargoRepository.findAll()).thenReturn(cargos);

        List<Cargo> cargosObtenidos = cargoService.obtenerTodosLosCargos();

        assertEquals(cargos.size(), cargosObtenidos.size());
        assertTrue(cargosObtenidos.containsAll(cargos));
    }

}
