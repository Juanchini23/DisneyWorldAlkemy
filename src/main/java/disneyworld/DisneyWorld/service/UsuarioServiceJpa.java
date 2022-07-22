package disneyworld.DisneyWorld.service;

import disneyworld.DisneyWorld.model.Usuario;
import disneyworld.DisneyWorld.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class UsuarioServiceJpa implements IUsuarioService{

    @Autowired
    private UsuarioRepository repoUsuario;

    @Override
    public void guardar(Usuario usuario) {
        repoUsuario.save(usuario);
    }
}
