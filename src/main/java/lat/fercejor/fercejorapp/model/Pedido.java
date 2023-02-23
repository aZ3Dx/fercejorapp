package lat.fercejor.fercejorapp.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPedido")
    private Long id;

    @Column(name = "fechaPedido", nullable = false)
    @NotBlank(message = "La fecha del pedido no puede estar vacía")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "La fecha del pedido no puede ser una fecha futura")
    private LocalDate fechaPedido;

    @Column(name = "descripcionPedido", nullable = false, length = 200)
    @Size(max = 200, message = "La descripción del pedido no puede tener más de 200 caracteres")
    @NotBlank(message = "La descripción del pedido no puede estar vacía")
    private String descripcionPedido;

    @Column(name = "cantidadProductos", nullable = false)
    @NotBlank(message = "La cantidad de productos no puede estar vacía")
    @Positive(message = "La cantidad de productos debe ser un número positivo")
    @Min(value = 1, message = "La cantidad de productos debe ser mayor a 0")
    private Integer cantidadProductos;

    @Column(name = "pesoPedido", nullable = false)
    @NotBlank(message = "El peso del pedido no puede estar vacío")
    @Positive(message = "El peso del pedido debe ser un número positivo")
    @Digits(integer = 10, fraction = 2, message = "El peso del pedido debe tener como máximo 10 dígitos y 2 decimales")
    private Double pesoPedido;

    @Column(name = "precioPedido", nullable = false)
    @NotBlank(message = "El precio del pedido no puede estar vacío")
    @Positive(message = "El precio del pedido debe ser un número positivo")
    @Digits(integer = 10, fraction = 2, message = "El precio del pedido debe tener como máximo 10 dígitos y 2 decimales")
    private Double precioPedido;

    @Column(name = "fechaEntrega")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "La fecha de entrega del pedido no puede ser una fecha pasada")
    private LocalDate fechaEntrega;

    @Column(name = "estadoPedido", nullable = false)
    @NotBlank(message = "El estado del pedido no puede estar vacío")
    private Boolean estadoPedido;

    @ManyToOne
    @JoinColumn(name = "fkIdCliente", nullable = false, referencedColumnName = "idCliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido")
    private List<ProductoPedido> productosPedido;

    @OneToOne(mappedBy = "pedido")
    private ComprobantePago comprobantePago;

    @OneToOne(mappedBy = "pedido")
    private HojaRuta hojaRuta;
    
}
