package disneyworld.DisneyWorld.service;

import disneyworld.DisneyWorld.model.Film;
import disneyworld.DisneyWorld.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class FilmServiceJpa implements IFilmService{

    @Autowired
    private FilmRepository repoFilm;

    @Override
    public void guardar(Film film) {
        repoFilm.save(film);
    }

    @Override
    public List<Film> traerFilms() {
        return repoFilm.findAll();
    }
}
