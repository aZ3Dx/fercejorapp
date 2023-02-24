package lat.fercejor.fercejorapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "metodosPago")
public class MetodoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMetodoPago")
    private Long id;

    @Column(name = "nombreMetodoPago", nullable = false, unique = true, length = 15)
    @Size(max = 15, message = "El nombre del método de pago no puede tener más de 15 caracteres")
    @NotBlank(message = "El nombre del método de pago no puede estar vacío")
    private String nombreMetodoPago;

    @Column(name = "estadoMetodoPago", nullable = false)
    @NotNull(message = "El estado del método de pago no puede estar vacío")
    private boolean estadoMetodoPago;

    @OneToOne(mappedBy = "metodoPago")
    private ComprobantePago comprobantePago;
    
}
