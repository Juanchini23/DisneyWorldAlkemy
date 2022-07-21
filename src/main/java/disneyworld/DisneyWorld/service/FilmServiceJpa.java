package disneyworld.DisneyWorld.service;

import disneyworld.DisneyWorld.model.Film;
import disneyworld.DisneyWorld.model.Personaje;
import disneyworld.DisneyWorld.repository.FilmRepository;
import disneyworld.DisneyWorld.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class FilmServiceJpa implements IFilmService{

    @Autowired
    private FilmRepository repoFilm;

    @Autowired
    private PersonajeRepository repoPersonaje;

    @Override
    public void guardar(Film film) {
        repoFilm.save(film);
    }

    @Override
    public List<Film> traerFilms() {
        return repoFilm.findAll();
    }

    @Override
    public List<Film> traerFilms(String titulo) {
        return repoFilm.findAllByTitulo(titulo);
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

    @Override
    public List<Personaje> traerFaltantes(Long idFilm) {

        List<Personaje> personajesPosesion = repoFilm.findById(idFilm).get().getPersonajes();
        List<Personaje> personajes = repoPersonaje.findAll();

        personajes.removeAll(personajesPosesion);

        return personajes;
    }

    @Override
    public void agregarPersonaje(Long idFilm, Long idPersonaje) {
        Film film = repoFilm.findById(idFilm).get();
        Personaje pj = repoPersonaje.findById(idPersonaje).get();

        film.getPersonajes().add(pj);

        repoFilm.save(film);
    }

    @Override
    public void eliminarPersonaje(Long idFilm, Long idPersonaje) {
        Film film = repoFilm.findById(idFilm).get();
        Personaje pj = repoPersonaje.findById(idPersonaje).get();

        film.getPersonajes().remove(pj);
        repoFilm.save(film);
    }

    @Override
    public List<Film> buscarExample(Example<Film> e) {
        return repoFilm.findAll(e);
    }
}
