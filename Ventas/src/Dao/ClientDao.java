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
