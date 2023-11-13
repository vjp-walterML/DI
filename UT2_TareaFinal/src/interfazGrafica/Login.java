package interfazGrafica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.netbeans.validation.api.builtin.stringvalidation.StringValidators;
import org.netbeans.validation.api.ui.ValidationGroup;

/**
 *
 * @author Walter
 */
public class Login extends javax.swing.JDialog {

    //Variables globales
    private final VentanaPrincipal ventanaPrincipal;
    public Map<String, String> usuarios;

    //Constructor
    public Login(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.ventanaPrincipal = (VentanaPrincipal) parent;
        usuarios = this.ventanaPrincipal.usuarios;
        usuarios = Logica.Utileria.cargarDatos();//Cargo los datos de los usuarios registrados
        establecerFondo();//Establezco el JPanel de fondo
        aniadirComponentes();//Añado los componentes al JPanels
        validationGroup();//Implemento el validationGroup

    }

    //Establece un JPanel de fondo con una imagen
    public void establecerFondo() {
        //PanelFondo panelPrincipal = new PanelFondo("src/interfazGrafica/IMG/3.png");
        panelPrincipal = new PanelFondo("src/interfazGrafica/IMG/3.png");
        panelPrincipal.setLayout(null);//Layout absoluto
        // Establecer el JPanel como el contenido del Jframe
        this.setContentPane(panelPrincipal);
    }

    //En este método se añaden los componentes al JPanel para que sean visibles
    public void aniadirComponentes() {
        panelPrincipal.add(validationPanel1);
        panelPrincipal.add(jTextFieldUsuario);
        panelPrincipal.add(jPasswordFieldContrasenia);
        panelPrincipal.add(jButtonIniciarSesion);
        panelPrincipal.add(jButtonRegistrarse);
    }

    //Este método implementa el validationGroup
    public void validationGroup() {
        ValidationGroup group = this.validationPanel1.getValidationGroup();
        group.add(this.jTextFieldUsuario, StringValidators.REQUIRE_NON_EMPTY_STRING);
        group.add(this.jPasswordFieldContrasenia, StringValidators.REQUIRE_NON_EMPTY_STRING);
        group.add(this.jTextFieldUsuario, StringValidators.NO_WHITESPACE);
        group.add(this.jPasswordFieldContrasenia, StringValidators.NO_WHITESPACE);
        jButtonIniciarSesion.setEnabled(false);

        validationPanel1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (validationPanel1.getProblem() == null) {
                    jButtonIniciarSesion.setEnabled(true);
                    jButtonRegistrarse.setEnabled(false);
                } else {
                    jButtonIniciarSesion.setEnabled(false);
                    jButtonRegistrarse.setEnabled(true);
                }
            }
        });
    }

    //Código generado
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        validationPanel1 = new org.netbeans.validation.api.ui.swing.ValidationPanel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jPasswordFieldContrasenia = new javax.swing.JPasswordField();
        jButtonIniciarSesion = new javax.swing.JButton();
        jButtonRegistrarse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        validationPanel1.setOpaque(false);

        jButtonIniciarSesion.setText("Iniciar Sesión");
        jButtonIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarSesionActionPerformed(evt);
            }
        });

        jButtonRegistrarse.setText("Registrarse");
        jButtonRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelPrincipalLayout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jButtonIniciarSesion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonRegistrarse))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelPrincipalLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(validationPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordFieldContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(validationPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPasswordFieldContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonIniciarSesion)
                    .addComponent(jButtonRegistrarse))
                .addGap(61, 61, 61))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Botón iniciar sesión
    private void jButtonIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarSesionActionPerformed
        //Obtengo los datos que el usuario ha introducido en los campos
        String nombre = jTextFieldUsuario.getText();
        String psw = new String(jPasswordFieldContrasenia.getPassword());
        //Codifico a MD5 para comparar
        psw = Logica.Utileria.encodeToMD5(psw);
        //Controlo si el usuario existe
        if (usuarios.containsKey(nombre)) {
            //Controlo si la contraseña es correcta
            if (usuarios.get(nombre).equals(psw)) {
                //Muestro mensaje de login correcto
                JOptionPane.showMessageDialog(this, "¡Bienvenido " + nombre + "!", "Inicio de sesión correcto", JOptionPane.INFORMATION_MESSAGE);
                ventanaPrincipal.setLoginCorrecto(true);//Establezco a true el login correcto para que deje acceder al programa
            } else {
                //Muestro mensaje de contraseña incorrecta
                JOptionPane.showMessageDialog(this, "¡Contraseña incorrecta!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            //Muestro mensaje de error, ya que no existe ese usuario
            JOptionPane.showMessageDialog(this, "Usuario no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonIniciarSesionActionPerformed

    //Botón registrarse
    private void jButtonRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarseActionPerformed
        Registrarse ventanaRegistrarse = new Registrarse(ventanaPrincipal, true);
        ventanaRegistrarse.setVisible(true);
        //Refresco los datos de usuarios
        usuarios = Logica.Utileria.cargarDatos();
    }//GEN-LAST:event_jButtonRegistrarseActionPerformed

    //Main
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login dialog = new Login(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIniciarSesion;
    private javax.swing.JButton jButtonRegistrarse;
    private javax.swing.JPasswordField jPasswordFieldContrasenia;
    private javax.swing.JTextField jTextFieldUsuario;
    private javax.swing.JPanel panelPrincipal;
    private org.netbeans.validation.api.ui.swing.ValidationPanel validationPanel1;
    // End of variables declaration//GEN-END:variables
}
