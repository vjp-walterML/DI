package com.mycompany.tareafinalinmobiliaria.interfazGrafica;

import com.mycompany.tareafinalinmobiliaria.logica.Constantes;
import com.mycompany.tareafinalinmobiliaria.logica.*;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author Walter
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    //Variables globales
    private TableRowSorter<InmuebleTableModel> sorter;

    //Constructor
    public VentanaPrincipal() {
        initComponents();
        establecerFondo();//Establezco el fondo
        crearTablaInmuebles();//Creo tabla inmuebles
        aniadirComponentes();//Añado los componentes al panelPrincipal
    }

    //Establece un JPanel de fondo con una imagen
    public void establecerFondo() {
        panelPrincipal = new PanelFondo("src/main/java/com/mycompany/tareafinalinmobiliaria/interfazGrafica/IMG/3.png");
        panelPrincipal.setLayout(null);//Layout absoluto
        // Establecer el JPanel como el contenido del Jframe
        this.setContentPane(panelPrincipal);
    }

    //En este método se añaden los componentes al JPanel para que sean visibles
    public void aniadirComponentes() {
        panelPrincipal.add(jScrollPane1);
        panelPrincipal.add(jLabelListadoInmuebles);
    }

    //Aplica el tableModel, shorter y estilos al JTable
    private void crearTablaInmuebles() {
        //Instancio un ClienteTableModel 
        InmuebleTableModel itm = new InmuebleTableModel();
        this.jTableInmuebles.setModel(itm);//Añado el InmuebleTableModel al JTableInmuebles
        //Para poder ordenar creo el tableRowShorter
        sorter = new TableRowSorter<>(itm);
        //Añado el tablerowsorter a mi Jtable
        this.jTableInmuebles.setRowSorter(sorter);
        //Establezco el color de fondo de la tabla
        jScrollPane1.getViewport().setBackground(new Color(255, 255, 255));
        // Obteniendo el TableHeader del JTable para modificar los estilos
        JTableHeader header = jTableInmuebles.getTableHeader();
        header.setFont(new Font("Microsoft PhasPa", Font.BOLD, 15));
        header.setForeground(new Color(38, 60, 61));
        // Obteniendo el ColumModel del JTable para modificar las dimensiones de las celdas
        TableColumnModel columnModel = jTableInmuebles.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(80);
        columnModel.getColumn(1).setPreferredWidth(1000);
        columnModel.getColumn(2).setPreferredWidth(400);
        columnModel.getColumn(3).setPreferredWidth(300);
        columnModel.getColumn(4).setPreferredWidth(400);
        //Centrar celdas
        aplicarRenderizadorCentrado();
    }

    //Aplica el renderizador creado para centrar el texto de las celdas
    public void aplicarRenderizadorCentrado() {
        CenterTableCellRenderer centerRenderer = new CenterTableCellRenderer();
        for (int i = 0; i < jTableInmuebles.getColumnCount(); i++) {
            jTableInmuebles.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    //ACCIONES=====================================
    public void generarInforme(int idInmueble) {
        try {
            System.out.println("Empezando");
            File file = new File(getClass().getClassLoader().getResource("inmobiliaria.jrxml").getFile());
            System.out.println(file.getCanonicalPath());
            JasperReport archivo = JasperCompileManager.compileReport(file.getAbsolutePath());
            Connection cnx;
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection("jdbc:mysql://localhost:" + Constantes.PUERTO + "/" + Constantes.BD + "?user=" + Constantes.USUARIO + "&password=");
            //Parámetros
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("idInmueble", idInmueble);
            JasperPrint prin = JasperFillManager.fillReport(archivo, parametros, cnx);
            //Creo carpeta
            File carpeta = new File("INFORMES");
            carpeta.mkdir();
            //Genero el nombre del pdf
            String nombrePdf = "INFORMES/Inmueble_" + idInmueble + ".pdf";
            //Genero el pdf
            JasperExportManager.exportReportToPdfFile(prin, nombrePdf);
            //Liberamos recursos
            cnx.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Botón Eliminar
//    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {                                                
//        if (jTableClientes.getSelectedRow() != -1) {//Compruebo si hay alguna fila seleccionada
//            if (JOptionPane.showConfirmDialog(this, "¿Quiere eliminar este registro?", "Eliminar", JOptionPane.YES_NO_OPTION) == 0) {
//                int i = this.jTableClientes.getSelectedRow();// Obtengo la fila seleccionada
//                i = this.jTableClientes.convertRowIndexToModel(i);//Convierto la fila seleccionada al índice correcto (sirve cuando la información está filtrada)
//                //Elimino el índice de la tabla
//                listaClientes.remove(i);
//                //Actualizo datos
//                actualizarDatos();
//            }
//        }
//    }       
    //Código generado
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableInmuebles = new javax.swing.JTable();
        jLabelListadoInmuebles = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableInmuebles.setFont(new java.awt.Font("Microsoft PhagsPa", 0, 14)); // NOI18N
        jTableInmuebles.setForeground(new java.awt.Color(38, 60, 61));
        jTableInmuebles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableInmuebles);

        jLabelListadoInmuebles.setFont(new java.awt.Font("Microsoft PhagsPa", 1, 30)); // NOI18N
        jLabelListadoInmuebles.setForeground(new java.awt.Color(38, 60, 61));
        jLabelListadoInmuebles.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelListadoInmuebles.setText("LISTADO DE INMUEBLES");

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelListadoInmuebles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabelListadoInmuebles, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private javax.swing.JLabel jLabelListadoInmuebles;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableInmuebles;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}
