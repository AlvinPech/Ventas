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
           
           //Cargamos el Driver MySQL
           Class.forName("com.mysql.cj.jdbc.Driver");
           conect = DriverManager.getConnection(url,login,password);
           //System.out.print("Se ha establecido una conexión a la Base de Datos "+url+" "+login +" \n");
           //Cargamos el Driver Access
           //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           //Conectar en red base 
           //String strConect = "jdbc:odbc:Driver=Microsoft Access Driver (*.mdb);DBQ=//servidor/bd_cw/cw.mdb";
           //Conectar Localmente
           //String strConect = "jdbc:odbc:Driver=Microsoft Access Driver (*.mdb);DBQ=D:/cwnetbeans/cw.mdb";
          //conect = DriverManager.getConnection(strConect,"",""); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error "+e);
        }
        System.out.println(""+conect);
        return conect;
      }
   public void cerrar(){
    try {
        conect.close();
        System.out.print("La Base de Datos esta cerrada \n");
    } catch (SQLException ex) {
       JOptionPane.showMessageDialog(null,"Error "+ex);
    }
   }
    
    
}
