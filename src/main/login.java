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
        inputIDLogin.setForeground(new java.awt.Color(241, 218, 196));
        inputPasswordLogin.setForeground(new java.awt.Color(241, 218, 196));
        inputPasswordLogin.setEchoChar((char)0);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        idLogin1 = new javax.swing.JLabel();
        buttonLogin = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();
        tampilkanPass = new javax.swing.JCheckBox();
        idLogin = new javax.swing.JLabel();
        inputIDLogin = new javax.swing.JTextField();
        inputPasswordLogin = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Admin");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(71, 73, 115));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(166, 156, 172));
        jLabel1.setText("LOGIN");

        idLogin1.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        idLogin1.setForeground(new java.awt.Color(166, 156, 172));
        idLogin1.setText("Password");

        buttonLogin.setBackground(new java.awt.Color(241, 218, 196));
        buttonLogin.setText("Login");
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });

        buttonExit.setBackground(new java.awt.Color(241, 218, 196));
        buttonExit.setText("Keluar");
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });

        tampilkanPass.setBackground(new java.awt.Color(71, 73, 115));
        tampilkanPass.setForeground(new java.awt.Color(166, 156, 172));
        tampilkanPass.setText("tampilkan password");
        tampilkanPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tampilkanPassActionPerformed(evt);
            }
        });

        idLogin.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        idLogin.setForeground(new java.awt.Color(166, 156, 172));
        idLogin.setText("ID");

        inputIDLogin.setBackground(new java.awt.Color(71, 73, 115));
        inputIDLogin.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        inputIDLogin.setForeground(new java.awt.Color(241, 218, 196));
        inputIDLogin.setText("Masukkan ID");
        inputIDLogin.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(170, 165, 159)));
        inputIDLogin.setCaretColor(new java.awt.Color(241, 218, 196));
        inputIDLogin.setSelectedTextColor(new java.awt.Color(12, 53, 106));
        inputIDLogin.setSelectionColor(new java.awt.Color(255, 153, 0));
        inputIDLogin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputIDLoginFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputIDLoginFocusLost(evt);
            }
        });
        inputIDLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputIDLoginActionPerformed(evt);
            }
        });

        inputPasswordLogin.setBackground(new java.awt.Color(71, 73, 115));
        inputPasswordLogin.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        inputPasswordLogin.setForeground(new java.awt.Color(241, 218, 196));
        inputPasswordLogin.setText("Masukkan Password");
        inputPasswordLogin.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(170, 165, 159)));
        inputPasswordLogin.setCaretColor(new java.awt.Color(241, 218, 196));
        inputPasswordLogin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputPasswordLoginFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputPasswordLoginFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(buttonExit)
                        .addGap(46, 46, 46)
                        .addComponent(buttonLogin))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idLogin)
                    .addComponent(idLogin1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tampilkanPass)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(inputIDLogin)
                        .addComponent(inputPasswordLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)))
                .addGap(46, 46, 46))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLogin)
                    .addComponent(inputIDLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idLogin1)
                    .addComponent(inputPasswordLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(tampilkanPass)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonLogin)
                    .addComponent(buttonExit))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_buttonExitActionPerformed

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed
        // TODO add your handling code here:
        if(this.inputIDLogin.getText().equals("Masukkan ID") && this.inputPasswordLogin.getText().equals("Masukkan Password")){
            this.inputIDLogin.setText("");
            this.inputPasswordLogin.setText("");
            if(this.inputIDLogin.getText().isBlank() && this.inputPasswordLogin.getText().isBlank()){
                JOptionPane.showMessageDialog(this, "Mohon tidak mengosongkan input!");
            }
        }else if(this.inputIDLogin.getText().equals("Masukkan ID") && !this.inputPasswordLogin.getText().equals("Masukkan Password")){
            this.inputIDLogin.setText("");
            if(this.inputIDLogin.getText().isBlank() && !this.inputPasswordLogin.getText().isBlank()){
                JOptionPane.showMessageDialog(this, "Input ID kosong!");
            }
        }else if(!this.inputIDLogin.getText().equals("Masukkan ID") && this.inputPasswordLogin.getText().equals("Masukkan Password")){
            this.inputPasswordLogin.setText("");
            if(!this.inputIDLogin.getText().isBlank() && this.inputPasswordLogin.getText().isBlank()){
                JOptionPane.showMessageDialog(this, "Input Password kosong!");
            }
        }else if(!this.inputIDLogin.getText().equals("Masukkan ID") && !this.inputPasswordLogin.getText().equals("Masukkan Password")){
            System.out.println("Huru hara");
            if(!this.inputIDLogin.getText().isBlank() && !this.inputPasswordLogin.getText().isBlank()){
                try{
                    Statement st1 = dbConnection.getConnection().createStatement();
                    String getAdmin = String.format("select * from data_admin where id_admin=\"%s\" and password_admin=\"%s\";", this.inputIDLogin.getText(), this.inputPasswordLogin.getText());
                    ResultSet rs1 = st1.executeQuery(getAdmin);
                    if(rs1.next()){
                        dispose();
                        MainMenu mp = new MainMenu(rs1.getString("nama_admin"), Integer.parseInt(rs1.getString("id_admin")));
                        mp.setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(this, "Maaf, data tersebut tidak tersedia di data admin!");
                    }
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }else if(this.inputIDLogin.getText().isBlank() && this.inputPasswordLogin.getText().isBlank()){
                JOptionPane.showMessageDialog(this, "Mohon tidak mengosongkan input!");
            }else if(this.inputIDLogin.getText().isBlank() && !this.inputPasswordLogin.getText().isBlank()){
                JOptionPane.showMessageDialog(this, "Input ID kosong!");
            }else if(!this.inputIDLogin.getText().isBlank() && this.inputPasswordLogin.getText().isBlank()){
                JOptionPane.showMessageDialog(this, "Input Password kosong!");
            }
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

    private void inputIDLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputIDLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputIDLoginActionPerformed

    private void inputIDLoginFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputIDLoginFocusGained
        // TODO add your handling code here:
        if(inputIDLogin.getText().equals("Masukkan ID")){
            inputIDLogin.setText("");
            inputIDLogin.setForeground(new java.awt.Color(241, 218, 196));
        }
        
    }//GEN-LAST:event_inputIDLoginFocusGained

    private void inputPasswordLoginFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputPasswordLoginFocusGained
        // TODO add your handling code here:
        if(inputPasswordLogin.getText().equals("Masukkan Password")){
            inputPasswordLogin.setText("");
            inputPasswordLogin.setForeground(new java.awt.Color(241, 218, 196));
            if(inputPasswordLogin.getText().isBlank() && !this.tampilkanPass.isSelected()){
                inputPasswordLogin.setEchoChar('*');
            }
        }
    }//GEN-LAST:event_inputPasswordLoginFocusGained

    private void inputPasswordLoginFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputPasswordLoginFocusLost
        // TODO add your handling code here:
        if(inputPasswordLogin.getText().equals("")){
            inputPasswordLogin.setText("Masukkan Password");
            inputPasswordLogin.setForeground(new java.awt.Color(241, 218, 196));
            if(this.inputPasswordLogin.getText().equals("Masukkan Password")){
                this.inputPasswordLogin.setEchoChar((char)0);
            }
            
        }
    }//GEN-LAST:event_inputPasswordLoginFocusLost

    private void inputIDLoginFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputIDLoginFocusLost
        // TODO add your handling code here:
        if(inputIDLogin.getText().equals("")){
            inputIDLogin.setText("Masukkan ID");
            inputIDLogin.setForeground(new java.awt.Color(241, 218, 196));
        }
    }//GEN-LAST:event_inputIDLoginFocusLost

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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JCheckBox tampilkanPass;
    // End of variables declaration//GEN-END:variables
}
