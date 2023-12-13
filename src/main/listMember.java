/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;
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
        butUbah = new javax.swing.JButton();
        butRefresh = new javax.swing.JButton();

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

        butUbah.setText("Ubah");
        butUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butUbahActionPerformed(evt);
            }
        });

        butRefresh.setText("Refresh");
        butRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(tombolkeluar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(butRefresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tombolhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(butUbah)
                .addGap(18, 18, 18)
                .addComponent(tomboldaftar)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tombolhapus)
                    .addComponent(tombolkeluar)
                    .addComponent(tomboldaftar)
                    .addComponent(butUbah)
                    .addComponent(butRefresh))
                .addGap(0, 15, Short.MAX_VALUE))
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
//                System.out.println("Baris : "  +tabelMember.getValueAt(this.baris, 0));
                String getID = (String) tabelMember.getValueAt(this.baris, 0);
                Statement st1 = dbConnection.getConnection().createStatement();
                String query1 = String.format("delete from tabel_member where id_member = \"%s\";", getID);
                st1.executeUpdate(query1);
            }catch(SQLException e){
                e.printStackTrace();
            }
            this.forMember.removeRow(this.baris);
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
        }
    }//GEN-LAST:event_tombolhapusActionPerformed

    private void tomboldaftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tomboldaftarActionPerformed
            // TODO add your handling code here:
            DaftarMember daftarMember = new DaftarMember();
            daftarMember.setVisible(true);
    }//GEN-LAST:event_tomboldaftarActionPerformed

    private void butUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butUbahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_butUbahActionPerformed

    private void tabelMemberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMemberMouseClicked
        // TODO add your handling code here:
        this.baris = tabelMember.getSelectedRow();
    }//GEN-LAST:event_tabelMemberMouseClicked

    private void butRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butRefreshActionPerformed
        // TODO add your handling code here:
        this.forMember.setRowCount(0);
        this.tampilkanMember();
    }//GEN-LAST:event_butRefreshActionPerformed

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
    private javax.swing.JButton butUbah;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelMember;
    private javax.swing.JButton tomboldaftar;
    private javax.swing.JButton tombolhapus;
    private javax.swing.JButton tombolkeluar;
    // End of variables declaration//GEN-END:variables
}
