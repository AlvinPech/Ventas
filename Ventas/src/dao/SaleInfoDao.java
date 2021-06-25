/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Conexion;
import model.Sale;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author alvin
 */
public class SaleInfoDao {
    Conexion conect = new Conexion();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    int response;
    
    public ArrayList listRangeSale(String fistDate, String secondDate){
        ArrayList<Sale> data = new ArrayList<>();
        String sql = "select * from ventas where FechaVentas between ? and ?";
        try{
            conn = conect.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, fistDate);
            ps.setString(2, secondDate);
            rs = ps.executeQuery();
            while(rs.next()){
                Sale sale = new Sale();
                sale.setId(rs.getInt(1));
                sale.setIdClient(rs.getInt(2));
                sale.setIdUser(rs.getInt(3));
                sale.setNumSer(rs.getString(4));
                sale.setDate(rs.getString(5));
                sale.setAmount(rs.getDouble(6));
                
                data.add(sale);
            }
        } catch(Exception e){
            System.out.println(""+e);
        }
        return data;
    }
    
    public ArrayList listDateSale(){
        ArrayList<String> data = new ArrayList<>();
        String sql = "select distinct FechaVentas from ventas";
        try{
            conn = conect.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                data.add(rs.getString(1));
                
            }
        } catch(Exception e){
            System.out.println(""+e);
        }
        return data;
    }
}
