package lat.fercejor.fercejorapp.api;

import java.util.List;
import java.util.Optional;

import lat.fercejor.fercejorapp.model.Producto;

public interface ProductoServiceAPI {

    List<Producto> obtenerTodosLosProductos();
    Optional<Producto> obtenerProductoPorId(Long id);
    Producto crearProducto(Producto producto);
    void eliminarProducto(Long id);
    Producto actualizarProducto(Producto producto);
    
}
