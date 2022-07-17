package disneyworld.DisneyWorld.model;

import javax.persistence.*;
import java.util.Date;

@Entity // indica que esta clase es una entidad osea una tabla
@Table(name="film") // hace referencia a la tabla de sql
public class Film {

    @Id //con estos dos hace que el id sea auto_increment
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String imagen;
    private String titulo;
    private Date fechaCreacion;
    private Integer calificaicon;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idGenero")
    private Genero genero;

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

    public Integer getCalificaicon() {
        return calificaicon;
    }

    public void setCalificaicon(Integer calificaicon) {
        this.calificaicon = calificaicon;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
