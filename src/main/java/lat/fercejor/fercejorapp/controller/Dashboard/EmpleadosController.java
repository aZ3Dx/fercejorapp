package lat.fercejor.fercejorapp.controller.Dashboard;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lat.fercejor.fercejorapp.model.Cargo;
import lat.fercejor.fercejorapp.model.Cuenta;
import lat.fercejor.fercejorapp.model.Empleado;
import lat.fercejor.fercejorapp.service.CargoService;
import lat.fercejor.fercejorapp.service.CuentaService;
import lat.fercejor.fercejorapp.service.EmpleadoService;

@PreAuthorize("hasAuthority('Desarrollador')")
@Controller
@RequestMapping("/dashboard/empleados")
public class EmpleadosController {

    private CargoService cargoService;
    private CuentaService cuentaService;
    private EmpleadoService empleadoService;

    @Autowired
    public EmpleadosController(CargoService cargoService, CuentaService cuentaService, EmpleadoService empleadoService) {
        this.cargoService = cargoService;
        this.cuentaService = cuentaService;
        this.empleadoService = empleadoService;
    }

    @RequestMapping("")
    public String empleadosInicio(Model model) {
        List<Empleado> empleados = empleadoService.obtenerTodosLosEmpleados();
        model.addAttribute("empleados", empleados);
        
        return "dashboard/empleados/inicio";
    }

    @RequestMapping("/crear")
    public String empleadosCrear(Model model) {
        List<Cargo> cargos = cargoService.obtenerTodosLosCargos();
        cargos.remove(0);

        Cuenta cuenta = new Cuenta();
        cuenta.setEstadoCuenta(true);

        Empleado empleado = new Empleado();

        model.addAttribute("cargos", cargos);
        model.addAttribute("cuenta", cuenta);
        model.addAttribute("empleado", empleado);

        return "dashboard/empleados/crear";
    }

    @PostMapping("/crear")
    public String empleadosCrear(
            @Valid @ModelAttribute("empleado") Empleado empleado, BindingResult resultEmpleado,
            @Valid @ModelAttribute("cuenta") Cuenta cuenta, BindingResult resultCuenta,
            @RequestParam("idCargo") Long idCargo,
            Model model) {
        if (resultEmpleado.hasErrors() || resultCuenta.hasErrors()) {
            List<Cargo> cargos = cargoService.obtenerTodosLosCargos();
            cargos.remove(0);

            model.addAttribute("cargos", cargos);
            model.addAttribute("cuenta", cuenta);
            model.addAttribute("empleado", empleado);

            return "dashboard/empleados/crear";
        }

        // empleadoService.crearEmpleado(empleado, cuenta);

        return "redirect:/dashboard/empleados";
    }
    
}
