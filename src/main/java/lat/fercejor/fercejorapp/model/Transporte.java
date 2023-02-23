package lat.fercejor.fercejorapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "transportes")
public class Transporte {

    @Id
    @Column(name = "idTransporte")
    private Long id;
    
    @Column(name = "tipoTransporte", nullable = false, length = 15)
    @Size(max = 15, message = "El tipo de transporte no puede tener más de 15 caracteres")
    @NotBlank(message = "El tipo de transporte no puede estar vacío")
    private String tipoTransporte;
    
    @Column(name = "modelo", nullable = false, length = 15)
    @Size(max = 15, message = "El modelo del transporte no puede tener más de 15 caracteres")
    @NotBlank(message = "El modelo del transporte no puede estar vacío")
    private String modelo;
    
    @Column(name = "marcaTransporte", nullable = false, length = 15)
    @Size(max = 15, message = "La marca del transporte no puede tener más de 15 caracteres")
    @NotBlank(message = "La marca del transporte no puede estar vacío")
    private String marcaTransporte;
    
    @Column(name = "serie", length = 15)
    @Size(max = 15, message = "La serie del transporte no puede tener más de 15 caracteres")
    private String serie;
    
    @Column(name = "estadoTransporte", nullable = false)
    @NotBlank(message = "El estado del transporte no puede estar vacío")
    private Boolean estadoTransporte;
    
    @ManyToOne
    @JoinColumn(name = "fkIdEmpleadoConductor", referencedColumnName = "idEmpleado")
    private Empleado empleado;

    @OneToOne(mappedBy = "transporte")
    private HojaRuta hojaRuta;
    
}
