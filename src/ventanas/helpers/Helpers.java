package ventanas.helpers;

import clases.ErroresRender;
import java.awt.Component;
import java.awt.Container;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import ventanas.helpers.HelpersArchivos;
import clases.CabecerasRender;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Base64;
import ventanas.sire.InicioSire;
import ventanas.sire.InterfazSire;
import org.mozilla.universalchardet.UniversalDetector;

public class Helpers {

    HelpersArchivos archivos = new HelpersArchivos();

    public void SetImageLabel(JLabel JLabel, String root) {
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(
                image.getImage().getScaledInstance(JLabel.getWidth() - 10, JLabel.getHeight() - 10, Image.SCALE_DEFAULT)
        );
        JLabel.setIcon(icon);
    }

    public static boolean esFechaValida(String fechaString) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fecha = LocalDate.parse(fechaString, formatter);
            if (fecha.getYear() < 2000) {
                return false;
            } else {
                return true;
            }
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public void SetImageButton(JButton JButtonName, String root) {
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(
                image.getImage().getScaledInstance(JButtonName.getWidth() - 10, JButtonName.getHeight() - 10, Image.SCALE_DEFAULT)
        );
        JButtonName.setIcon(icon);
    }

    public String obtenerTextoDespuesDeGuion(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        int indexGuion = input.lastIndexOf('-');
        if (indexGuion != -1) {
            return input.substring(indexGuion + 1);
        } else {
            return input;
        }
    }

    public void hidePanelsInContainer(Container container) {
        Component[] components = container.getComponents();
        for (Component component : components) {
            if (component instanceof JPanel) {
                component.setVisible(false);
            }
            if (component instanceof Container) {
                hidePanelsInContainer((Container) component); // Llamada recursiva para subcontenedores
            }
        }
    }

    public String obtenerSubCadena(String cadena, int inicio, int vfinal) {
        return (cadena == null || cadena.isEmpty() || cadena.length() < vfinal) ? ""
                : cadena.substring(inicio, vfinal);
    }

    public String obtenerFechaHoraActual() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String formattedDateTime = now.format(formatter);

