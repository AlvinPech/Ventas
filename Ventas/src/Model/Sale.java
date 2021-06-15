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
public class Sale {
    private int id;
    private int idClient;
    private int idUser;
    private String numSer;
    private String date;
    private double amount;

    public Sale(){
        
    }
    
    public Sale(int id, int idClient, int idUser, String numSer, String date, double amount) {
        this.id = id;
        this.idClient = idClient;
        this.idUser = idUser;
        this.numSer = numSer;
        this.date = date;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNumSer() {
        return numSer;
    }

    public void setNumSer(String numSer) {
        this.numSer = numSer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    
    
}
