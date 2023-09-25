package ventanas.helpers;

import clases.CabecerasRender;
import clases.ColumnasSire;
import java.awt.Desktop;
import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.DefaultIndexedColorMap;
import org.apache.poi.xssf.usermodel.IndexedColorMap;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HelpersArchivos {

    public void cargarDatosEnTablaExecute(BufferedReader archivo, CabecerasRender cabeceraTable, JTable table, int inicio) {

        try {
            DefaultTableModel model = new DefaultTableModel();
            model.setRowCount(0);

            model.addColumn(""); // Columna sin título para el número de índice

            for (int i = 1; i <= cabeceraTable.getCOLUMNAS().size(); i++) {
                model.addColumn(cabeceraTable.getCOLUMNAS().get(i - 1).getDSCRPCN());
            }

            String line;
            int indice = 1;
            Map<Integer, String> COLUMNASNOREGISTERLOCAL = new HashMap<>();
            COLUMNASNOREGISTERLOCAL = cabeceraTable.getCOLUMNASNOREGISTER();

            while ((line = archivo.readLine()) != null) {
                if (indice < inicio) {
                    indice++;
                    continue;
                }
                String[] data = line.split("\\|");
                Object[] rowData = new Object[cabeceraTable.getCOLUMNAS().size() + 1];
                rowData[0] = indice++;

                List<String> dataList = new ArrayList<>(Arrays.asList(data));

                for (Map.Entry<Integer, String> entry : COLUMNASNOREGISTERLOCAL.entrySet()) {
                    Integer key = entry.getKey();
                    String value = entry.getValue();
                    dataList.add(key - 1, value);
                }

                data = dataList.toArray(new String[0]);

                for (int i = 0; i < data.length; i++) {
                    rowData[i + 1] = data[i];
                }

                for (int i = data.length + 1; i < rowData.length; i++) {
                    rowData[i] = "";
                }

                model.addRow(rowData);
            }

            archivo.close();
            // Crear la tabla con el modelo configurado

            table.setModel(model);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar los datos del archivo.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cargarDatosEnTablaSireExecute(BufferedReader archivo, CabecerasRender cabeceraTable, JTable table, int inicio) {
        try {
            DefaultTableModel model = new DefaultTableModel();
            model.setRowCount(0);

            model.addColumn(""); // Columna sin título para el número de índice

            for (int i = 1; i <= cabeceraTable.getCOLUMNAS().size(); i++) {
                model.addColumn(cabeceraTable.getCOLUMNAS().get(i - 1).getDSCRPCN().toUpperCase());
            }

            String line;
            int indice = 1;
            while ((line = archivo.readLine()) != null) {
                if (indice < inicio) {
                    indice++;
                    continue;
                }
                String[] data = line.split("\\|");
                Object[] rowData = new Object[cabeceraTable.getCOLUMNAS().size() + 1];
                rowData[0] = indice++;

                // Copiar los datos disponibles
                for (int i = 0; i < data.length; i++) {
                    rowData[i + 1] = data[i];
                }

                // Completar con "" si no hay suficientes datos
                for (int i = data.length + 1; i < rowData.length; i++) {
                    rowData[i] = "";
                }

                model.addRow(rowData);
            }

            archivo.close();
            // Crear la tabla con el modelo configurado
            table.setModel(model);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar los datos del archivo.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actualizarCabeceraSireExecute(JTable table, CabecerasRender cabecera) {
        DefaultTableModel model = new DefaultTableModel();
        model.setRowCount(0);
        model.addColumn(""); // Columna sin título para el número de índice

        for (int i = 1; i <= cabecera.getCOLUMNAS().size(); i++) {
            model.addColumn(cabecera.getCOLUMNAS().get(i - 1).getDSCRPCN().toUpperCase());
        }

        table.setModel(model);
    }

    public static void addDataToTable(String[] rowData, JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(rowData);
    }

    public static void exportTableToTxtExport(JTable table, String separator, String nombre, int maxColumn, int minColumn,
            JDialog progressDialog, boolean abrirDocument) {

        // Crear un SwingWorker para realizar la generación del archivo en segundo plano
        SwingWorker<String, Void> worker = new SwingWorker<>() {
            @Override
            protected String doInBackground() throws Exception {
                String selectedFile = getSelectedFile(nombre);
                if (selectedFile != null) {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile))) {
                        TableModel model = table.getModel();
                        int rowCount = model.getRowCount();

                        for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
                            for (int columnIndex = minColumn; columnIndex < maxColumn; columnIndex++) {
                                Object value = model.getValueAt(rowIndex, columnIndex);

                                if (value != null) {
                                    writer.write(value.toString());
                                }
                                if (columnIndex <= maxColumn) {
                                    writer.write(separator);
                                }
                            }
                            writer.write(separator);
                            writer.newLine();
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return selectedFile;
            }

            @Override
            protected void done() {
                progressDialog.dispose();
                String savedFilePath;
                try {
                    savedFilePath = get();
                    if (savedFilePath != null) {
                        JOptionPane.showMessageDialog(null, "Archivo guardado correctamente en: " + savedFilePath, "Éxito", JOptionPane.INFORMATION_MESSAGE);

                        if (abrirDocument) {
                            if (Desktop.isDesktopSupported()) {
                                Desktop desktop = Desktop.getDesktop();
                                File fileToOpen = new File(savedFilePath);
                                desktop.open(fileToOpen);
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        // Iniciar el SwingWorker en un hilo separado
        worker.execute();

        // Mostrar el JDialog de progreso
        progressDialog.setVisible(true);

    }

    public static void exportTableToExcelExport(JTable table, String nombre, CabecerasRender cabecera, JDialog progressDialog, boolean abrirDocument) {
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                try (Workbook workbook = new XSSFWorkbook()) {
                    Sheet sheet = workbook.createSheet("Datos");

                    TableModel model = table.getModel();
                    int rowCount = model.getRowCount();
                    int columnCount = model.getColumnCount();

                    Row headerRow = sheet.createRow(0);
                    XSSFCellStyle headerCellStyle = (XSSFCellStyle) workbook.createCellStyle();
                    for (int columnIndex = 1; columnIndex < columnCount; columnIndex++) {
                        IndexedColorMap colorMap = new DefaultIndexedColorMap();
                        XSSFColor xssfColor = new XSSFColor(new java.awt.Color(cabecera.getCOLUMNAS().get(columnIndex - 1).getCCLR()[0], cabecera.getCOLUMNAS().get(columnIndex - 1).getCCLR()[1], cabecera.getCOLUMNAS().get(columnIndex - 1).getCCLR()[2]), colorMap);
                        headerCellStyle.setFillForegroundColor(xssfColor);
                        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

                        Cell cell = headerRow.createCell(columnIndex - 1);
                        cell.setCellValue(model.getColumnName(columnIndex));
                        cell.setCellStyle(headerCellStyle);
                    }

                    // Agregar datos
                    for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
                        Row row = sheet.createRow(rowIndex + 1);
                        for (int columnIndex = 1; columnIndex < columnCount; columnIndex++) {
                            Cell cell = row.createCell(columnIndex - 1);
                            Object value = model.getValueAt(rowIndex, columnIndex);
                            if (value != null) {
                                cell.setCellValue(value.toString());
                            } else {
                                cell.setCellValue("");
                            }
                        }
                    }

                    // Ajustar el ancho de las columnas
                    for (int columnIndex = 0; columnIndex < columnCount - 1; columnIndex++) {
                        sheet.autoSizeColumn(columnIndex);
                    }

                    // Agregar tabla de autofiltro
                    int firstColumn = 0;
                    int lastColumn = columnCount - 2;
                    int firstRow = 0;
                    int lastRow = rowCount;

                    sheet.setAutoFilter(new CellRangeAddress(firstRow, lastRow, firstColumn, lastColumn));

                    FileDialog fileDialog = new FileDialog((Frame) null, "Guardar Archivo Excel", FileDialog.SAVE);
                    fileDialog.setFile(nombre + ".xlsx");
                    fileDialog.setVisible(true);

                    String selectedFile = fileDialog.getFile();
                    String selectedDirectory = fileDialog.getDirectory();

                    JOptionPane.showMessageDialog(null, "Archivo guardado correctamente en: " + selectedDirectory + selectedFile, "Éxito", JOptionPane.INFORMATION_MESSAGE);

                    if (selectedFile != null && selectedDirectory != null) {
                        String fileName = selectedDirectory + selectedFile;

                        try (FileOutputStream fileOut = new FileOutputStream(fileName)) {
                            workbook.write(fileOut);
                            if (abrirDocument) {
                                if (Desktop.isDesktopSupported()) {
                                    Desktop desktop = Desktop.getDesktop();
                                    File fileToOpen = new File(fileName);
                                    desktop.open(fileToOpen);
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return null;
            }

            @Override
            protected void done() {
                progressDialog.dispose(); // Cierra el diálogo de progreso cuando ha terminado la generación
            }
        };

        worker.execute(); // Inicia el trabajo en segundo plano

        progressDialog.setVisible(true);

    }

    private static String getSelectedFile(String nombre) {
        FileDialog fileDialog = new FileDialog((Frame) null, "Guardar Archivo TXT", FileDialog.SAVE);
        fileDialog.setFile(nombre + ".txt");
        fileDialog.setVisible(true);

        String selectedFile = fileDialog.getFile();
        String selectedDirectory = fileDialog.getDirectory();

        if (selectedFile != null && selectedDirectory != null) {
            return selectedDirectory + selectedFile;
        }

        return null;
    }

    public static void exportTableToZipExport(JTable table, String separator, String nombre, int range, int rangeMin, JDialog progressDialog, boolean abrirDocumento) {
        SwingWorker<String, Void> worker = new SwingWorker<>() {
            @Override
            protected String doInBackground() throws Exception {
                FileDialog fileDialog = new FileDialog((Frame) null, "Save Zip File", FileDialog.SAVE);
                fileDialog.setFile(nombre + ".zip");
                fileDialog.setVisible(true);

                String selectedFile = fileDialog.getFile();
                String selectedDirectory = fileDialog.getDirectory();

                if (selectedFile != null && selectedDirectory != null) {
                    String zipFileName = selectedDirectory + selectedFile;

                    try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFileName))) {
                        TableModel model = table.getModel();
                        int rowCount = model.getRowCount();

                        zipOutputStream.putNextEntry(new ZipEntry(nombre + ".txt"));

                        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(zipOutputStream));
                        for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
                            for (int columnIndex = rangeMin; columnIndex < range; columnIndex++) {
                                Object value = model.getValueAt(rowIndex, columnIndex);
                                if (value != null) {
                                    writer.write(value.toString());
                                }
                                if (columnIndex <= range) {
                                    writer.write(separator);
                                }
                            }
                            writer.newLine();
                        }

                        writer.close();
                        zipOutputStream.closeEntry();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                return selectedFile;
            }

            @Override
            protected void done() {
                progressDialog.dispose();
                String savedFilePath;
                try {
                    savedFilePath = get();
                    if (savedFilePath != null) {
                        JOptionPane.showMessageDialog(null, "Archivo ZIP guardado correctamente en: " + savedFilePath, "Éxito", JOptionPane.INFORMATION_MESSAGE);

                        if (abrirDocumento) {
                            if (Desktop.isDesktopSupported()) {
                                Desktop desktop = Desktop.getDesktop();
                                File fileToOpen = new File(savedFilePath);
                                desktop.open(fileToOpen);
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        worker.execute();

        progressDialog.setVisible(true);
    }

    public void generarExcelComparacion(Map<String, Map<String, String[]>> excelData, CabecerasRender cabecera, String nombreArchivo, boolean abrirDocument) {
        Workbook workbook = new XSSFWorkbook(); // Crear un archivo Excel en formato XLSX

        for (Map.Entry<String, Map<String, String[]>> entry : excelData.entrySet()) {
            String mensaje = entry.getKey();
            Map<String, String[]> hashMapData = entry.getValue();
            Sheet sheet = workbook.createSheet(mensaje); // Crear una hoja con el nombre del mensaje

            int rowIndex = 0;
            Row headerRow = sheet.createRow(rowIndex++);
            headerRow.createCell(0); // Celda en blanco para la columna 1
            XSSFCellStyle[] headerCellStyles = new XSSFCellStyle[cabecera.getCOLUMNAS().size()];

            for (int i = 1; i <= cabecera.getCOLUMNAS().size(); i++) {
                XSSFCellStyle headerCellStyle = (XSSFCellStyle) workbook.createCellStyle();
                IndexedColorMap colorMap = new DefaultIndexedColorMap();
                XSSFColor xssfColor = new XSSFColor(new java.awt.Color(
                        cabecera.getCOLUMNAS().get(i - 1).getCCLR()[0],
                        cabecera.getCOLUMNAS().get(i - 1).getCCLR()[1],
                        cabecera.getCOLUMNAS().get(i - 1).getCCLR()[2]
                ), colorMap);
                headerCellStyle.setFillForegroundColor(xssfColor);
                headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                headerCellStyles[i - 1] = headerCellStyle;
            }

            // Agregar los nombres de las columnas de cabecera
            for (int i = 1; i <= cabecera.getCOLUMNAS().size(); i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(cabecera.getCOLUMNAS().get(i - 1).getDSCRPCN());
                cell.setCellStyle(headerCellStyles[i - 1]);
            }

            // Agregar los datos
            for (Map.Entry<String, String[]> dataEntry : hashMapData.entrySet()) {
                String key = dataEntry.getKey();
                String[] values = dataEntry.getValue();

                Row row = sheet.createRow(rowIndex++); // Crear una fila en la hoja

                // Agregar el nombre de la clave en la primera celda
                Cell keyCell = row.createCell(0);
                keyCell.setCellValue(key);

                // Agregar los valores en celdas siguientes
                for (int i = 0; i < values.length; i++) {
                    Cell cell = row.createCell(i + 1);
                    cell.setCellValue(values[i]);
                }
            }

            // Ajustar el ancho de las columnas
            for (int columnIndex = 0; columnIndex < cabecera.getCOLUMNAS().size() - 1; columnIndex++) {
                sheet.autoSizeColumn(columnIndex);
            }
        }

        // Crear un diálogo de archivo para que el usuario elija la ubicación y el nombre del archivo
        Frame parentFrame = new Frame();
        FileDialog fileDialog = new FileDialog(parentFrame, "Guardar archivo Excel", FileDialog.SAVE);
        fileDialog.setFile(nombreArchivo.toUpperCase() + "_REPORTE DE ERRORES.xlsx"); // Nombre predeterminado del archivo
        fileDialog.setVisible(true);

        String selectedDirectory = fileDialog.getDirectory();
        String selectedFile = fileDialog.getFile();

        if (selectedDirectory != null && selectedFile != null) {
            String filePath = selectedDirectory + selectedFile;
            try {
                FileOutputStream outputStream = new FileOutputStream(filePath);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
                JOptionPane.showMessageDialog(null, "El archivo " + nombreArchivo.toUpperCase() + "_REPORTE DE ERRORES, se ha descargado correctamente.", "Descarga Exitosa", JOptionPane.INFORMATION_MESSAGE);

                if (abrirDocument) {
                    // Abrir el archivo automáticamente si abrirDocument es verdadero después de que se haya hecho clic en "OK"
                    Desktop desktop = Desktop.getDesktop();
                    File excelFile = new File(filePath);
                    desktop.open(excelFile);
                }

            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al descargar el archivo Excel.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
