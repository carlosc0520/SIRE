package clases;

public class ColumnasSire {

    String DSCRPCN, CLMNDFLTVLR1, RSCL;
    int[] CCLR;
    int CLMNDFLT, ID;
    String[] NADMTDS, VVLDCNS;
    Integer NPCSN, CODPLE, CDVLDCN, TYPECOLUMN, NCOLUMNA, ORDN;

    public Integer getNCOLUMNA() {
        return NCOLUMNA;
    }

    public void setNCOLUMNA(Integer NCOLUMNA) {
        this.NCOLUMNA = NCOLUMNA;
    }

    public Integer getORDN() {
        return ORDN;
    }

    public void setORDN(Integer ORDN) {
        this.ORDN = ORDN;
    }

    public String getRSCL() {
        return RSCL;
    }

    public void setRSCL(String RSCL) {
        this.RSCL = RSCL;
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Integer getTYPECOLUMN() {
        return TYPECOLUMN;
    }

    public void setTYPECOLUMN(Integer TYPECOLUMN) {
        this.TYPECOLUMN = TYPECOLUMN;
    }

    public int getCLMNDFLT() {
        return CLMNDFLT;
    }

    public String getCLMNDFLTVLR1() {
        return CLMNDFLTVLR1;
    }

    public void setCLMNDFLTVLR1(String CLMNDFLTVLR1) {
        this.CLMNDFLTVLR1 = CLMNDFLTVLR1;
    }

    public void setCLMNDFLT(int CLMNDFLT) {
        this.CLMNDFLT = CLMNDFLT;
    }

    public String getDSCRPCN() {
        return DSCRPCN;
    }

    public String[] getNADMTDS() {
        return NADMTDS;
    }

    public void setNADMTDS(String NADMTDS) {
        if (NADMTDS != null) {
            this.NADMTDS = NADMTDS.split(",");
        } else {
            this.NADMTDS = new String[0];
        }
    }

    public String[] getVVLDCNS() {
        return VVLDCNS;
    }

    public void setVVLDCNS(String VVLDCNS) {
        if (VVLDCNS != null) {
            this.VVLDCNS = VVLDCNS.split(",");
        } else {
            this.VVLDCNS = new String[0];
        }
    }

    public boolean getContenedor(String valor, String[] partes) {
        for (String cadena : partes) {
            if (valor.trim().equalsIgnoreCase(cadena.trim()) || valor.equals("")) {
                return true;
            }
        }
        return false;
    }

    public void setDSCRPCN(String DSCRPCN) {
        this.DSCRPCN = DSCRPCN;
    }

    public int[] getCCLR() {
        return CCLR;
    }

    public void setCCLR(String colores) {
        if (colores == null || colores.isEmpty()) {
            colores = "255,255,255";
        }

        String[] numbersArray = colores.split(",");
        int[] intArray = new int[numbersArray.length];

        for (int i = 0; i < numbersArray.length; i++) {
            try {
                intArray[i] = Integer.parseInt(numbersArray[i]);
            } catch (NumberFormatException e) {
                intArray[i] = 0;             }
        }

        this.CCLR = intArray;

    }

    public Integer getNPCSN() {
        return NPCSN;
    }

    public void setNPCSN(Integer NPCSN) {
        this.NPCSN = NPCSN;
    }

    public Integer getCODPLE() {
        return CODPLE;
    }

    public void setCODPLE(Integer CODPLE) {
        this.CODPLE = CODPLE;
    }

    public Integer getCDVLDCN() {
        return CDVLDCN;
    }

    public void setCDVLDCN(Integer CDVLDCN) {
        this.CDVLDCN = CDVLDCN;
    }
}
