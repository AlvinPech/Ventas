package model;


import java.sql.*;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alvin
 */
public class Conexion {
    Connection conect = null;
  static String bd="bd_tienda";
    static String login="root";
    static String password="root";
    static String url="jdbc:mysql://localhost:8889/"+Conexion.bd;
    
   public Connection getConexion()
    {
      try {
           
           Class.forName("com.mysql.cj.jdbc.Driver");
           conect = DriverManager.getConnection(url,login,password);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error "+e);
        }
        System.out.println(""+conect);
        return conect;
      }
   public void close(){
    try {
        conect.close();
        System.out.print("La Base de Datos esta cerrada \n");
    } catch (SQLException ex) {
       JOptionPane.showMessageDialog(null,"Error "+ex);
    }
   }
    
    
}
