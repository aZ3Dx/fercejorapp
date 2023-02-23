package lat.fercejor.fercejorapp.model;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;

import lat.fercejor.fercejorapp.repository.CategoriaRepository;

@SpringBootTest
@ActiveProfiles("tst")
public class CategoriaTest {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Test
    public void testNombreCategoriaUnico() {
        Categoria categoria1 = new Categoria();
        Categoria categoria2 = new Categoria();
        Categoria categoria3 = new Categoria();

        categoria1.setNombreCategoria("Frenos");
        categoria1.setDescripcionCategoria("Frenos de disco");
        categoria1.setEstadoCategoria(true);
        categoria2.setNombreCategoria("Motor 4");
        categoria2.setDescripcionCategoria("Motor de 4 cilindros");
        categoria2.setEstadoCategoria(true);
        categoria3.setNombreCategoria("Motor 4");
        categoria3.setDescripcionCategoria("Motor de 2x4 cilindros");
        categoria3.setEstadoCategoria(true);

        categoriaRepository.save(categoria1);
        categoriaRepository.save(categoria2);

        try {
            categoriaRepository.save(categoria3);
            fail("No se lanzó la excepción DataIntegrityViolationException");
        } catch (DataIntegrityViolationException e) {
            assertTrue(e.getMessage().contains("categorias.UK"));
        }
    }

}
