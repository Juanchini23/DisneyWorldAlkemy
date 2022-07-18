package disneyworld.DisneyWorld.model;

import javax.persistence.*;
import java.util.List;

@Entity // indica que esta clase es una entidad osea una tabla
@Table(name="personaje") // hace referencia a la tabla de sql
public class Personaje {

    @Id //con estos dos hace que el id sea auto_increment
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String imagen;
    private String nombre;
    private Integer edad;
    private Integer peso;
    private String historia;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "participacion", // nombre de la entidad que se genera, importa el orden de los join
            joinColumns = @JoinColumn(name = "idPersonaje"), // aca ambas claves foraneas
            inverseJoinColumns = @JoinColumn(name = "idFilm"))
    private List<Film> peliculas;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public List<Film> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<Film> peliculas) {
        this.peliculas = peliculas;
    }
}
