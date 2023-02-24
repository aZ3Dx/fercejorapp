package lat.fercejor.fercejorapp.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEmpleado")
    private Long id;

    @Column(name = "nombreEmpleado", nullable = false, length = 50)
    @Size(max = 50, message = "El nombre del empleado no puede tener más de 50 caracteres")
    @NotBlank(message = "El nombre del empleado no puede estar vacío")
    private String nombreEmpleado;

    @Column(name = "apellidoPaternoEmpleado", nullable = false, length = 50)
    @Size(max = 50, message = "El apellido paterno del empleado no puede tener más de 50 caracteres")
    @NotBlank(message = "El apellido paterno del empleado no puede estar vacío")
    private String apellidoPaternoEmpleado;

    @Column(name = "apellidoMaternoEmpleado", nullable = false, length = 50)
    @Size(max = 50, message = "El apellido materno del empleado no puede tener más de 50 caracteres")
    @NotBlank(message = "El apellido materno del empleado no puede estar vacío")
    private String apellidoMaternoEmpleado;

    @Column(name = "correoEmpleado", nullable = false, length = 50)
    @Size(max = 50, message = "El correo del empleado no puede tener más de 50 caracteres")
    @NotBlank(message = "El correo del empleado no puede estar vacío")
    @Email(message = "El correo del empleado no es válido")
    private String correoEmpleado;

    @Column(name = "fechaNacimientoEmpleado", nullable = false)
    @NotNull(message = "La fecha de nacimiento del empleado no puede estar vacía")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "La fecha de nacimiento del empleado no puede ser mayor a la fecha actual")
    private LocalDate fechaNacimientoEmpleado;

    @OneToOne
    @JoinColumn(name = "fkIdCuentaEmpleado", nullable = false, referencedColumnName = "idCuenta")
    private Cuenta cuenta;

    @OneToMany(mappedBy = "empleado")
    private List<HistoriaCredito> historiasCredito;

    @OneToMany(mappedBy = "empleado")
    private List<ComprobantePago> comprobantesPago;

    @OneToMany(mappedBy = "empleado")
    private List<HojaRuta> hojasRuta;
    
}
