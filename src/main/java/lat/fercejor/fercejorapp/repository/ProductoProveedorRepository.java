package lat.fercejor.fercejorapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lat.fercejor.fercejorapp.model.Producto;
import lat.fercejor.fercejorapp.model.ProductoProveedor;
import lat.fercejor.fercejorapp.model.ProductoProveedorId;
import lat.fercejor.fercejorapp.model.Proveedor;

@Repository
public interface ProductoProveedorRepository extends JpaRepository<ProductoProveedor, ProductoProveedorId> {

    ProductoProveedor findByProductoAndProveedor(Producto producto, Proveedor proveedor);
    void deleteByProductoAndProveedor(Producto producto, Proveedor proveedor);
    
}
