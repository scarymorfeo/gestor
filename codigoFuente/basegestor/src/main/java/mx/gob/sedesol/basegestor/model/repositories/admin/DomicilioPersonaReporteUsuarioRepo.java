package mx.gob.sedesol.basegestor.model.repositories.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import mx.gob.sedesol.basegestor.model.entities.admin.TblDomiciliosPersonaReporteUsuario;

@Repository
public interface DomicilioPersonaReporteUsuarioRepo
		extends JpaRepository<TblDomiciliosPersonaReporteUsuario, Long>, JpaSpecificationExecutor<TblDomiciliosPersonaReporteUsuario> {


}
