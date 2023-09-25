package clases;

import java.util.ArrayList;
import clases.ColumnasSire;
import clases.ErroresRender;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class CabecerasRender {

    private Integer ID, VLR1, INITPLE, FINPLE, INITSIRE, FINSIRE, CMNZLCTRA, CLMNCMPRBNTE, COLUMNEQVLNTE;
    private String DSCRPCN, RSCLARCCMPL, VLR2;
    private ArrayList<ColumnasSire> COLUMNAS = new ArrayList<>();
    private Map<Integer, String> ESTADOS = new HashMap<>();
    private ArrayList<ErroresRender> ERRORESPLE = new ArrayList<>();
    private List<Integer> COLUMNSVALIDARPLE = new ArrayList<>();
    private ArrayList<ErroresRender> ERRORESSIRE = new ArrayList<>();
    private List<Integer> COLUMNSVALIDARSIRE = new ArrayList<>();
    private Map<Integer, String> COLUMNASNOREGISTER = new HashMap<>();

    public Integer getCOLUMNEQVLNTE() {
        return COLUMNEQVLNTE;
    }

    public void setCOLUMNEQVLNTE(Integer COLUMNEQVLNTE) {
        this.COLUMNEQVLNTE = COLUMNEQVLNTE;
    }
    
    public Map<Integer, String> getCOLUMNASNOREGISTER() {
        return COLUMNASNOREGISTER;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getVLR2() {
        return VLR2;
    }

    public void setVLR2(String VLR2) {
        this.VLR2 = VLR2;
    }

    public String getRSCLARCCMPL() {
        return RSCLARCCMPL;
    }

    public void setRSCLARCCMPL(String RSCLARCCMPL) {
        this.RSCLARCCMPL = RSCLARCCMPL;
    }

    public ArrayList<ErroresRender> getERRORESPLE() {
        return ERRORESPLE;
    }

    public Integer getCLMNCMPRBNTE() {
        return CLMNCMPRBNTE;
    }

    public void setCLMNCMPRBNTE(Integer CLMNCMPRBNTE) {
        this.CLMNCMPRBNTE = CLMNCMPRBNTE;
    }

    public void resetErrores() {
        for (ErroresRender error : ERRORESPLE) {
            error.reiniciarDATOS();
        }

        for (ErroresRender error : ERRORESSIRE) {
            error.reiniciarDATOS();
        }
    }

    public Integer getCMNZLCTRA() {
        return CMNZLCTRA;
    }

    public void setCMNZLCTRA(Integer CMNZLCTRA) {
        this.CMNZLCTRA = CMNZLCTRA;
    }

    public ArrayList<ErroresRender> getERRORESSIRE() {
        return ERRORESSIRE;
    }

    public void setERRORESSIRE(ArrayList<ErroresRender> ERRORESSIRE) {
        this.ERRORESSIRE = ERRORESSIRE;
    }

    public List<Integer> getCOLUMNSVALIDARSIRE() {
        return COLUMNSVALIDARSIRE;
    }

    public void setCOLUMNSVALIDARSIRE(List<Integer> COLUMNSVALIDARSIRE) {
        this.COLUMNSVALIDARSIRE = COLUMNSVALIDARSIRE;
    }

    public List<Integer> getCOLUMNSVALIDARPLE() {
        return COLUMNSVALIDARPLE;
    }

    public ArrayList<ErroresRender> getERRORESPLESIRE() {
        return ERRORESSIRE;
    }

    public List<Integer> getCOLUMNSVALIDARPLESIRE() {
        return COLUMNSVALIDARSIRE;
    }

    public void setERRORESPLE(Integer codigo, String ERRORESARRAY) {
        this.ERRORESPLE = erroresRender(ERRORESARRAY);
    }

    public void setCOLUMNSVALIDARPLE(String COLUMNVALIDARARRAY) {
        this.COLUMNSVALIDARPLE = columnasRender(COLUMNVALIDARARRAY);
    }

    public void setCOLUMNASNOREGISTER(String COLUMNASNOREGISTER) {
        try {
            JSONArray columnasArray = new JSONArray(COLUMNASNOREGISTER);
            for (int i = 0; i < columnasArray.length(); i++) {
                JSONObject columnaJSON = columnasArray.getJSONObject(i);
                this.COLUMNASNOREGISTER.put(columnaJSON.getInt("NPCSN"), columnaJSON.getString("CLMNDFLTVLR1"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setERRORESSIRE(Integer codigo, String ERRORESARRAY) {
        this.ERRORESSIRE = erroresRender(ERRORESARRAY);
    }

    public void setCOLUMNSVALIDARSIRE(String COLUMNVALIDARARRAY) {
        this.COLUMNSVALIDARSIRE = columnasRender(COLUMNVALIDARARRAY);
    }

    public ArrayList<ErroresRender> erroresRender(String json) {
        ArrayList<ErroresRender> erroresColumns = new ArrayList<>();
        try {
            JSONArray columnasArray = new JSONArray(json);
            for (int i = 0; i < columnasArray.length(); i++) {
                JSONObject columnaJSON = columnasArray.getJSONObject(i);
                ErroresRender renderColumn = new ErroresRender();
                renderColumn.setTPODTO(columnaJSON.getInt("TPODTO"));
                renderColumn.setCLMNAVLDR(columnaJSON.getInt("CLMNAVLDR"));
                renderColumn.setCLMNAEQUVLNTE(columnaJSON.getInt("CLMNAEQUVLNTE"));
                renderColumn.setMNTDFRNCA(columnaJSON.getFloat("MNTDFRNCA"));
                renderColumn.setMNSJE(columnaJSON.getString("MNSJE"));
                erroresColumns.add(renderColumn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return erroresColumns;
    }

    public List<Integer> columnasRender(String json) {
        List<Integer> columns = new ArrayList<Integer>();
        try {
            JSONArray columnasArray = new JSONArray(json);
            for (int i = 0; i < columnasArray.length(); i++) {
                JSONObject columnaJSON = columnasArray.getJSONObject(i);
                columns.add(columnaJSON.getInt("NCOLUMNA"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return columns;
    }

    public Integer getINITPLE() {
        return INITPLE;
    }

    public void setINITPLE(Integer INITPLE) {
        this.INITPLE = INITPLE;
    }

    public Integer getFINPLE() {
        return FINPLE;
    }

    public void setFINPLE(Integer FINPLE) {
        this.FINPLE = FINPLE;
    }

    public Integer getINITSIRE() {
        return INITSIRE;
    }

    public void setINITSIRE(Integer INITSIRE) {
        this.INITSIRE = INITSIRE;
    }

    public Integer getFINSIRE() {
        return FINSIRE;
    }

    public void setFINSIRE(Integer FINSIRE) {
        this.FINSIRE = FINSIRE;
    }

    public Map<Integer, String> getESTADOS() {
        return ESTADOS;
    }

    public void setESTADOS(Map<Integer, String> ESTADOS) {
        this.ESTADOS = ESTADOS;
    }

    public Integer getVLR1() {
        return VLR1;
    }

    public void setVLR1(Integer VLR1) {
        this.VLR1 = VLR1;
    }

    public String getDSCRPCN() {
        return DSCRPCN;
    }

    public void setDSCRPCN(String DSCRPCN) {
        this.DSCRPCN = DSCRPCN;
    }

    public ArrayList<ColumnasSire> getCOLUMNAS() {
        return COLUMNAS;
    }

    public void setESTADOS(String ESTADOSARRAY) {
        try {
            JSONArray columnasArray = new JSONArray(ESTADOSARRAY);
            for (int i = 0; i < columnasArray.length(); i++) {
                JSONObject columnaJSON = columnasArray.getJSONObject(i);

                this.ESTADOS.put(columnaJSON.getInt("CODCMPRBNTE"), columnaJSON.getString("DSCRPCN"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String obtenerEstadoPorCodigo(Integer codigo) {
        return ESTADOS.getOrDefault(codigo, "");
    }

    public void setCOLUMNAS(String COLUMNASARRAY) {

        try {
            JSONArray columnasArray = new JSONArray(COLUMNASARRAY);
            for (int i = 0; i < columnasArray.length(); i++) {
                JSONObject columnaJSON = columnasArray.getJSONObject(i);
                ColumnasSire columna = new ColumnasSire();

                columna.setDSCRPCN(columnaJSON.optString("DSCRPCN", null));
                columna.setCCLR(columnaJSON.optString("CCLR", null));
                columna.setNPCSN(columnaJSON.optInt("NPCSN", -1)); // Valor por defecto 0 para NPCSN
                columna.setCODPLE(columnaJSON.optInt("CODPLE", -1));
                columna.setCDVLDCN(columnaJSON.optInt("CDVLDCN", -1));
                columna.setVVLDCNS(columnaJSON.optString("VVLDCNS"));
                columna.setNADMTDS(columnaJSON.optString("NADMTDS"));
                columna.setCLMNDFLT(columnaJSON.optInt("CLMNDFLT"));
                columna.setCLMNDFLTVLR1(columnaJSON.optString("CLMNDFLTVLR"));
                columna.setTYPECOLUMN(columnaJSON.getInt("TYPECOLUMN"));

                COLUMNAS.add(columna);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
