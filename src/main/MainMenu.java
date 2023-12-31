/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author acer_
 */
public class MainMenu extends javax.swing.JFrame {

    
    private int idAdminS;
    private String namaAdmins;
    
    public MainMenu(String nama, int id) {
        this.idAdminS = id;
        this.namaAdmins = nama;
        initComponents();
        setLocationRelativeTo(null);
//        buttonRiwayatTransaksi.setText("Riwayat \nTransaksi");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMainMenu = new javax.swing.JPanel();
        buttonInputBarang = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        buttonMember = new javax.swing.JButton();
        buttonPembayaran = new javax.swing.JButton();
        buttonRiwayatTransaksi = new javax.swing.JButton();
        tombolLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelMainMenu.setBackground(new java.awt.Color(241, 218, 196));
        panelMainMenu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(71, 73, 115), 10, true));

        buttonInputBarang.setBackground(new java.awt.Color(74, 65, 80));
        buttonInputBarang.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        buttonInputBarang.setForeground(new java.awt.Color(241, 218, 196));
        buttonInputBarang.setText("Input Barang");
        buttonInputBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInputBarangActionPerformed(evt);
            }
        });

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logo/Screenshot__241_-removebg-preview (2).png"))); // NOI18N

        buttonMember.setBackground(new java.awt.Color(74, 65, 80));
        buttonMember.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        buttonMember.setForeground(new java.awt.Color(241, 218, 196));
        buttonMember.setText("Member");
        buttonMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMemberActionPerformed(evt);
            }
        });

        buttonPembayaran.setBackground(new java.awt.Color(74, 65, 80));
        buttonPembayaran.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        buttonPembayaran.setForeground(new java.awt.Color(241, 218, 196));
        buttonPembayaran.setText("Pembayaran");
        buttonPembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPembayaranActionPerformed(evt);
            }
        });

        buttonRiwayatTransaksi.setBackground(new java.awt.Color(74, 65, 80));
        buttonRiwayatTransaksi.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        buttonRiwayatTransaksi.setForeground(new java.awt.Color(241, 218, 196));
        buttonRiwayatTransaksi.setText("Riwayat Transaksi");
        buttonRiwayatTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRiwayatTransaksiActionPerformed(evt);
            }
        });

        tombolLogout.setBackground(new java.awt.Color(71, 73, 115));
        tombolLogout.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        tombolLogout.setForeground(new java.awt.Color(204, 204, 204));
        tombolLogout.setText("Logout");
        tombolLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMainMenuLayout = new javax.swing.GroupLayout(panelMainMenu);
        panelMainMenu.setLayout(panelMainMenuLayout);
        panelMainMenuLayout.setHorizontalGroup(
            panelMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainMenuLayout.createSequentialGroup()
                .addGroup(panelMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMainMenuLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(panelMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMainMenuLayout.createSequentialGroup()
                                .addComponent(buttonPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonRiwayatTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelMainMenuLayout.createSequentialGroup()
                                .addComponent(buttonInputBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonMember, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tombolLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelMainMenuLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(logo)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        panelMainMenuLayout.setVerticalGroup(
            panelMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainMenuLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(logo)
                .addGap(18, 18, 18)
                .addGroup(panelMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonInputBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonMember, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelMainMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRiwayatTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(tombolLogout)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonInputBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInputBarangActionPerformed
        // TODO add your handling code here:
        dispose();
        InputBarang ib = new InputBarang();
        ib.getAdminBio(this.namaAdmins, this.idAdminS);
        ib.setVisible(true);
    }//GEN-LAST:event_buttonInputBarangActionPerformed

    private void buttonPembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPembayaranActionPerformed
        // TODO add your handling code here:
        dispose();
        Pembayaran mp = new Pembayaran();
        mp.getAdminBio(this.namaAdmins, this.idAdminS);
        mp.setVisible(true);
//        mp.setExtendedState(mp.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    }//GEN-LAST:event_buttonPembayaranActionPerformed

    private void buttonRiwayatTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRiwayatTransaksiActionPerformed
        // TODO add your handling code here:
        dispose();
        RiwayatPembelian rp = new RiwayatPembelian(this.namaAdmins, this.idAdminS);
        rp.getAdminBio(this.namaAdmins, this.idAdminS);
        rp.setVisible(true);
    }//GEN-LAST:event_buttonRiwayatTransaksiActionPerformed

    private void buttonMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMemberActionPerformed
        // TODO add your handling code here:
        dispose();
        listMember lm = new listMember(this.namaAdmins, this.idAdminS);
        lm.setVisible(true); 
    }//GEN-LAST:event_buttonMemberActionPerformed

    private void tombolLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolLogoutActionPerformed
        // TODO add your handling code here:
        this.dispose();
        login lg = new login();
        lg.setVisible(true);
    }//GEN-LAST:event_tombolLogoutActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonInputBarang;
    private javax.swing.JButton buttonMember;
    private javax.swing.JButton buttonPembayaran;
    private javax.swing.JButton buttonRiwayatTransaksi;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel panelMainMenu;
    private javax.swing.JButton tombolLogout;
    // End of variables declaration//GEN-END:variables
}
