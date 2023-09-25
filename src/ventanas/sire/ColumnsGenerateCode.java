package ventanas.sire;

import clases.ColumnasSire;
import clases.Empresa;
import java.awt.Dialog;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import ventanas.helpers.ActionsPerformand;
import ventanas.helpers.Helpers;

public class ColumnsGenerateCode extends javax.swing.JPanel {

    private ImageIcon eliminarIcon = new ImageIcon("src/resources/eliminar.png");
    private int nuevoAncho = 16;
    private int nuevoAlto = 16;
    private Empresa empresa = new Empresa();
    List<ColumnasSire> columnasList = new ArrayList<>();

    private ActionsPerformand beansActions = new ActionsPerformand();
    private Helpers helpers = new Helpers();
    private ArrayList<ColumnasSire> cabecerasExport = new ArrayList<ColumnasSire>();
    private boolean eventoActivo = true;

    private Map<String, String> options = Map.of("PLE COMPRAS", "1", "PLE VENTAS", "2", "SIRE COMPRAS", "4", "SIRE VENTAS", "5");

    public ColumnsGenerateCode(Empresa empresa) {
        initComponents();
        this.empresa = empresa;
        eliminarIcon = new ImageIcon(eliminarIcon.getImage().getScaledInstance(nuevoAncho, nuevoAlto, java.awt.Image.SCALE_SMOOTH));
        JDValidacionAdd.setSize(350, 310);
        JDValidacionAdd.setLocationRelativeTo(null);
        JDValidacionAdd.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        ImageIcon icon = new ImageIcon("src/resources/logosystem.png");  // Reemplaza con la ruta a tu icono
        JDValidacionAdd.setIconImage(icon.getImage());
        JDValidacionAdd.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("ejecutando");
                reiniciarAdd();
                obtenerColumnasValidaciones();
            }
        });

        // Establecer el icono para la ventana del JDialog
        llenarCombo();
        actionsListenerTable();
        //obtenerColumnasValidaciones();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JDValidacionAdd = new javax.swing.JDialog();
        JLTitleVentana7 = new javax.swing.JLabel();
        JLTtileArchivoD2 = new javax.swing.JLabel();
        JCConfigValidacionesComboAdd = new javax.swing.JComboBox<>();
        JLTtileArchivoD3 = new javax.swing.JLabel();
        JLTtileArchivoD4 = new javax.swing.JLabel();
        JFConfigComprasAddSire = new javax.swing.JTextField();
        JFConfigComprasAddSire1 = new javax.swing.JTextField();
        JBConfigAddCancel = new javax.swing.JButton();
        JBConfigCompras3 = new javax.swing.JButton();
        JSTable3 = new javax.swing.JScrollPane();
        JTConfigExportacion = new javax.swing.JTable();
        JLTitleVentana6 = new javax.swing.JLabel();
        JBConfigValidacion = new javax.swing.JButton();
        JLTtileArchivoD1 = new javax.swing.JLabel();
        JCConfigValidacionesCombo = new javax.swing.JComboBox<>();
        JBConfigCompras2 = new javax.swing.JButton();
        JBConfigAddValidacion = new javax.swing.JButton();

        JDValidacionAdd.setTitle("SISTEMA SIRE");
        JDValidacionAdd.setBackground(new java.awt.Color(242, 239, 239));
        JDValidacionAdd.setResizable(false);
        JDValidacionAdd.setSize(new java.awt.Dimension(100, 100));
        JDValidacionAdd.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                JDValidacionAddComponentHidden(evt);
            }
        });

        JLTitleVentana7.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        JLTitleVentana7.setForeground(new java.awt.Color(144, 144, 144));
        JLTitleVentana7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLTitleVentana7.setText("AGREGAR VALIDACIÓN");

        JLTtileArchivoD2.setText("N° POSICIÓN");

        JCConfigValidacionesComboAdd.setPreferredSize(new java.awt.Dimension(68, 22));
        JCConfigValidacionesComboAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCConfigValidacionesComboAddActionPerformed(evt);
            }
        });

        JLTtileArchivoD3.setText("TIPO");

        JLTtileArchivoD4.setText("N° COLUMNA");

        JFConfigComprasAddSire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JFConfigComprasAddSireActionPerformed(evt);
            }
        });
        JFConfigComprasAddSire.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JFConfigComprasAddSireKeyTyped(evt);
            }
        });

        JFConfigComprasAddSire1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JFConfigComprasAddSire1ActionPerformed(evt);
            }
        });
        JFConfigComprasAddSire1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JFConfigComprasAddSire1KeyTyped(evt);
            }
        });

        JBConfigAddCancel.setBackground(new java.awt.Color(0, 0, 0));
        JBConfigAddCancel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JBConfigAddCancel.setForeground(new java.awt.Color(255, 255, 255));
        JBConfigAddCancel.setText("CANCELAR");
        JBConfigAddCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBConfigAddCancelActionPerformed(evt);
            }
        });

        JBConfigCompras3.setBackground(new java.awt.Color(102, 102, 255));
        JBConfigCompras3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JBConfigCompras3.setForeground(new java.awt.Color(255, 255, 255));
        JBConfigCompras3.setText("GUADAR");
        JBConfigCompras3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBConfigCompras3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JDValidacionAddLayout = new javax.swing.GroupLayout(JDValidacionAdd.getContentPane());
        JDValidacionAdd.getContentPane().setLayout(JDValidacionAddLayout);
        JDValidacionAddLayout.setHorizontalGroup(
            JDValidacionAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JDValidacionAddLayout.createSequentialGroup()
                .addGroup(JDValidacionAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JDValidacionAddLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(JDValidacionAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLTtileArchivoD3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JCConfigValidacionesComboAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(JDValidacionAddLayout.createSequentialGroup()
                                .addComponent(JLTtileArchivoD4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(JLTtileArchivoD2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(JDValidacionAddLayout.createSequentialGroup()
                                .addComponent(JFConfigComprasAddSire, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(JFConfigComprasAddSire1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(JDValidacionAddLayout.createSequentialGroup()
                                .addComponent(JBConfigAddCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(JBConfigCompras3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(JDValidacionAddLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JLTitleVentana7, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JDValidacionAddLayout.setVerticalGroup(
            JDValidacionAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JDValidacionAddLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(JLTitleVentana7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLTtileArchivoD3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(JCConfigValidacionesComboAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(JDValidacionAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLTtileArchivoD4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLTtileArchivoD2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(JDValidacionAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JFConfigComprasAddSire, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JFConfigComprasAddSire1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(JDValidacionAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JBConfigAddCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBConfigCompras3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        setBackground(new java.awt.Color(242, 239, 239));
        setPreferredSize(new java.awt.Dimension(904, 588));

        JTConfigExportacion.setAutoCreateRowSorter(true);
        JTConfigExportacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "DESCRIPCIÓN", "EMPRESA", "N° COLUMNA", "ORDEN", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
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
            JTConfigExportacion.getColumnModel().getColumn(1).setPreferredWidth(200);
            JTConfigExportacion.getColumnModel().getColumn(2).setPreferredWidth(280);
            JTConfigExportacion.getColumnModel().getColumn(3).setPreferredWidth(115);
            JTConfigExportacion.getColumnModel().getColumn(4).setPreferredWidth(115);
            JTConfigExportacion.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

        JLTitleVentana6.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        JLTitleVentana6.setForeground(new java.awt.Color(144, 144, 144));
        JLTitleVentana6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLTitleVentana6.setText("ESTABLECER CÓDIGOS DE VALIDACIÓN");

        JBConfigValidacion.setBackground(new java.awt.Color(102, 102, 255));
        JBConfigValidacion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JBConfigValidacion.setForeground(new java.awt.Color(255, 255, 255));
        JBConfigValidacion.setText("BUSCAR");
        JBConfigValidacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBConfigValidacionActionPerformed(evt);
            }
        });

        JLTtileArchivoD1.setText("OPCIÓN");

        JCConfigValidacionesCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCConfigValidacionesComboActionPerformed(evt);
            }
        });

        JBConfigCompras2.setBackground(new java.awt.Color(0, 0, 0));
        JBConfigCompras2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JBConfigCompras2.setForeground(new java.awt.Color(255, 255, 255));
        JBConfigCompras2.setText("LIMPIAR");
        JBConfigCompras2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBConfigCompras2ActionPerformed(evt);
            }
        });

        JBConfigAddValidacion.setBackground(new java.awt.Color(75, 153, 80));
        JBConfigAddValidacion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JBConfigAddValidacion.setForeground(new java.awt.Color(255, 255, 255));
        JBConfigAddValidacion.setText("NUEVO");
        JBConfigAddValidacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBConfigAddValidacionActionPerformed(evt);
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
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JLTtileArchivoD1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JCConfigValidacionesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JBConfigValidacion, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(JBConfigAddValidacion, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(JBConfigCompras2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(JSTable3, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addComponent(JLTitleVentana6)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JBConfigValidacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JBConfigCompras2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JBConfigAddValidacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JLTtileArchivoD1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JCConfigValidacionesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JSTable3, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void JBConfigValidacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBConfigValidacionActionPerformed
        obtenerColumnasValidaciones();
    }//GEN-LAST:event_JBConfigValidacionActionPerformed

    private void JCConfigValidacionesComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCConfigValidacionesComboActionPerformed

    }//GEN-LAST:event_JCConfigValidacionesComboActionPerformed

    private void JBConfigCompras2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBConfigCompras2ActionPerformed
        JCConfigValidacionesCombo.setSelectedIndex(0);
        DefaultTableModel modeloTabla = (DefaultTableModel) JTConfigExportacion.getModel();
        modeloTabla.setRowCount(0); // Limpia la tabla
    }//GEN-LAST:event_JBConfigCompras2ActionPerformed

    private void JBConfigAddValidacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBConfigAddValidacionActionPerformed
        JDValidacionAdd.setVisible(true);
    }//GEN-LAST:event_JBConfigAddValidacionActionPerformed

    private void JCConfigValidacionesComboAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCConfigValidacionesComboAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCConfigValidacionesComboAddActionPerformed

    private void JFConfigComprasAddSireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JFConfigComprasAddSireActionPerformed

    }//GEN-LAST:event_JFConfigComprasAddSireActionPerformed

    private void JFConfigComprasAddSireKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JFConfigComprasAddSireKeyTyped
        char c = evt.getKeyChar();
        JTextField textField = (JTextField) evt.getSource();

        if (!(Character.isDigit(c) && textField.getText().length() < 4)) {
            evt.consume();
        }
    }//GEN-LAST:event_JFConfigComprasAddSireKeyTyped

    private void JFConfigComprasAddSire1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JFConfigComprasAddSire1ActionPerformed

    }//GEN-LAST:event_JFConfigComprasAddSire1ActionPerformed

    private void JFConfigComprasAddSire1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JFConfigComprasAddSire1KeyTyped
        char c = evt.getKeyChar();
        JTextField textField = (JTextField) evt.getSource();

        if (!(Character.isDigit(c) && textField.getText().length() < 4)) {
            evt.consume();
        }
    }//GEN-LAST:event_JFConfigComprasAddSire1KeyTyped

    private void JBConfigAddCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBConfigAddCancelActionPerformed
        reiniciarAdd();
    }//GEN-LAST:event_JBConfigAddCancelActionPerformed

    private void reiniciarAdd() {
        JCConfigValidacionesComboAdd.setSelectedIndex(0);
        JFConfigComprasAddSire.setText("");
        JFConfigComprasAddSire1.setText("");
        JDValidacionAdd.setVisible(false);
    }

    private void JBConfigCompras3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBConfigCompras3ActionPerformed
        if (JCConfigValidacionesComboAdd.getSelectedIndex() == 0) {
            helpers.mensajeError("Elija el tipo de registro, validar!.", 2);
            return;
        }

        if (JFConfigComprasAddSire.getText().equals("")) {
            helpers.mensajeError("Ingrese el número de columna, validar!.", 2);
            return;
        }

        if (!this.esNumeroEntero(JFConfigComprasAddSire.getText())) {
            helpers.mensajeError("Ingrese un número de columna correcto, validar!.", 2);
            return;
        }

        if (JFConfigComprasAddSire1.getText().equals("")) {
            helpers.mensajeError("Ingrese el número de posición, validar!.", 2);
            return;
        }

        if (!this.esNumeroEntero(JFConfigComprasAddSire1.getText())) {
            helpers.mensajeError("Ingrese un número de posición correcto, validar!.", 2);
            return;
        }

        Integer ORDN = Integer.parseInt(JFConfigComprasAddSire1.getText());
        Integer NCOLUMNA = Integer.parseInt(JFConfigComprasAddSire.getText());

        String valorSeleccionado = (String) JCConfigValidacionesComboAdd.getSelectedItem();
        String keySelection = options.get(valorSeleccionado);

        beansActions.InsertarColumnaValidacion(this.empresa.getCODRC(),
                keySelection, ORDN, NCOLUMNA, JDValidacionAdd);

    }//GEN-LAST:event_JBConfigCompras3ActionPerformed

    private void JDValidacionAddComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_JDValidacionAddComponentHidden
    }//GEN-LAST:event_JDValidacionAddComponentHidden

    private void llenarCombo() {
        if (JCConfigValidacionesCombo.getItemCount() > 0) {
            JCConfigValidacionesCombo.removeAllItems();
        }

        if (JCConfigValidacionesComboAdd.getItemCount() > 0) {
            JCConfigValidacionesComboAdd.removeAllItems();
        }

        this.JCConfigValidacionesCombo.addItem("--SELECCIONE");
        this.JCConfigValidacionesComboAdd.addItem("--SELECCIONE");

        for (String key : options.keySet()) {
            this.JCConfigValidacionesCombo.addItem(key);
            this.JCConfigValidacionesComboAdd.addItem(key);
        }
    }

    private void obtenerColumnasValidaciones() {
        try {
            String CCBCRA = "";
            if (JCConfigValidacionesCombo.getSelectedIndex() > 0) {
                CCBCRA = options.get(JCConfigValidacionesCombo.getSelectedItem());
                CCBCRA = CCBCRA == null ? "" : CCBCRA;
            }

            this.cabecerasExport = beansActions.obtenerColumnasValidacion(this.empresa.getCODRC(), CCBCRA);
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

                JTConfigExportacion.getColumnModel().getColumn(5).setCellRenderer(iconRenderer);

                int columnaIndex = 1;
                for (ColumnasSire columna : cabecerasExport) {

                    Object[] fila;

                    fila = new Object[]{columnaIndex, columna.getDSCRPCN(), columna.getRSCL(), columna.getNCOLUMNA(), columna.getORDN(), eliminarIcon};

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

                if (columna == 5) {
                    ColumnasSire instanciaColumna = columnasList.get(fila);

                    UIManager.put("OptionPane.yesButtonText", "Sí");
                    UIManager.put("OptionPane.noButtonText", "No");

                    int confirmacion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar este registro?", "Confirmación", JOptionPane.YES_NO_OPTION);

                    // Restablece las opciones de idioma a su valor predeterminado
                    UIManager.put("OptionPane.yesButtonText", UIManager.getString("OptionPane.yesButtonText"));
                    UIManager.put("OptionPane.noButtonText", UIManager.getString("OptionPane.noButtonText"));

                    if (confirmacion == JOptionPane.YES_OPTION) {
                        beansActions.eliminarColumnaValidacion(empresa.getCODRC(), instanciaColumna.getID());

                        obtenerColumnasValidaciones();
                    }

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
    private javax.swing.JButton JBConfigAddCancel;
    private javax.swing.JButton JBConfigAddValidacion;
    private javax.swing.JButton JBConfigCompras2;
    private javax.swing.JButton JBConfigCompras3;
    private javax.swing.JButton JBConfigValidacion;
    private javax.swing.JComboBox<String> JCConfigValidacionesCombo;
    private javax.swing.JComboBox<String> JCConfigValidacionesComboAdd;
    private javax.swing.JDialog JDValidacionAdd;
    private javax.swing.JTextField JFConfigComprasAddSire;
    private javax.swing.JTextField JFConfigComprasAddSire1;
    private javax.swing.JLabel JLTitleVentana6;
    private javax.swing.JLabel JLTitleVentana7;
    private javax.swing.JLabel JLTtileArchivoD1;
    private javax.swing.JLabel JLTtileArchivoD2;
    private javax.swing.JLabel JLTtileArchivoD3;
    private javax.swing.JLabel JLTtileArchivoD4;
    private javax.swing.JScrollPane JSTable3;
    private javax.swing.JTable JTConfigExportacion;
    // End of variables declaration//GEN-END:variables
}
