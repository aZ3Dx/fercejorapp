package lat.fercejor.fercejorapp.controller.Dashboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lat.fercejor.fercejorapp.model.Cliente;
import lat.fercejor.fercejorapp.service.ClienteService;

@PreAuthorize("hasAuthority('Desarrollador')")
@Controller
@RequestMapping("/dashboard/clientes")
public class ClientesController {

    @Autowired
    private ClienteService clienteService;

    @RequestMapping("")
    public String clientesInicio(Model model) {
        List<Cliente> clientes = clienteService.obtenerTodosLosClientes();

        model.addAttribute("clientes", clientes);

        return "dashboard/clientes/inicio";
    }
    
}
