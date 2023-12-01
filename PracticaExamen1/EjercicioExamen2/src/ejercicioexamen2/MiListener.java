package ejercicioexamen2;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/**
 *
 * @author Walter
 */
public class MiListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        JButton boton = (JButton) e.getSource();
        boton.setBackground(Color.GREEN);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JButton boton = (JButton) e.getSource();
        boton.setBackground(Color.RED);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JButton boton = (JButton) e.getSource();
        boton.setBackground(Color.YELLOW);
    }

}
