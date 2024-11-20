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
 * La clase Actividad representa una actividad que se puede asociar a un servicio en el sistema.
 * Proporciona métodos para obtener, eliminar, editar, guardar y consultar actividades 
 * desde la base de datos.
 * 
 * Contiene atributos como ID, orden, descripción y el servicio asociado.
 * También incluye métodos de acceso (getters y setters) para cada atributo.
 * 
 * @author Barush
 */
public class Actividad {

    // Atributos de la clase Actividad
    private int id; // Identificador único de la actividad en la base de datos
    private int orden; // Orden secuencial de la actividad dentro de un servicio
    private String descripcion; // Descripción detallada de la actividad
    private Servicio servicio; // Servicio asociado a la actividad

    /**
     * Obtiene el servicio asociado a la actividad.
     * 
     * @return El objeto Servicio asociado a la actividad.
     */
    public Servicio getServicio() {
        return servicio;
    }

    /**
     * Asocia un servicio a la actividad.
     * 
     * @param servicio El objeto Servicio que se desea asociar a la actividad.
     */
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    /**
     * Obtiene una lista de actividades asociadas a un servicio específico.
     * Realiza una consulta en la base de datos y filtra las actividades que coinciden con el id del servicio.
     * 
     * @param idServicio El identificador del servicio para el cual se buscan las actividades.
     * @return Una lista de objetos Actividad asociados al servicio especificado. Si ocurre un error, devuelve una lista vacía.
     */
    public static List<Actividad> getList(int idServicio) {
        List<Actividad> actividades = new ArrayList<>();
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "SELECT id, orden, descripcion FROM actividad WHERE id_servicio = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, idServicio);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Actividad a = new Actividad();
                a.setId(rs.getInt(1));
                a.setOrden(rs.getInt(2));
                a.setDescripcion(rs.getString(3));
                actividades.add(a);
            }
        } catch (Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return actividades;
    }

    /**
     * Elimina una actividad de la base de datos según su ID.
     * 
     * @param id Identificador único de la actividad que se desea eliminar.
     * @return `true` si la operación fue exitosa; `false` en caso contrario.
     */
    public static boolean delete(int id) {
        boolean resultado = false;
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "DELETE FROM actividad WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, id);
            statement.execute();
            resultado = statement.getUpdateCount() == 1;
            conexion.close();
        } catch (Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return resultado;
    }

    /**
     * Edita los datos de una actividad en la base de datos.
     * 
     * @param orden Nuevo orden de la actividad.
     * @param descripcion Nueva descripción de la actividad.
     * @param id Identificador único de la actividad que se desea editar.
     * @return `true` si la operación fue exitosa; `false` en caso contrario.
     */
    public static boolean edit(int orden, String descripcion, int id) {
        boolean resultado = false;
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "UPDATE actividad SET orden = ?, descripcion = ? WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, orden);
            statement.setString(2, descripcion);
            statement.setInt(3, id);
            statement.execute();
            resultado = statement.getUpdateCount() == 1;
            conexion.close();
        } catch (Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return resultado;
    }

    /**
     * Guarda una nueva actividad en la base de datos.
     * 
     * @param orden Orden de la actividad dentro del servicio.
     * @param descripcion Descripción de la actividad.
     * @return `true` si la operación fue exitosa; `false` en caso contrario.
     */
    public static boolean save(int orden, String descripcion) {
        boolean resultado = false;
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "INSERT INTO actividad (orden, descripcion) VALUES(?, ?)";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, orden);
            statement.setString(2, descripcion);
            statement.execute();
            resultado = statement.getUpdateCount() == 1;
            conexion.close();
        } catch (Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return resultado;
    }

    /**
     * Obtiene una actividad específica por su ID.
     * 
     * @param id Identificador único de la actividad.
     * @return Un objeto Actividad si se encuentra; de lo contrario, una actividad vacía.
     */
    public static Actividad getById(int id) {
        Actividad a = new Actividad();
        try {
            Connection conexion = Conexion.obtener();
            String query = "SELECT id, orden, descripcion FROM actividad WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                a.setId(rs.getInt(1));
                a.setOrden(rs.getInt(2));
                a.setDescripcion(rs.getString(3));
            }
        } catch (Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return a;
    }

    /**
     * Obtiene todas las actividades almacenadas en la base de datos.
     * 
     * @return Una lista con todas las actividades.
     */
    public static List<Actividad> getAll() {
        List<Actividad> actividades = new ArrayList<>();
        try {
            Connection conexion = Conexion.obtener();
            Statement statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery("SELECT id, orden, descripcion, id_servicio FROM actividad");
            while (rs.next()) {
                Actividad a = new Actividad();
                a.setId(rs.getInt(1));
                a.setOrden(rs.getInt(2));
                a.setDescripcion(rs.getString(3));
                Servicio s = Servicio.getById(rs.getInt(4));
                a.setServicio(s);
                actividades.add(a);
            }
        } catch (Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return actividades;
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
