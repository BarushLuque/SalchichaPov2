/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.salchicha.ui;

/**
 *
 * @author user
 */


import mx.itson.salchicha.entidades.Actividad;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una ventana para mostrar un listado de actividades.
 * 
 * /**
 *
 * @author Barush and Sveen 
 */
 
public class ActividadFrame extends JFrame {

    /**
     * Constructor de la clase ActividadFrame.
     * Este constructor recibe una lista de actividades y muestra sus datos en una tabla.
     * 
     * @param actividades Lista de objetos Actividad que se mostrará en la tabla.
     */
    public ActividadFrame(List<Actividad> actividades) {
        // Configuración básica de la ventana
        setTitle("Listado de Actividades"); // Título de la ventana
        setSize(600, 400); // Tamaño inicial de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Acción al cerrar la ventana
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        // Definir los nombres de las columnas de la tabla
        String[] columnas = {"ID", "Orden", "Descripción"};

        // Crear el modelo de la tabla con las columnas definidas
        DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);

        // Llenar el modelo de la tabla con los datos de la lista de actividades
        for (Actividad actividad : actividades) {
            Object[] fila = {
                actividad.getId(),        // Obtiene el ID de la actividad
                actividad.getOrden(),     // Obtiene el orden de la actividad
                actividad.getDescripcion() // Obtiene la descripción de la actividad
            };
            modeloTabla.addRow(fila); // Agrega la fila al modelo
        }

        // Crear la tabla usando el modelo de datos
        JTable tabla = new JTable(modeloTabla);

        // Agregar barras de desplazamiento
        JScrollPane scrollPane = new JScrollPane(tabla);
        add(scrollPane, BorderLayout.CENTER); // Añadir el JScrollPane al JFrame
    }

    /**
     * Método principal para ejecutar el frame de actividades.
     */
    public static void main(String[] args) {
        // Ejemplo de obtención de actividades
       

        // Ejecutar la interfaz en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            ActividadFrame frame = new ActividadFrame(Actividad.getAll());
            frame.setVisible(true);
        });
    }
   }
         

   