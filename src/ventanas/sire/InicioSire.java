package ventanas.sire;

import clases.CabecerasRender;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import clases.Empresa;
import java.awt.Dialog;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.SwingWorker;
import ventanas.helpers.Helpers;
import ventanas.helpers.ActionsPerformand;

public class InicioSire extends javax.swing.JFrame {

    private ActionsPerformand beansActions = new ActionsPerformand();
    Helpers helpers = new Helpers();

    public InicioSire() {
        initComponents();
   
        Color backgroundColor = new Color(240, 240, 240); // Puedes ajustar los valores RGB
        getContentPane().setBackground(backgroundColor);

        helpers.SetImageLabel(JLLogoEmpresa, "src/resources/logosystem.png");
        JDLoading.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        JDLoading.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        JDLoading.setSize(250, 150); // Ajusta el tamaño del diálogo según tus necesidades
        JDLoading.setLocationRelativeTo(null);
        ImageIcon loadingIcon = new ImageIcon("src/resources/Spinner.gif"); // Reemplaza "ruta_de_tu_archivo.gif" con la ruta de tu archivo GIF
        loadingIcon = new ImageIcon(loadingIcon.getImage().getScaledInstance(JDLoading.getWidth(), JDLoading.getHeight(), Image.SCALE_DEFAULT));
        jLabel6.setIcon(loadingIcon);
        jLabel6.setOpaque(false);

        this.repaint();
        setIconImage(getIconImage());
        this.setLocationRelativeTo(this);
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(
                ClassLoader.getSystemResource("resources/logosystem.png")
        );
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JDLoading = new javax.swing.JDialog();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        JTRuc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        JPPassword = new javax.swing.JPasswordField();
        JBIngresar = new javax.swing.JButton();
        JLLogoEmpresa = new javax.swing.JLabel();
        JLDerechosRes = new javax.swing.JLabel();

        JDLoading.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        JDLoading.setTitle("Espere un momento..");
        JDLoading.setBackground(new java.awt.Color(255, 255, 255));
        JDLoading.setResizable(false);
        JDLoading.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Spinner.gif"))); // NOI18N
        JDLoading.getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 130));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SISTEMA SIRE");
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(getIconImage());
        setIconImages(null);
        setLocationByPlatform(true);
        setResizable(false);

        jLabel1.setText("RUC");

        JTRuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTRucActionPerformed(evt);
            }
        });
        JTRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTRucKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTRucKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTRucKeyTyped(evt);
            }
        });

        jLabel3.setText("CONTRASEÑA");

        JPPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JPPasswordActionPerformed(evt);
            }
        });
        JPPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JPPasswordKeyTyped(evt);
            }
        });

        JBIngresar.setText("INGRESAR");
        JBIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBIngresarActionPerformed(evt);
            }
        });

        JLLogoEmpresa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        JLDerechosRes.setFont(new java.awt.Font("Segoe UI", 2, 8)); // NOI18N
        JLDerechosRes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLDerechosRes.setText("©2023 C&C Contadores Asociados S.R.L. Todos los derechos reservados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JLDerechosRes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(JTRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(JPPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(JBIngresar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(JLLogoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(JLLogoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(JTRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(12, 12, 12)
                .addComponent(JPPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(JBIngresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(JLDerechosRes)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTRucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTRucActionPerformed
    }//GEN-LAST:event_JTRucActionPerformed

    private void JPPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JPPasswordActionPerformed
    }//GEN-LAST:event_JPPasswordActionPerformed

    private void JBIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBIngresarActionPerformed
        String ruc = JTRuc.getText();
        char[] passwordText = JPPassword.getPassword();
        String password = new String(passwordText);

        if (ruc.length() < 11) {
            helpers.mensajeError("El RUC debe tener al menos 11 caracteres, validar!.", 2);
            return;
        }

        if (password.length() < 6) {
            helpers.mensajeError("La contraseña debe tener al menos 6 caracteres, validar!.", 2);
            return;
        }

        SwingWorker<Empresa, Void> worker = new SwingWorker<Empresa, Void>() {
            @Override
            protected Empresa doInBackground() {
                try {
                    Empresa empresa = beansActions.autenticarUsuario(ruc, password);
                    if (empresa != null) {
                        switch (empresa.getMENSAJE()) {
                            case 1:
                               // ArrayList<CabecerasRender> cabeceras;
                                //try {
                                    dispose();
                                    InterfazSire interfazSiri = new InterfazSire(empresa, null);
                                    interfazSiri.setVisible(true);

                                //} catch (SQLException ex) {
                                  //  Logger.getLogger(InicioSire.class.getName()).log(Level.SEVERE, null, ex);
                                   // helpers.mensajeError("Ocurrió un error. Por favor, póngase en contacto con el soporte técnico.", 2);
                                //}
                                break;

                            case 2:
                                helpers.mensajeError("El usuario no existe.", 2);
                                break;
                            case 3:
                                helpers.mensajeError("Contraseña incorrecta.", 2);
                                break;
                            default:
                                break;
                        }
                    } else {
                        helpers.mensajeError("Ocurrió un error. Por favor, póngase en contacto con el soporte técnico.", 2);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void done() {
                JDLoading.dispose();
            }
        };

        worker.execute(); // Iniciar el SwingWorker en un hilo separado
        JDLoading.setVisible(true); // Muestra el diálogo de carga antes de iniciar el SwingWorker
    }//GEN-LAST:event_JBIngresarActionPerformed

    private void JTRucKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTRucKeyPressed
    }//GEN-LAST:event_JTRucKeyPressed

    private void JTRucKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTRucKeyReleased
    }//GEN-LAST:event_JTRucKeyReleased

    private void JTRucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTRucKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || JTRuc.getText().length() >= 11)
            evt.consume();
    }//GEN-LAST:event_JTRucKeyTyped

    private void JPPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JPPasswordKeyTyped
        char c = evt.getKeyChar();
        String currentPassword = new String(JPPassword.getPassword());

        if (!(Character.isLetterOrDigit(c) || c == '.' || c == '&' || currentPassword.length() >= 12))
            evt.consume();
    }//GEN-LAST:event_JPPasswordKeyTyped

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InicioSire.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioSire.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioSire.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioSire.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioSire().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBIngresar;
    private javax.swing.JDialog JDLoading;
    private javax.swing.JLabel JLDerechosRes;
    private javax.swing.JLabel JLLogoEmpresa;
    private javax.swing.JPasswordField JPPassword;
    private javax.swing.JTextField JTRuc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
