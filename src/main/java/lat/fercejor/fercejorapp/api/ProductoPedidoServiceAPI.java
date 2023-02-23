package lat.fercejor.fercejorapp.api;

import java.util.List;
import java.util.Optional;

import lat.fercejor.fercejorapp.model.Pedido;
import lat.fercejor.fercejorapp.model.Producto;
import lat.fercejor.fercejorapp.model.ProductoPedido;

public interface ProductoPedidoServiceAPI {

    List<ProductoPedido> obtenerTodosLosProductosPedido();
    Optional<ProductoPedido> obtenerPorProductoYPedido(Producto producto, Pedido pedido);
    ProductoPedido crearProductoPedido(ProductoPedido productoPedido);
    void eliminarPorProductoYPedido(Producto producto, Pedido pedido);

}
