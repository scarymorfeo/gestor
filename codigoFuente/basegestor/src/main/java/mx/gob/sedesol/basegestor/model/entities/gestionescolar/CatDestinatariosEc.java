package mx.gob.sedesol.basegestor.model.entities.gestionescolar;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the cat_destinatarios_ec database table.
 * 
 */
@Entity
@Table(name="cat_destinatarios_ec")
public class CatDestinatariosEc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Integer activo;

	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_actualizacion")
	private Date fechaActualizacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_registro")
	private Date fechaRegistro;

	private String nombre;

	private Integer orden;

	@Column(name="usuario_modifico")
	private Long usuarioModifico;

	public CatDestinatariosEc() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getActivo() {
		return this.activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaActualizacion() {
		return this.fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public Date getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getOrden() {
		return this.orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public Long getUsuarioModifico() {
		return this.usuarioModifico;
	}

	public void setUsuarioModifico(Long usuarioModifico) {
		this.usuarioModifico = usuarioModifico;
	}

}