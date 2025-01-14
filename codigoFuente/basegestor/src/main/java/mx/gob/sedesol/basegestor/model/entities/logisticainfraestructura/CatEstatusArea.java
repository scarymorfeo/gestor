package mx.gob.sedesol.basegestor.model.entities.logisticainfraestructura;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cat_estatus_area database table.
 * 
 */
@Entity
@Table(name="cat_estatus_area")
@NamedQuery(name="CatEstatusArea.findAll", query="SELECT c FROM CatEstatusArea c")
public class CatEstatusArea implements Serializable {
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

	//bi-directional many-to-one association to CatAreasSede
//	@OneToMany(mappedBy="catEstatusArea")
//	private List<CatAreasSede> catAreasSedes;

	public CatEstatusArea() {
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

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

//	public List<CatAreasSede> getCatAreasSedes() {
//		return this.catAreasSedes;
//	}
//
//	public void setCatAreasSedes(List<CatAreasSede> catAreasSedes) {
//		this.catAreasSedes = catAreasSedes;
//	}
//
//	public CatAreasSede addCatAreasSede(CatAreasSede catAreasSede) {
//		getCatAreasSedes().add(catAreasSede);
//		catAreasSede.setCatEstatusArea(this);
//
//		return catAreasSede;
//	}
//
//	public CatAreasSede removeCatAreasSede(CatAreasSede catAreasSede) {
//		getCatAreasSedes().remove(catAreasSede);
//		catAreasSede.setCatEstatusArea(null);
//
//		return catAreasSede;
//	}

}