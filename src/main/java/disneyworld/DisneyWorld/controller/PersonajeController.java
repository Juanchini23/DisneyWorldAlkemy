package disneyworld.DisneyWorld.controller;

import disneyworld.DisneyWorld.model.Personaje;
import disneyworld.DisneyWorld.service.IFilmService;
import disneyworld.DisneyWorld.service.IPersonajeService;
import disneyworld.DisneyWorld.util.Utileria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/personaje")
public class PersonajeController {

    @Value("${disneyworld.ruta.imagenes}")
    private String ruta;

    @Autowired
    private IPersonajeService servicePersonaje;

    @Autowired
    private IFilmService serviceFilm;

    @GetMapping("/")
    public String homePersonaje(Personaje personaje, Model model){

        List<Personaje> personajes = servicePersonaje.traerPersonajes();
        model.addAttribute("films", serviceFilm.traerFilms());
        model.addAttribute("personajes", personajes);
        return "personaje/indexPersonaje";
    }

    @GetMapping("/buscar")
    public String buscar(@ModelAttribute("personaje") Personaje personaje,
                         @RequestParam(value = "film", required = false) Long idFilm,
                         Model model){
        if (idFilm==null){
            idFilm=0l;
        }
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("nombre", ExampleMatcher.GenericPropertyMatchers.contains());
        Example<Personaje> example = Example.of(personaje, matcher);
        List<Personaje> personajes = servicePersonaje.buscarExample(example, idFilm);
        model.addAttribute("films", serviceFilm.traerFilms());
        model.addAttribute("personajes", personajes);
        return "personaje/indexPersonaje";
    }

    @GetMapping("/crear")
    public String crearPersonaje(Personaje personaje){

        return "personaje/formPersonaje";
    }

    @PostMapping("/crear")
    public String guardarPersonaje(Personaje personaje,
                                   @RequestParam("foto") MultipartFile multipartFile,
                                   BindingResult result,
                                   RedirectAttributes attributes){

        if(result.hasErrors()) {
            for (ObjectError error: result.getAllErrors()){
                System.out.println("Ocurrio un error: " + error.getDefaultMessage());
            }
            return "personaje/formPersonaje";
        }

        if (!multipartFile.isEmpty()) {
            String nombreImagen = Utileria.guardarArchivo(multipartFile, ruta);
            if (nombreImagen != null){ // La imagen si se subio
                personaje.setImagen(nombreImagen);
            }
        }

        System.out.println(personaje);
        servicePersonaje.guardar(personaje);
        attributes.addFlashAttribute("msg", "Personaje guardado correctamente");
        return "redirect:/personaje/";
    }

    @GetMapping("/editar/{id}")
    public String editarPersonaje(@PathVariable("id") Long id, Model model){
        Personaje p = servicePersonaje.buscarPorId(id);
        model.addAttribute("personaje", p);
        return "personaje/formPersonaje";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPersonaje(@PathVariable("id") Long id, RedirectAttributes attributes){
        //ConstraintViolationException excepcion que tira cuando elimino un personaje que esta en una peli
        servicePersonaje.borrar(id);
        attributes.addFlashAttribute("msg", "Personaje eliminado con exito");
        return "redirect:/personaje/";
    }

    @GetMapping("/detalle/{id}")
    public String detallePersonaje(@PathVariable("id") Long id, Model model){
        model.addAttribute("personaje", servicePersonaje.buscarPorId(id));
        model.addAttribute("films", serviceFilm.buscarFilmPersonaje(id));
        return "personaje/detalle";
    }
}
