/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author alvin
 */
public class Purchase {
    int idPurchase;
    int idVendor;
    String datePurchase;
    double amount;
    
    public Purchase(){
        
    }

    public Purchase(int idPurchase, int idVendor, String datePurchase, double amount) {
        this.idPurchase = idPurchase;
        this.idVendor = idVendor;
        this.datePurchase = datePurchase;
        this.amount = amount;
    }

    public int getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(int idPurchase) {
        this.idPurchase = idPurchase;
    }

    public int getIdVendor() {
        return idVendor;
    }

    public void setIdVendor(int idVendor) {
        this.idVendor = idVendor;
    }

    public String getDatePurchase() {
        return datePurchase;
    }

    public void setDatePurchase(String datePurchase) {
        this.datePurchase = datePurchase;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    
}
