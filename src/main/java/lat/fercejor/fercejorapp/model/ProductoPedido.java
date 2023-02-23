package lat.fercejor.fercejorapp.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "productosPedido")
public class ProductoPedido {

    @EmbeddedId
    private ProductoPedidoId id; 

    @ManyToOne
    @JoinColumn(name = "fkIdProducto", nullable = false, referencedColumnName = "idProducto", insertable = false, updatable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "fkIdPedido", nullable = false, referencedColumnName = "idPedido", insertable = false, updatable = false)
    private Pedido pedido;

    @Column(name = "peso", nullable = false)
    @NotBlank(message = "El peso del producto no puede estar vacío")
    @Digits(integer = 10, fraction = 2, message = "El peso del producto no puede tener más de 10 dígitos y 2 decimales")
    @Positive(message = "El peso del producto no puede ser negativo")
    private Double peso;

    @Column(name = "cantidad", nullable = false)
    @NotBlank(message = "La cantidad del producto no puede estar vacía")
    @Min(value = 1, message = "La cantidad del producto no puede ser negativa")
    private Integer cantidad;
    
}
