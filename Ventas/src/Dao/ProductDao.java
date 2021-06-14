/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Conexion;
import Model.Product;
import java.awt.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author alvin
 */
public class ProductDao {
    Conexion conect = new Conexion();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    public Product findProduct(int id){
        Product product = new Product();
        String sql = "select * from producto where IdProducto = ?";
        
        try{
            conn  = conect.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                product.setId(rs.getInt(1));
                product.setNombre(rs.getString(2));
                product.setPrecio(rs.getDouble(3));
                product.setCantidad(rs.getInt(4));
                
            }
            
        } catch(Exception e){
            System.out.println("Error "+e);
        }
        
        return product;
    }
    
    public ArrayList listProduct(){
        ArrayList<Product> data = new ArrayList<>();
        String sql = "select * from producto";
        try{
            conn = conect.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Product product = new Product();
                product.setId(rs.getInt(1));
                product.setNombre(rs.getString(2));
                product.setPrecio(rs.getDouble(3));
                product.setCantidad(rs.getInt(4));
                
                data.add(product);
            }
        } catch(Exception e){
            
        }
        return data;
    }
    
    public int addProduc(Product product){
        String sql = "INSERT INTO PRODUCTO(Nombres, Precio, Stock) VALUES(?,?,?)";
        try{
            conn = conect.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, product.getNombre());
            ps.setDouble(2, product.getPrecio());
            ps.setInt(3, product.getCantidad());
            ps.executeUpdate();
                  
        }catch(Exception e){
            System.out.println(""+e);
        }
        
        return 1;
    }
}
