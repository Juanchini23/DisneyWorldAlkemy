package disneyworld.DisneyWorld.controller;

import disneyworld.DisneyWorld.model.Perfil;
import disneyworld.DisneyWorld.model.Usuario;
import disneyworld.DisneyWorld.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

@Controller
public class UsuarioController {


    @Autowired
    private IUsuarioService serviceUser;


    @GetMapping("/signup")
    public String registrarse(Usuario usuario) {
        return "formRegistro";
    }

    @PostMapping("/signup")
    public String guardarRegistro(Usuario usuario, RedirectAttributes attributes) {

        usuario.setEstatus(1); // Activado por defecto
        Perfil perfil = new Perfil();
        perfil.setId(3); // Perfil USUARIO
        usuario.agregar(perfil);
        serviceUser.guardar(usuario);
        attributes.addFlashAttribute("msg", "Usuario guardado");
        return "redirect:/";
    }
}
