/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;


public class Pembayaran extends javax.swing.JFrame {
    
    DefaultTableModel modelTblPbl;
    private KoneksiDatabase dbConnection;
    DecimalFormat df=new DecimalFormat("#,###");
    
    public Pembayaran() {
        initComponents();
        this.dbConnection = KoneksiDatabase.getInstance();
        getDataBarang();
        System.out.println(getSize());
//        getContentPane().setBackground(new Color(71,73,115));
    }
    
    void getAdminBio(String nama, int id){
        this.namaAdmin.setText(nama);
        this.idAdmin.setText(String.valueOf(id));
    }
    
    public static void main(String[] args) {
        new Pembayaran().show();
    }
    
    void getDataBarang(){
        listKategoriBarang.addItem("Semua");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        namaAdmin = new javax.swing.JLabel();
        jumlahBarangYangDibeli = new javax.swing.JTextField();
        idAdmin = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelPembelianBarang = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        totalHargaKeseluruhan = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        potonganDiskon = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        hargaAkhir = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        buttonTambah = new javax.swing.JButton();
        listKategoriBarang = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        listNamaBarang = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        tombolUbah = new javax.swing.JButton();
        tombolHapus = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        searchByTelp = new javax.swing.JTextField();
        statusMember = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(71, 73, 115));

