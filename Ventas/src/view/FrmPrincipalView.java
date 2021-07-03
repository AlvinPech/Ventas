package view;


import controller.ClientController;
import controller.ProductController;
import controller.ProfitsController;
import controller.SaleController;
import controller.SaleInfoController;
import controller.VendorController;
import dao.SaleDao;
import model.Conexion;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alvin
 */
public class FrmPrincipalView extends javax.swing.JFrame {

    /**
     * Creates new form FrmInicio
     */
    
    Conexion conexion;
    SaleDao dao = new SaleDao();
    public FrmPrincipalView() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        setIcons();
        getCalendar();
        getSerie();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        dateTxt = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        prodIdTxt = new javax.swing.JTextField();
        buscarProd = new javax.swing.JButton();
        AgregarProd = new javax.swing.JButton();
        prodNomTxt = new javax.swing.JTextField();
        productLabel = new javax.swing.JLabel();
        cantidadNum = new javax.swing.JSpinner();
        jPanel5 = new javax.swing.JPanel();
        clientIdTxt = new javax.swing.JTextField();
        clientNomTxt = new javax.swing.JTextField();
        clientLabel = new javax.swing.JLabel();
        buscarClient = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProdVenta = new javax.swing.JTable();
        serieTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        idClientTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        cancelSaleBtn = new javax.swing.JButton();
        generateSaleBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        totalTxt = new javax.swing.JTextField();
        removeProductBtn = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        systemMenu = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        salesMenu = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        addClient = new javax.swing.JMenu();
        addClientItem = new javax.swing.JMenuItem();
        vendorJMenu = new javax.swing.JMenu();
        addVendorItem = new javax.swing.JMenuItem();
        addProductItem = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();

        jMenuItem4.setText("jMenuItem4");

        jMenuItem6.setText("jMenuItem6");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(153, 204, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Sinhala Sangam MN", 1, 24)); // NOI18N
        jLabel1.setText("Tiendita \"El Rodri\"");

        dateTxt.setBackground(new java.awt.Color(231, 239, 255));
        dateTxt.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        dateTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dateTxt.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(dateTxt)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(473, 473, 473))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        prodIdTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        prodIdTxt.setSelectionColor(new java.awt.Color(231, 239, 255));

