package lat.fercejor.fercejorapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lat.fercejor.fercejorapp.api.CargoServiceAPI;
import lat.fercejor.fercejorapp.model.Cargo;
import lat.fercejor.fercejorapp.repository.CargoRepository;

@Service
public class CargoService implements CargoServiceAPI {

    @Autowired
    private CargoRepository cargoRepository;

    @Override
    public List<Cargo> obtenerTodosLosCargos() {
        List<Cargo> cargos = cargoRepository.findAll();
        return cargos;
    }

    @Override
    public Optional<Cargo> obtenerCargoPorId(Long id) {
        Optional<Cargo> cargo = cargoRepository.findById(id);
        return cargo;
    }

    @Override
    public Cargo crearCargo(Cargo cargo) {
        Cargo cargoCreado = cargoRepository.save(cargo);
        return cargoCreado;
    }

    @Override
    public void eliminarCargo(Long id) {
        cargoRepository.deleteById(id);
    }

    @Override
    public Cargo actualizarCargo(Cargo cargo) {
        Cargo cargoActualizado = cargoRepository.save(cargo);
        return cargoActualizado;
    }

    @Override
    public Optional<Cargo> obtenerCargoPorNombre(String nombreCargo) {
        Optional<Cargo> cargo = cargoRepository.findByNombreCargo(nombreCargo);
        return cargo;
    }
    
}
