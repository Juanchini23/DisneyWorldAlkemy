package disneyworld.DisneyWorld.service;

import disneyworld.DisneyWorld.model.Genero;
import disneyworld.DisneyWorld.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Primary
public class GeneroServiceJpa implements IGeneroService{

    @Autowired
    private GeneroRepository repoGenero;

    @Override
    public void guardar(Genero genero) {
        repoGenero.save(genero);
    }

    @Override
    public List<Genero> traerGeneros() {
        return repoGenero.findAll();
    }
}
