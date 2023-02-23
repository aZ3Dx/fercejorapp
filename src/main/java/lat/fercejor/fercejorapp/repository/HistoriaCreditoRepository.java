package lat.fercejor.fercejorapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lat.fercejor.fercejorapp.model.Cliente;
import lat.fercejor.fercejorapp.model.Empleado;
import lat.fercejor.fercejorapp.model.HistoriaCredito;
import lat.fercejor.fercejorapp.model.HistoriaCreditoId;

@Repository
public interface HistoriaCreditoRepository extends JpaRepository<HistoriaCredito, HistoriaCreditoId> {

    HistoriaCredito findByClienteAndEmpleado(Cliente cliente, Empleado empleado);
    void deleteByClienteAndEmpleado(Cliente cliente, Empleado empleado);
    
}
