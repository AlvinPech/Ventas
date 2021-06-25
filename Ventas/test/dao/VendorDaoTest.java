/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.VendorDao;
import model.Vendor;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alvin
 */
public class VendorDaoTest {
    
    public VendorDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of listVen method, of class VendorDao.
     */
    @Test
    public void testListVen() {
        System.out.println("listVen");
        VendorDao instance = new VendorDao();
        ArrayList expResult = null;
        ArrayList result = instance.listVen();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addVen method, of class VendorDao.
     */
    @Test
    public void testAddVen() {
        System.out.println("addVen");
        Vendor vendor = null;
        VendorDao instance = new VendorDao();
        int expResult = 0;
        int result = instance.addVen(vendor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
