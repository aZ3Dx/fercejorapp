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
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "categorias")
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCategoria")
    private Long id;

    @Column(name = "nombreCategoria", nullable = false, unique = true, length = 15)
    @Size(max = 15, message = "El nombre de la categoría no puede tener más de 15 caracteres")
    @NotBlank(message = "El nombre de la categoría no puede estar vacío")
    private String nombreCategoria;

    @Column(name = "descripcionCategoria", nullable = false, length = 200)
    @Size(max = 200, message = "La descripción de la categoría no puede tener más de 200 caracteres")
    @NotBlank(message = "La descripción de la categoría no puede estar vacía")
    private String descripcionCategoria;

    @Column(name = "estadoCategoria", nullable = false)
    @NotNull(message = "El estado de la categoría no puede estar vacío")
    private boolean estadoCategoria;

    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;

}
