/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author acer_
 */
public class RiwayatPembelian extends javax.swing.JFrame {
    private KoneksiDatabase dbConnection;

    int idAdminS;
    String namaAdmins;
    DecimalFormat df=new DecimalFormat("#,###.##");
    
    Integer baris;
    
    DefaultTableModel modelTabelRiwayat;
    public RiwayatPembelian(String nama, int id) {
        this.dbConnection = KoneksiDatabase.getInstance();
        initComponents();
        setLocationRelativeTo(null);
        tampilkanRiwayat();
    }
    
    void getAdminBio(String nama, int id){
        this.idAdminS = id;
        this.namaAdmins = nama;
    }
    
    void tampilkanRiwayat(){
        this.modelTabelRiwayat = (DefaultTableModel) tabelRiwayat.getModel();
        this.modelTabelRiwayat.setRowCount(0);
        try{
            Statement st1 = this.dbConnection.getConnection().createStatement();
            String query1 = String.format("select * from tabel_riwayat_pembelian;");
            ResultSet rs1 = st1.executeQuery(query1);
            while(rs1.next()){
//                System.out.println("HARIDWA");
                this.modelTabelRiwayat.addRow(new Object[]{rs1.getString(1),rs1.getString(2),rs1.getString(3),rs1.getString(7),rs1.getString(6),rs1.getString(4),rs1.getString(5),rs1.getString(8),rs1.getString(9),rs1.getString(10),rs1.getString(11),rs1.getString(12)});
            }
            
            int totalPenghasilan = 0;
            for(int i = 0; i < tabelRiwayat.getRowCount(); i++){
//                totalPenghasilan += Integer.parseInt((String) tabelRiwayat.getValueAt(i, 8));
                String[] getTotal = String.valueOf(this.tabelRiwayat.getValueAt(i, 8)).split(" - ");
//                String[] getTotal2 = getTotal[1].split(",");
                for(String tes: getTotal){
                    String[] getTotal2 = tes.split(",");
                    for(String tes2 : getTotal2){
                        totalPenghasilan += Integer.parseInt(tes2);
                    }
                }
                
            }
            
            if(totalPenghasilan == 0){
                this.showTotal.setText("Rp0");
            }else{
                this.showTotal.setText("Rp"+df.format(totalPenghasilan));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogNota = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelNota = new javax.swing.JTable();
        idTransaksiNota = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelRiwayat = new javax.swing.JTable();
        Hapus = new javax.swing.JButton();
        labelTotal = new javax.swing.JLabel();
        showTotal = new javax.swing.JLabel();
        butKembali = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        dialogNota.setBackground(new java.awt.Color(71, 73, 115));

        tabelNota.setBackground(new java.awt.Color(166, 156, 172));
        tabelNota.setForeground(new java.awt.Color(22, 27, 51));
        tabelNota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nomor", "ID Admin", "ID Member", "ID Barang", "Nama Barang", "Waktu Transaksi", "Tanggal Transaksi", "Jumlah Barang", "Total Harga", "Nominal", "Kategori Barang", "Brand Barang"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelNota.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabelNota);
        if (tabelNota.getColumnModel().getColumnCount() > 0) {
            tabelNota.getColumnModel().getColumn(0).setResizable(false);
            tabelNota.getColumnModel().getColumn(1).setResizable(false);
            tabelNota.getColumnModel().getColumn(2).setResizable(false);
            tabelNota.getColumnModel().getColumn(3).setResizable(false);
            tabelNota.getColumnModel().getColumn(4).setResizable(false);
            tabelNota.getColumnModel().getColumn(5).setResizable(false);
            tabelNota.getColumnModel().getColumn(6).setResizable(false);
            tabelNota.getColumnModel().getColumn(7).setResizable(false);
            tabelNota.getColumnModel().getColumn(8).setResizable(false);
            tabelNota.getColumnModel().getColumn(9).setResizable(false);
            tabelNota.getColumnModel().getColumn(10).setResizable(false);
            tabelNota.getColumnModel().getColumn(11).setResizable(false);
        }

        idTransaksiNota.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        idTransaksiNota.setText("ID Transaksi");

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel3.setText("ID Transaksi");

        javax.swing.GroupLayout dialogNotaLayout = new javax.swing.GroupLayout(dialogNota.getContentPane());
        dialogNota.getContentPane().setLayout(dialogNotaLayout);
        dialogNotaLayout.setHorizontalGroup(
            dialogNotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogNotaLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(dialogNotaLayout.createSequentialGroup()
                .addGap(584, 584, 584)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(idTransaksiNota, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(341, Short.MAX_VALUE))
        );
        dialogNotaLayout.setVerticalGroup(
            dialogNotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogNotaLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(dialogNotaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idTransaksiNota)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(71, 73, 115));

        tabelRiwayat.setBackground(new java.awt.Color(166, 156, 172));
        tabelRiwayat.setForeground(new java.awt.Color(22, 27, 51));
        tabelRiwayat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Transaksi", "ID Admin", "ID Member", "ID Barang", "Nama Barang", "Waktu Transaksi", "Tanggal Transaksi", "Jumlah Barang", "Total Harga", "Nominal", "Kategori Barang", "Brand Barang"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelRiwayat.getTableHeader().setReorderingAllowed(false);
        tabelRiwayat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelRiwayatMouseClicked(evt);
            }
        });
        tabelRiwayat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabelRiwayatKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tabelRiwayat);
        if (tabelRiwayat.getColumnModel().getColumnCount() > 0) {
            tabelRiwayat.getColumnModel().getColumn(0).setResizable(false);
            tabelRiwayat.getColumnModel().getColumn(1).setResizable(false);
            tabelRiwayat.getColumnModel().getColumn(2).setResizable(false);
            tabelRiwayat.getColumnModel().getColumn(3).setResizable(false);
            tabelRiwayat.getColumnModel().getColumn(4).setResizable(false);
            tabelRiwayat.getColumnModel().getColumn(5).setResizable(false);
            tabelRiwayat.getColumnModel().getColumn(6).setResizable(false);
            tabelRiwayat.getColumnModel().getColumn(7).setResizable(false);
            tabelRiwayat.getColumnModel().getColumn(8).setResizable(false);
            tabelRiwayat.getColumnModel().getColumn(9).setResizable(false);
            tabelRiwayat.getColumnModel().getColumn(10).setResizable(false);
            tabelRiwayat.getColumnModel().getColumn(11).setResizable(false);
        }

