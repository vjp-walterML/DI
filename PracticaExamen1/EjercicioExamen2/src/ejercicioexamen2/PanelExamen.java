package ejercicioexamen2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Walter
 */
public class PanelExamen extends JPanel {

    //Variables globales
    private int aleatorio;

    public PanelExamen() {
        super();
        setLayout(new BorderLayout());
        setBounds(0, 0, 200, 200);
        aleatorio = generarAleatorio();
        //Label
        JLabel label = new JLabel("Examen Walter Martin Lopes " + aleatorio);
        add(label, BorderLayout.PAGE_START);
        //Boton
        JButton boton = new JButton("PULSAME");
        boton.addMouseListener(new MiListener());
        addActionListener(boton);
        add(boton, BorderLayout.CENTER);
    }

    private int generarAleatorio() {
        return (int) (Math.round(Math.random() * 11) + 1);
    }

    private void addActionListener(JButton boton) {
        boton.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(this, "Pulsado el botón nº " + aleatorio, "JOptionPane", JOptionPane.WARNING_MESSAGE);
        });
    }
}
