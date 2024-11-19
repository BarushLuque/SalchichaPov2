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
 *
 * @author Barush and Sveen 
 */
public class Servicio {

    /**
     * @return the actividades
     */
    public Actividad getActividades() {
        return actividades;
    }

    /**
     * @param actividades the actividades to set
     */
    public void setActividades(Actividad actividades) {
        this.actividades = actividades;
    }

    public static Servicio getById(int id){
            Servicio s = new Servicio ();
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

    private int id;
    private Date fechaRealizacion;
    private Responsable responsable;
    private String descripcionProblema;
    private List<Actividad> actividad;
    private Actividad actividades;
    
    public static List<Servicio> getAll(){
                List<Servicio> servicios = new ArrayList<>();
        try {
            Connection conexion = Conexion.obtener();
            Statement statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery("SELECT id, fecha_realizacion, id_responsable, descripcion_problema FROM servicio");
            while(rs.next()) {
                Servicio s = new Servicio ();
                s.setId(rs.getInt(1));
                s.setFechaRealizacion(rs.getDate(2));
                
                //Obtenemos tipo responsable
                Responsable r = Responsable.getById(rs.getInt(3));
                s.setResponsable(r);
                
                s.setDescripcionProblema(rs.getString(4));
                
                //Obtenemos una lista de tipo Actividad
                List<Actividad> actividades = Actividad.getList(rs.getInt(1));
                s.setActividades(actividades);
                
                servicios.add(s);
                
            }
            
        } catch(Exception ex){
            System.err.println("Ocurrió un error: " + ex.getMessage());
        } return servicios; 
    } 
    
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the fechaRealizacion
     */
    public Date getFechaRealizacion() {
        return fechaRealizacion;
    }

    /**
     * @param fechaRealizacion the fechaRealizacion to set
     */
    public void setFechaRealizacion(Date fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    /**
     * @return the responsable
     */
    public Responsable getResponsable() {
        return responsable;
    }

    /**
     * @param responsable the responsable to set
     */
    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

    /**
     * @return the descripcionProblema
     */
    public String getDescripcionProblema() {
        return descripcionProblema;
    }

    /**
     * @param descripcionProblema the descripcionProblema to set
     */
    public void setDescripcionProblema(String descripcionProblema) {
        this.descripcionProblema = descripcionProblema;
    }

    /**
     * @return the actividades
     */
    public List<Actividad> getActividad() {
        return actividad;
    }

    /**
     * @param actividades the actividades to set
     */
    public void setActividades(List<Actividad> actividades) {
        this.actividad = actividades;
    }
    
    
public static boolean save(String descripcionProblema, int idResponsable) {
    boolean resultado = false;
    try {
        // Establecer conexión con la base de datos
        Connection conexion = Conexion.obtener();
        
        // Consulta SQL para insertar el servicio
        String consulta = "INSERT INTO servicio (descripcion_problema, id_responsable, fecha_realizacion) VALUES (?, ?, ?)";
        PreparedStatement statement = conexion.prepareStatement(consulta);
        
        // Asignar valores a los parámetros de la consulta
        statement.setString(1, descripcionProblema);
        statement.setInt(2, idResponsable); // Cambiado a setInt porque idResponsable es un entero
        
        // Hora actual como fecha de realización
        LocalDateTime fechaActual = LocalDateTime.now();
        statement.setObject(3, fechaActual);
        
        // Ejecutar la consulta
        statement.execute();
        resultado = statement.getUpdateCount() == 1;
        
        // Cerrar la conexión
        conexion.close();
    } catch (Exception ex) {
        // Manejo de errores
        System.err.println("Ocurrió un error: " + ex.getMessage());
    }
    return resultado;
}

    
    
    
    
    public static boolean edit(int idServicio, String descripcionProblema, int idResponsable) {
    boolean resultado = false;
    try {
        // Establecer conexión con la base de datos
        Connection conexion = Conexion.obtener();

        // Consulta SQL para actualizar un registro en la tabla servicio
        String consulta = "UPDATE servicio SET descripcion_problema = ?, id_responsable = ? WHERE id = ?";
        PreparedStatement statement = conexion.prepareStatement(consulta);

        // Asignar valores a los parámetros de la consulta
        statement.setString(1, descripcionProblema);
        statement.setInt(2, idResponsable); // Asignar el ID del responsable
        statement.setInt(3, idServicio); // Asignar el ID del servicio a actualizar

        // Ejecutar la consulta
        statement.execute();
        resultado = statement.getUpdateCount() == 1;

        // Cerrar la conexión
        conexion.close();
    } catch (Exception ex) {
        // Manejo de errores
        System.err.println("Ocurrió un error: " + ex.getMessage());
    }
    return resultado;
}

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
        }catch(Exception ex){
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return resultado;
    }

    
}