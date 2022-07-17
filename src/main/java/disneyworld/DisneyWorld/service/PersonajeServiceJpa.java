package disneyworld.DisneyWorld.service;

import disneyworld.DisneyWorld.model.Personaje;
import disneyworld.DisneyWorld.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class PersonajeServiceJpa implements IPersonajeService{

    @Autowired
    private PersonajeRepository repoPersonaje;

    @Override
    public Personaje guardar(Personaje personaje) {
        return null;
    }

    @Override
    public void borrar(Long idPersonaje) {

    }
}
