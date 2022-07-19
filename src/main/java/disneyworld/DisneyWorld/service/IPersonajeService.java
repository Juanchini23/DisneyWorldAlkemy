package disneyworld.DisneyWorld.service;

import disneyworld.DisneyWorld.model.Personaje;

import java.util.*;

public interface IPersonajeService {

    Personaje guardar(Personaje personaje);
    void borrar(Long idPersonaje);

    List<Personaje> traerPersonajes();
    Personaje buscarPorId(Long id);
}
