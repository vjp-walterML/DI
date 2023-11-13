package interfazGrafica;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.netbeans.validation.api.builtin.stringvalidation.StringValidators;
import org.netbeans.validation.api.ui.ValidationGroup;

/**
 *
 * @author Walter
 */
public class Registrarse extends javax.swing.JDialog {

    //Variables globales
    private VentanaPrincipal ventanaPrincipal;

    //Constructor
    public Registrarse(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.ventanaPrincipal = (VentanaPrincipal) parent;
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
        panelPrincipal.add(jButtonRegistrarse);
    }

    //Este método implementa el validationGroup
    public void validationGroup() {
        ValidationGroup group = this.validationPanel1.getValidationGroup();
        group.add(this.jTextFieldUsuario, StringValidators.REQUIRE_NON_EMPTY_STRING);
        group.add(this.jPasswordFieldContrasenia, StringValidators.REQUIRE_NON_EMPTY_STRING);
        group.add(this.jTextFieldUsuario, StringValidators.NO_WHITESPACE);
        group.add(this.jPasswordFieldContrasenia, StringValidators.NO_WHITESPACE);
        jButtonRegistrarse.setEnabled(false);

        validationPanel1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (validationPanel1.getProblem() == null) {
                    jButtonRegistrarse.setEnabled(true);
                } else {
                    jButtonRegistrarse.setEnabled(false);
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
        jButtonRegistrarse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTextFieldUsuario.setText(org.openide.util.NbBundle.getMessage(Registrarse.class, "Registrarse.jTextFieldUsuario.text")); // NOI18N

        jPasswordFieldContrasenia.setText(org.openide.util.NbBundle.getMessage(Registrarse.class, "Registrarse.jPasswordFieldContrasenia.text")); // NOI18N

        jButtonRegistrarse.setText(org.openide.util.NbBundle.getMessage(Registrarse.class, "Registrarse.jButtonRegistrarse.text")); // NOI18N
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
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(validationPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPasswordFieldContrasenia)
                            .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(103, 103, 103))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonRegistrarse)
                .addGap(139, 139, 139))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(validationPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jPasswordFieldContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jButtonRegistrarse)
                .addContainerGap(75, Short.MAX_VALUE))
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

    //Botón registrarse
    private void jButtonRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarseActionPerformed
        //Recupero los datos que introduce el usuario
        String nombre = jTextFieldUsuario.getText();
        String psw = new String(jPasswordFieldContrasenia.getPassword());
        psw = Logica.Utileria.encodeToMD5(psw);//Codifico la contraseña
        //Compruebo si el usuario que intenta registrar ya existe o no
        if (ventanaPrincipal.usuarios.containsKey(nombre)) {
            JOptionPane.showMessageDialog(this, "¡El usuario que intentas registrar ya existe!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            //Creo flujos
            PrintWriter pw = crearFlujos();
            //Escribo
            String nuevoUsuario = nombre + "-" + psw;
            pw.println(nuevoUsuario);
            //Cierro flujos
            pw.close();
            //Muestro mensaje de registro correcto
            JOptionPane.showMessageDialog(this, "¡Usuario registrado correctamente!", "Registro correcto", JOptionPane.INFORMATION_MESSAGE);
        }
        ventanaPrincipal.usuarios = Logica.Utileria.cargarDatos();
        dispose();//Cierro ventana
    }//GEN-LAST:event_jButtonRegistrarseActionPerformed

    //Método auxiliar para cerrar los flujos de escritura
    private PrintWriter crearFlujos() {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(Logica.Constantes.FICHERO_USERS, true));
            return pw;
        } catch (IOException ex) {
            return null;
        }
    }

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
            java.util.logging.Logger.getLogger(Registrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registrarse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Registrarse dialog = new Registrarse(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonRegistrarse;
    private javax.swing.JPasswordField jPasswordFieldContrasenia;
    private javax.swing.JTextField jTextFieldUsuario;
    private javax.swing.JPanel panelPrincipal;
    private org.netbeans.validation.api.ui.swing.ValidationPanel validationPanel1;
    // End of variables declaration//GEN-END:variables
}
