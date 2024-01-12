package ventanas.sire;

// CLASES ......
import ventanas.helpers.ActionsPerformand;
import ventanas.helpers.HelpersArchivos;
import clases.CabecerasRender;
import clases.ColumnasSire;
import clases.Empresa;
import clases.ErroresRender;
import java.awt.Desktop;
import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import org.apache.poi.ss.usermodel.*;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

import ventanas.helpers.Helpers;

public class InterfazSire extends javax.swing.JFrame {

    // ----------- DATOS CABECERA --------------
    private ActionsPerformand beansActions = new ActionsPerformand();
    ArrayList<CabecerasRender> cabecerasRender = new ArrayList<CabecerasRender>();
    CabecerasRender PLE;
    CabecerasRender SIRE;

    // * VARIABLES GLOBALES --------------------
    private Helpers helpers = new Helpers();
    private HelpersArchivos functArchivos = new HelpersArchivos();
    private FileInputStream selectFile = null, selectFileSire = null, selectFilePle = null;
    private Empresa empresa = null;
    private boolean cargado = false, isactualizado = false, isConfigOpen = false;
    private int selectionComparar = 0;
    private Map<String, String> documentos;
    private Map<String, Map<String, String[]>> excelDataGlobal = new HashMap<>();

    public InterfazSire(Empresa empresa, ArrayList<CabecerasRender> cabeceras) {
        initComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.empresa = empresa;
        //if (empresa.getLGOEMPRSA().equals("1")) {
          //  JXMENUITEM4.setVisible(false);
        //}
        // BLOQUEAR FIELDS DE INICIO 
        JFRucEmpresa.setEditable(false);
        JFRazonSocialEmp.setEditable(false);
        JFFechaAfiliacion.setEditable(false);
        JFUsuariosEmp.setEditable(false);

        // * OCULTAR PANELES
        ocultarPaneles();
        helpers.SetImageLabel(JLlogoEmpresa, "src/resources/logosystem.png");

        JFRucEmpresa.setText(this.empresa.getCODRC().toString());
        JFRazonSocialEmp.setText(this.empresa.getRSCL());
        JFFechaAfiliacion.setText(this.empresa.getFCRCN().toString());
        JFUsuariosEmp.setText(this.empresa.getNUSRS().toString());

        JPRegistroInicio.setVisible(true);

        JFSeparadorComparacion.setText("|");
        selectionComparar = 1;

        JDLoading.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        JDLoading.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        JDLoading.setSize(250, 150); // Ajusta el tamaño del diálogo según tus necesidades
        JDLoading.setLocationRelativeTo(null);
        ImageIcon loadingIcon = new ImageIcon("src/resources/Spinner.gif"); // Reemplaza "ruta_de_tu_archivo.gif" con la ruta de tu archivo GIF
        loadingIcon = new ImageIcon(loadingIcon.getImage().getScaledInstance(JDLoading.getWidth(), JDLoading.getHeight(), Image.SCALE_DEFAULT));
        jLabel6.setIcon(loadingIcon);
        jLabel6.setOpaque(false);

        this.repaint();
        actualizarDatosRender();

        setIconImage(getIconImage());
        setTitle("SISTEMA SIRE");
        this.documentos = beansActions.getDocumentos();
        this.setLocationRelativeTo(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BGCompras = new javax.swing.ButtonGroup();
        BGVentas = new javax.swing.ButtonGroup();
        BGDomiciliados = new javax.swing.ButtonGroup();
        JDLoading = new javax.swing.JDialog();
        jLabel6 = new javax.swing.JLabel();
        JPRegistroCompra = new javax.swing.JPanel();
        JBUpdateArchivCompra = new javax.swing.JButton();
        JBVerCompra = new javax.swing.JButton();
        JLTitleVentana = new javax.swing.JLabel();
        JLTtileArchivo = new javax.swing.JLabel();
        JBLimpiarCompra = new javax.swing.JButton();
        JBExportarSireCompra = new javax.swing.JButton();
        JLOblig = new javax.swing.JLabel();
        JSTable = new javax.swing.JScrollPane();
        JTCompras = new javax.swing.JTable();
        JLTtileArchivo1 = new javax.swing.JLabel();
        JRPleCompras = new javax.swing.JRadioButton();
        JRSireCompras = new javax.swing.JRadioButton();
        JLOblig1 = new javax.swing.JLabel();
        JRPropuestaCompra = new javax.swing.JRadioButton();
        JLTtileArchivo2 = new javax.swing.JLabel();
        JCComprasFormato = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        JFSeparadorCompra = new javax.swing.JTextField();
        JBVerCompra1 = new javax.swing.JButton();
        JPRegistroVentas = new javax.swing.JPanel();
        JBUpdateArchivVentas = new javax.swing.JButton();
        JBVerVenta = new javax.swing.JButton();
        JLTtileArchivo3 = new javax.swing.JLabel();
        JBLimpiarVenta = new javax.swing.JButton();
        JBExportarVenta = new javax.swing.JButton();
        JLOblig2 = new javax.swing.JLabel();
        JSTable1 = new javax.swing.JScrollPane();
        JTVentas = new javax.swing.JTable();
        JLTtileArchivoV = new javax.swing.JLabel();
        JRPleVentas = new javax.swing.JRadioButton();
        JRSireVentas = new javax.swing.JRadioButton();
        JLOblig3 = new javax.swing.JLabel();
        JRPropuestaVenta = new javax.swing.JRadioButton();
        JLTtileArchivoVentas = new javax.swing.JLabel();
        JCVentasFormato = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        JFSeparadorVentas = new javax.swing.JTextField();
        JBVerVentaResumen = new javax.swing.JButton();
        JLTitleVentana5 = new javax.swing.JLabel();
        JPRegistroDomiciliados = new javax.swing.JPanel();
        JBUpdateArchivDomc = new javax.swing.JButton();
        JBVerDomiciliados = new javax.swing.JButton();
        JLTtileArchivo4 = new javax.swing.JLabel();
        JBLimpiarDomiciliados = new javax.swing.JButton();
        JBExportarDomiciliados = new javax.swing.JButton();
        JLOblig4 = new javax.swing.JLabel();
        JSTable2 = new javax.swing.JScrollPane();
        JTDomiciliados = new javax.swing.JTable();
        JLTtileArchivoD = new javax.swing.JLabel();
        JRPleDocimiciliados = new javax.swing.JRadioButton();
        JRSireDocimiciliados = new javax.swing.JRadioButton();
        JLOblig5 = new javax.swing.JLabel();
        JRPropuestaDocimiciliados = new javax.swing.JRadioButton();
        JLTtileArchivoVentas1 = new javax.swing.JLabel();
        JCDomiciliadosFormato = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        JFSeparadorDomiciliados = new javax.swing.JTextField();
        JBVerVentaResumen1 = new javax.swing.JButton();
        JLTitleVentana6 = new javax.swing.JLabel();
        JPRegistroComparacion = new javax.swing.JPanel();
        JBUpdateArcSireComparacion = new javax.swing.JButton();
        JBVerDomiciliados1 = new javax.swing.JButton();
        JLTtileArchivo5 = new javax.swing.JLabel();
        JBLimpiarDomiciliados1 = new javax.swing.JButton();
        JLOblig6 = new javax.swing.JLabel();
        JSTable3 = new javax.swing.JScrollPane();
        JTDomiciliados1 = new javax.swing.JTable();
        JLTtileArchivoD1 = new javax.swing.JLabel();
        JLOblig7 = new javax.swing.JLabel();
        JLTtileArchivoVentas2 = new javax.swing.JLabel();
        JCComparacion = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        JFSeparadorComparacion = new javax.swing.JTextField();
        JBUpdateArcPleComparacion = new javax.swing.JButton();
        JCKSeparador = new javax.swing.JCheckBox();
        JLOblig8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JTDiferenciaMonto = new javax.swing.JTextField();
        JLTitleVentana7 = new javax.swing.JLabel();
        JBExportarDomiciliados1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        JCExportarComparacionAll = new javax.swing.JCheckBox();
        JLTtileArchivo6 = new javax.swing.JLabel();
        JCComparacionErrores = new javax.swing.JComboBox<>();
        JPRegistroInicio = new javax.swing.JPanel();
        JLTtileArchivo7 = new javax.swing.JLabel();
        JLTtileArchivo9 = new javax.swing.JLabel();
        JFUsuariosEmp = new javax.swing.JTextField();
        JFRucEmpresa = new javax.swing.JTextField();
        JLTtileArchivo10 = new javax.swing.JLabel();
        JFRazonSocialEmp = new javax.swing.JTextField();
        JFFechaAfiliacion = new javax.swing.JTextField();
        JLTtileArchivo11 = new javax.swing.JLabel();
        JLlogoEmpresa = new javax.swing.JLabel();
        JCBAbrirDocumento = new javax.swing.JCheckBox();
        JLTitleVentana8 = new javax.swing.JLabel();
        JTPConfiguracion = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        JMInicio = new javax.swing.JMenuItem();
        JMCerrarSesion = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        JMICompras = new javax.swing.JMenuItem();
        JMIVentas = new javax.swing.JMenuItem();
        JMIDomiciliadas = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        JXMENUITEM4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        JDLoading.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        JDLoading.setTitle("Espere un momento..");
        JDLoading.setBackground(new java.awt.Color(255, 255, 255));
        JDLoading.setResizable(false);
        JDLoading.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Spinner.gif"))); // NOI18N
        JDLoading.getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 130));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(" ");
        setBackground(new java.awt.Color(242, 239, 239));
        setResizable(false);

