/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mx.itson.salchicha.ui;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mx.itson.salchicha.entidades.Actividad;

/**
 *
 * @author Barush
 */
public class ActividadListado extends javax.swing.JFrame {

    private int id;
     private int idServicio;
    
    /**
     * Creates new form ActividadListado
     */
    public ActividadListado() {
        initComponents();
        
        
    }
    
   private void cargarTable(){
        List<Actividad> actividades = Actividad.getAll();
        DefaultTableModel modeloTabla = (DefaultTableModel)tableActividad.getModel();
        modeloTabla.setRowCount(0);
        for(Actividad a : actividades) {
            modeloTabla.addRow(new Object[] {
                    a.getId(),
                    a.getOrden(),
                    a.getDescripcion(),
                    a.getServicio().getId()
            });
            }
        }
            
 
    /**
     * Creates new form ActividadListado
     */
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableActividad = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnAgg = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tableActividad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "ORDEN", "DESCRIPCION", "ID SERVICIO"
            }
        ));
        jScrollPane1.setViewportView(tableActividad);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("LISTA DE ACTIVIDADES");

        btnAgg.setText("AGREGAR");
        btnAgg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAggActionPerformed(evt);
            }
        });

        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(211, 211, 211)
                            .addComponent(btnAgg)
                            .addGap(18, 18, 18)
                            .addComponent(btnEditar)
                            .addGap(18, 18, 18)
                            .addComponent(btnEliminar))))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgg)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAggActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAggActionPerformed
        // TODO add your handling code here:
        int idActividad = 0;
        ActividadForm form = new ActividadForm(this, true, idActividad, idServicio);
        form.setVisible(true);
        
        cargarTable();
    }//GEN-LAST:event_btnAggActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        int renglon = tableActividad.getSelectedRow();
        int idActividad = Integer.parseInt(tableActividad.getModel().getValueAt(renglon, 0).toString());
        
        ActividadForm form = new ActividadForm(this, true, idActividad, idServicio);
         form.setVisible(true);
        
        cargarTable();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int renglon = tableActividad.getSelectedRow();
        int idResponsable = Integer.parseInt(tableActividad.getModel().getValueAt(renglon, 0).toString());
        
        if (JOptionPane.showConfirmDialog(this, "Está seguro que quiere eliminar el registro?", "Eliminar registro", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
        
        if(Actividad.delete(idResponsable)){
            JOptionPane.showMessageDialog(this, "El registro se eliminó con éxito", "Registro eliminado", JOptionPane.INFORMATION_MESSAGE);
            cargarTable();
        } else {
            JOptionPane.showMessageDialog(this, "Ocurrió un error", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        } 
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        cargarTable();
        tableActividad.removeColumn(tableActividad.getColumnModel().getColumn(0));
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ActividadListado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActividadListado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActividadListado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActividadListado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ActividadListado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgg;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableActividad;
    // End of variables declaration//GEN-END:variables
}