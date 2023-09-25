package ventanas.helpers;

import clases.CabecerasRender;
import clases.ColumnasSire;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

// ------ CLASES
import clases.Empresa;
import clases.ErroresRender;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import ventanas.helpers.Conexion;
import ventanas.sire.ConfiguracionSIREPLE;

public class ActionsPerformand<T> {

    private Conexion conection = new Conexion();
    private Connection conn = conection.getConnection();

    public Empresa autenticarUsuario(String ruc, String password) {
        String cadena = conection.getProcedimiento("SEGURIDAD", "AutenticarUsuario");
        ResultSet resultados = executeProcedure(cadena, ruc, password);

        ResultSetMapper<Empresa> mapper = new ResultSetMapper<>();
        Empresa empresa = mapper.mapResultSetToObject(resultados, Empresa.class);
        return empresa;
    }

    public Map<String, String> getDocumentos() {
        Map<String, String> documentosMap = new HashMap<>();

        try {
            String cadena = conection.getProcedimiento("SEGURIDAD", "ListarDocumentos");
            ResultSet resultados = executeProcedure(cadena);

            while (resultados.next()) {
                String codigo = resultados.getString("CODIGO");
                String descripcion = resultados.getString("DSCRPCN");
                documentosMap.put(codigo, descripcion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción apropiadamente
        }

        return documentosMap;
    }

    public ArrayList<CabecerasRender> obtenerCabeceras(String ruc) throws SQLException {
        ArrayList<CabecerasRender> cabeceraRender = new ArrayList<>();
        String cadena = conection.getProcedimiento("SEGURIDAD", "ListarCabeceras");
        ResultSet resultados = executeProcedure(cadena, ruc);

        while (resultados.next()) {
            CabecerasRender column = new CabecerasRender();
            column.setVLR2(resultados.getString("VLR2"));
            column.setRSCLARCCMPL(resultados.getString("RSCLARCCMPL"));
            column.setCOLUMNAS(resultados.getString("COLUMNAS"));
            column.setCLMNCMPRBNTE(resultados.getInt("CLMNCMPRBNTE"));
            //column.setESTADOS(resultados.getString("ESTADOS"));
            column.setDSCRPCN(resultados.getString("DSCRPCN"));
            column.setVLR1(resultados.getInt("VLR1"));
            column.setINITPLE(resultados.getInt("INITPLE"));
            column.setFINPLE(resultados.getInt("FINPLE"));
            column.setINITSIRE(resultados.getInt("INITSIRE"));
            column.setFINSIRE(resultados.getInt("FINSIRE"));
            column.setERRORESPLE(resultados.getInt("VLR1"), resultados.getString("ERRORESPLE"));
            column.setCOLUMNSVALIDARPLE(resultados.getString("COLUMNASVALIDARPLE"));
            column.setERRORESSIRE(resultados.getInt("VLR1"), resultados.getString("ERRORESSIRE"));
            column.setCOLUMNSVALIDARSIRE(resultados.getString("COLUMNASVALIDARSIRE"));
            column.setCOLUMNASNOREGISTER(resultados.getString("COLUMNASNOREGISTER"));
            column.setCMNZLCTRA(resultados.getInt("CMNZLCTRA"));
            column.setCOLUMNEQVLNTE(resultados.getInt("COLUMNEQVLNTE"));
            cabeceraRender.add(column);
        }

        return cabeceraRender;
    }

    public ArrayList<ColumnasSire> obtenerColumnasValidacion(String ruc, String CCBCRA) throws SQLException {
        ArrayList<ColumnasSire> cabeceraRender = new ArrayList<>();
        String cadena = conection.getProcedimiento("SEGURIDAD", "ObtenerColumnasValidacion");
        ResultSet resultados = executeProcedure(cadena, ruc, CCBCRA);

        while (resultados.next()) {
            ColumnasSire column = new ColumnasSire();
            column.setID(resultados.getInt("ID"));
            column.setDSCRPCN(resultados.getString("DSCRPCN"));
            column.setRSCL(resultados.getString("RSCL"));
            column.setNCOLUMNA(resultados.getInt("NCOLUMNA"));
            column.setORDN(resultados.getInt("ORDN"));
            cabeceraRender.add(column);
        }

        return cabeceraRender;
    }

    public ArrayList<ErroresRender> obtenerColumnasErrores(String ruc, String CCBCRA) throws SQLException {
        ArrayList<ErroresRender> cabeceraRender = new ArrayList<>();
        String cadena = conection.getProcedimiento("SEGURIDAD", "ObtenerColumnasErrores");
        ResultSet resultados = executeProcedure(cadena, ruc, CCBCRA);

        while (resultados.next()) {
            ErroresRender column = new ErroresRender();
            column.setID(resultados.getInt("ID"));
            column.setCLMNAVLDR(resultados.getInt("CLMNAVLDR"));
            column.setCLMNAVLDRS(resultados.getString("CLMNAVLDRS"));
            column.setCLMNAEQUVLNTE(resultados.getInt("CLMNAEQUVLNTE"));
            column.setCLMNAEQUVLNTES(resultados.getString("CLMNAEQUVLNTES"));
            column.setMNSJE(resultados.getString("MNSJE"));
            column.setMNTDFRNCA(resultados.getFloat("MNTDFRNCA"));
            column.setTPODTO(resultados.getInt("TPODTO"));
            column.setTPODTOS(resultados.getString("TPODTOS"));
            cabeceraRender.add(column);
        }

        return cabeceraRender;
    }

    public ArrayList<CabecerasRender> obtenerRangosExpotacion(String ruc) throws SQLException {
        ArrayList<CabecerasRender> cabeceraRender = new ArrayList<>();
        String cadena = conection.getProcedimiento("SEGURIDAD", "ObtenerRangosExportacion");
        ResultSet resultados = executeProcedure(cadena, ruc);

        while (resultados.next()) {
            CabecerasRender column = new CabecerasRender();
            column.setID(resultados.getInt("ID"));
            column.setDSCRPCN(resultados.getString("DSCRPCN"));
            column.setINITPLE(resultados.getInt("INITPLE"));
            column.setFINPLE(resultados.getInt("FINPLE"));
            column.setINITSIRE(resultados.getInt("INITSIRE"));
            column.setFINSIRE(resultados.getInt("FINSIRE"));

            cabeceraRender.add(column);
        }

        return cabeceraRender;
    }

    public String[] obtenerColumnasRender(String ruc, String ccbcra) throws SQLException {
        ArrayList<String> cabeceraRender = new ArrayList<>(); // Cambiado a ArrayList

        String cadena = conection.getProcedimiento("SEGURIDAD", "ObtenerColumnas");
        ResultSet resultados = executeProcedure(cadena, ruc, ccbcra);

        while (resultados.next()) {
            cabeceraRender.add(resultados.getString("ITEM"));
        }

        String[] cabeceraArray = cabeceraRender.toArray(new String[0]);

        return cabeceraArray;
    }

    public ArrayList<ColumnasSire> obtenerCabecerasEmpresa(String ruc, String ccbcra, String buscar) throws SQLException {
        ArrayList<ColumnasSire> cabeceraRender = new ArrayList<>();
        String cadena = conection.getProcedimiento("SEGURIDAD", "Configuracion");

        ResultSet resultados = executeProcedure(cadena, ruc, ccbcra, buscar);

        while (resultados.next()) {
            ColumnasSire column = new ColumnasSire();
            column.setID(resultados.getInt("ID"));
            column.setDSCRPCN(resultados.getString("DSCRPCN"));
            column.setCCLR(resultados.getString("CCLR"));
            column.setNPCSN(resultados.getInt("NPCSN")); // Valor por defecto 0 para NPCSN
            column.setCODPLE(resultados.getInt("CODPLE"));
            column.setCDVLDCN(resultados.getInt("CDVLDCN"));
            column.setVVLDCNS(resultados.getString("VVLDCNS"));
            column.setNADMTDS(resultados.getString("NADMTDS"));
            column.setCLMNDFLT(resultados.getInt("CLMNDFLT"));
            column.setCLMNDFLTVLR1(resultados.getString("CLMNDFLTVLR1"));
            column.setTYPECOLUMN(resultados.getInt("TYPECOLUMN"));

            cabeceraRender.add(column);
        }

        return cabeceraRender;
    }

    public void InsertarCabceraPLESIRE(String IDCODRC, String CCBCRA, String DSCRPCN, String CCLR, Integer NPCSN, Integer CODPLE,
            Integer CDVLDCN, String NADMTDS, String VVLDCNS, Integer CLMNDFLT, Integer TYPECOLUMN, ConfiguracionSIREPLE interfaz
    ) {
        try {
            conn.setAutoCommit(false);
            String cadena = conection.getProcedimiento("SEGURIDAD", "InsertarColumna");

            CallableStatement callableStatement = conn.prepareCall("{call " + cadena + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            callableStatement.setString(1, IDCODRC);
            callableStatement.setString(2, CCBCRA);
            callableStatement.setString(3, DSCRPCN);
            callableStatement.setString(4, CCLR);
            callableStatement.setInt(5, NPCSN);
            callableStatement.setInt(6, CODPLE);
            callableStatement.setInt(7, CDVLDCN);
            callableStatement.setString(8, NADMTDS);
            callableStatement.setString(9, VVLDCNS);
            callableStatement.setInt(10, CLMNDFLT);
            callableStatement.setInt(11, TYPECOLUMN);

            callableStatement.execute();

            JOptionPane.showMessageDialog(null, "Se registro correctamente los datos.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            conn.commit();

            if (interfaz != null) {
                interfaz.dispose();
            }
        } catch (SQLException e) {
            try {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                conn.rollback();
            } catch (SQLException rollbackEx) {
            }
        }
    }

    public void InsertarColumnaValidacion(String IDCODRC, String CCBCRA, Integer ORDN, Integer NCOLUMNA, JDialog interfaz
    ) {
        try {
            conn.setAutoCommit(false);
            String cadena = conection.getProcedimiento("SEGURIDAD", "InsertarColumnaValidacion");

            CallableStatement callableStatement = conn.prepareCall("{call " + cadena + "(?, ?, ?, ?)}");
            callableStatement.setString(1, IDCODRC);
            callableStatement.setString(2, CCBCRA);
            callableStatement.setInt(3, ORDN);
            callableStatement.setInt(4, NCOLUMNA);

            callableStatement.execute();

            JOptionPane.showMessageDialog(null, "Se registro correctamente los datos.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            if (interfaz != null) {
                interfaz.dispose();
            }
            conn.commit();

        } catch (SQLException e) {
            try {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                conn.rollback();
            } catch (SQLException rollbackEx) {
            }
        }
    }

    public void InsertarColumnaError(String IDCODRC, String CCBCRA, Integer TPODTO, Integer CLMNAVLDR,
            String MNTDFRNCA, String MNSJE, Integer CLMNAEQUVLNTE, JDialog interfaz
    ) {
        try {
            conn.setAutoCommit(false);
            String cadena = conection.getProcedimiento("SEGURIDAD", "InsertarColumnasErrores");

            CallableStatement callableStatement = conn.prepareCall("{call " + cadena + "(?, ?, ?, ?, ?, ?, ?)}");
            callableStatement.setString(1, IDCODRC);
            callableStatement.setString(2, CCBCRA);
            callableStatement.setInt(3, TPODTO);
            callableStatement.setInt(4, CLMNAVLDR);
            callableStatement.setString(5, MNTDFRNCA);
            callableStatement.setString(6, MNSJE);
            callableStatement.setInt(7, CLMNAEQUVLNTE);

            callableStatement.execute();

            JOptionPane.showMessageDialog(null, "Se registro correctamente los datos.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            if (interfaz != null) {
                interfaz.dispose();
            }
            conn.commit();

        } catch (SQLException e) {
            try {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                conn.rollback();
            } catch (SQLException rollbackEx) {
            }
        }
    }

    public void ActualizarCabceraPLESIRE(String IDCODRC, String CCBCRA, String DSCRPCN, String CCLR, Integer NPCSN, Integer CODPLE,
            Integer CDVLDCN, String NADMTDS, String VVLDCNS, Integer CLMNDFLT, Integer TYPECOLUMN, ConfiguracionSIREPLE interfaz, Integer ID
    ) {
        try {
            conn.setAutoCommit(false);
            String cadena = conection.getProcedimiento("SEGURIDAD", "ActualizarColumna");

            CallableStatement callableStatement = conn.prepareCall("{call " + cadena + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            callableStatement.setString(1, IDCODRC);
            callableStatement.setString(2, CCBCRA);
            callableStatement.setString(3, DSCRPCN);
            callableStatement.setString(4, CCLR);
            callableStatement.setInt(5, NPCSN);
            callableStatement.setInt(6, CODPLE);
            callableStatement.setInt(7, CDVLDCN);
            callableStatement.setString(8, NADMTDS);
            callableStatement.setString(9, VVLDCNS);
            callableStatement.setInt(10, CLMNDFLT);
            callableStatement.setInt(11, TYPECOLUMN);
            callableStatement.setInt(12, ID);

            callableStatement.execute();

            JOptionPane.showMessageDialog(null, "Se actualizo correctamente el registro.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            conn.commit();

            if (interfaz != null) {
                interfaz.dispose();
            }
        } catch (SQLException e) {
            try {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                conn.rollback();
            } catch (SQLException rollbackEx) {
            }
        }
    }

    public void ActualizarRangosExportacion(Integer ID, String IDCODRC, Integer INITPLE, Integer FINPLE, Integer INITSIRE, Integer FINSIRE
    ) {
        try {
            conn.setAutoCommit(false);
            String cadena = conection.getProcedimiento("SEGURIDAD", "ActualizarRangosExportacion");

            CallableStatement callableStatement = conn.prepareCall("{call " + cadena + "(?, ?, ?, ?, ?, ?)}");
            callableStatement.setInt(1, ID);
            callableStatement.setString(2, IDCODRC);
            callableStatement.setInt(3, INITPLE);
            callableStatement.setInt(4, FINPLE);
            callableStatement.setInt(5, INITSIRE);
            callableStatement.setInt(6, FINSIRE);

            callableStatement.execute();

            JOptionPane.showMessageDialog(null, "Se actualizo correctamente el registro.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            conn.commit();

        } catch (SQLException e) {
            try {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                conn.rollback();
            } catch (SQLException rollbackEx) {
            }
        }
    }

    public void eliminarCabceraPLESIRE(String IDCODRC, String CCBCRA, Integer ID) {
        try {
            conn.setAutoCommit(false);
            String cadena = conection.getProcedimiento("SEGURIDAD", "EliminarColumna");

            CallableStatement callableStatement = conn.prepareCall("{call " + cadena + "(?, ?, ?)}");
            callableStatement.setString(1, IDCODRC);
            callableStatement.setString(2, CCBCRA);
            callableStatement.setInt(3, ID);

            callableStatement.execute();
            conn.commit();

            JOptionPane.showMessageDialog(null, "Se elimino correctamente el registro.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            try {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                conn.rollback();
            } catch (SQLException rollbackEx) {
            }
        }
    }

    public void eliminarColumnaValidacion(String IDCODRC, Integer ID) {
        try {
            conn.setAutoCommit(false);
            String cadena = conection.getProcedimiento("SEGURIDAD", "EliminarColumnaValidacion");

            CallableStatement callableStatement = conn.prepareCall("{call " + cadena + "(?, ?)}");
            callableStatement.setString(1, IDCODRC);
            callableStatement.setInt(2, ID);

            callableStatement.execute();
            conn.commit();

            JOptionPane.showMessageDialog(null, "Se elimino correctamente el registro.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            try {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                conn.rollback();
            } catch (SQLException rollbackEx) {
            }
        }
    }

    public void eliminarColumnaErrores(String IDCODRC, Integer ID) {
        try {
            conn.setAutoCommit(false);
            String cadena = conection.getProcedimiento("SEGURIDAD", "EliminarColumnasErrores");

            CallableStatement callableStatement = conn.prepareCall("{call " + cadena + "(?, ?)}");
            callableStatement.setString(1, IDCODRC);
            callableStatement.setInt(2, ID);

            callableStatement.execute();
            conn.commit();

            JOptionPane.showMessageDialog(null, "Se elimino correctamente el registro.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            try {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                conn.rollback();
            } catch (SQLException rollbackEx) {
            }
        }
    }

    public ResultSet executeProcedure(String procedureName, Object... parameters) {
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;

        try {
            // Preparar la llamada al procedimiento almacenado
            StringBuilder procedureCall = new StringBuilder("{call ");
            procedureCall.append(procedureName).append("(");

            for (int i = 0; i < parameters.length; i++) {
                procedureCall.append("?");
                if (i < parameters.length - 1) {
                    procedureCall.append(",");
                }
            }

            procedureCall.append(")}");

            callableStatement = conn.prepareCall(procedureCall.toString());

            // Establecer los valores de los parámetros
            for (int i = 0; i < parameters.length; i++) {
                callableStatement.setObject(i + 1, parameters[i]);
            }

            // Ejecutar el procedimiento almacenado
            callableStatement.execute();

            resultSet = callableStatement.getResultSet();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

}
