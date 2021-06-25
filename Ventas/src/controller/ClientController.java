/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ClientDao;
import model.Client;
import view.FrmClient;
import view.FrmPrincipalView;
import view.FrmProduct;
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
public class ClientController implements ActionListener{
    
    Client client = new Client();
    ClientDao dao = new ClientDao();
    FrmPrincipalView view = new FrmPrincipalView();
    FrmClient clientView = new FrmClient();
    DefaultTableModel model = new DefaultTableModel();

    
    public ClientController(FrmPrincipalView view){
       this.view = view;
       this.view.buscarClient.addActionListener(this);
       this.view.buscarProd.addActionListener(this);
    }
    
    public ClientController(FrmClient client){
        this.clientView = client;
        this.clientView.saveClientBtn.addActionListener(this);
        this.clientView.listClientBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.buscarClient){
            findClient();
        }
        
        if(e.getSource() == clientView.saveClientBtn){
            saveClient();
        }
        
        if(e.getSource() == clientView.listClientBtn){
            listClient(clientView.clienTable);
        }
    }
    
    private void cleanFielTable(){
        clientView.dirClientTxt.setText("");
        clientView.dniClientTxt.setText("");
        clientView.idClientTxt.setText("");
        clientView.nomClientTxt.setText("");
        
        model = (DefaultTableModel) clientView.clienTable.getModel();
        
        for(int i = 0; i < model.getRowCount(); i++){
            model.removeRow(i);
            i = i - 1;
        }
        
    }
    
    public void findClient(){
        String dni = view.clientIdTxt.getText();
        if(dni.equals("")){
            JOptionPane.showMessageDialog(view, "No deje espacios en blanco");
        }else{
            Client client = dao.findClient(dni);
            validateDni(client);
        }
        
    }
    
    private static boolean isNumeric(String cadena){
    	try {
            Integer.parseInt(cadena);
            return true;
    	} catch (NumberFormatException nfe){
            return false;
    	}
    }

    private void saveClient() {
        String dni = clientView.dniClientTxt.getText();
        String name = clientView.nomClientTxt.getText();
        String dir = clientView.dirClientTxt.getText();
        //String email = clientView.emailClientTxt.getText();
        
        if(dni.equals("")|| name.equals("") || dir.equals("")){
            JOptionPane.showMessageDialog(clientView, "No deje espacios en blanco");
        }else{
            client.setDni(dni);
            client.setNombres(name);
            client.setDireccion(dir);

            int response = dao.addClien(client);

            showAddClientMessage(response);
        }
    }

    private void listClient(JTable table) {
        cleanFielTable();
        model = (DefaultTableModel) table.getModel();
        ArrayList<Client> listData = dao.listClient();
        Object[] object = new Object[4];
        for(int i = 0; i < listData.size(); i++){
            object[0] = listData.get(i).getIdCliente();
            object[1] = listData.get(i).getDni();
            object[2] = listData.get(i).getNombres();
            object[3] = listData.get(i).getDireccion();
            model.addRow(object);
        }
        
        clientView.clienTable.setModel(model);
    }

    private void validateDni(Client client) {
        if(client.getDni() != null){
            view.clientNomTxt.setText(client.getNombres());
            view.idClientTxt.setText(""+client.getIdCliente());
        }else{
            JOptionPane.showMessageDialog(view, "No se encontro el cliente");
        }
    }

    private void showAddClientMessage(int response) {
        if(response == 1){
            JOptionPane.showMessageDialog(clientView, "Cliente agregado con exito");
            cleanFielTable();
        }else{
            JOptionPane.showMessageDialog(clientView, "Error de agregacion");
        }
    }
    
    
}
