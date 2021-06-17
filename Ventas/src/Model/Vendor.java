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
public class Vendor {
    int idVendor;
    String name;
    String address;
    String telephone;
    String mark;
    
    public Vendor(){
        
    }

    public Vendor(int idVendor, String name, String address, String telephone, String mark) {
        this.idVendor = idVendor;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.mark = mark;
    }

    public int getIdVendor() {
        return idVendor;
    }

    public void setIdVendor(int idVendor) {
        this.idVendor = idVendor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
    
    
}
