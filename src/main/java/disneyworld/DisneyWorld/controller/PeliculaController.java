package disneyworld.DisneyWorld.controller;

import disneyworld.DisneyWorld.model.Film;
import disneyworld.DisneyWorld.service.IFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/film")
public class PeliculaController {

    @Value("${disneyworld.ruta.imagenes}")
    private String ruta;

    @Autowired
    private IFilmService serviceFilm;

    @GetMapping("/")
    public String homePelicula(Model model){
        return "film/indexFilm";
    }

    @GetMapping("/crear")
    public String crearPelicula(Film film){

        return "film/formFilm";
    }

    @PostMapping("/crear")
    private String guardarPelicula(){
        return "redirect:/film/";
    }

    @GetMapping("/editar/{id}")
    public String editarFilm(@PathVariable("id") Long id, Model model){

        return "film/formFilm";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPersonaje(@PathVariable("id") Long id, RedirectAttributes attributes){

        return "redirect:/film/";
    }

    @GetMapping("/detalle/{id}")
    public String detallePersonaje(@PathVariable("id") Long id, Model model){
        return "film/detalle";
    }


    //para el formato de las fechas
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
