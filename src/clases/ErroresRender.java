package clases;

import java.util.HashMap;
import java.util.Map;

public class ErroresRender {

    Integer TPODTO, CLMNAVLDR, ERRORES, CLMNAEQUVLNTE, ID;
    String CLMNAVLDRS, CLMNAEQUVLNTES, TPODTOS;
    float MNTDFRNCA;
    String MNSJE;
    private Map<String, String[]> DATOS = new HashMap<>();

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getTPODTOS() {
        return TPODTOS;
    }

    public void setTPODTOS(String TPODTOS) {
        this.TPODTOS = TPODTOS;
    }

    public String getCLMNAVLDRS() {
        return CLMNAVLDRS;
    }

    public void setCLMNAVLDRS(String CLMNAVLDRS) {
        this.CLMNAVLDRS = CLMNAVLDRS;
    }

    public String getCLMNAEQUVLNTES() {
        return CLMNAEQUVLNTES;
    }

    public void setCLMNAEQUVLNTES(String CLMNAEQUVLNTES) {
        this.CLMNAEQUVLNTES = CLMNAEQUVLNTES;
    }

    
    public Integer getCLMNAEQUVLNTE() {
        return CLMNAEQUVLNTE;
    }

    public void setCLMNAEQUVLNTE(Integer CLMNAEQUVLNTE) {
        this.CLMNAEQUVLNTE = CLMNAEQUVLNTE;
    }

    public Integer getERRORES() {
        return ERRORES;
    }

    public Map<String, String[]> getDATOS() {
        return this.DATOS;
    }

    public void setDATOS(String clave, String[] datos) {
        this.DATOS.put(clave, datos);
    }

    public void reiniciarDATOS() {
        this.DATOS.clear(); // Elimina todas las entradas del Map
    }

    public void setERRORES(Integer ERRORES) {
        this.ERRORES = ERRORES;
    }

    public Integer getTPODTO() {
        return TPODTO;
    }

    public void setTPODTO(Integer TPODTO) {
        this.TPODTO = TPODTO;
    }

    public Integer getCLMNAVLDR() {
        return CLMNAVLDR;
    }

    public void setCLMNAVLDR(Integer CLMNAVLDR) {
        this.CLMNAVLDR = CLMNAVLDR;
    }

    public float getMNTDFRNCA() {
        return MNTDFRNCA;
    }

    public void setMNTDFRNCA(float MNTDFRNCA) {
        this.MNTDFRNCA = MNTDFRNCA;
    }

    public String getMNSJE() {
        return MNSJE;
    }

    public void setMNSJE(String MNSJE) {
        this.MNSJE = MNSJE;
    }

}
