package lat.fercejor.fercejorapp.api;

import java.util.List;
import java.util.Optional;

import lat.fercejor.fercejorapp.model.Cliente;
import lat.fercejor.fercejorapp.model.Empleado;
import lat.fercejor.fercejorapp.model.HistoriaCredito;

public interface HistoriaCreditoServiceAPI {

    List<HistoriaCredito> obtenerTodosLosHistoriaCreditos();
    Optional<HistoriaCredito> obtenerPorClienteYEmpleado(Cliente cliente, Empleado empleado);
    HistoriaCredito crearHistoriaCredito(HistoriaCredito historiaCredito);
    void eliminarPorClienteYEmpleado(Cliente cliente, Empleado empleado);
    
}
