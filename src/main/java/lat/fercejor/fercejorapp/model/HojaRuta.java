package lat.fercejor.fercejorapp.model;

import java.time.LocalDate;

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
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "hojasRuta")
public class HojaRuta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHojaRuta")
    private Long id;
    
    @Column(name = "descripcionHojaRuta", nullable = false, length = 200)
    @Size(max = 200, message = "La descripción de la hoja de ruta no puede tener más de 200 caracteres")
    @NotBlank(message = "La descripción de la hoja de ruta no puede estar vacía")
    private String descripcionHojaRuta;
    
    @Column(name = "fechaSalida", nullable = false)
    private LocalDate fechaSalida;
    
    @Column(name = "estadoHojaRuta", nullable = false)
    private Boolean estadoHojaRuta;

    @ManyToOne
    @JoinColumn(name = "fkIdEmpleadoConductor", nullable = false, referencedColumnName = "idEmpleado")
    private Empleado empleado;
    
    @OneToOne
    @JoinColumn(name = "fkIdTransporte", nullable = false, referencedColumnName = "idTransporte")
    private Transporte transporte;
    
    @OneToOne
    @JoinColumn(name = "fkIdPedidoEntregar", nullable = false, referencedColumnName = "idPedido")
    private Pedido pedido;
    
}
