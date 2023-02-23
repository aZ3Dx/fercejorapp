package lat.fercejor.fercejorapp.api;

import java.util.List;
import java.util.Optional;

import lat.fercejor.fercejorapp.model.Cliente;

public interface ClienteServiceAPI {

    List<Cliente> obtenerTodosLosClientes();
    Optional<Cliente> obtenerClientePorId(Long id);
    Cliente crearCliente(Cliente cliente);
    void eliminarCliente(Long id);
    Cliente actualizarCliente(Cliente cliente);
    
}
