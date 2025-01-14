package mx.gob.sedesol.basegestor.service.gestionescolar;

import java.util.List;
import java.util.Map;

import mx.gob.sedesol.basegestor.commons.dto.admin.ParametroWSMoodleDTO;
import mx.gob.sedesol.basegestor.commons.dto.admin.PersonaDTO;
import mx.gob.sedesol.basegestor.commons.dto.admin.ResultadoDTO;
import mx.gob.sedesol.basegestor.commons.dto.gestion.aprendizaje.ContenedorLogrosDTO;
import mx.gob.sedesol.basegestor.commons.dto.gestion.aprendizaje.EventoConstanciaDTO;
import mx.gob.sedesol.basegestor.commons.dto.gestionescolar.EventoCapacitacionDTO;
import mx.gob.sedesol.basegestor.commons.dto.gestionescolar.GrupoDTO;
import mx.gob.sedesol.basegestor.commons.dto.gestionescolar.RelGrupoParticipanteDTO;

public interface GrupoParticipanteService {
	List<EventoConstanciaDTO> getParticipanteByActaCerradaYconstancia(Long idPersona);
	
	ContenedorLogrosDTO obtenerLogrosPorIdParticipante(Long idPersona);
	
	List<RelGrupoParticipanteDTO> buscarAlumno(Integer idGrupo, String nombre);
	
	List<RelGrupoParticipanteDTO> getParticipantesByGrupo(Integer idGrupo) ;
	
	List<RelGrupoParticipanteDTO> getParticipantesByEvento(Integer idEvento) ;

	RelGrupoParticipanteDTO almacenarParticipante(GrupoDTO grupo, PersonaDTO persona, EventoCapacitacionDTO evento, ParametroWSMoodleDTO parametroWSMoodleDTO);

	ResultadoDTO<RelGrupoParticipanteDTO> eliminarParticipante(RelGrupoParticipanteDTO participante, EventoCapacitacionDTO evento);

	ResultadoDTO<RelGrupoParticipanteDTO> almacenarParticipantes(List<PersonaDTO> listaPersonas, GrupoDTO grupo,
			EventoCapacitacionDTO evento, ParametroWSMoodleDTO parametroWSMoodleDTO);	
	
	Map<String,Long> obtenerParticipantesPorIdEventoCapacitacion(List<Integer> idEventosList);
	
	Map<String,Map<String,String>> obtenerGeneroParticipantesPorIdEventoCapacitacion(List<Integer> idEventosList);
	
    List<RelGrupoParticipanteDTO> obtenerEventosCapacitacionPorIdParticipante(Long idParticipante,Integer idEstatusEc);
    
    List<RelGrupoParticipanteDTO> obtenEvtsEnLineayMixtosPorIdParticipante(Long idParticipante,Integer idEstatusEc);
    
    List<RelGrupoParticipanteDTO> obtenerAlumnosQueRecibieronConstPorIdGrupo(Integer idGrupo) throws Exception;
    
    ResultadoDTO<RelGrupoParticipanteDTO> actualizaRelGrupoParticipante(RelGrupoParticipanteDTO dto);
    
    List<RelGrupoParticipanteDTO> buscarParticipanteEnEvento(Integer idEvento, Long idPersona);

	List<RelGrupoParticipanteDTO> getAlumnosQueRecibieronConstPorIdGrupo(Integer idGrupo) throws Exception;
}



