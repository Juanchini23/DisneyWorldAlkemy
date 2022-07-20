package disneyworld.DisneyWorld.service;

import disneyworld.DisneyWorld.model.Film;
import disneyworld.DisneyWorld.model.Personaje;
import disneyworld.DisneyWorld.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Film traerFilmId(Long id) {
        Optional<Film> op = repoFilm.findById(id);
        return op.orElse(null);
    }

    @Override
    public List<Film> buscarFilmPersonaje(Long idPersonaje) {
        List<Film> filmsReturn = new ArrayList<Film>();
        List<Film> pelis = repoFilm.findAll();

        for (Film film : pelis){
            for(Personaje p : film.getPersonajes()){
                if(p.getId() == idPersonaje){
                    filmsReturn.add(film);
                    break;
                }
            }
        }

        return filmsReturn;
    }

    @Override
    public void borrar(Long id) {
        repoFilm.deleteById(id);
    }
}
