package InterfazGrafica;

import Logica.Tiempo;

/**
 *
 * @author wmartinl01
 */
public class VentanaJuego extends javax.swing.JDialog {
    
    private Tiempo tiempo = new Tiempo(this);
    private VentanaPrincipal ventanaPrincipal;

    //Constructor
    public VentanaJuego(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ventanaPrincipal = (VentanaPrincipal) parent;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelSegundos = new javax.swing.JLabel();
        jButtonJuego = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelSegundos.setText("Segundos");

        jButtonJuego.setText("PULSAME");
        jButtonJuego.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButtonJuegoMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButtonJuegoMouseReleased(evt);
            }
        });
        jButtonJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonJuegoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonJuego)
                    .addComponent(jLabelSegundos, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(229, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jLabelSegundos, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addComponent(jButtonJuego)
                .addGap(99, 99, 99))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //ESTABLECER SEGUNDOS
    public void actualizarSegundos(int segundos) {
        jLabelSegundos.setText(String.valueOf(segundos));
    }

    //BOTÓN JUEGO ===============================================================
    private void jButtonJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonJuegoActionPerformed

    }//GEN-LAST:event_jButtonJuegoActionPerformed

    private void jButtonJuegoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonJuegoMousePressed
        //Empiezo a contar
        tiempo.Contar();
    }//GEN-LAST:event_jButtonJuegoMousePressed

    private void jButtonJuegoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonJuegoMouseReleased
        //Paro de contar
        tiempo.Detener();
        //Paso la info a VentanaPrincipal
        ventanaPrincipal.setTiempo(tiempo.getSegundos());
        //Creo ventanaNombre y la abro
        VentanaNombre ventanaNombre = new VentanaNombre(ventanaPrincipal, true);
        ventanaNombre.setVisible(true);
        //Cierro
        dispose();

    }//GEN-LAST:event_jButtonJuegoMouseReleased
    //==============================================================================
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
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaJuego dialog = new VentanaJuego(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonJuego;
    private javax.swing.JLabel jLabelSegundos;
    // End of variables declaration//GEN-END:variables
}
