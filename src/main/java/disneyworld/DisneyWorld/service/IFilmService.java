package disneyworld.DisneyWorld.service;

import disneyworld.DisneyWorld.model.Film;

import java.util.List;

public interface IFilmService {

    void guardar(Film film);
    List<Film> traerFilms();
}
