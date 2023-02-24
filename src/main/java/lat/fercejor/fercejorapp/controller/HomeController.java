package lat.fercejor.fercejorapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lat.fercejor.fercejorapp.config.SecurityBeans;
import lat.fercejor.fercejorapp.model.Cargo;
import lat.fercejor.fercejorapp.model.Cliente;
import lat.fercejor.fercejorapp.model.Cuenta;
import lat.fercejor.fercejorapp.service.CargoService;
import lat.fercejor.fercejorapp.service.ClienteService;
import lat.fercejor.fercejorapp.service.CuentaService;

@Controller
public class HomeController {

    @Autowired
    private CuentaService cuentaService;
    @Autowired
    private CargoService cargoService;
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private SecurityBeans securityBeans;

    @GetMapping("/")
    public String inicio() {
        System.out.println("Mostrar inicio");
        return "inicio";
    }

    @GetMapping("/registro")
    public String registroCliente(Model model) {
        System.out.println("Mostrar formulario de registro");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            if (auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("Cliente"))) {
                return "redirect:/";
            }
            return "redirect:/dashboard";
        }

        Cargo cargo = new Cargo();
        cargo = cargoService.obtenerCargoPorNombre("Cliente").get();

        Cuenta cuenta = new Cuenta();
        cuenta.setEstadoCuenta(true);
        cuenta.setCargo(cargo);

        Cliente cliente = new Cliente();
        cliente.setCredito(0.0D);
        cliente.setCuenta(cuenta);

        model.addAttribute("idCargo", cargo.getId());
        model.addAttribute("cuenta", cuenta);
        model.addAttribute("cliente", cliente);

        return "registro";
    }

    @PostMapping("/registro")
    public String registrarCliente(
            @Valid Cuenta cuenta, BindingResult resultCuenta,
            @Valid Cliente cliente, BindingResult resultCliente,
            @RequestParam("claveRepetida") @NotEmpty @Size(min = 8, max = 15) String claveRepetida,
            @RequestParam("idCargo") long idCargo,
            Model model) {
        if (resultCuenta.hasErrors() || resultCliente.hasErrors() || !cuenta.getClave().equals(claveRepetida)) {
            System.out.println("Error en el formulario");
            List<ObjectError> errors = new ArrayList<>();
            errors.addAll(resultCuenta.getAllErrors());
            errors.addAll(resultCliente.getAllErrors());
            if (!cuenta.getClave().equals(claveRepetida)) {
                errors.add(new ObjectError("claveRepetida", "Las claves no coinciden"));
            }
            model.addAttribute("errors", errors);
            model.addAttribute("idCargo", idCargo);
            return "registro";
        }

        System.out.println("Registrar cliente");

        Cargo cargo = cargoService.obtenerCargoPorId(idCargo).get();
        cuenta.setCargo(cargo);
        cuenta.setClave(securityBeans.passwordEncoder().encode(cuenta.getClave()));
        Cuenta cuentaGuardada = cuentaService.crearCuenta(cuenta);
        cliente.setCuenta(cuentaGuardada);
        clienteService.crearCliente(cliente);

        return "redirect:/";
    }

    // @GetMapping("/error")
    // public String error() {
    // return "error";
    // }

}
