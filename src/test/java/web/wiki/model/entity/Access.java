package web.wiki.model.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by PilarRM on 2020-01-18.
 */

@Entity
@Table(name = "access",schema = "schema_usuario")
public class Access {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int estado_id;

    @Column
    private Date fecha_creacion;

    @Column
    private String usuario_id;

    @Column
    private String access;

    public Access(Long id, int estado_id, Date current_time, Long userId, String access) {
    }

    public Access(Long id, int estado_id, Date fecha_creacion, String usuario_id, String access) {
        this.id = id;
        this.estado_id = estado_id;
        this.fecha_creacion = fecha_creacion;
        this.usuario_id = usuario_id;
        this.access = access;
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

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public String getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(String usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }
}
