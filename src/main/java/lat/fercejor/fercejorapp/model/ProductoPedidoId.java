package lat.fercejor.fercejorapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class ProductoPedidoId implements Serializable {

    @Column(name = "fkIdProducto")
    private Long producto;

    @Column(name = "fkIdPedido")
    private Long pedido;
    
}
