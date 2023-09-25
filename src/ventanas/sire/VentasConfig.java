package ventanas.sire;

import clases.ColumnasSire;
import clases.Empresa;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import ventanas.helpers.ActionsPerformand;
import ventanas.helpers.Helpers;

public class VentasConfig extends javax.swing.JPanel {

    private ImageIcon editarIcon = new ImageIcon("src/resources/editar.png");
    private ImageIcon eliminarIcon = new ImageIcon("src/resources/eliminar.png");
    private boolean eventoActivo = true;
    List<ColumnasSire> columnasList = new ArrayList<>();

    int nuevoAncho = 16;
    int nuevoAlto = 16;
    private ActionsPerformand beansActions = new ActionsPerformand();
    private ArrayList<ColumnasSire> columnas = new ArrayList<ColumnasSire>();
    private Empresa empresa = new Empresa();
    private Map<String, String> options = Map.of("PLE VENTAS", "2", "SIRE VENTAS", "5");
    private Map<String, String> tipoDatos = Map.of(
            "1", "TEXTO",
            "2", "NÚMERO",
            "3", "MONEDA",
            "4", "FECHA",
            "", ""
    );

    private Helpers helpers = new Helpers();

    public VentasConfig(Empresa empresa) {
        this.empresa = empresa;
        initComponents();

        editarIcon = new ImageIcon(editarIcon.getImage().getScaledInstance(nuevoAncho, nuevoAlto, java.awt.Image.SCALE_SMOOTH));
        eliminarIcon = new ImageIcon(eliminarIcon.getImage().getScaledInstance(nuevoAncho, nuevoAlto, java.awt.Image.SCALE_SMOOTH));
        actionsListenerTable();
        llenarCombos();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JLTtileArchivoD1 = new javax.swing.JLabel();
        JCConfigCompras = new javax.swing.JComboBox<>();
        JFConfigCompras = new javax.swing.JTextField();
        JLTtileArchivoD2 = new javax.swing.JLabel();
        JBConfigCompras = new javax.swing.JButton();
        JSTable3 = new javax.swing.JScrollPane();
        JTConfigCompras = new javax.swing.JTable();
        JBConfigCompras1 = new javax.swing.JButton();
        JBConfigComprasFilter = new javax.swing.JButton();

        setBackground(new java.awt.Color(242, 239, 239));
        setPreferredSize(new java.awt.Dimension(904, 588));

        JLTtileArchivoD1.setText("OPCIÓN");

        JCConfigCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCConfigComprasActionPerformed(evt);
            }
        });

        JLTtileArchivoD2.setText("DESCRIPCIÓN");

        JBConfigCompras.setBackground(new java.awt.Color(102, 102, 255));
        JBConfigCompras.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JBConfigCompras.setForeground(new java.awt.Color(255, 255, 255));
        JBConfigCompras.setText("BUSCAR");
        JBConfigCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBConfigComprasActionPerformed(evt);
            }
        });

        JTConfigCompras.setAutoCreateRowSorter(true);
        JTConfigCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "DESCRIPCIÓN", "CÓDIGO PLE", "CÓDIGO SIRE", "TIPO", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTConfigCompras.setAutoResizeMode(0);
        JTConfigCompras.setColumnSelectionAllowed(true);
        JTConfigCompras.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JTConfigCompras.setGridColor(new java.awt.Color(0, 0, 0));
        JTConfigCompras.setSelectionBackground(new java.awt.Color(102, 102, 102));
        JTConfigCompras.setSelectionForeground(new java.awt.Color(255, 255, 255));
        JSTable3.setViewportView(JTConfigCompras);
        JTConfigCompras.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        if (JTConfigCompras.getColumnModel().getColumnCount() > 0) {
            JTConfigCompras.getColumnModel().getColumn(0).setPreferredWidth(50);
            JTConfigCompras.getColumnModel().getColumn(1).setPreferredWidth(350);
            JTConfigCompras.getColumnModel().getColumn(2).setPreferredWidth(100);
            JTConfigCompras.getColumnModel().getColumn(3).setPreferredWidth(100);
            JTConfigCompras.getColumnModel().getColumn(4).setPreferredWidth(120);
            JTConfigCompras.getColumnModel().getColumn(5).setPreferredWidth(40);
            JTConfigCompras.getColumnModel().getColumn(6).setPreferredWidth(40);
        }

        JBConfigCompras1.setBackground(new java.awt.Color(75, 153, 80));
        JBConfigCompras1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JBConfigCompras1.setForeground(new java.awt.Color(255, 255, 255));
        JBConfigCompras1.setText("NUEVO");
        JBConfigCompras1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBConfigCompras1ActionPerformed(evt);
            }
        });

        JBConfigComprasFilter.setBackground(new java.awt.Color(0, 0, 0));
        JBConfigComprasFilter.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JBConfigComprasFilter.setForeground(new java.awt.Color(255, 255, 255));
        JBConfigComprasFilter.setText("LIMPIAR");
        JBConfigComprasFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBConfigComprasFilterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JLTtileArchivoD1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(JLTtileArchivoD2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JCConfigCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(JFConfigCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(JBConfigCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JBConfigCompras1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addComponent(JBConfigComprasFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JSTable3, javax.swing.GroupLayout.PREFERRED_SIZE, 830, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(158, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLTtileArchivoD1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLTtileArchivoD2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCConfigCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JFConfigCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBConfigCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBConfigCompras1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBConfigComprasFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(JSTable3, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void llenarCombos() {
        if (JCConfigCompras.getItemCount() > 0) {
            JCConfigCompras.removeAllItems();
        }

        this.JCConfigCompras.addItem("--SELECCIONE");
        for (String key : options.keySet()) {
            this.JCConfigCompras.addItem(key);
        }
    }

    private void JCConfigComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCConfigComprasActionPerformed
    }//GEN-LAST:event_JCConfigComprasActionPerformed

    private void JBConfigComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBConfigComprasActionPerformed
        if (JCConfigCompras.getSelectedIndex() == 0) {
            helpers.mensajeError("Selecciona una opción, validar!.", 2);
            return;
        }

        String valorSeleccionado = (String) JCConfigCompras.getSelectedItem();
        String keySelection = options.get(valorSeleccionado);

        obtenerCabecerasRendering(keySelection);
    }//GEN-LAST:event_JBConfigComprasActionPerformed

    private void actionsListenerTable() {
        JTConfigCompras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!eventoActivo) {
                    return; // Si el evento está desactivado, no hagas nada.
                }

                int fila = JTConfigCompras.rowAtPoint(e.getPoint());
                int columna = JTConfigCompras.columnAtPoint(e.getPoint());

                if (columna == 5) {
                    ColumnasSire instanciaColumna = columnasList.get(fila);

                    if (JCConfigCompras.getSelectedIndex() == 0) {
                        helpers.mensajeError("Selecciona una opción, validar!.", 2);
                        return;
                    }

                    String valorSeleccionado = (String) JCConfigCompras.getSelectedItem();
                    String keySelection = options.get(valorSeleccionado);
                    Integer keySelectionOpt = Integer.parseInt(keySelection);

                    ConfiguracionSIREPLE configSirePle = new ConfiguracionSIREPLE(empresa,
                            keySelectionOpt, instanciaColumna, 1);
                    configSirePle.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            obtenerCabecerasRendering(keySelection);
                        }
                    });
                    configSirePle.setVisible(true);
                }

                if (columna == 6) {
                    ColumnasSire instanciaColumna = columnasList.get(fila);

                    int confirmacion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar este elemento?", "Confirmación", JOptionPane.YES_NO_OPTION);

                    if (confirmacion == JOptionPane.YES_OPTION) {
                        if (JCConfigCompras.getSelectedIndex() == 0) {
                            helpers.mensajeError("Selecciona una opción, validar!.", 2);
                            return;
                        }

                        String valorSeleccionado = (String) JCConfigCompras.getSelectedItem();
                        String keySelection = options.get(valorSeleccionado);

                        beansActions.eliminarCabceraPLESIRE(empresa.getCODRC(), keySelection, instanciaColumna.getID());
                        obtenerCabecerasRendering(keySelection);
                    }
                }
            }
        });
    }

    private void obtenerCabecerasRendering(String keySelection) {
        try {

            DefaultTableModel modeloTabla = (DefaultTableModel) JTConfigCompras.getModel();
            modeloTabla.setRowCount(0); // Limpia la tabla
            columnas = beansActions.obtenerCabecerasEmpresa(this.empresa.getCODRC(), keySelection, JFConfigCompras.getText());
            columnasList.clear();

            if (columnas.size() > 0) {

                DefaultTableCellRenderer iconRenderer = new DefaultTableCellRenderer() {
                    @Override
                    public void setValue(Object value) {
                        setIcon((value instanceof ImageIcon) ? (ImageIcon) value : null);
                    }
                };

                JTConfigCompras.getColumnModel().getColumn(5).setCellRenderer(iconRenderer);
                JTConfigCompras.getColumnModel().getColumn(6).setCellRenderer(iconRenderer);

                // Itera sobre la lista 'columnas' y agrega cada elemento a la tabla
                int columnaIndex = 1;
                for (ColumnasSire columna : columnas) {
                    Integer valorEntero = columna.getTYPECOLUMN();
                    String valorConvertido = (valorEntero != null) ? String.valueOf(valorEntero) : "";

                    Object[] fila;
                    if (Integer.parseInt(keySelection) < 3) {
                        fila = new Object[]{columnaIndex, columna.getDSCRPCN(), columna.getNPCSN(), columna.getCODPLE(), tipoDatos.get(valorConvertido), editarIcon, eliminarIcon};
                    } else {
                        fila = new Object[]{columnaIndex, columna.getDSCRPCN(), columna.getCODPLE(), columna.getNPCSN(), tipoDatos.get(valorConvertido), editarIcon, eliminarIcon};
                    }
                    columnaIndex++;
                    modeloTabla.addRow(fila);
                    columnasList.add(columna);
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(VentasConfig.class.getName()).log(Level.SEVERE, null, ex);
            helpers.mensajeError("Ocurrió un error, ¡validar!", 2);
            return;
        }
    }
    private void JBConfigCompras1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBConfigCompras1ActionPerformed
        if (JCConfigCompras.getSelectedIndex() == 0) {
            helpers.mensajeError("Selecciona una opción, validar!.", 2);
            return;
        }

        String valorSeleccionado = (String) JCConfigCompras.getSelectedItem();
        String keySelection = options.get(valorSeleccionado);
        Integer keySelectionOpt = Integer.parseInt(keySelection);

        JBConfigCompras1.setEnabled(false);
        ConfiguracionSIREPLE configSirePle = new ConfiguracionSIREPLE(this.empresa, keySelectionOpt, null, 0);
        configSirePle.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                obtenerCabecerasRendering(keySelection);
                JBConfigCompras1.setEnabled(true);
            }
        });

        configSirePle.setVisible(true);
    }//GEN-LAST:event_JBConfigCompras1ActionPerformed

    private void JBConfigComprasFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBConfigComprasFilterActionPerformed
        // TODO add your handling code here:
        JCConfigCompras.setSelectedIndex(0);
        JFConfigCompras.setText("");
        DefaultTableModel modeloTabla = (DefaultTableModel) JTConfigCompras.getModel();
        modeloTabla.setRowCount(0); // Limpia la tabla
    }//GEN-LAST:event_JBConfigComprasFilterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBConfigCompras;
    private javax.swing.JButton JBConfigCompras1;
    private javax.swing.JButton JBConfigComprasFilter;
    private javax.swing.JComboBox<String> JCConfigCompras;
    private javax.swing.JTextField JFConfigCompras;
    private javax.swing.JLabel JLTtileArchivoD1;
    private javax.swing.JLabel JLTtileArchivoD2;
    private javax.swing.JScrollPane JSTable3;
    private javax.swing.JTable JTConfigCompras;
    // End of variables declaration//GEN-END:variables
}
