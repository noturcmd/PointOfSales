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
    DecimalFormat df=new DecimalFormat("#,###.##");
    DaftarMember dfm = null;
    int totalHargaSemua;
    int idAdminS;
    int idMemberS;
    int idBarangs;
    int jumlahBeliBarang;
    
    public Pembayaran(){
        initComponents();
        this.dbConnection = KoneksiDatabase.getInstance();
        getDataBarang();
        System.out.println(getSize());
        this.tombolSimpan.setVisible(false);
        this.inputPembayaran.setBackground(new Color(14,41,84));
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
        daftarMember = new javax.swing.JToggleButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        searchByID = new javax.swing.JTextField();
        statusMember = new javax.swing.JLabel();
        tombolSearch = new javax.swing.JButton();
        tombolReset = new javax.swing.JToggleButton();
        tombolSimpan = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        inputPembayaran = new javax.swing.JTextField();
        tombolBayar = new javax.swing.JButton();
        teksTotal = new javax.swing.JLabel();

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
        tabelPembelianBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelPembelianBarangMouseClicked(evt);
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

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(166, 156, 172));
        jLabel4.setText("Kategori");

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

        jLabel12.setForeground(new java.awt.Color(241, 218, 196));

        searchByID.setBackground(new java.awt.Color(14, 41, 84));
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tombolBayar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(inputPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(207, 207, 207)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(totalHargaKeseluruhan, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(potonganDiskon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(768, 768, 768)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(teksTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(hargaAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(daftarMember, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(buttonTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(9, 9, 9)
                                                    .addComponent(tombolUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(tombolHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(42, 42, 42)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(listNamaBarang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(listKategoriBarang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jumlahBarangYangDibeli)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                            .addComponent(searchByID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                                            .addComponent(statusMember, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                                                        .addComponent(tombolSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(tombolReset, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(tombolSimpan))))))
                                .addGap(9, 9, 9)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1036, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(120, 120, 120)))
                .addGap(229, 229, 229))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(84, 84, 84))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(hargaAkhir)
                                    .addComponent(teksTotal))
                                .addGap(38, 38, 38)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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
                                            .addComponent(listKategoriBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tombolSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                            .addComponent(searchByID)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(tombolSearch)
                                        .addComponent(tombolReset)))
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
                                    .addComponent(daftarMember)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalHargaKeseluruhan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(potonganDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(530, 530, 530)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tombolBayar)))
                .addContainerGap(529, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        if(!this.jumlahBarangYangDibeli.getText().matches("\\d*")){
            JOptionPane.showMessageDialog(this, "Mohon input jumlah yang valid!");
        }else if (this.jumlahBarangYangDibeli.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Input jumlah kosong!");
        }else if (this.jumlahBarangYangDibeli.getText().matches("\\d*") && Integer.parseInt(this.jumlahBarangYangDibeli.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "Mohon input jumlah yang valid!");
        }else if(this.jumlahBarangYangDibeli.getText().matches("\\d*") && Integer.parseInt(this.jumlahBarangYangDibeli.getText()) > 0){
            try {
                Statement st1 = dbConnection.getConnection().createStatement();
                String query1 = String.format("SELECT id_barang, kategori_barang, harga_barang FROM tabel_barang WHERE nama_barang = \"%s\";", this.listNamaBarang.getSelectedItem().toString());
                ResultSet rs1 = st1.executeQuery(query1);

                if (rs1.next()) {
                    this.jumlahBeliBarang = Integer.parseInt(this.jumlahBarangYangDibeli.getText());
                    this.idBarangs = Integer.parseInt(rs1.getString("id_barang"));
                    int jumlahBaris = modelTblPbl.getRowCount();
                    int index = 0;
                    boolean idFound = false;

                    while (index < jumlahBaris) {
                        if (Integer.parseInt((String) this.modelTblPbl.getValueAt(index, 0)) == Integer.parseInt(rs1.getString("id_barang"))) {
                            System.out.println("Kondisi 11111");
                            String jumlah = String.valueOf(Integer.parseInt((String) this.modelTblPbl.getValueAt(index, 3)) + Integer.parseInt(this.jumlahBarangYangDibeli.getText()));
                            modelTblPbl.setValueAt(rs1.getString("id_barang"), index, 0);
                            modelTblPbl.setValueAt(this.listNamaBarang.getSelectedItem().toString(), index, 1);
                            modelTblPbl.setValueAt(rs1.getString("kategori_barang"), index, 2);
                            modelTblPbl.setValueAt(jumlah, index, 3);
                            int harga123 = Integer.parseInt(String.valueOf(modelTblPbl.getValueAt(index, 3))) * Integer.parseInt(rs1.getString("harga_barang"));
                            modelTblPbl.setValueAt(df.format(harga123), index, 4);
                            idFound = true;
                            break;
                        }
                        index++;
                    }
                    if (!idFound) {
                        System.out.println("Kondisi 22222");
                        modelTblPbl.addRow(new Object[]{rs1.getString("id_barang"), this.listNamaBarang.getSelectedItem().toString(), rs1.getString("kategori_barang"), this.jumlahBarangYangDibeli.getText(), df.format(Integer.parseInt(rs1.getString("harga_barang")) * Integer.parseInt(this.jumlahBarangYangDibeli.getText()))});
                    }
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
                        this.hargaAkhir.setText("Rp" + df.format(hargaAfterDiskon));
                        this.totalHargaSemua = hargaAfterDiskon;
                    }
                     
                          
                }
                
                
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_buttonTambahActionPerformed

    private void tombolUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolUbahActionPerformed
        // TODO add your handling code here:
        this.tombolSimpan.setVisible(true);
        
    }//GEN-LAST:event_tombolUbahActionPerformed

    private void tombolHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolHapusActionPerformed
        // TODO add your handling code here:
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
                    this.potonganDiskon.setText("Rp" + df.format(diskon));
                    this.hargaAkhir.setText("Rp" + String.valueOf(df.format(Integer.parseInt(harga4) - diskon)));
                    this.totalHargaSemua = Integer.parseInt(harga4) - diskon;
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
    }//GEN-LAST:event_tombolResetActionPerformed

    private void tabelPembelianBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPembelianBarangMouseClicked
        // TODO add your handling code here:
        int row = tabelPembelianBarang.getSelectedRow();
        DefaultTableModel getTableForEdit = (DefaultTableModel) tabelPembelianBarang.getModel();
        
    }//GEN-LAST:event_tabelPembelianBarangMouseClicked

    private void tombolSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolSimpanActionPerformed
        // TODO add your handling code here:
        JOptionPane jop = new JOptionPane();
        int jawab = jop.showConfirmDialog(this, "Ingin menyimpan perubahan?");
        switch(jawab){
            case JOptionPane.YES_OPTION: 
                                        this.tombolSimpan.setVisible(false);
                                        break;
            case JOptionPane.NO_OPTION: 
                                        break;
            case JOptionPane.CANCEL_OPTION: 
                                        break;
        }
    }//GEN-LAST:event_tombolSimpanActionPerformed

    private void tombolBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolBayarActionPerformed
        // TODO add your handling code here:
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
                            String query1 = String.format("insert into tabel_riwayat_pembelian(id_admin, id_member, waktu_transaksi, tanggal_transaksi, id_barang, jumlah_beli_barang, total_harga, pembayaran, nama_barang) values(\"%s\",\"%s\", curtime(), curdate(), \"%s\", \"%s\", \"%s\", \"%s\", \"%s\");", this.idAdminS, this.idMemberS, this.idBarangs, this.jumlahBeliBarang, this.totalHargaSemua, Integer.parseInt(this.inputPembayaran.getText()), this.listNamaBarang.getSelectedItem().toString());
                            st1.executeUpdate(query1);
                            int pointMember = (int) (0.2 * this.jumlahBeliBarang);
                            Statement st2 = dbConnection.getConnection().createStatement();
                            String query2 = String.format("Select point_member from tabel_member where id_member = \"%s\";", this.idMemberS);
                            ResultSet rs2 = st2.executeQuery(query2);
                            Statement st4 = dbConnection.getConnection().createStatement();
                            String query4 = String.format("Select jumlah_barang from tabel_barang where id_barang = \"%s\";", this.idBarangs);
                            ResultSet rs4 = st4.executeQuery(query4);
                            if(rs2.next()){
                                if(Integer.parseInt(rs2.getString("point_member")) > 0){
                                    Statement st3 = dbConnection.getConnection().createStatement();
                                    String queryUpdate = String.format("update tabel_member set point_member = \"%s\" where id_member = \"%s\";", pointMember, this.idMemberS);
                                    st3.executeUpdate(queryUpdate);
                                    if(rs4.next()){
                                        Statement st5 = dbConnection.getConnection().createStatement();
                                        String queryUpdate2 = String.format("update tabel_barang set jumlah_barang = \"%s\" where id_barang = \"%s\";", (Integer.parseInt(rs4.getString("jumlah_barang")) -this.jumlahBeliBarang), this.idBarangs);
                                        st5.executeUpdate(queryUpdate2);
                                }
                                }else{
                                    int tambahPoint = Integer.parseInt(rs2.getString("point_member")) + pointMember;
                                    Statement st3 = dbConnection.getConnection().createStatement();
                                    String queryUpdate = String.format("update tabel_member set point_member = \"%s\" where id_member = \"%s\";", tambahPoint, this.idMemberS);
                                    st3.executeUpdate(queryUpdate);
                                    if(rs4.next()){
                                        Statement st5 = dbConnection.getConnection().createStatement();
                                        String queryUpdate2 = String.format("update tabel_barang set jumlah_barang = \"%s\" where id_barang = \"%s\";", (Integer.parseInt(rs4.getString("jumlah_barang")) -this.jumlahBeliBarang), this.idBarangs);
                                        st5.executeUpdate(queryUpdate2);
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
                        try{
                            Statement st1 = dbConnection.getConnection().createStatement();
                            String query1 = String.format("insert into tabel_riwayat_pembelian(id_admin, id_member, waktu_transaksi, tanggal_transaksi, id_barang, jumlah_beli_barang, total_harga, pembayaran, nama_barang) values(\"%s\",\"%s\", curtime(), curdate(), \"%s\", \"%s\", \"%s\", \"%s\", \"%s\");", this.idAdminS, "0", this.idBarangs, this.jumlahBeliBarang, this.totalHargaSemua, Integer.parseInt(this.inputPembayaran.getText()),this.listNamaBarang.getSelectedItem().toString());
                            st1.executeUpdate(query1);
                            Statement st4 = dbConnection.getConnection().createStatement();
                            String query4 = String.format("Select jumlah_barang from tabel_barang where id_barang = \"%s\";", this.idBarangs);
                            ResultSet rs4 = st4.executeQuery(query4);
                            if(rs4.next()){
                                String queryUpdate2 = String.format("update tabel_barang set jumlah_barang = \"%s\" where id_barang = \"%s\";", (Integer.parseInt(rs4.getString("jumlah_barang")) -this.jumlahBeliBarang), this.idBarangs);
                                st4.executeUpdate(queryUpdate2);
                            }
                            JOptionPane.showMessageDialog(this, "Pembayaran berhasil!");
                            resetAll();
                            this.inputPembayaran.setText("");
                            this.idMemberS = 0;
                        }catch(SQLException e){
                            e.printStackTrace();
                        }
                    }
                }else if(Integer.parseInt(this.inputPembayaran.getText()) > this.totalHargaSemua){
                    if(this.statusMember.getText().equals("Member")){
                        try{
                            System.out.println(this.idAdminS + " : "+this.idMemberS + " : "+ this.idBarangs + " : "+ this.jumlahBeliBarang + " : "+this.totalHargaSemua + " : "+Integer.parseInt(this.inputPembayaran.getText()));
                            Statement st1 = dbConnection.getConnection().createStatement();
                            String query1 = String.format("insert into tabel_riwayat_pembelian(id_admin, id_member, waktu_transaksi, tanggal_transaksi, id_barang, jumlah_beli_barang, total_harga, pembayaran, nama_barang) values(\"%s\",\"%s\", curtime(), curdate(), \"%s\", \"%s\", \"%s\", \"%s\", \"%s\");", this.idAdminS, this.idMemberS, this.idBarangs, this.jumlahBeliBarang, this.totalHargaSemua, Integer.parseInt(this.inputPembayaran.getText()),this.listNamaBarang.getSelectedItem().toString());
                            st1.executeUpdate(query1);
                            int pointMember = (int) (0.2 * this.totalHargaSemua);
                            Statement st2 = dbConnection.getConnection().createStatement();
        //                    JOptionPane.showMessageDialog(rootPane, "ID member : " + this.idMemberS);
                            String query2 = String.format("Select point_member from tabel_member where id_member = \"%s\";", this.idMemberS);
                            ResultSet rs2 = st2.executeQuery(query2);
                            Statement st4 = dbConnection.getConnection().createStatement();
                            String query4 = String.format("Select jumlah_barang from tabel_barang where id_barang = \"%s\";", this.idBarangs);
                            ResultSet rs4 = st4.executeQuery(query4);
                            if(rs2.next()){
                                if(Integer.parseInt(rs2.getString("point_member")) > 0){
                                    Statement st3 = dbConnection.getConnection().createStatement();
                                    String queryUpdate = String.format("update tabel_member set point_member = \"%s\" where id_member = \"%s\";", pointMember, this.idMemberS);
                                    st3.executeUpdate(queryUpdate);
                                    if(rs4.next()){
                                        Statement st5 = dbConnection.getConnection().createStatement();
                                        String queryUpdate2 = String.format("update tabel_barang set jumlah_barang = \"%s\" where id_barang = \"%s\";", (Integer.parseInt(rs4.getString("jumlah_barang")) -this.jumlahBeliBarang), this.idBarangs);
                                        st5.executeUpdate(queryUpdate2);
                                    }
                                }else{
                                    int tambahPoint = Integer.parseInt(rs2.getString("point_member")) + pointMember;
                                    Statement st3 = dbConnection.getConnection().createStatement();
                                    String queryUpdate = String.format("update tabel_member set point_member = \"%s\" where id_member = \"%s\";", tambahPoint, this.idMemberS);
                                    st3.executeUpdate(queryUpdate);
                                    Statement st5 = dbConnection.getConnection().createStatement();
                                    if(rs4.next()){
                                        String queryUpdate2 = String.format("update tabel_barang set jumlah_barang = \"%s\" where id_barang = \"%s\";", (Integer.parseInt(rs4.getString("jumlah_barang")) -this.jumlahBeliBarang), this.idBarangs);
                                        st5.executeUpdate(queryUpdate2);
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
                        try{
                            Statement st1 = dbConnection.getConnection().createStatement();
                            String query1 = String.format("insert into tabel_riwayat_pembelian(id_admin, id_member, waktu_transaksi, tanggal_transaksi, id_barang, jumlah_beli_barang, total_harga, pembayaran, nama_barang) values(\"%s\",\"%s\", curtime(), curdate(), \"%s\", \"%s\", \"%s\", \"%s\", \"%s\");", this.idAdminS, "0", this.idBarangs, this.jumlahBeliBarang, this.totalHargaSemua, Integer.parseInt(this.inputPembayaran.getText()),this.listNamaBarang.getSelectedItem().toString());
                            st1.executeUpdate(query1);
                            Statement st4 = dbConnection.getConnection().createStatement();
                            String query4 = String.format("Select jumlah_barang from tabel_barang where id_barang = \"%s\";", this.idBarangs);
                            ResultSet rs4 = st4.executeQuery(query4);
                            if(rs4.next()){
                                String queryUpdate2 = String.format("update tabel_barang set jumlah_barang = \"%s\" where id_barang = \"%s\";", (Integer.parseInt(rs4.getString("jumlah_barang")) -this.jumlahBeliBarang), this.idBarangs);
                                st1.executeUpdate(queryUpdate2);
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
        }
    }//GEN-LAST:event_tombolBayarActionPerformed

    private void inputPembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputPembayaranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputPembayaranActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonTambah;
    private javax.swing.JToggleButton daftarMember;
    private javax.swing.JLabel hargaAkhir;
    private javax.swing.JLabel idAdmin;
    private javax.swing.JTextField inputPembayaran;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jumlahBarangYangDibeli;
    private javax.swing.JComboBox<String> listKategoriBarang;
    private javax.swing.JComboBox<String> listNamaBarang;
    private javax.swing.JLabel namaAdmin;
    private javax.swing.JLabel potonganDiskon;
    private javax.swing.JTextField searchByID;
    private javax.swing.JLabel statusMember;
    private javax.swing.JTable tabelPembelianBarang;
    private javax.swing.JLabel teksTotal;
    private javax.swing.JButton tombolBayar;
    private javax.swing.JButton tombolHapus;
    private javax.swing.JToggleButton tombolReset;
    private javax.swing.JButton tombolSearch;
    private javax.swing.JButton tombolSimpan;
    private javax.swing.JButton tombolUbah;
    private javax.swing.JLabel totalHargaKeseluruhan;
    // End of variables declaration//GEN-END:variables
}