        jPanel1.setBackground(new java.awt.Color(14, 41, 84));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(166, 156, 172));
        jLabel1.setText("Pembayaran");

        namaAdmin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        namaAdmin.setForeground(new java.awt.Color(241, 218, 196));
        namaAdmin.setText("jLabel2");

        jumlahBarangYangDibeli.setBackground(new java.awt.Color(14, 41, 84));
        jumlahBarangYangDibeli.setForeground(new java.awt.Color(241, 218, 196));
        jumlahBarangYangDibeli.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(170, 165, 159)));

        idAdmin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idAdmin.setForeground(new java.awt.Color(241, 218, 196));
        idAdmin.setText("jLabel2");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(166, 156, 172));
        jLabel7.setText("Total Harga");

        tabelPembelianBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Barang", "Nama Barang", "Kategori", "Jumlah", "Harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelPembelianBarang.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelPembelianBarang);
        if (tabelPembelianBarang.getColumnModel().getColumnCount() > 0) {
            tabelPembelianBarang.getColumnModel().getColumn(0).setResizable(false);
            tabelPembelianBarang.getColumnModel().getColumn(0).setPreferredWidth(20);
            tabelPembelianBarang.getColumnModel().getColumn(1).setResizable(false);
            tabelPembelianBarang.getColumnModel().getColumn(1).setPreferredWidth(150);
            tabelPembelianBarang.getColumnModel().getColumn(2).setResizable(false);
            tabelPembelianBarang.getColumnModel().getColumn(3).setResizable(false);
            tabelPembelianBarang.getColumnModel().getColumn(3).setPreferredWidth(20);
            tabelPembelianBarang.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(166, 156, 172));
        jLabel8.setText("Diskon  10%");

        totalHargaKeseluruhan.setForeground(new java.awt.Color(241, 218, 196));
        totalHargaKeseluruhan.setText("Rp 0");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(166, 156, 172));
        jLabel2.setText("Nama Admin : ");

        potonganDiskon.setForeground(new java.awt.Color(241, 218, 196));
        potonganDiskon.setText("Rp 0");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(166, 156, 172));
        jLabel3.setText("ID                  :");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(166, 156, 172));
        jLabel9.setText("Harga Akhir");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(166, 156, 172));
        jLabel4.setText("Kategori");

        hargaAkhir.setForeground(new java.awt.Color(241, 218, 196));
        hargaAkhir.setText("Rp 0");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(166, 156, 172));
        jLabel5.setText("Jumlah");

        buttonTambah.setBackground(new java.awt.Color(241, 218, 196));
        buttonTambah.setText("Tambah");
        buttonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTambahActionPerformed(evt);
            }
        });

        listKategoriBarang.setBackground(new java.awt.Color(31, 110, 140));
        listKategoriBarang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        listKategoriBarang.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                listKategoriBarangComponentAdded(evt);
            }
        });
        listKategoriBarang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                listKategoriBarangFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                listKategoriBarangFocusLost(evt);
            }
        });
        listKategoriBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listKategoriBarangMouseClicked(evt);
            }
        });
        listKategoriBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listKategoriBarangActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(166, 156, 172));
        jLabel6.setText("Nama Barang");

        listNamaBarang.setBackground(new java.awt.Color(31, 110, 140));
        listNamaBarang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        listNamaBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listNamaBarangActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(166, 156, 172));
        jLabel10.setText("Status");

        tombolUbah.setBackground(new java.awt.Color(241, 218, 196));
        tombolUbah.setText("Ubah");
        tombolUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolUbahActionPerformed(evt);
            }
        });

        tombolHapus.setBackground(new java.awt.Color(241, 218, 196));
        tombolHapus.setText("Hapus");
        tombolHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolHapusActionPerformed(evt);
            }
        });

        jToggleButton1.setBackground(new java.awt.Color(241, 218, 196));
        jToggleButton1.setText("Daftar");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(166, 156, 172));
        jLabel11.setText("Search By Telp");

        jLabel12.setForeground(new java.awt.Color(241, 218, 196));

        searchByTelp.setBackground(new java.awt.Color(14, 41, 84));
        searchByTelp.setForeground(new java.awt.Color(241, 218, 196));
        searchByTelp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(170, 165, 159)));
        searchByTelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchByTelpActionPerformed(evt);
            }
        });

        statusMember.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        statusMember.setForeground(new java.awt.Color(166, 156, 172));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(578, 578, 578)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(totalHargaKeseluruhan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(potonganDiskon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hargaAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(namaAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(buttonTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(9, 9, 9)
                                            .addComponent(tombolUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(tombolHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(listNamaBarang, 0, 279, Short.MAX_VALUE)
                                            .addComponent(listKategoriBarang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jumlahBarangYangDibeli)
                                            .addComponent(searchByTelp)
                                            .addComponent(statusMember, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(229, 229, 229))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(84, 84, 84)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(namaAdmin)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idAdmin)
                            .addComponent(jLabel3))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(listKategoriBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(listNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jumlahBarangYangDibeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchByTelp))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(statusMember, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonTambah)
                            .addComponent(tombolUbah)
                            .addComponent(tombolHapus)
                            .addComponent(jToggleButton1)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalHargaKeseluruhan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(potonganDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(hargaAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(488, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listNamaBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listNamaBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listNamaBarangActionPerformed

    private void listKategoriBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listKategoriBarangActionPerformed
        // TODO add your handling code here:
        try{
            if(listKategoriBarang.getSelectedItem().toString().equals("Semua")){
                Statement st1 = dbConnection.getConnection().createStatement();
                String query1 = String.format("Select distinct(kategori_barang) as kb from tabel_barang;");
                ResultSet rs1 = st1.executeQuery(query1);
                listKategoriBarang.setModel(new javax.swing.DefaultComboBoxModel<>());
                getDataBarang();
                listNamaBarang.setModel(new javax.swing.DefaultComboBoxModel<>());
                while(rs1.next()){
                    listKategoriBarang.addItem(rs1.getString("kb"));
                }
                String query2 = String.format("Select nama_barang from tabel_barang;");
                ResultSet rs2 = st1.executeQuery(query2);
                while(rs2.next()){
                    listNamaBarang.addItem(rs2.getString("nama_barang"));
                    System.out.println("Hehehehe");
                }
            }else{
                System.out.println("Hahahah");
                Statement st1 = dbConnection.getConnection().createStatement();
                String query2 = String.format("Select nama_barang from tabel_barang where kategori_barang = \"%s\";", this.listKategoriBarang.getSelectedItem().toString());
                System.out.println(this.listKategoriBarang.getSelectedItem().toString());
                ResultSet rs2 = st1.executeQuery(query2);
                listNamaBarang.setModel(new javax.swing.DefaultComboBoxModel<>());
                while(rs2.next()){
                    listNamaBarang.addItem(rs2.getString("nama_barang"));
                    System.out.println("HAHAHAH");
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_listKategoriBarangActionPerformed

    private void listKategoriBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listKategoriBarangMouseClicked
        // TODO add your handling code here:
        //        System.out.println(listKategoriBarang.getSelectedItem());
    }//GEN-LAST:event_listKategoriBarangMouseClicked

    private void listKategoriBarangFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_listKategoriBarangFocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_listKategoriBarangFocusLost

    private void listKategoriBarangFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_listKategoriBarangFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_listKategoriBarangFocusGained

    private void listKategoriBarangComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_listKategoriBarangComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_listKategoriBarangComponentAdded

    private void buttonTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTambahActionPerformed
        // TODO add your handling code here:
        modelTblPbl = (DefaultTableModel) tabelPembelianBarang.getModel();
        System.out.println(this.jumlahBarangYangDibeli.getText());
        System.out.println(this.jumlahBarangYangDibeli.getText().matches("\\d*"));
        if(!this.jumlahBarangYangDibeli.getText().matches("\\d*")){
            JOptionPane.showMessageDialog(this, "Mohon input jumlah yang valid!");
        }else if (this.jumlahBarangYangDibeli.getText().matches("\\d*") && Integer.parseInt(this.jumlahBarangYangDibeli.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "Mohon input jumlah yang valid!");
        } else if(this.jumlahBarangYangDibeli.getText().matches("\\d*") && Integer.parseInt(this.jumlahBarangYangDibeli.getText()) > 0){
            try{
                Statement st1 = dbConnection.getConnection().createStatement();
                String query1 = String.format("Select id_barang, kategori_barang, harga_barang from tabel_barang where nama_barang = \"%s\";", this.listNamaBarang.getSelectedItem().toString());
                ResultSet rs1 = st1.executeQuery(query1);
                int hargaSeluruh = 0;
                while(rs1.next()){
                    modelTblPbl.addRow(new Object[]{rs1.getString("id_barang"), this.listNamaBarang.getSelectedItem().toString(),rs1.getString("kategori_barang"), this.jumlahBarangYangDibeli.getText(),df.format(Integer.parseInt(rs1.getString("harga_barang")) * Integer.parseInt(jumlahBarangYangDibeli.getText()))});
                }

                ArrayList<String> harga1 = new ArrayList<String>();
                int jumlahData = modelTblPbl.getRowCount();
                for(int i = 0; i < jumlahData; i++){
                    String harga2 = String.valueOf( modelTblPbl.getValueAt(i, 4));
                    String[] jumlahHarga = harga2.split(",");
                    for(String harga3: jumlahHarga){
                        harga1.add(harga3);
                    }
                }

                this.totalHargaKeseluruhan.setText("Rp"+df.format(Integer.parseInt(String.join("", harga1))));

            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_buttonTambahActionPerformed

    private void tombolUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolUbahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tombolUbahActionPerformed

    private void tombolHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolHapusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tombolHapusActionPerformed

    private void searchByTelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchByTelpActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_searchByTelpActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonTambah;
    private javax.swing.JLabel hargaAkhir;
    private javax.swing.JLabel idAdmin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField jumlahBarangYangDibeli;
    private javax.swing.JComboBox<String> listKategoriBarang;
    private javax.swing.JComboBox<String> listNamaBarang;
    private javax.swing.JLabel namaAdmin;
    private javax.swing.JLabel potonganDiskon;
    private javax.swing.JTextField searchByTelp;
    private javax.swing.JLabel statusMember;
    private javax.swing.JTable tabelPembelianBarang;
    private javax.swing.JButton tombolHapus;
    private javax.swing.JButton tombolUbah;
    private javax.swing.JLabel totalHargaKeseluruhan;
    // End of variables declaration//GEN-END:variables
}
