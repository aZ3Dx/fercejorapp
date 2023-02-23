package lat.fercejor.fercejorapp.api;

import java.util.List;
import java.util.Optional;

import lat.fercejor.fercejorapp.model.ProductoPedido;

public interface ProductoPedidoServiceAPI {

    List<ProductoPedido> obtenerTodosLosProductosPedido();
    Optional<ProductoPedido> obtenerProductoPedidoPorId(Long id);
    ProductoPedido crearProductoPedido(ProductoPedido productoPedido);
    void eliminarProductoPedido(Long id);
    ProductoPedido actualizarProductoPedido(ProductoPedido productoPedido);

}