        return formattedDateTime;
    }

    public static String obtenerFechaActual() {
        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();

        // Formatear la fecha en el formato deseado (AÑO_MES_DIA)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd");
        String fechaFormateada = fechaActual.format(formatter);

        return fechaFormateada;
    }

    public static String procesarCadena(String input) {
        if (input.isEmpty()) {
            return "000000";
        }

        if (input.length() == 6) {
            return input;
        }

        if (input.length() > 6) {
            return input.substring(0, 6);
        }

        return String.format("%-6s", input).replace(" ", "0");
    }

    public static String procesarComprobante(String cadena, boolean indicador, int longitud) {
        if (indicador) {
            String cadenaSinCeros = cadena.replaceFirst("^0+", "");
            return cadenaSinCeros;
        } else {
            int cerosFaltantes = longitud - cadena.length();
            if (cerosFaltantes <= 0) {
                return cadena;
            }

            StringBuilder resultado = new StringBuilder();
            for (int i = 0; i < cerosFaltantes; i++) {
                resultado.append('0');
            }
            resultado.append(cadena);
            return resultado.toString();
        }
    }

    public FileInputStream CargarArchivo(InterfazSire interfaz, JButton btnArchivo, JTable table) {
        if (table != null) {
            LimpiarTable(table, null, null, null);
        }
        btnArchivo.setText("");

        FileInputStream fileInputStream = null;
        FileDialog fileDialog = new FileDialog(interfaz, "Seleccionar archivo de texto", FileDialog.LOAD);
        fileDialog.setFile("*.txt");
        fileDialog.setVisible(true);

        String selectedFilePath = fileDialog.getFile();

        if (selectedFilePath != null) {
            File selectArchivo = new File(fileDialog.getDirectory(), selectedFilePath);

            if (selectArchivo.isFile()) {
                btnArchivo.setText(getFileNameWithoutExtension(selectArchivo.getName()));
                btnArchivo.setHorizontalAlignment(SwingConstants.LEFT);

                try {
                    String detectedCharset = detectCharset(selectArchivo);

                    if (detectedCharset == null) {
                        convertirAUTF8(selectArchivo);
                    } else if (!detectedCharset.equalsIgnoreCase("UTF-8")) {
                        convertirAUTF8(selectArchivo);
                    }


                    fileInputStream = new FileInputStream(new File(selectArchivo.getAbsolutePath()));

                    JOptionPane.showMessageDialog(interfaz, "Se cargó correctamente el archivo", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(interfaz, "Error al abrir el archivo", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(interfaz, "Selecciona un archivo de texto (.txt)", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        return fileInputStream;
    }

    private String detectCharset(File file) {
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] buf = new byte[4096];
            UniversalDetector detector = new UniversalDetector(null);

            int nread;
            while ((nread = fis.read(buf)) > 0 && !detector.isDone()) {
                detector.handleData(buf, 0, nread);
            }

            detector.dataEnd();
            return detector.getDetectedCharset();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void convertirAUTF8(File file) {
        try {
            String detectedCharset = detectCharset(file);

            if (detectedCharset == null) {
                detectedCharset = StandardCharsets.UTF_8.name();
            }

            StringBuilder content = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), detectedCharset))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
            }

            try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8)) {
                osw.write(content.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // leerArchivoYDevolverHashMap - leerInputStreamYDevolverHashMap
    public static Map<String, String[]> leerInputStreamYDevolverHashMap(InputStream inputStream, String separador, List<Integer> indices, Integer inicio) {
        Map<String, String[]> hashMap = new HashMap<>();

        try {
            BufferedReader archivoLectura = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

            String linea;
            String codigo;
            Integer comienzo = 0;

            while ((linea = archivoLectura.readLine()) != null) {
                if (comienzo >= inicio) {
                    String[] cadenaLinea = linea.split("\\" + separador + "");
                    codigo = "";

                    for (Integer indice : indices) {
                        codigo = codigo + "" + cadenaLinea[indice - 1];
                    }

                    hashMap.put(codigo, cadenaLinea);
                } else {
                    comienzo++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return hashMap;
    }

    public static Map<String, String[]> leerArchivoYDevolverHashMap(InputStream inputStream, String separador, List<Integer> indices, Integer inicio, Map<String, String[]> Duplicados) {
        Map<String, String[]> hashMap = new HashMap<>();

        try (BufferedReader archivoLectura = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            String linea;
            String codigo;
            Integer comienzo = 0;

            while ((linea = archivoLectura.readLine()) != null) {
                if (comienzo >= inicio) {
                    String[] cadenaLinea = linea.split("\\" + separador + "");
                    codigo = "";

                    for (Integer indice : indices) {
                        codigo = codigo + "" + cadenaLinea[indice - 1];
                    }

                    if (hashMap.containsKey(codigo) && !Duplicados.containsKey(codigo)) {
                        Duplicados.put(codigo, cadenaLinea);
                    }
                    hashMap.put(codigo, cadenaLinea);
                } else {
                    comienzo++;
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        return hashMap;
    }

    public static String getFileNameWithoutExtension(String fileName) {
        int lastIndex = fileName.lastIndexOf('.');
        if (lastIndex > 0 && lastIndex < fileName.length() - 1) {
            return fileName.substring(0, lastIndex);
        }
        return fileName;
    }

    public void LimpiarTable(JTable table, ButtonGroup buttonGroup, JComboBox combo, JButton boton) {
        // Limpiar la tabla
        if (table != null) {
            table.setModel(new DefaultTableModel());
        }

        // Limpiar el botón
        if (boton != null) {
            boton.setText("");
        }

        // Limpiar el combo box
        if (combo != null) {
            combo.setSelectedIndex(0);
        }

        // Limpiar el ButtonGroup
        if (buttonGroup != null) {
            Enumeration<AbstractButton> buttons = buttonGroup.getElements();
            while (buttons.hasMoreElements()) {
                AbstractButton button = buttons.nextElement();
                button.setSelected(false);
            }
        }
    }

    public static boolean hasDataCount(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        return model.getRowCount() > 0;
    }

    public static boolean isSpecialCharacter(char c) {
        return !Character.isLetterOrDigit(c) && !Character.isWhitespace(c);
    }

    public void CerrarSesion(InterfazSire interfaz) {
        UIManager.put("OptionPane.yesButtonText", "Sí");
        UIManager.put("OptionPane.noButtonText", "No");
        int confirmacion = JOptionPane.showConfirmDialog(interfaz, "¿Deseas cerrar la sesión?", "", JOptionPane.YES_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            interfaz.dispose();

            // Abrir la ventana InicioSire
            InicioSire inicioSire = new InicioSire();
            inicioSire.setVisible(true);
        }
    }

    public Map<String, Map<String, String[]>> CompararSirePle(Map<String, String[]> comparar, Map<String, String[]> comparacion, ArrayList<ErroresRender> errores,
            float montoDiferencia, CabecerasRender cabecera, String texto, boolean abrirDocument, Map<String, String[]> Duplicados) {

        int noEncontrado = 0;
        Map<String, String[]> NoEncontrados = new HashMap<>();

        for (String clave : comparar.keySet()) {
            String[] contenidoComparar = comparar.get(clave);

            if (comparacion.containsKey(clave)) {
                String[] contenidoComparacion = comparacion.get(clave);

                for (ErroresRender columnaError : errores) {
                    switch (columnaError.getTPODTO()) {
                        case 1:
                            if (!contenidoComparar[columnaError.getCLMNAVLDR() - 1].equalsIgnoreCase(contenidoComparacion[columnaError.getCLMNAEQUVLNTE() - 1])) {
                                columnaError.setDATOS(clave, contenidoComparar);
                            }
                            break;

                        case 2:
                            break;
                        case 3:
                            float montoDiferenciaQuality = (montoDiferencia == -1) ? columnaError.getMNTDFRNCA() : montoDiferencia;

                            String valorCompararStr = contenidoComparar[columnaError.getCLMNAVLDR() - 1];
                            String valorComparacionStr = contenidoComparacion[columnaError.getCLMNAEQUVLNTE() - 1];

                            if (!valorCompararStr.isEmpty() && esNumeroValido(valorCompararStr)) {
                                float montoComparar = Float.parseFloat(valorCompararStr);

                                if (!valorComparacionStr.isEmpty() && esNumeroValido(valorComparacionStr)) {
                                    float montoComparacion = Float.parseFloat(valorComparacionStr);

                                    if (montoComparar != montoComparacion) {
                                        if (Math.abs(montoComparar - montoComparacion) > montoDiferenciaQuality) {
                                            columnaError.setDATOS(clave, contenidoComparar);
                                        }
                                    }
                                }
                            }

                            break;

                        case 4:
                            if (!contenidoComparar[columnaError.getCLMNAVLDR() - 1].equalsIgnoreCase(contenidoComparacion[columnaError.getCLMNAEQUVLNTE() - 1])) {
                                columnaError.setDATOS(clave, contenidoComparar);
                            }
                            break;
                        default:
                            break;
                    }

                }

            } else {
                NoEncontrados.put(clave, contenidoComparar);
                noEncontrado++;
            }
        }

        Map<String, Map<String, String[]>> excelData = new HashMap<>();
        if (noEncontrado > 0) {
            excelData.put("0 - DOCUMENTOS NO ENCONTRADOS", NoEncontrados);
        }

        if (Duplicados.size() > 0) {
            excelData.put("00 - DUPLICADOS", Duplicados);
        }

        for (ErroresRender columnaValidada : errores) {
            if (columnaValidada.getDATOS().size() > 0) {
                String mensaje = columnaValidada.getCLMNAVLDR() + " - " + columnaValidada.getMNSJE();
                excelData.put(mensaje, columnaValidada.getDATOS());
            }
        }

        return excelData;

    }

    public void mensajeError(String mensaje, int codigoError) {
        switch (codigoError) {
            case 1:
                JOptionPane.showMessageDialog(null, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 2:
                JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
                break;
            case 3:
                JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
                break;
            default:
                JOptionPane.showMessageDialog(null, mensaje, "Éxito", JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }

    public void actualizarLabelConImagenBase64(JLabel label, String base64Image) {
        try {
            // Decodificar la cadena Base64 en un arreglo de bytes
            byte[] imageBytes = Base64.getDecoder().decode(base64Image);

            // Crear un BufferedImage a partir de los bytes de la imagen
            ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes);
            BufferedImage bufferedImage = ImageIO.read(bis);

            // Asignar la imagen al JLabel
            label.setIcon(new ImageIcon(bufferedImage));
        } catch (IOException e) {
            e.printStackTrace();
            // Manejo de errores si la decodificación o lectura de la imagen falla
        }
    }

    public boolean esNumeroValido(String cadena) {
        try {
            Float.parseFloat(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
