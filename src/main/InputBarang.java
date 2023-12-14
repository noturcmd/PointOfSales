/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer_
 */
public class InputBarang extends javax.swing.JFrame {

    private KoneksiDatabase dbConnection;
    private DefaultTableModel modelTabelBarang;
    ButtonGroup buttonStatus = new ButtonGroup();
    
    int idAdminS;
    String namaAdmins;
    
    Integer baris;
    public InputBarang() {
        this.dbConnection = KoneksiDatabase.getInstance();
        initComponents();
        setLocationRelativeTo(null);
        tampilkanDataBarang();
        this.buttonStatus.add(viaID);
        this.buttonStatus.add(exceptID);
        this.buttonStatus.add(viaAll);
        this.viaAll.setSelected(true);
        
    }
    
    void getAdminBio(String nama, int id){
        this.idAdminS = id;
        this.namaAdmins = nama;
    }
    
    void tampilkanDataBarang(){
        this.modelTabelBarang = (DefaultTableModel) tabelBarang.getModel();
        try{
            Statement st1 = this.dbConnection.getConnection().createStatement();
            String query1 = String.format("select * from tabel_barang;");
            ResultSet rs1 = st1.executeQuery(query1);
            while(rs1.next()){
                this.modelTabelBarang.addRow(new Object[]{rs1.getString(1),rs1.getString(2),rs1.getString(3),rs1.getString(4),rs1.getString(5),rs1.getString(6)});
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    void resetInput(){
        this.inpBarang.setText("");
        this.inpBrand.setText("");
        this.inpID.setText("");
        this.inpHarga.setText("");
        this.inpJumlah.setText("");
        this.inpKategori.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        viaAll = new javax.swing.JRadioButton();
        viaID = new javax.swing.JRadioButton();
        exceptID = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelBarang = new javax.swing.JTable();
        butSimpan = new javax.swing.JButton();
        butUbah = new javax.swing.JButton();
        butHapus = new javax.swing.JButton();
        butKembali = new javax.swing.JButton();
        gapID = new javax.swing.JPanel();
        kategori = new javax.swing.JLabel();
        HaBarang = new javax.swing.JLabel();
        inpHarga = new javax.swing.JTextField();
        inpKategori = new javax.swing.JTextField();
        inpID = new javax.swing.JTextField();
        ID = new javax.swing.JLabel();
        inpBarang = new javax.swing.JTextField();
        Barang = new javax.swing.JLabel();
        inpBrand = new javax.swing.JTextField();
        BrBarang = new javax.swing.JLabel();
        inpJumlah = new javax.swing.JTextField();
        JuBarang = new javax.swing.JLabel();
        butReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(71, 73, 115));

        viaAll.setForeground(new java.awt.Color(166, 156, 172));
        viaAll.setText("All");
        viaAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viaAllActionPerformed(evt);
            }
        });

