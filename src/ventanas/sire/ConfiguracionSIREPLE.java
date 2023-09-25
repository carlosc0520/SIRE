package ventanas.sire;

import clases.ColumnasSire;
import clases.Empresa;
import java.awt.Dialog;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import ventanas.helpers.ActionsPerformand;
import ventanas.helpers.Helpers;

public class ConfiguracionSIREPLE extends javax.swing.JFrame {

    private ActionsPerformand beansActions = new ActionsPerformand();
    private Helpers helpers = new Helpers();
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private Map<String, String> tipoDatos = Map.of(
            "TEXTO", "1",
            "NÚMERO", "2",
            "MONEDA", "3",
            "FECHA", "4"
    );
    private Map<String, String> tipoDatosRev = Map.of(
            "1", "TEXTO",
            "2", "NÚMERO",
            "3", "MONEDA",
            "4", "FECHA"
    );

    private Map<Integer, String> tipoConfig = new HashMap<>() {
        {
            put(1, "CONFIGURACIÓN PLE COMPRAS");
            put(2, "CONFIGURACIÓN PLE VENTAS");
            put(3, "CONFIGURACIÓN PLE NO DOMICILIADOS");
            put(4, "CONFIGURACIÓN SIRE COMPRAS");
            put(5, "CONFIGURACIÓN SIRE VENTAS");
            put(6, "CONFIGURACIÓN SIRE NO DOMICILIADOS");
        }
    };
    private String[] itemsValidacion;
    private List<String> itemsNOADMITIDAS = new ArrayList<>();
    private List<String> itemsVALIDACIONES = new ArrayList<>();
    private Empresa empresa;
    private Integer keySelection;
    private ColumnasSire column;
    private DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<String> comboBoxModelPLE = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<String> comboBoxModelDEFECT = new DefaultComboBoxModel<>();
    private DefaultComboBoxModel<String> comboBoxModelVAL = new DefaultComboBoxModel<>();
    private Integer typeEdition;
    private String DSCRPCN;
    private String NADMTDS;
    private String VVLDCNS;
    private Integer TYPECOLUMN;
    private Integer CLMNDFLT;
    private Integer CDVLDCN;
    private Integer NPCSN;
    private Integer CODPLE;

