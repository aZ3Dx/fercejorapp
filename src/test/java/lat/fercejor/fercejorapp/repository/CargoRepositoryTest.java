package lat.fercejor.fercejorapp.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import lat.fercejor.fercejorapp.model.Cargo;

@SpringBootTest
@ActiveProfiles("tst")
public class CargoRepositoryTest {

    @Autowired
    private CargoRepository cargoRepository;

    @BeforeEach
    @Transactional
    public void setUp() {
        Cargo cargo1 = new Cargo();
        Cargo cargo2 = new Cargo();

        cargo1.setNombreCargo("Administrador");
        cargo1.setEstadoCargo(true);
        cargo2.setNombreCargo("Gerente");
        cargo2.setEstadoCargo(true);

        cargoRepository.save(cargo1);
        cargoRepository.save(cargo2);
    }

    @Test
    public void testFindAll() {
        List<Cargo> cargos = cargoRepository.findAll();

        assertEquals(2, cargos.size());

        assertEquals("Administrador", cargos.get(0).getNombreCargo());
        assertEquals("Gerente", cargos.get(1).getNombreCargo());
    }

}
