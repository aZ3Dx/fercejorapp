package lat.fercejor.fercejorapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lat.fercejor.fercejorapp.api.PedidoServiceAPI;
import lat.fercejor.fercejorapp.model.Pedido;
import lat.fercejor.fercejorapp.repository.PedidoRepository;

@Service
public class PedidoService implements PedidoServiceAPI {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> obtenerTodosLosPedidos() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidos;
    }

    @Override
    public Optional<Pedido> obtenerPedidoPorId(Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        return pedido;
    }

    @Override
    public Pedido crearPedido(Pedido pedido) {
        Pedido pedidoCreado = pedidoRepository.save(pedido);
        return pedidoCreado;
    }

    @Override
    public void eliminarPedido(Long id) {
        pedidoRepository.deleteById(id);
    }

    @Override
    public Pedido actualizarPedido(Pedido pedido) {
        Pedido pedidoActualizado = pedidoRepository.save(pedido);
        return pedidoActualizado;
    }
    
}
