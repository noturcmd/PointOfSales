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
    DefaultTableModel modelDataBarang;
    private KoneksiDatabase dbConnection;
    DecimalFormat df=new DecimalFormat("#,###.##");
    DaftarMember dfm = null;
    int totalHargaSemua;
    int idAdminS;
    int idMemberS;
    String idBarangs;
    String namaBarangs;
    int jumlahBeliBarang;
    Integer baris;
    Integer baris2;
    
//    Integer pointMember;
    
    public Pembayaran(){
        initComponents();
        this.dbConnection = KoneksiDatabase.getInstance();
//        getDataBarang();
        System.out.println(getSize());
        this.tombolSimpan.setVisible(false);
        setLocationRelativeTo(null);
        getDataBarangAll();
        
    }
    
    void getDataBarangAll(){
        this.modelDataBarang = (DefaultTableModel) tabelDataBarang.getModel();
        this.modelDataBarang.setRowCount(0);
        try{
            Statement st1 = dbConnection.getConnection().createStatement();
            String query1 = "select * from tabel_barang";
            ResultSet rs1 = st1.executeQuery(query1);
            while(rs1.next()){
                this.modelDataBarang.addRow(new Object[]{rs1.getString("id_barang"),rs1.getString("nama_barang"),rs1.getString("kategori_barang"),rs1.getString("brand_barang"),rs1.getString("jumlah_barang"),rs1.getString("harga_barang")});
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }
   
    
    private void ubahDataBaris() {
        int selectedRow = tabelPembelianBarang.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris yang akan diubah.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        DefaultTableModel model = (DefaultTableModel) tabelPembelianBarang.getModel();
        model.setValueAt("Value Baru", selectedRow, 0);
        model.setValueAt("Value Baru", selectedRow, 3);
        model.fireTableRowsUpdated(selectedRow, selectedRow);
    }
    
    void getAdminBio(String nama, int id){
        this.idAdminS = id;
        this.namaAdmin.setText(nama);
        this.idAdmin.setText(String.valueOf(id));
    }
    
    void resetAll(){
        DefaultTableModel tabelTabel = (DefaultTableModel) tabelPembelianBarang.getModel();
        tabelTabel.setRowCount(0);
        this.statusMember.setText("");
        this.jumlahBarangYangDibeli.setText("");
        this.searchByID.setText("");
        this.totalHargaKeseluruhan.setText("Rp 0");
        this.potonganDiskon.setText("Rp 0");
        this.hargaAkhir.setText("Rp 0");
        this.baris2 = null;
        this.baris = null;
    }
    
    void tambahBarang(){
        if(!this.jumlahBarangYangDibeli.getText().matches("\\d*")){
            JOptionPane.showMessageDialog(this, "Mohon input jumlah yang valid!");
        }else if (this.jumlahBarangYangDibeli.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Input jumlah kosong!");
        }else if (this.jumlahBarangYangDibeli.getText().matches("\\d*") && Integer.parseInt(this.jumlahBarangYangDibeli.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "Mohon input jumlah yang valid!");
        }else if(this.jumlahBarangYangDibeli.getText().matches("\\d*") && Integer.parseInt(this.jumlahBarangYangDibeli.getText()) > 0){
//            JOptionPane.showMessageDialog(rootPane, "Masuk ke Anuuuuu");
            if(this.baris2 == null){
                JOptionPane.showMessageDialog(rootPane, "Mohon memilih barang!");
            }else{
                    try {
                        Statement st2 = dbConnection.getConnection().createStatement();
                        String query2 = String.format("select jumlah_barang from tabel_barang where id_barang = \"%s\";", this.tabelDataBarang.getValueAt(this.baris2, 0));
                        ResultSet rs2 = st2.executeQuery(query2);
                        if(rs2.next()){
                            int sisaBarang = Integer.parseInt(rs2.getString("jumlah_barang"));
                            if(sisaBarang - Integer.parseInt(this.jumlahBarangYangDibeli.getText()) < 0){
                                JOptionPane.showMessageDialog(this, "Jumlah barang yang akan dibeli tidak pas dengan stok yang tersedia!");
                            }else{
                                namaBarangs = (String) this.tabelDataBarang.getValueAt(this.baris2, 1);
//                            jumlahPCS += Integer.parseInt(this.jumlahBarangYangDibeli.getText());
                            Statement st1 = dbConnection.getConnection().createStatement();
                            String query1 = String.format("SELECT * FROM tabel_barang WHERE nama_barang = \"%s\";", namaBarangs);

                            ResultSet rs1 = st1.executeQuery(query1);
                            if (rs1.next()) {

                            this.idBarangs = rs1.getString("id_barang");
                            int jumlahBaris = modelTblPbl.getRowCount();
                            int index = 0;
                            boolean idFound = false;
                            Integer jumlahStokTersedia = Integer.parseInt(String.valueOf(tabelDataBarang.getValueAt(this.baris2, 4)));
//                               JOptionPane.showMessageDialog(this, "Stok tersedia : " + jumlahStokTersedia);
                            
                            while (index < jumlahBaris) {
                                if (this.modelTblPbl.getValueAt(index, 0).equals(rs1.getString("id_barang"))) {
                                    System.out.println("Kondisi 11111");
                                    String jumlah = String.valueOf(Integer.parseInt((String) this.modelTblPbl.getValueAt(index, 4)) + Integer.parseInt(this.jumlahBarangYangDibeli.getText()));
//                                    JOptionPane.showMessageDialog(this, "Jumlah barang dalam tabel beli  :" + jumlah);
//                                    jumlahStokTersedia += Integer.parseInt(jumlah);
                                    if(jumlahStokTersedia < Integer.valueOf(jumlah)){
                                        JOptionPane.showMessageDialog(this, "Stok tidak cukup!");
                                        idFound = true;
                                        break;
                                    }else{
//                                        JOptionPane.showMessageDialog(this, "Malah masuk ke sini");
                                        modelTblPbl.setValueAt(rs1.getString("id_barang"), index, 0);
                                        modelTblPbl.setValueAt(namaBarangs, index, 1);
                                        modelTblPbl.setValueAt(rs1.getString("kategori_barang"), index, 2);
                                        modelTblPbl.setValueAt(rs1.getString("brand_barang"), index, 3);
                                        modelTblPbl.setValueAt(jumlah, index, 4);
                                        int harga123 = Integer.parseInt(String.valueOf(modelTblPbl.getValueAt(index, 4))) * Integer.parseInt(rs1.getString("harga_barang"));
                                        modelTblPbl.setValueAt(df.format(harga123), index, 5);
                                        idFound = true;
                                        break;
                                    } 
                                }
                                
                                index++;
                            }
                            
                            
                            
                            
                            if (idFound == false) {
                                namaBarangs = (String) this.tabelDataBarang.getValueAt(this.baris2, 1);
                                modelTblPbl.addRow(new Object[]{rs1.getString("id_barang"), namaBarangs, rs1.getString("kategori_barang"), rs1.getString("brand_barang"),this.jumlahBarangYangDibeli.getText(), df.format(Integer.parseInt(rs1.getString("harga_barang")) * Integer.parseInt(this.jumlahBarangYangDibeli.getText()))});
                            }else{
                                
                            }
//                            JOptionPane.showMessageDialog(this, "Jumlah barang yang  dibeli 2:" + jumlahPCS);
//                            for(int i = 0; i < tabelPembelianBarang.getRowCount(); i ++){
//                                JOptionPane.showMessageDialog(this, "Jumlah barang yang dapat dibeli lagi :" + jumlahPCS);
//                                jumlahPCS += Integer.parseInt(String.valueOf(tabelPembelianBarang.getValueAt(i, 4)));
//                                JOptionPane.showMessageDialog(this, "Jumlah barang yang  dibeli  lagi 2 : "+ jumlahPCS);
//                            }
                            
                            int getHargaTable = 0;
                            ArrayList<String> harga1 = new ArrayList<String>();
                            for(int i = 0; i < modelTblPbl.getRowCount(); i++){
                                String getHarga = "";
                                String[] harga = (String[]) String.valueOf(modelTblPbl.getValueAt(i, 5)).split(",");
                                for(String harga10: harga){
                                    getHarga += harga10;
                                }
                                harga1.add(getHarga);
                            }
                            for(String hargaalll : harga1){
                                getHargaTable += Integer.parseInt(hargaalll);
                            }
                            this.totalHargaKeseluruhan.setText("Rp" + df.format(getHargaTable));
                            this.hargaAkhir.setText("Rp" + df.format(getHargaTable));
                        }

                        if(this.tabelPembelianBarang.getRowCount() > 0){
                            ArrayList<String> harga1 = new ArrayList<String>();
                            String harga4 = "";
                            String[] diskonAll = this.totalHargaKeseluruhan.getText().split("Rp");
                            for(String hahaha: diskonAll){
                                System.out.println("harga haha: " +  hahaha);
                            }

                            String[] splittt = diskonAll[1].split(",");
                            for(String trusss: splittt){
                                harga4 += trusss;
                            }

                            this.totalHargaSemua = Integer.parseInt(harga4);


                            if(this.statusMember.getText().equals("Member")){
                                int diskonPotong = (int)(0.1 * Integer.parseInt(harga4));
                                this.potonganDiskon.setText("Rp" + df.format(diskonPotong));
                                int hargaAfterDiskon = Integer.parseInt(harga4) - diskonPotong;
                                this.totalHargaSemua = hargaAfterDiskon;
                                JOptionPane.showMessageDialog(rootPane, "Harga all satu : " + totalHargaSemua);
                                try{
                                Statement rahasia = dbConnection.getConnection().createStatement();
                                String rahasia2 = String.format("select point_member from tabel_member where id_member = \"%s\";", this.searchByID.getText());
                                ResultSet rs3 = rahasia.executeQuery(rahasia2);
                                if(rs3.next()){
                                    if(Integer.parseInt(rs3.getString("point_member")) >= 4000){
                                        int diskon2 = (int)(0.2 * this.totalHargaSemua);
                                        JOptionPane.showMessageDialog(rootPane, "Besar diskon pertama : " + diskonPotong);
                                        JOptionPane.showMessageDialog(rootPane, "Besar diskon kedua : " + diskon2);
                                        this.totalHargaSemua = this.totalHargaSemua - diskon2;
                                        JOptionPane.showMessageDialog(rootPane, "Harga All dua : " + this.totalHargaSemua);
                                        this.potonganDiskon.setText("Rp" + df.format(diskonPotong + diskon2));
                                        JOptionPane.showMessageDialog(rootPane, "Harga All terakhir : " + this.totalHargaSemua);
                                        this.hargaAkhir.setText("Rp" + String.valueOf(df.format(this.totalHargaSemua)));
                                    }else{
                                        this.potonganDiskon.setText("Rp" + df.format(diskonPotong));
                                        this.hargaAkhir.setText("Rp" + String.valueOf(df.format(this.totalHargaSemua - diskonPotong)));
                                    }
                                }
                    }catch(SQLException e){
                        e.printStackTrace();
                    }
                            }       
                        }
                      }
                    }
                    
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
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
        hargaAkhir = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        buttonTambah = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        tombolUbah = new javax.swing.JButton();
        tombolHapus = new javax.swing.JButton();
        daftarMember = new javax.swing.JToggleButton();
        jLabel11 = new javax.swing.JLabel();
        searchByID = new javax.swing.JTextField();
        statusMember = new javax.swing.JLabel();
        tombolSearch = new javax.swing.JButton();
        tombolReset = new javax.swing.JToggleButton();
        tombolSimpan = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        inputPembayaran = new javax.swing.JTextField();
        tombolBayar = new javax.swing.JButton();
        teksTotal = new javax.swing.JLabel();
        tombolKembali = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelDataBarang = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(71, 73, 115));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(71, 73, 115));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(241, 218, 196), 4, true));
        jPanel1.setToolTipText("");
        jPanel1.setPreferredSize(new java.awt.Dimension(1300, 629));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(166, 156, 172));
        jLabel1.setText("Pembayaran");

        namaAdmin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        namaAdmin.setForeground(new java.awt.Color(241, 218, 196));
        namaAdmin.setText("jLabel2");

        jumlahBarangYangDibeli.setBackground(new java.awt.Color(71, 73, 115));
        jumlahBarangYangDibeli.setForeground(new java.awt.Color(241, 218, 196));
        jumlahBarangYangDibeli.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(170, 165, 159)));
        jumlahBarangYangDibeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumlahBarangYangDibeliActionPerformed(evt);
            }
        });

        idAdmin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idAdmin.setForeground(new java.awt.Color(241, 218, 196));
        idAdmin.setText("jLabel2");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(166, 156, 172));
        jLabel7.setText("Total Harga");

        tabelPembelianBarang.setBackground(new java.awt.Color(166, 156, 172));
        tabelPembelianBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Barang", "Nama Barang", "Kategori", "Brand", "Jumlah", "Harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelPembelianBarang.getTableHeader().setReorderingAllowed(false);
        tabelPembelianBarang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tabelPembelianBarangFocusLost(evt);
            }
        });
        tabelPembelianBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelPembelianBarangMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tabelPembelianBarangMouseExited(evt);
            }
        });
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
            tabelPembelianBarang.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(166, 156, 172));
        jLabel8.setText("Diskon  10%");

        totalHargaKeseluruhan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        totalHargaKeseluruhan.setForeground(new java.awt.Color(241, 218, 196));
        totalHargaKeseluruhan.setText("Rp 0");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(166, 156, 172));
        jLabel2.setText("Nama Admin : ");

        potonganDiskon.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        potonganDiskon.setForeground(new java.awt.Color(241, 218, 196));
        potonganDiskon.setText("Rp 0");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(166, 156, 172));
        jLabel3.setText("ID                  :");

        hargaAkhir.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
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

        daftarMember.setBackground(new java.awt.Color(241, 218, 196));
        daftarMember.setText("Daftar");
        daftarMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daftarMemberActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(166, 156, 172));
        jLabel11.setText("Search By ID");

        searchByID.setBackground(new java.awt.Color(71, 73, 115));
        searchByID.setForeground(new java.awt.Color(241, 218, 196));
        searchByID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(170, 165, 159)));
        searchByID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchByIDActionPerformed(evt);
            }
        });

        statusMember.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        statusMember.setForeground(new java.awt.Color(166, 156, 172));

        tombolSearch.setBackground(new java.awt.Color(241, 218, 196));
        tombolSearch.setText("Search");
        tombolSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolSearchActionPerformed(evt);
            }
        });

        tombolReset.setBackground(new java.awt.Color(241, 218, 196));
        tombolReset.setText("Reset");
        tombolReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolResetActionPerformed(evt);
            }
        });

        tombolSimpan.setBackground(new java.awt.Color(241, 218, 196));
        tombolSimpan.setText("Simpan");
        tombolSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolSimpanActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(166, 156, 172));
        jLabel13.setText("Nominal Pembayaran");

        inputPembayaran.setBackground(new java.awt.Color(71, 73, 115));
        inputPembayaran.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        inputPembayaran.setForeground(new java.awt.Color(241, 218, 196));
        inputPembayaran.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(170, 165, 159)));
        inputPembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputPembayaranActionPerformed(evt);
            }
        });

        tombolBayar.setBackground(new java.awt.Color(241, 218, 196));
        tombolBayar.setText("Bayar");
        tombolBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolBayarActionPerformed(evt);
            }
        });

        teksTotal.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        teksTotal.setForeground(new java.awt.Color(241, 218, 196));
        teksTotal.setText("Total");

        tombolKembali.setBackground(new java.awt.Color(241, 218, 196));
        tombolKembali.setText("Kembali");
        tombolKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolKembaliActionPerformed(evt);
            }
        });

        tabelDataBarang.setBackground(new java.awt.Color(166, 156, 172));
        tabelDataBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Barang", "Nama Barang", "Kategori", "Brand", "Jumlah", "Harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelDataBarang.getTableHeader().setReorderingAllowed(false);
        tabelDataBarang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tabelDataBarangFocusLost(evt);
            }
        });
        tabelDataBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelDataBarangMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tabelDataBarangMouseExited(evt);
            }
        });
        jScrollPane2.setViewportView(tabelDataBarang);
        if (tabelDataBarang.getColumnModel().getColumnCount() > 0) {
            tabelDataBarang.getColumnModel().getColumn(0).setResizable(false);
            tabelDataBarang.getColumnModel().getColumn(0).setPreferredWidth(20);
            tabelDataBarang.getColumnModel().getColumn(1).setResizable(false);
            tabelDataBarang.getColumnModel().getColumn(1).setPreferredWidth(150);
            tabelDataBarang.getColumnModel().getColumn(2).setResizable(false);
            tabelDataBarang.getColumnModel().getColumn(3).setResizable(false);
            tabelDataBarang.getColumnModel().getColumn(3).setPreferredWidth(20);
            tabelDataBarang.getColumnModel().getColumn(4).setResizable(false);
            tabelDataBarang.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(768, 768, 768)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(namaAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                    .addComponent(idAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(teksTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hargaAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(statusMember, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(searchByID, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(tombolBayar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(inputPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jLabel11)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(159, 159, 159)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tombolSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jumlahBarangYangDibeli, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tombolReset, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tombolSimpan))))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(totalHargaKeseluruhan, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(potonganDiskon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(229, 229, 229))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(tombolKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(daftarMember, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(tombolUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tombolHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(namaAdmin)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idAdmin)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hargaAkhir)
                            .addComponent(teksTotal))
                        .addGap(38, 38, 38)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(totalHargaKeseluruhan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(potonganDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jumlahBarangYangDibeli, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tombolSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(9, 9, 9)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(searchByID, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tombolSearch)
                                    .addComponent(tombolReset)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(7, 7, 7)
                                    .addComponent(statusMember, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tombolBayar)
                        .addGap(48, 48, 48)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonTambah)
                    .addComponent(tombolUbah)
                    .addComponent(tombolHapus)
                    .addComponent(daftarMember)
                    .addComponent(tombolKembali))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1737, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTambahActionPerformed
        // TODO add your handling code here:
        modelTblPbl = (DefaultTableModel) tabelPembelianBarang.getModel();
        this.tambahBarang();
    }//GEN-LAST:event_buttonTambahActionPerformed

    private void tombolUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolUbahActionPerformed
        // TODO add your handling code here:
        
        this.ubahDataBaris();
        this.tombolSimpan.setVisible(true);
    }//GEN-LAST:event_tombolUbahActionPerformed

    private void tombolHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolHapusActionPerformed
        // TODO add your handling code here:
        if(this.baris == null){
            JOptionPane.showMessageDialog(this, "Tidak ada baris yang dipilih!");
        }else{
            this.modelTblPbl.removeRow(this.baris);
        int getHargaTable = 0;
        ArrayList<String> harga1 = new ArrayList<String>();
                    for(int i = 0; i < modelTblPbl.getRowCount(); i++){
                        String getHarga = "";
                        String[] harga = (String[]) String.valueOf(modelTblPbl.getValueAt(i, 4)).split(",");
                        for(String harga10: harga){
                            getHarga += harga10;
                        }
                        harga1.add(getHarga);
                    }
                    for(String hargaalll : harga1){
                        getHargaTable += Integer.parseInt(hargaalll);
                    }
                    this.totalHargaKeseluruhan.setText("Rp" + df.format(getHargaTable));
                    this.hargaAkhir.setText("Rp" + df.format(getHargaTable));
        if(this.tabelPembelianBarang.getRowCount() > 0){
                    String harga4 = "";
                    String[] diskonAll = this.totalHargaKeseluruhan.getText().split("Rp");
                    for(String hahaha: diskonAll){
                        System.out.println("harga haha: " +  hahaha);
                    }
                    
                    String[] splittt = diskonAll[1].split(",");
                    for(String trusss: splittt){
                        harga4 += trusss;
                    }
                    
                    this.totalHargaSemua = Integer.parseInt(harga4);
                    
                    
                    if(this.statusMember.getText().equals("Member")){
                        int diskonPotong = (int)(0.1 * Integer.parseInt(harga4));
                        this.potonganDiskon.setText("Rp" + df.format(diskonPotong));
                        int hargaAfterDiskon = Integer.parseInt(harga4) - diskonPotong;
                        this.hargaAkhir.setText("Rp" + df.format(hargaAfterDiskon));
                        this.totalHargaSemua = hargaAfterDiskon;
                        this.totalHargaSemua = Integer.parseInt(harga4) - diskonPotong;
                    
                        
                    }else{
                        
                    }    
                }
        }
    }//GEN-LAST:event_tombolHapusActionPerformed

    private void searchByIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchByIDActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_searchByIDActionPerformed

    private void tombolSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolSearchActionPerformed
        // TODO add your handling code here:
        if(this.searchByID.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Input ID kosong!");
        }else if(Integer.parseInt(this.searchByID.getText()) <= 0){
            JOptionPane.showMessageDialog(this, "Input ID tidak valid!");
        }else{
            try{
                Statement st1 = dbConnection.getConnection().createStatement();
                String query1 = String.format("Select * from tabel_member where id_member = \"%s\";", this.searchByID.getText());
                ResultSet rs1 = st1.executeQuery(query1);
                if(rs1.next()){
                    this.idMemberS = Integer.parseInt(rs1.getString("id_member"));
                    this.statusMember.setText("Member");
                if(this.tabelPembelianBarang.getRowCount() > 0){
                    ArrayList<String> harga1 = new ArrayList<String>();
                    String harga4 = "";
                    String[] jumlahHarga2 = this.totalHargaKeseluruhan.getText().split("Rp");   
                    String[] jumlahHarga3 = jumlahHarga2[1].split(",");
                    for(String tes: jumlahHarga3){
                        harga4 += tes;
                    }
                    int diskon = (int)(0.1 * Integer.parseInt(harga4));
                    this.totalHargaSemua = Integer.parseInt(harga4) - diskon;
                    JOptionPane.showMessageDialog(rootPane, "Harga all satu : " + totalHargaSemua);
                    Statement rahasia = dbConnection.getConnection().createStatement();
                    String rahasia2 = String.format("select point_member from tabel_member where id_member = \"%s\";", this.searchByID.getText());
                    ResultSet rs3 = rahasia.executeQuery(rahasia2);
                                if(rs3.next()){
//                                    JOptionPane.showMessageDialog(rootPane, "Bisa masuk");
                                    if(Integer.parseInt(rs3.getString("point_member")) >= 4000){
                                        int diskon2 = (int)(0.2 * this.totalHargaSemua);
                                        JOptionPane.showMessageDialog(rootPane, "Besar diskon pertama : " + diskon);
                                        JOptionPane.showMessageDialog(rootPane, "Besar diskon kedua : " + diskon2);
                                        this.totalHargaSemua = this.totalHargaSemua - diskon2;
                                        JOptionPane.showMessageDialog(rootPane, "Harga All dua : " + this.totalHargaSemua);
                                        this.potonganDiskon.setText("Rp" + df.format(diskon + diskon2));
                                        JOptionPane.showMessageDialog(rootPane, "Harga All terakhir : " + this.totalHargaSemua);
                                        this.hargaAkhir.setText("Rp" + String.valueOf(df.format(this.totalHargaSemua)));
                                    }else{
                                        this.potonganDiskon.setText("Rp" + df.format(diskon));
                                        JOptionPane.showMessageDialog(rootPane, "Harga All terakhir : " + this.totalHargaSemua);
                                        this.hargaAkhir.setText("Rp" + String.valueOf(df.format(this.totalHargaSemua)));
                                    }
                                }
                }
                }else{
                    this.statusMember.setText("Bukan Member");
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_tombolSearchActionPerformed

    private void daftarMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daftarMemberActionPerformed
        // TODO add your handling code here:
        if(this.dfm == null){
            this.dfm = new DaftarMember();
        }
        
        this.dfm.setVisible(true);
    }//GEN-LAST:event_daftarMemberActionPerformed

    private void tombolResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolResetActionPerformed
        // TODO add your handling code here:
        resetAll();
        this.baris = null;
    }//GEN-LAST:event_tombolResetActionPerformed

    private void tabelPembelianBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPembelianBarangMouseClicked
        // TODO add your handling code here:
        this.baris = tabelPembelianBarang.getSelectedRow();
    }//GEN-LAST:event_tabelPembelianBarangMouseClicked

    private void tombolSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolSimpanActionPerformed
        // TODO add your handling code here:
        JOptionPane jop = new JOptionPane();
        int jawab = jop.showConfirmDialog(this, "Ingin menyimpan perubahan?");
        switch(jawab){
            case JOptionPane.YES_OPTION: 
                                        tabelPembelianBarang.clearSelection();
                                        this.tombolSimpan.setVisible(false);
                                        break;
            case JOptionPane.NO_OPTION: 
                                        break;
        }
    }//GEN-LAST:event_tombolSimpanActionPerformed

    private void tombolBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolBayarActionPerformed
        // TODO add your handling code here:
        Integer jumlahPCS = this.totalHargaSemua;
