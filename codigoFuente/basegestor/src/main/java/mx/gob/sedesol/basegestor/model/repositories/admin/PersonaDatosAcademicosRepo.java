package mx.gob.sedesol.basegestor.model.repositories.admin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import mx.gob.sedesol.basegestor.model.entities.admin.RelPersonaDatosAcademico;

@Repository
public interface PersonaDatosAcademicosRepo extends JpaRepository<RelPersonaDatosAcademico, Integer> {

	@Query("SELECT da FROM RelPersonaDatosAcademico da WHERE da.idPersona = ?1")
	List<RelPersonaDatosAcademico> obtenerDatosAcademicosPorIdPersona(Long idPersona);
	
}


