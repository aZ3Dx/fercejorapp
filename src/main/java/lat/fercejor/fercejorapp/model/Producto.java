package lat.fercejor.fercejorapp.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProducto")
    private Long id;
    
    @Column(name = "nombreProducto", nullable = false, length = 50)
    @Size(max = 50, message = "El nombre del producto no puede tener más de 50 caracteres")
    @NotBlank(message = "El nombre del producto no puede estar vacío")
    private String nombreProducto;

    @Column(name = "descripcionProducto", nullable = false, length = 200)
    @Size(max = 200, message = "La descripción del producto no puede tener más de 200 caracteres")
    @NotBlank(message = "La descripción del producto no puede estar vacía")
    private String descripcionProducto;

    @Column(name = "existencias", nullable = false)
    @NotNull(message = "Las existencias del producto no pueden estar vacías")
    @Positive(message = "Las existencias del producto no pueden ser negativas")
    private Integer existencias;

    @Column(name = "garantia", nullable = false)
    @NotNull(message = "La garantía del producto no puede estar vacía")
    private boolean garantia;

    @Column(name = "marca", length = 50)
    @Size(max = 50, message = "La marca del producto no puede tener más de 50 caracteres")
    @Pattern(regexp = "^(?!\\s*$).+", message = "La marca del producto no puede estar vacía")
    private String marca;

    @Column(name = "precioProducto", nullable = false)
    @NotNull(message = "El precio del producto no puede estar vacío")
    @Digits(integer = 10, fraction = 2, message = "El precio del producto no puede tener más de 10 dígitos y 2 decimales")
    @Min(value = 0, message = "El precio del producto no puede ser negativo")
    private double precioProducto;

    @Column(name = "tipoProducto", length = 15)
    @Size(max = 15, message = "El tipo de producto no puede tener más de 15 caracteres")
    @Pattern(regexp = "^(?!\\s*$).+", message = "El tipo de producto no puede estar vacío")
    private String tipoProducto;

    @ManyToOne
    @JoinColumn(name = "fkIdCategoria", nullable = false, referencedColumnName = "idCategoria")
    private Categoria categoria;

    @OneToMany(mappedBy = "producto")
    private List<ProductoPedido> productosPedidos;
    
}
