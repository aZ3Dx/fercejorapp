package lat.fercejor.fercejorapp.api;

import java.util.List;
import java.util.Optional;

import lat.fercejor.fercejorapp.model.Proveedor;

public interface ProveedorServiceAPI {

    List<Proveedor> obtenerTodosLosProveedores();
    Optional<Proveedor> obtenerProveedorPorId(Long id);
    Proveedor crearProveedor(Proveedor proveedor);
    void eliminarProveedor(Long id);
    Proveedor actualizarProveedor(Proveedor proveedor);
    
}
