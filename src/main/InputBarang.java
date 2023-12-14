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
        inpID = new javax.swing.JTextField();
        viaAll = new javax.swing.JRadioButton();
        inpBarang = new javax.swing.JTextField();
        viaID = new javax.swing.JRadioButton();
        exceptID = new javax.swing.JRadioButton();
        inpBrand = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        inpJumlah = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelBarang = new javax.swing.JTable();
        inpHarga = new javax.swing.JTextField();
        butSimpan = new javax.swing.JButton();
        ID = new javax.swing.JLabel();
        butUbah = new javax.swing.JButton();
        Barang = new javax.swing.JLabel();
        butHapus = new javax.swing.JButton();
        BrBarang = new javax.swing.JLabel();
        butKembali = new javax.swing.JButton();
        JuBarang = new javax.swing.JLabel();
        BrBarang1 = new javax.swing.JLabel();
        HaBarang = new javax.swing.JLabel();
        inpKategori = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(71, 73, 115));

        inpID.setBackground(new java.awt.Color(71, 73, 115));
        inpID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(170, 165, 159)));

        viaAll.setForeground(new java.awt.Color(166, 156, 172));
        viaAll.setText("All");

        inpBarang.setBackground(new java.awt.Color(71, 73, 115));
        inpBarang.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(170, 165, 159)));
        inpBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpBarangActionPerformed(evt);
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

        inpBrand.setBackground(new java.awt.Color(71, 73, 115));
        inpBrand.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(170, 165, 159)));
        inpBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpBrandActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(166, 156, 172));
        jLabel1.setText("Stok Barang ATK");

        inpJumlah.setBackground(new java.awt.Color(71, 73, 115));
        inpJumlah.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(170, 165, 159)));
        inpJumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpJumlahActionPerformed(evt);
            }
        });

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

        inpHarga.setBackground(new java.awt.Color(71, 73, 115));
        inpHarga.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(170, 165, 159)));
        inpHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpHargaActionPerformed(evt);
            }
        });

        butSimpan.setBackground(new java.awt.Color(241, 218, 196));
        butSimpan.setText("Simpan");
        butSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butSimpanActionPerformed(evt);
            }
        });

        ID.setForeground(new java.awt.Color(166, 156, 172));
        ID.setText("ID Barang");

        butUbah.setBackground(new java.awt.Color(241, 218, 196));
        butUbah.setText("Ubah");
        butUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butUbahActionPerformed(evt);
            }
        });

        Barang.setForeground(new java.awt.Color(166, 156, 172));
        Barang.setText("Nama Barang");

        butHapus.setBackground(new java.awt.Color(241, 218, 196));
        butHapus.setText("Hapus");

        BrBarang.setForeground(new java.awt.Color(166, 156, 172));
        BrBarang.setText("Brand");

        butKembali.setBackground(new java.awt.Color(241, 218, 196));
        butKembali.setText("Kembali");
        butKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butKembaliActionPerformed(evt);
            }
        });

        JuBarang.setForeground(new java.awt.Color(166, 156, 172));
        JuBarang.setText("Jumlah");

        BrBarang1.setForeground(new java.awt.Color(166, 156, 172));
        BrBarang1.setText("Kategori");

        HaBarang.setForeground(new java.awt.Color(166, 156, 172));
        HaBarang.setText("Harga / pcs");

        inpKategori.setBackground(new java.awt.Color(71, 73, 115));
        inpKategori.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(170, 165, 159)));
        inpKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpKategoriActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(butSimpan))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ID, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(BrBarang1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(JuBarang)
                                        .addComponent(BrBarang)
                                        .addComponent(Barang)
                                        .addComponent(HaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(inpBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inpID, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inpBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inpKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inpJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inpHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(viaID)
                                        .addGap(18, 18, 18)
                                        .addComponent(exceptID)
                                        .addGap(18, 18, 18)
                                        .addComponent(viaAll)))))
                        .addGap(53, 53, 53)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(butKembali)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(butHapus)
                        .addGap(66, 66, 66)
                        .addComponent(butUbah)))
                .addGap(68, 68, 68))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(447, 447, 447)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(viaAll)
                            .addComponent(viaID)
                            .addComponent(exceptID))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ID)
                            .addComponent(inpID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Barang)
                            .addComponent(inpBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inpBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BrBarang))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inpKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BrBarang1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inpJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JuBarang))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inpHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HaBarang))
                        .addGap(50, 50, 50)
                        .addComponent(butSimpan)
                        .addGap(27, 27, 27)
                        .addComponent(butKembali)
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(butHapus)
                            .addComponent(butUbah))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inpBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpBarangActionPerformed

    private void inpBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpBrandActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpBrandActionPerformed

    private void inpKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpKategoriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpKategoriActionPerformed

    private void inpHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpHargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpHargaActionPerformed

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
    }//GEN-LAST:event_butUbahActionPerformed

    private void viaIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viaIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viaIDActionPerformed

    private void inpJumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpJumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpJumlahActionPerformed

    private void butKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butKembaliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_butKembaliActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Barang;
    private javax.swing.JLabel BrBarang;
    private javax.swing.JLabel BrBarang1;
    private javax.swing.JLabel HaBarang;
    private javax.swing.JLabel ID;
    private javax.swing.JLabel JuBarang;
    private javax.swing.JButton butHapus;
    private javax.swing.JButton butKembali;
    private javax.swing.JButton butSimpan;
    private javax.swing.JButton butUbah;
    private javax.swing.JRadioButton exceptID;
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
    private javax.swing.JTable tabelBarang;
    private javax.swing.JRadioButton viaAll;
    private javax.swing.JRadioButton viaID;
    // End of variables declaration//GEN-END:variables
}
