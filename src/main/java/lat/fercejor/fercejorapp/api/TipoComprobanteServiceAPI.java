package lat.fercejor.fercejorapp.api;

import java.util.List;
import java.util.Optional;

import lat.fercejor.fercejorapp.model.TipoComprobante;

public interface TipoComprobanteServiceAPI {

    List<TipoComprobante> obtenerTodosLosTiposComprobante();
    Optional<TipoComprobante> obtenerTipoComprobantePorId(Long id);
    TipoComprobante crearTipoComprobante(TipoComprobante tipoComprobante);
    void eliminarTipoComprobante(Long id);
    TipoComprobante actualizarTipoComprobante(TipoComprobante tipoComprobante);
    
}
