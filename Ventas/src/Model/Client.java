/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author alvin
 */
public class Client {
    int IdCliente;
    String Dni;
    String Nombres;
    String Direccion;

    public Client(){
        
    }
    
    public Client(int IdCliente, String Dni, String Nombres, String Direccion) {
        this.IdCliente = IdCliente;
        this.Dni = Dni;
        this.Nombres = Nombres;
        this.Direccion = Direccion;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String Dni) {
        this.Dni = Dni;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
    
    
    
}
