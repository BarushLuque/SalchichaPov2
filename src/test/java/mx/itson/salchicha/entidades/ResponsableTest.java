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
public class ResponsableTest {
    
    public ResponsableTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getAll method, of class Responsable.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        List<Responsable> expResult = null;
        List<Responsable> result = Responsable.getAll();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getById method, of class Responsable.
     */
    @Test
    public void testGetById() {
        System.out.println("getById");
        int id = 0;
        Responsable expResult = null;
        Responsable result = Responsable.getById(id);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of save method, of class Responsable.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        String nombre = "";
        String puesto = "";
        boolean expResult = false;
        boolean result = Responsable.save(nombre, puesto);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of edit method, of class Responsable.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        int id = 0;
        String nombre = "";
        String puesto = "";
        boolean expResult = false;
        boolean result = Responsable.edit(id, nombre, puesto);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of delete method, of class Responsable.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        int id = 0;
        boolean expResult = false;
        boolean result = Responsable.delete(id);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getId method, of class Responsable.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Responsable instance = new Responsable();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setId method, of class Responsable.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Responsable instance = new Responsable();
        instance.setId(id);
       
    }

    /**
     * Test of getNombre method, of class Responsable.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Responsable instance = new Responsable();
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);

    }

    /**
     * Test of setNombre method, of class Responsable.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        Responsable instance = new Responsable();
        instance.setNombre(nombre);
        
    }

    /**
     * Test of getPuesto method, of class Responsable.
     */
    @Test
    public void testGetPuesto() {
        System.out.println("getPuesto");
        Responsable instance = new Responsable();
        String expResult = "";
        String result = instance.getPuesto();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setPuesto method, of class Responsable.
     */
    @Test
    public void testSetPuesto() {
        System.out.println("setPuesto");
        String puesto = "";
        Responsable instance = new Responsable();
        instance.setPuesto(puesto);
        
    }

    /**
     * Test of toString method, of class Responsable.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Responsable instance = new Responsable();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }
    
}