        Hapus.setBackground(new java.awt.Color(241, 218, 196));
        Hapus.setText("Hapus");
        Hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HapusActionPerformed(evt);
            }
        });

        labelTotal.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        labelTotal.setForeground(new java.awt.Color(241, 218, 196));
        labelTotal.setText("Total Penjualan");

        showTotal.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        showTotal.setForeground(new java.awt.Color(241, 218, 196));

        butKembali.setBackground(new java.awt.Color(241, 218, 196));
        butKembali.setText("Kembali");
        butKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butKembaliActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(166, 156, 172));
        jLabel1.setText("Riwayat Transaksi");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(580, 580, 580)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(butKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(labelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(showTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1358, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Hapus)
                    .addComponent(butKembali)
                    .addComponent(labelTotal)
                    .addComponent(showTotal))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HapusActionPerformed
        // TODO add your handling code here:
        if(this.baris == null){
            JOptionPane.showMessageDialog(this, "Tidak ada baris yang dipilih!");
        }else{
            try{
                String getID = (String) tabelRiwayat.getValueAt(this.baris, 0);
                Statement st1 = dbConnection.getConnection().createStatement();
                String query1 = String.format("delete from tabel_riwayat_pembelian where id_transaksi= \"%s\";", getID);
                st1.executeUpdate(query1);
                tampilkanRiwayat();
            }catch(SQLException e){
                e.printStackTrace();
            }
            this.baris = null;
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus!"); 
        }
    }//GEN-LAST:event_HapusActionPerformed

    private void butKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butKembaliActionPerformed
        // TODO add your handling code here:
        MainMenu exitMember = new MainMenu(this.namaAdmins, this.idAdminS);
        exitMember.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_butKembaliActionPerformed

    private void tabelRiwayatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelRiwayatMouseClicked
        // TODO add your handling code here:
        this.baris = tabelRiwayat.getSelectedRow();
    }//GEN-LAST:event_tabelRiwayatMouseClicked

    private void tabelRiwayatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelRiwayatKeyReleased
        // TODO add your handling code here:
        DefaultTableModel modelTabelNota = (DefaultTableModel) tabelNota.getModel();
        modelTabelNota.setRowCount(0);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int selectedRow = tabelNota.getSelectedRow();
            this.dialogNota.setVisible(true);
            this.dialogNota.setSize(1500, 600);
            this.dialogNota.getContentPane().setBackground(new Color(71,73,115));
            this.dialogNota.setLocationRelativeTo(null);
            this.dialogNota.setResizable(false);
            String[] kategoriBarang = String.valueOf(this.tabelRiwayat.getValueAt(this.baris, 10)).split(" - ");
            String[] brandBarang = String.valueOf(this.tabelRiwayat.getValueAt(this.baris, 11)).split(" - ");
            String[] namaBarang = String.valueOf(this.tabelRiwayat.getValueAt(this.baris, 4)).split(" - ");
            String[] jumlahBarang = String.valueOf(this.tabelRiwayat.getValueAt(this.baris, 7)).split(" - ");
            String[] idBarang = String.valueOf(this.tabelRiwayat.getValueAt(this.baris, 3)).split(" - ");
            String[] hargaBarang = String.valueOf(this.tabelRiwayat.getValueAt(this.baris, 8)).split(" - ");
            this.idTransaksiNota.setText((String) this.tabelRiwayat.getValueAt(this.baris, 0));
            
            for(int i = 0; i < kategoriBarang.length; i++){
                modelTabelNota.addRow(new Object[]{(i + 1), this.tabelRiwayat.getValueAt(this.baris, 1),this.tabelRiwayat.getValueAt(this.baris, 2),idBarang[i],namaBarang[i],this.tabelRiwayat.getValueAt(this.baris, 5),this.tabelRiwayat.getValueAt(this.baris, 6),jumlahBarang[i],hargaBarang[i],this.tabelRiwayat.getValueAt(this.baris, 9),kategoriBarang[i],brandBarang[i]});
            }
            
            
        }
    }//GEN-LAST:event_tabelRiwayatKeyReleased
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Hapus;
    private javax.swing.JButton butKembali;
    private javax.swing.JDialog dialogNota;
    private javax.swing.JLabel idTransaksiNota;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JLabel showTotal;
    private javax.swing.JTable tabelNota;
    private javax.swing.JTable tabelRiwayat;
    // End of variables declaration//GEN-END:variables
}
