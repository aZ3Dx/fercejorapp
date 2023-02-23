package lat.fercejor.fercejorapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lat.fercejor.fercejorapp.api.CategoriaServiceAPI;
import lat.fercejor.fercejorapp.model.Categoria;
import lat.fercejor.fercejorapp.repository.CategoriaRepository;

@Service
public class CategoriaService implements CategoriaServiceAPI {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> obtenerTodasLasCategorias() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return categorias;
    }

    @Override
    public Optional<Categoria> obtenerCategoriaPorId(Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria;
    }

    @Override
    public Categoria crearCategoria(Categoria categoria) {
        Categoria categoriaCreada = categoriaRepository.save(categoria);
        return categoriaCreada;
    }

    @Override
    public void eliminarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }

    @Override
    public Categoria actualizarCategoria(Categoria categoria) {
        Categoria categoriaActualizada = categoriaRepository.save(categoria);
        return categoriaActualizada;
    }
    
}
