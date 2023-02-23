package lat.fercejor.fercejorapp.api;

import java.util.List;
import java.util.Optional;

import lat.fercejor.fercejorapp.model.Empleado;

public interface EmpleadoServiceAPI {

    List<Empleado> obtenerTodosLosEmpleados();
    Optional<Empleado> obtenerEmpleadoPorId(Long id);
    Empleado crearEmpleado(Empleado empleado);
    void eliminarEmpleado(Long id);
    Empleado actualizarEmpleado(Empleado empleado);
    
}
