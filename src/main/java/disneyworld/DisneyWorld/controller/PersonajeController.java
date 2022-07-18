package disneyworld.DisneyWorld.controller;

import disneyworld.DisneyWorld.model.Personaje;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/personaje")
public class PersonajeController {

    @GetMapping("/")
    public String homePersonaje(){

        return "personaje/indexPersonaje";
    }

    @GetMapping("/crear")
    public String crearPersonaje(Personaje personaje){

        return "personaje/formPersonaje";
    }

    @PostMapping("/crear")
    public String guardarPersonaje(Personaje personaje, BindingResult result, RedirectAttributes attributes){

        if(result.hasErrors()) {
            for (ObjectError error: result.getAllErrors()){
                System.out.println("Ocurrio un error: " + error.getDefaultMessage());
            }
            return "personaje/formPersonaje";
        }


        System.out.println(personaje);
        attributes.addFlashAttribute("msg", "Personaje creado correctamente");
        return "redirect:/personaje/";
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
