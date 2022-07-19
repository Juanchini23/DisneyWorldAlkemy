package disneyworld.DisneyWorld.controller;

import disneyworld.DisneyWorld.model.Genero;
import disneyworld.DisneyWorld.service.IGeneroService;
import disneyworld.DisneyWorld.util.Utileria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/genero")
public class GeneroController {

    @Value("${disneyworld.ruta.imagenes}")
    private String ruta;

    @Autowired
    private IGeneroService serviceGenero;

    @GetMapping("/")
    public String homeGenero(Genero genero, Model model){
        model.addAttribute("generos", serviceGenero.traerGeneros());
        return "genero/indexGenero";
    }

    @PostMapping("/guardar")
    private String guardar(Genero genero,
                           @RequestParam("foto") MultipartFile multipartFile,
                           BindingResult result,
                           RedirectAttributes attributes){

        if(result.hasErrors()) {
            for (ObjectError error: result.getAllErrors()){
                System.out.println("Ocurrio un error: " + error.getDefaultMessage());
            }
            return "genero/indexGenero";
        }

        if (!multipartFile.isEmpty()) {
            String nombreImagen = Utileria.guardarArchivo(multipartFile, ruta);
            if (nombreImagen != null){ // La imagen si se subio
                genero.setImagen(nombreImagen);
            }
        }

        attributes.addFlashAttribute("msg", "Genero guardado correctamente");
        serviceGenero.guardar(genero);

        return "redirect:/genero/";
    }
}
