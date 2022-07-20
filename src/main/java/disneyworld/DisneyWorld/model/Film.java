package disneyworld.DisneyWorld.model;

import javax.persistence.*;
import java.util.Date;
import java.util.*;

@Entity // indica que esta clase es una entidad osea una tabla
@Table(name="film") // hace referencia a la tabla de sql
public class Film {

    @Id //con estos dos hace que el id sea auto_increment
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String imagen;
    private String titulo;
    private Date fechaCreacion;
    private Integer calificacion;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idGenero")
    private Genero genero;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "participaciones", // nombre de la entidad que se genera, importa el orden de los join
            joinColumns = @JoinColumn(name = "idFilm"), // aca ambas claves foraneas
            inverseJoinColumns = @JoinColumn(name = "idPersonaje"))
    private List<Personaje> personajes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificaicon) {
        this.calificacion = calificaicon;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public List<Personaje> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(List<Personaje> personajes) {
        this.personajes = personajes;
    }
}
