/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.SaleInfoDao;
import Model.Sale;
import View.FrmPrincipalView;
import View.FrmSaleInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alvin
 */
public class SaleInfoController implements ActionListener {
    FrmSaleInfo infoView = new FrmSaleInfo();
    FrmPrincipalView principalView = new FrmPrincipalView();
    SaleInfoDao dao = new SaleInfoDao();
    DefaultTableModel model = new DefaultTableModel();
    double totalAmount;
    double total;
    
    public SaleInfoController(FrmSaleInfo view){
        this.infoView = view;
        this.infoView.findSaleBtn.addActionListener(this);
        this.infoView.todaySaleBtn.addActionListener(this);
        listDates();
    }
    
    public SaleInfoController(FrmPrincipalView view){
        this.principalView = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == infoView.findSaleBtn){
            cleanFieldTable();
            String firstDate = infoView.fromCombo.getSelectedItem().toString();
            String secondDate = infoView.toCombo.getSelectedItem().toString();
            listSale(infoView.saleTable, firstDate, secondDate);
            calculateTotal();
        }
        
        if(e.getSource() == infoView.todaySaleBtn){
            cleanFieldTable();
            String firstDate = principalView.dateTxt.getText();
            String secondDate = principalView.dateTxt.getText();
            listSale(infoView.saleTable, firstDate, secondDate);
            calculateTotal();
        }
        
    }
    
    private void cleanFieldTable() {
        //Clean purchase table
        model = (DefaultTableModel) infoView.saleTable.getModel();
        
        for(int i = 0; i < model.getRowCount(); i++){
            model.removeRow(i);
            i = i - 1;
        }
    }
    
    private void listDates(){
        ArrayList<String> listData = dao.listDateSale();
        for(int i = 0; i < listData.size(); i++){
            infoView.fromCombo.addItem(listData.get(i));
            infoView.toCombo.addItem(listData.get(i));
        }
    }

    private void listSale(JTable saleTable, String firstDate, String secondDate) {

        model = (DefaultTableModel) saleTable.getModel();
        
        ArrayList<Sale> listData = dao.listRangeSale(firstDate, secondDate);
        Object[] object = new Object[5];
        for(int i = 0; i < listData.size(); i++){
            object[0] = listData.get(i).getId();
            object[1] = listData.get(i).getIdClient();
            object[2] = listData.get(i).getNumSer();
            object[3] = listData.get(i).getDate();
            object[4] = listData.get(i).getAmount();
            model.addRow(object);
        }
        
        infoView.saleTable.setModel(model);
    }

    private void calculateTotal() {
        totalAmount = 0;
        for(int i = 0; i < model.getRowCount(); i++){
            total = Double.parseDouble(model.getValueAt(i, 4).toString());
            totalAmount = totalAmount + total;
        }
        infoView.totalTxt.setText(""+totalAmount);
    }
}