        JPRegistroCompra.setBackground(new java.awt.Color(242, 239, 239));
        JPRegistroCompra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JBUpdateArchivCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBUpdateArchivCompraActionPerformed(evt);
            }
        });
        JPRegistroCompra.add(JBUpdateArchivCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 380, 30));

        JBVerCompra.setBackground(new java.awt.Color(102, 102, 255));
        JBVerCompra.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JBVerCompra.setForeground(new java.awt.Color(255, 255, 255));
        JBVerCompra.setText("VER");
        JBVerCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVerCompraActionPerformed(evt);
            }
        });
        JPRegistroCompra.add(JBVerCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 190, 130, 30));

        JLTitleVentana.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        JLTitleVentana.setForeground(new java.awt.Color(144, 144, 144));
        JLTitleVentana.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLTitleVentana.setText("REGISTRO DE COMPRAS");
        JPRegistroCompra.add(JLTitleVentana, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 860, 40));

        JLTtileArchivo.setText("FORMATO");
        JPRegistroCompra.add(JLTtileArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 100, 30));

        JBLimpiarCompra.setBackground(new java.awt.Color(0, 0, 0));
        JBLimpiarCompra.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JBLimpiarCompra.setForeground(new java.awt.Color(255, 255, 255));
        JBLimpiarCompra.setText("LIMPIAR");
        JBLimpiarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBLimpiarCompraActionPerformed(evt);
            }
        });
        JPRegistroCompra.add(JBLimpiarCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 190, 130, 30));

        JBExportarSireCompra.setBackground(new java.awt.Color(35, 110, 57));
        JBExportarSireCompra.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JBExportarSireCompra.setForeground(new java.awt.Color(255, 255, 255));
        JBExportarSireCompra.setText("EXPORTAR");
        JBExportarSireCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBExportarSireCompraActionPerformed(evt);
            }
        });
        JPRegistroCompra.add(JBExportarSireCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 540, 130, 30));

        JLOblig.setForeground(new java.awt.Color(255, 0, 51));
        JLOblig.setText("*");
        JPRegistroCompra.add(JLOblig, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 57, -1, -1));

        JTCompras.setAutoCreateRowSorter(true);
        JTCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JTCompras.setAutoResizeMode(0);
        JTCompras.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JTCompras.setGridColor(new java.awt.Color(255, 255, 255));
        JTCompras.setSelectionBackground(new java.awt.Color(102, 102, 102));
        JTCompras.setSelectionForeground(new java.awt.Color(255, 255, 255));
        JSTable.setViewportView(JTCompras);

        JPRegistroCompra.add(JSTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 830, 290));

        JLTtileArchivo1.setText("SUBIR ARCHIVO");
        JPRegistroCompra.add(JLTtileArchivo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 100, 30));

        BGCompras.add(JRPleCompras);
        JRPleCompras.setText("PLE");
        JPRegistroCompra.add(JRPleCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        BGCompras.add(JRSireCompras);
        JRSireCompras.setText("SIRE");
        JPRegistroCompra.add(JRSireCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, -1, -1));

        JLOblig1.setForeground(new java.awt.Color(255, 0, 51));
        JLOblig1.setText("*");
        JPRegistroCompra.add(JLOblig1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 117, 30, -1));

        BGCompras.add(JRPropuestaCompra);
        JRPropuestaCompra.setText("PROPUESTA");
        JRPropuestaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRPropuestaCompraActionPerformed(evt);
            }
        });
        JPRegistroCompra.add(JRPropuestaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, -1, -1));

        JLTtileArchivo2.setText("TIPO");
        JPRegistroCompra.add(JLTtileArchivo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 100, 30));

        JCComprasFormato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccione", "TXT", "EXCEL", "ZIP" }));
        JCComprasFormato.setBorder(null);
        JCComprasFormato.setLightWeightPopupEnabled(false);
        JCComprasFormato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCComprasFormatoActionPerformed(evt);
            }
        });
        JPRegistroCompra.add(JCComprasFormato, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 190, 30));

        jLabel1.setText("SEPARADOR");
        JPRegistroCompra.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, -1, -1));

        JFSeparadorCompra.setEnabled(false);
        JFSeparadorCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JFSeparadorCompraKeyTyped(evt);
            }
        });
        JPRegistroCompra.add(JFSeparadorCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 100, 30));

        JBVerCompra1.setBackground(new java.awt.Color(255, 0, 0));
        JBVerCompra1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JBVerCompra1.setForeground(new java.awt.Color(255, 255, 255));
        JBVerCompra1.setText("REPORTE");
        JBVerCompra1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVerCompra1ActionPerformed(evt);
            }
        });
        JPRegistroCompra.add(JBVerCompra1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 540, 130, 30));

        JPRegistroVentas.setBackground(new java.awt.Color(242, 239, 239));
        JPRegistroVentas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JBUpdateArchivVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBUpdateArchivVentasActionPerformed(evt);
            }
        });
        JPRegistroVentas.add(JBUpdateArchivVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 380, 30));

        JBVerVenta.setBackground(new java.awt.Color(102, 102, 255));
        JBVerVenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JBVerVenta.setForeground(new java.awt.Color(255, 255, 255));
        JBVerVenta.setText("VER");
        JBVerVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVerVentaActionPerformed(evt);
            }
        });
        JPRegistroVentas.add(JBVerVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 190, 130, 30));

        JLTtileArchivo3.setText("FORMATO");
        JPRegistroVentas.add(JLTtileArchivo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 100, 30));

        JBLimpiarVenta.setBackground(new java.awt.Color(0, 0, 0));
        JBLimpiarVenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JBLimpiarVenta.setForeground(new java.awt.Color(255, 255, 255));
        JBLimpiarVenta.setText("LIMPIAR");
        JBLimpiarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBLimpiarVentaActionPerformed(evt);
            }
        });
        JPRegistroVentas.add(JBLimpiarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 190, 130, 30));

        JBExportarVenta.setBackground(new java.awt.Color(35, 110, 57));
        JBExportarVenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JBExportarVenta.setForeground(new java.awt.Color(255, 255, 255));
        JBExportarVenta.setText("EXPORTAR");
        JBExportarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBExportarVentaActionPerformed(evt);
            }
        });
        JPRegistroVentas.add(JBExportarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 540, 130, 30));

        JLOblig2.setForeground(new java.awt.Color(255, 0, 51));
        JLOblig2.setText("*");
        JPRegistroVentas.add(JLOblig2, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 57, -1, -1));

        JTVentas.setAutoCreateRowSorter(true);
        JTVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JTVentas.setAutoResizeMode(0);
        JTVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JTVentas.setGridColor(new java.awt.Color(0, 0, 0));
        JTVentas.setSelectionBackground(new java.awt.Color(102, 102, 102));
        JTVentas.setSelectionForeground(new java.awt.Color(255, 255, 255));
        JSTable1.setViewportView(JTVentas);

        JPRegistroVentas.add(JSTable1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 830, 290));

        JLTtileArchivoV.setText("SUBIR ARCHIVO");
        JPRegistroVentas.add(JLTtileArchivoV, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 100, 30));

        BGVentas.add(JRPleVentas);
        JRPleVentas.setText("PLE");
        JPRegistroVentas.add(JRPleVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        BGVentas.add(JRSireVentas);
        JRSireVentas.setText("SIRE");
        JPRegistroVentas.add(JRSireVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, -1, -1));

        JLOblig3.setForeground(new java.awt.Color(255, 0, 51));
        JLOblig3.setText("*");
        JPRegistroVentas.add(JLOblig3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 117, 30, -1));

        BGVentas.add(JRPropuestaVenta);
        JRPropuestaVenta.setText("PROPUESTA");
        JRPropuestaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRPropuestaVentaActionPerformed(evt);
            }
        });
        JPRegistroVentas.add(JRPropuestaVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, -1, -1));

        JLTtileArchivoVentas.setText("TIPO");
        JPRegistroVentas.add(JLTtileArchivoVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 100, 30));

        JCVentasFormato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccione", "TXT", "EXCEL", "ZIP" }));
        JCVentasFormato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCVentasFormatoActionPerformed(evt);
            }
        });
        JPRegistroVentas.add(JCVentasFormato, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 190, 30));

        jLabel2.setText("SEPARADOR");
        JPRegistroVentas.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, -1, -1));

        JFSeparadorVentas.setEnabled(false);
        JFSeparadorVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JFSeparadorVentasActionPerformed(evt);
            }
        });
        JFSeparadorVentas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JFSeparadorVentasKeyTyped(evt);
            }
        });
        JPRegistroVentas.add(JFSeparadorVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 100, 30));

        JBVerVentaResumen.setBackground(new java.awt.Color(255, 0, 0));
        JBVerVentaResumen.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JBVerVentaResumen.setForeground(new java.awt.Color(255, 255, 255));
        JBVerVentaResumen.setText("REPORTE");
        JBVerVentaResumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVerVentaResumenActionPerformed(evt);
            }
        });
        JPRegistroVentas.add(JBVerVentaResumen, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 540, 130, 30));

        JLTitleVentana5.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        JLTitleVentana5.setForeground(new java.awt.Color(144, 144, 144));
        JLTitleVentana5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLTitleVentana5.setText("REGISTRO DE VENTAS");
        JPRegistroVentas.add(JLTitleVentana5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 860, 40));

        JPRegistroDomiciliados.setBackground(new java.awt.Color(242, 239, 239));
        JPRegistroDomiciliados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JBUpdateArchivDomc.setBorder(null);
        JBUpdateArchivDomc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBUpdateArchivDomcActionPerformed(evt);
            }
        });
        JPRegistroDomiciliados.add(JBUpdateArchivDomc, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 380, 30));

        JBVerDomiciliados.setBackground(new java.awt.Color(102, 102, 255));
        JBVerDomiciliados.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JBVerDomiciliados.setForeground(new java.awt.Color(255, 255, 255));
        JBVerDomiciliados.setText("VER");
        JBVerDomiciliados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVerDomiciliadosActionPerformed(evt);
            }
        });
        JPRegistroDomiciliados.add(JBVerDomiciliados, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 190, 130, 30));

        JLTtileArchivo4.setText("FORMATO");
        JPRegistroDomiciliados.add(JLTtileArchivo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 100, 30));

        JBLimpiarDomiciliados.setBackground(new java.awt.Color(0, 0, 0));
        JBLimpiarDomiciliados.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JBLimpiarDomiciliados.setForeground(new java.awt.Color(255, 255, 255));
        JBLimpiarDomiciliados.setText("LIMPIAR");
        JBLimpiarDomiciliados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBLimpiarDomiciliadosActionPerformed(evt);
            }
        });
        JPRegistroDomiciliados.add(JBLimpiarDomiciliados, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 190, 130, 30));

        JBExportarDomiciliados.setBackground(new java.awt.Color(35, 110, 57));
        JBExportarDomiciliados.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JBExportarDomiciliados.setForeground(new java.awt.Color(255, 255, 255));
        JBExportarDomiciliados.setText("EXPORTAR");
        JBExportarDomiciliados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBExportarDomiciliadosActionPerformed(evt);
            }
        });
        JPRegistroDomiciliados.add(JBExportarDomiciliados, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 540, 130, 30));

        JLOblig4.setForeground(new java.awt.Color(255, 0, 51));
        JLOblig4.setText("*");
        JPRegistroDomiciliados.add(JLOblig4, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 57, -1, -1));

        JTDomiciliados.setAutoCreateRowSorter(true);
        JTDomiciliados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JTDomiciliados.setAutoResizeMode(0);
        JTDomiciliados.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JTDomiciliados.setGridColor(new java.awt.Color(0, 0, 0));
        JTDomiciliados.setSelectionBackground(new java.awt.Color(102, 102, 102));
        JTDomiciliados.setSelectionForeground(new java.awt.Color(255, 255, 255));
        JSTable2.setViewportView(JTDomiciliados);

        JPRegistroDomiciliados.add(JSTable2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 830, 290));

        JLTtileArchivoD.setText("SUBIR ARCHIVO");
        JPRegistroDomiciliados.add(JLTtileArchivoD, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 100, 30));

        BGDomiciliados.add(JRPleDocimiciliados);
        JRPleDocimiciliados.setText("PLE");
        JPRegistroDomiciliados.add(JRPleDocimiciliados, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        BGDomiciliados.add(JRSireDocimiciliados);
        JRSireDocimiciliados.setText("SIRE");
        JPRegistroDomiciliados.add(JRSireDocimiciliados, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, -1, -1));

        JLOblig5.setForeground(new java.awt.Color(255, 0, 51));
        JLOblig5.setText("*");
        JPRegistroDomiciliados.add(JLOblig5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 117, 30, -1));

        BGDomiciliados.add(JRPropuestaDocimiciliados);
        JRPropuestaDocimiciliados.setText("PROPUESTA");
        JRPropuestaDocimiciliados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRPropuestaDocimiciliadosActionPerformed(evt);
            }
        });
        JPRegistroDomiciliados.add(JRPropuestaDocimiciliados, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, -1, -1));

        JLTtileArchivoVentas1.setText("TIPO");
        JPRegistroDomiciliados.add(JLTtileArchivoVentas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 100, 30));

        JCDomiciliadosFormato.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccione", "TXT", "EXCEL", "ZIP" }));
        JCDomiciliadosFormato.setBorder(null);
        JCDomiciliadosFormato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCDomiciliadosFormatoActionPerformed(evt);
            }
        });
        JPRegistroDomiciliados.add(JCDomiciliadosFormato, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 190, 30));

        jLabel3.setText("SEPARADOR");
        JPRegistroDomiciliados.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, -1, -1));

        JFSeparadorDomiciliados.setEnabled(false);
        JFSeparadorDomiciliados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JFSeparadorDomiciliadosActionPerformed(evt);
            }
        });
        JFSeparadorDomiciliados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JFSeparadorDomiciliadosKeyTyped(evt);
            }
        });
        JPRegistroDomiciliados.add(JFSeparadorDomiciliados, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 100, 30));

        JBVerVentaResumen1.setBackground(new java.awt.Color(255, 0, 0));
        JBVerVentaResumen1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JBVerVentaResumen1.setForeground(new java.awt.Color(255, 255, 255));
        JBVerVentaResumen1.setText("REPORTE");
        JBVerVentaResumen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVerVentaResumen1ActionPerformed(evt);
            }
        });
        JPRegistroDomiciliados.add(JBVerVentaResumen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 540, 130, 30));

        JLTitleVentana6.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        JLTitleVentana6.setForeground(new java.awt.Color(144, 144, 144));
        JLTitleVentana6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLTitleVentana6.setText("REGISTRO NO DOMICILIADOS");
        JPRegistroDomiciliados.add(JLTitleVentana6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 860, 40));

        JPRegistroComparacion.setBackground(new java.awt.Color(242, 239, 239));
        JPRegistroComparacion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JBUpdateArcSireComparacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBUpdateArcSireComparacionActionPerformed(evt);
            }
        });
        JPRegistroComparacion.add(JBUpdateArcSireComparacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 380, 30));

        JBVerDomiciliados1.setBackground(new java.awt.Color(102, 102, 255));
        JBVerDomiciliados1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JBVerDomiciliados1.setForeground(new java.awt.Color(255, 255, 255));
        JBVerDomiciliados1.setText("COMPARAR");
        JBVerDomiciliados1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBVerDomiciliados1ActionPerformed(evt);
            }
        });
        JPRegistroComparacion.add(JBVerDomiciliados1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 200, 130, 30));

        JLTtileArchivo5.setText("ERRORES ENCONTRADOS");
        JPRegistroComparacion.add(JLTtileArchivo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 180, 30));

        JBLimpiarDomiciliados1.setBackground(new java.awt.Color(0, 0, 0));
        JBLimpiarDomiciliados1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JBLimpiarDomiciliados1.setForeground(new java.awt.Color(255, 255, 255));
        JBLimpiarDomiciliados1.setText("LIMPIAR");
        JBLimpiarDomiciliados1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBLimpiarDomiciliados1ActionPerformed(evt);
            }
        });
        JPRegistroComparacion.add(JBLimpiarDomiciliados1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 200, 130, 30));

        JLOblig6.setForeground(new java.awt.Color(255, 0, 51));
        JLOblig6.setText("*");
        JPRegistroComparacion.add(JLOblig6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 57, 20, -1));

        JTDomiciliados1.setAutoCreateRowSorter(true);
        JTDomiciliados1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JTDomiciliados1.setAutoResizeMode(0);
        JTDomiciliados1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JTDomiciliados1.setGridColor(new java.awt.Color(0, 0, 0));
        JTDomiciliados1.setSelectionBackground(new java.awt.Color(102, 102, 102));
        JTDomiciliados1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        JSTable3.setViewportView(JTDomiciliados1);

        JPRegistroComparacion.add(JSTable3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 830, 280));

        JLTtileArchivoD1.setText("SUBIR ARCHIVO SIRE EMPRESA");
        JPRegistroComparacion.add(JLTtileArchivoD1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 190, 30));

        JLOblig7.setForeground(new java.awt.Color(255, 0, 51));
        JLOblig7.setText("*");
        JPRegistroComparacion.add(JLOblig7, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 174, 30, 20));

        JLTtileArchivoVentas2.setText("SUBIR ARCHIVO SIRE SUNAT");
        JPRegistroComparacion.add(JLTtileArchivoVentas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 170, 30));

        JCComparacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Seleccione", "EMPRESA VS SUNAT", "SUNAT VS EMPRESA" }));
        JCComparacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCComparacionActionPerformed(evt);
            }
        });
        JPRegistroComparacion.add(JCComparacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 190, 30));

        jLabel4.setText("MONTO DIFERENCIA");
        JPRegistroComparacion.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, -1, -1));

        JFSeparadorComparacion.setEnabled(false);
        JFSeparadorComparacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JFSeparadorComparacionActionPerformed(evt);
            }
        });
        JFSeparadorComparacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JFSeparadorComparacionKeyTyped(evt);
            }
        });
        JPRegistroComparacion.add(JFSeparadorComparacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 100, 30));

        JBUpdateArcPleComparacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBUpdateArcPleComparacionActionPerformed(evt);
            }
        });
        JPRegistroComparacion.add(JBUpdateArcPleComparacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 380, 30));

        JCKSeparador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCKSeparadorActionPerformed(evt);
            }
        });
        JPRegistroComparacion.add(JCKSeparador, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, 40, 30));

        JLOblig8.setForeground(new java.awt.Color(255, 0, 51));
        JLOblig8.setText("*");
        JPRegistroComparacion.add(JLOblig8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 115, 30, -1));

        jLabel5.setText("SEPARADOR");
        JPRegistroComparacion.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, -1, -1));

        JTDiferenciaMonto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTDiferenciaMontoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTDiferenciaMontoKeyTyped(evt);
            }
        });
        JPRegistroComparacion.add(JTDiferenciaMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 100, 30));

        JLTitleVentana7.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        JLTitleVentana7.setForeground(new java.awt.Color(144, 144, 144));
        JLTitleVentana7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLTitleVentana7.setText("COMPARACIÓN");
        JPRegistroComparacion.add(JLTitleVentana7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 860, 50));

        JBExportarDomiciliados1.setBackground(new java.awt.Color(35, 110, 57));
        JBExportarDomiciliados1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        JBExportarDomiciliados1.setForeground(new java.awt.Color(255, 255, 255));
        JBExportarDomiciliados1.setText("EXPORTAR");
        JBExportarDomiciliados1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBExportarDomiciliados1ActionPerformed(evt);
            }
        });
        JPRegistroComparacion.add(JBExportarDomiciliados1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 540, 130, 30));

        jLabel7.setText("Todo");
        JPRegistroComparacion.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 547, -1, -1));
        JPRegistroComparacion.add(JCExportarComparacionAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 547, -1, -1));

        JLTtileArchivo6.setText("TIPO DE COMPARACIÓN");
        JPRegistroComparacion.add(JLTtileArchivo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 150, 30));

        JCComparacionErrores.setEnabled(false);
        JCComparacionErrores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCComparacionErroresActionPerformed(evt);
            }
        });
        JPRegistroComparacion.add(JCComparacionErrores, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 190, 30));

        JPRegistroInicio.setBackground(new java.awt.Color(242, 239, 239));
        JPRegistroInicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JLTtileArchivo7.setText("N° DE USUARIOS");
        JPRegistroInicio.add(JLTtileArchivo7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 100, 30));

        JLTtileArchivo9.setText("RUC EMPRESA");
        JPRegistroInicio.add(JLTtileArchivo9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 100, 30));
        JPRegistroInicio.add(JFUsuariosEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 280, 30));
        JPRegistroInicio.add(JFRucEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 280, 30));

        JLTtileArchivo10.setText("RAZÓN SOCIAL");
        JPRegistroInicio.add(JLTtileArchivo10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 100, 30));
        JPRegistroInicio.add(JFRazonSocialEmp, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 280, 30));
        JPRegistroInicio.add(JFFechaAfiliacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 280, 30));

        JLTtileArchivo11.setText("FECHA AFILIACIÓN");
        JPRegistroInicio.add(JLTtileArchivo11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 110, 30));
        JPRegistroInicio.add(JLlogoEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, 200, 190));

        JCBAbrirDocumento.setText("abrir automaticamente");
        JPRegistroInicio.add(JCBAbrirDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 240, -1));

        JLTitleVentana8.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        JLTitleVentana8.setForeground(new java.awt.Color(144, 144, 144));
        JLTitleVentana8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JLTitleVentana8.setText("DATOS REGISTRADOS");
        JPRegistroInicio.add(JLTitleVentana8, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 10, 830, 40));

        JTPConfiguracion.setBackground(new java.awt.Color(242, 239, 239));
        JTPConfiguracion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        JTPConfiguracion.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        JTPConfiguracion.setRequestFocusEnabled(false);

        jMenu4.setText("INICIO");
        jMenu4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4ActionPerformed(evt);
            }
        });

        JMInicio.setText("USUARIO");
        JMInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMInicioActionPerformed(evt);
            }
        });
        jMenu4.add(JMInicio);

        JMCerrarSesion.setText("CERRAR SESIÓN");
        JMCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMCerrarSesionActionPerformed(evt);
            }
        });
        jMenu4.add(JMCerrarSesion);

        jMenuBar1.add(jMenu4);

        jMenu3.setText("OPCIONES");

        JMICompras.setText("REGISTRO DE COMPRAS");
        JMICompras.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logo.png"))); // NOI18N
        JMICompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIComprasActionPerformed(evt);
            }
        });
        jMenu3.add(JMICompras);

        JMIVentas.setText("REGISTRO DE VENTAS");
        JMIVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIVentasActionPerformed(evt);
            }
        });
        jMenu3.add(JMIVentas);

        JMIDomiciliadas.setText("REGISTRO NO DOMICIALIADAS");
        JMIDomiciliadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIDomiciliadasActionPerformed(evt);
            }
        });
        jMenu3.add(JMIDomiciliadas);

        jMenu1.setText("COMPARAR");

        jMenuItem1.setText("COMPRAS");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("VENTAS");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenu3.add(jMenu1);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("AYUDA");

        jMenuItem3.setText("SOPORTE");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        JXMENUITEM4.setText("CONFIGURACIÓN");
        JXMENUITEM4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JXMENUITEM4ActionPerformed(evt);
            }
        });
        jMenu2.add(JXMENUITEM4);

        jMenuItem5.setText("ACTUALIZAR");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPRegistroCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 904, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(JPRegistroVentas, javax.swing.GroupLayout.DEFAULT_SIZE, 904, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(JPRegistroDomiciliados, javax.swing.GroupLayout.DEFAULT_SIZE, 904, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(JPRegistroComparacion, javax.swing.GroupLayout.DEFAULT_SIZE, 904, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(JPRegistroInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 904, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(JTPConfiguracion, javax.swing.GroupLayout.Alignment.TRAILING))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPRegistroCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(JPRegistroVentas, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(JPRegistroDomiciliados, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(JPRegistroComparacion, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(JPRegistroInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(JTPConfiguracion, javax.swing.GroupLayout.Alignment.TRAILING))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("resources/logosystem.png"));
        return retValue;
    }

    private void JBUpdateArchivCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBUpdateArchivCompraActionPerformed
        JBVerCompra.setEnabled(true);
        selectFile = helpers.CargarArchivo(this, JBUpdateArchivCompra, JTCompras);
    }//GEN-LAST:event_JBUpdateArchivCompraActionPerformed

    public CabecerasRender updateRenderCabeceras(int VLR1) {
        for (CabecerasRender cabeceraRender : cabecerasRender) {
            if (cabeceraRender.getVLR1() == VLR1) {
                return cabeceraRender;
            }
        }
        return null;
    }

    private void ocultarPaneles() {
        helpers.hidePanelsInContainer(this.getContentPane());
        JTPConfiguracion.setVisible(false);
    }

    private void JBVerCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBVerCompraActionPerformed
        if (selectFile == null) {
            helpers.mensajeError("Seleccione un archivo, validar!.", 2);
            return;
        }

        if (!JRPleCompras.isSelected() && !JRSireCompras.isSelected() && !JRPropuestaCompra.isSelected()) {
            helpers.mensajeError("Selecciona un tipo de conversión, validar!.", 2);
            return;
        }

        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                try (BufferedReader archivo = new BufferedReader(new InputStreamReader(selectFile, Charset.forName("UTF-8")))) {
                    String linea;

                    if (JRPleCompras.isSelected()) {
                        functArchivos.cargarDatosEnTablaExecute(archivo, PLE, JTCompras, 1);

                    } else if (JRSireCompras.isSelected()) {
                        functArchivos.actualizarCabeceraSireExecute(JTCompras, SIRE);
                        Map<Integer, String> COLUMNASNOREGISTERLOCAL = new HashMap<>();
                        PLE = updateRenderCabeceras(SIRE.getCOLUMNEQVLNTE());
                        COLUMNASNOREGISTERLOCAL = PLE.getCOLUMNASNOREGISTER();

                        int indiceRow = 1, positionCol;

                        while ((linea = archivo.readLine()) != null) {
                            String[] cadenaLinea = linea.split("\\|");
                            List<String> dataList = new ArrayList<>(Arrays.asList(cadenaLinea));

                            for (Map.Entry<Integer, String> entry : COLUMNASNOREGISTERLOCAL.entrySet()) {
                                Integer key = entry.getKey();
                                String value = entry.getValue();
                                dataList.add(key - 1, value);
                            }

                            cadenaLinea = dataList.toArray(new String[0]);

                            String[] cadenaModificada = new String[SIRE.getCOLUMNAS().size()];
                            cadenaModificada[0] = String.valueOf(indiceRow);
                            cadenaModificada[1] = empresa.getCODRC();
                            cadenaModificada[2] = empresa.getRSCL();

                            for (int j = 3; j < SIRE.getCOLUMNAS().size(); j++) {
                                ColumnasSire columnaSire = SIRE.getCOLUMNAS().get(j - 1);

                                if ((columnaSire.getCODPLE() < cadenaLinea.length && columnaSire.getCODPLE() > 0)
                                        || columnaSire.getCDVLDCN() > 0) {
                                    switch (j) {
                                        case 3:
                                            cadenaModificada[j] = helpers.obtenerSubCadena(cadenaLinea[columnaSire.getCODPLE() - 1], 0, 6);
                                            break;
                                        case 6:
                                            if (helpers.esFechaValida(cadenaLinea[columnaSire.getCODPLE() - 1]) || columnaSire.getContenedor(cadenaLinea[columnaSire.getCDVLDCN() - 1], columnaSire.getVVLDCNS())) {
                                                cadenaModificada[j] = helpers.esFechaValida(cadenaLinea[columnaSire.getCODPLE() - 1]) ? cadenaLinea[columnaSire.getCODPLE() - 1] : cadenaLinea[columnaSire.getCLMNDFLT() - 1];
                                            } else {
                                                cadenaModificada[j] = columnaSire.getContenedor(cadenaLinea[columnaSire.getCODPLE() - 1], columnaSire.getNADMTDS()) ? columnaSire.getCLMNDFLTVLR1() : cadenaLinea[columnaSire.getCODPLE() - 1];
                                            }
                                            break;
                                        case 9:
                                            cadenaModificada[j] = columnaSire.getContenedor(cadenaLinea[columnaSire.getCODPLE() - 1], columnaSire.getNADMTDS())
                                                    ? columnaSire.getCLMNDFLTVLR1() : cadenaLinea[columnaSire.getCODPLE() - 1];
                                            break;
                                        case 10:
                                            cadenaModificada[j] = columnaSire.getContenedor(cadenaLinea[columnaSire.getCDVLDCN() - 1], columnaSire.getVVLDCNS())
                                                    ? helpers.procesarComprobante(cadenaLinea[columnaSire.getCODPLE() - 1], false, 6)
                                                    : helpers.procesarComprobante(cadenaLinea[columnaSire.getCODPLE() - 1], true, 6);
                                            break;
                                        case 27:
                                            cadenaModificada[j] = columnaSire.getContenedor(cadenaLinea[columnaSire.getCDVLDCN() - 1], columnaSire.getVVLDCNS())
                                                    ? columnaSire.getCLMNDFLTVLR1()
                                                    : cadenaLinea[columnaSire.getCODPLE() - 1];
                                            break;
                                        case 28:
                                            cadenaModificada[j] = columnaSire.getContenedor(cadenaLinea[columnaSire.getCDVLDCN() - 1], columnaSire.getVVLDCNS())
                                                    ? cadenaLinea[columnaSire.getCLMNDFLT() - 1]
                                                    : columnaSire.getCLMNDFLTVLR1();
                                            break;
                                        case 29:
                                        case 30:
                                        case 31:
                                        case 32:
                                            cadenaModificada[j] = columnaSire.getContenedor(cadenaLinea[columnaSire.getCODPLE() - 1], columnaSire.getNADMTDS())
                                                    ? columnaSire.getCLMNDFLTVLR1()
                                                    : cadenaLinea[columnaSire.getCODPLE() - 1];
                                            break;
                                        case 38:
                                            cadenaModificada[j] = columnaSire.getContenedor(cadenaLinea[columnaSire.getCODPLE() - 1], columnaSire.getNADMTDS())
                                                    ? ""
                                                    : columnaSire.getCLMNDFLTVLR1();
                                            break;

                                        case 39:
                                            cadenaModificada[j] = columnaSire.getContenedor(cadenaLinea[columnaSire.getCDVLDCN() - 1], columnaSire.getVVLDCNS())
                                                    ? (columnaSire.getCLMNDFLTVLR1().equals("") ? "01" : columnaSire.getCLMNDFLTVLR1())
                                                    : "";
                                            break;
                                        default:
                                            cadenaModificada[j] = (columnaSire.getContenedor(cadenaLinea[columnaSire.getCODPLE() - 1], columnaSire.getNADMTDS()))
                                                    ? columnaSire.getCLMNDFLTVLR1() : cadenaLinea[columnaSire.getCODPLE() - 1];
                                            break;
                                    }

                                } else {
                                    cadenaModificada[j] = columnaSire.getCLMNDFLTVLR1();
                                }

                            }

                            functArchivos.addDataToTable(cadenaModificada, JTCompras);
                            indiceRow++;
                        }

                    } else {
                        functArchivos.cargarDatosEnTablaSireExecute(archivo, SIRE, JTCompras, 2);
                    }

                    selectFile.close();
                    JBVerCompra.setEnabled(false);

                } catch (IOException e) {
                    helpers.mensajeError("Ocurrio un error, validar el archivo.", 2);
                }

                return null;
            }

            @Override

            protected void done() {
                JDLoading.dispose();
            }
        };

        worker.execute();

        JDLoading.setVisible(
                true);
    }//GEN-LAST:event_JBVerCompraActionPerformed

    private void JMIComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIComprasActionPerformed
        ocultarPaneles();
        JPRegistroCompra.setVisible(true);
        helpers.LimpiarTable(JTCompras, BGCompras, JCComprasFormato, JBUpdateArchivCompra);
        selectFile = null;
        JBVerCompra.setEnabled(true);
        this.PLE = updateRenderCabeceras(1);
        this.SIRE = updateRenderCabeceras(4);
    }//GEN-LAST:event_JMIComprasActionPerformed

    private void JMIDomiciliadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIDomiciliadasActionPerformed
        ocultarPaneles();
        JPRegistroDomiciliados.setVisible(true);
        helpers.LimpiarTable(JTDomiciliados, BGDomiciliados, JCDomiciliadosFormato, JBUpdateArchivDomc);
        selectFile = null;
        JBVerDomiciliados.setEnabled(true);
        this.PLE = updateRenderCabeceras(3);
        this.SIRE = updateRenderCabeceras(6);
    }//GEN-LAST:event_JMIDomiciliadasActionPerformed

    private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu4ActionPerformed
    }//GEN-LAST:event_jMenu4ActionPerformed

    private void JMInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMInicioActionPerformed
        ocultarPaneles();
        selectFile = null;
        JPRegistroInicio.setVisible(true);
    }//GEN-LAST:event_JMInicioActionPerformed

    private void JMIVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIVentasActionPerformed
        ocultarPaneles();
        JPRegistroVentas.setVisible(true);
        helpers.LimpiarTable(JTVentas, BGVentas, JCVentasFormato, JBUpdateArchivVentas);
        selectFile = null;
        JBVerVenta.setEnabled(true);
        this.PLE = updateRenderCabeceras(2);
        this.SIRE = updateRenderCabeceras(5);
    }//GEN-LAST:event_JMIVentasActionPerformed

    private void JMCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMCerrarSesionActionPerformed
        helpers.CerrarSesion(this);
    }//GEN-LAST:event_JMCerrarSesionActionPerformed

    private void JBLimpiarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBLimpiarCompraActionPerformed
        helpers.LimpiarTable(JTCompras, BGCompras, JCComprasFormato, JBUpdateArchivCompra);
        JBVerCompra.setEnabled(true);
        selectFile = null;
    }//GEN-LAST:event_JBLimpiarCompraActionPerformed

    public void agregarArchivoAlZip(ZipOutputStream zipOut, String filePath) throws IOException {
        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);
        ZipEntry zipEntry = new ZipEntry(file.getName());
        zipOut.putNextEntry(zipEntry);

        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
        }

        fis.close();
    }

    public void abrirArchivo(String filePath) {
        try {
            File fileToOpen = new File(filePath);
            Desktop.getDesktop().open(fileToOpen);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "No se pudo abrir el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void JBExportarSireCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBExportarSireCompraActionPerformed
        // TODO add your handling code here:
        int selection = JCComprasFormato.getSelectedIndex();

        if (selection == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un formato a exportar", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean dataRows = helpers.hasDataCount(JTCompras);
        if (!dataRows) {
            JOptionPane.showMessageDialog(this, "No existen datos para exportar", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int rangeInit = 0, rangeFin = 0, periodo = 0;
        String valor = "";

        if (JRSireCompras.isSelected() || JRPropuestaCompra.isSelected()) {
            rangeInit = SIRE.getINITSIRE();
            rangeFin = SIRE.getFINSIRE();
            periodo = SIRE.getVLR1();
            valor = SIRE.getRSCLARCCMPL();
        } else {
            rangeInit = PLE.getINITPLE();
            rangeFin = PLE.getFINPLE();
            periodo = PLE.getVLR1();
            valor = PLE.getRSCLARCCMPL();
        }

        String hPeriodoMax6 = helpers.procesarCadena((String) JTCompras.getModel().getValueAt(0, periodo - 1));
        String archivoName = (empresa.getRSCLARC() + hPeriodoMax6 + valor);

        if (selection == 1) {
            if (JFSeparadorCompra.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Ingresa un separador de datos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            functArchivos.exportTableToTxtExport(JTCompras, JFSeparadorCompra.getText(),
                    archivoName, rangeFin, rangeInit,
                    JDLoading,
                    JCBAbrirDocumento.isSelected()
            );

        } else if (selection == 2) {
            functArchivos.exportTableToExcelExport(JTCompras, archivoName, SIRE, JDLoading, JCBAbrirDocumento.isSelected());
        } else {
            functArchivos.exportTableToZipExport(JTCompras, "|", archivoName, rangeFin, rangeInit, JDLoading, JCBAbrirDocumento.isSelected());
        }
    }//GEN-LAST:event_JBExportarSireCompraActionPerformed

    private void JRPropuestaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRPropuestaCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JRPropuestaCompraActionPerformed

    private void JCComprasFormatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCComprasFormatoActionPerformed
        JFSeparadorCompra.setEnabled(JCComprasFormato.getSelectedIndex() == 1);
        JFSeparadorCompra.setText("");
    }//GEN-LAST:event_JCComprasFormatoActionPerformed

    private void JFSeparadorCompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JFSeparadorCompraKeyTyped
        char c = evt.getKeyChar();
        if (!helpers.isSpecialCharacter(c))
            evt.consume();
    }//GEN-LAST:event_JFSeparadorCompraKeyTyped

    private void JBLimpiarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBLimpiarVentaActionPerformed
        helpers.LimpiarTable(JTVentas, BGVentas, JCVentasFormato, JBUpdateArchivVentas);
        JBVerVenta.setEnabled(true);
        selectFile = null;
    }//GEN-LAST:event_JBLimpiarVentaActionPerformed

    private void JBExportarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBExportarVentaActionPerformed
        int selection = JCVentasFormato.getSelectedIndex();

        if (selection == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un formato a exportar", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean dataRows = helpers.hasDataCount(JTVentas);
        if (!dataRows) {
            JOptionPane.showMessageDialog(this, "No existen datos para exportar", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int rangeInit = 0, rangeFin = 0, periodo = 0;
        String valor = "";

        if (JRSireVentas.isSelected() || JRPropuestaVenta.isSelected()) {
            rangeInit = SIRE.getINITSIRE();
            rangeFin = SIRE.getFINSIRE();
            periodo = SIRE.getVLR1();
            valor = SIRE.getRSCLARCCMPL();
        } else {
            rangeInit = PLE.getINITPLE();
            rangeFin = PLE.getFINPLE();
            periodo = PLE.getVLR1();
            valor = PLE.getRSCLARCCMPL();
        }

        String hPeriodoMax6 = helpers.procesarCadena((String) JTVentas.getModel().getValueAt(0, periodo - 1));
        String archivoName = (empresa.getRSCLARC() + hPeriodoMax6 + valor);

        if (selection == 1) {
            if (JFSeparadorVentas.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Ingresa un separador de datos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            functArchivos.exportTableToTxtExport(JTVentas, JFSeparadorVentas.getText(), archivoName, rangeFin, rangeInit, JDLoading, JCBAbrirDocumento.isSelected());

        } else if (selection == 2) {
            functArchivos.exportTableToExcelExport(JTVentas, archivoName, SIRE, JDLoading, JCBAbrirDocumento.isSelected());
        } else {
            functArchivos.exportTableToZipExport(JTVentas, "|", archivoName, rangeFin, rangeInit, JDLoading, JCBAbrirDocumento.isSelected());
        }
    }//GEN-LAST:event_JBExportarVentaActionPerformed

    private void JRPropuestaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRPropuestaVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JRPropuestaVentaActionPerformed

    private void JCVentasFormatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCVentasFormatoActionPerformed
        JFSeparadorVentas.setEnabled(JCVentasFormato.getSelectedIndex() == 1);
        JFSeparadorVentas.setText("");
    }//GEN-LAST:event_JCVentasFormatoActionPerformed

    private void JFSeparadorVentasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JFSeparadorVentasKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_JFSeparadorVentasKeyTyped

    private void JFSeparadorVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JFSeparadorVentasActionPerformed
        JFSeparadorVentas.setEnabled(JCVentasFormato.getSelectedIndex() == 1);
        JFSeparadorVentas.setText("");
    }//GEN-LAST:event_JFSeparadorVentasActionPerformed

    private void JBUpdateArchivDomcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBUpdateArchivDomcActionPerformed
        selectFile = helpers.CargarArchivo(this, JBUpdateArchivDomc, JTDomiciliados);
    }//GEN-LAST:event_JBUpdateArchivDomcActionPerformed

    private void JBVerDomiciliadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBVerDomiciliadosActionPerformed
        if (selectFile == null) {
            JOptionPane.showMessageDialog(this, "Primero selecciona un archivo", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!JRPleDocimiciliados.isSelected() && !JRSireDocimiciliados.isSelected() && !JRPropuestaDocimiciliados.isSelected()) {
            JOptionPane.showMessageDialog(this, "Selecciona un tipo de conversión", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                try (BufferedReader archivo = new BufferedReader(new InputStreamReader(selectFile, Charset.forName("UTF-8")))) {
                    String linea;

                    if (JRPleDocimiciliados.isSelected()) {
                        functArchivos.cargarDatosEnTablaExecute(archivo, PLE, JTDomiciliados, 1);

                    } else if (JRSireDocimiciliados.isSelected()) {
                        functArchivos.actualizarCabeceraSireExecute(JTDomiciliados, SIRE);
                        Map<Integer, String> COLUMNASNOREGISTERLOCAL = new HashMap<>();
                        PLE = updateRenderCabeceras(SIRE.getCOLUMNEQVLNTE());
                        COLUMNASNOREGISTERLOCAL = PLE.getCOLUMNASNOREGISTER();

                        int indiceRow = 1, positionCol;

                        while ((linea = archivo.readLine()) != null) {
                            String[] cadenaLinea = linea.split("\\|");
                            List<String> dataList = new ArrayList<>(Arrays.asList(cadenaLinea));

                            for (Map.Entry<Integer, String> entry : COLUMNASNOREGISTERLOCAL.entrySet()) {
                                Integer key = entry.getKey();
                                String value = entry.getValue();
                                dataList.add(key - 1, value);
                            }

                            cadenaLinea = dataList.toArray(new String[0]);

                            String[] cadenaModificada = new String[SIRE.getCOLUMNAS().size()];
                            cadenaModificada[0] = String.valueOf(indiceRow);

                            for (int j = 1; j < SIRE.getCOLUMNAS().size(); j++) {
                                ColumnasSire columnaSire = SIRE.getCOLUMNAS().get(j - 1);

                                if ((columnaSire.getCODPLE() < cadenaLinea.length && columnaSire.getCODPLE() > 0)
                                        || columnaSire.getCDVLDCN() > 0) {

                                    switch (j) {
                                        case 1:
                                            cadenaModificada[j] = helpers.obtenerSubCadena(cadenaLinea[columnaSire.getCODPLE() - 1], 0, 6);
                                            break;
                                        case 6:
                                            cadenaModificada[j] = helpers.obtenerTextoDespuesDeGuion(cadenaLinea[columnaSire.getCODPLE() - 1]);
                                            break;
                                        case 16:
                                            cadenaModificada[j] = columnaSire.getContenedor(cadenaLinea[columnaSire.getCDVLDCN() - 1], columnaSire.getVVLDCNS())
                                                    ? columnaSire.getCLMNDFLTVLR1()
                                                    : cadenaLinea[columnaSire.getCODPLE() - 1];
                                            break;
                                        default:
                                            cadenaModificada[j] = (columnaSire.getContenedor(cadenaLinea[columnaSire.getCODPLE() - 1], columnaSire.getNADMTDS()))
                                                    ? columnaSire.getCLMNDFLTVLR1() : cadenaLinea[columnaSire.getCODPLE() - 1];
                                            break;
                                    }
                                } else {
                                    cadenaModificada[j] = columnaSire.getCLMNDFLTVLR1();
                                }

                            }

                            functArchivos.addDataToTable(cadenaModificada, JTDomiciliados);
                            indiceRow++;
                        }

                    } else {
                        functArchivos.cargarDatosEnTablaSireExecute(archivo, SIRE, JTDomiciliados, 2);
                    }

                    selectFile.close();
                    JBVerDomiciliados.setEnabled(false);

                } catch (IOException e) {
                    helpers.mensajeError("Ocurrio un error, validar el archivo.", 2);
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
    }//GEN-LAST:event_JBVerDomiciliadosActionPerformed

    private void JBLimpiarDomiciliadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBLimpiarDomiciliadosActionPerformed
        helpers.LimpiarTable(JTDomiciliados, BGDomiciliados, JCDomiciliadosFormato, JBUpdateArchivDomc);
        JBVerDomiciliados.setEnabled(true);
        selectFile = null;
    }//GEN-LAST:event_JBLimpiarDomiciliadosActionPerformed

    private void JBExportarDomiciliadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBExportarDomiciliadosActionPerformed
        int selection = JCDomiciliadosFormato.getSelectedIndex();

        if (selection == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un formato a exportar", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean dataRows = helpers.hasDataCount(JTDomiciliados);
        if (!dataRows) {
            JOptionPane.showMessageDialog(this, "No existen datos para exportar", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int rangeInit = 0, rangeFin = 0, periodo = 0;
        String valor = "";

        if (JRSireDocimiciliados.isSelected() || JRPropuestaDocimiciliados.isSelected()) {
            rangeInit = SIRE.getINITSIRE();
            rangeFin = SIRE.getFINSIRE();
            periodo = SIRE.getVLR1();
            valor = SIRE.getRSCLARCCMPL();
        } else {
            rangeInit = PLE.getINITPLE();
            rangeFin = PLE.getFINPLE();
            periodo = PLE.getVLR1();
            valor = PLE.getRSCLARCCMPL();
        }

        String hPeriodoMax6 = helpers.procesarCadena((String) JTDomiciliados.getModel().getValueAt(0, periodo - 1));
        String archivoName = (empresa.getRSCLARC() + hPeriodoMax6 + valor);

        if (selection == 1) {
            if (JFSeparadorDomiciliados.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Ingresa un separador de datos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            functArchivos.exportTableToTxtExport(JTDomiciliados, JFSeparadorDomiciliados.getText(), archivoName, rangeFin, rangeInit, JDLoading, JCBAbrirDocumento.isSelected());

        } else if (selection == 2) {
            functArchivos.exportTableToExcelExport(JTDomiciliados, archivoName, SIRE, JDLoading, JCBAbrirDocumento.isSelected());
        } else {
            functArchivos.exportTableToZipExport(JTDomiciliados, "|", archivoName, rangeFin, rangeInit, JDLoading, JCBAbrirDocumento.isSelected());
        }
    }//GEN-LAST:event_JBExportarDomiciliadosActionPerformed

    private void JRPropuestaDocimiciliadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRPropuestaDocimiciliadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JRPropuestaDocimiciliadosActionPerformed

    private void JCDomiciliadosFormatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCDomiciliadosFormatoActionPerformed
        // TODO add your handling code here:
        JFSeparadorDomiciliados.setEnabled(JCDomiciliadosFormato.getSelectedIndex() == 1);
        JFSeparadorDomiciliados.setText("");
    }//GEN-LAST:event_JCDomiciliadosFormatoActionPerformed

    private void JFSeparadorDomiciliadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JFSeparadorDomiciliadosActionPerformed
        JFSeparadorDomiciliados.setEnabled(JCDomiciliadosFormato.getSelectedIndex() == 1);
        JFSeparadorDomiciliados.setText("");
    }//GEN-LAST:event_JFSeparadorDomiciliadosActionPerformed

    private void JFSeparadorDomiciliadosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JFSeparadorDomiciliadosKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_JFSeparadorDomiciliadosKeyTyped

    private void JBUpdateArcSireComparacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBUpdateArcSireComparacionActionPerformed
        // TODO add your handling code here:
        selectFileSire = helpers.CargarArchivo(this, JBUpdateArcSireComparacion, null);
    }//GEN-LAST:event_JBUpdateArcSireComparacionActionPerformed

    private void JBVerDomiciliados1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBVerDomiciliados1ActionPerformed
        if (selectFilePle == null || selectFileSire == null) {
            JOptionPane.showMessageDialog(this, "Algun archivo no se a subido correctamente, validar!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (JCComparacion.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione una opción de comparación, validar!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (JFSeparadorComparacion.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ingrese un separador de comparación, validar!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                BloquearInputsComparacion();

                // ------- TODO OK...
                float montoDiferencia = 0;
                if (!JTDiferenciaMonto.getText().equals("")) {
                    montoDiferencia = Float.parseFloat(JTDiferenciaMonto.getText());
                }

                String valorSeleccionado = (String) JCComparacion.getSelectedItem();
                int valorIndex = JCComparacion.getSelectedIndex();

                Map<String, String[]> hashMapPLE = new HashMap<>();
                Map<String, String[]> hashMapSIRE = new HashMap<>();
                Map<String, String[]> DuplicadosPLE = new HashMap<>();
                Map<String, String[]> DuplicadosSIRE = new HashMap<>();
                if (DuplicadosPLE.size() > 0) {
                    DuplicadosPLE.clear();
                }

                if (DuplicadosSIRE.size() > 0) {
                    DuplicadosSIRE.clear();
                }

                ArrayList<ErroresRender> compararErrores = new ArrayList<>();
                PLE.resetErrores();
                SIRE.resetErrores();

                // Limpia la lista de errores antes de cada ejecución
                hashMapPLE = helpers.leerArchivoYDevolverHashMap(selectFilePle, JFSeparadorComparacion.getText(), PLE.getCOLUMNSVALIDARPLE(), PLE.getCMNZLCTRA(), DuplicadosPLE);
                hashMapSIRE = helpers.leerArchivoYDevolverHashMap(selectFileSire, JFSeparadorComparacion.getText(), SIRE.getCOLUMNSVALIDARPLESIRE(), SIRE.getCMNZLCTRA(), DuplicadosSIRE);

                compararErrores.addAll(valorIndex == 1 ? PLE.getERRORESPLE() : SIRE.getERRORESPLESIRE());

                if (valorIndex == 1) {
                    excelDataGlobal = helpers.CompararSirePle(hashMapPLE, hashMapSIRE, compararErrores, montoDiferencia, SIRE, valorSeleccionado, JCBAbrirDocumento.isSelected(), DuplicadosPLE);
                } else {
                    excelDataGlobal = helpers.CompararSirePle(hashMapSIRE, hashMapPLE, compararErrores, montoDiferencia, SIRE, valorSeleccionado, JCBAbrirDocumento.isSelected(), DuplicadosSIRE);
                }

                if (excelDataGlobal.size() > 0) {
                    JCComparacionErrores.removeAllItems();
                    JCComparacionErrores.setEnabled(true);

                    for (String key : excelDataGlobal.keySet()) {
                        JCComparacionErrores.addItem(key);
                    }
                } else {
                    helpers.mensajeError("No se encontraron errores!.", 1);
                }

                return null;
            }

            @Override
            protected void done() {
                JDLoading.dispose();
            }
        };

        // Iniciar el Worker
        worker.execute();

        JDLoading.setVisible(true);
    }//GEN-LAST:event_JBVerDomiciliados1ActionPerformed

    private void JBLimpiarDomiciliados1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBLimpiarDomiciliados1ActionPerformed
        // TODO add your handling code here:
        limpiarDatosCompracion();
    }//GEN-LAST:event_JBLimpiarDomiciliados1ActionPerformed

    private void limpiarDatosCompracion() {
        JBUpdateArcPleComparacion.setText("");
        JBUpdateArcPleComparacion.setEnabled(true);
        JBUpdateArcSireComparacion.setText("");
        JBUpdateArcSireComparacion.setEnabled(true);

        JFSeparadorComparacion.setText("|");
        JCKSeparador.setSelected(false);
        JTDiferenciaMonto.setText("");
        excelDataGlobal = new HashMap<>();

        JFSeparadorComparacion.setEnabled(false);
        JCComparacion.setEnabled(true);
        JCComparacion.setSelectedIndex(0);
        JCExportarComparacionAll.setSelected(false);

        JBVerDomiciliados1.setEnabled(true);
        DefaultTableModel model = (DefaultTableModel) JTDomiciliados1.getModel();
        model.setRowCount(0);
        model.setColumnCount(0);

        JCComparacionErrores.removeAllItems();
        JCComparacionErrores.setEnabled(false);

        selectFilePle = null;
        selectFileSire = null;
    }

    private void BloquearInputsComparacion() {
        JBUpdateArcPleComparacion.setEnabled(false);
        JBUpdateArcSireComparacion.setEnabled(false);
        JCComparacion.setEnabled(false);
        JBVerDomiciliados1.setEnabled(false);
    }

    private void JCComparacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCComparacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCComparacionActionPerformed

    private void JFSeparadorComparacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JFSeparadorComparacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JFSeparadorComparacionActionPerformed

    private void JFSeparadorComparacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JFSeparadorComparacionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_JFSeparadorComparacionKeyTyped

    private void JBUpdateArcPleComparacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBUpdateArcPleComparacionActionPerformed
        // TODO add your handling code here:
        selectFilePle = helpers.CargarArchivo(this, JBUpdateArcPleComparacion, null);
    }//GEN-LAST:event_JBUpdateArcPleComparacionActionPerformed

    private void JCKSeparadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCKSeparadorActionPerformed
        // TODO add your handling code here:
        if (JCKSeparador.isSelected())
            JFSeparadorComparacion.setEnabled(true);
        else {
            JFSeparadorComparacion.setEnabled(false);
            JFSeparadorComparacion.setText("|");
        }
    }//GEN-LAST:event_JCKSeparadorActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        ocultarPaneles();
        JPRegistroComparacion.setVisible(true);
        JLTitleVentana7.setText("COMPARACIÓN REGISTRO DE VENTAS");
        limpiarDatosCompracion();
        this.PLE = updateRenderCabeceras(2);
        this.SIRE = updateRenderCabeceras(5);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        ocultarPaneles();
        JPRegistroComparacion.setVisible(true);
        JLTitleVentana7.setText("COMPARACIÓN REGISTRO DE COMPRAS");
        limpiarDatosCompracion();
        this.PLE = updateRenderCabeceras(1);
        this.SIRE = updateRenderCabeceras(4);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void JTDiferenciaMontoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTDiferenciaMontoKeyTyped
        char c = evt.getKeyChar();

        if (!Character.isDigit(c) && c != '.') {
            evt.consume(); // Rechaza el carácter si no es un número ni un punto decimal.
        } else if (c == '.' && JTDiferenciaMonto.getText().contains(".")) {
            evt.consume(); // Rechaza el segundo punto decimal.
        } else if (c == '.' && JTDiferenciaMonto.getText().isEmpty()) {
            evt.consume(); // Rechaza el punto decimal al principio.
        } else if (JTDiferenciaMonto.getText().contains(".")) {
            String text = JTDiferenciaMonto.getText();
            int dotIndex = text.indexOf('.');
            if (text.length() - dotIndex > 2) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_JTDiferenciaMontoKeyTyped

    private void JTDiferenciaMontoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTDiferenciaMontoKeyPressed
        char c = evt.getKeyChar();

        if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getKeyCode() == KeyEvent.VK_DELETE) {
            return;
        }

        if (!Character.isDigit(c) && c != '.') {
            evt.consume(); // Rechaza la tecla si no es un número ni un punto decimal.
        } else if (c == '.' && JTDiferenciaMonto.getText().contains(".")) {
            evt.consume(); // Rechaza la tecla si ya hay un punto decimal.
        } else if (c == '.' && JTDiferenciaMonto.getText().isEmpty()) {
            evt.consume(); // Rechaza el punto decimal al principio.
        } else if (JTDiferenciaMonto.getText().contains(".")) {
            // Permite solo 2 decimales después del punto.
            String text = JTDiferenciaMonto.getText();
            int dotIndex = text.indexOf('.');
            if (text.length() - dotIndex > 2) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_JTDiferenciaMontoKeyPressed

    private void JBVerVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBVerVentaActionPerformed
        if (selectFile == null) {
            JOptionPane.showMessageDialog(this, "Primero selecciona un archivo", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!JRPleVentas.isSelected() && !JRSireVentas.isSelected() && !JRPropuestaVenta.isSelected()) {
            JOptionPane.showMessageDialog(this, "Selecciona un tipo de conversión", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                try (BufferedReader archivo = new BufferedReader(new InputStreamReader(selectFile, Charset.forName("UTF-8")))) {
                    String linea;

                    if (JRPleVentas.isSelected()) {
                        functArchivos.cargarDatosEnTablaExecute(archivo, PLE, JTVentas, 1);

                    } else if (JRSireVentas.isSelected()) {
                        functArchivos.actualizarCabeceraSireExecute(JTVentas, SIRE);
                        Map<Integer, String> COLUMNASNOREGISTERLOCAL = new HashMap<>();
                        PLE = updateRenderCabeceras(SIRE.getCOLUMNEQVLNTE());
                        COLUMNASNOREGISTERLOCAL = PLE.getCOLUMNASNOREGISTER();

                        int indiceRow = 1, positionCol;

                        while ((linea = archivo.readLine()) != null) {
                            String[] cadenaLinea = linea.split("\\|");
                            List<String> dataList = new ArrayList<>(Arrays.asList(cadenaLinea));

                            for (Map.Entry<Integer, String> entry : COLUMNASNOREGISTERLOCAL.entrySet()) {
                                Integer key = entry.getKey();
                                String value = entry.getValue();
                                dataList.add(key - 1, value);
                            }

                            cadenaLinea = dataList.toArray(new String[0]);

                            String[] cadenaModificada = new String[SIRE.getCOLUMNAS().size()];
                            cadenaModificada[0] = String.valueOf(indiceRow);
                            cadenaModificada[1] = empresa.getCODRC();
                            cadenaModificada[2] = empresa.getRSCL();

                            for (int j = 3; j < SIRE.getCOLUMNAS().size(); j++) {
                                ColumnasSire columnaSire = SIRE.getCOLUMNAS().get(j - 1);

                                if ((columnaSire.getCODPLE() < cadenaLinea.length && columnaSire.getCODPLE() > 0)
                                        || columnaSire.getCDVLDCN() > 0) {

                                    switch (j) {
                                        case 3:
                                            cadenaModificada[j] = helpers.obtenerSubCadena(cadenaLinea[columnaSire.getCODPLE() - 1], 0, 6);
                                            break;
                                        case 6:
                                            if (helpers.esFechaValida(cadenaLinea[columnaSire.getCODPLE() - 1]) || columnaSire.getContenedor(cadenaLinea[columnaSire.getCDVLDCN() - 1], columnaSire.getVVLDCNS())) {
                                                cadenaModificada[j] = helpers.esFechaValida(cadenaLinea[columnaSire.getCODPLE() - 1]) ? cadenaLinea[columnaSire.getCODPLE() - 1] : cadenaLinea[columnaSire.getCLMNDFLT() - 1];
                                            } else {
                                                cadenaModificada[j] = columnaSire.getContenedor(cadenaLinea[columnaSire.getCODPLE() - 1], columnaSire.getNADMTDS()) ? columnaSire.getCLMNDFLTVLR1() : cadenaLinea[columnaSire.getCODPLE() - 1];
                                            }
                                            break;
                                        case 9:
                                            cadenaModificada[j] = helpers.procesarComprobante(cadenaLinea[columnaSire.getCODPLE() - 1], true, 0);
                                            break;
                                        case 28:
                                            cadenaModificada[j] = columnaSire.getContenedor(cadenaLinea[columnaSire.getCDVLDCN() - 1], columnaSire.getVVLDCNS())
                                                    ? columnaSire.getCLMNDFLTVLR1()
                                                    : cadenaLinea[columnaSire.getCODPLE() - 1];
                                            break;
                                        case 29:
                                        case 30:
                                        case 31:
                                        case 32:
                                            cadenaModificada[j] = columnaSire.getContenedor(cadenaLinea[columnaSire.getCODPLE() - 1], columnaSire.getNADMTDS())
                                                    ? columnaSire.getCLMNDFLTVLR1()
                                                    : cadenaLinea[columnaSire.getCODPLE() - 1];
                                            break;
                                        case 35:
                                            Integer codigoNum;
                                            try {
                                                codigoNum = Integer.parseInt(cadenaLinea[columnaSire.getCODPLE() - 1]);
                                            } catch (Exception e) {
                                                codigoNum = 0;
                                            }
                                            cadenaModificada[j] = SIRE.obtenerEstadoPorCodigo(codigoNum);
                                            break;
                                        default:
                                            cadenaModificada[j] = (columnaSire.getContenedor(cadenaLinea[columnaSire.getCODPLE() - 1], columnaSire.getNADMTDS()))
                                                    ? columnaSire.getCLMNDFLTVLR1() : cadenaLinea[columnaSire.getCODPLE() - 1];
                                            break;
                                    }
                                } else {
                                    cadenaModificada[j] = columnaSire.getCLMNDFLTVLR1();
                                }

                            }

                            functArchivos.addDataToTable(cadenaModificada, JTVentas);
                            indiceRow++;
                        }

                    } else {
                        functArchivos.cargarDatosEnTablaSireExecute(archivo, SIRE, JTVentas, 2);
                    }
                    selectFile.close();
                    JBVerVenta.setEnabled(false);

                } catch (IOException e) {
                    helpers.mensajeError("Ocurrio un error, validar el archivo.", 2);
                }

                return null;
            }

            @Override

            protected void done() {
                JDLoading.dispose();
            }
        };

        worker.execute();

        JDLoading.setVisible(
                true);
    }//GEN-LAST:event_JBVerVentaActionPerformed

    private void JBUpdateArchivVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBUpdateArchivVentasActionPerformed
        selectFile = helpers.CargarArchivo(this, JBUpdateArchivVentas, JTVentas);
    }//GEN-LAST:event_JBUpdateArchivVentasActionPerformed

    private void JBVerCompra1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBVerCompra1ActionPerformed
        if (!JRSireCompras.isSelected()) {
            helpers.mensajeError("Opción solo validada para formato SIRE, validar!.", 2);
            return;
        }

        if (JTCompras.getModel().getRowCount() > 0) {
            cargarJTableExport(JTCompras, SIRE, "DE COMPRAS");
        } else {
            helpers.mensajeError("No existen datos para generar reporte, validar!.", 2);
        }
    }//GEN-LAST:event_JBVerCompra1ActionPerformed

    private void JBVerVentaResumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBVerVentaResumenActionPerformed
        // TODO add your handling code here
        if (!JRSireVentas.isSelected()) {
            helpers.mensajeError("Opción solo validada para formato SIRE, validar!.", 2);
            return;
        }

        if (JTVentas.getModel().getRowCount() > 0) {
            cargarJTableExport(JTVentas, SIRE, "DE VENTAS");
        } else {
            helpers.mensajeError("No existen datos para generar reporte, validar!.", 2);
        }
    }//GEN-LAST:event_JBVerVentaResumenActionPerformed

    private void JBVerVentaResumen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBVerVentaResumen1ActionPerformed
        // TODO add your handling code here:
        if (!JRSireDocimiciliados.isSelected()) {
            helpers.mensajeError("Opción solo validada para formato SIRE, validar!.", 2);
            return;
        }

        if (JTDomiciliados.getModel().getRowCount() > 0) {
            cargarJTableExport(JTDomiciliados, SIRE, "DE VENTAS");
        } else {
            helpers.mensajeError("No existen datos para generar reporte, validar!.", 2);
        }
    }//GEN-LAST:event_JBVerVentaResumen1ActionPerformed

    private void JBExportarDomiciliados1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBExportarDomiciliados1ActionPerformed
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                DefaultTableModel model = (DefaultTableModel) JTDomiciliados1.getModel();

                if (model.getRowCount() > 0) {
                    String nombre = (String) JCComparacion.getSelectedItem();
                    if (nombre.isEmpty() || nombre == null) {
                        nombre = "ARCHIVO COMPARACIÓN";
                    }

                    CabecerasRender SIREVENTAS = new CabecerasRender();
                    Integer bandera = SIRE.getVLR1();
                    if (bandera == 5 && JCComparacion.getSelectedIndex() == 2) {
                        SIREVENTAS = updateRenderCabeceras(7);
                    }

                    if (JCExportarComparacionAll.isSelected()) {
                        functArchivos.generarExcelComparacion(excelDataGlobal, bandera == 5 && JCComparacion.getSelectedIndex() == 2 ? SIREVENTAS : SIRE, nombre, JCBAbrirDocumento.isSelected());
                    } else {
                        String keySelection = (String) JCComparacionErrores.getSelectedItem();
                        if (keySelection == null || keySelection.isEmpty()) {
                            helpers.mensajeError("No existen errores del valor seleccionado, validar!", 2);
                            return null;
                        }

                        Map<String, Map<String, String[]>> copia = new HashMap<>();

                        if (excelDataGlobal.containsKey(keySelection)) {
                            Map<String, String[]> datosOriginales = excelDataGlobal.get(keySelection);
                            copia.put(keySelection, new HashMap<>(datosOriginales));
                        }

                        functArchivos.generarExcelComparacion(copia, bandera == 5 && JCComparacion.getSelectedIndex() == 2 ? SIREVENTAS : SIRE, nombre, JCBAbrirDocumento.isSelected());

                    }
                } else {
                    helpers.mensajeError("No existen datos para exportar, validar!", 2);
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
    }//GEN-LAST:event_JBExportarDomiciliados1ActionPerformed

    private void JCComparacionErroresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCComparacionErroresActionPerformed
        // TODO add your handling code here:
        String keySelection = (String) JCComparacionErrores.getSelectedItem();
        if (keySelection == null || keySelection.isEmpty()) {
            if (keySelection != null) {
                helpers.mensajeError("No se ha seleccionado un filtro, validar!", 2);
            }
            return;
        }

        DefaultTableModel model = new DefaultTableModel();
        model.setRowCount(0);

        model.addColumn(""); // Columna sin título para el número de índice
        CabecerasRender SIREVENTAS = new CabecerasRender();
        if (SIRE.getVLR1() == 5 && JCComparacion.getSelectedIndex() == 2) {
            SIREVENTAS = updateRenderCabeceras(7);
            for (ColumnasSire column : SIREVENTAS.getCOLUMNAS()) {
                model.addColumn(column.getDSCRPCN());
            }
        } else {
            for (ColumnasSire column : SIRE.getCOLUMNAS()) {
                model.addColumn(column.getDSCRPCN());
            }
        }

        if (excelDataGlobal.containsKey(keySelection)) {
            Map<String, String[]> selectedMap = excelDataGlobal.get(keySelection);

            for (String innerKey : selectedMap.keySet()) {
                Object[] rowData = new Object[selectedMap.get(innerKey).length + 1]; // +1 para la columna con innerKey

                rowData[0] = innerKey;

                String[] innerValue = selectedMap.get(innerKey);
                for (int i = 0; i < innerValue.length; i++) {
                    rowData[i + 1] = innerValue[i];
                }

                model.addRow(rowData);

            }

        } else {
            helpers.mensajeError("El valor seleccionado no se reconoce, validar!", 2);
        }

        JTDomiciliados1.setModel(model);


    }//GEN-LAST:event_JCComparacionErroresActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        String mensaje = "Estimado usuario,\n\n¿Desea contactar con nuestro servicio de soporte técnico para recibir asistencia?";
        String[] opciones = {"Sí", "No"};

        int respuesta = JOptionPane.showOptionDialog(
                null,
                mensaje,
                "Contacto con Soporte Técnico",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        if (respuesta == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(
                    null,
                    "Gracias por su interés en contactar con nuestro servicio de soporte técnico. Pronto nos pondremos en contacto con usted.",
                    "Contacto con Soporte Técnico",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Entendido. Si en el futuro decide que necesita asistencia, no dude en contactarnos. ¡Que tenga un buen día!",
                    "Contacto con Soporte Técnico",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void JXMENUITEM4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JXMENUITEM4ActionPerformed
        // TODO add your handling code here:

        ocultarPaneles();
        if (!cargado) {
            ActualizarPanelConfiguracion();
            cargado = true;
        }
        JTPConfiguracion.setVisible(true);

    }//GEN-LAST:event_JXMENUITEM4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        actualizarDatosRender();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void actualizarDatosRender() {
        if (cabecerasRender.size() > 0) {
            cabecerasRender.clear();
        }
        try {
            // Crear un worker para realizar tareas en segundo plano
            SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                @Override
                protected Void doInBackground() throws Exception {
                    cabecerasRender = beansActions.obtenerCabeceras(empresa.getCODRC());
                    return null;
                }

                @Override
                protected void done() {
                    try {
                        // Actualizar la interfaz gráfica después de completar la tarea en segundo plano
                        get();
                        if (isactualizado) {
                            helpers.mensajeError("Se actualizaron sus datos con éxito.", 1);
                        }
                        if (!isactualizado) {
                            isactualizado = true;
                        }

                    } catch (InterruptedException | ExecutionException e) {
                        // Manejar cualquier excepción que ocurra durante la ejecución en segundo plano
                        helpers.mensajeError("Ocurrió un error al actualizar.", 2);
                    }

                    JDLoading.dispose();
                }
            };

            // Ejecutar el worker
            worker.execute();
            JDLoading.setVisible(true);

        } catch (Exception e) {
            helpers.mensajeError("Ocurrió un error al actualizar.", 2);
        }
    }

    private void ActualizarPanelConfiguracion() {

        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                ComprasConfig configC = new ComprasConfig(empresa);
                VentasConfig configV = new VentasConfig(empresa);
                DomiciliadosConfig configD = new DomiciliadosConfig(empresa);
                ColumnsExportConfig configExport = new ColumnsExportConfig(empresa);
                ColumnsGenerateCode configVal = new ColumnsGenerateCode(empresa);
                ConfigErroresColumnas configErrores = new ConfigErroresColumnas(empresa);

                JTPConfiguracion.addTab("COMPRAS", configC);
                JTPConfiguracion.addTab("VENTAS", configV);
                JTPConfiguracion.addTab("NO DOMICILIADOS", configD);
                JTPConfiguracion.addTab("C. EXPORTACIÓN", configExport);
                JTPConfiguracion.addTab("C. VALIDACIOENS", configVal);
                JTPConfiguracion.addTab("C. ERRORES", configErrores);
                return null;
            }

            @Override
            protected void done() {
                JDLoading.dispose();
            }
        };

        worker.execute();
        JDLoading.setVisible(true);
    }

    private void cargarJTableExport(JTable tabla, CabecerasRender cabeceraRender, String title) {
        ResumenSire modal = new ResumenSire(title, tabla,
                cabeceraRender.getCOLUMNAS(),
                cabeceraRender.getCLMNCMPRBNTE(),
                documentos);
        modal.setVisible(true);
    }

    public File CargarArchivoExcel(JButton btnArchivo) {
        File selectedArchivo = null;
        btnArchivo.setText("");
        FileDialog fileDialog = new FileDialog(this, "Seleccionar archivo Excel", FileDialog.LOAD);
        fileDialog.setFile("*.xlsx"); // Filtrar solo archivos con extensión .xlsx
        fileDialog.setVisible(true);

        String selectedFilePath = fileDialog.getFile();
        if (selectedFilePath != null) {
            selectedArchivo = new File(fileDialog.getDirectory(), selectedFilePath);

            if (selectedArchivo.isFile()) {
                btnArchivo.setText(selectedArchivo.getName());
                btnArchivo.setHorizontalAlignment(SwingConstants.LEFT);
                JOptionPane.showMessageDialog(this, "Archivo subido correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona un archivo Excel (.xlsx)", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        return selectedArchivo;
    }

    public void GuardarArchivo(Workbook workbook, String nombre) {
        // * DESCARGA DEL ARCHIVO .......
        FileDialog fileDialog = new FileDialog(this, "Guardar archivo", FileDialog.SAVE);
        fileDialog.setFile(nombre);
        fileDialog.setVisible(true);

        String directorio = fileDialog.getDirectory();
        String archivoSeleccionado = fileDialog.getFile();

        if (archivoSeleccionado != null) {
            String rutaArchivo = directorio + archivoSeleccionado;

            try (FileOutputStream fileOut = new FileOutputStream(rutaArchivo)) {
                workbook.write(fileOut);
            } catch (IOException e) {
                e.printStackTrace();
            }

            JOptionPane.showMessageDialog(this, "Archivo guardado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            selectFile = null;

            // Abrir el archivo guardado con la aplicación predeterminada
            File archivoGuardado = new File(rutaArchivo);
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.OPEN)) {
                try {
                    Desktop.getDesktop().open(archivoGuardado);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void LimpiarInpust(JComboBox combo, JButton boton) {
        boton.setText("");
        combo.setSelectedIndex(0);
        selectFile = null;
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazSire.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazSire.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazSire.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazSire.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazSire(null, null).setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.ButtonGroup BGCompras;
    javax.swing.ButtonGroup BGDomiciliados;
    javax.swing.ButtonGroup BGVentas;
    javax.swing.JButton JBExportarDomiciliados;
    javax.swing.JButton JBExportarDomiciliados1;
    javax.swing.JButton JBExportarSireCompra;
    javax.swing.JButton JBExportarVenta;
    javax.swing.JButton JBLimpiarCompra;
    javax.swing.JButton JBLimpiarDomiciliados;
    javax.swing.JButton JBLimpiarDomiciliados1;
    javax.swing.JButton JBLimpiarVenta;
    javax.swing.JButton JBUpdateArcPleComparacion;
    javax.swing.JButton JBUpdateArcSireComparacion;
    javax.swing.JButton JBUpdateArchivCompra;
    javax.swing.JButton JBUpdateArchivDomc;
    javax.swing.JButton JBUpdateArchivVentas;
    javax.swing.JButton JBVerCompra;
    javax.swing.JButton JBVerCompra1;
    javax.swing.JButton JBVerDomiciliados;
    javax.swing.JButton JBVerDomiciliados1;
    javax.swing.JButton JBVerVenta;
    javax.swing.JButton JBVerVentaResumen;
    javax.swing.JButton JBVerVentaResumen1;
    javax.swing.JCheckBox JCBAbrirDocumento;
    javax.swing.JComboBox<String> JCComparacion;
    javax.swing.JComboBox<String> JCComparacionErrores;
    javax.swing.JComboBox<String> JCComprasFormato;
    javax.swing.JComboBox<String> JCDomiciliadosFormato;
    javax.swing.JCheckBox JCExportarComparacionAll;
    javax.swing.JCheckBox JCKSeparador;
    javax.swing.JComboBox<String> JCVentasFormato;
    javax.swing.JDialog JDLoading;
    javax.swing.JTextField JFFechaAfiliacion;
    javax.swing.JTextField JFRazonSocialEmp;
    javax.swing.JTextField JFRucEmpresa;
    javax.swing.JTextField JFSeparadorComparacion;
    javax.swing.JTextField JFSeparadorCompra;
    javax.swing.JTextField JFSeparadorDomiciliados;
    javax.swing.JTextField JFSeparadorVentas;
    javax.swing.JTextField JFUsuariosEmp;
    javax.swing.JLabel JLOblig;
    javax.swing.JLabel JLOblig1;
    javax.swing.JLabel JLOblig2;
    javax.swing.JLabel JLOblig3;
    javax.swing.JLabel JLOblig4;
    javax.swing.JLabel JLOblig5;
    javax.swing.JLabel JLOblig6;
    javax.swing.JLabel JLOblig7;
    javax.swing.JLabel JLOblig8;
    javax.swing.JLabel JLTitleVentana;
    javax.swing.JLabel JLTitleVentana5;
    javax.swing.JLabel JLTitleVentana6;
    javax.swing.JLabel JLTitleVentana7;
    javax.swing.JLabel JLTitleVentana8;
    javax.swing.JLabel JLTtileArchivo;
    javax.swing.JLabel JLTtileArchivo1;
    javax.swing.JLabel JLTtileArchivo10;
    javax.swing.JLabel JLTtileArchivo11;
    javax.swing.JLabel JLTtileArchivo2;
    javax.swing.JLabel JLTtileArchivo3;
    javax.swing.JLabel JLTtileArchivo4;
    javax.swing.JLabel JLTtileArchivo5;
    javax.swing.JLabel JLTtileArchivo6;
    javax.swing.JLabel JLTtileArchivo7;
    javax.swing.JLabel JLTtileArchivo9;
    javax.swing.JLabel JLTtileArchivoD;
    javax.swing.JLabel JLTtileArchivoD1;
    javax.swing.JLabel JLTtileArchivoV;
    javax.swing.JLabel JLTtileArchivoVentas;
    javax.swing.JLabel JLTtileArchivoVentas1;
    javax.swing.JLabel JLTtileArchivoVentas2;
    javax.swing.JLabel JLlogoEmpresa;
    javax.swing.JMenuItem JMCerrarSesion;
    javax.swing.JMenuItem JMICompras;
    javax.swing.JMenuItem JMIDomiciliadas;
    javax.swing.JMenuItem JMIVentas;
    javax.swing.JMenuItem JMInicio;
    javax.swing.JPanel JPRegistroComparacion;
    javax.swing.JPanel JPRegistroCompra;
    javax.swing.JPanel JPRegistroDomiciliados;
    javax.swing.JPanel JPRegistroInicio;
    javax.swing.JPanel JPRegistroVentas;
    javax.swing.JRadioButton JRPleCompras;
    javax.swing.JRadioButton JRPleDocimiciliados;
    javax.swing.JRadioButton JRPleVentas;
    javax.swing.JRadioButton JRPropuestaCompra;
    javax.swing.JRadioButton JRPropuestaDocimiciliados;
    javax.swing.JRadioButton JRPropuestaVenta;
    javax.swing.JRadioButton JRSireCompras;
    javax.swing.JRadioButton JRSireDocimiciliados;
    javax.swing.JRadioButton JRSireVentas;
    javax.swing.JScrollPane JSTable;
    javax.swing.JScrollPane JSTable1;
    javax.swing.JScrollPane JSTable2;
    javax.swing.JScrollPane JSTable3;
    javax.swing.JTable JTCompras;
    javax.swing.JTextField JTDiferenciaMonto;
    javax.swing.JTable JTDomiciliados;
    javax.swing.JTable JTDomiciliados1;
    javax.swing.JTabbedPane JTPConfiguracion;
    javax.swing.JTable JTVentas;
    javax.swing.JMenuItem JXMENUITEM4;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel2;
    javax.swing.JLabel jLabel3;
    javax.swing.JLabel jLabel4;
    javax.swing.JLabel jLabel5;
    javax.swing.JLabel jLabel6;
    javax.swing.JLabel jLabel7;
    javax.swing.JMenu jMenu1;
    javax.swing.JMenu jMenu2;
    javax.swing.JMenu jMenu3;
    javax.swing.JMenu jMenu4;
    javax.swing.JMenuBar jMenuBar1;
    javax.swing.JMenuItem jMenuItem1;
    javax.swing.JMenuItem jMenuItem2;
    javax.swing.JMenuItem jMenuItem3;
    javax.swing.JMenuItem jMenuItem5;
    // End of variables declaration//GEN-END:variables
}
