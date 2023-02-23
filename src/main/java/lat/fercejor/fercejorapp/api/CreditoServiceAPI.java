package lat.fercejor.fercejorapp.api;

import java.util.List;
import java.util.Optional;

import lat.fercejor.fercejorapp.model.Credito;

public interface CreditoServiceAPI {

    List<Credito> obtenerTodosLosCreditos();
    Optional<Credito> obtenerCreditoPorId(Long id);
    Credito crearCredito(Credito credito);
    void eliminarCredito(Long id);
    Credito actualizarCredito(Credito credito);
    
}
