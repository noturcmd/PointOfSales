/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import java.awt.Color;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author acer_
 */
public class login extends javax.swing.JFrame {
    private KoneksiDatabase dbConnection;
    
    
    public login() {
        dbConnection = KoneksiDatabase.getInstance();
        initComponents();
        setLocationRelativeTo(null);
        inputIDLogin.setForeground(new Color(153, 153, 153));
        inputPasswordLogin.setForeground(new Color(153, 153, 153));
        inputPasswordLogin.setEchoChar((char)0);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        idLogin = new javax.swing.JLabel();
        inputIDLogin = new javax.swing.JTextField();
        idLogin1 = new javax.swing.JLabel();
        buttonLogin = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();
        tampilkanPass = new javax.swing.JCheckBox();
        inputPasswordLogin = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Admin");

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        jLabel1.setText("LOGIN");

        idLogin.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        idLogin.setText("ID");

        inputIDLogin.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        inputIDLogin.setText("Masukkan ID");
        inputIDLogin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputIDLoginFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputIDLoginFocusLost(evt);
            }
        });

        idLogin1.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        idLogin1.setText("Password");

        buttonLogin.setText("Login");
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });

        buttonExit.setText("Keluar");
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });

        tampilkanPass.setText("tampilkan password");
        tampilkanPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tampilkanPassActionPerformed(evt);
            }
        });

        inputPasswordLogin.setText("Masukkan Password");
        inputPasswordLogin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputPasswordLoginFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputPasswordLoginFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(buttonExit)
                        .addGap(18, 18, 18)
                        .addComponent(buttonLogin))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idLogin)
                            .addComponent(idLogin1))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inputIDLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .addComponent(tampilkanPass)
                            .addComponent(inputPasswordLogin))))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLogin)
                    .addComponent(inputIDLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(idLogin1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(inputPasswordLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addComponent(tampilkanPass)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonLogin)
                    .addComponent(buttonExit))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputIDLoginFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputIDLoginFocusGained
        // TODO add your handling code here:
        if(inputIDLogin.getText().equals("Masukkan ID")){
            inputIDLogin.setText("");
            inputIDLogin.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_inputIDLoginFocusGained

    private void inputIDLoginFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputIDLoginFocusLost
        // TODO add your handling code here:
        if(inputIDLogin.getText().equals("")){
            inputIDLogin.setText("Masukkan ID");
            inputIDLogin.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_inputIDLoginFocusLost

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_buttonExitActionPerformed

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed
        // TODO add your handling code here:
        try{
            Statement st1 = dbConnection.getConnection().createStatement();
            String getAdmin = String.format("select * from data_admin where id_admin=\"%s\" and password_admin=\"%s\";", this.inputIDLogin.getText(), this.inputPasswordLogin.getText());
            ResultSet rs1 = st1.executeQuery(getAdmin);
            if(rs1.next()){
                dispose();
                Pembayaran mp = new Pembayaran();
                mp.getAdminBio(rs1.getString("nama_admin"), Integer.parseInt(rs1.getString("id_admin")));
                mp.setVisible(true);
                mp.setExtendedState(mp.getExtendedState() | JFrame.MAXIMIZED_BOTH);
            }else{
                JOptionPane.showMessageDialog(this, "Maaf, data tersebut tidak tersedia di data admin!");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_buttonLoginActionPerformed

    private void tampilkanPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tampilkanPassActionPerformed
        // TODO add your handling code here:
        if(inputPasswordLogin.getText().equals("Masukkan Password") && tampilkanPass.isSelected()){
            this.inputPasswordLogin.setEchoChar((char)0);
        }else if(!inputPasswordLogin.getText().equals("Masukkan Password") && tampilkanPass.isSelected()){
            this.inputPasswordLogin.setEchoChar((char)0);
        }else if(!inputPasswordLogin.getText().equals("Masukkan Password") && !tampilkanPass.isSelected()){
            this.inputPasswordLogin.setEchoChar('*');
        }
    }//GEN-LAST:event_tampilkanPassActionPerformed

    private void inputPasswordLoginFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputPasswordLoginFocusGained
        // TODO add your handling code here:
        if(inputPasswordLogin.getText().equals("Masukkan Password")){
            inputPasswordLogin.setText("");
            if(inputPasswordLogin.getText().isBlank()){
                System.out.println("Kosong");
                inputPasswordLogin.setEchoChar('*');
            }
            inputPasswordLogin.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_inputPasswordLoginFocusGained

    private void inputPasswordLoginFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputPasswordLoginFocusLost
        // TODO add your handling code here:
        if(inputPasswordLogin.getText().equals("")){
            inputPasswordLogin.setText("Masukkan Password");
            if(this.inputPasswordLogin.getText().equals("Masukkan Password")){
                this.inputPasswordLogin.setEchoChar((char)0);
            }
            inputPasswordLogin.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_inputPasswordLoginFocusLost

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonLogin;
    private javax.swing.JLabel idLogin;
    private javax.swing.JLabel idLogin1;
    private javax.swing.JTextField inputIDLogin;
    private javax.swing.JPasswordField inputPasswordLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JCheckBox tampilkanPass;
    // End of variables declaration//GEN-END:variables
}
