package mx.gob.sedesol.basegestor.commons.dto.gestion.aprendizaje;

import java.io.Serializable;
import java.util.Date;

public class EventoConstanciaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String modalidad;
	private String nombreEc;
	private Date fecha;
	private Integer tipoConstancia;
	private String nombreConstancia;
	private String nombreEstatusEncuesta;
	
	private String nombreAcreditado;
	private String calificacion;
	private String nombrePrograma;
	private String direccion;
	private String duracionHrs;
	private String directorGral;
	
	private Double calificacionTotal;
	private Double calificacionFinal;
	private Integer porcentajeAsistencia;
	
	public EventoConstanciaDTO(){
		tipoConstancia = 0;
	}
	public String getNombreConstancia() {
		return nombreConstancia;
	}
	public void setNombreConstancia(String nombreConstancia) {
		this.nombreConstancia = nombreConstancia;
	}
	public String getNombreEstatusEncuesta() {
		return nombreEstatusEncuesta;
	}
	public void setNombreEstatusEncuesta(String nombreEstatusEncuesta) {
		this.nombreEstatusEncuesta = nombreEstatusEncuesta;
	}
	public String getModalidad() {
		return modalidad;
	}
	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}
	public String getNombreEc() {
		return nombreEc;
	}
	public void setNombreEc(String nombreEc) {
		this.nombreEc = nombreEc;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Integer getTipoConstancia() {
		return tipoConstancia;
	}
	public void setTipoConstancia(Integer tipoConstancia) {
		this.tipoConstancia = tipoConstancia;
	}
	public String getNombreAcreditado() {
		return nombreAcreditado;
	}
	public void setNombreAcreditado(String nombreAcreditado) {
		this.nombreAcreditado = nombreAcreditado;
	}
	public String getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}
	public String getNombrePrograma() {
		return nombrePrograma;
	}
	public void setNombrePrograma(String nombrePrograma) {
		this.nombrePrograma = nombrePrograma;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDuracionHrs() {
		return duracionHrs;
	}
	public void setDuracionHrs(String duracionHrs) {
		this.duracionHrs = duracionHrs;
	}
	public String getDirectorGral() {
		return directorGral;
	}
	public void setDirectorGral(String directorGral) {
		this.directorGral = directorGral;
	}
	
	public Double getCalificacionTotal() {
		return calificacionTotal;
	}
	public void setCalificacionTotal(Double calificacionTotal) {
		this.calificacionTotal = calificacionTotal;
	}
	public Double getCalificacionFinal() {
		return calificacionFinal;
	}
	public void setCalificacionFinal(Double calificacionFinal) {
		this.calificacionFinal = calificacionFinal;
	}
	public Integer getPorcentajeAsistencia() {
		return porcentajeAsistencia;
	}
	public void setPorcentajeAsistencia(Integer porcentajeAsistencia) {
		this.porcentajeAsistencia = porcentajeAsistencia;
	}

}
