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
public class DetailSale {
    int idSaleDetail;
    int idSale;
    int idProduct;
    int cant;
    double saleAmount;
    
    public DetailSale(){
        
    }

    public DetailSale(int idSaleDetail, int idSale, int idProduct, int cant, double saleAmount) {
        this.idSaleDetail = idSaleDetail;
        this.idSale = idSale;
        this.idProduct = idProduct;
        this.cant = cant;
        this.saleAmount = saleAmount;
    }

    public int getIdSaleDetail() {
        return idSaleDetail;
    }

    public void setIdSaleDetail(int idSaleDetail) {
        this.idSaleDetail = idSaleDetail;
    }

    public int getIdSale() {
        return idSale;
    }

    public void setIdSale(int idSale) {
        this.idSale = idSale;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public double getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(double saleAmount) {
        this.saleAmount = saleAmount;
    }
    
    
}
