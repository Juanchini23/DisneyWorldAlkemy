package disneyworld.DisneyWorld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/personaje")
public class PersonajeController {

    @GetMapping("/")
    public String homePersonaje(){

        return "personaje/indexPersonaje";
    }

    @GetMapping("/crear")
    public String crearPersonaje(){

        return "personaje/formPersonaje";
    }

    @GetMapping("/editar")
    public String editarPersonaje(){

        return "redirect:/personaje/";
    }

    // que sea un path variable ocn el id del personake a borra
    @GetMapping("/eliminar")
    public String eliminarPersonaje(){

        return "redirect:/personaje/";
    }

    // que sea un path variable ocn el id del personake a ver el detalle
    @GetMapping("/detalle")
    public String detallePersonaje(){

        return "redirect:/personaje/";
    }
}
