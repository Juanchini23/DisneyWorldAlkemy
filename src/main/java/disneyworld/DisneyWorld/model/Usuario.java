package disneyworld.DisneyWorld.model;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "Usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String nombre;
    private String email;
    private String password;
    private Integer estatus;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "UsuarioPerfil", // nombre de la entidad que se genera, importa el orden de los join
            joinColumns = @JoinColumn(name = "idUsuario"), // aca ambas claves foraneas
            inverseJoinColumns = @JoinColumn(name = "idPerfil"))
    private List<Perfil> perfiles;

    public void agregar(Perfil perfil) {
        if (perfiles == null) {
            perfiles = new LinkedList<>();

        }
        perfiles.add(perfil);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }


}