package lat.fercejor.fercejorapp.api;

import java.util.List;
import java.util.Optional;

import lat.fercejor.fercejorapp.model.Producto;
import lat.fercejor.fercejorapp.model.ProductoProveedor;
import lat.fercejor.fercejorapp.model.Proveedor;

public interface ProductoProveedorServiceAPI {

    List<ProductoProveedor> obtenerTodosLosProductosProveedor();
    Optional<ProductoProveedor> obtenerPorProductoYProveedor(Producto producto, Proveedor proveedor);
    ProductoProveedor crearProductoProveedor(ProductoProveedor productoProveedor);
    void eliminarPorProductoYProveedor(Producto producto, Proveedor proveedor);
    
}
