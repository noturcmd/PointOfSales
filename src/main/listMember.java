/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Lenovo
 */
public class listMember extends javax.swing.JFrame {
    private KoneksiDatabase dbConnection;
    
    DefaultTableModel forMember;
    DaftarMember daftarMember = null;
    
    Integer baris;
    int idAdminS;
    String namaAdmins;
    public listMember(String nama, int id) {
        this.namaAdmins = nama;
        this.idAdminS = id;
        this.dbConnection = KoneksiDatabase.getInstance();
        initComponents();
        setLocationRelativeTo(null);
        this.tampilkanMember();
    }
    
    void tampilkanMember(){
        this.forMember = (DefaultTableModel) tabelMember.getModel();
        try{
            Statement st1 = this.dbConnection.getConnection().createStatement();
            String query1 = "Select * from tabel_member;";
            ResultSet rs1 = st1.executeQuery(query1);
            while(rs1.next()){
                forMember.addRow(new Object[]{rs1.getString(1), rs1.getString(2), rs1.getString(3),rs1.getString(4)});
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelMember = new javax.swing.JTable();
        tombolkeluar = new javax.swing.JButton();
        tombolhapus = new javax.swing.JButton();
        tomboldaftar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ubahNoHP = new javax.swing.JTextField();
        butRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(166, 156, 172));
        jPanel1.setPreferredSize(new java.awt.Dimension(964, 412));

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(241, 218, 196));
        jLabel2.setText("Member ATK ");

        tabelMember.setBackground(new java.awt.Color(71, 73, 115));
        tabelMember.setForeground(new java.awt.Color(241, 218, 196));
        tabelMember.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NAMA", "NO HP", "POINT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelMember.setGridColor(new java.awt.Color(241, 218, 196));
        tabelMember.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMemberMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelMember);
        if (tabelMember.getColumnModel().getColumnCount() > 0) {
            tabelMember.getColumnModel().getColumn(0).setResizable(false);
            tabelMember.getColumnModel().getColumn(1).setResizable(false);
            tabelMember.getColumnModel().getColumn(2).setResizable(false);
            tabelMember.getColumnModel().getColumn(3).setResizable(false);
        }

        tombolkeluar.setBackground(new java.awt.Color(241, 218, 196));
        tombolkeluar.setForeground(new java.awt.Color(13, 12, 29));
        tombolkeluar.setText("Kembali");
        tombolkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolkeluarActionPerformed(evt);
            }
        });

        tombolhapus.setBackground(new java.awt.Color(241, 218, 196));
        tombolhapus.setForeground(new java.awt.Color(13, 12, 29));
        tombolhapus.setText("Hapus");
        tombolhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolhapusActionPerformed(evt);
            }
        });

        tomboldaftar.setBackground(new java.awt.Color(241, 218, 196));
        tomboldaftar.setForeground(new java.awt.Color(13, 12, 29));
        tomboldaftar.setText("Daftar");
        tomboldaftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tomboldaftarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(241, 218, 196));
        jLabel1.setText("No HP :");

        ubahNoHP.setBackground(new java.awt.Color(166, 156, 172));
        ubahNoHP.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        ubahNoHP.setForeground(new java.awt.Color(22, 27, 51));
        ubahNoHP.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(71, 73, 115)));
        ubahNoHP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahNoHPActionPerformed(evt);
            }
        });
        ubahNoHP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ubahNoHPKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ubahNoHPKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ubahNoHPKeyTyped(evt);
            }
        });

        butRefresh.setBackground(new java.awt.Color(241, 218, 196));
        butRefresh.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        butRefresh.setText("Refresh");
        butRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 905, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(tombolkeluar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(127, 127, 127)
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(ubahNoHP)
                                        .addGap(62, 62, 62)))
                                .addComponent(butRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tombolhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tomboldaftar))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(399, 399, 399)
                        .addComponent(jLabel2)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ubahNoHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(tombolkeluar)
                    .addComponent(tombolhapus)
                    .addComponent(tomboldaftar)
                    .addComponent(butRefresh))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tombolkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolkeluarActionPerformed
        MainMenu exitMember = new MainMenu(this.namaAdmins, this.idAdminS);
        exitMember.setVisible(true);
        this.dispose();       
    }//GEN-LAST:event_tombolkeluarActionPerformed

    private void tombolhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolhapusActionPerformed
        // TODO add your handling code here:
        if(this.baris == null){
            JOptionPane.showMessageDialog(this, "Tidak ada baris yang dipilih!");
        }else{
            try{
                String getID = (String) tabelMember.getValueAt(this.baris, 0);
                Statement st1 = dbConnection.getConnection().createStatement();
                String query1 = String.format("delete from tabel_member where id_member = \"%s\";", getID);
                st1.executeUpdate(query1);
            }catch(SQLException e){
                e.printStackTrace();
            }
            this.forMember.removeRow(this.baris);
            this.baris = null;
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus!"); 
        }
    }//GEN-LAST:event_tombolhapusActionPerformed

    private void tomboldaftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tomboldaftarActionPerformed
            // TODO add your handling code here:
            if(this.daftarMember == null){
                this.daftarMember = new DaftarMember();
            }
            daftarMember.setVisible(true);
            
            
            
    }//GEN-LAST:event_tomboldaftarActionPerformed

    private void tabelMemberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMemberMouseClicked
        // TODO add your handling code here:
        this.baris = tabelMember.getSelectedRow();
        this.ubahNoHP.setText((String) this.tabelMember.getValueAt(this.baris, 2));
    }//GEN-LAST:event_tabelMemberMouseClicked

    private void ubahNoHPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahNoHPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ubahNoHPActionPerformed

    private void ubahNoHPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ubahNoHPKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try{
                Statement st1 = this.dbConnection.getConnection().createStatement();
                String query1 = String.format("update tabel_member set nohp_member = \"%s\" where id_member = \"%s\";",this.ubahNoHP.getText(), this.tabelMember.getValueAt(this.baris, 0));
                st1.executeUpdate(query1);
                JOptionPane.showMessageDialog(this, "Berhasil diubah!");
                this.ubahNoHP.setText("");
                this.ubahNoHP.setFocusable(false);
                this.baris = null;
                
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        
    }//GEN-LAST:event_ubahNoHPKeyPressed

    private void ubahNoHPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ubahNoHPKeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_ubahNoHPKeyReleased

    private void ubahNoHPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ubahNoHPKeyTyped
        // TODO add your handling code here:
        this.tabelMember.setValueAt(this.ubahNoHP.getText(), this.baris, 2);
    }//GEN-LAST:event_ubahNoHPKeyTyped

    private void butRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butRefreshActionPerformed
        // TODO add your handling code here:
        this.forMember.setRowCount(0);
        this.tampilkanMember();
    }//GEN-LAST:event_butRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butRefresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelMember;
    private javax.swing.JButton tomboldaftar;
    private javax.swing.JButton tombolhapus;
    private javax.swing.JButton tombolkeluar;
    private javax.swing.JTextField ubahNoHP;
    // End of variables declaration//GEN-END:variables
}
