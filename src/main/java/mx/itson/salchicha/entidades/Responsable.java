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
 * Clase Responsable que representa un registro de la tabla "responsable" en la base de datos.
 * Contiene métodos para realizar operaciones CRUD en la tabla.
 * 
 * @author Barush and Sveen
 */
public class Responsable {

    // Atributos que representan las columnas en la tabla "responsable".
    private int id;       // Identificador único del responsable
    private String nombre; // Nombre del responsable
    private String puesto; // Puesto del responsable
    
    /**
     * Obtiene una lista de todos los registros de la tabla "responsable".
     * 
     * @return Una lista de objetos de tipo Responsable.
     */
    public static List<Responsable> getAll(){
        List<Responsable> responsables = new ArrayList<>();
        try {
            Connection conexion = Conexion.obtener();
            Statement statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery("SELECT id, nombre, puesto FROM responsable");
            while(rs.next()){
                Responsable r = new Responsable();
                r.setId(rs.getInt(1));
                r.setNombre(rs.getString(2));
                r.setPuesto(rs.getString(3));
                responsables.add(r);
            }
        } catch(Exception ex){
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return responsables;
    }
    
    /**
     * Obtiene un registro de la tabla "responsable" por su ID.
     * 
     * @param id Identificador único del responsable.
     * @return Un objeto de tipo Responsable con los datos del registro.
     */
    public static Responsable getById(int id){
        Responsable r = new Responsable();
        try {
            Connection conexion = Conexion.obtener();
            String query = "SELECT id, nombre, puesto FROM responsable WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, id);
            
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                r.setId(rs.getInt(1));
                r.setNombre(rs.getString(2));
                r.setPuesto(rs.getString(3));
            }
        } catch(Exception ex){
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return r;
    }
    
    /**
     * Inserta un nuevo registro en la tabla "responsable".
     * 
     * @param nombre Nombre del responsable.
     * @param puesto Puesto del responsable.
     * @return true si la inserción fue exitosa; false en caso contrario.
     */
    public static boolean save(String nombre, String puesto){
        boolean resultado = false;
        try{
            Connection conexion = Conexion.obtener();
            String consulta = "INSERT INTO responsable (nombre, puesto) VALUES (?, ?)";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, nombre);
            statement.setString(2, puesto);
            
            statement.execute();
            resultado = statement.getUpdateCount() == 1;
            conexion.close();
        }catch(Exception ex){
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return resultado;
    }
    
    /**
     * Actualiza un registro existente en la tabla "responsable".
     * 
     * @param id ID del registro a actualizar.
     * @param nombre Nuevo valor para el nombre.
     * @param puesto Nuevo valor para el puesto.
     * @return true si la actualización fue exitosa; false en caso contrario.
     */
    public static boolean edit(int id, String nombre, String puesto){
        boolean resultado = false;
        try{
            Connection conexion = Conexion.obtener();
            String consulta = "UPDATE responsable SET nombre = ?, puesto = ? WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, nombre);
            statement.setString(2, puesto);
            statement.setInt(3, id);
            
            statement.execute();
            resultado = statement.getUpdateCount() == 1;
            conexion.close();
        }catch(Exception ex){
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return resultado;
    }
     
    /**
     * Elimina un registro de la tabla "responsable" basado en su ID.
     * 
     * @param id ID del registro a eliminar.
     * @return true si la eliminación fue exitosa; false en caso contrario.
     */
    public static boolean delete(int id){
        boolean resultado = false;
        try{
            Connection conexion = Conexion.obtener();
            String consulta = "DELETE FROM responsable WHERE id = ?";
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
         
    // Métodos getters y setters para los atributos.
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    
    /**
     * Representa el objeto Responsable en formato de texto.
     * 
     * @return Una cadena con el nombre del responsable.
     */
    @Override
    public String toString(){
        return this.nombre;
    }
}
