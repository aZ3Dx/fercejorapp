package lat.fercejor.fercejorapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lat.fercejor.fercejorapp.api.EmpleadoServiceAPI;
import lat.fercejor.fercejorapp.model.Empleado;
import lat.fercejor.fercejorapp.repository.EmpleadoRepository;

@Service
public class EmpleadoService implements EmpleadoServiceAPI {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> obtenerTodosLosEmpleados() {
        List<Empleado> empleados = empleadoRepository.findAll();
        return empleados;
    }

    @Override
    public Optional<Empleado> obtenerEmpleadoPorId(Long id) {
        Optional<Empleado> empleado = empleadoRepository.findById(id);
        return empleado;
    }

    @Override
    public Empleado crearEmpleado(Empleado empleado) {
        Empleado empleadoCreado = empleadoRepository.save(empleado);
        return empleadoCreado;
    }

    @Override
    public void eliminarEmpleado(Long id) {
        empleadoRepository.deleteById(id);
    }

    @Override
    public Empleado actualizarEmpleado(Empleado empleado) {
        Empleado empleadoActualizado = empleadoRepository.save(empleado);
        return empleadoActualizado;
    }
    
}
