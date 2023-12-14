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
    
    Integer baris;
    public listMember() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelMember = new javax.swing.JTable();
        tombolkeluar = new javax.swing.JButton();
        tombolhapus = new javax.swing.JButton();
        tomboldaftar = new javax.swing.JButton();
        butRefresh = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ubahNoHP = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

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

        tombolkeluar.setText("Kembali");
        tombolkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolkeluarActionPerformed(evt);
            }
        });

        tombolhapus.setText("Hapus");
        tombolhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolhapusActionPerformed(evt);
            }
        });

        tomboldaftar.setText("Daftar");
        tomboldaftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tomboldaftarActionPerformed(evt);
            }
        });

        butRefresh.setText("Refresh");
        butRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butRefreshActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel1.setText("No HP ");

        ubahNoHP.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
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
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(tombolkeluar)
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(ubahNoHP, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addGap(91, 91, 91)
                .addComponent(butRefresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tombolhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tomboldaftar)
                .addGap(114, 114, 114))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tombolhapus)
                            .addComponent(tombolkeluar)
                            .addComponent(tomboldaftar)
                            .addComponent(butRefresh))
                        .addGap(0, 5, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ubahNoHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tombolkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolkeluarActionPerformed
        MainMenu exitMember = new MainMenu();
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
            DaftarMember daftarMember = new DaftarMember();
            daftarMember.setVisible(true);
    }//GEN-LAST:event_tomboldaftarActionPerformed

    private void tabelMemberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMemberMouseClicked
        // TODO add your handling code here:
        this.baris = tabelMember.getSelectedRow();
        this.ubahNoHP.setText((String) this.tabelMember.getValueAt(this.baris, 2));
    }//GEN-LAST:event_tabelMemberMouseClicked

    private void butRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butRefreshActionPerformed
        // TODO add your handling code here:
        this.forMember.setRowCount(0);
        this.tampilkanMember();
    }//GEN-LAST:event_butRefreshActionPerformed

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
        this.tabelMember.setValueAt(this.ubahNoHP.getText(), this.baris, 2);
        
    }//GEN-LAST:event_ubahNoHPKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(listMember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(listMember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(listMember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listMember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listMember().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butRefresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelMember;
    private javax.swing.JButton tomboldaftar;
    private javax.swing.JButton tombolhapus;
    private javax.swing.JButton tombolkeluar;
    private javax.swing.JTextField ubahNoHP;
    // End of variables declaration//GEN-END:variables
}
