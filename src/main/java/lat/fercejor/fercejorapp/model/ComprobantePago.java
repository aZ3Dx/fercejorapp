package lat.fercejor.fercejorapp.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "comprobantesPago")
public class ComprobantePago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idComprobantePago")
    private Long id;

    @OneToOne
    @JoinColumn(name = "fkIdMetodoPago", nullable = false, referencedColumnName = "idMetodoPago")
    private MetodoPago metodoPago;

    @OneToOne
    @JoinColumn(name = "fkIdPedidoPagado", nullable = false, referencedColumnName = "idPedido")
    private Pedido pedido;

    @OneToOne
    @JoinColumn(name = "fkTipoComprobante", nullable = false, referencedColumnName = "idTipoComprobante")
    private TipoComprobante tipoComprobante;

    @Column(name = "nota", nullable = false, length = 200)
    @Size(max = 200, message = "La nota no puede tener más de 200 caracteres")
    @NotBlank(message = "La nota no puede estar vacía")
    private String nota;

    @Column(name = "fechaEmisionComprobantePago", nullable = false)
    @NotBlank(message = "La fecha de emisión del comprobante de pago no puede estar vacía")
    @FutureOrPresent(message = "La fecha de emisión del comprobante de pago no puede ser una fecha pasada")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaEmisionComprobantePago;

    @Column(name = "horaEmisionComprobantePago", nullable = false)
    @NotBlank(message = "La hora de emisión del comprobante de pago no puede estar vacía")
    @FutureOrPresent(message = "La hora de emisión del comprobante de pago no puede ser una hora pasada")
    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalTime horaEmisionComprobantePago;
    
}
