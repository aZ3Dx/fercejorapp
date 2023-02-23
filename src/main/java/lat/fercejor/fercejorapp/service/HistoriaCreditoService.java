package lat.fercejor.fercejorapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lat.fercejor.fercejorapp.api.HistoriaCreditoServiceAPI;
import lat.fercejor.fercejorapp.model.Cliente;
import lat.fercejor.fercejorapp.model.Empleado;
import lat.fercejor.fercejorapp.model.HistoriaCredito;
import lat.fercejor.fercejorapp.repository.HistoriaCreditoRepository;

@Service
public class HistoriaCreditoService implements HistoriaCreditoServiceAPI {

    @Autowired
    private HistoriaCreditoRepository historiaCreditoRepository;

    @Override
    public List<HistoriaCredito> obtenerTodosLosHistoriaCreditos() {
        List<HistoriaCredito> historiaCreditos = historiaCreditoRepository.findAll();
        return historiaCreditos;
    }

    @Override
    public Optional<HistoriaCredito> obtenerPorClienteYEmpleado(Cliente cliente, Empleado empleado) {
        HistoriaCredito historiaCredito = historiaCreditoRepository.findByClienteAndEmpleado(cliente, empleado);
        return Optional.ofNullable(historiaCredito);
    }

    @Override
    public HistoriaCredito crearHistoriaCredito(HistoriaCredito historiaCredito) {
        HistoriaCredito historiaCreditoCreado = historiaCreditoRepository.save(historiaCredito);
        return historiaCreditoCreado;
    }

    @Override
    public void eliminarPorClienteYEmpleado(Cliente cliente, Empleado empleado) {
        historiaCreditoRepository.deleteByClienteAndEmpleado(cliente, empleado);
    }
    
}
