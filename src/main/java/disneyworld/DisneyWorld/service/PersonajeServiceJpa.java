package disneyworld.DisneyWorld.service;

import disneyworld.DisneyWorld.model.Film;
import disneyworld.DisneyWorld.model.Personaje;
import disneyworld.DisneyWorld.repository.FilmRepository;
import disneyworld.DisneyWorld.repository.PersonajeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.swing.tree.VariableHeightLayoutCache;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class PersonajeServiceJpa implements IPersonajeService{

    @Autowired
    private PersonajeRepository repoPersonaje;

    @Autowired
    private FilmRepository repoFilm;

    @Override
    public Personaje guardar(Personaje personaje) {
        return repoPersonaje.save(personaje);
    }

    @Override
    public void borrar(Long idPersonaje) {
        repoPersonaje.deleteById(idPersonaje);
    }

    @Override
    public List<Personaje> traerPersonajes() {
        return repoPersonaje.findAll();
    }

    @Override
    public List<Personaje> traerPersonajes(String nombre) {
        return repoPersonaje.findAllByNombre(nombre);
    }

    @Override
    public Personaje buscarPorId(Long id) {
        Optional<Personaje> op = repoPersonaje.findById(id);
        return op.orElse(null);
    }

    @Override
    public List<Personaje> buscarExample(Example<Personaje> e, Long idFilm) {
        List<Personaje> personajes = repoPersonaje.findAll(e);
        Optional<Film> op = repoFilm.findById(idFilm);
        Film film = null;

        if(op.isPresent()) {
            film = op.get();
        }
        if(film == null){
            return personajes;
        }

        List<Personaje> personajesReturn = new ArrayList<>();
        for(Personaje personaje : personajes){
            for(Personaje p2 : film.getPersonajes()){
                if(personaje.getId()== p2.getId()){
                    personajesReturn.add(personaje);
                }
            }
        }

        return personajesReturn;
    }
}
