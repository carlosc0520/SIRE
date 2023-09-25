package ventanas.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Conexion {

    // Datos de conexión a SQL Server
    //private static final String connectionString = "jdbc:sqlserver://SQL8002.site4now.net;database=db_a9c576_dbproyecto;user=db_a9c576_dbproyecto_admin;password=x975p83s_-eDmcK;loginTimeout=30";
//    private static final String connectionString = "jdbc:sqlserver://DESKTOP-JVH12V7\\MSSQL:1433;database=db_a9ec8e_proyectos;user=DESKTOP-JVH12V7\\user1;";
    private static final String connectionString = "jdbc:sqlserver://SQL5107.site4now.net;database=db_a9ec8e_proyectos;user=db_a9ec8e_proyectos_admin;password=ING052001;loginTimeout=30";
    //"Data Source=SQL5107.site4now.net;Initial Catalog=db_a9ec8e_proyectos;User Id=db_a9ec8e_proyectos_admin;Password=YOUR_DB_PASSWORD
    //private static final String connectionString = "jdbc:sqlserver://localhost:1433;database=db_a9c576_dbproyecto;user=user1;password=;loginTimeout=30";

    private Map<String, Map<String, String>> modulosProcedimientos = new HashMap<>();

    public Connection getConnection() {
        try {
            Connection conection = DriverManager.getConnection(connectionString);
            return conection;

        } catch (Exception e) {
            System.out.println("error.....");
        }
        return null;
    }

    public Conexion() {
        Map<String, String> procedimientosSeguridad = new HashMap<>();
        procedimientosSeguridad.put("AutenticarUsuario", "SIRE.USP_TB0001_AUTENTICARUSUARIOS");
        procedimientosSeguridad.put("ListarCabeceras", "SIRE.USP_TB0003_LISTARCABECERAS");
        procedimientosSeguridad.put("ListarDocumentos", "SIRE.USP_TB0003_LISTARCOMPROBANTES");
        procedimientosSeguridad.put("Configuracion", "SIRE.USP_TB0003_LISTARCABECERASEMPRESA");
        procedimientosSeguridad.put("ObtenerColumnas", "SIRE.USP_TB0003_LISTARSELECTVALIDACION");
        procedimientosSeguridad.put("InsertarColumna", "SIRE.USP_TB0003_INSERTARCABECERA");
        procedimientosSeguridad.put("EliminarColumna", "SIRE.USP_TB0003_ELIMINARCABECERA");
        procedimientosSeguridad.put("ActualizarColumna", "SIRE.USP_TB0003_ACTUALIZARCABECERA");
        procedimientosSeguridad.put("ObtenerRangosExportacion", "SIRE.USP_TB0003_OBTENERRANGOSEXPORTACION");
        procedimientosSeguridad.put("ActualizarRangosExportacion", "SIRE.USP_TB0003_ACTUALIZARRANGOSEXPORTACION");
        procedimientosSeguridad.put("ObtenerColumnasValidacion", "SIRE.USP_TB0003_OBTENERCOLUMNASVALIDACION");
        procedimientosSeguridad.put("EliminarColumnaValidacion", "SIRE.USP_TB0007_ELIMINARCOLUMNACODIGO");
        procedimientosSeguridad.put("InsertarColumnaValidacion", "SIRE.USP_TB0007_INSERTARCOLUMNAVALIDACION");
        procedimientosSeguridad.put("ObtenerColumnasErrores", "SIRE.USP_TB0003_OBTENERCOLUMNASERRORES");
        procedimientosSeguridad.put("EliminarColumnasErrores", "SIRE.USP_TB0006_ELIMINARCOLUMNASERRORES");
        procedimientosSeguridad.put("InsertarColumnasErrores", "SIRE.USP_TB0006_INSERTARCOLUMNASERRORES");

        modulosProcedimientos.put("SEGURIDAD", procedimientosSeguridad);
    }

    // Método para cerrar la conexión
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public String getProcedimiento(String nombreModulo, String nombreProcedimiento) {
        nombreModulo = nombreModulo.toUpperCase();
        nombreProcedimiento = nombreProcedimiento.toUpperCase();

        Map<String, String> procedimientos = modulosProcedimientos.get(nombreModulo);
        if (procedimientos != null) {
            for (String key : procedimientos.keySet()) {
                if (key.equalsIgnoreCase(nombreProcedimiento)) {
                    return procedimientos.get(key);
                }
            }
        }

        return null;
    }
}
