package lat.fercejor.fercejorapp.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "productosProveedor")
public class ProductoProveedor {

    @EmbeddedId
    private ProductoProveedorId id;

    @ManyToOne
    @JoinColumn(name = "fkIdProductoSuministro",nullable = false, referencedColumnName = "idProducto", insertable = false, updatable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "fkIdProveedor",nullable = false, referencedColumnName = "idProveedor", insertable = false, updatable = false)
    private Proveedor proveedor;

    @Column(name = "cantidadSuministro", nullable = false)
    @NotNull(message = "La cantidad de suministro no puede estar vacía")
    @Positive(message = "La cantidad de suministro debe ser un número positivo")
    private Integer cantidadSuministro;

    @Column(name = "fechaSuministro", nullable = false)
    @NotNull(message = "La fecha de suministro no puede estar vacía")
    @FutureOrPresent(message = "La fecha de suministro no puede ser anterior a la fecha actual")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaSuministro;
    
}
