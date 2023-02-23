package lat.fercejor.fercejorapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lat.fercejor.fercejorapp.api.ProductoServiceAPI;
import lat.fercejor.fercejorapp.model.Producto;
import lat.fercejor.fercejorapp.repository.ProductoRepository;

@Service
public class ProductoService implements ProductoServiceAPI {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> obtenerTodosLosProductos() {
        List<Producto> productos = productoRepository.findAll();
        return productos;
    }

    @Override
    public Optional<Producto> obtenerProductoPorId(Long id) {
        Optional<Producto> producto = productoRepository.findById(id);
        return producto;
    }

    @Override
    public Producto crearProducto(Producto producto) {
        Producto productoCreado = productoRepository.save(producto);
        return productoCreado;
    }

    @Override
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public Producto actualizarProducto(Producto producto) {
        Producto productoActualizado = productoRepository.save(producto);
        return productoActualizado;
    }
    
}
