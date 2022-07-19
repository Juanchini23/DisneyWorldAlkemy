package disneyworld.DisneyWorld.service;

import disneyworld.DisneyWorld.model.Personaje;
import disneyworld.DisneyWorld.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.swing.tree.VariableHeightLayoutCache;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class PersonajeServiceJpa implements IPersonajeService{

    @Autowired
    private PersonajeRepository repoPersonaje;

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
    public Personaje buscarPorId(Long id) {
        Optional<Personaje> op = repoPersonaje.findById(id);
        return op.orElse(null);
    }
}
