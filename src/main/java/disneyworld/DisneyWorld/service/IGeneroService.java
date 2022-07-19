package disneyworld.DisneyWorld.service;

import disneyworld.DisneyWorld.model.Genero;

import java.util.*;

public interface IGeneroService {

    void guardar(Genero genero);
    List<Genero> traerGeneros();
}
