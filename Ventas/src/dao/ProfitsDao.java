/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Conexion;
import model.Purchase;
import model.Sale;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author alvin
 */
public class ProfitsDao {
    Conexion conect = new Conexion();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    int response = 0;
    
    public String lastPurchase(){
        String lastPurchase = "";
        String sql = "select max(FechaCompra) from compras";
        try{
            conn = conect.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                lastPurchase  = rs.getString(1);
            }
        }catch(Exception e){
            System.out.println(""+e);
        }
        
        return lastPurchase;
    }
    
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
    
    public ArrayList listRangePurchase(String fistDate, String secondDate){
        ArrayList<Purchase> data = new ArrayList<>();
        String sql = "select * from compras where FechaCompra between ? and ?";
        try{
            conn = conect.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, fistDate);
            ps.setString(2, secondDate);
            rs = ps.executeQuery();
            while(rs.next()){
                Purchase purchase = new Purchase();
                purchase.setIdPurchase(rs.getInt(1));
                purchase.setIdVendor(rs.getInt(2));
                purchase.setDatePurchase(rs.getString(3));
                purchase.setAmount(rs.getDouble(4));
                
                data.add(purchase);
            }
        } catch(Exception e){
            System.out.println(""+e);
        }
        return data;
    }
}
