/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.VendorDao;
import Model.Vendor;
import View.FrmVendor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alvin
 */
public class VendorController implements ActionListener{
    Vendor vendor = new Vendor();
    VendorDao vendorDao = new VendorDao();
    DefaultTableModel model = new DefaultTableModel();
    FrmVendor vendorView = new FrmVendor();
    
    public VendorController(FrmVendor vendor){
        this.vendorView = vendor;
        this.vendorView.saveVendorBtn.addActionListener(this);
        this.vendorView.listVendorBtn.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vendorView.saveVendorBtn){
            saveVendor();
        }
        
        if(e.getSource() == vendorView.listVendorBtn){
            listVendor(vendorView.vendorTable);
        }
    }

    private void saveVendor() {
        String name = vendorView.nameVendorTxt.getText();
        String adress = vendorView.dirVendorTxt.getText();
        String telephone = vendorView.telVendorTxt.getText();
        String mark = vendorView.markVendorTxt.getText();
        
        vendor.setName(name);
        vendor.setAddress(adress);
        vendor.setTelephone(telephone);
        vendor.setMark(mark);
        
        
        int response = vendorDao.addVen(vendor);
        
        if(response == 1){
            JOptionPane.showMessageDialog(vendorView, "Proveedor agregado con exito");
        }else{
            JOptionPane.showMessageDialog(vendorView, "Error de agregacion");
        }
    }

    private void listVendor(JTable vendorTable) {
        model = (DefaultTableModel) vendorTable.getModel();
        ArrayList<Vendor> listData = vendorDao.listVen();
        Object[] object = new Object[5];
        for(int i = 0; i < listData.size(); i++){
            object[0] = listData.get(i).getIdVendor();
            object[1] = listData.get(i).getName();
            object[2] = listData.get(i).getAddress();
            object[3] = listData.get(i).getTelephone();
            object[4] = listData.get(i).getMark();
            model.addRow(object);
        }
        
        vendorView.vendorTable.setModel(model);
    }
}
