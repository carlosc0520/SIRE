package clases;

import java.util.List;

public class Empresa {

    private Integer MENSAJE, NUSRS;
    private String CODRC, RSCL, LGOEMPRSA, FCRCN, RSCLARCCMPL, RSCLARC;

    public String getLGOEMPRSA() {
        return LGOEMPRSA;
    }

    public String getRSCLARCCMPL() {
        return RSCLARCCMPL;
    }

    public void setRSCLARCCMPL(String RSCLARCCMPL) {
        this.RSCLARCCMPL = RSCLARCCMPL;
    }

    public String getRSCLARC() {
        return RSCLARC;
    }

    public void setRSCLARC(String RSCLARC) {
        this.RSCLARC = RSCLARC;
    }

    public void setLGOEMPRSA(String LGOEMPRSA) {
        this.LGOEMPRSA = LGOEMPRSA;
    }

    public Integer getNUSRS() {
        return NUSRS;
    }

    public void setNUSRS(Integer NUSRS) {
        this.NUSRS = NUSRS;
    }

    public String getFCRCN() {
        return FCRCN;
    }

    public void setFCRCN(String FCRCN) {
        this.FCRCN = FCRCN;
    }

    public Integer getMENSAJE() {
        return MENSAJE;
    }

    public void setMENSAJE(Integer MENSAJE) {
        this.MENSAJE = MENSAJE;
    }

    public String getCODRC() {
        return CODRC;
    }

    public void setCODRC(String CODRC) {
        this.CODRC = CODRC;
    }

    public String getRSCL() {
        return RSCL;
    }

    public void setRSCL(String RSCL) {
        this.RSCL = RSCL;
    }
}
