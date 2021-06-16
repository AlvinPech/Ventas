/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Client;
import Model.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author alvin
 */
public class ClientDao {
    Conexion conect = new Conexion();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public ArrayList listClient(){
        ArrayList<Client> data = new ArrayList<>();
        String sql = "select * from cliente";
        try{
            conn = conect.getConexion();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Client client = new Client();
                client.setIdCliente(rs.getInt(1));
                client.setDni(rs.getString(2));
                client.setNombres(rs.getString(3));
                client.setDireccion(rs.getString(4));
                
                data.add(client);
            }
        } catch(Exception e){
            
        }
        return data;
    }
    
    public int addClien(Client client){
        String sql = "INSERT INTO CLIENTE(Dni, Nombres, Direccion) VALUES(?,?,?)";
        try{
            conn = conect.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, client.getDni());
            ps.setString(2, client.getNombres());
            ps.setString(3, client.getDireccion());
            ps.executeUpdate();
                  
        }catch(Exception e){
            System.out.println(""+e);
        }
        
        return 1;
    }
    
    
    
    public Client findClient(String dni){
        Client client = new Client();
        String sql = "select * from cliente where Dni = ?";
        
        try{
            conn  = conect.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, dni);
            rs = ps.executeQuery();
            
            while(rs.next()){
                client.setIdCliente(rs.getInt(1));
                client.setDni(rs.getString(2));
                client.setNombres(rs.getString(3));
                client.setDireccion(rs.getString(4));
                
            }
            
        } catch(Exception e){
            System.out.println("Error "+e);
        }
        
        return client;
    }
}
