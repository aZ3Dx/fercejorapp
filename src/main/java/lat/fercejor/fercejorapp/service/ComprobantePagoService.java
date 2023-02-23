package lat.fercejor.fercejorapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lat.fercejor.fercejorapp.api.ComprobantePagoServiceAPI;
import lat.fercejor.fercejorapp.model.ComprobantePago;
import lat.fercejor.fercejorapp.repository.ComprobantePagoRepository;

@Service
public class ComprobantePagoService implements ComprobantePagoServiceAPI {

    @Autowired
    private ComprobantePagoRepository comprobantePagoRepository;

    @Override
    public List<ComprobantePago> obtenerTodosLosComprobantesPago() {
        List<ComprobantePago> comprobantesPago = comprobantePagoRepository.findAll();
        return comprobantesPago;
    }

    @Override
    public Optional<ComprobantePago> obtenerComprobantePagoPorId(Long id) {
        Optional<ComprobantePago> comprobantePago = comprobantePagoRepository.findById(id);
        return comprobantePago;
    }

    @Override
    public ComprobantePago crearComprobantePago(ComprobantePago comprobantePago) {
        ComprobantePago comprobantePagoCreado = comprobantePagoRepository.save(comprobantePago);
        return comprobantePagoCreado;
    }

    @Override
    public void eliminarComprobantePago(Long id) {
        comprobantePagoRepository.deleteById(id);
    }

    @Override
    public ComprobantePago actualizarComprobantePago(ComprobantePago comprobantePago) {
        ComprobantePago comprobantePagoActualizado = comprobantePagoRepository.save(comprobantePago);
        return comprobantePagoActualizado;
    }
    
}
