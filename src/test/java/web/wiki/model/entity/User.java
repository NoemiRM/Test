package web.wiki.model.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by PilarRM on 2020-01-18.
 */

@Entity
@Table(name="usuario", schema = "schema_usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int estado_id;

    @Column
    private String usuario;

    @Column
    private String correo;

    @Column
    private String password;

    public User() {
    }

    public User(Long id, int estado_id, String usuario, String correo, String password) {
        this.id = id;
        this.estado_id = estado_id;
        this.usuario = usuario;
        this.correo = correo;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getEstado_id() {
        return estado_id;
    }

    public void setEstado_id(int estado_id) {
        this.estado_id = estado_id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}