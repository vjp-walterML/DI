package ejercicioexamen4;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Walter
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    //Variables globales
    private ImageIcon fichaRoja;
    private ImageIcon fichaAzul;

    //Constructor
    public VentanaPrincipal() {
        initComponents();
        recuperarImagenesFicha();
        establecerTablero();
    }

    public void establecerTablero() {
        jPanelTablero.removeAll();
        jPanelTablero.revalidate();
        jPanelTablero.repaint();
        jPanelTablero.setLayout(new GridLayout(3, 3));
        for (int i = 0; i < 9; i++) {
            JButton boton = new JButton();
            boton.setName("VACIA");
            boton.setBackground(Color.WHITE);
            boton.setPreferredSize(new Dimension(Constantes.ANCHO_FICHA, Constantes.ALTO_FICHA));
            addActionListener(boton);
            jPanelTablero.add(boton);
        }
    }

    public void addActionListener(JButton boton) {
        boton.addActionListener((ActionEvent e) -> {
            boton.setIcon(fichaAzul);
            boton.setName("A");
            if (!comprobarGanador()) {
                turnoCPU();
            }
        });
    }

    public void turnoCPU() {
        for (Component c : jPanelTablero.getComponents()) {
            JButton boton = (JButton) c;
            if (boton.getName().equalsIgnoreCase("VACIA")) {
                boton.setIcon(fichaRoja);
                boton.setName("R");
                comprobarGanador();
                return;
            }
        }
    }

    public boolean comprobarGanador() {
        boolean ganaUser = false;
        boolean ganaCpu = false;
        List<JButton> b = new ArrayList<>();
        //Añado los botones a la lista
        for (Component c : jPanelTablero.getComponents()) {
            JButton boton = (JButton) c;
            b.add(boton);
        }

        if (b.get(0).getName().equalsIgnoreCase("R") && b.get(1).getName().equalsIgnoreCase("R") && b.get(2).getName().equalsIgnoreCase("R")
                || b.get(3).getName().equalsIgnoreCase("R") && b.get(4).getName().equalsIgnoreCase("R") && b.get(5).getName().equalsIgnoreCase("R")
                || b.get(6).getName().equalsIgnoreCase("R") && b.get(7).getName().equalsIgnoreCase("R") && b.get(8).getName().equalsIgnoreCase("R")
                || b.get(0).getName().equalsIgnoreCase("R") && b.get(4).getName().equalsIgnoreCase("R") && b.get(8).getName().equalsIgnoreCase("R")
                || b.get(2).getName().equalsIgnoreCase("R") && b.get(4).getName().equalsIgnoreCase("R") && b.get(6).getName().equalsIgnoreCase("R")) {
            ganaCpu = true;
        } else {
            if (b.get(0).getName().equalsIgnoreCase("A") && b.get(1).getName().equalsIgnoreCase("A") && b.get(2).getName().equalsIgnoreCase("A")
                    || b.get(3).getName().equalsIgnoreCase("A") && b.get(4).getName().equalsIgnoreCase("A") && b.get(5).getName().equalsIgnoreCase("A")
                    || b.get(6).getName().equalsIgnoreCase("A") && b.get(7).getName().equalsIgnoreCase("A") && b.get(8).getName().equalsIgnoreCase("A")
                    || b.get(0).getName().equalsIgnoreCase("A") && b.get(4).getName().equalsIgnoreCase("A") && b.get(8).getName().equalsIgnoreCase("A")
                    || b.get(2).getName().equalsIgnoreCase("A") && b.get(4).getName().equalsIgnoreCase("A") && b.get(6).getName().equalsIgnoreCase("A")) {
                ganaUser = true;
            }
        }
        int opcion;
        if (ganaCpu) {
            opcion = JOptionPane.showConfirmDialog(this, "HAS PERDIDO, DESEA VOLVER A JUGAR?", "game over", JOptionPane.YES_NO_OPTION);
        } else {
            if (ganaUser) {
                opcion = JOptionPane.showConfirmDialog(this, "HAS GANADO, DESEA VOLVER A JUGAR?", "WIN", JOptionPane.YES_NO_OPTION);
            } else {
                opcion = comprobarEmpate();
            }
        }

        if (opcion == -1) {
            return false;
        } else {
            if (opcion == JOptionPane.YES_OPTION) {
                establecerTablero();
            } else {
                dispose();
            }
            return true;
        }
    }

    public int comprobarEmpate() {
        for (Component c : jPanelTablero.getComponents()) {
            JButton boton = (JButton) c;
            if (boton.getName().equalsIgnoreCase("VACIA")) {
                return -1;
            }
        }
        return JOptionPane.showConfirmDialog(this, "EMPATE, DESEA VOLVER A JUGAR?", "EMPATE", JOptionPane.YES_NO_OPTION);
    }

    public void recuperarImagenesFicha() {
        //Ficha AZUL
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/IMG/fichaAzul.png"));
        Image image = imageIcon.getImage();
        Image newImg = image.getScaledInstance(Constantes.ANCHO_FICHA, Constantes.ALTO_FICHA, java.awt.Image.SCALE_SMOOTH);
        fichaAzul = new ImageIcon(newImg);
        //Ficha ROJA
        ImageIcon imageIcon2 = new ImageIcon(getClass().getResource("/IMG/fichaRoja.png"));
        Image image2 = imageIcon2.getImage();
        Image newImg2 = image2.getScaledInstance(Constantes.ANCHO_FICHA, Constantes.ALTO_FICHA, java.awt.Image.SCALE_SMOOTH);
        fichaRoja = new ImageIcon(newImg2);
    }

    //Código generado
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTablero = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanelTableroLayout = new javax.swing.GroupLayout(jPanelTablero);
        jPanelTablero.setLayout(jPanelTableroLayout);
        jPanelTableroLayout.setHorizontalGroup(
            jPanelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 324, Short.MAX_VALUE)
        );
        jPanelTableroLayout.setVerticalGroup(
            jPanelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(jPanelTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(138, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jPanelTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
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
    private javax.swing.JPanel jPanelTablero;
    // End of variables declaration//GEN-END:variables
}
