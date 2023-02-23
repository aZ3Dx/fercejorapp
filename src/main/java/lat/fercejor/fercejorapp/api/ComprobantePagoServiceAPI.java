package lat.fercejor.fercejorapp.api;

import java.util.List;
import java.util.Optional;

import lat.fercejor.fercejorapp.model.ComprobantePago;

public interface ComprobantePagoServiceAPI {

    List<ComprobantePago> obtenerTodosLosComprobantesPago();
    Optional<ComprobantePago> obtenerComprobantePagoPorId(Long id);
    ComprobantePago crearComprobantePago(ComprobantePago comprobantePago);
    void eliminarComprobantePago(Long id);
    ComprobantePago actualizarComprobantePago(ComprobantePago comprobantePago);
    
}
