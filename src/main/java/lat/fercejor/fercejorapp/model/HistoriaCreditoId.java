package lat.fercejor.fercejorapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class HistoriaCreditoId implements Serializable {

    @Column(name = "fkIdCliente")
    private Long cliente;

    @Column(name = "fkIdEmpleadoAdministradorCredito")
    private Long empleado;
    
}
