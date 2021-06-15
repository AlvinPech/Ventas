/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.SaleDao;
import Model.DetailSale;
import Model.Sale;
import View.FrmInicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author alvin
 */
public class SaleController implements ActionListener{
    Sale sale = new Sale();
    SaleDao dao = new SaleDao();
    FrmInicio view = new FrmInicio();
    DetailSale detail = new DetailSale();
    
    public SaleController(FrmInicio view){
       this.view = view;
       this.view.generateSaleBtn.addActionListener(this);
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.generateSaleBtn){
            saveSale();
            saveDetailSale();
        }
    }

    private void saveSale() {
        int idSale = 1;
        int idClient = Integer.parseInt(view.idClientTxt.getText());
        String serie = view.serieTxt.getText();
        String date = view.dateTxt.getText();
        double amount = Double.parseDouble(view.totalTxt.getText());
        
        sale.setIdClient(idSale);
        sale.setIdUser(idClient);
        sale.setNumSer(serie);
        sale.setDate(date);
        sale.setAmount(amount);
        
        dao.saveSale(sale); 
        
    }

    private void saveDetailSale() {
        String idv = dao.getIdSale();
        int idve = Integer.parseInt(idv);
        for(int i = 0; i < view.tablaProdVenta.getRowCount(); i++){
            int idProduct = Integer.parseInt(view.tablaProdVenta.getValueAt(i, 1).toString());
            int cant = Integer.parseInt(view.tablaProdVenta.getValueAt(i, 3).toString());
            double price = Double.parseDouble(view.tablaProdVenta.getValueAt(i, 4).toString());
            detail.setIdSale(idve);
            detail.setIdProduct(idProduct);
            detail.setCant(cant);
            detail.setSaleAmount(price);
            dao.saveDetailSale(detail);
            
        }
    }
    
}
