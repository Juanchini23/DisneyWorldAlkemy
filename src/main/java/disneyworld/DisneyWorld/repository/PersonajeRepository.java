package disneyworld.DisneyWorld.repository;

import disneyworld.DisneyWorld.model.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonajeRepository extends JpaRepository<Personaje,Long> {
}
