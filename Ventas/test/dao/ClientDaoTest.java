/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.ClientDao;
import model.Client;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alvin
 */
public class ClientDaoTest {
    
    public ClientDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of findClient method, of class ClientDao.
     */
    @Test
    public void testFindClient() {
        System.out.println("findClient");
        String dni = "678";
        Client clientExample = new Client(8, "678", "Pepe", "Calle 34 # 345");
        String expResult = clientExample.getNombres();
        
        ClientDao instance = new ClientDao();
        Client result = instance.findClient(dni);
        String methodResult = result.getNombres();
        
        assertEquals(expResult, methodResult);
    }
}
