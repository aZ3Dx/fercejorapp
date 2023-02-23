package lat.fercejor.fercejorapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tiposComprobante")
public class TipoComprobante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoComprobante")
    private Long id;

    @Column(name = "nombreTipoComprobante", nullable = false, unique = true, length = 15)
    @Size(max = 15, message = "El nombre del tipo de comprobante no puede tener más de 15 caracteres")
    @NotBlank(message = "El nombre del tipo de comprobante no puede estar vacío")
    private String nombreTipoComprobante;

    @OneToOne(mappedBy = "tipoComprobante")
    private ComprobantePago comprobantePago;
    
}
