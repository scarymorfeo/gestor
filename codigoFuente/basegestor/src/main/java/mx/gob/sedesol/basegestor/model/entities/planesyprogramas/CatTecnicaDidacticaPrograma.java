package mx.gob.sedesol.basegestor.model.entities.planesyprogramas;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cat_tecnicas_didacticas_programa database table.
 * 
 */
@Entity
@Table(name="cat_tecnicas_didacticas_programa")
@NamedQuery(name="CatTecnicasDidacticasPrograma.findAll", query="SELECT c FROM CatTecnicaDidacticaPrograma c")
public class CatTecnicaDidacticaPrograma implements Serializable {
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

	//bi-directional many-to-one association to RelProgramaTecnicasDidactica
//	@OneToMany(mappedBy="catTecnicasDidacticasPrograma")
//	private List<RelProgramaTecnicasDidactica> relProgramaTecnicasDidacticas;

	public CatTecnicaDidacticaPrograma() {
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

	public Integer getOrden() {
		return this.orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public Long getUsuarioModifico() {
		return this.usuarioModifico;
	}

	public void setUsuarioModifico(Long usuarioModifico) {
		this.usuarioModifico = usuarioModifico;
	}


}