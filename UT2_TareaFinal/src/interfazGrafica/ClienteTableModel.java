package interfazGrafica;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import logica.Cliente;

/**
 *
 * @author Walter
 */
public class ClienteTableModel extends AbstractTableModel {

    //Atributos
    private List<Cliente> listCliente;
    private String columnas[] = {"   Número", "           DNI", "     Fecha Alta", "                               Dirección", "      Teléfono"};

    //Constructor
    public ClienteTableModel(List<Cliente> listCliente) {
        this.listCliente = listCliente;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public int getRowCount() {
        return listCliente.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return listCliente.get(rowIndex).getNumCliente();
            case 1:
                return listCliente.get(rowIndex).getDni();
            case 2:
                return listCliente.get(rowIndex).getFechaAlta();
            case 3:
                return listCliente.get(rowIndex).getDireccion();
            case 4:
                return listCliente.get(rowIndex).getTelefono();
        }
        return null;
    }

}
