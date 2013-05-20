/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_carnaval;

import java.awt.Frame;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author jesus
 */
public class AgrupacionListaPanel extends javax.swing.JPanel {
    
    ArrayList<DatosAgrupaciones> listaAgrupaciones = new ArrayList();
    private DefaultTableModel modeloTabla;
    GestionAgrupaciones gestion = new GestionAgrupaciones();
    
    void CargarDatosJTable() {
        
        
        
        modeloTabla = new DefaultTableModel() {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        };
        jTable1.setModel(modeloTabla);
        listaAgrupaciones = gestion.list();
        
        String[] cabecera = {"Id", "Nombre", "Modalidad",};
        modeloTabla.setColumnIdentifiers(cabecera);
        
        
        
        for (DatosAgrupaciones agrupacion : listaAgrupaciones) {
            
            String[] datosFilaAgrupacion = {
                String.valueOf(agrupacion.getId()),
                agrupacion.getNombre(),
                String.valueOf(agrupacion.dameModalidad(agrupacion.getModalidad())),};
            modeloTabla.addRow(datosFilaAgrupacion);
        }
        
        
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        TableColumn tc = jTable1.getColumn("Id");
        
        jTable1.removeColumn(tc);
        
        this.mostrarDatosAgrupacion();
        
    }
    
    void mostrarDatosAgrupacion() {
        
        int numFilaSelec = jTable1.getSelectedRow();
        
        if (numFilaSelec != -1) {
            
            
            DatosAgrupaciones agrupacion = GestionAgrupaciones.leerAgrupacion(
                    Integer.valueOf((String) modeloTabla.getValueAt(numFilaSelec, 0)));
            
            jLabelNombre.setText(agrupacion.getNombre());
            jLabelModalidad.setText(agrupacion.dameModalidad(agrupacion.getModalidad()));
            jLabelNumero.setText(String.valueOf(agrupacion.getNumComponentes()));
            jLabelLetra.setText(agrupacion.getAutorLetra());
            jLabelMusica.setText(agrupacion.getAutorMusica());
            jLabelDirector.setText(agrupacion.getDirector());
            jLabelLocalidad.setText(agrupacion.getLocalidad());
        } else {
            jLabelNombre.setText("");
            jLabelModalidad.setText("");
            jLabelNumero.setText("");
            jLabelLetra.setText("");
            jLabelMusica.setText("");
            jLabelDirector.setText("");
            jLabelLocalidad.setText("");
        }
        
    }
    
    public AgrupacionListaPanel() {
        initComponents();
        Conexion.conectar("localhost", "root", "");
        this.CargarDatosJTable();
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(30);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(210);
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelModalidad = new javax.swing.JLabel();
        jLabelNumero = new javax.swing.JLabel();
        jLabelLetra = new javax.swing.JLabel();
        jLabelMusica = new javax.swing.JLabel();
        jLabelDirector = new javax.swing.JLabel();
        jLabelLocalidad = new javax.swing.JLabel();
        editar = new javax.swing.JButton();
        insertar = new javax.swing.JButton();
        suprimir = new javax.swing.JButton();

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Agrupación"));

        jLabel1.setText("Nombre");

        jLabel2.setText("Modalidad");

        jLabel3.setText("Nª componentes");

        jLabel4.setText("Autor de la letra");

        jLabel5.setText("Autor de la música");

        jLabel6.setText("Director");

        jLabel7.setText("Localidad");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDirector, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMusica, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelLetra, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelModalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabelModalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelLetra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelMusica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelDirector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabelLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(155, Short.MAX_VALUE))
        );

        editar.setText("Editar");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });

        insertar.setText("Insertar");
        insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertarActionPerformed(evt);
            }
        });

        suprimir.setText("Suprimir");
        suprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(editar)
                        .addGap(35, 35, 35)
                        .addComponent(insertar)
                        .addGap(40, 40, 40)
                        .addComponent(suprimir)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editar)
                            .addComponent(insertar)
                            .addComponent(suprimir)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        this.mostrarDatosAgrupacion();
    }//GEN-LAST:event_jTable1MouseClicked
    
    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        this.mostrarDatosAgrupacion();
    }//GEN-LAST:event_jTable1KeyReleased
    
    private void suprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suprimirActionPerformed
        if (jTable1.getSelectedRow() != -1) {
            listaAgrupaciones = gestion.list();
            int index = jTable1.getSelectedRow();
            DatosAgrupaciones agrupacion = listaAgrupaciones.get(index);
            int numeroJoption = JOptionPane.showConfirmDialog(jTable1, "Estás seguro que deseas eliminar a " + agrupacion.getNombre(), "Confirmacion", JOptionPane.OK_CANCEL_OPTION);
            if (numeroJoption == JOptionPane.OK_OPTION) {
                gestion.delete(agrupacion);
                this.CargarDatosJTable();
            }
        }
    }//GEN-LAST:event_suprimirActionPerformed
    
    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        int index = jTable1.getSelectedRow();
        if (index != -1) {
            
            DatosAgrupaciones agrupacion = listaAgrupaciones.get(index);
            VentanaDetalle ventana = new VentanaDetalle(Frame.getFrames()[0], true);
            ventana.setAgrupacion(agrupacion);
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);
            DatosAgrupaciones agrupacionNueva = ventana.getAgrupacion();
            if (ventana.aceptado()) {
                gestion.update(agrupacionNueva);
                this.CargarDatosJTable();
            }
            
        }
        
        
    }//GEN-LAST:event_editarActionPerformed
    
    private void insertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertarActionPerformed
        GestionAgrupaciones gestion = new GestionAgrupaciones();
        VentanaDetalle ventana = new VentanaDetalle(Frame.getFrames()[0], true);
        DatosAgrupaciones agrupacion = new DatosAgrupaciones();
        ventana.setAgrupacion(agrupacion);
        ventana.setVisible(true);
        if (ventana.aceptado()) {
            gestion.Insert(agrupacion);
            CargarDatosJTable();
        }
    }//GEN-LAST:event_insertarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editar;
    private javax.swing.JButton insertar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelDirector;
    private javax.swing.JLabel jLabelLetra;
    private javax.swing.JLabel jLabelLocalidad;
    private javax.swing.JLabel jLabelModalidad;
    private javax.swing.JLabel jLabelMusica;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton suprimir;
    // End of variables declaration//GEN-END:variables
}
