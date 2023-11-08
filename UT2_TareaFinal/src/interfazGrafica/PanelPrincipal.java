package interfazGrafica;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author wmartinl01
 */
public class PanelPrincipal extends JPanel {

    private Image fondo;

    public PanelPrincipal(String rutaImagen) {
        fondo = new ImageIcon(rutaImagen).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fondo, WIDTH, WIDTH, this);
    }

}