    public ConfiguracionSIREPLE(Empresa empresa, Integer keySelection, ColumnasSire column, Integer typeEdition) {
        this.setVisible(false);
        initComponents();

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        setIconImage(getIconImage());

        JDLoading.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        JDLoading.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        JDLoading.setSize(250, 150);
        JDLoading.setLocationRelativeTo(null);
        ImageIcon loadingIcon = new ImageIcon("src/resources/Spinner.gif"); // Reemplaza "ruta_de_tu_archivo.gif" con la ruta de tu archivo GIF
        loadingIcon = new ImageIcon(loadingIcon.getImage().getScaledInstance(JDLoading.getWidth(), JDLoading.getHeight(), Image.SCALE_DEFAULT));
        jLabel6.setIcon(loadingIcon);
        jLabel6.setOpaque(false);

        this.setTitle("SISTEMA SIRE");
        this.JLTitleVentanaConfig.setText(tipoConfig.get(keySelection));
        this.empresa = empresa;
        this.keySelection = keySelection;
        this.column = column;
        this.typeEdition = typeEdition;
        JListConfigAdd.setModel(listModel);
        JCConfigTpoDatoAdd.setModel(comboBoxModel);
        JCConfigPleAdd.setModel(comboBoxModelPLE);
        JCConfigDefectoAdd.setModel(comboBoxModelDEFECT);
        JCConfigValidacionAdd.setModel(comboBoxModelVAL);

        ObtenerDatos();
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("resources/logosystem.png"));
        return retValue;
    }

    private void ObtenerDatos() {

        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                obtenerItemValidacion();
                ocultarObligatorios();

                if (typeEdition == 1) {
                    replaceValores();
                }

                return null;
            }

            @Override
            protected void done() {
                JDLoading.dispose();
                setVisible(true);
            }
        };

        worker.execute();
        JDLoading.setVisible(true);

    }

    private void modificarListItems(int indicador) {
        List<String> items = indicador == 1 ? itemsNOADMITIDAS : itemsVALIDACIONES;
        listModel.removeAllElements();

        if (items.size() > 0) {
            for (String valor : items) {
                listModel.addElement(valor);
            }
        }

        JFConfigComprasAddItem.setText("");
    }

    private void replaceValores() {
        JFConfigComprasAddDesp.setText(this.column.getDSCRPCN());
        String getTPODTO = tipoDatosRev.get(this.column.getTYPECOLUMN().toString());
        int selectedIndex = comboBoxModel.getIndexOf(getTPODTO);
        if (selectedIndex != -1) {
            comboBoxModel.setSelectedItem(getTPODTO);
        }

        if (column.getVVLDCNS().length > 0) {
            for (String item : column.getVVLDCNS()) {
                this.itemsVALIDACIONES.add(item);
            }
        }

        if (column.getNADMTDS().length > 0) {
            for (String item : column.getNADMTDS()) {
                this.itemsNOADMITIDAS.add(item);
            }
        }

        if (keySelection < 4) {
            JFConfigComprasAddPle.setText(this.column.getNPCSN().toString());

        } else {
            JFConfigComprasAddSire.setText(this.column.getNPCSN().toString());

            String getTPODTOPLE = this.column.getCODPLE().toString();
            for (int i = 0; i < comboBoxModelPLE.getSize(); i++) {
                String item = (String) comboBoxModelPLE.getElementAt(i);
                if (item != null && item.startsWith(getTPODTOPLE + "-")) {
                    JCConfigPleAdd.setSelectedIndex(i);
                    break; // Rompe el bucle si encuentra una coincidencia
                }
            }

            Integer validar = this.column.getCLMNDFLT();
            if (validar != null) {
                String getTPODTODEFECT = String.valueOf(this.column.getCLMNDFLT());
                for (int i = 0; i < comboBoxModelDEFECT.getSize(); i++) {
                    String item = (String) comboBoxModelDEFECT.getElementAt(i);
                    if (item != null && item.startsWith(getTPODTODEFECT + "-")) {
                        JCConfigDefectoAdd.setSelectedIndex(i);
                        break;
                    }
                }
            }

            if (this.column.getCDVLDCN() != null) {
                String getTPODTOVAL = this.column.getCDVLDCN().toString();
                for (int i = 0; i < comboBoxModelVAL.getSize(); i++) {
                    String item = (String) comboBoxModelVAL.getElementAt(i);
                    if (item != null && item.startsWith(getTPODTOVAL + "-")) {
                        JCConfigValidacionAdd.setSelectedIndex(i);
                        break;
                    }
                }
            }

        }
    }

    private void ocultarObligatorios() {
        if (this.keySelection < 4) {
            JLOblig1.setVisible(false);
            JCConfigPleAdd.setEnabled(false);
            JCConfigDefectoAdd.setEnabled(false);
            JCConfigValidacionAdd.setEnabled(false);
            JCConfigPleAdd.setEnabled(false);
            JFConfigComprasAddSire.setEnabled(false);
        } else {
            JFConfigComprasAddPle.setEnabled(false);
            JLOblig2.setVisible(false);
        }
    }

    private void obtenerItemValidacion() {
        try {

            JCConfigPleAdd.addItem("--Seleccione");
            JCConfigDefectoAdd.addItem("--Seleccione");
            JCConfigTpoDatoAdd.addItem("--Seleccione");
            JCConfigValidacionAdd.addItem("--Seleccione");

            if (this.keySelection > 3) {
                this.itemsValidacion = beansActions.obtenerColumnasRender(this.empresa.getCODRC(), keySelection.toString());
                for (String item : itemsValidacion) {
                    JCConfigPleAdd.addItem(item);
                    JCConfigDefectoAdd.addItem(item);
                    JCConfigValidacionAdd.addItem(item);
                }
            }

            for (Map.Entry<String, String> entry : tipoDatos.entrySet()) {
                String key = entry.getKey();
                JCConfigTpoDatoAdd.addItem(key);
            }

        } catch (Exception e) {
            helpers.mensajeError("Ocurrio un error, porfavor vuelta a intentar!.", ERROR);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JGroupActions = new javax.swing.ButtonGroup();
        JDLoading = new javax.swing.JDialog();
        jLabel6 = new javax.swing.JLabel();
        JLTitleVentanaConfig = new javax.swing.JLabel();
        JLTtileArchivoV = new javax.swing.JLabel();
        JFConfigComprasAddSire = new javax.swing.JTextField();
        JLTtileArchivoV1 = new javax.swing.JLabel();
        JLTtileArchivoV2 = new javax.swing.JLabel();
        JFConfigComprasAddItem = new javax.swing.JTextField();
        JFConfigComprasAddPle = new javax.swing.JTextField();
        JLTtileArchivoV3 = new javax.swing.JLabel();
        JCConfigTpoDatoAdd = new javax.swing.JComboBox<>();
        JLOblig1 = new javax.swing.JLabel();
        JLOblig2 = new javax.swing.JLabel();
        JLTtileArchivoV4 = new javax.swing.JLabel();
        JCConfigDefectoAdd = new javax.swing.JComboBox<>();
        JCConfigPleAdd = new javax.swing.JComboBox<>();
        JLTtileArchivoV5 = new javax.swing.JLabel();
        JRNoAdmitidasAdd = new javax.swing.JRadioButton();
        JRValidacionesAdd = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JListConfigAdd = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        JFConfigComprasAddDesp = new javax.swing.JTextField();
        JBConfigAddCancel = new javax.swing.JButton();
        JBConfigCompras2 = new javax.swing.JButton();
        JLTtileArchivoV6 = new javax.swing.JLabel();
        JLOblig3 = new javax.swing.JLabel();
        JLOblig6 = new javax.swing.JLabel();
        JCConfigValidacionAdd = new javax.swing.JComboBox<>();
        JLTtileArchivoV7 = new javax.swing.JLabel();

        JDLoading.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        JDLoading.setTitle("Espere un momento..");
        JDLoading.setBackground(new java.awt.Color(255, 255, 255));
        JDLoading.setResizable(false);
        JDLoading.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Spinner.gif"))); // NOI18N
        JDLoading.getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 130));

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(242, 239, 239));
        setPreferredSize(new java.awt.Dimension(500, 495));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JLTitleVentanaConfig.setFont(new java.awt.Font("Calibri", 1, 22)); // NOI18N
        JLTitleVentanaConfig.setForeground(new java.awt.Color(144, 144, 144));
        JLTitleVentanaConfig.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLTitleVentanaConfig.setText("CONFIGURACIÓN ");
        getContentPane().add(JLTitleVentanaConfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 500, 40));

        JLTtileArchivoV.setText("TIPO DE VALOR");
        getContentPane().add(JLTtileArchivoV, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 240, 30));

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
        getContentPane().add(JFConfigComprasAddSire, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 100, 30));

        JLTtileArchivoV1.setText("DESCRIPCIÓN");
        getContentPane().add(JLTtileArchivoV1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 100, 30));

        JLTtileArchivoV2.setText("CÓDIGO PLE");
        getContentPane().add(JLTtileArchivoV2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 100, 30));
        getContentPane().add(JFConfigComprasAddItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, 120, 30));

        JFConfigComprasAddPle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JFConfigComprasAddPleActionPerformed(evt);
            }
        });
        JFConfigComprasAddPle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JFConfigComprasAddPleKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JFConfigComprasAddPleKeyTyped(evt);
            }
        });
        getContentPane().add(JFConfigComprasAddPle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 100, 30));

        JLTtileArchivoV3.setText("CÓDIGO SIRE");
        getContentPane().add(JLTtileArchivoV3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 100, 30));

        JCConfigTpoDatoAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCConfigTpoDatoAddActionPerformed(evt);
            }
        });
        getContentPane().add(JCConfigTpoDatoAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 130, 30));

        JLOblig1.setForeground(new java.awt.Color(255, 0, 51));
        JLOblig1.setText("*");
        getContentPane().add(JLOblig1, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 107, 30, -1));

        JLOblig2.setForeground(new java.awt.Color(255, 0, 51));
        JLOblig2.setText("*");
        getContentPane().add(JLOblig2, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 107, 30, -1));

        JLTtileArchivoV4.setText("COLUMNA POR DEFECTO");
        getContentPane().add(JLTtileArchivoV4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 240, 30));

        JCConfigDefectoAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCConfigDefectoAddActionPerformed(evt);
            }
        });
        getContentPane().add(JCConfigDefectoAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 220, 30));

        JCConfigPleAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCConfigPleAddActionPerformed(evt);
            }
        });
        getContentPane().add(JCConfigPleAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 220, 30));

        JLTtileArchivoV5.setText("VALOR");
        getContentPane().add(JLTtileArchivoV5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, 80, 30));

        JGroupActions.add(JRNoAdmitidasAdd);
        JRNoAdmitidasAdd.setText("VALORES NO ADMITIDOS");
        JRNoAdmitidasAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRNoAdmitidasAddActionPerformed(evt);
            }
        });
        getContentPane().add(JRNoAdmitidasAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 170, -1));

        JGroupActions.add(JRValidacionesAdd);
        JRValidacionesAdd.setText("VALORES VALIDAR");
        JRValidacionesAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRValidacionesAddActionPerformed(evt);
            }
        });
        getContentPane().add(JRValidacionesAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(329, 245, 140, 30));

        jScrollPane1.setViewportView(JListConfigAdd);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 320, 110));

        jButton1.setText("ELIMINAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 380, 120, 20));

        jButton2.setText("AGREGAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, 120, 20));
        getContentPane().add(JFConfigComprasAddDesp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 450, 30));

        JBConfigAddCancel.setBackground(new java.awt.Color(0, 0, 0));
        JBConfigAddCancel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JBConfigAddCancel.setForeground(new java.awt.Color(255, 255, 255));
        JBConfigAddCancel.setText("CANCELAR");
        JBConfigAddCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBConfigAddCancelActionPerformed(evt);
            }
        });
        getContentPane().add(JBConfigAddCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 420, 140, 30));

        JBConfigCompras2.setBackground(new java.awt.Color(102, 102, 255));
        JBConfigCompras2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JBConfigCompras2.setForeground(new java.awt.Color(255, 255, 255));
        JBConfigCompras2.setText("GUADAR");
        JBConfigCompras2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBConfigCompras2ActionPerformed(evt);
            }
        });
        getContentPane().add(JBConfigCompras2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 420, 140, 30));

        JLTtileArchivoV6.setText("COLUMNA PLE");
        getContentPane().add(JLTtileArchivoV6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 240, 30));

        JLOblig3.setForeground(new java.awt.Color(255, 0, 51));
        JLOblig3.setText("*");
        getContentPane().add(JLOblig3, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 47, 30, -1));

        JLOblig6.setForeground(new java.awt.Color(255, 0, 51));
        JLOblig6.setText("*");
        getContentPane().add(JLOblig6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 227, 30, -1));

        JCConfigValidacionAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCConfigValidacionAddActionPerformed(evt);
            }
        });
        getContentPane().add(JCConfigValidacionAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 220, 30));

        JLTtileArchivoV7.setText("COLUMNA DE VALIDACIÓN");
        getContentPane().add(JLTtileArchivoV7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 240, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JCConfigTpoDatoAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCConfigTpoDatoAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCConfigTpoDatoAddActionPerformed

    private void JCConfigDefectoAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCConfigDefectoAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCConfigDefectoAddActionPerformed

    private void JCConfigPleAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCConfigPleAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCConfigPleAddActionPerformed

    private void JRNoAdmitidasAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRNoAdmitidasAddActionPerformed
        modificarListItems(1);
    }//GEN-LAST:event_JRNoAdmitidasAddActionPerformed

    private void JBConfigAddCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBConfigAddCancelActionPerformed
        dispose();
    }//GEN-LAST:event_JBConfigAddCancelActionPerformed

    private void JBConfigCompras2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBConfigCompras2ActionPerformed
        // validar todos los campos..............
        DSCRPCN = JFConfigComprasAddDesp.getText().trim();
        NADMTDS = itemsNOADMITIDAS.size() > 0 ? String.join(",", itemsNOADMITIDAS) : "";
        VVLDCNS = itemsVALIDACIONES.size() > 0 ? String.join(",", itemsVALIDACIONES) : "";
        TYPECOLUMN = JCConfigTpoDatoAdd.getSelectedIndex() == 0 ? 0 : Integer.parseInt(tipoDatos.get(JCConfigTpoDatoAdd.getSelectedItem()));
        CLMNDFLT = -1;
        CDVLDCN = -1;
        NPCSN = -1;
        CODPLE = -1;

        if (DSCRPCN.equals("")) {
            helpers.mensajeError("La descripción es obligatoria, validar!.", 2);
            return;
        }

        if (TYPECOLUMN == 0) {
            helpers.mensajeError("Seleccione el tipo de valor a almacenar, validar!.", 2);
            return;
        }

        if (this.keySelection < 4) {
            String S_NPCSNS = JFConfigComprasAddPle.getText().trim();
            if (!S_NPCSNS.matches("\\d+")) {
                helpers.mensajeError("El código de PLE contiene letras, validar!.", 2);
                return;
            }

            NPCSN = Integer.parseInt(S_NPCSNS);
            CODPLE = -1;
        } else {
            String S_NPCSNS = JFConfigComprasAddSire.getText().trim();
            if (!S_NPCSNS.matches("\\d+")) {
                helpers.mensajeError("El código de SIRE contiene letras, validar!.", 2);
                return;
            }

            NPCSN = Integer.parseInt(S_NPCSNS);

            if (JCConfigPleAdd.getSelectedIndex() > 0) {
                String columnaPLE = (String) JCConfigPleAdd.getSelectedItem();
                String[] partes = columnaPLE.split("-");
                if (partes.length > 0) {
                    try {
                        CODPLE = Integer.parseInt(partes[0]);
                    } catch (NumberFormatException e) {
                        CODPLE = -1;
                        helpers.mensajeError("Ocurrió un error al obtener el código de PLE, validar!.", 2);
                    }
                }
            }


            if (JCConfigDefectoAdd.getSelectedIndex() > 0) {
                String columnaDEFAULT = (String) JCConfigDefectoAdd.getSelectedItem();
                String[] partesDEFAULT = columnaDEFAULT.split("-");
                if (partesDEFAULT.length > 0) {
                    try {
                        CLMNDFLT = Integer.parseInt(partesDEFAULT[0]);
                    } catch (NumberFormatException e) {
                        helpers.mensajeError("Ocurrió un error al obtener el código de la columan POR DEFECTO, validar!.", 2);
                        return;
                    }
                }
            }

            if (JCConfigValidacionAdd.getSelectedIndex() > 0) {
                String columnaCDVLDCN = (String) JCConfigValidacionAdd.getSelectedItem();
                String[] partesCDVLDCN = columnaCDVLDCN.split("-");
                if (partesCDVLDCN.length > 0) {
                    try {
                        CDVLDCN = Integer.parseInt(partesCDVLDCN[0]);
                    } catch (NumberFormatException e) {
                        helpers.mensajeError("Ocurrió un error al obtener el código de la columan de VALIDACIÓN, validar!.", 2);
                        return;
                    }
                }
            }

        }

        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                // TOODO EXITOSO....
                if (typeEdition == 1) {
                    beansActions.ActualizarCabceraPLESIRE(empresa.getCODRC(), String.valueOf(keySelection), DSCRPCN, "255,255,255", NPCSN, CODPLE, CDVLDCN, NADMTDS, VVLDCNS, CLMNDFLT, TYPECOLUMN, ConfiguracionSIREPLE.this, column.getID());
                } else {
                    beansActions.InsertarCabceraPLESIRE(empresa.getCODRC(), String.valueOf(keySelection), DSCRPCN, "255,255,255", NPCSN, CODPLE, CDVLDCN, NADMTDS, VVLDCNS, CLMNDFLT, TYPECOLUMN, ConfiguracionSIREPLE.this);
                }

                return null;
            }

            @Override
            protected void done() {
                JDLoading.dispose();
            }
        };

        worker.execute();
        JDLoading.setVisible(true);

    }//GEN-LAST:event_JBConfigCompras2ActionPerformed

    private void JFConfigComprasAddPleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JFConfigComprasAddPleKeyPressed

    }//GEN-LAST:event_JFConfigComprasAddPleKeyPressed

    private void JFConfigComprasAddPleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JFConfigComprasAddPleKeyTyped
        char c = evt.getKeyChar();
        JTextField textField = (JTextField) evt.getSource();

        if (!(Character.isDigit(c) && textField.getText().length() < 4)) {
            evt.consume();
        }
    }//GEN-LAST:event_JFConfigComprasAddPleKeyTyped

    private void JFConfigComprasAddSireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JFConfigComprasAddSireActionPerformed

    }//GEN-LAST:event_JFConfigComprasAddSireActionPerformed

    private void JFConfigComprasAddSireKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JFConfigComprasAddSireKeyTyped
        char c = evt.getKeyChar();
        JTextField textField = (JTextField) evt.getSource();

        if (!(Character.isDigit(c) && textField.getText().length() < 4)) {
            evt.consume();
        }
    }//GEN-LAST:event_JFConfigComprasAddSireKeyTyped

    private void JRValidacionesAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRValidacionesAddActionPerformed
        modificarListItems(2);
    }//GEN-LAST:event_JRValidacionesAddActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (JFConfigComprasAddItem.getText().equals("")) {
            helpers.mensajeError("Ingrese un valor, validar!.", 2);
            return;
        }

        String valor = JFConfigComprasAddItem.getText().trim();
        if (JRNoAdmitidasAdd.isSelected()) {
            if (!itemsNOADMITIDAS.contains(valor)) {
                itemsNOADMITIDAS.add(valor);
            } else {
                helpers.mensajeError("El valor ingresado ya existe, validar!.", 2);
                return;
            }
        }

        if (JRValidacionesAdd.isSelected()) {
            if (!itemsVALIDACIONES.contains(valor)) {
                itemsVALIDACIONES.add(valor);
            } else {
                helpers.mensajeError("El valor ingresado ya existe, validar!.", 2);
                return;
            }
        }

        modificarListItems(JRNoAdmitidasAdd.isSelected() ? 1 : 2);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int selectedIndex = JListConfigAdd.getSelectedIndex();

        if (selectedIndex != -1) {
            if (JRNoAdmitidasAdd.isSelected()) {
                itemsNOADMITIDAS.remove(selectedIndex);
            }

            if (JRValidacionesAdd.isSelected()) {
                itemsVALIDACIONES.remove(selectedIndex);
            }

            listModel.remove(selectedIndex);
            modificarListItems(JRNoAdmitidasAdd.isSelected() ? 1 : 2);
        } else {
            helpers.mensajeError("No se a seleccionado un elemento, validar!.", 2);
            return;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void JCConfigValidacionAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCConfigValidacionAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCConfigValidacionAddActionPerformed

    private void JFConfigComprasAddPleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JFConfigComprasAddPleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JFConfigComprasAddPleActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConfiguracionSIREPLE.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfiguracionSIREPLE.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfiguracionSIREPLE.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfiguracionSIREPLE.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConfiguracionSIREPLE(null, null, null, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBConfigAddCancel;
    private javax.swing.JButton JBConfigCompras2;
    private javax.swing.JComboBox<String> JCConfigDefectoAdd;
    private javax.swing.JComboBox<String> JCConfigPleAdd;
    private javax.swing.JComboBox<String> JCConfigTpoDatoAdd;
    private javax.swing.JComboBox<String> JCConfigValidacionAdd;
    private javax.swing.JDialog JDLoading;
    private javax.swing.JTextField JFConfigComprasAddDesp;
    private javax.swing.JTextField JFConfigComprasAddItem;
    private javax.swing.JTextField JFConfigComprasAddPle;
    private javax.swing.JTextField JFConfigComprasAddSire;
    private javax.swing.ButtonGroup JGroupActions;
    private javax.swing.JLabel JLOblig1;
    private javax.swing.JLabel JLOblig2;
    private javax.swing.JLabel JLOblig3;
    private javax.swing.JLabel JLOblig6;
    private javax.swing.JLabel JLTitleVentanaConfig;
    private javax.swing.JLabel JLTtileArchivoV;
    private javax.swing.JLabel JLTtileArchivoV1;
    private javax.swing.JLabel JLTtileArchivoV2;
    private javax.swing.JLabel JLTtileArchivoV3;
    private javax.swing.JLabel JLTtileArchivoV4;
    private javax.swing.JLabel JLTtileArchivoV5;
    private javax.swing.JLabel JLTtileArchivoV6;
    private javax.swing.JLabel JLTtileArchivoV7;
    private javax.swing.JList<String> JListConfigAdd;
    private javax.swing.JRadioButton JRNoAdmitidasAdd;
    private javax.swing.JRadioButton JRValidacionesAdd;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
