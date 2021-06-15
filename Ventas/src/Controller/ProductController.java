/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.FrmProduct;
import Model.Product;
import Dao.ProductDao;
import View.FrmInicio;
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
    Product foundProduct = new Product();
    FrmProduct productView = new FrmProduct();
    FrmInicio principalView = new FrmInicio();
    DefaultTableModel model = new DefaultTableModel();
    int item = 0;
    double totalPagar;
    double total;
    
    
    public ProductController(FrmProduct view){
       this.productView = view;
       this.productView.listarProductoBtn.addActionListener(this);
       this.productView.guardarProductoBtn.addActionListener(this);
    }
    
    public ProductController(FrmInicio view){
       this.principalView = view;
       this.principalView.buscarProd.addActionListener(this);
       this.principalView.AgregarProd.addActionListener(this);
       
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == productView.listarProductoBtn){
            list(productView.jTable1);
        }
        
        if(e.getSource() == productView.guardarProductoBtn){
            add();
        }
        
        if(e.getSource() == principalView.buscarProd){
            findProduct();
        }
        
        if(e.getSource() == principalView.AgregarProd){
            addTableProduct();
        }
    }
    
    private void addTableProduct(){
        
        model = (DefaultTableModel) principalView.tablaProdVenta.getModel();
        int idProd = foundProduct.getId();
        String prodName = foundProduct.getNombre();
        double prodPrice = foundProduct.getPrecio();
        int cantProd = Integer.parseInt(principalView.cantidadNum.getValue().toString());
        int stock = foundProduct.getCantidad();
        total = cantProd * prodPrice;
        
        ArrayList list = new ArrayList();
        
        if(stock > 0){
            item = item + 1;
            list.add(item);
            list.add(idProd);
            list.add(prodName);
            list.add(cantProd);
            list.add(prodPrice);
            list.add(total);
            Object[] ob = new Object[6];
            ob[0] = list.get(0);
            ob[1] = list.get(1);
            ob[2] = list.get(2);
            ob[3] = list.get(3);
            ob[4] = list.get(4);
            ob[5] = list.get(5);
            model.addRow(ob);
            principalView.tablaProdVenta.setModel(model);
            calculateTotal();
        }else{
            JOptionPane.showMessageDialog(principalView, "El stock llego a cero");            
        }
    }
    
    private void calculateTotal(){
        totalPagar = 0;
        for(int i = 0; i < model.getRowCount(); i++){
            total = Double.parseDouble(model.getValueAt(i, 5).toString());
            totalPagar = totalPagar + total;
        }
        principalView.totalTxt.setText(""+totalPagar);
    }
    
    private void findProduct() {
        String txtId = principalView.prodIdTxt.getText();
        int dni = Integer.parseInt(txtId);
        if(txtId.equals("")){
            JOptionPane.showMessageDialog(principalView, "No deje espacios en blanco");
        }else{
            Product prod = dao.findProduct(dni);
            foundProduct = prod;
            if(prod.getId() != 0){
                principalView.prodNomTxt.setText(prod.getNombre());
            }else{
                JOptionPane.showMessageDialog(principalView, "Producto no encontrado");
            }
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
        
        int response = dao.addProduc(product);
        
        if(response == 1){
            JOptionPane.showMessageDialog(productView, "Producto agregado con exito");
        }else{
            JOptionPane.showMessageDialog(productView, "Error de agregacion");
        }
        
        //cleanField();
    }
    
    public void cleanField(){
        productView.nomProductTxt.setText("");
        productView.precioProductTxt.setText("");
        productView.cantProductTxt.setText("");
    }

   
}
