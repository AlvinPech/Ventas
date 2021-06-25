/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.SaleDao;
import model.DetailSale;
import model.Sale;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rodrigo
 */
public class SaleDaoTest {
    
    public SaleDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of NumSerie method, of class SaleDao.
     */
    @Test
    public void testNumSerie() {
        System.out.println("NumSerie");
        SaleDao instance = new SaleDao();
        String expResult = "21";
        String result = instance.NumSerie();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getIdSale method, of class SaleDao.
     */
    @Test
    public void testGetIdSale() {
        System.out.println("getIdSale");
        SaleDao instance = new SaleDao();
        String expResult = "107";
        String result = instance.getIdSale();
        assertEquals(expResult, result);
        
    }
    
}
