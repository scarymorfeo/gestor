package mx.gob.sedesol.gestorweb.beans.gestionaprendizaje;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import mx.gob.sedesol.basegestor.commons.constantes.ConstantesBitacora;

import org.apache.log4j.Logger;

import mx.gob.sedesol.basegestor.commons.dto.admin.CatalogoComunDTO;
import mx.gob.sedesol.basegestor.commons.dto.admin.ResultadoDTO;
import mx.gob.sedesol.basegestor.commons.utils.CatGestionAprendizajeEnum;
import mx.gob.sedesol.basegestor.commons.utils.ObjectUtils;
import mx.gob.sedesol.basegestor.springinit.GestionAprendizajeServiceAdapter;
import mx.gob.sedesol.gestorweb.beans.acceso.BaseBean;
import mx.gob.sedesol.gestorweb.commons.constantes.ConstantesGestorWeb;
import mx.gob.sedesol.gestorweb.commons.utils.BitacoraUtil;

@SessionScoped
@ManagedBean
public class CatGestionAprendizajeBean extends BaseBean {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private static final Logger logger = Logger.getLogger(CatGestionAprendizajeBean.class);

    private CatalogoComunDTO catComunDTOGenerico;
    private String nombreCat;
    private String idCat;
    private boolean muestraCompReg;
    private boolean muestraCompTabla;
    private CatGestionAprendizajeEnum catalogoSeleccionado;
    private List<CatalogoComunDTO> lstCatSelec;
    private CatGestionAprendizajeEnum[] catalogosGestionAprendizaje;

    @ManagedProperty(value = "#{gestionAprendizajeServiceAdapter}")
    private GestionAprendizajeServiceAdapter gestionAprendizajeServiceAdapter;

    public CatGestionAprendizajeBean() {
    }

    @PostConstruct
    public void inicializaInstancia() {
        catalogosGestionAprendizaje = CatGestionAprendizajeEnum.values();
    }

    @SuppressWarnings("unchecked")
    public void guardarRegCatalogo() {
        if (ObjectUtils.isNotNull(catalogoSeleccionado)
                && ObjectUtils.isNotNull(catComunDTOGenerico) && !ObjectUtils.isNullOrEmpty(catComunDTOGenerico.getNombre())) {
            try {

                ResultadoDTO<CatalogoComunDTO> res = null;
                if (isMuestraCompTabla() && isMuestraCompReg()) {

                    catComunDTOGenerico.setFechaActualizacion(new Date());
                    catComunDTOGenerico.setUsuarioModifico(getUsuarioEnSession().getIdPersona());
                    catComunDTOGenerico.setNombreUsuarioMod(getUsuarioEnSession().getUsuario());
                    //GUSTAVO --BitacoraUtil.llenarBitacora(catComunDTOGenerico, getUsuarioEnSession(), ConstantesBitacora.CATALOGO_EDITAR, request);
                    res = getGestionAprendizajeServiceAdapter().getCatalogoServiceByGestionAprendizajeEnum(catalogoSeleccionado)
                            .actualizar(catComunDTOGenerico, catalogoSeleccionado.getClassEntidad());

                } else {
                    catComunDTOGenerico.setFechaRegistro(new Date());
                    catComunDTOGenerico.setUsuarioModifico(getUsuarioEnSession().getIdPersona());
                    catComunDTOGenerico.setNombreUsuarioMod(getUsuarioEnSession().getUsuario());
                    //GUSTAVO --BitacoraUtil.llenarBitacora(catComunDTOGenerico, getUsuarioEnSession(), ConstantesBitacora.CATALOGO_AGREGAR, request);
                    res = getGestionAprendizajeServiceAdapter().getCatalogoServiceByGestionAprendizajeEnum(catalogoSeleccionado)
                            .guardar(catComunDTOGenerico, catalogoSeleccionado.getClassEntidad());
                }

                if (ObjectUtils.isNotNull(res) && res.getResultado().getValor()) {
                    agregarMsgInfo("Se guardo el registro exitosamente.", null);
                    //System.out.println();
                } else {
                    agregarMsgError("Ocurrio un error", null);
                    logger.error(res != null ? obtenerErroresDeServicio(res.getMensajes()) : null);
                }

            } catch (Exception e) {
                logger.error(e.getCause(), e);
            }
        }
    }

    /**
     *
     * @param catalogo
     */
    public void generaComponenteReg(CatGestionAprendizajeEnum catalogo) {

        setMuestraCompTabla(Boolean.FALSE);
        if (ObjectUtils.isNotNull(catalogo)) {
            setMuestraCompReg(Boolean.TRUE);
            catalogoSeleccionado = catalogo;
            nombreCat = catalogo.getNombre();
            idCat = catalogo.getId();
            catComunDTOGenerico = new CatalogoComunDTO();

        } else {
            setMuestraCompReg(Boolean.FALSE);
        }
    }

    @SuppressWarnings("unchecked")
    public void obtenerDatosCatSel(CatGestionAprendizajeEnum catalogo) {
        setMuestraCompReg(Boolean.FALSE);
        if (ObjectUtils.isNotNull(catalogo)) {
            setMuestraCompTabla(Boolean.TRUE);
            catalogoSeleccionado = catalogo;
            nombreCat = catalogo.getNombre();
            idCat = catalogo.getId();
            lstCatSelec = getGestionAprendizajeServiceAdapter().getCatalogoServiceByGestionAprendizajeEnum(catalogoSeleccionado)
                    .findAll(catalogoSeleccionado.getClassEntidad());
        } else {
            setMuestraCompTabla(Boolean.FALSE);
            lstCatSelec = new ArrayList<>();
        }
    }

