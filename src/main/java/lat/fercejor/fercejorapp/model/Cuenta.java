package lat.fercejor.fercejorapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cuentas")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCuenta")
    private Long id;

    @Column(name = "usuario", nullable = false, unique = true, length = 15)
    @Size(min = 3, max = 15, message = "El nombre de usuario debe tener entre 3 y 15 caracteres")
    @NotBlank(message = "El nombre de usuario no puede estar vacío")
    private String usuario;

    @Column(name = "clave", nullable = false, length = 60)
    private String clave;

    @Column(name = "estadoCuenta", nullable = false)
    @NotBlank(message = "El estado de la cuenta no puede estar vacío")
    private Boolean estadoCuenta;

    @OneToOne
    @JoinColumn(name = "fkIdCargo", nullable = false, referencedColumnName = "idCargo")
    private Cargo cargo;

    @OneToOne(mappedBy = "cuenta")
    private Cliente cliente;

    @OneToOne(mappedBy = "cuenta")
    private Empleado empleado;
    
}
