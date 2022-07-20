package disneyworld.DisneyWorld.controller;

import disneyworld.DisneyWorld.model.Film;
import disneyworld.DisneyWorld.model.Personaje;
import disneyworld.DisneyWorld.service.IFilmService;
import disneyworld.DisneyWorld.service.IGeneroService;
import disneyworld.DisneyWorld.service.IPersonajeService;
import disneyworld.DisneyWorld.util.Utileria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/film")
public class PeliculaController {

    @Value("${disneyworld.ruta.imagenes}")
    private String ruta;

    @Autowired
    private IFilmService serviceFilm;

    @Autowired
    private IGeneroService serviceGenero;

    @Autowired
    private IPersonajeService servicePersonaje;

    @GetMapping("/")
    public String homePelicula(Model model){
        model.addAttribute("films", serviceFilm.traerFilms());
        return "film/indexFilm";
    }

    @GetMapping("/crear")
    public String crearPelicula(Film film, Model model){

        model.addAttribute("generos", serviceGenero.traerGeneros());
        model.addAttribute("personajes", servicePersonaje.traerPersonajes());
        return "film/formFilm";
    }

    @PostMapping("/crear")
    private String guardarPelicula(Film film,
                                   @RequestParam("foto") MultipartFile multipartFile,
                                   BindingResult result,
                                   RedirectAttributes attributes){

        if(result.hasErrors()) {
            for (ObjectError error: result.getAllErrors()){
                System.out.println("Ocurrio un error: " + error.getDefaultMessage());
            }
            return "film/formfilm";
        }

        if (!multipartFile.isEmpty()) {
            String nombreImagen = Utileria.guardarArchivo(multipartFile, ruta);
            if (nombreImagen != null){ // La imagen si se subio
                film.setImagen(nombreImagen);
            }
        }

        serviceFilm.guardar(film);
        attributes.addFlashAttribute("msg", "Film guardado correctamente");

        return "redirect:/film/";
    }

    @GetMapping("/editar/{id}")
    public String editarFilm(@PathVariable("id") Long id, Model model){
        Film f = serviceFilm.traerFilmId(id);
        model.addAttribute("generos", serviceGenero.traerGeneros());
        model.addAttribute("personajes", servicePersonaje.traerPersonajes());
        model.addAttribute("film", f);
        model.addAttribute("noEditable",1);
        return "film/formFilm";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPersonaje(@PathVariable("id") Long id, RedirectAttributes attributes){

        serviceFilm.borrar(id);
        attributes.addFlashAttribute("msg", "Film eliminado con exito");

        return "redirect:/film/";
    }

    @GetMapping("/detalle/{id}")
    public String detallePersonaje(@PathVariable("id") Long id, Model model){
        model.addAttribute("film", serviceFilm.traerFilmId(id));
        return "film/detalle";
    }


    //para el formato de las fechas
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
