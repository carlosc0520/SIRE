package ventanas.helpers;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ResultSetMapper<T> {

    public T mapResultSetToObject(ResultSet resultados, Class<T> clase) {
        T objeto = null;

        try {
            if (resultados.next()) {
                objeto = clase.getDeclaredConstructor().newInstance();

                // Obtén los métodos de la clase
                Method[] metodos = clase.getMethods();
                
                for (Method metodo : metodos) {
                    if (esSetter(metodo) && resultados.findColumn(getNombreColumna(metodo)) != 0) {
                        String nombreColumna = getNombreColumna(metodo);
                        Object valor = resultados.getObject(nombreColumna);

                        if (valor != null) {
                            metodo.invoke(objeto, valor);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return objeto;
    }

    public ArrayList<T> mapResultSetToArrayList(ResultSet resultados, Class<T> clase) {
        ArrayList<T> objetos = new ArrayList<>();

        try {
            while (resultados.next()) {
                T objeto = clase.getDeclaredConstructor().newInstance();

                // Obtén los métodos de la clase
                Method[] metodos = clase.getMethods();

                for (Method metodo : metodos) {
                    if (esSetter(metodo) && resultados.findColumn(getNombreColumna(metodo)) != 0) {
                        String nombreColumna = getNombreColumna(metodo);
                        Object valor = resultados.getObject(nombreColumna);

                        if (valor != null) {
                            metodo.invoke(objeto, valor);
                        }
                    }
                }

                objetos.add(objeto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return objetos;
    }
    

    private boolean esGetter(Method metodo) {
        return metodo.getName().startsWith("get")
                && metodo.getParameterCount() == 0
                && metodo.getReturnType() != void.class;
    }

    private boolean esSetter(Method metodo) {
        return metodo.getName().startsWith("set")
                && metodo.getParameterCount() == 1;
    }

    private String getNombreColumna(Method metodo) {
        String nombreGetter = metodo.getName();
        return nombreGetter.substring(3).toUpperCase();
    }

}
