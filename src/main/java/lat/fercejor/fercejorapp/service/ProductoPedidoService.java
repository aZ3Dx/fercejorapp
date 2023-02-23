package lat.fercejor.fercejorapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lat.fercejor.fercejorapp.api.ProductoPedidoServiceAPI;
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
    public Optional<ProductoPedido> obtenerProductoPedidoPorId(Long id) {
        Optional<ProductoPedido> productoPedido = productoPedidoRepository.findById(id);
        return productoPedido;
    }

    @Override
    public ProductoPedido crearProductoPedido(ProductoPedido productoPedido) {
        ProductoPedido productoPedidoCreado = productoPedidoRepository.save(productoPedido);
        return productoPedidoCreado;
    }

    @Override
    public void eliminarProductoPedido(Long id) {
        productoPedidoRepository.deleteById(id);
    }

    @Override
    public ProductoPedido actualizarProductoPedido(ProductoPedido productoPedido) {
        ProductoPedido productoPedidoActualizado = productoPedidoRepository.save(productoPedido);
        return productoPedidoActualizado;
    }
    
}
