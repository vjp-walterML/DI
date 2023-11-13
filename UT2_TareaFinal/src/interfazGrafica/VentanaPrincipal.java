package interfazGrafica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author wmartinl01
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    //Variables globales
    public Map<String, String> usuarios = new LinkedHashMap<>();
    public boolean loginCorrecto = false;

    //Constructor
    public VentanaPrincipal() {
        initComponents();
        login();//Lanzo el login
        establecerFondo();//Establezco el JPanel de fondo
        aniadirComponentes();//Añado los componentes al JPanel
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
        panelPrincipal.add(jMenuBar);

    }

    //Este método lanza el login antes de pintar todos los componentes, si el login es correcto accede a la aplicación, si no lo es volvera a pedir, y si cierra el Dialog, también se cerrará la aplicación.
    public void login() {
        Login login = new Login(this, true);
        login.setVisible(true);
        if (!loginCorrecto) {
            dispose();
        }
    }

    //Setter de loginCorrecto
    public void setLoginCorrecto(boolean loginCorrecto) {
        this.loginCorrecto = loginCorrecto;
    }

    //Código generado
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        jMenuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemAltaCliente = new javax.swing.JMenuItem();
        jMenuItemModificarCliente = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 596, Short.MAX_VALUE)
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 487, Short.MAX_VALUE)
        );

        jMenu1.setText("Clientes");

        jMenuItemAltaCliente.setText("Alta cliente");
        jMenu1.add(jMenuItemAltaCliente);

        jMenuItemModificarCliente.setText("Modificar cliente");
        jMenu1.add(jMenuItemModificarCliente);

        jMenuBar.add(jMenu1);

        setJMenuBar(jMenuBar);

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItemAltaCliente;
    private javax.swing.JMenuItem jMenuItemModificarCliente;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}
