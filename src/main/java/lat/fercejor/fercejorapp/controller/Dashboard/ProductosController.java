package lat.fercejor.fercejorapp.controller.Dashboard;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

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

import lat.fercejor.fercejorapp.model.Categoria;
import lat.fercejor.fercejorapp.model.Producto;
import lat.fercejor.fercejorapp.service.CategoriaService;
import lat.fercejor.fercejorapp.service.ProductoService;

@PreAuthorize("hasAuthority('Desarrollador')")
@Controller
@RequestMapping("/dashboard/productos")
public class ProductosController {

    private ProductoService productoService;
    private CategoriaService categoriaService;

    @Autowired
    public ProductosController(ProductoService productoService, CategoriaService categoriaService) {
        this.productoService = productoService;
        this.categoriaService = categoriaService;
    }

    @GetMapping("")
    public String productosInicio(Model model) {
        List<Producto> productos = productoService.obtenerTodosLosProductos();

        model.addAttribute("productos", productos);

        return "dashboard/productos/inicio";
    }

    @GetMapping("/crear")
    public String productosCrear(Model model) {
        List<Categoria> categorias = categoriaService.obtenerTodasLasCategorias();
        model.addAttribute("categorias", categorias);

        Producto producto = new Producto();
        producto.setExistencias(0);
        producto.setGarantia(true);
        model.addAttribute("producto", producto);

        return "dashboard/productos/crear";
    }

    @PostMapping("/crear")
    public String productosGuardar(
            @Valid Producto producto, BindingResult resultProducto,
            @RequestParam("idCategoria") Long idCategoria,
            Model model) {
        if (resultProducto.hasErrors() || idCategoria == 0) {
            List<Categoria> categorias = categoriaService.obtenerTodasLasCategorias();
            model.addAttribute("categorias", categorias);

            List<ObjectError> errors = new ArrayList<>();
            errors.addAll(resultProducto.getAllErrors());
            if (idCategoria == 0) {
                errors.add(new ObjectError("idCategoria", "Debe seleccionar una categoría"));
            }

            model.addAttribute("errors", errors);
            model.addAttribute("producto", producto);

            return "dashboard/productos/crear";
        }

        Categoria categoriaDelProducto = categoriaService.obtenerCategoriaPorId(idCategoria).orElse(null);
        producto.setCategoria(categoriaDelProducto);

        productoService.crearProducto(producto);

        return "redirect:/dashboard/productos";
    }

    @GetMapping("/editar/{id}")
    public String productosEditar(@PathVariable("id") Long id, Model model) {
        List<Categoria> categorias = categoriaService.obtenerTodasLasCategorias();
        model.addAttribute("categorias", categorias);

        Producto producto = productoService.obtenerProductoPorId(id).orElse(null);
        model.addAttribute("producto", producto);

        Categoria categoriaDelProducto = producto.getCategoria();
        model.addAttribute("categoriaDelProducto", categoriaDelProducto);

        return "dashboard/productos/editar";
    }

    @PostMapping("/editar/{id}")
    public String productosActualizar(
        @PathVariable("id") Long id,
        @Valid Producto producto, BindingResult resultProducto,
        Categoria categoriaDelProducto,
        Model model
    ) {
        if (resultProducto.hasErrors()) {
            List<Categoria> categorias = categoriaService.obtenerTodasLasCategorias();
            model.addAttribute("categorias", categorias);

            List<ObjectError> errors = new ArrayList<>();
            errors.addAll(resultProducto.getAllErrors());

            model.addAttribute("errors", errors);
            model.addAttribute("producto", producto);
            model.addAttribute("categoriaDelProducto", categoriaDelProducto);

            return "dashboard/productos/editar";
        }

        Categoria categoriaNueva = categoriaService.obtenerCategoriaPorId(categoriaDelProducto.getId()).orElse(null);

        producto.setCategoria(categoriaNueva);

        System.out.println(producto);
        // productoService.actualizarProducto(producto);

        return "redirect:/dashboard/productos";
    }

}
