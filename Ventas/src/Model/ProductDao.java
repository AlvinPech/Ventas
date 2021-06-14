/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
    
    public ArrayList listProduct(){
        ArrayList<Product> data = new ArrayList<>();
        String sql = "select * from productos";
        try{
            conn = conect.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Product product = new Product();
                product.setId(rs.getInt(1));
                product.setNombre(rs.getString(2));
                product.setCantidad(rs.getInt(3));
                product.setPrecio(rs.getDouble(4));
                
                data.add(product);
            }
        } catch(Exception e){
            
        }
        return data;
    }
    
    public int addProduct(Product product){
        String sql = "insert into productos(nombre, cantidad, precio) values(?,?,?)";
        try{
            conn = conect.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, product.getNombre());
            ps.setInt(2, product.getCantidad());
            ps.setDouble(3, product.getPrecio());
            ps.executeUpdate();
                  
        }catch(Exception e){
            System.out.println(""+e);
        }
        
        return 1;
    }
}