        AgregarProd.setText("AGREGAR PRODUCTO");
        AgregarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarProdActionPerformed(evt);
            }
        });

        prodNomTxt.setEditable(false);
        prodNomTxt.setBackground(new java.awt.Color(231, 239, 255));
        prodNomTxt.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        prodNomTxt.setEnabled(false);

        productLabel.setText("DATOS PRODUCTO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(productLabel)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(prodIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(AgregarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cantidadNum, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(prodNomTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buscarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(productLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buscarProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(prodIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prodNomTxt))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cantidadNum, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AgregarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setPreferredSize(new java.awt.Dimension(12, 147));

        clientIdTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        clientIdTxt.setSelectionColor(new java.awt.Color(231, 239, 255));

        clientNomTxt.setEditable(false);
        clientNomTxt.setBackground(new java.awt.Color(231, 239, 255));
        clientNomTxt.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        clientNomTxt.setEnabled(false);

        clientLabel.setText("DATOS CLIENTE");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(clientIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clientNomTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buscarClient, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(clientLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(clientLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(clientNomTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(clientIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buscarClient, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tablaProdVenta.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        tablaProdVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NUMERO", "CODIGO", "NOMBRE", "CANTIDAD", "PRECIO UNITARIO", "COSTO"
            }
        ));
        jScrollPane1.setViewportView(tablaProdVenta);
        if (tablaProdVenta.getColumnModel().getColumnCount() > 0) {
            tablaProdVenta.getColumnModel().getColumn(0).setHeaderValue("NUMERO");
            tablaProdVenta.getColumnModel().getColumn(1).setHeaderValue("CODIGO");
            tablaProdVenta.getColumnModel().getColumn(2).setHeaderValue("NOMBRE");
            tablaProdVenta.getColumnModel().getColumn(3).setHeaderValue("CANTIDAD");
            tablaProdVenta.getColumnModel().getColumn(4).setHeaderValue("PRECIO UNITARIO");
            tablaProdVenta.getColumnModel().getColumn(5).setHeaderValue("COSTO");
        }

        serieTxt.setBackground(new java.awt.Color(231, 239, 255));
        serieTxt.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        serieTxt.setEnabled(false);

        jLabel6.setText("NRO. SERIE");

        idClientTxt.setEditable(false);
        idClientTxt.setBackground(new java.awt.Color(231, 239, 255));
        idClientTxt.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        idClientTxt.setForeground(new java.awt.Color(255, 255, 255));
        idClientTxt.setEnabled(false);

        jLabel8.setText("CLIENTE");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(314, 314, 314)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(idClientTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(serieTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serieTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(idClientTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cancelSaleBtn.setBackground(new java.awt.Color(255, 255, 255));
        cancelSaleBtn.setForeground(new java.awt.Color(255, 0, 0));
        cancelSaleBtn.setText("CANCELAR");

        generateSaleBtn.setBackground(new java.awt.Color(255, 255, 255));
        generateSaleBtn.setForeground(new java.awt.Color(51, 150, 49));
        generateSaleBtn.setText("GENERAR VENTA");

        jLabel7.setText("TOTAL A PAGAR");

        totalTxt.setBackground(new java.awt.Color(231, 239, 255));
        totalTxt.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        totalTxt.setEnabled(false);

        removeProductBtn.setText("QUITAR SELECCIONADO");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cancelSaleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(generateSaleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeProductBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(totalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelSaleBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(generateSaleBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addComponent(totalTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(removeProductBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jMenuBar1.setBackground(java.awt.SystemColor.textHighlight);
        jMenuBar1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N

        systemMenu.setText("Sistema");

        jMenuItem3.setText("Salir");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        systemMenu.add(jMenuItem3);

        jMenuBar1.add(systemMenu);

        salesMenu.setText("Ventas");

        jMenuItem2.setText("Ventas realizadas");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem2MouseClicked(evt);
            }
        });
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        salesMenu.add(jMenuItem2);

        jMenuItem1.setText("Utilidad semanal");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        salesMenu.add(jMenuItem1);

        jMenuBar1.add(salesMenu);

        addClient.setText("Cliente");
        addClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addClientMouseClicked(evt);
            }
        });

        addClientItem.setText("Agregar");
        addClientItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addClientItemActionPerformed(evt);
            }
        });
        addClient.add(addClientItem);

        jMenuBar1.add(addClient);

        vendorJMenu.setText("Proveedores");
        vendorJMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vendorJMenuMouseClicked(evt);
            }
        });

        addVendorItem.setText("Agregar");
        addVendorItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addVendorItemActionPerformed(evt);
            }
        });
        vendorJMenu.add(addVendorItem);

        jMenuBar1.add(vendorJMenu);

        addProductItem.setText("Producto");
        addProductItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addProductItemMouseClicked(evt);
            }
        });
        addProductItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductItemActionPerformed(evt);
            }
        });

        jMenuItem5.setText("Agregar");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        addProductItem.add(jMenuItem5);

        jMenuBar1.add(addProductItem);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addProductItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductItemActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_addProductItemActionPerformed

    private void addProductItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addProductItemMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_addProductItemMouseClicked

    private void addClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addClientMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_addClientMouseClicked

    private void vendorJMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vendorJMenuMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_vendorJMenuMouseClicked

    private void jMenuItem2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenuItem2MouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        FrmSaleInfo view = new FrmSaleInfo();
        SaleInfoController controller = new SaleInfoController(view);
        view.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void addVendorItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addVendorItemActionPerformed
        // TODO add your handling code here:
        FrmVendor view = new FrmVendor();
        VendorController controller = new VendorController(view);
        view.setVisible(true);
    }//GEN-LAST:event_addVendorItemActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        FrmProfits view = new FrmProfits();
        ProfitsController controller = new ProfitsController(view);
        view.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        FrmProduct  view = new FrmProduct();
        ProductController controller = new ProductController(view);
        view.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void AgregarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AgregarProdActionPerformed

    private void addClientItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addClientItemActionPerformed
        // TODO add your handling code here:
        FrmClient  view = new FrmClient();
        ClientController controller = new ClientController(view);
        view.setVisible(true);
    }//GEN-LAST:event_addClientItemActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FrmPrincipalView  view = new FrmPrincipalView();
        ClientController controller = new ClientController(view);
        SaleController saleCon = new SaleController(view);
        ProductController productCon = new ProductController(view);
        SaleInfoController infoSale = new SaleInfoController(view);
        view.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton AgregarProd;
    private javax.swing.JMenu addClient;
    private javax.swing.JMenuItem addClientItem;
    private javax.swing.JMenu addProductItem;
    private javax.swing.JMenuItem addVendorItem;
    public javax.swing.JButton buscarClient;
    public javax.swing.JButton buscarProd;
    public javax.swing.JButton cancelSaleBtn;
    public javax.swing.JSpinner cantidadNum;
    public javax.swing.JTextField clientIdTxt;
    private javax.swing.JLabel clientLabel;
    public javax.swing.JTextField clientNomTxt;
    public javax.swing.JTextField dateTxt;
    public javax.swing.JButton generateSaleBtn;
    public javax.swing.JTextField idClientTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField prodIdTxt;
    public javax.swing.JTextField prodNomTxt;
    private javax.swing.JLabel productLabel;
    public javax.swing.JButton removeProductBtn;
    private javax.swing.JMenu salesMenu;
    public javax.swing.JTextField serieTxt;
    private javax.swing.JMenu systemMenu;
    public javax.swing.JTable tablaProdVenta;
    public javax.swing.JTextField totalTxt;
    private javax.swing.JMenu vendorJMenu;
    // End of variables declaration//GEN-END:variables

    public void getCalendar() {
        Calendar calendar = new GregorianCalendar();
        dateTxt.setText(""+calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.MONTH) + 1)+"-"+calendar.get(Calendar.DAY_OF_MONTH));
    
    }

    public void getSerie() {
        String serie = dao.NumSerie();
        System.out.println("Serie"+serie);
        if(serie == null){
            serieTxt.setText("1");
            
        }else{
            int increment = Integer.parseInt(serie);
            increment = increment + 1;
            serieTxt.setText(""+increment);
        }
    }

    private void setIcons() {
        systemMenu.setIcon(new ImageIcon(getClass().getResource("/img/tools.png")));
        salesMenu.setIcon(new ImageIcon(getClass().getResource("/img/nomina.png")));
        addClient.setIcon(new ImageIcon(getClass().getResource("/img/clientes.png")));
        vendorJMenu.setIcon(new ImageIcon(getClass().getResource("/img/proveedores.png")));
        addProductItem.setIcon(new ImageIcon(getClass().getResource("/img/carrito.png")));
        
        clientLabel.setIcon(new ImageIcon(getClass().getResource("/img/user-28623.png")));
        productLabel.setIcon(new ImageIcon(getClass().getResource("/img/carrito.png")));
        AgregarProd.setIcon(new ImageIcon(getClass().getResource("/img/agregar.png")));
        cancelSaleBtn.setIcon(new ImageIcon(getClass().getResource("/img/cancelar16.png")));
        generateSaleBtn.setIcon(new ImageIcon(getClass().getResource("/img/impresora.png")));
        removeProductBtn.setIcon(new ImageIcon(getClass().getResource("/img/eliminar.png")));
        buscarClient.setIcon(new ImageIcon(getClass().getResource("/img/buscar (2).png")));
        buscarProd.setIcon(new ImageIcon(getClass().getResource("/img/buscar (2).png")));
    }
}