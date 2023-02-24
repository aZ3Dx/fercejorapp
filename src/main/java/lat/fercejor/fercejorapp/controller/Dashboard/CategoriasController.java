package lat.fercejor.fercejorapp.controller.Dashboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lat.fercejor.fercejorapp.model.Categoria;
import lat.fercejor.fercejorapp.service.CategoriaService;

@PreAuthorize("not hasRole('Cliente')")
@Controller
@RequestMapping("/dashboard/categorias")
public class CategoriasController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("")
    public String categoriasInicio(Model model) {
        List<Categoria> categorias = categoriaService.obtenerTodasLasCategorias();
        model.addAttribute("categorias", categorias);

        return "dashboard/categorias/inicio";
    }

    @GetMapping("/crear")
    public String categoriasCrear(Model model) {
        Categoria categoria = new Categoria();
        categoria.setEstadoCategoria(true);

        model.addAttribute("categoria", categoria);

        return "dashboard/categorias/crear";
    }

    @PostMapping("/crear")
    public String categoriasGuardar(
            @Valid Categoria categoria, BindingResult resultCategoria, Model model) {
        if (resultCategoria.hasErrors()) {
            List<ObjectError> errors = new ArrayList<>();
            errors.addAll(resultCategoria.getAllErrors());

            model.addAttribute("errors", errors);

            return "dashboard/categorias/crear";
        }

        categoriaService.crearCategoria(categoria);

        return "redirect:/dashboard/categorias";
    }

    @GetMapping("/editar/{id}")
    public String categoriasEditar(@PathVariable Long id, Model model) {
        Optional<Categoria> categoria = categoriaService.obtenerCategoriaPorId(id);

        if (!categoria.isPresent()) {
            return "redirect:/dashboard/categorias";
        }

        model.addAttribute("categoria", categoria.get());

        return "dashboard/categorias/editar";
    }

    @PostMapping("/editar/{id}")
    public String categoriasActualizar(
            @PathVariable Long id, @Valid Categoria categoria, BindingResult resultCategoria, Model model) {
        if (resultCategoria.hasErrors()) {
            List<ObjectError> errors = new ArrayList<>();
            errors.addAll(resultCategoria.getAllErrors());

            model.addAttribute("errors", errors);

            return "dashboard/categorias/editar";
        }

        categoriaService.actualizarCategoria(categoria);

        return "redirect:/dashboard/categorias";
    }

    @GetMapping("/eliminar/{id}")
    public String categoriasEliminar(@PathVariable Long id) {
        categoriaService.eliminarCategoria(id);

        return "redirect:/dashboard/categorias";
    }

}
