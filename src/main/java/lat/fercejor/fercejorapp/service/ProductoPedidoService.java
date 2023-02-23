package lat.fercejor.fercejorapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lat.fercejor.fercejorapp.api.ProductoPedidoServiceAPI;
import lat.fercejor.fercejorapp.model.Pedido;
import lat.fercejor.fercejorapp.model.Producto;
import lat.fercejor.fercejorapp.model.ProductoPedido;
import lat.fercejor.fercejorapp.repository.ProductoPedidoRepository;

@Service
public class ProductoPedidoService implements ProductoPedidoServiceAPI {

    @Autowired
    private ProductoPedidoRepository productoPedidoRepository;

    @Override
    public List<ProductoPedido> obtenerTodosLosProductosPedido() {
        List<ProductoPedido> productosPedido = productoPedidoRepository.findAll();
        return productosPedido;
    }

    @Override
    public Optional<ProductoPedido> obtenerPorProductoYPedido(Producto producto, Pedido pedido) {
        ProductoPedido productoPedido = productoPedidoRepository.findByProductoAndPedido(producto, pedido);
        return Optional.ofNullable(productoPedido);
    }

    @Override
    public ProductoPedido crearProductoPedido(ProductoPedido productoPedido) {
        ProductoPedido productoPedidoCreado = productoPedidoRepository.save(productoPedido);
        return productoPedidoCreado;
    }

    @Override
    public void eliminarPorProductoYPedido(Producto producto, Pedido pedido) {
        productoPedidoRepository.deleteByProductoAndPedido(producto, pedido);
    }
    
}
