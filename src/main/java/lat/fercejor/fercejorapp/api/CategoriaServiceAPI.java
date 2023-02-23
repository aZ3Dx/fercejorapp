package lat.fercejor.fercejorapp.api;

import java.util.List;
import java.util.Optional;

import lat.fercejor.fercejorapp.model.Categoria;

public interface CategoriaServiceAPI {

    List<Categoria> obtenerTodasLasCategorias();
    Optional<Categoria> obtenerCategoriaPorId(Long id);
    Categoria crearCategoria(Categoria categoria);
    void eliminarCategoria(Long id);
    Categoria actualizarCategoria(Categoria categoria);
    
}
