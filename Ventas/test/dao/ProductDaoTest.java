/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.ProductDao;
import model.Product;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lizandro
 */
public class ProductDaoTest {
    
    public ProductDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of updateStock method, of class ProductDao.
     */
    @Test
    public void testUpdateStock() {
        System.out.println("updateStock"); //Actualmente el stock esta en 12, se actualizara a 11
        int cant = 11;
        int idProd = 14;
        ProductDao instance = new ProductDao();
        int expResult = 1;
        int result = instance.updateStock(cant, idProd);
        assertEquals(expResult, result);
        
    }

    
    /**
     * Test of addProduc method, of class ProductDao.
     */
    @Test
    public void testAddProduc() {
        System.out.println("addProduc");
        Product product = new Product(15,"Picafresa", 13, 11);
        ProductDao instance = new ProductDao();
        int expResult = 1;
        int result = instance.addProduc(product);
        assertEquals(expResult, result);
        
    }
    
}
