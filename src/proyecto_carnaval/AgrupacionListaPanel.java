/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_carnaval;

import java.util.ArrayList;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author jesus
 */
public class AgrupacionListaPanel extends javax.swing.JPanel {

    private DefaultTableModel modeloTabla;
    GestionAgrupaciones gestion = new GestionAgrupaciones();

    void CargarDatosJTable() {
        ArrayList<DatosAgrupaciones> listaAgrupaciones = new ArrayList();

        modeloTabla = new DefaultTableModel() {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        jTable1.setModel(modeloTabla);


        String[] cabecera = {"Id", "Nombre", "Modalidad", "Componentes", "Autor de la Letra", "Autor de la Música", "Director", "Localidad", "Imagen de la Agrupacion"};
        modeloTabla.setColumnIdentifiers(cabecera);

        listaAgrupaciones = gestion.list();

        for (DatosAgrupaciones agrupacion : listaAgrupaciones) {

            String[] datosFilaAgrupacion = {
                String.valueOf(agrupacion.getId()),
                agrupacion.getNombre(),
                agrupacion.getModalidad(),
                String.valueOf(agrupacion.getNumComponentes()),
                agrupacion.getAutorLetra(),
                agrupacion.getAutorMusica(),
                agrupacion.getDirector(),
                agrupacion.getLocalidad(),
                String.valueOf(agrupacion.getImagenAgrupacion())
            };
            modeloTabla.addRow(datosFilaAgrupacion);
        }


        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        TableColumn tc = jTable1.getColumn("Id");

        jTable1.removeColumn(tc);



    }

    public AgrupacionListaPanel() {
        initComponents();
         Conexion.conectar("localhost","root","");
        this.CargarDatosJTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 958, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