    @SuppressWarnings("unchecked")
    public void cambioEstatusCatSelec() {
        catComunDTOGenerico = null;
        String idRegCat = (String) getFacesContext().getExternalContext().getRequestParameterMap().get("idRegCat");
        if (ObjectUtils.isNotNull(catalogoSeleccionado) && !ObjectUtils.isNullOrEmpty(idRegCat)) {

            try {
                catComunDTOGenerico = getGestionAprendizajeServiceAdapter().getCatalogoServiceByGestionAprendizajeEnum(catalogoSeleccionado)
                        .buscarPorId(Long.valueOf(idRegCat), catalogoSeleccionado.getClassEntidad());

                if (ObjectUtils.isNotNull(catComunDTOGenerico)) {

                    if (catComunDTOGenerico.getActivo().equals(ConstantesGestorWeb.ACTIVO)) {
                        catComunDTOGenerico.setActivo(ConstantesGestorWeb.INACTIVO);
                    } else {
                        catComunDTOGenerico.setActivo(ConstantesGestorWeb.ACTIVO);
                    }

                    catComunDTOGenerico.setFechaActualizacion(new Date());
                    catComunDTOGenerico.setUsuarioModifico(getUsuarioEnSession().getIdPersona());
                    catComunDTOGenerico.setNombreUsuarioMod(getUsuarioEnSession().getUsuario());
                    //GUSTAVO --BitacoraUtil.llenarBitacora(catComunDTOGenerico, getUsuarioEnSession(), ConstantesBitacora.CATALOGO_EDITAR, request);
                    ResultadoDTO<CatalogoComunDTO> res = getGestionAprendizajeServiceAdapter().getCatalogoServiceByGestionAprendizajeEnum(catalogoSeleccionado)
                            .actualizar(catComunDTOGenerico, catalogoSeleccionado.getClassEntidad());

                    if (ObjectUtils.isNotNull(res) && res.getResultado().getValor()) {
                        agregarMsgInfo("Se actualizo el registro exitosamente.", null);
                    } else {
                        agregarMsgError("Ocurrio un error", null);
                        logger.error(res != null ? obtenerErroresDeServicio(res.getMensajes()) : null);
                    }

                }
            } catch (Exception e) {
                logger.error(e.getCause(), e);
            }
        }
    }

    /**
     *
     */
    public void editaRegCatSeleccionado() {
        if (ObjectUtils.isNotNull(catComunDTOGenerico)) {
            setMuestraCompReg(Boolean.TRUE);
        }

    }

    /**
     * @return the catComunDTOGenerico
     */
    public CatalogoComunDTO getCatComunDTOGenerico() {
        return catComunDTOGenerico;
    }

    /**
     * @param catComunDTOGenerico the catComunDTOGenerico to set
     */
    public void setCatComunDTOGenerico(CatalogoComunDTO catComunDTOGenerico) {
        this.catComunDTOGenerico = catComunDTOGenerico;
    }

    public CatGestionAprendizajeEnum[] getCatalogosGestionAprendizaje() {
        return catalogosGestionAprendizaje;
    }

    public void setCatalogosGestionAprendizaje(CatGestionAprendizajeEnum[] catalogosGestionEAprendizaje) {
        this.catalogosGestionAprendizaje = catalogosGestionEAprendizaje;
    }

    /**
     * @return the nombreCat
     */
    public String getNombreCat() {
        return nombreCat;
    }

    /**
     * @param nombreCat the nombreCat to set
     */
    public void setNombreCat(String nombreCat) {
        this.nombreCat = nombreCat;
    }

    /**
     * @return the idCat
     */
    public String getIdCat() {
        return idCat;
    }

    /**
     * @param idCat the idCat to set
     */
    public void setIdCat(String idCat) {
        this.idCat = idCat;
    }

    /**
     * @return the muestraCompReg
     */
    public boolean isMuestraCompReg() {
        return muestraCompReg;
    }

    /**
     * @param muestraCompReg the muestraCompReg to set
     */
    public void setMuestraCompReg(boolean muestraCompReg) {
        this.muestraCompReg = muestraCompReg;
    }

    public CatGestionAprendizajeEnum getCatalogoSeleccionado() {
        return catalogoSeleccionado;
    }

    public void setCatalogoSeleccionado(CatGestionAprendizajeEnum catalogoSeleccionado) {
        this.catalogoSeleccionado = catalogoSeleccionado;
    }

    public GestionAprendizajeServiceAdapter getGestionAprendizajeServiceAdapter() {
        if (ObjectUtils.isNull(gestionAprendizajeServiceAdapter)) {
            gestionAprendizajeServiceAdapter = new GestionAprendizajeServiceAdapter();
        }
        return gestionAprendizajeServiceAdapter;
    }

    public void setGestionAprendizajeServiceAdapter(GestionAprendizajeServiceAdapter gestionEscolarServiceAdapter) {
        this.gestionAprendizajeServiceAdapter = gestionEscolarServiceAdapter;
    }

    /**
     * @return the lstCatSelec
     */
    public List<CatalogoComunDTO> getLstCatSelec() {
        return lstCatSelec;
    }

    /**
     * @param lstCatSelec the lstCatSelec to set
     */
    public void setLstCatSelec(List<CatalogoComunDTO> lstCatSelec) {
        this.lstCatSelec = lstCatSelec;
    }

    /**
     * @return the muestraCompTabla
     */
    public boolean isMuestraCompTabla() {
        return muestraCompTabla;
    }

    /**
     * @param muestraCompTabla the muestraCompTabla to set
     */
    public void setMuestraCompTabla(boolean muestraCompTabla) {
        this.muestraCompTabla = muestraCompTabla;
    }

}
