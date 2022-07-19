package disneyworld.DisneyWorld.repository;

import disneyworld.DisneyWorld.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film,Long> {
}
