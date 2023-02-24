package lat.fercejor.fercejorapp.controller.Dashboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lat.fercejor.fercejorapp.config.SecurityBeans;
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
    private SecurityBeans securityBeans;

    @Autowired
    public EmpleadosController(CargoService cargoService, CuentaService cuentaService, EmpleadoService empleadoService, SecurityBeans securityBeans) {
        this.cargoService = cargoService;
        this.cuentaService = cuentaService;
        this.empleadoService = empleadoService;
        this.securityBeans = securityBeans;
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
            @RequestParam("claveRepetida") @NotEmpty @Size(min = 8, max = 15) String claveRepetida,
            @RequestParam("idCargo") Long idCargo,
            Model model) {
        if (resultEmpleado.hasErrors() || resultCuenta.hasErrors() || idCargo == 0 || !cuenta.getClave().equals(claveRepetida)) {
            List<Cargo> cargos = cargoService.obtenerTodosLosCargos();
            cargos.remove(0);
            cargos.remove(0);

            List<ObjectError> errors = new ArrayList<>();
            if (idCargo == 0) {
                errors.add(new ObjectError("idCargo", "Debe seleccionar un cargo"));
            }
            if (!cuenta.getClave().equals(claveRepetida)) {
                errors.add(new ObjectError("claveRepetida", "Las claves no coinciden"));
            }
            errors.addAll(resultEmpleado.getAllErrors());
            errors.addAll(resultCuenta.getAllErrors());

            model.addAttribute("errors", errors);
            model.addAttribute("cargos", cargos);
            model.addAttribute("cuenta", cuenta);
            model.addAttribute("empleado", empleado);

            return "dashboard/empleados/crear";
        }

        Optional<Cargo> cargo = cargoService.obtenerCargoPorId(idCargo);
        if (cargo.isPresent()) {
            cuenta.setCargo(cargo.get());
            cuenta.setClave(securityBeans.passwordEncoder().encode(cuenta.getClave()));
            Cuenta cuentaCreada = cuentaService.crearCuenta(cuenta);
            empleado.setCuenta(cuentaCreada);
            empleadoService.crearEmpleado(empleado);
        }

        return "redirect:/dashboard/empleados";
    }

    @GetMapping("/editar/{id}")
    public String empleadosEditar(@PathVariable Long id, Model model) {
        Optional<Empleado> empleado = empleadoService.obtenerEmpleadoPorId(id);
        if (empleado.isPresent()) {
            List<Cargo> cargos = cargoService.obtenerTodosLosCargos();
            cargos.remove(0);
            cargos.remove(0);

            model.addAttribute("cargos", cargos);
            model.addAttribute("cuenta", empleado.get().getCuenta());
            model.addAttribute("empleado", empleado.get());

            return "dashboard/empleados/editar";
        }

        return "redirect:/dashboard/empleados";
    }

    @PostMapping("/editar/{id}")
    public String empleadosEditar(
            @PathVariable Long id,
            @Valid @ModelAttribute("cuenta") Cuenta cuenta, BindingResult resultCuenta,
            @Valid @ModelAttribute("empleado") Empleado empleado, BindingResult resultEmpleado,
            @RequestParam("idCargo") Long idCargo,
            Model model) {
        if (resultEmpleado.hasErrors() || resultCuenta.hasErrors() || idCargo == 0) {
            List<Cargo> cargos = cargoService.obtenerTodosLosCargos();
            cargos.remove(0);
            cargos.remove(0);

            Cuenta cuentaAntigua = cuentaService.obtenerCuentaPorId(cuenta.getId()).get();

            List<ObjectError> errors = new ArrayList<>();
            if (idCargo == 0) {
                errors.add(new ObjectError("idCargo", "Debe seleccionar un cargo"));
            }
            errors.addAll(resultEmpleado.getAllErrors());
            errors.addAll(resultCuenta.getAllErrors());

            model.addAttribute("errors", errors);
            model.addAttribute("cargos", cargos);
            model.addAttribute("cuenta", cuentaAntigua);
            model.addAttribute("empleado", empleado);

            return "dashboard/empleados/editar";
        }

        Optional<Cargo> cargo = cargoService.obtenerCargoPorId(idCargo);
        Optional<Cuenta> cuentaAntigua = cuentaService.obtenerCuentaPorId(cuenta.getId());
        cuentaAntigua.get().setCargo(cargo.get());
        cuentaAntigua.get().setEstadoCuenta(cuenta.isEstadoCuenta());
        Cuenta cuentaActualizada = cuentaService.actualizarCuenta(cuentaAntigua.get());

        empleado.setCuenta(cuentaActualizada);
        empleadoService.actualizarEmpleado(empleado);
        // if (cargo.get().getId() != empleado.getCuenta().getCargo().getId()) {
        //     Cuenta cuenta = empleado.getCuenta();
        //     cuenta.setCargo(cargo.get());
        //     empleado.setCuenta(cuenta);
        //     cuentaService.actualizarCuenta(cuenta);
        // }

        // Empleado empleadoActualizado = empleadoService.actualizarEmpleado(empleado);

        // System.out.println("Cargo id" + cargo.get().getId());
        // System.out.println(cuenta.get().getUsuario());

        return "redirect:/dashboard/empleados";
    }
    
}
