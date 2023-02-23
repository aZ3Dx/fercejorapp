package lat.fercejor.fercejorapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lat.fercejor.fercejorapp.api.ClienteServiceAPI;
import lat.fercejor.fercejorapp.model.Cliente;
import lat.fercejor.fercejorapp.repository.ClienteRepository;

@Service
public class ClienteService implements ClienteServiceAPI {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> obtenerTodosLosClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes;
    }

    @Override
    public Optional<Cliente> obtenerClientePorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente;
    }

    @Override
    public Cliente crearCliente(Cliente cliente) {
        Cliente clienteCreado = clienteRepository.save(cliente);
        return clienteCreado;
    }

    @Override
    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) {
        Cliente clienteActualizado = clienteRepository.save(cliente);
        return clienteActualizado;
    }
    
}
