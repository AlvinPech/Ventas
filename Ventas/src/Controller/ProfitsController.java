/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.ProfitsDao;
import Model.Purchase;
import Model.Sale;
import View.FrmInicio;
import View.FrmProfits;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alvin
 */
public class ProfitsController implements ActionListener {
    ProfitsDao dao = new ProfitsDao();
    FrmProfits profitsView = new FrmProfits();
    FrmInicio principalView = new FrmInicio();
    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel modelPurchase = new DefaultTableModel();
    double totalAmountSale;
    double totalAmountPurch;
    double totalSale;
    double totalPurchase;
    
    public ProfitsController(FrmProfits view){
        this.profitsView = view;
        this.profitsView.findDateBtn.addActionListener(this);
        this.profitsView.calculateProfitBtn.addActionListener(this);
        getLastPurchase();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == profitsView.findDateBtn){
            String firstDate = profitsView.fromTxt.getText();
            String secondDate = profitsView.toTxt.getText();
            listSale(profitsView.saleTable, firstDate, secondDate);
            listPurchase(profitsView.purchaseTable, firstDate, secondDate);
        }
        
        if(e.getSource() == profitsView.calculateProfitBtn){
            calculateTotal();
        }
    }
    
    private void getLastPurchase() {
        String serie = dao.lastPurchase();
        if(serie == null){
            System.out.println("Error");
            
        }else{
            profitsView.fromTxt.setText(serie);
            profitsView.toTxt.setText(principalView.dateTxt.getText());
        }
    }
    
    private void listSale(JTable saleTable, String firstDate, String secondDate) {
        model = (DefaultTableModel) saleTable.getModel();
        ArrayList<Sale> listData = dao.listRangeSale(firstDate, secondDate);
        Object[] object = new Object[3];
        for(int i = 0; i < listData.size(); i++){
            object[0] = listData.get(i).getId();
            object[1] = listData.get(i).getDate();
            object[2] = listData.get(i).getAmount();
            model.addRow(object);
        }
        
        profitsView.saleTable.setModel(model);
    }

    private void listPurchase(JTable purchaseTable, String firstDate, String secondDate) {
        modelPurchase = (DefaultTableModel) purchaseTable.getModel();
        ArrayList<Purchase> listData = dao.listRangePurchase(firstDate, secondDate);
        Object[] object = new Object[3];
        for(int i = 0; i < listData.size(); i++){
            object[0] = listData.get(i).getIdPurchase();
            object[1] = listData.get(i).getDatePurchase();
            object[2] = listData.get(i).getAmount();
            modelPurchase.addRow(object);
        }
        
        profitsView.purchaseTable.setModel(modelPurchase);
    }
    
    private void calculateTotal() {
        double profit = 0;
        totalAmountSale = 0;
        totalAmountPurch = 0;
        
        //Calculate amount for Sale table
        for(int i = 0; i < model.getRowCount(); i++){
            totalSale = Double.parseDouble(model.getValueAt(i, 2).toString());
            totalAmountSale = totalAmountSale + totalSale;
        }
        
        //Calculate amount for Purchase table
        for(int i = 0; i < modelPurchase.getRowCount(); i++){
            totalSale = Double.parseDouble(modelPurchase.getValueAt(i, 2).toString());
            totalAmountPurch = totalAmountPurch + totalSale;
        }
        
        profit = totalAmountSale - totalAmountPurch;
        
        profitsView.profitTxt.setText(""+profit);
        
        
        
    }
}
