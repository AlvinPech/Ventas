/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.ClientDao;
import Model.Client;
import View.FrmInicio;
import View.FrmProduct;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author alvin
 */
public class ClientController implements ActionListener{
    
    Client client = new Client();
    ClientDao dao = new ClientDao();
    FrmInicio view = new FrmInicio();
    
    public ClientController(FrmInicio view){
       this.view = view;
       this.view.buscarClient.addActionListener(this);
       this.view.buscarProd.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.buscarClient){
            findClient();
        }
    }
    
    public void findClient(){
        String dni = view.clientIdTxt.getText();
        if(dni.equals("")){
            JOptionPane.showMessageDialog(view, "No deje espacios en blanco");
        }else{
            Client client = dao.findClient(dni);
            if(client.getDni() != null){
                view.clientNomTxt.setText(client.getNombres());
                view.idClientTxt.setText(""+client.getIdCliente());
            }
        }
        
    }
    
    
}
