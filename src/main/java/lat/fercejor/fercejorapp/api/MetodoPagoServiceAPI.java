package lat.fercejor.fercejorapp.api;

import java.util.List;
import java.util.Optional;

import lat.fercejor.fercejorapp.model.MetodoPago;

public interface MetodoPagoServiceAPI {

    List<MetodoPago> obtenerTodosLosMetodosPago();
    Optional<MetodoPago> obtenerMetodoPagoPorId(Long id);
    MetodoPago crearMetodoPago(MetodoPago metodoPago);
    void eliminarMetodoPago(Long id);
    MetodoPago actualizarMetodoPago(MetodoPago metodoPago);
    
}
