package disneyworld.DisneyWorld.service;

import disneyworld.DisneyWorld.model.Personaje;

public interface IPersonajeService {

    Personaje guardar(Personaje personaje);
    void borrar(Long idPersonaje);
}
