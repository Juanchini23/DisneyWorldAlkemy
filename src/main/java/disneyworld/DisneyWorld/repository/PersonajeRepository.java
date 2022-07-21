package disneyworld.DisneyWorld.repository;

import disneyworld.DisneyWorld.model.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonajeRepository extends JpaRepository<Personaje,Long> {
    List<Personaje> findAllByNombre(String nombre);
}
