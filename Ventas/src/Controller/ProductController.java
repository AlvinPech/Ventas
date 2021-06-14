/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.FrmProduct;
import Model.Product;
import Model.ProductDao;
import java.awt.List;
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
public class ProductController implements ActionListener{

    ProductDao dao = new ProductDao();
    Product product = new Product();
    FrmProduct productView = new FrmProduct();
    DefaultTableModel model = new DefaultTableModel();
    
    public ProductController(FrmProduct view){
       this.productView = view;
       this.productView.listarProductoBtn.addActionListener(this);
       this.productView.guardarProductoBtn.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == productView.listarProductoBtn){
            list(productView.jTable1);
        }
        
        if(e.getSource() == productView.guardarProductoBtn){
            add();
        }
    }
    
    
    public void list(JTable table){
        model = (DefaultTableModel) table.getModel();
        ArrayList<Product> listData = dao.listProduct();
        Object[] object = new Object[4];
        for(int i = 0; i < listData.size(); i++){
            object[0] = listData.get(i).getId();
            object[1] = listData.get(i).getNombre();
            object[2] = listData.get(i).getCantidad();
            object[3] = listData.get(i).getPrecio();
            model.addRow(object);
        }
        
        productView.jTable1.setModel(model);
    }
    
    public void add(){
        String name = productView.nomProductTxt.getText();
        int cant = Integer.parseInt(productView.cantProductTxt.getText());
        double price = Double.parseDouble(productView.precioProductTxt.getText());
        
        product.setNombre(name);
        product.setCantidad(cant);
        product.setPrecio(price);
        
        int response = dao.addProduct(product);
        
        if(response == 1){
            JOptionPane.showMessageDialog(productView, "Usuario agregado con exito");
        }else{
            JOptionPane.showMessageDialog(productView, "Error de agregacion");
        }
         
    }
}
