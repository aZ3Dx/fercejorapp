package lat.fercejor.fercejorapp.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "proveedores")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProveedor")
    private Long id;

    @Column(name = "nombreProveedor", nullable = false, length = 50)
    @Size(max = 50, message = "El nombre del proveedor no puede tener más de 50 caracteres")
    @NotBlank(message = "El nombre del proveedor no puede estar vacío")
    private String nombreProveedor;

    @Column(name = "apellidoPaternoProveedor", nullable = false, length = 50)
    @Size(max = 50, message = "El apellido paterno del proveedor no puede tener más de 50 caracteres")
    @NotBlank(message = "El apellido paterno del proveedor no puede estar vacío")
    private String apellidoPaternoProveedor;

    @Column(name = "apellidoMaternoProveedor", nullable = false, length = 50)
    @Size(max = 50, message = "El apellido materno del proveedor no puede tener más de 50 caracteres")
    @NotBlank(message = "El apellido materno del proveedor no puede estar vacío")
    private String apellidoMaternoProveedor;

    @Column(name = "correoProveedor", nullable = false, unique = true, length = 50)
    @Size(max = 50, message = "El correo del proveedor no puede tener más de 50 caracteres")
    @NotBlank(message = "El correo del proveedor no puede estar vacío")
    @Email(message = "El correo del proveedor debe ser válido")
    private String correoProveedor;

    @Column(name = "celularProveedor", nullable = false, unique = true, length = 15)
    @Size(max = 15, message = "El celular del proveedor no puede tener más de 15 caracteres")
    @NotBlank(message = "El celular del proveedor no puede estar vacío")
    private String celularProveedor;

    @Column(name = "direccionProveedor", nullable = false, length = 50)
    @Size(max = 50, message = "La dirección del proveedor no puede tener más de 50 caracteres")
    @NotBlank(message = "La dirección del proveedor no puede estar vacío")
    private String direccionProveedor;

    @Column(name = "fechaNacimientoProveedor", nullable = false)
    @NotBlank(message = "La fecha de nacimiento del proveedor no puede estar vacía")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "La fecha de nacimiento del proveedor no puede ser mayor a la fecha actual")
    private LocalDate fechaNacimientoProveedor;

    @Column(name = "numeroRuc", nullable = false, unique = true, length = 15)
    @Size(max = 15, message = "El número de RUC del proveedor no puede tener más de 15 caracteres")
    @NotBlank(message = "El número de RUC del proveedor no puede estar vacío")
    private String numeroRuc;

    @OneToOne(mappedBy = "proveedor")
    private Producto producto;
    
}
