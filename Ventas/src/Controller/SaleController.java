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
import View.FrmPrincipalView;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alvin
 */
public class SaleController implements ActionListener{
    Sale sale = new Sale();
    SaleDao dao = new SaleDao();
    FrmPrincipalView view = new FrmPrincipalView();
    DetailSale detail = new DetailSale();
    DefaultTableModel model = new DefaultTableModel();
    
    public SaleController(FrmPrincipalView view){
       this.view = view;
       this.view.generateSaleBtn.addActionListener(this);
       this.view.cancelSaleBtn.addActionListener(this);
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.generateSaleBtn){
            validateSale();
        }
        
        if(e.getSource() == view.cancelSaleBtn){
            cancelSale();
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
            createTicket();
            JOptionPane.showMessageDialog(view, "Venta Exitosa");
            cleanField();
            view.getSerie();
        }
    }
    
    private void cancelSale(){
        cleanField();
        JOptionPane.showMessageDialog(view, "Se ha cancelado la venta");
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

    private void createTicket() {
        try {
            int idPdf = Integer.parseInt(view.serieTxt.getText());
            FileOutputStream fileOutputStream;
            File file = new File("src/pdf/venta" + idPdf + ".pdf");
            fileOutputStream = new FileOutputStream(file);
            Document document = new Document();
            PdfWriter.getInstance(document, fileOutputStream);
            document.open();

            Paragraph dateParagraph = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLUE);
            dateParagraph.add(Chunk.NEWLINE);
            Date date = new Date();
            dateParagraph.add("Factura:" + idPdf + "\n" + "Fecha: " + new SimpleDateFormat("dd-mm-yyyy").format(date) + "\n\n");

            PdfPTable headerTable = new PdfPTable(3);
            headerTable.setWidthPercentage(100);
            headerTable.getDefaultCell().setBorder(0);
            float[] headerColumn = new float[]{20f, 50f, 30f};
            headerTable.setWidths(headerColumn);
            headerTable.setHorizontalAlignment(Element.ALIGN_LEFT);

            String storeType = "Tienda de abarrotes";
            String storeName = "El Rodri";
            String storeTelephone = "9991234562";
            String storeDir = "Calle 34 # 234";
            String documentDescription = "Ticket de compra";

            headerTable.addCell("");
            headerTable.addCell(storeType + "\nNombre: " + storeName + "\nTelefono: " + storeTelephone + "\nDireccion: " + storeDir + "\nRazon: " + documentDescription);
            headerTable.addCell(dateParagraph);
            document.add(headerTable);

            Paragraph clientParagraph = new Paragraph();
            clientParagraph.add(Chunk.NEWLINE);
            clientParagraph.add("Datos de los clientes" + "\n\n");
            document.add(clientParagraph);

            PdfPTable clientTable = new PdfPTable(3);
            clientTable.setWidthPercentage(100);
            clientTable.getDefaultCell().setBorder(0);
            float[] Columnacli = new float[]{20f, 50f, 30f};
            clientTable.setWidths(Columnacli);
            clientTable.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell clientCell1 = new PdfPCell(new Phrase("Id", negrita));
            PdfPCell clientCell2 = new PdfPCell(new Phrase("Dni", negrita));
            PdfPCell clientCell3 = new PdfPCell(new Phrase("Nombre", negrita));
            clientCell1.setBorder(0);
            clientCell2.setBorder(0);
            clientCell3.setBorder(0);
            clientTable.addCell(clientCell1);
            clientTable.addCell(clientCell2);
            clientTable.addCell(clientCell3);
            clientTable.addCell(view.idClientTxt.getText());
            clientTable.addCell(view.clientIdTxt.getText());
            clientTable.addCell(view.clientNomTxt.getText());

            document.add(clientTable);

            //productos
            PdfPTable productTable = new PdfPTable(4);
            productTable.setWidthPercentage(100);
            productTable.getDefaultCell().setBorder(0);
            float[] productColumn = new float[]{10f, 50f, 15f, 20f};
            productTable.setWidths(productColumn);
            productTable.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell productCell1 = new PdfPCell(new Phrase("Nombre", negrita));
            PdfPCell productCell2 = new PdfPCell(new Phrase("Cantidad", negrita));
            PdfPCell productCell3 = new PdfPCell(new Phrase("Precio U.", negrita));
            PdfPCell productCell4 = new PdfPCell(new Phrase("Precio T.", negrita));
            productCell1.setBorder(0);
            productCell2.setBorder(0);
            productCell3.setBorder(0);
            productCell4.setBorder(0);
            productCell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            productCell2.setBackgroundColor(BaseColor.LIGHT_GRAY);
            productCell3.setBackgroundColor(BaseColor.LIGHT_GRAY);
            productCell4.setBackgroundColor(BaseColor.LIGHT_GRAY);
            productTable.addCell(productCell1);
            productTable.addCell(productCell2);
            productTable.addCell(productCell3);
            productTable.addCell(productCell4);
            for (int i = 0; i < view.tablaProdVenta.getRowCount(); i++) {
                String producto = view.tablaProdVenta.getValueAt(i, 2).toString();
                String cantidad = view.tablaProdVenta.getValueAt(i, 3).toString();
                String precio = view.tablaProdVenta.getValueAt(i, 4).toString();
                String total = view.tablaProdVenta.getValueAt(i, 5).toString();
                productTable.addCell(cantidad);
                productTable.addCell(producto);
                productTable.addCell(precio);
                productTable.addCell(total);
            }
            document.add(productTable);

            Paragraph infoParagraph = new Paragraph();
            infoParagraph.add(Chunk.NEWLINE);
            infoParagraph.add("Total a Pagar: " + view.totalTxt.getText());
            infoParagraph.setAlignment(Element.ALIGN_RIGHT);
            document.add(infoParagraph);

            Paragraph singParagraph = new Paragraph();
            singParagraph.add(Chunk.NEWLINE);
            singParagraph.add("\n\nCancelación y Firma\n\n");
            singParagraph.add("------------------------");
            singParagraph.setAlignment(Element.ALIGN_CENTER);
            document.add(singParagraph);

            Paragraph messageParagraph = new Paragraph();
            messageParagraph.add(Chunk.NEWLINE);
            messageParagraph.add("Gracias por su Compra");
            messageParagraph.setAlignment(Element.ALIGN_CENTER);
            document.add(messageParagraph);
            document.close();
            fileOutputStream.close();
            Desktop.getDesktop().open(file);
        } catch (DocumentException | IOException e) {
            System.out.println(e.toString());
        }
    }
    
}
