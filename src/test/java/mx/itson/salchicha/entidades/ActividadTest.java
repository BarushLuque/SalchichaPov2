/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package mx.itson.salchicha.entidades;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Barush
 */
public class ActividadTest {
    
    public ActividadTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    

    /**
     * Test of getServicio method, of class Actividad.
     */
    @org.junit.jupiter.api.Test
    public void testGetServicio() {
        System.out.println("getServicio");
        Actividad instance = new Actividad();
        Servicio expResult = null;
        Servicio result = instance.getServicio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setServicio method, of class Actividad.
     */
    @org.junit.jupiter.api.Test
    public void testSetServicio() {
        System.out.println("setServicio");
        Servicio servicio = null;
        Actividad instance = new Actividad();
        instance.setServicio(servicio);
        
    }

    /**
     * Test of getList method, of class Actividad.
     */
    @org.junit.jupiter.api.Test
    public void testGetList() {
        System.out.println("getList");
        int idServicio = 0;
        List<Actividad> expResult = null;
        List<Actividad> result = Actividad.getList(idServicio);
        assertEquals(expResult, result);
     
    }

    /**
     * Test of delete method, of class Actividad.
     */
    @org.junit.jupiter.api.Test
    public void testDelete() {
        System.out.println("delete");
        int id = 0;
        boolean expResult = false;
        boolean result = Actividad.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class Actividad.
     */
    @org.junit.jupiter.api.Test
    public void testEdit() {
        System.out.println("edit");
        int orden = 0;
        String descripcion = "";
        int id = 0;
        boolean expResult = false;
        boolean result = Actividad.edit(orden, descripcion, id);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of save method, of class Actividad.
     */
    @org.junit.jupiter.api.Test
    public void testSave() {
        System.out.println("save");
        int orden = 0;
        String descripcion = "";
        boolean expResult = false;
        boolean result = Actividad.save(orden, descripcion);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getById method, of class Actividad.
     */
    @org.junit.jupiter.api.Test
    public void testGetById() {
        System.out.println("getById");
        int id = 0;
        Actividad expResult = null;
        Actividad result = Actividad.getById(id);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getAll method, of class Actividad.
     */
    @org.junit.jupiter.api.Test
    public void testGetAll() {
        System.out.println("getAll");
        List<Actividad> expResult = null;
        List<Actividad> result = Actividad.getAll();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getId method, of class Actividad.
     */
    @org.junit.jupiter.api.Test
    public void testGetId() {
        System.out.println("getId");
        Actividad instance = new Actividad();
        int expResult = 1;
        int result = instance.getId();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setId method, of class Actividad.
     */
    @org.junit.jupiter.api.Test
    public void testSetId() {
        System.out.println("setId");
        int id = 1;
        Actividad instance = new Actividad();
        instance.setId(id);
       
    }

    /**
     * Test of getOrden method, of class Actividad.
     */
    @org.junit.jupiter.api.Test
    public void testGetOrden() {
        System.out.println("getOrden");
        Actividad instance = new Actividad();
        int expResult = 1;
        int result = instance.getOrden();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of setOrden method, of class Actividad.
     */
    @org.junit.jupiter.api.Test
    public void testSetOrden() {
        System.out.println("setOrden");
        int orden = 1;
        Actividad instance = new Actividad();
        instance.setOrden(orden);
        
    }

    /**
     * Test of getDescripcion method, of class Actividad.
     */
    @org.junit.jupiter.api.Test
    public void testGetDescripcion() {
        System.out.println("getDescripcion");
        Actividad instance = new Actividad();
        String expResult = "HOLA";
        String result = instance.getDescripcion();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setDescripcion method, of class Actividad.
     */
    @org.junit.jupiter.api.Test
    public void testSetDescripcion() {
        System.out.println("setDescripcion");
        String descripcion = "HOLA";
        Actividad instance = new Actividad();
        instance.setDescripcion(descripcion);
        
    }
    
}
