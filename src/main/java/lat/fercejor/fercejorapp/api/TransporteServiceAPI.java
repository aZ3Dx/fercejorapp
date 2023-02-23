package lat.fercejor.fercejorapp.api;

import java.util.List;
import java.util.Optional;

import lat.fercejor.fercejorapp.model.Transporte;

public interface TransporteServiceAPI {

    List<Transporte> obtenerTodosLosTransportes();
    Optional<Transporte> obtenerTransportePorId(Long id);
    Transporte crearTransporte(Transporte transporte);
    void eliminarTransporte(Long id);
    Transporte actualizarTransporte(Transporte transporte);
    
}
