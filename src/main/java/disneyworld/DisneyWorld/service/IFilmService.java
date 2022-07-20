package disneyworld.DisneyWorld.service;

import disneyworld.DisneyWorld.model.Film;
import disneyworld.DisneyWorld.model.Personaje;

import java.util.List;

public interface IFilmService {

    void guardar(Film film);
    List<Film> traerFilms();
    Film traerFilmId(Long id);
    List<Film> buscarFilmPersonaje(Long idPersonaje);
    void borrar(Long id);
    List<Personaje> traerFaltantes(Long idFilm);

    void agregarPersonaje(Long idFilm, Long idPersonaje);

    void eliminarPersonaje(Long idFilm, Long idPersonaje);
}
