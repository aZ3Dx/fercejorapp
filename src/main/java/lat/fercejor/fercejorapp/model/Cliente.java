package lat.fercejor.fercejorapp.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @Column(name = "idCliente")
    private Long id;

    @Column(name = "nombreCliente", nullable = false, length = 50)
    @Size(max = 50, message = "El nombre del cliente no puede tener más de 50 caracteres")
    @NotBlank(message = "El nombre del cliente no puede estar vacío")
    private String nombreCliente;

    @Column(name = "apellidoPaternoCliente", nullable = false, length = 50)
    @Size(max = 50, message = "El apellido paterno del cliente no puede tener más de 50 caracteres")
    @NotBlank(message = "El apellido paterno del cliente no puede estar vacío")
    private String apellidoPaternoCliente;

    @Column(name = "apellidoMaternoCliente", nullable = false, length = 50)
    @Size(max = 50, message = "El apellido materno del cliente no puede tener más de 50 caracteres")
    @NotBlank(message = "El apellido materno del cliente no puede estar vacío")
    private String apellidoMaternoCliente;

    @Column(name = "correoCliente", nullable = false, length = 50)
    @Size(max = 50, message = "El correo del cliente no puede tener más de 50 caracteres")
    @NotBlank(message = "El correo del cliente no puede estar vacío")
    @Email(message = "El correo del cliente no es válido")
    private String correoCliente;

    @Column(name = "celularCliente", nullable = false, unique = true, length = 15)
    @Size(max = 15, message = "El celular del cliente no puede tener más de 15 caracteres")
    @NotBlank(message = "El celular del cliente no puede estar vacío")
    private String celularCliente;

    @Column(name = "direccionCliente", nullable = false, length = 50)
    @Size(max = 50, message = "La dirección del cliente no puede tener más de 50 caracteres")
    @NotBlank(message = "La dirección del cliente no puede estar vacío")
    private String direccionCliente;

    @Column(name = "fechaNacimientoCliente", nullable = false)
    @NotNull(message = "La fecha de nacimiento del cliente no puede estar vacía")
    @Past(message = "La fecha de nacimiento del cliente no puede ser mayor a la fecha actual")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimientoCliente;

    @Column(name = "credito", nullable = false)
    @NotNull(message = "El crédito del cliente no puede estar vacío")
    @Min(value = 0, message = "El crédito del cliente no puede ser menor a 0")
    private double credito;

    @OneToOne
    @JoinColumn(name = "fkIdCuentaCliente", nullable = false, referencedColumnName = "idCuenta")
    private Cuenta cuenta;

    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;

    @OneToMany(mappedBy = "cliente")
    private List<HistoriaCredito> historiasCredito;

}
