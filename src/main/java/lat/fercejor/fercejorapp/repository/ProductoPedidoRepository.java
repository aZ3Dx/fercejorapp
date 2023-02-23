package lat.fercejor.fercejorapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lat.fercejor.fercejorapp.model.Pedido;
import lat.fercejor.fercejorapp.model.Producto;
import lat.fercejor.fercejorapp.model.ProductoPedido;
import lat.fercejor.fercejorapp.model.ProductoPedidoId;

@Repository
public interface ProductoPedidoRepository extends JpaRepository<ProductoPedido, ProductoPedidoId> {

    ProductoPedido findByProductoAndPedido(Producto producto, Pedido pedido);
    void deleteByProductoAndPedido(Producto producto, Pedido pedido);
    
}
