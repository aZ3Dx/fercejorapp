package lat.fercejor.fercejorapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lat.fercejor.fercejorapp.api.TipoComprobanteServiceAPI;
import lat.fercejor.fercejorapp.model.TipoComprobante;
import lat.fercejor.fercejorapp.repository.TipoComprobanteRepository;

@Service
public class TipoComprobanteService implements TipoComprobanteServiceAPI {
    
    @Autowired
    private TipoComprobanteRepository tipoComprobanteRepository;

    @Override
    public List<TipoComprobante> obtenerTodosLosTiposComprobante() {
        List<TipoComprobante> tiposComprobante = tipoComprobanteRepository.findAll();
        return tiposComprobante;
    }

    @Override
    public Optional<TipoComprobante> obtenerTipoComprobantePorId(Long id) {
        Optional<TipoComprobante> tipoComprobante = tipoComprobanteRepository.findById(id);
        return tipoComprobante;
    }

    @Override
    public TipoComprobante crearTipoComprobante(TipoComprobante tipoComprobante) {
        TipoComprobante tipoComprobanteCreado = tipoComprobanteRepository.save(tipoComprobante);
        return tipoComprobanteCreado;
    }

    @Override
    public void eliminarTipoComprobante(Long id) {
        tipoComprobanteRepository.deleteById(id);
    }

    @Override
    public TipoComprobante actualizarTipoComprobante(TipoComprobante tipoComprobante) {
        TipoComprobante tipoComprobanteActualizado = tipoComprobanteRepository.save(tipoComprobante);
        return tipoComprobanteActualizado;
    }
    
}
