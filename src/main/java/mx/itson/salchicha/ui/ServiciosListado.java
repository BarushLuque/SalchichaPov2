/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mx.itson.salchicha.ui;

import java.awt.BorderLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import mx.itson.salchicha.entidades.Actividad;
import mx.itson.salchicha.entidades.Servicio;

/**
 *
 * @author Barush and Sveen 
 */
public class ServiciosListado extends javax.swing.JFrame {
    /**
     * Creates new form ActividadesListado
     */
    public ServiciosListado() {
        initComponents();        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEliminar1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblServicios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnActividades = new javax.swing.JButton();

        btnEliminar1.setText("Eliminar");
        btnEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tblServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "Responsable", "Descripcion", "Fecha", "Numero Actividades"
            }
        ));
        jScrollPane1.setViewportView(tblServicios);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel1.setText("Servicios Listado");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnActividades.setText("Actividades");
        btnActividades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActividadesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnActividades)
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnEliminar)
                    .addComponent(btnEditar)
                    .addComponent(btnActividades))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        ServicioForm form = new ServicioForm(this, true, 0);
        form.setVisible(true);
        cargarTableServicios();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        cargarTableServicios();
        tblServicios.removeColumn(tblServicios.getColumnModel().getColumn(0));
    }//GEN-LAST:event_formWindowOpened

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
    
        editar Editar = new editar();
        Editar.setVisible(true);
  
    /* Obtiene el índice de la fila seleccionada en la tabla de servicios
    int selectedRow = tblServicios.getSelectedRow();
    
    // Verifica que se haya seleccionado una fila
    if (selectedRow != -1) {
        // Obtiene el ID del servicio seleccionado desde el modelo de la tabla
        int servicioId = (int) tblServicios.getValueAt(selectedRow, 0); // Asegúrate de que el ID está en la columna 0
        
        // Carga el servicio específico desde la base de datos
        Servicio servicio = Servicio.getById(servicioId); // Llama al método getById para obtener el servicio
        
        // Abre el formulario de edición, pasando el servicio a editar
        ServicioForm form = new ServicioForm(this, true, servicio); // Asegúrate de que el constructor de ServicioForm permite recibir el servicio para edición
        form.setVisible(true);
        
        // Recarga la tabla de servicios después de editar para reflejar los cambios
        cargarTableServicios();
    } else {
        // Muestra un mensaje si no se ha seleccionado ningún servicio
        JOptionPane.showMessageDialog(this, "Por favor, selecciona un servicio para editar.");
    }
        */




    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        // AQUI ME QUEDE
        // Verificar si hay un registro seleccionado
    int renglon = tblServicios.getSelectedRow();
    if (renglon == -1) {
        JOptionPane.showMessageDialog(this,
                "Seleccione un registro para eliminar.",
                "Advertencia",
                JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Obtener el ID del servicio seleccionado
    try {
        int idServicio = Integer.parseInt(tblServicios.getModel().getValueAt(renglon, 0).toString());

        // Confirmación del usuario
        int confirmacion = JOptionPane.showConfirmDialog(this,
                "¿Está seguro que desea eliminar el registro?",
                "Eliminar",
                JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            // Intentar eliminar el servicio
            if (Servicio.delete(idServicio)) {
                JOptionPane.showMessageDialog(this,
                        "El servicio se eliminó con éxito.",
                        "Servicio eliminado",
                        JOptionPane.INFORMATION_MESSAGE);
                cargarTableServicios(); // Actualizar tabla
            } else {
                JOptionPane.showMessageDialog(this,
                        "Ocurrió un error al eliminar el servicio.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this,
                "Ocurrió un error al obtener el ID del servicio.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminar1ActionPerformed

    private void btnActividadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActividadesActionPerformed

       ActividadFrame frame = new ActividadFrame(Actividad.getAll());
            frame.setVisible(true);
    //ActividadFrame Actividad = new ActividadFrame();
       // Actividad.setVisible(true);       // TODO add your handling code here:
    }//GEN-LAST:event_btnActividadesActionPerformed
   
    public static String convertirDate (Date date){
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
    String fecha = dateFormat.format(date);   
    
    return fecha;
    }
    
    private void cargarTableServicios(){
        List<Servicio> servicios = Servicio.getAll();
        DefaultTableModel modeloTabla = (DefaultTableModel)tblServicios.getModel();
        modeloTabla.setRowCount(0);
        for(Servicio s : servicios) {
            modeloTabla.addRow(new Object[] { 
                s.getId(),
                s.getResponsable().getNombre(),
                s.getDescripcionProblema(),
                convertirDate(s.getFechaRealizacion()),
                s.getActividad().size()
            });
        }
    }
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
            java.util.logging.Logger.getLogger(ServiciosListado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServiciosListado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServiciosListado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServiciosListado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServiciosListado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActividades;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblServicios;
    // End of variables declaration//GEN-END:variables
}
