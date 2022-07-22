package disneyworld.DisneyWorld.repository;

import disneyworld.DisneyWorld.model.Personaje;
import disneyworld.DisneyWorld.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