        viaID.setForeground(new java.awt.Color(166, 156, 172));
        viaID.setText("ID");
        viaID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viaIDActionPerformed(evt);
            }
        });

        exceptID.setForeground(new java.awt.Color(166, 156, 172));
        exceptID.setText("Except ID");
        exceptID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exceptIDActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(166, 156, 172));
        jLabel1.setText("Stok Barang ATK");

        tabelBarang.setBackground(new java.awt.Color(166, 156, 172));
        tabelBarang.setForeground(new java.awt.Color(22, 27, 51));
        tabelBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Barang", "Nama Barang", "Brand", "Kategori", "Jumlah Barang", "Harga/pcs"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelBarang.getTableHeader().setReorderingAllowed(false);
        tabelBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelBarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelBarang);
        if (tabelBarang.getColumnModel().getColumnCount() > 0) {
            tabelBarang.getColumnModel().getColumn(0).setResizable(false);
            tabelBarang.getColumnModel().getColumn(1).setResizable(false);
            tabelBarang.getColumnModel().getColumn(2).setResizable(false);
            tabelBarang.getColumnModel().getColumn(3).setResizable(false);
            tabelBarang.getColumnModel().getColumn(4).setResizable(false);
            tabelBarang.getColumnModel().getColumn(5).setResizable(false);
        }

        butSimpan.setBackground(new java.awt.Color(241, 218, 196));
        butSimpan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        butSimpan.setText("Simpan");
        butSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butSimpanActionPerformed(evt);
            }
        });

        butUbah.setBackground(new java.awt.Color(241, 218, 196));
        butUbah.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        butUbah.setText("Ubah");
        butUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butUbahActionPerformed(evt);
            }
        });

        butHapus.setBackground(new java.awt.Color(241, 218, 196));
        butHapus.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        butHapus.setText("Hapus");
        butHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butHapusActionPerformed(evt);
            }
        });

        butKembali.setBackground(new java.awt.Color(241, 218, 196));
        butKembali.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        butKembali.setText("Kembali");
        butKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butKembaliActionPerformed(evt);
            }
        });

        gapID.setBackground(new java.awt.Color(71, 73, 115));

        kategori.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        kategori.setForeground(new java.awt.Color(166, 156, 172));
        kategori.setText("Kategori");

        HaBarang.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        HaBarang.setForeground(new java.awt.Color(166, 156, 172));
        HaBarang.setText("Harga / pcs");

        inpHarga.setBackground(new java.awt.Color(71, 73, 115));
        inpHarga.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        inpHarga.setForeground(new java.awt.Color(166, 156, 172));
        inpHarga.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(170, 165, 159)));

        inpKategori.setBackground(new java.awt.Color(71, 73, 115));
        inpKategori.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        inpKategori.setForeground(new java.awt.Color(166, 156, 172));
        inpKategori.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(170, 165, 159)));

        inpID.setBackground(new java.awt.Color(71, 73, 115));
        inpID.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        inpID.setForeground(new java.awt.Color(166, 156, 172));
        inpID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(170, 165, 159)));
        inpID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpIDActionPerformed(evt);
            }
        });

        ID.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        ID.setForeground(new java.awt.Color(166, 156, 172));
        ID.setText("ID Barang");

        inpBarang.setBackground(new java.awt.Color(71, 73, 115));
        inpBarang.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        inpBarang.setForeground(new java.awt.Color(166, 156, 172));
        inpBarang.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(170, 165, 159)));

        Barang.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        Barang.setForeground(new java.awt.Color(166, 156, 172));
        Barang.setText("Nama Barang");

        inpBrand.setBackground(new java.awt.Color(71, 73, 115));
        inpBrand.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        inpBrand.setForeground(new java.awt.Color(166, 156, 172));
        inpBrand.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(170, 165, 159)));

        BrBarang.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        BrBarang.setForeground(new java.awt.Color(166, 156, 172));
        BrBarang.setText("Brand");

        inpJumlah.setBackground(new java.awt.Color(71, 73, 115));
        inpJumlah.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        inpJumlah.setForeground(new java.awt.Color(166, 156, 172));
        inpJumlah.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(170, 165, 159)));

        JuBarang.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        JuBarang.setForeground(new java.awt.Color(166, 156, 172));
        JuBarang.setText("Jumlah");

        javax.swing.GroupLayout gapIDLayout = new javax.swing.GroupLayout(gapID);
        gapID.setLayout(gapIDLayout);
        gapIDLayout.setHorizontalGroup(
            gapIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gapIDLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gapIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gapIDLayout.createSequentialGroup()
                        .addComponent(ID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(inpID, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gapIDLayout.createSequentialGroup()
                        .addComponent(BrBarang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(inpBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gapIDLayout.createSequentialGroup()
                        .addComponent(Barang)
                        .addGap(0, 17, Short.MAX_VALUE)
                        .addComponent(inpBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gapIDLayout.createSequentialGroup()
                        .addComponent(JuBarang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(inpJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gapIDLayout.createSequentialGroup()
                        .addComponent(kategori)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(inpKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gapIDLayout.createSequentialGroup()
                        .addComponent(HaBarang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(inpHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        gapIDLayout.setVerticalGroup(
            gapIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gapIDLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(gapIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ID)
                    .addComponent(inpID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(gapIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Barang)
                    .addComponent(inpBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gapIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BrBarang)
                    .addComponent(inpBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(gapIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inpKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kategori))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(gapIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(inpJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JuBarang))
                .addGap(18, 18, 18)
                .addGroup(gapIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HaBarang)
                    .addComponent(inpHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        butReset.setBackground(new java.awt.Color(241, 218, 196));
        butReset.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        butReset.setText("Reset");
        butReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(butKembali)
                .addGap(27, 27, 27)
                .addComponent(butSimpan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(butReset, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(butHapus)
                .addGap(18, 18, 18)
                .addComponent(butUbah)
                .addGap(116, 116, 116))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(447, 447, 447)
                .addComponent(jLabel1)
                .addContainerGap(455, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(viaID)
                        .addGap(18, 18, 18)
                        .addComponent(exceptID)
                        .addGap(18, 18, 18)
                        .addComponent(viaAll))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(gapID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(viaAll)
                            .addComponent(viaID)
                            .addComponent(exceptID))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(gapID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butKembali)
                    .addComponent(butSimpan)
                    .addComponent(butReset)
                    .addComponent(butHapus)
                    .addComponent(butUbah))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSimpanActionPerformed
        // TODO add your handling code here:
        if(this.inpBarang.getText().isBlank() && this.inpBrand.getText().isBlank() && this.inpHarga.getText().isBlank() && this.inpID.getText().isBlank() && this.inpJumlah.getText().isBlank() && this.inpKategori.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Mohon tidak mengosongkan input!");
        }else{
            try{
                Statement st1 = this.dbConnection.getConnection().createStatement();
                String query1 = String.format("select * from tabel_barang where id_barang = \"%s\";", this.inpID.getText());
                ResultSet rs1 = st1.executeQuery(query1);
                if(rs1.next()){
                    JOptionPane.showMessageDialog(this, "Barang tersebut sudah ada!");
                }else{
                    try{
                        Statement st2 = this.dbConnection.getConnection().createStatement();
                        String query2 = String.format("insert into tabel_barang (id_barang, nama_barang, brand_barang, kategori_barang, jumlah_barang, harga_barang) values(\"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\")", this.inpID.getText(), this.inpBarang.getText(), this.inpBrand.getText(), this.inpKategori.getText(), this.inpJumlah.getText(), this.inpHarga.getText());
                        st2.executeUpdate(query2);
                        JOptionPane.showMessageDialog(this, "Berhasil ditambahkan!");
                        this.modelTabelBarang.setRowCount(0);
                        tampilkanDataBarang();
                        this.resetInput();
                    }catch(SQLException e){
                        e.printStackTrace();
                    }
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_butSimpanActionPerformed

    private void tabelBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelBarangMouseClicked
        // TODO add your handling code here:
        this.baris = tabelBarang.getSelectedRow();
        this.inpBarang.setText((String) tabelBarang.getValueAt(this.baris, 1));
        this.inpBrand.setText((String) tabelBarang.getValueAt(this.baris, 2));
        this.inpID.setText((String) tabelBarang.getValueAt(this.baris, 0));
        this.inpHarga.setText((String) tabelBarang.getValueAt(this.baris, 5));
        this.inpJumlah.setText((String) tabelBarang.getValueAt(this.baris, 4));
        this.inpKategori.setText((String) tabelBarang.getValueAt(this.baris, 3));
    }//GEN-LAST:event_tabelBarangMouseClicked

    private void butUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butUbahActionPerformed
        // TODO add your handling code here:
        if(this.baris == null){
            JOptionPane.showMessageDialog(this, "Mohon memilih data!");
        }else{
            if(this.viaID.isSelected()){
                this.inpID.setVisible(true);
                try{
                Statement st1 = this.dbConnection.getConnection().createStatement();
                String query1 = String.format("select id_barang from tabel_barang where id_barang = \"%s\";", this.inpID.getText());
                ResultSet rs1 = st1.executeQuery(query1);
                if(rs1.next()){
                    JOptionPane.showMessageDialog(this, "Barang tersebut sudah ada!");
                }else{
                    try{
                        Statement st2 = this.dbConnection.getConnection().createStatement();
                        String query2 = String.format("update tabel_barang set id_barang = \"%s\" where id_barang= \"%s\";",this.inpID.getText(), this.tabelBarang.getValueAt(this.baris, 0));
                        st2.executeUpdate(query2);
                        JOptionPane.showMessageDialog(this, "Data ID berhasil diubah!");
                        this.modelTabelBarang.setRowCount(0);
                        tampilkanDataBarang();
                        this.resetInput();
                        this.baris = null;
                        }catch(SQLException e){
                            e.printStackTrace();
                        }
                    }
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }else if(this.exceptID.isSelected()){
                this.inpID.setVisible(false);
                try{
                        Statement st2 = this.dbConnection.getConnection().createStatement();
                        String query2 = String.format("update tabel_barang set nama_barang= \"%s\", brand_barang= \"%s\", kategori_barang= \"%s\", jumlah_barang= \"%s\", harga_barang= \"%s\" where id_barang= \"%s\";",this.inpBarang.getText(), this.inpBrand.getText(), this.inpKategori.getText(), this.inpJumlah.getText(), this.inpHarga.getText(), this.tabelBarang.getValueAt(this.baris, 0));
                        st2.executeUpdate(query2);
                        JOptionPane.showMessageDialog(this, "Data berhasil diubah!");
                        this.modelTabelBarang.setRowCount(0);
                        tampilkanDataBarang();
                        this.resetInput();
                        this.baris = null;
                }catch(SQLException e){
                    e.printStackTrace();
                }  
            }else if(this.viaAll.isSelected()){
                try{
                Statement st1 = this.dbConnection.getConnection().createStatement();
                String query1 = String.format("select id_barang from tabel_barang where id_barang = \"%s\";", this.inpID.getText());
                ResultSet rs1 = st1.executeQuery(query1);
                if(rs1.next()){
                    JOptionPane.showMessageDialog(this, "Barang tersebut sudah ada!");
                }else{
                    try{
                        Statement st2 = this.dbConnection.getConnection().createStatement();
                        String query2 = String.format("update tabel_barang set id_barang = \"%s\", nama_barang= \"%s\", brand_barang= \"%s\", kategori_barang= \"%s\", jumlah_barang= \"%s\", harga_barang= \"%s\" where id_barang= \"%s\";",this.inpID.getText(), this.inpBarang.getText(), this.inpBrand.getText(), this.inpKategori.getText(), this.inpJumlah.getText(), this.inpHarga.getText(), this.tabelBarang.getValueAt(this.baris, 0));
                        st2.executeUpdate(query2);
                        JOptionPane.showMessageDialog(this, "Data berhasil diubah!");
                        this.modelTabelBarang.setRowCount(0);
                        tampilkanDataBarang();
                        this.resetInput();
                        this.baris = null;
                        }catch(SQLException e){
                            e.printStackTrace();
                        }
                    }
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_butUbahActionPerformed

    private void viaIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viaIDActionPerformed
        // TODO add your handling code here:
        if(this.viaID.isSelected()){
            this.ID.setVisible(true);
            this.inpBarang.setVisible(false);
            this.inpBrand.setVisible(false);
            this.inpID.setVisible(true);
            this.inpHarga.setVisible(false);
            this.inpJumlah.setVisible(false);
            this.inpKategori.setVisible(false);
            this.Barang.setVisible(false);
            this.JuBarang.setVisible(false);
            this.kategori.setVisible(false);
            this.HaBarang.setVisible(false);
            this.BrBarang.setVisible(false);
        }
    }//GEN-LAST:event_viaIDActionPerformed

    private void butKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butKembaliActionPerformed
        // TODO add your handling code here:
        MainMenu exitMember = new MainMenu(this.namaAdmins, this.idAdminS);
        exitMember.setVisible(true);
        this.dispose();  
    }//GEN-LAST:event_butKembaliActionPerformed

    private void butHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butHapusActionPerformed
        // TODO add your handling code here:
        if(this.baris == null){
            JOptionPane.showMessageDialog(this, "Tidak ada baris yang dipilih!");
        }else{
            try{
                String getID = (String) tabelBarang.getValueAt(this.baris, 0);
                Statement st1 = dbConnection.getConnection().createStatement();
                String query1 = String.format("delete from tabel_barang where id_barang = \"%s\";", getID);
                st1.executeUpdate(query1);
            }catch(SQLException e){
                e.printStackTrace();
            }
            this.modelTabelBarang.removeRow(this.baris);
            this.baris = null;
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
            this.resetInput();
            
        }
    }//GEN-LAST:event_butHapusActionPerformed

    private void exceptIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exceptIDActionPerformed
        // TODO add your handling code here:
        if(this.exceptID.isSelected()){
            this.inpBarang.setVisible(true);
            this.inpBrand.setVisible(true);
            this.inpID.setVisible(false);
            this.inpHarga.setVisible(true);
            this.inpJumlah.setVisible(true);
            this.inpKategori.setVisible(true);
            this.Barang.setVisible(true);
            this.JuBarang.setVisible(true);
            this.kategori.setVisible(true);
            this.HaBarang.setVisible(true);
            this.BrBarang.setVisible(true);
            this.ID.setVisible(false);
        }
    }//GEN-LAST:event_exceptIDActionPerformed

    private void viaAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viaAllActionPerformed
        // TODO add your handling code here:
        if(this.viaAll.isSelected()){
            this.inpBarang.setVisible(true);
            this.inpBrand.setVisible(true);
            this.inpID.setVisible(true);
            this.inpHarga.setVisible(true);
            this.inpJumlah.setVisible(true);
            this.inpKategori.setVisible(true);
            this.Barang.setVisible(true);
            this.JuBarang.setVisible(true);
            this.kategori.setVisible(true);
            this.HaBarang.setVisible(true);
            this.BrBarang.setVisible(true);
            this.ID.setVisible(true);
        }
    }//GEN-LAST:event_viaAllActionPerformed

    private void butResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butResetActionPerformed
        // TODO add your handling code here:
        this.inpBarang.setText("");
        this.inpBrand.setText("");
        this.inpID.setText("");
        this.inpHarga.setText("");
        this.inpJumlah.setText("");
        this.inpKategori.setText("");
        this.Barang.setVisible(true);
        this.JuBarang.setVisible(true);
        this.kategori.setVisible(true);
        this.HaBarang.setVisible(true);
        this.BrBarang.setVisible(true);
        this.ID.setVisible(true);
    }//GEN-LAST:event_butResetActionPerformed

    private void inpIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpIDActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Barang;
    private javax.swing.JLabel BrBarang;
    private javax.swing.JLabel HaBarang;
    private javax.swing.JLabel ID;
    private javax.swing.JLabel JuBarang;
    private javax.swing.JButton butHapus;
    private javax.swing.JButton butKembali;
    private javax.swing.JButton butReset;
    private javax.swing.JButton butSimpan;
    private javax.swing.JButton butUbah;
    private javax.swing.JRadioButton exceptID;
    private javax.swing.JPanel gapID;
    private javax.swing.JTextField inpBarang;
    private javax.swing.JTextField inpBrand;
    private javax.swing.JTextField inpHarga;
    private javax.swing.JTextField inpID;
    private javax.swing.JTextField inpJumlah;
    private javax.swing.JTextField inpKategori;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel kategori;
    private javax.swing.JTable tabelBarang;
    private javax.swing.JRadioButton viaAll;
    private javax.swing.JRadioButton viaID;
    // End of variables declaration//GEN-END:variables
}
