/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.salchicha.entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.itson.salchicha.persistencia.Conexion;

/**
 *
 * @author Barush and Sveen 
 */
/**
 * La clase Actividad representa una actividad que se puede asociar a un servicio en el sistema.
 * Proporciona métodos para obtener actividades de la base de datos,
 * ya sea todas las actividades o solo aquellas asociadas a un servicio específico.
 */
public class Actividad {

    // Atributos de la clase Actividad
    private int id; // Identificador único de la actividad en la base de datos
    private int orden; // Orden secuencial de la actividad dentro de un servicio
    private String descripcion; // Descripción detallada de la actividad

    /**
     * Obtiene una lista de actividades asociadas a un servicio específico.
     * Realiza una consulta en la base de datos y filtra las actividades que coinciden con el id del servicio.
     * 
     * @param idServicio El identificador del servicio para el cual se buscan las actividades.
     * @return Una lista de objetos Actividad asociados al servicio especificado. Si ocurre un error, devuelve una lista vacía.
     */
    public static List<Actividad> getList(int idServicio) {
        List<Actividad> actividades = new ArrayList<>(); // Lista para almacenar las actividades obtenidas
        try {
            // Establece conexión con la base de datos
            Connection conexion = Conexion.obtener();

            // Consulta SQL que obtiene las actividades filtradas por id de servicio
            String consulta = "SELECT * FROM actividad WHERE id_servicio = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);

            // Asigna el idServicio al parámetro de la consulta
            statement.setInt(1, idServicio);

            // Ejecuta la consulta y obtiene los resultados
            ResultSet rs = statement.executeQuery();

            // Procesa cada resultado obtenido de la consulta
            while (rs.next()) {
                // Crea una nueva instancia de Actividad y asigna los valores obtenidos de la base de datos
                Actividad a = new Actividad();
                a.setId(rs.getInt(1)); // Establece el ID de la actividad
                a.setOrden(rs.getInt(2)); // Establece el orden de la actividad
                a.setDescripcion(rs.getString(3)); // Establece la descripción de la actividad
                actividades.add(a); // Agrega la actividad a la lista de actividades
            }
        } catch (Exception ex) {
            // Captura cualquier excepción y muestra un mensaje de error en la consola
            System.err.println("Ocurrió un error al obtener la lista de actividades: " + ex.getMessage());
        }
        return actividades; // Retorna la lista de actividades (vacía si ocurrió algún error)
    }

    /**
     * Obtiene todas las actividades registradas en la base de datos sin importar el servicio al que pertenezcan.
     * 
     * @return Una lista con todas las actividades en la base de datos. Si ocurre un error, devuelve una lista vacía.
     */
    public static List<Actividad> getAll() {
        List<Actividad> actividad = new ArrayList<>(); // Lista para almacenar todas las actividades
        try {
            // Establece conexión con la base de datos
            Connection conexion = Conexion.obtener();

            // Consulta SQL que obtiene todas las actividades sin filtrar por servicio
            Statement statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery("SELECT id, orden, descripcion FROM actividad");

            // Procesa cada resultado obtenido de la consulta
            while (rs.next()) {
                // Crea una nueva instancia de Actividad y asigna los valores obtenidos de la base de datos
                Actividad a = new Actividad();
                a.setId(rs.getInt(1)); // Establece el ID de la actividad
                a.setOrden(rs.getInt(2)); // Establece el orden de la actividad
                a.setDescripcion(rs.getString(3)); // Establece la descripción de la actividad
                
                // Opcional: obtiene una lista de actividades específicas para el ID actual (puede ser redundante)
                List<Actividad> actividades = Actividad.getList(rs.getInt(1));
                
                actividad.add(a); // Agrega la actividad a la lista de todas las actividades
            }
        } catch (Exception ex) {
            // Captura cualquier excepción y muestra un mensaje de error en la consola
            System.err.println("Ocurrió un error al obtener todas las actividades: " + ex.getMessage());
        }
        return actividad; // Retorna la lista de todas las actividades (vacía si ocurrió algún error)
    }

    // Métodos de acceso (getters y setters) para los atributos de la clase

    /**
     * Obtiene el ID de la actividad.
     * 
     * @return El identificador único de la actividad.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID de la actividad.
     * 
     * @param id El identificador único a asignar a la actividad.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el orden de la actividad dentro del servicio.
     * 
     * @return El orden de la actividad.
     */
    public int getOrden() {
        return orden;
    }

    /**
     * Establece el orden de la actividad.
     * 
     * @param orden El valor del orden a asignar a la actividad.
     */
    public void setOrden(int orden) {
        this.orden = orden;
    }

    /**
     * Obtiene la descripción de la actividad.
     * 
     * @return La descripción de la actividad.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción de la actividad.
     * 
     * @param descripcion La descripción a asignar a la actividad.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
