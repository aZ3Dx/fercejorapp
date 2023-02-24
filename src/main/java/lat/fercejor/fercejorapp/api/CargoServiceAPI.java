package lat.fercejor.fercejorapp.api;

import java.util.List;
import java.util.Optional;

import lat.fercejor.fercejorapp.model.Cargo;

public interface CargoServiceAPI {

    List<Cargo> obtenerTodosLosCargos();
    Optional<Cargo> obtenerCargoPorId(Long id);
    Cargo crearCargo(Cargo cargo);
    void eliminarCargo(Long id);
    Cargo actualizarCargo(Cargo cargo);

    Optional<Cargo> obtenerCargoPorNombre(String nombreCargo);
    
}
