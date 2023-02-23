package lat.fercejor.fercejorapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lat.fercejor.fercejorapp.api.ProveedorServiceAPI;
import lat.fercejor.fercejorapp.model.Proveedor;
import lat.fercejor.fercejorapp.repository.ProveedorRepository;

@Service
public class ProveedorService implements ProveedorServiceAPI {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public List<Proveedor> obtenerTodosLosProveedores() {
        List<Proveedor> proveedores = proveedorRepository.findAll();
        return proveedores;
    }

    @Override
    public Optional<Proveedor> obtenerProveedorPorId(Long id) {
        Optional<Proveedor> proveedor = proveedorRepository.findById(id);
        return proveedor;
    }

    @Override
    public Proveedor crearProveedor(Proveedor proveedor) {
        Proveedor proveedorCreado = proveedorRepository.save(proveedor);
        return proveedorCreado;
    }

    @Override
    public void eliminarProveedor(Long id) {
        proveedorRepository.deleteById(id);
    }

    @Override
    public Proveedor actualizarProveedor(Proveedor proveedor) {
        Proveedor proveedorActualizado = proveedorRepository.save(proveedor);
        return proveedorActualizado;
    }
    
}