//        String huhu = "";
//        for(int i = 0; i < tabelPembelianBarang.getRowCount(); i++){
//            String[] getHargaHu = String.valueOf(tabelPembelianBarang.getValueAt(i, 5)).split(",");
//            for(String tes: getHargaHu){
//                System.out.println("Tes tes :" + tes);
//                huhu += tes;
//            }
//            System.out.println("Tes tes :" + huhu);
//            jumlahPCS +=Integer.parseInt(getHargaHu[i]);
//        }
        
        String namaBarang2 = "";
        for(int i = 0; i < tabelPembelianBarang.getRowCount(); i++){
            namaBarang2 += String.join(",", String.valueOf(tabelPembelianBarang.getValueAt(i, 1)));
        }
        
//        JOptionPane.showMessageDialog(this, "namaBarang2 : " + namaBarang2);
        
        String idBarangs = "";
        for(int i = 0; i < tabelPembelianBarang.getRowCount(); i++){
            idBarangs += String.valueOf(tabelPembelianBarang.getValueAt(i, 0)+",");
        }
        
        String[] idBarang2 = idBarangs.split(",");
        ArrayList<String> idBaru = new ArrayList<>();
        for(String tes: idBarang2){
            if(tes.isBlank() | tes.isEmpty()){
                
            }else{
                idBaru.add(tes);
            }
        }
