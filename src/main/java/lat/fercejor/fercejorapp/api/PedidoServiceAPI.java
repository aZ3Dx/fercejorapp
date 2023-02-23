package lat.fercejor.fercejorapp.api;

import java.util.List;
import java.util.Optional;

import lat.fercejor.fercejorapp.model.Pedido;

public interface PedidoServiceAPI {

    List<Pedido> obtenerTodosLosPedidos();
    Optional<Pedido> obtenerPedidoPorId(Long id);
    Pedido crearPedido(Pedido pedido);
    void eliminarPedido(Long id);
    Pedido actualizarPedido(Pedido pedido);
    
}
