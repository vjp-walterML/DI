package InterfazGrafica;

import Logica.Juego;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author wmartinl01
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    //Variables globales
    //Atributos para crear el objeto Juego
    private String nombre;
    private int tiempo;
    private String nivel;

    //Constructor
    public VentanaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonNivelFacil = new javax.swing.JButton();
        jButtonNivelDificil = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableResultados = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonNivelFacil.setText("Nivel Fácil");
        jButtonNivelFacil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNivelFacilActionPerformed(evt);
            }
        });

        jButtonNivelDificil.setText("Nivel Difícil");
        jButtonNivelDificil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNivelDificilActionPerformed(evt);
            }
        });

        jTableResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Tiempo", "Nivel"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableResultados);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jButtonNivelFacil)
                        .addGap(88, 88, 88)
                        .addComponent(jButtonNivelDificil))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNivelFacil)
                    .addComponent(jButtonNivelDificil))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //NIVEL FÁCIL
    private void jButtonNivelFacilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNivelFacilActionPerformed
        NivelFacil nivelFacil = new NivelFacil(this, true);
        nivelFacil.setVisible(true);
        //Creo nuevo juego si lo ha conseguido
        if (tiempo != 0) {
            Juego juegoFacil = new Juego();
            juegoFacil.setNombre(nombre);
            juegoFacil.setTiempo(tiempo);
            juegoFacil.setNivel(nivel);
            //Añado la información a la tabla
            aniadirRegistroTabla(juegoFacil);
            //Reseteo el atributo tiempo (Que es el que uso para saber si ha perdido o ganado el usuario)
            tiempo = 0;
        } else {
            GameOver gameOver = new GameOver(this, true);
            gameOver.setVisible(true);
        }

    }//GEN-LAST:event_jButtonNivelFacilActionPerformed

    //NIVEL DIFÍCIL
    private void jButtonNivelDificilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNivelDificilActionPerformed
        NivelDificil nivelDificil = new NivelDificil(this, true);
        nivelDificil.setVisible(true);
        //Creo nuevo juego si lo ha conseguido
        if (tiempo != 0) {
            Juego juegoDificil = new Juego();
            juegoDificil.setNombre(nombre);
            juegoDificil.setTiempo(tiempo);
            juegoDificil.setNivel(nivel);
            //Añado la información a la tabla
            aniadirRegistroTabla(juegoDificil);
            //Reseteo el atributo tiempo (Que es el que uso para saber si ha perdido o ganado el usuario)
            tiempo = 0;
        } else {
            GameOver gameOver = new GameOver(this, true);
            gameOver.setVisible(true);
        }
    }//GEN-LAST:event_jButtonNivelDificilActionPerformed

    //SETTER
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    //AÑADIR DATOS A LA TABLA
    public void aniadirRegistroTabla(Juego juego) {
        DefaultTableModel tabla = (DefaultTableModel) jTableResultados.getModel();
        tabla.addRow(juego.toArrayString());
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
    private javax.swing.JButton jButtonNivelDificil;
    private javax.swing.JButton jButtonNivelFacil;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableResultados;
    // End of variables declaration//GEN-END:variables
}
