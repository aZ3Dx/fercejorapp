package lat.fercejor.fercejorapp.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "creditos")
public class Credito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCredito")
    private Long id;

    @Column(name = "fechaEmision", nullable = false)
    @NotBlank(message = "La fecha de emisión del crédito no puede estar vacía")
    @FutureOrPresent(message = "La fecha de emisión del crédito no puede ser anterior a la fecha actual")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaEmision;

    @Column(name = "horaEmision", nullable = false)
    @NotBlank(message = "La hora de emisión del crédito no puede estar vacía")
    @FutureOrPresent(message = "La hora de emisión del crédito no puede ser anterior a la hora actual")
    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalTime horaEmision;

    @Column(name = "cantidadCredito", nullable = false, precision = 10, scale = 2)
    @NotBlank(message = "La cantidad del crédito no puede estar vacía")
    @Digits(integer = 10, fraction = 2, message = "La cantidad del crédito no puede tener más de 10 dígitos enteros y 2 dígitos decimales")
    @Positive(message = "La cantidad del crédito debe ser un número positivo")
    private Double cantidadCredito;

    @Column(name = "estadoCredito", nullable = false)
    @NotBlank(message = "El estado del crédito no puede estar vacío")
    private Boolean estadoCredito;

    @OneToOne(mappedBy = "credito")
    private Cliente cliente;
    
}
