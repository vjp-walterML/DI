package interfazGrafica;

/**
 *
 * @author Walter
 */
import java.awt.Component;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JTable;

//Esta clase sirve para crear un Renderizador personalizado para centrar el texto de las celdas del header de la tabla
public class HeaderRenderer extends DefaultTableCellRenderer {

    public HeaderRenderer() {
        setHorizontalAlignment(CENTER); // Centra el texto
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        return this;
    }
}
