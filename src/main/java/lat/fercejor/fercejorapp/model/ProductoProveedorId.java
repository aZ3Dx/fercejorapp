package lat.fercejor.fercejorapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class ProductoProveedorId implements Serializable {

    @Column(name = "fkIdProductoSuministro")
    private Long producto;

    @Column(name = "fkIdProveedor")
    private Long proveedor;
    
}
