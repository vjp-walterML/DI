package ejercicioexamen1;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Walter
 */
public class CitaTableModel extends AbstractTableModel {

    //Atributos
    private List<Cita> lcitas = new ArrayList<>();
    private String[] nombreColumnas = {"Id", "Matricula", "Coche", "Fecha"};

    //Constructor
    public CitaTableModel(List<Cita> lcitas) {
        this.lcitas = lcitas;
    }

    public void aniadirCita(Cita cita) {
        lcitas.add(cita);
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return lcitas.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }

    @Override
    public String getColumnName(int column) {
        return nombreColumnas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return lcitas.get(rowIndex).getIdCita();
            case 1:
                return lcitas.get(rowIndex).getMatricula();
            case 2:
                return lcitas.get(rowIndex).getCoche();
            case 3:
                return lcitas.get(rowIndex).getFecha();
            default:
                return null;
        }
    }

}
