package lat.fercejor.fercejorapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lat.fercejor.fercejorapp.api.CreditoServiceAPI;
import lat.fercejor.fercejorapp.model.Credito;
import lat.fercejor.fercejorapp.repository.CreditoRepository;

@Service
public class CreditoService implements CreditoServiceAPI {

    @Autowired
    private CreditoRepository creditoRepository;

    @Override
    public List<Credito> obtenerTodosLosCreditos() {
        List<Credito> creditos = creditoRepository.findAll();
        return creditos;
    }

    @Override
    public Optional<Credito> obtenerCreditoPorId(Long id) {
        Optional<Credito> credito = creditoRepository.findById(id);
        return credito;
    }

    @Override
    public Credito crearCredito(Credito credito) {
        Credito creditoCreado = creditoRepository.save(credito);
        return creditoCreado;
    }

    @Override
    public void eliminarCredito(Long id) {
        creditoRepository.deleteById(id);
    }

    @Override
    public Credito actualizarCredito(Credito credito) {
        Credito creditoActualizado = creditoRepository.save(credito);
        return creditoActualizado;
    }
    
}
