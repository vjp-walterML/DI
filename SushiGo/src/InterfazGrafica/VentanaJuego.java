package InterfazGrafica;

import LogicaJuego.Carta;
import LogicaJuego.Constantes;
import LogicaJuego.Juego;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Walter
 */
public class VentanaJuego extends javax.swing.JDialog {

    //Variables globales
    private VentanaInicio ventanaPrincipal;
    private Juego juego;
    private JLabel ventanaJuego;

    //Constructor
    public VentanaJuego(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.ventanaPrincipal = (VentanaInicio) parent;
        this.juego = ventanaPrincipal.juego;
        //Pintar tablero
        pintarTablero();
        //Comunico las ventanas
        juego.comunicarVentanaJuego(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelManoUsuario = new javax.swing.JPanel();
        jPanelCartasVisiblesUsuario = new javax.swing.JPanel();
        jPanelCartasVisiblesCpu1 = new javax.swing.JPanel();
        jPanelCartasVisiblesCpu2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanelCartasVisiblesUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelManoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jPanelCartasVisiblesCpu2, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(137, 137, 137)
                            .addComponent(jPanelCartasVisiblesCpu1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanelManoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelCartasVisiblesUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelCartasVisiblesCpu1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jPanelCartasVisiblesCpu2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(249, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //PINTAR TABLERO ============================================================
    private void pintarTablero() {
        establecerFondo();
        crearPaneles();
        actualizarCartas();
    }

    private void establecerFondo() {
        // Cargar la imagen de fondo
        ImageIcon icon = new ImageIcon("src/IMG/mesa.png");
        // Crear un JLabel con la imagen de fondo
        JLabel labelConFondo = new JLabel(icon);
        this.ventanaJuego = labelConFondo;
        labelConFondo.setLayout(null);
        // Establecer el JLabel como el contenido del JDialog
        this.setContentPane(labelConFondo);
        this.pack();
    }

    private void crearPaneles() {
        jPanelManoUsuario.setBounds(125, 32, Constantes.ANCHO_PANEL, Constantes.ALTO_PANEL);//Establezco dimensiones
        jPanelManoUsuario.setBackground(new Color(0, 0, 0, 0));//Establezco color transparente
        jPanelManoUsuario.setOpaque(false); //Informo a Swing de que el panel debe ser transparente
        ventanaJuego.add(jPanelManoUsuario); //Añado el panel a ventanaJuego
        jPanelCartasVisiblesUsuario.setBounds(125, 192, Constantes.ANCHO_PANEL, Constantes.ALTO_PANEL);
        jPanelCartasVisiblesUsuario.setBackground(new Color(0, 0, 0, 0));
        jPanelCartasVisiblesUsuario.setOpaque(false);
        ventanaJuego.add(jPanelCartasVisiblesUsuario);
        jPanelCartasVisiblesCpu1.setBounds(125, 368, Constantes.ANCHO_PANEL, Constantes.ALTO_PANEL);
        jPanelCartasVisiblesCpu1.setBackground(new Color(0, 0, 0, 0));
        jPanelCartasVisiblesCpu1.setOpaque(false);
        ventanaJuego.add(jPanelCartasVisiblesCpu1);
        jPanelCartasVisiblesCpu2.setBounds(125, 547, Constantes.ANCHO_PANEL, Constantes.ALTO_PANEL);
        jPanelCartasVisiblesCpu2.setBackground(new Color(0, 0, 0, 0));
        jPanelCartasVisiblesCpu2.setOpaque(false);
        ventanaJuego.add(jPanelCartasVisiblesCpu2);
    }

    public void borrarComponentesActualizar() {
        jPanelCartasVisiblesCpu1.removeAll();
        jPanelCartasVisiblesCpu1.revalidate();
        jPanelCartasVisiblesCpu1.repaint();
        jPanelCartasVisiblesCpu2.removeAll();
        jPanelCartasVisiblesCpu2.revalidate();
        jPanelCartasVisiblesCpu2.repaint();
        jPanelCartasVisiblesUsuario.removeAll();
        jPanelCartasVisiblesUsuario.revalidate();
        jPanelCartasVisiblesUsuario.repaint();
        jPanelManoUsuario.removeAll();
        jPanelManoUsuario.revalidate();
        jPanelManoUsuario.repaint();
    }

    //Este método actualiza las cartas en la pantalla
    public void actualizarCartas() {
        //Elimino todos los componentes existentes en los paneles y actualizo
        borrarComponentesActualizar();
        //Recorro los jugadores
        juego.getJugadores().forEach(jugador -> {
            //Si el jugador es USER
            if (!jugador.esCPU()) {
                //Me recorro sus cartas visibles, creando un botón para cada una y añadiendo su representacion a su respectivo JPanel
                for (int i = 0; i < jugador.getCartasVisibles().size(); i++) {
                    Carta carta = jugador.getCartasVisibles().get(i);
                    JButton boton = new JButton(carta.getRepresentacion());
                    boton.setName(String.valueOf(i));
                    configurarEstilosBoton(boton);//Configuro los estilos del boton
                    generarActionListenerBoton(boton);//Genero un action listener para el boton
                    jPanelCartasVisiblesUsuario.add(boton);//Añado el boton al panel correspondiente
                    jPanelCartasVisiblesUsuario.revalidate();//Refresco
                    jPanelCartasVisiblesUsuario.repaint();//Refresco
                }
                //Me recorro su mano de cartas añadiendo su representacion a su respectivo JPanel
                jugador.getMano().forEach(carta -> {
                    JLabel jLabel = new JLabel(carta.getRepresentacion());
                    jPanelManoUsuario.add(jLabel);//Añado el label al panel correspondiente
                    jPanelManoUsuario.revalidate();//Refresco
                    jPanelManoUsuario.repaint();//Refresco
                });
            } else {
                //Si es un CPU creo un label con la representacion de la carta y lo añado a su respectivo Jpanel
                jugador.getCartasVisibles().forEach(carta -> {
                    JLabel jLabel = new JLabel(carta.getRepresentacion());
                    if (jugador.getNombre().equalsIgnoreCase(Constantes.CPU1)) {
                        jPanelCartasVisiblesCpu1.add(jLabel);//Añado el label al panel correspondiente
                        jPanelCartasVisiblesCpu1.revalidate();//Refresco
                        jPanelCartasVisiblesCpu1.repaint();//Refresco
                    } else {
                        jPanelCartasVisiblesCpu2.add(jLabel);//Añado el label al panel correspondiente
                        jPanelCartasVisiblesCpu2.revalidate();//Refresco
                        jPanelCartasVisiblesCpu2.repaint();//Refresco
                    }
                });
            }
        });
    }

    private void configurarEstilosBoton(JButton boton) {
        // Ajustar el tamaño del botón al tamaño de la imagen
        boton.setPreferredSize(new Dimension(Constantes.ANCHO_CARTA, Constantes.ALTO_CARTA));
        // Configurar el botón para que solo muestre la imagen
        boton.setBorderPainted(false);      // Quitar el borde
        boton.setFocusPainted(false);       // Quitar el efecto de enfoque
        boton.setContentAreaFilled(false);  // Quitar el fondo del botón
        boton.setMargin(new Insets(0, 0, 0, 0)); // Ajustar márgenes
    }

    private void generarActionListenerBoton(JButton boton) {
        //Genero un actionListener para el botón
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton botonUsado = (JButton) e.getSource(); // Obtengo el botón que disparó el evento
                int cartaSeleccionada = Integer.valueOf(botonUsado.getName());//Obtengo el texto del boton (Indice de la carta) y lo convierto en Integer
                juego.jugarTurnoUsuario(cartaSeleccionada);
            }
        });
    }

    //===========================================================================
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
    private javax.swing.JPanel jPanelCartasVisiblesCpu1;
    private javax.swing.JPanel jPanelCartasVisiblesCpu2;
    private javax.swing.JPanel jPanelCartasVisiblesUsuario;
    private javax.swing.JPanel jPanelManoUsuario;
    // End of variables declaration//GEN-END:variables
}
