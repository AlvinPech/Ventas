/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.Conexion;
import java.sql.Connection;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alvin
 */
public class ConexionTest {
    
    public ConexionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getConexion method, of class Conexion.
     */
    @Test
    public void testGetConexion() {
        System.out.println("getConexion");
        Conexion instance = new Conexion();
        Connection result = instance.getConexion();
  
        CharSequence successResponse = "ConnectionImpl";//com.mysql.cj.jdbc.ConnectionImpl
        String response = result.toString();
        boolean bool = response.contains(successResponse);
        
        Boolean expResult = true;
        
        assertEquals(expResult, bool);
        
    }

    /**
     * Test of cerrar method, of class Conexion.
     */
    /*@Test
    public void testCerrar() {
        System.out.println("cerrar");
        Conexion instance = new Conexion();
        instance.cerrar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
