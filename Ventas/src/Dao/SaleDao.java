/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Conexion;
import Model.DetailSale;
import Model.Sale;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author alvin
 */
public class SaleDao {
    Conexion conect = new Conexion();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    int response = 0;
    
    public String NumSerie(){
        String serie = "";
        String sql = "select max(NumeroSerie) from ventas";
        try{
            conn = conect.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                serie  = rs.getString(1);
            }
        }catch(Exception e){
            System.out.println(""+e);
        }
        
        return serie;
    }
    
    public String getIdSale(){
        String idSale = "";
        String sql = "select max(IdVentas) from ventas";
        try{
            conn = conect.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                idSale = rs.getString(1);
            }
        }catch(Exception e){
            
        }
        
        return idSale;
    }
    
    public int saveSale(Sale s){
        System.out.println("Guardar venta");
        Sale sale = new Sale();
        String sql = "insert into ventas(IdCliente, IdVendedor, NumeroSerie, FechaVentas, Monto) values(?,?,?,?,?)";
        
        try{
            conn = conect.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, s.getIdClient());
            ps.setInt(2, s.getIdUser());
            ps.setString(3, s.getNumSer());
            ps.setString(4, s.getDate());
            ps.setDouble(5, s.getAmount());
            
            response = ps.executeUpdate();
        }catch(Exception e){
            System.out.println(""+e);
        }
        
        return response;
    }
    
    public int saveDetailSale(DetailSale ds){
        System.out.println("Si entra");
        String sql = "insert into detalle_ventas(IdVentas, IdProducto, Cantidad, PrecioVenta) values(?,?,?,?)";
        try{
            conn = conect.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, ds.getIdSale());
            ps.setInt(2, ds.getIdProduct());
            ps.setInt(3, ds.getCant());
            ps.setDouble(4, ds.getSaleAmount());
            ps.executeUpdate();
        }catch(Exception e){
            
        }
        return response;
    }
}
