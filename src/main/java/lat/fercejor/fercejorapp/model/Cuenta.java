package lat.fercejor.fercejorapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
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
    @Size(min = 8, message = "La clave debe tener al menos 8 caracteres")
    @NotBlank(message = "La clave no puede estar vacía")
    private String clave;

    @Column(name = "estadoCuenta", nullable = false)
    @NotNull(message = "El estado de la cuenta no puede estar vacío")
    private boolean estadoCuenta;

    @ManyToOne
    @JoinColumn(name = "fkIdCargo", nullable = false, referencedColumnName = "idCargo")
    private Cargo cargo;

    @OneToOne(mappedBy = "cuenta")
    private Cliente cliente;

    @OneToOne(mappedBy = "cuenta")
    private Empleado empleado;

    // To String
    @Override
    public String toString() {
        if (this.cliente != null && this.cliente.getCuenta() != this) {
            return "Cuenta{" +
                    "id=" + id +
                    ", usuario='" + usuario + '\'' +
                    ", clave='" + clave + '\'' +
                    ", estadoCuenta=" + estadoCuenta +
                    ", cargo=" + cargo.getNombreCargo() +
                    ", cliente=" + cliente +
                    ", empleado=" + empleado +
                    '}';
        } else {
            return "Cuenta{" +
                    "id=" + id +
                    ", usuario='" + usuario + '\'' +
                    ", clave='" + clave + '\'' +
                    ", estadoCuenta=" + estadoCuenta +
                    ", cargo=" + cargo.getNombreCargo() +
                    ", cliente=<circular reference>" +
                    ", empleado=" + empleado +
                    '}';
        }
    }

}
