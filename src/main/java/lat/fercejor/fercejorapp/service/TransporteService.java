package lat.fercejor.fercejorapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lat.fercejor.fercejorapp.api.TransporteServiceAPI;
import lat.fercejor.fercejorapp.model.Transporte;
import lat.fercejor.fercejorapp.repository.TransporteRepository;

@Service
public class TransporteService implements TransporteServiceAPI {

    @Autowired
    private TransporteRepository transporteRepository;

    @Override
    public List<Transporte> obtenerTodosLosTransportes() {
        List<Transporte> transportes = transporteRepository.findAll();
        return transportes;
    }

    @Override
    public Optional<Transporte> obtenerTransportePorId(Long id) {
        Optional<Transporte> transporte = transporteRepository.findById(id);
        return transporte;
    }

    @Override
    public Transporte crearTransporte(Transporte transporte) {
        Transporte transporteCreado = transporteRepository.save(transporte);
        return transporteCreado;
    }

    @Override
    public void eliminarTransporte(Long id) {
        transporteRepository.deleteById(id);
    }

    @Override
    public Transporte actualizarTransporte(Transporte transporte) {
        Transporte transporteActualizado = transporteRepository.save(transporte);
        return transporteActualizado;
    }
    
}
