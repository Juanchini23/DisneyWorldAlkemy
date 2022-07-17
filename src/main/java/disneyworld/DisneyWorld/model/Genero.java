package disneyworld.DisneyWorld.model;

import javax.persistence.*;

@Entity // indica que esta clase es una entidad osea una tabla
@Table(name="genero") // hace referencia a la tabla de sql
public class Genero {

    @Id //con estos dos hace que el id sea auto_increment
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String imagen;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
