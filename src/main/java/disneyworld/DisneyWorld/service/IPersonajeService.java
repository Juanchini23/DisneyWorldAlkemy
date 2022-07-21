package disneyworld.DisneyWorld.service;

import disneyworld.DisneyWorld.model.Personaje;
import org.springframework.data.domain.Example;


import java.util.*;

public interface IPersonajeService {

    Personaje guardar(Personaje personaje);
    void borrar(Long idPersonaje);

    List<Personaje> traerPersonajes();
    List<Personaje> traerPersonajes(String nombre);
    Personaje buscarPorId(Long id);
    List<Personaje> buscarExample(Example<Personaje> e, Long idFilm);

}