//        JOptionPane.showMessageDialog(this, namaBarang2);
        if(this.totalHargaSemua <= 0){
            JOptionPane.showMessageDialog(this, "Barang belum diinput!");
        }else{
            if(this.inputPembayaran.getText().isBlank()){
                JOptionPane.showMessageDialog(this, "Mohon tidak mengosongkan input pembayaran!");
            }else if (!this.inputPembayaran.getText().matches("\\d*")) {
                JOptionPane.showMessageDialog(this, "Mohon input nominal yang valid!");
            }else if(this.inputPembayaran.getText().matches("\\d*")){
                  if(Integer.parseInt(this.inputPembayaran.getText()) > 0 && Integer.parseInt(this.inputPembayaran.getText()) < this.totalHargaSemua){
                        JOptionPane.showMessageDialog(this, "Uang Anda kurang : "+ df.format(this.totalHargaSemua - Integer.parseInt(this.inputPembayaran.getText())));
                    }else if(Integer.parseInt(this.inputPembayaran.getText()) == this.totalHargaSemua){
                        if(this.statusMember.getText().equals("Member")){
                            try{
                                Statement st1 = dbConnection.getConnection().createStatement();
                                
                                String query1 = String.format("insert into tabel_riwayat_pembelian(id_admin, id_member, waktu_transaksi, tanggal_transaksi, id_barang, jumlah_beli_barang, total_harga, pembayaran, nama_barang) values(\"%s\",\"%s\", curtime(), curdate(), \"%s\", \"%s\", \"%s\", \"%s\", \"%s\");", this.idAdminS, this.idMemberS, this.idBarangs, jumlahPCS, this.totalHargaSemua, Integer.parseInt(this.inputPembayaran.getText()), namaBarang2);
                                st1.executeUpdate(query1);
//                                JOptionPane.showMessageDialog(rootPane, "Jumlah PCS : " + jumlahPCS);
                                int pointMember = (int) (0.2 * this.totalHargaSemua);
//                                JOptionPane.showMessageDialog(rootPane, "PointMember : " + pointMember);
                                Statement st2 = dbConnection.getConnection().createStatement();
                                String query2 = String.format("Select point_member from tabel_member where id_member = \"%s\";", this.idMemberS);
                                ResultSet rs2 = st2.executeQuery(query2);
                                Statement st4 = dbConnection.getConnection().createStatement();
                                String query4 = String.format("Select jumlah_barang from tabel_barang where id_barang = \"%s\";", this.idBarangs);
                                ResultSet rs4 = st4.executeQuery(query4);
                                if(rs2.next()){
                                    if(Integer.parseInt(rs2.getString("point_member")) > 0){
                                        if(Integer.parseInt(rs2.getString("point_member")) >= 4000){
                                            Statement st3 = dbConnection.getConnection().createStatement();
                                            String queryUpdate = String.format("update tabel_member set point_member = \"%s\" where id_member = \"%s\";", Integer.parseInt(rs2.getString("point_member")) - 4000  + pointMember, this.idMemberS);
                                            st3.executeUpdate(queryUpdate);
                                            ResultSet rs1 = st3.executeQuery(query4);
                                        }else{
                                            Statement st3 = dbConnection.getConnection().createStatement();
                                            String queryUpdate = String.format("update tabel_member set point_member = \"%s\" where id_member = \"%s\";", Integer.parseInt(rs2.getString("point_member")) + pointMember, this.idMemberS);
                                            st3.executeUpdate(queryUpdate);
                                            ResultSet rs1 = st3.executeQuery(query4);
                                        }
                                        
                                        
                                        if(rs4.next()){
                                        for(int i = 0; i < idBaru.size(); i++){ 
                                            try (
                                                    Statement st5 = dbConnection.getConnection().createStatement()) {
//                                            JOptionPane.showMessageDialog(rootPane, "ID barang : " + idBaru.get(i));
                                            String query5 = String.format("Select jumlah_barang from tabel_barang where id_barang = \"%s\";", idBaru.get(i));
                                            ResultSet rs5 = st5.executeQuery(query5);
                                            int jumlahBaris = tabelPembelianBarang.getRowCount();

                                            while (rs5.next()) {

        //                                        for (int d = 0; d < jumlahBaris; d++) {
                                                    int jumlahBarangDatabase = rs5.getInt("jumlah_barang");
                                                    int jumlahBarangDibeli = Integer.parseInt(tabelPembelianBarang.getValueAt(i,4).toString());
        //                                            JOptionPane.showMessageDialog(this, "nama Barang : " + );
//                                                    JOptionPane.showMessageDialog(rootPane, "Jumlah database : " + jumlahBarangDatabase);
//                                                    JOptionPane.showMessageDialog(rootPane, "Jumlah beli : " + jumlahBarangDibeli);
                                                    int jumlahBarangBaru = jumlahBarangDatabase - jumlahBarangDibeli;
//                                                    JOptionPane.showMessageDialog(rootPane, "Jumlah baru : " + jumlahBarangBaru);
                                                    String updateQuery = "UPDATE tabel_barang SET jumlah_barang = ? WHERE id_barang = ?";
                                                    try (PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(updateQuery)) {
                                                        preparedStatement.setInt(1, jumlahBarangBaru);
                                                        preparedStatement.setString(2, (String) tabelPembelianBarang.getValueAt(i, 0));
//                                                        JOptionPane.showMessageDialog(this, "ID : " + tabelPembelianBarang.getValueAt(i, 0));
                                                        int rowCount = preparedStatement.executeUpdate();
                                                        System.out.println("Baris yang diupdate: " + rowCount);
                                                    } catch (SQLException e) {
                                                        e.printStackTrace();
                                                    }
        //                                        }
                                            }
                                        }
                                    }
                                        }
                                }else{
                                        int tambahPoint = Integer.parseInt(rs2.getString("point_member")) + pointMember;
                                        Statement st3 = dbConnection.getConnection().createStatement();
                                        String queryUpdate = String.format("update tabel_member set point_member = \"%s\" where id_member = \"%s\";", tambahPoint, this.idMemberS);
                                        st3.executeUpdate(queryUpdate);
                                        if(rs4.next()){
                                            if(rs4.next()){
                                        for(int i = 0; i < idBaru.size(); i++){
                                            try (
                                                    Statement st5 = dbConnection.getConnection().createStatement()) {
//                                            JOptionPane.showMessageDialog(rootPane, "ID barang : " + idBaru.get(i));
                                            String query5 = String.format("Select jumlah_barang from tabel_barang where id_barang = \"%s\";", idBaru.get(i));
                                            ResultSet rs5 = st5.executeQuery(query4);
                                            int jumlahBaris = tabelPembelianBarang.getRowCount();

                                            while (rs4.next()) {

        //                                        for (int d = 0; d < jumlahBaris; d++) {
                                                    int jumlahBarangDatabase = rs4.getInt("jumlah_barang");
                                                    int jumlahBarangDibeli = Integer.parseInt(tabelPembelianBarang.getValueAt(i,4).toString());
        //                                            JOptionPane.showMessageDialog(this, "nama Barang : " + );
//                                                    JOptionPane.showMessageDialog(rootPane, "Jumlah database : " + jumlahBarangDatabase);
//                                                    JOptionPane.showMessageDialog(rootPane, "Jumlah beli : " + jumlahBarangDibeli);
                                                    int jumlahBarangBaru = jumlahBarangDatabase - jumlahBarangDibeli;
//                                                    JOptionPane.showMessageDialog(rootPane, "Jumlah baru : " + jumlahBarangBaru);
                                                    String updateQuery = "UPDATE tabel_barang SET jumlah_barang = ? WHERE id_barang = ?";
                                                    try (PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(updateQuery)) {
                                                        preparedStatement.setInt(1, jumlahBarangBaru);
                                                        preparedStatement.setString(2, (String) tabelPembelianBarang.getValueAt(i, 0));
//                                                        JOptionPane.showMessageDialog(this, "ID : " + tabelPembelianBarang.getValueAt(i, 0));
                                                        int rowCount = preparedStatement.executeUpdate();
                                                        System.out.println("Baris yang diupdate: " + rowCount);
                                                    } catch (SQLException e) {
                                                        e.printStackTrace();
                                                    }
        //                                        }
                                            }
                                        }
                                    }
                                            }
                                        }
                                    }
                                }
                                JOptionPane.showMessageDialog(this, "Pembayaran berhasil!");
                                resetAll();
                                this.inputPembayaran.setText("");
                                this.idMemberS = 0;
                            }catch(SQLException e){
                                e.printStackTrace();
                            }
                        }else{
                            try {
                                Statement st1 = dbConnection.getConnection().createStatement();
                                System.out.println("HAHAHAH INI SUDAH LEBIH DALAM");
                                String query1 = String.format("insert into tabel_riwayat_pembelian(id_admin, id_member, waktu_transaksi, tanggal_transaksi, id_barang, jumlah_beli_barang, total_harga, pembayaran, nama_barang) values(\"%s\",\"%s\", curtime(), curdate(), \"%s\", \"%s\", \"%s\", \"%s\", \"%s\");", this.idAdminS, "0", this.idBarangs, jumlahPCS, this.totalHargaSemua, Integer.parseInt(this.inputPembayaran.getText()),namaBarang2);
                                st1.executeUpdate(query1);
                                System.out.println("Jumlah Beli Barang bukan member dan sama dengan : " + jumlahPCS);

                                for(int i = 0; i < idBaru.size(); i++){
                                    try (Statement st4 = dbConnection.getConnection().createStatement()) {
//                                    JOptionPane.showMessageDialog(rootPane, "ID barang : " + idBaru.get(i));
                                    String query4 = String.format("Select jumlah_barang from tabel_barang where id_barang = \"%s\";", idBaru.get(i));
                                    ResultSet rs4 = st4.executeQuery(query4);
                                    int jumlahBaris = tabelPembelianBarang.getRowCount();

                                    while (rs4.next()) {
                                        
//                                        for (int d = 0; d < jumlahBaris; d++) {
                                            int jumlahBarangDatabase = rs4.getInt("jumlah_barang");
                                            int jumlahBarangDibeli = Integer.parseInt(tabelPembelianBarang.getValueAt(i,4).toString());
//                                            JOptionPane.showMessageDialog(this, "nama Barang : " + );
//                                            JOptionPane.showMessageDialog(rootPane, "Jumlah database : " + jumlahBarangDatabase);
//                                            JOptionPane.showMessageDialog(rootPane, "Jumlah beli : " + jumlahBarangDibeli);
                                            int jumlahBarangBaru = jumlahBarangDatabase - jumlahBarangDibeli;
//                                            JOptionPane.showMessageDialog(rootPane, "Jumlah baru : " + jumlahBarangBaru);
                                            String updateQuery = "UPDATE tabel_barang SET jumlah_barang = ? WHERE id_barang = ?";
                                            try (PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(updateQuery)) {
                                                preparedStatement.setInt(1, jumlahBarangBaru);
                                                preparedStatement.setString(2, (String) tabelPembelianBarang.getValueAt(i, 0));
//                                                JOptionPane.showMessageDialog(this, "ID : " + tabelPembelianBarang.getValueAt(i, 0));
                                                int rowCount = preparedStatement.executeUpdate();
                                                System.out.println("Baris yang diupdate: " + rowCount);
                                            } catch (SQLException e) {
                                                e.printStackTrace();
                                            }
//                                        }
                                    }
                                }
                                }

                                JOptionPane.showMessageDialog(this, "Pembayaran berhasil!");
                                resetAll();
                                this.inputPembayaran.setText("");
                                this.idMemberS = 0;
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }

                        }
                        getDataBarangAll();
                    }else if(Integer.parseInt(this.inputPembayaran.getText()) > this.totalHargaSemua){
                        if(this.statusMember.getText().equals("Member")){
                            try{
                                System.out.println(this.idAdminS + " : "+this.idMemberS + " : "+ this.idBarangs + " : "+ jumlahPCS + " : "+this.totalHargaSemua + " : "+Integer.parseInt(this.inputPembayaran.getText()));
                                Statement st1 = dbConnection.getConnection().createStatement();
                                String query1 = String.format("insert into tabel_riwayat_pembelian(id_admin, id_member, waktu_transaksi, tanggal_transaksi, id_barang, jumlah_beli_barang, total_harga, pembayaran, nama_barang) values(\"%s\",\"%s\", curtime(), curdate(), \"%s\", \"%s\", \"%s\", \"%s\", \"%s\");", this.idAdminS, this.idMemberS, this.idBarangs, jumlahPCS, this.totalHargaSemua, Integer.parseInt(this.inputPembayaran.getText()),namaBarang2);
                                st1.executeUpdate(query1);
                                int pointMember = (int) (0.2 * this.totalHargaSemua);
                                Statement st2 = dbConnection.getConnection().createStatement();
                                String query2 = String.format("Select point_member from tabel_member where id_member = \"%s\";", this.idMemberS);
                                ResultSet rs2 = st2.executeQuery(query2);
                                Statement st4 = dbConnection.getConnection().createStatement();
                                String query4 = String.format("Select jumlah_barang from tabel_barang where id_barang = \"%s\";", this.idBarangs);
                                ResultSet rs4 = st4.executeQuery(query4);
                                int jumlahBaris = tabelPembelianBarang.getRowCount();
                                if(rs2.next()){
                                    if(Integer.parseInt(rs2.getString("point_member")) > 0){
                                        if(Integer.parseInt(rs2.getString("point_member")) >= 4000){
                                            Statement st3 = dbConnection.getConnection().createStatement();
                                            String queryUpdate = String.format("update tabel_member set point_member = \"%s\" where id_member = \"%s\";", Integer.parseInt(rs2.getString("point_member")) - 4000  + pointMember, this.idMemberS);
                                            st3.executeUpdate(queryUpdate);
                                            ResultSet rs1 = st3.executeQuery(query4);
                                        }else{
                                            Statement st3 = dbConnection.getConnection().createStatement();
                                            String queryUpdate = String.format("update tabel_member set point_member = \"%s\" where id_member = \"%s\";", Integer.parseInt(rs2.getString("point_member")) + pointMember, this.idMemberS);
                                            st3.executeUpdate(queryUpdate);
                                            ResultSet rs1 = st3.executeQuery(query4);
                                        }
                                        if(rs4.next()){
                                        for(int i = 0; i < idBaru.size(); i++){
                                            try (
                                            Statement st5 = dbConnection.getConnection().createStatement()) {
//                                            JOptionPane.showMessageDialog(rootPane, "ID barang : " + idBaru.get(i));
                                            String query5 = String.format("Select jumlah_barang from tabel_barang where id_barang = \"%s\";", idBaru.get(i));
                                            ResultSet rs5 = st5.executeQuery(query5);

                                            while (rs5.next()) {

        //                                        for (int d = 0; d < jumlahBaris; d++) {
                                                    int jumlahBarangDatabase = rs5.getInt("jumlah_barang");
                                                    int jumlahBarangDibeli = Integer.parseInt(tabelPembelianBarang.getValueAt(i,4).toString());
        //                                            JOptionPane.showMessageDialog(this, "nama Barang : " + );
//                                                    JOptionPane.showMessageDialog(rootPane, "Jumlah database : " + jumlahBarangDatabase);
//                                                    JOptionPane.showMessageDialog(rootPane, "Jumlah beli : " + jumlahBarangDibeli);
                                                    int jumlahBarangBaru = jumlahBarangDatabase - jumlahBarangDibeli;
//                                                    JOptionPane.showMessageDialog(rootPane, "Jumlah baru : " + jumlahBarangBaru);
                                                    String updateQuery = "UPDATE tabel_barang SET jumlah_barang = ? WHERE id_barang = ?";
                                                    try (PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(updateQuery)) {
                                                        preparedStatement.setInt(1, jumlahBarangBaru);
                                                        preparedStatement.setString(2, (String) tabelPembelianBarang.getValueAt(i, 0));
//                                                        JOptionPane.showMessageDialog(this, "ID : " + tabelPembelianBarang.getValueAt(i, 0));
                                                        int rowCount = preparedStatement.executeUpdate();
                                                        System.out.println("Baris yang diupdate: " + rowCount);
                                                    } catch (SQLException e) {
                                                        e.printStackTrace();
                                                    }
        //                                        }
                                            }
                                        }
                                    
                                        }
                                            
                                        }
                                    }else{
                                        int tambahPoint = Integer.parseInt(rs2.getString("point_member")) + pointMember;
                                        Statement st3 = dbConnection.getConnection().createStatement();
                                        String queryUpdate = String.format("update tabel_member set point_member = \"%s\" where id_member = \"%s\";", tambahPoint, this.idMemberS);
                                        st3.executeUpdate(queryUpdate);
                                        Statement st5 = dbConnection.getConnection().createStatement();
                                        if(rs4.next()){
                                        for(int i = 0; i < idBaru.size(); i++){
                                            try (
                                              Statement st6 = dbConnection.getConnection().createStatement()) {
//                                            JOptionPane.showMessageDialog(rootPane, "ID barang : " + idBaru.get(i));
                                            String query5 = String.format("Select jumlah_barang from tabel_barang where id_barang = \"%s\";", idBaru.get(i));
                                            ResultSet rs5 = st6.executeQuery(query4);

                                            while (rs4.next()) {

        //                                        for (int d = 0; d < jumlahBaris; d++) {
                                                    int jumlahBarangDatabase = rs4.getInt("jumlah_barang");
                                                    int jumlahBarangDibeli = Integer.parseInt(tabelPembelianBarang.getValueAt(i,4).toString());
        //                                            JOptionPane.showMessageDialog(this, "nama Barang : " + );
//                                                    JOptionPane.showMessageDialog(rootPane, "Jumlah database : " + jumlahBarangDatabase);
//                                                    JOptionPane.showMessageDialog(rootPane, "Jumlah beli : " + jumlahBarangDibeli);
                                                    int jumlahBarangBaru = jumlahBarangDatabase - jumlahBarangDibeli;
//                                                    JOptionPane.showMessageDialog(rootPane, "Jumlah baru : " + jumlahBarangBaru);
                                                    String updateQuery = "UPDATE tabel_barang SET jumlah_barang = ? WHERE id_barang = ?";
                                                    try (PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(updateQuery)) {
                                                        preparedStatement.setInt(1, jumlahBarangBaru);
                                                        preparedStatement.setString(2, (String) tabelPembelianBarang.getValueAt(i, 0));
//                                                        JOptionPane.showMessageDialog(this, "ID : " + tabelPembelianBarang.getValueAt(i, 0));
                                                        int rowCount = preparedStatement.executeUpdate();
                                                        System.out.println("Baris yang diupdate: " + rowCount);
                                                    } catch (SQLException e) {
                                                        e.printStackTrace();
                                                    }
        //                                        }
                                            }
                                        }
                                            
                                        }
                                        
                                            
                                        }
                                    }
                                }JOptionPane.showMessageDialog(this, "Pembayaran berhasil! Uang Kembalian Anda : Rp" + df.format(Integer.parseInt(this.inputPembayaran.getText()) - this.totalHargaSemua));
                                
                                resetAll();
                                this.inputPembayaran.setText("");
                                this.idMemberS = 0;
                            }catch(SQLException e){
                                e.printStackTrace();
                            }
                        }else{
                            try{
                                        for(int i = 0; i < idBaru.size(); i++){
                                            try (
                                            Statement st5 = dbConnection.getConnection().createStatement()) {
//                                            JOptionPane.showMessageDialog(rootPane, "ID barang : " + idBaru.get(i));
                                            String query5 = String.format("Select jumlah_barang from tabel_barang where id_barang = \"%s\";", idBaru.get(i));
                                            ResultSet rs5 = st5.executeQuery(query5);
                                            int jumlahBaris = tabelPembelianBarang.getRowCount();

                                            while (rs5.next()) {

        //                                        for (int d = 0; d < jumlahBaris; d++) {
                                                    int jumlahBarangDatabase = rs5.getInt("jumlah_barang");
                                                    int jumlahBarangDibeli = Integer.parseInt(tabelPembelianBarang.getValueAt(i,4).toString());
        //                                            JOptionPane.showMessageDialog(this, "nama Barang : " + );
//                                                    JOptionPane.showMessageDialog(rootPane, "Jumlah database : " + jumlahBarangDatabase);
//                                                    JOptionPane.showMessageDialog(rootPane, "Jumlah beli : " + jumlahBarangDibeli);
                                                    int jumlahBarangBaru = jumlahBarangDatabase - jumlahBarangDibeli;
//                                                    JOptionPane.showMessageDialog(rootPane, "Jumlah baru : " + jumlahBarangBaru);
                                                    String updateQuery = "UPDATE tabel_barang SET jumlah_barang = ? WHERE id_barang = ?";
                                                    try (PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(updateQuery)) {
                                                        preparedStatement.setInt(1, jumlahBarangBaru);
                                                        preparedStatement.setString(2, (String) tabelPembelianBarang.getValueAt(i, 0));
//                                                        JOptionPane.showMessageDialog(this, "ID : " + tabelPembelianBarang.getValueAt(i, 0));
                                                        int rowCount = preparedStatement.executeUpdate();
                                                        System.out.println("Baris yang diupdate: " + rowCount);
                                                    } catch (SQLException e) {
                                                        e.printStackTrace();
                                                    }
        //                                        }
                                            }
                                        
                                    }
                                    
                                }
                                JOptionPane.showMessageDialog(this, "Pembayaran berhasil!");
                                resetAll();
                                this.inputPembayaran.setText("");
                                this.idMemberS = 0;
                            }catch(SQLException e){
                                e.printStackTrace();
                        }
                    }
                }
                getDataBarangAll();
            }
        }
    }//GEN-LAST:event_tombolBayarActionPerformed

    private void inputPembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputPembayaranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputPembayaranActionPerformed

    private void tabelPembelianBarangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPembelianBarangMouseExited
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tabelPembelianBarangMouseExited

    private void tabelPembelianBarangFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabelPembelianBarangFocusLost
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tabelPembelianBarangFocusLost

    private void tombolKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolKembaliActionPerformed
        // TODO add your handling code here:
        MainMenu exitPembayaran = new MainMenu(this.namaAdmin.getText(), this.idAdminS);
        exitPembayaran.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_tombolKembaliActionPerformed

    private void jumlahBarangYangDibeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumlahBarangYangDibeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jumlahBarangYangDibeliActionPerformed

    private void tabelDataBarangFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabelDataBarangFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelDataBarangFocusLost

    private void tabelDataBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelDataBarangMouseClicked
        // TODO add your handling code here:
        this.baris2 = this.tabelDataBarang.getSelectedRow();
