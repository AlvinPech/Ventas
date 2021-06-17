/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Conexion;
import Model.Vendor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author alvin
 */
public class VendorDao {
    Conexion conect = new Conexion();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    public ArrayList listVen(){
        ArrayList<Vendor> data = new ArrayList<>();
        String sql = "select * from proveedor";
        try{
            conn = conect.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Vendor vendor = new Vendor();
                vendor.setIdVendor(rs.getInt(1));
                vendor.setName(rs.getString(2));
                vendor.setAddress(rs.getString(3));
                vendor.setTelephone(rs.getString(4));
                vendor.setMark(rs.getString(5));
                
                data.add(vendor);
            }
        } catch(Exception e){
            System.out.println(""+e);  
        }
        return data;
    }
    
    public int addVen(Vendor vendor){
        String sql = "insert into proveedor(Nombre, Direccion, Telefono, Marca) values(?,?,?,?)";
        try{
            conn = conect.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, vendor.getName());
            ps.setString(2, vendor.getAddress());
            ps.setString(3, vendor.getTelephone());
            ps.setString(4, vendor.getMark());
            ps.executeUpdate();
                  
        }catch(Exception e){
            System.out.println(""+e);
        }
        
        return 1;
    }
}
