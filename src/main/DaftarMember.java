/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import java.awt.Color;
import javax.swing.JOptionPane;
import java.sql.*;


public class DaftarMember extends javax.swing.JFrame {
    private KoneksiDatabase dbConnection;
    
    public DaftarMember() {
        dbConnection = KoneksiDatabase.getInstance();
        initComponents();
        getContentPane().setBackground(new Color(14,41,84));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(71,73,115));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        inputNamaDaftarMember = new javax.swing.JTextField();
        inputNoTelpDaftarMember = new javax.swing.JTextField();
        tombolDaftarMember = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(14, 41, 84));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(166, 156, 172));
        jLabel1.setText("Daftar Member");

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(241, 218, 196));
        jLabel2.setText("Nama");

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(241, 218, 196));
        jLabel3.setText("No Telepon");

        tombolDaftarMember.setText("Daftar");
        tombolDaftarMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolDaftarMemberActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(tombolDaftarMember))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(76, 76, 76)
                                .addComponent(inputNoTelpDaftarMember, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(inputNamaDaftarMember, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(35, 35, 35)))
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(inputNamaDaftarMember, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(inputNoTelpDaftarMember, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tombolDaftarMember)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tombolDaftarMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolDaftarMemberActionPerformed
        // TODO add your handling code here:
        if(this.inputNamaDaftarMember.getText().isBlank() && this.inputNoTelpDaftarMember.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Mohon tidak mengosongkan input!");
        }else if(this.inputNamaDaftarMember.getText().isBlank() && !this.inputNoTelpDaftarMember.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Mohon tidak mengosongkan input Nama!");
        }else if(!this.inputNamaDaftarMember.getText().isBlank() && this.inputNoTelpDaftarMember.getText().isBlank()){
            JOptionPane.showMessageDialog(this, "Mohon tidak mengosongkan input No Telepon!");
        }else if(!this.inputNamaDaftarMember.getText().isBlank() && !this.inputNoTelpDaftarMember.getText().isBlank()){
            if(this.inputNoTelpDaftarMember.getText().matches("\\d*")){
                try{
                    Statement st1 = dbConnection.getConnection().createStatement();
                    String query10 = String.format("select * from tabel_member where nohp_member=\"%s\";", this.inputNoTelpDaftarMember.getText());
                    ResultSet rs1 = st1.executeQuery(query10);
                    if(rs1.next()){
                        JOptionPane.showMessageDialog(this, "Member tersebut telah terdaftar!");
                    }else{
                        Statement st2 = dbConnection.getConnection().createStatement();
                        System.out.println(this.inputNoTelpDaftarMember.getText());
                        System.out.println(this.inputNoTelpDaftarMember.getText().length());
                        String query11 = String.format("insert into tabel_member(nama_member, nohp_member) values (\"%s\", \"%s\");", this.inputNamaDaftarMember.getText(), this.inputNoTelpDaftarMember.getText());
                        st2.executeUpdate(query11);
                        JOptionPane.showMessageDialog(this, "Berhasil Mendaftar!");
                        this.dispose();
                    }
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }else{
                JOptionPane.showMessageDialog(this, "Input nomor telepon tidak valid!");
            }
        }
    }//GEN-LAST:event_tombolDaftarMemberActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField inputNamaDaftarMember;
    private javax.swing.JTextField inputNoTelpDaftarMember;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton tombolDaftarMember;
    // End of variables declaration//GEN-END:variables
}
