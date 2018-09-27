package com.dic;

import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    DictionaryManagement dicMana = new DictionaryManagement();
    final private String username = "anhducc13";
    final private String password = "03121997";

    public Login() {
        initComponents();
        this.setIconImage(new ImageIcon("login.png").getImage());
        initData();
        this.setLocationRelativeTo(null);
    }

    void initData() {
        Dictionary.listWord.clear();
        dicMana.dictionaryImportfromSQL();
        Dictionary.recentWords.clear();
        dicMana.updateDataFromFileToList("dataSaved\\recent.txt", Dictionary.recentWords);
        Dictionary.myWords.clear();
        dicMana.updateDataFromFileToList("dataSaved\\saved.txt", Dictionary.myWords);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        optionLogin = new javax.swing.ButtonGroup();
        jPanelMain = new javax.swing.JPanel();
        jOptionLoginClient = new javax.swing.JRadioButton();
        jOptionLoginAdmin = new javax.swing.JRadioButton();
        jLabelAccount = new javax.swing.JLabel();
        jLabelPsw = new javax.swing.JLabel();
        jFormattedTextFieldAcc = new javax.swing.JFormattedTextField();
        jPasswordFieldPsw = new javax.swing.JPasswordField();
        jButtonLogin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng nhập");
        setBackground(new java.awt.Color(52, 152, 219));
        setResizable(false);

        jPanelMain.setBackground(new java.awt.Color(0, 174, 255));

        optionLogin.add(jOptionLoginClient);
        jOptionLoginClient.setSelected(true);
        jOptionLoginClient.setText("Đăng nhập với tư cách người dùng");
        jOptionLoginClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOptionLoginClientActionPerformed(evt);
            }
        });

        optionLogin.add(jOptionLoginAdmin);
        jOptionLoginAdmin.setText("Đăng nhập với tư cách quản trị viên");
        jOptionLoginAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOptionLoginAdminActionPerformed(evt);
            }
        });

        jLabelAccount.setText("Tên đăng nhập");

        jLabelPsw.setText("Mật khẩu");

        jFormattedTextFieldAcc.setEditable(false);

        jPasswordFieldPsw.setEditable(false);

        jButtonLogin.setBackground(new java.awt.Color(38, 67, 72));
        jButtonLogin.setForeground(new java.awt.Color(242, 241, 239));
        jButtonLogin.setText("Đăng nhập");
        jButtonLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonLoginMouseEntered(evt);
            }
        });
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(207, 0, 15));
        jLabel1.setText("TỪ ĐIỂN ANH - VIỆT");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelMainLayout.createSequentialGroup()
                                .addComponent(jLabelAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jFormattedTextFieldAcc))
                            .addGroup(jPanelMainLayout.createSequentialGroup()
                                .addComponent(jLabelPsw, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPasswordFieldPsw, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonLogin))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1))
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jOptionLoginAdmin)
                            .addComponent(jOptionLoginClient))))
                .addContainerGap())
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jOptionLoginClient)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jOptionLoginAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPsw, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordFieldPsw, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        // TODO add your handling code here:
        if (jOptionLoginClient.isSelected()) {
            DictionaryApplication dic = new DictionaryApplication();
            this.dispose();
            dic.setVisible(true);
        } else if (jOptionLoginAdmin.isSelected()) {
            if (jFormattedTextFieldAcc.getText().equals(username)
                    && jPasswordFieldPsw.getText().equals(password)) {
                JOptionPane.showMessageDialog(rootPane, "Đăng nhập thành công!!!");
                Admin ad = new Admin();
                this.dispose();
                ad.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Sai tên đăng nhập hoặc mật khẩu");
            }
        }

    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void jOptionLoginAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jOptionLoginAdminActionPerformed
        // TODO add your handling code here:
        jFormattedTextFieldAcc.setText("");
        jPasswordFieldPsw.setText("");
        jFormattedTextFieldAcc.setEditable(true);
        jPasswordFieldPsw.setEditable(true);
        jFormattedTextFieldAcc.requestFocusInWindow();
    }//GEN-LAST:event_jOptionLoginAdminActionPerformed

    private void jOptionLoginClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jOptionLoginClientActionPerformed
        // TODO add your handling code here:
        jFormattedTextFieldAcc.setText("");
        jPasswordFieldPsw.setText("");
        jFormattedTextFieldAcc.setEditable(false);
        jPasswordFieldPsw.setEditable(false);
    }//GEN-LAST:event_jOptionLoginClientActionPerformed

    private void jButtonLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLoginMouseEntered
        // TODO add your handling code here:
        jButtonLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jButtonLoginMouseEntered

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JFormattedTextField jFormattedTextFieldAcc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAccount;
    private javax.swing.JLabel jLabelPsw;
    private javax.swing.JRadioButton jOptionLoginAdmin;
    private javax.swing.JRadioButton jOptionLoginClient;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPasswordField jPasswordFieldPsw;
    private javax.swing.ButtonGroup optionLogin;
    // End of variables declaration//GEN-END:variables
}
