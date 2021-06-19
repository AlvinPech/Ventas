/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.ProductDao;
import Dao.SaleDao;
import Model.DetailSale;
import Model.Product;
import Model.Sale;
import View.FrmInicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alvin
 */
public class SaleController implements ActionListener{
    Sale sale = new Sale();
    SaleDao dao = new SaleDao();
    FrmInicio view = new FrmInicio();
    DetailSale detail = new DetailSale();
    DefaultTableModel model = new DefaultTableModel();
    
    public SaleController(FrmInicio view){
       this.view = view;
       this.view.generateSaleBtn.addActionListener(this);
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.generateSaleBtn){
            validateSale();
        }
    }

    private void saveSale() {
        int idSale = 1;
        int idClient = Integer.parseInt(view.idClientTxt.getText());
        String serie = view.serieTxt.getText();
        String date = view.dateTxt.getText();
        double amount = Double.parseDouble(view.totalTxt.getText());
        
        sale.setIdClient(idClient);
        sale.setIdUser(idSale);
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

    private void updateStock() {
        int idProd = 0;
        int prodCant = 0;
        ProductDao pdao = new ProductDao();
        for(int i = 0; i < view.tablaProdVenta.getRowCount(); i++){
            Product prod = new Product();
            idProd = Integer.parseInt(view.tablaProdVenta.getValueAt(i, 1).toString());
            prodCant = Integer.parseInt(view.tablaProdVenta.getValueAt(i, 3).toString());
            prod = pdao.findProduct(idProd);
            int sa = prod.getCantidad() - prodCant;
            pdao.updateStock(sa, idProd);
        }
    }

    private void validateSale() {
        if(view.totalTxt.equals("")){
            JOptionPane.showMessageDialog(view, "El total esta vacio");
        }else{
            saveSale();
            saveDetailSale();
            updateStock();
            JOptionPane.showMessageDialog(view, "Venta Exitosa");
            cleanField();
            view.getSerie();
        }
    }
    
    private void cleanField(){
        view.cantidadNum.setValue(0);
        view.clientIdTxt.setText("");
        view.clientNomTxt.setText("");
        view.idClientTxt.setText("");
        view.prodIdTxt.setText("");
        view.prodNomTxt.setText("");
        view.totalTxt.setText("");
        
        cleanTable();
    }

    private void cleanTable() {
        model = (DefaultTableModel) view.tablaProdVenta.getModel();
        
        for(int i = 0; i < model.getRowCount(); i++){
            model.removeRow(i);
            i = i - 1;
        }
    }
    
}
