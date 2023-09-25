package ventanas.sire;

import clases.CabecerasRender;
import clases.Empresa;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import ventanas.helpers.ActionsPerformand;
import ventanas.helpers.Helpers;

public class ColumnsExportConfig extends javax.swing.JPanel {

    private ImageIcon guardarIcon = new ImageIcon("src/resources/guardar.png");
    private int nuevoAncho = 16;
    private int nuevoAlto = 16;
    private Empresa empresa = new Empresa();
    List<CabecerasRender> columnasList = new ArrayList<>();

    private ActionsPerformand beansActions = new ActionsPerformand();
    private Helpers helpers = new Helpers();
    private ArrayList<CabecerasRender> cabecerasExport = new ArrayList<CabecerasRender>();
    private boolean eventoActivo = true;

    public ColumnsExportConfig(Empresa empresa) {
        initComponents();

        this.empresa = empresa;
        guardarIcon = new ImageIcon(guardarIcon.getImage().getScaledInstance(nuevoAncho, nuevoAlto, java.awt.Image.SCALE_SMOOTH));
        actionsListenerTable();
        //obtenerRangosExportacion();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JSTable3 = new javax.swing.JScrollPane();
        JTConfigExportacion = new javax.swing.JTable();
        JLTitleVentana6 = new javax.swing.JLabel();
        JBConfigCompras1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(242, 239, 239));
        setPreferredSize(new java.awt.Dimension(904, 588));

        JTConfigExportacion.setAutoCreateRowSorter(true);
        JTConfigExportacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "DESCRIPCIÓN", "INICIO PLE", "FIN DE PLE", "INICIO SIRE", "FIN SIRE", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTConfigExportacion.setAutoResizeMode(0);
        JTConfigExportacion.setColumnSelectionAllowed(true);
        JTConfigExportacion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JTConfigExportacion.setGridColor(new java.awt.Color(0, 0, 0));
        JTConfigExportacion.setSelectionBackground(new java.awt.Color(102, 102, 102));
        JTConfigExportacion.setSelectionForeground(new java.awt.Color(255, 255, 255));
        JSTable3.setViewportView(JTConfigExportacion);
        JTConfigExportacion.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (JTConfigExportacion.getColumnModel().getColumnCount() > 0) {
            JTConfigExportacion.getColumnModel().getColumn(0).setPreferredWidth(50);
            JTConfigExportacion.getColumnModel().getColumn(1).setPreferredWidth(250);
            JTConfigExportacion.getColumnModel().getColumn(2).setPreferredWidth(115);
            JTConfigExportacion.getColumnModel().getColumn(3).setPreferredWidth(115);
            JTConfigExportacion.getColumnModel().getColumn(4).setPreferredWidth(115);
            JTConfigExportacion.getColumnModel().getColumn(5).setPreferredWidth(115);
            JTConfigExportacion.getColumnModel().getColumn(6).setPreferredWidth(50);
        }

        JLTitleVentana6.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        JLTitleVentana6.setForeground(new java.awt.Color(144, 144, 144));
        JLTitleVentana6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLTitleVentana6.setText("ESTABLECER RANGOS DE EXPORTACIÓN");

        JBConfigCompras1.setBackground(new java.awt.Color(75, 153, 80));
        JBConfigCompras1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JBConfigCompras1.setForeground(new java.awt.Color(255, 255, 255));
        JBConfigCompras1.setText("ACTUALIZAR");
        JBConfigCompras1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBConfigCompras1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(JLTitleVentana6, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JBConfigCompras1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JSTable3, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(JLTitleVentana6)
                .addGap(24, 24, 24)
                .addComponent(JBConfigCompras1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JSTable3, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JBConfigCompras1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBConfigCompras1ActionPerformed
        obtenerRangosExportacion();
    }//GEN-LAST:event_JBConfigCompras1ActionPerformed

    private void obtenerRangosExportacion() {
        try {
            this.cabecerasExport = beansActions.obtenerRangosExpotacion(this.empresa.getCODRC());
            columnasList.clear();
            if (cabecerasExport.size() > 0) {
                DefaultTableModel modeloTabla = (DefaultTableModel) JTConfigExportacion.getModel();
                modeloTabla.setRowCount(0); // Limpia la tabla

                DefaultTableCellRenderer iconRenderer = new DefaultTableCellRenderer() {
                    @Override
                    public void setValue(Object value) {
                        setIcon((value instanceof ImageIcon) ? (ImageIcon) value : null);
                    }
                };

                JTConfigExportacion.getColumnModel().getColumn(6).setCellRenderer(iconRenderer);

                // Itera sobre la lista 'columnas' y agrega cada elemento a la tabla
                int columnaIndex = 1;
                for (CabecerasRender columna : cabecerasExport) {

                    Object[] fila;

                    fila = new Object[]{columnaIndex, columna.getDSCRPCN(), columna.getINITPLE(), columna.getFINPLE(), columna.getINITSIRE(), columna.getFINSIRE(), guardarIcon};

                    columnaIndex++;
                    modeloTabla.addRow(fila);
                    columnasList.add(columna);
                }

            }
        } catch (Exception e) {
            helpers.mensajeError(e.getMessage(), 2);
            return;
        }
    }

    private void actionsListenerTable() {
        JTConfigExportacion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!eventoActivo) {
                    return; // Si el evento está desactivado, no hagas nada.
                }

                int fila = JTConfigExportacion.rowAtPoint(e.getPoint());
                int columna = JTConfigExportacion.columnAtPoint(e.getPoint());

                if (columna == 6) {
                    CabecerasRender instanciaColumna = columnasList.get(fila);

                    // Obtener los datos de la fila modificada
                    String columna1 = JTConfigExportacion.getValueAt(fila, 2).toString();  // Reemplaza 0 con el índice de la columna que deseas obtener
                    String columna2 = JTConfigExportacion.getValueAt(fila, 3).toString();  // Reemplaza 1 con el índice de la columna que deseas obtener
                    String columna3 = JTConfigExportacion.getValueAt(fila, 4).toString();  // Reemplaza 1 con el índice de la columna que deseas obtener
                    String columna4 = JTConfigExportacion.getValueAt(fila, 5).toString();  // Reemplaza 1 con el índice de la columna que deseas obtener

                    if (!esNumeroEntero(columna1)) {
                        helpers.mensajeError("Inicio de PLE no es correcto. Por favor, validar.", 2);
                        return;
                    }

                    if (!esNumeroEntero(columna2)) {
                        helpers.mensajeError("Fin de PLE no es correcto. Por favor, validar.", 2);
                        return;
                    }

                    if (!esNumeroEntero(columna3)) {
                        helpers.mensajeError("Inicio de SIRE no es correcto. Por favor, validar.", 2);
                        return;
                    }

                    if (!esNumeroEntero(columna4)) {
                        helpers.mensajeError("Fin de SIRE no es correcto. Por favor, validar.", 2);
                        return;
                    }

                    beansActions.ActualizarRangosExportacion(instanciaColumna.getID(), empresa.getCODRC(), 
                            Integer.parseInt(columna1), Integer.parseInt(columna2), Integer.parseInt(columna3), 
                            Integer.parseInt(columna4)
                            );
                    obtenerRangosExportacion();
                }
            }
        });
    }

    private boolean esNumeroEntero(String valor) {
        try {
            Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBConfigCompras1;
    private javax.swing.JLabel JLTitleVentana6;
    private javax.swing.JScrollPane JSTable3;
    private javax.swing.JTable JTConfigExportacion;
    // End of variables declaration//GEN-END:variables
}
