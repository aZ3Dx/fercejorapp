package lat.fercejor.fercejorapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lat.fercejor.fercejorapp.api.MetodoPagoServiceAPI;
import lat.fercejor.fercejorapp.model.MetodoPago;
import lat.fercejor.fercejorapp.repository.MetodoPagoRepository;

@Service
public class MetodoPagoService implements MetodoPagoServiceAPI {

    @Autowired
    private MetodoPagoRepository metodoPagoRepository;

    @Override
    public List<MetodoPago> obtenerTodosLosMetodosPago() {
        List<MetodoPago> metodosPago = metodoPagoRepository.findAll();
        return metodosPago;
    }

    @Override
    public Optional<MetodoPago> obtenerMetodoPagoPorId(Long id) {
        Optional<MetodoPago> metodoPago = metodoPagoRepository.findById(id);
        return metodoPago;
    }

    @Override
    public MetodoPago crearMetodoPago(MetodoPago metodoPago) {
        MetodoPago metodoPagoCreado = metodoPagoRepository.save(metodoPago);
        return metodoPagoCreado;
    }

    @Override
    public void eliminarMetodoPago(Long id) {
        metodoPagoRepository.deleteById(id);
    }

    @Override
    public MetodoPago actualizarMetodoPago(MetodoPago metodoPago) {
        MetodoPago metodoPagoActualizado = metodoPagoRepository.save(metodoPago);
        return metodoPagoActualizado;
    }
    
}
