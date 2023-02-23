package lat.fercejor.fercejorapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lat.fercejor.fercejorapp.api.ProductoProveedorServiceAPI;
import lat.fercejor.fercejorapp.model.Producto;
import lat.fercejor.fercejorapp.model.ProductoProveedor;
import lat.fercejor.fercejorapp.model.Proveedor;
import lat.fercejor.fercejorapp.repository.ProductoProveedorRepository;

@Service
public class ProductoProveedorService implements ProductoProveedorServiceAPI {

    @Autowired
    private ProductoProveedorRepository productoProveedorRepository;

    @Override
    public List<ProductoProveedor> obtenerTodosLosProductosProveedor() {
        List<ProductoProveedor> productosProveedor = productoProveedorRepository.findAll();
        return productosProveedor;
    }

    @Override
    public Optional<ProductoProveedor> obtenerPorProductoYProveedor(Producto producto, Proveedor proveedor) {
        ProductoProveedor productoProveedor = productoProveedorRepository.findByProductoAndProveedor(producto, proveedor);
        return Optional.ofNullable(productoProveedor);
    }

    @Override
    public ProductoProveedor crearProductoProveedor(ProductoProveedor productoProveedor) {
        ProductoProveedor productoProveedorCreado = productoProveedorRepository.save(productoProveedor);
        return productoProveedorCreado;
    }

    @Override
    public void eliminarPorProductoYProveedor(Producto producto, Proveedor proveedor) {
        productoProveedorRepository.deleteByProductoAndProveedor(producto, proveedor);
    }
    
}
