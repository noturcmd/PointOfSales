/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;


public class Pembayaran extends javax.swing.JFrame {
    
    DefaultTableModel modelTblPbl;
    private KoneksiDatabase dbConnection;
    DecimalFormat df=new DecimalFormat("#,###");
    
    public Pembayaran() {
        initComponents();
        this.dbConnection = KoneksiDatabase.getInstance();
        getDataBarang();
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

        jLabel1 = new javax.swing.JLabel();
        namaAdmin = new javax.swing.JLabel();
        idAdmin = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelPembelianBarang = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        listKategoriBarang = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        listNamaBarang = new javax.swing.JComboBox<>();
        jumlahBarangYangDibeli = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        totalHargaKeseluruhan = new javax.swing.JLabel();
        potonganDiskon = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        hargaAkhir = new javax.swing.JLabel();
        buttonTambah = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 48)); // NOI18N
        jLabel1.setText("Pembayaran");

        namaAdmin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        namaAdmin.setText("jLabel2");

        idAdmin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idAdmin.setText("jLabel2");

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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nama Admin : ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("ID                  :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Kategori");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Jumlah");

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
        jLabel6.setText("Nama Barang");

        listNamaBarang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Total Harga");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Diskon  10%");

        totalHargaKeseluruhan.setText("jLabel9");

        potonganDiskon.setText("jLabel9");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Harga Akhir");

        hargaAkhir.setText("jLabel9");

        buttonTambah.setText("Tambah");
        buttonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTambahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(totalHargaKeseluruhan, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                    .addComponent(potonganDiskon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hargaAkhir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(namaAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(listKategoriBarang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(listNamaBarang, 0, 222, Short.MAX_VALUE)
                            .addComponent(jumlahBarangYangDibeli)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonTambah)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1019, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(560, 560, 560))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(namaAdmin)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idAdmin)
                            .addComponent(jLabel3))
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(listKategoriBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(listNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jumlahBarangYangDibeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonTambah))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalHargaKeseluruhan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(potonganDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(hargaAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(385, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void listKategoriBarangComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_listKategoriBarangComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_listKategoriBarangComponentAdded

    private void listKategoriBarangFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_listKategoriBarangFocusGained
        // TODO add your handling code here:
        
    }//GEN-LAST:event_listKategoriBarangFocusGained

    private void listKategoriBarangFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_listKategoriBarangFocusLost
        // TODO add your handling code here:
        
    }//GEN-LAST:event_listKategoriBarangFocusLost

    private void buttonTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTambahActionPerformed
        // TODO add your handling code here:
        modelTblPbl = (DefaultTableModel) tabelPembelianBarang.getModel();
        try{
            Statement st1 = dbConnection.getConnection().createStatement();
            String query1 = String.format("Select id_barang, kategori_barang, harga_barang from tabel_barang where nama_barang = \"%s\";", this.listNamaBarang.getSelectedItem().toString());
            ResultSet rs1 = st1.executeQuery(query1);
            int hargaSeluruh = 0;
            while(rs1.next()){
                modelTblPbl.addRow(new Object[]{rs1.getString("id_barang"), this.listNamaBarang.getSelectedItem().toString(),rs1.getString("kategori_barang"), this.jumlahBarangYangDibeli.getText(),df.format(Integer.parseInt(rs1.getString("harga_barang")) * Integer.parseInt(jumlahBarangYangDibeli.getText()))});
            }
            
            int jumlahData = modelTblPbl.getRowCount();
            for(int i = 0; i < jumlahData; i++){
                String nama = (String) modelTblPbl.getValueAt(i, 4);;
                String[] angka = nama.split(",");
                hargaSeluruh += Integer.parseInt(angka[0] + angka[1]);
            }

            System.out.println("Harga seluruh : " + hargaSeluruh);
            this.totalHargaKeseluruhan.setText("Rp"+df.format(hargaSeluruh));
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_buttonTambahActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonTambah;
    private javax.swing.JLabel hargaAkhir;
    private javax.swing.JLabel idAdmin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jumlahBarangYangDibeli;
    private javax.swing.JComboBox<String> listKategoriBarang;
    private javax.swing.JComboBox<String> listNamaBarang;
    private javax.swing.JLabel namaAdmin;
    private javax.swing.JLabel potonganDiskon;
    private javax.swing.JTable tabelPembelianBarang;
    private javax.swing.JLabel totalHargaKeseluruhan;
    // End of variables declaration//GEN-END:variables
}
