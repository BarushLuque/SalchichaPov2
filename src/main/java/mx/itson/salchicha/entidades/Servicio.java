/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.salchicha.entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mx.itson.salchicha.persistencia.Conexion;

/**
 * Clase Servicio que representa un registro en la tabla "servicio" de la base de datos.
 * Permite realizar operaciones CRUD y administrar información relacionada con servicios, 
 * responsables y actividades asociadas.
 * 
 * @author Barush
 */
public class Servicio {

    // Atributos que representan columnas en la tabla "servicio".
    private int id; // Identificador único del servicio.
    private Date fechaRealizacion; // Fecha y hora de realización del servicio.
    private Responsable responsable; // Responsable asignado al servicio.
    private String descripcionProblema; // Descripción del problema que motivó el servicio.
    private List<Actividad> actividad; // Lista de actividades relacionadas con el servicio.
    private Actividad actividades; // Actividad específica (atributo redundante; puede ser simplificado).
    
    /**
     * Obtiene un servicio específico por su ID.
     * 
     * @param id Identificador único del servicio.
     * @return Un objeto Servicio con los datos correspondientes.
     */
    public static Servicio getById(int id){
        Servicio s = new Servicio();
        try {
            Connection conexion = Conexion.obtener();
            String query = "SELECT id, fecha_realizacion, descripcion_problema FROM servicio WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, id);
            
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                s.setId(rs.getInt(1));
                s.setFechaRealizacion(rs.getDate(2));
                s.setDescripcionProblema(rs.getString(3));
            }
        } catch (Exception ex) {
            System.err.println("Ocurrió un error " + ex.getMessage());
        }
        return s;
    }

    /**
     * Obtiene una lista con todos los servicios registrados en la base de datos.
     * Incluye información del responsable asignado y las actividades asociadas.
     * 
     * @return Una lista de objetos Servicio.
     */
    public static List<Servicio> getAll(){
        List<Servicio> servicios = new ArrayList<>();
        try {
            Connection conexion = Conexion.obtener();
            Statement statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery("SELECT id, fecha_realizacion, id_responsable, descripcion_problema FROM servicio");
            while(rs.next()) {
                Servicio s = new Servicio();
                s.setId(rs.getInt(1));
                s.setFechaRealizacion(rs.getDate(2));
                
                // Obtenemos el responsable asociado al servicio
                Responsable r = Responsable.getById(rs.getInt(3));
                s.setResponsable(r);
                
                s.setDescripcionProblema(rs.getString(4));
                
                // Obtenemos las actividades asociadas al servicio
                List<Actividad> actividades = Actividad.getList(rs.getInt(1));
                s.setActividades(actividades);
                
                servicios.add(s);
            }
        } catch(Exception ex){
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return servicios;
    }

    /**
     * Guarda un nuevo servicio en la base de datos.
     * 
     * @param descripcionProblema Descripción del problema que motivó el servicio.
     * @param idResponsable ID del responsable asignado al servicio.
     * @return true si el registro fue exitoso; false en caso contrario.
     */
    public static boolean save(String descripcionProblema, int idResponsable) {
        boolean resultado = false;
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "INSERT INTO servicio (descripcion_problema, id_responsable, fecha_realizacion) VALUES (?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, descripcionProblema);
            statement.setInt(2, idResponsable);
            
            // Registrar la fecha actual como fecha de realización
            LocalDateTime fechaActual = LocalDateTime.now();
            statement.setObject(3, fechaActual);
            
            statement.execute();
            resultado = statement.getUpdateCount() == 1;
            conexion.close();
        } catch (Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return resultado;
    }

    /**
     * Edita un registro de servicio existente en la base de datos.
     * 
     * @param idServicio ID del servicio a modificar.
     * @param descripcionProblema Nueva descripción del problema.
     * @param idResponsable Nuevo ID del responsable asignado.
     * @return true si la actualización fue exitosa; false en caso contrario.
     */
    public static boolean edit(int idServicio, String descripcionProblema, int idResponsable) {
        boolean resultado = false;
        try {
            Connection conexion = Conexion.obtener();
            String consulta = "UPDATE servicio SET descripcion_problema = ?, id_responsable = ? WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, descripcionProblema);
            statement.setInt(2, idResponsable);
            statement.setInt(3, idServicio);
            
            statement.execute();
            resultado = statement.getUpdateCount() == 1;
            conexion.close();
        } catch (Exception ex) {
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return resultado;
    }

    /**
     * Elimina un registro de servicio de la base de datos.
     * 
     * @param id ID del servicio a eliminar.
     * @return true si la eliminación fue exitosa; false en caso contrario.
     */
    public static boolean delete(int id){
        boolean resultado = false;
        try{
            Connection conexion = Conexion.obtener();
            String consulta = "DELETE FROM servicio WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, id);
            
            statement.execute();
            resultado = statement.getUpdateCount() == 1;
            conexion.close();
        } catch(Exception ex){
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return resultado;
    }

    // Métodos Getters y Setters para los atributos de la clase.

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(Date fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

    public String getDescripcionProblema() {
        return descripcionProblema;
    }

    public void setDescripcionProblema(String descripcionProblema) {
        this.descripcionProblema = descripcionProblema;
    }

    public List<Actividad> getActividad() {
        return actividad;
    }

    public void setActividades(List<Actividad> actividades) {
        this.actividad = actividades;
    }

    public Actividad getActividades() {
        return actividades;
    }

    public void setActividades(Actividad actividades) {
        this.actividades = actividades;
    }

}