//        JOptionPane.showMessageDialog(rootPane, "Baris :" + this.baris2);
    }//GEN-LAST:event_tabelDataBarangMouseClicked

    private void tabelDataBarangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelDataBarangMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelDataBarangMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonTambah;
    private javax.swing.JToggleButton daftarMember;
    private javax.swing.JLabel hargaAkhir;
    private javax.swing.JLabel idAdmin;
    private javax.swing.JTextField inputPembayaran;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jumlahBarangYangDibeli;
    private javax.swing.JLabel namaAdmin;
    private javax.swing.JLabel potonganDiskon;
    private javax.swing.JTextField searchByID;
    private javax.swing.JLabel statusMember;
    private javax.swing.JTable tabelDataBarang;
    private javax.swing.JTable tabelPembelianBarang;
    private javax.swing.JLabel teksTotal;
    private javax.swing.JButton tombolBayar;
    private javax.swing.JButton tombolHapus;
    private javax.swing.JButton tombolKembali;
    private javax.swing.JToggleButton tombolReset;
    private javax.swing.JButton tombolSearch;
    private javax.swing.JButton tombolSimpan;
    private javax.swing.JButton tombolUbah;
    private javax.swing.JLabel totalHargaKeseluruhan;
    // End of variables declaration//GEN-END:variables
}
