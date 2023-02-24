package lat.fercejor.fercejorapp.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cargos")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCargo")
    private Long id;

    @Column(name = "nombreCargo", nullable = false, unique = true, length = 15)
    @Size(max = 15, message = "El nombre del cargo no puede tener más de 15 caracteres")
    @NotBlank(message = "El nombre del cargo no puede estar vacío")
    private String nombreCargo;

    @Column(name = "descripcionCargo", length = 50)
    @Size(max = 50, message = "La descripción del cargo no puede tener más de 50 caracteres")
    @Pattern(regexp = "^(?!\\s*$).+", message = "La descripción del cargo no puede estar vacía")
    private String descripcionCargo;

    @Column(name = "estadoCargo", nullable = false)
    @NotNull(message = "El estado del cargo no puede estar vacío")
    private boolean estadoCargo;

    @OneToMany(mappedBy = "cargo")
    private List<Cuenta> cuentas;
    
}
