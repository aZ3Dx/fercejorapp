package lat.fercejor.fercejorapp.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
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
@Table(name = "historiasCredito")
public class HistoriaCredito {

    @EmbeddedId
    private HistoriaCreditoId id;

    @ManyToOne
    @JoinColumn(name = "fkIdCliente", nullable = false, referencedColumnName = "idCliente", insertable = false, updatable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "fkIdEmpleadoAdministradorCredito", nullable = false, referencedColumnName = "idEmpleado", insertable = false, updatable = false)
    private Empleado empleado;

    @Column(name = "fechaEmision", nullable = false)
    @NotNull(message = "La fecha de emisión no puede estar vacía")
    @FutureOrPresent(message = "La fecha de emisión no puede ser anterior a la fecha actual")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaEmision;

    @Column(name = "horaEmision", nullable = false)
    @NotNull(message = "La hora de emisión no puede estar vacía")
    @FutureOrPresent(message = "La hora de emisión no puede ser anterior a la hora actual")
    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalTime horaEmision;

    @Column(name = "cantidadCreditoNuevo", nullable = false, precision = 10, scale = 2)
    @NotNull(message = "La cantidad del crédito no puede estar vacía")
    @Digits(integer = 10, fraction = 2, message = "La cantidad del crédito no puede tener más de 10 dígitos enteros y 2 dígitos decimales")
    @Positive(message = "La cantidad del crédito debe ser un número positivo")
    private double cantidadCreditoNuevo;

    @Column(name = "cantidadCreditoAnterior", nullable = false, precision = 10, scale = 2)
    @NotNull(message = "La cantidad del crédito no puede estar vacía")
    @Digits(integer = 10, fraction = 2, message = "La cantidad del crédito no puede tener más de 10 dígitos enteros y 2 dígitos decimales")
    @Positive(message = "La cantidad del crédito debe ser un número positivo")
    private double cantidadCreditoAnterior;
    
}
