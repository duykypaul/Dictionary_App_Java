package com.dic;

import com.darkprograms.speech.synthesiser.Synthesiser;
import java.awt.Cursor;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

public class Admin extends javax.swing.JFrame {

    DictionaryManagement dicMana = new DictionaryManagement();

    DefaultListModel<String> DLM = new DefaultListModel<>();

    public Admin() {
//        initData();
        initComponents();
        jBoxSearch.requestFocusInWindow();

        setCursor();
        this.setLocationRelativeTo(null);
    }

    void setCursor() {
        jLabelAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabelExit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabelLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabelDel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabelSpeaker.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabelEdit.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jBoxSearch = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListWordAction = new javax.swing.JList<>();
        jLabelPrce = new javax.swing.JLabel();
        jLabelExpl = new javax.swing.JLabel();
        jLabelLogout = new javax.swing.JLabel();
        jLabelExit = new javax.swing.JLabel();
        jLabelSpeaker = new javax.swing.JLabel();
        jFormattedTextFieldVoca = new javax.swing.JFormattedTextField();
        jLabelEdit = new javax.swing.JLabel();
        jLabelDel = new javax.swing.JLabel();
        jLabelAdd = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 174, 255));

        jPanel2.setBackground(new java.awt.Color(28, 199, 208));

        jBoxSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
        jBoxSearch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jBoxSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jBoxSearchKeyReleased(evt);
            }
        });

        jLabel2.setText("jLabel2");

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBar(null);

        jListWordAction.setBackground(new java.awt.Color(28, 199, 208));
        jListWordAction.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jListWordAction.setFont(jListWordAction.getFont().deriveFont(jListWordAction.getFont().getSize()+1f));
        jListWordAction.setSelectionBackground(new java.awt.Color(255, 0, 0));
        jListWordAction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListWordActionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListWordAction);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                    .addComponent(jBoxSearch))
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBoxSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );

        jLabelPrce.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelPrce.setText("Phát âm");

        jLabelExpl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelExpl.setText("Nghĩa của từ");

        jLabelLogout.setBackground(new java.awt.Color(0, 174, 255));
        jLabelLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logout.png"))); // NOI18N
        jLabelLogout.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabelLogout.setOpaque(true);
        jLabelLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLogoutMouseClicked(evt);
            }
        });

        jLabelExit.setBackground(new java.awt.Color(0, 174, 255));
        jLabelExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon.png"))); // NOI18N
        jLabelExit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabelExit.setOpaque(true);
        jLabelExit.setPreferredSize(new java.awt.Dimension(37, 36));
        jLabelExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelExitMouseClicked(evt);
            }
        });

        jLabelSpeaker.setBackground(new java.awt.Color(0, 174, 255));
        jLabelSpeaker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/speaker.png"))); // NOI18N
        jLabelSpeaker.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabelSpeaker.setOpaque(true);
        jLabelSpeaker.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSpeakerMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSpeakerMouseExited(evt);
            }
        });

        jFormattedTextFieldVoca.setEditable(false);
        jFormattedTextFieldVoca.setBackground(new java.awt.Color(5, 15, 44));
        jFormattedTextFieldVoca.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jFormattedTextFieldVoca.setForeground(new java.awt.Color(243, 244, 247));
        jFormattedTextFieldVoca.setText("Từ vựng");
        jFormattedTextFieldVoca.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jFormattedTextFieldVoca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldVocaActionPerformed(evt);
            }
        });

        jLabelEdit.setBackground(new java.awt.Color(0, 174, 255));
        jLabelEdit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/content.png"))); // NOI18N
        jLabelEdit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabelEdit.setOpaque(true);
        jLabelEdit.setPreferredSize(new java.awt.Dimension(38, 36));
        jLabelEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelEditMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelEditMouseExited(evt);
            }
        });

        jLabelDel.setBackground(new java.awt.Color(0, 174, 255));
        jLabelDel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete-button.png"))); // NOI18N
        jLabelDel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabelDel.setOpaque(true);
        jLabelDel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelDelMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelDelMouseExited(evt);
            }
        });

        jLabelAdd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        jLabelAdd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabelAdd.setOpaque(true);
        jLabelAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAddMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabelLogout)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFormattedTextFieldVoca, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPrce, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelSpeaker))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelExpl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelDel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelSpeaker, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldVoca, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPrce, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelExpl, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelExit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelLogout, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBoxSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBoxSearchKeyReleased
        // TODO add your handling code here:
        jFormattedTextFieldVoca.setText("Từ vựng");
        jLabelPrce.setText("Phát âm");
        jLabelExpl.setText("Nghĩa của từ");
        DLM.clear();
        String text = jBoxSearch.getText();
        if (!text.equals("")) {
            for (Word ele
                    : Dictionary.listWord) {
                if (ele.getWord_taget().indexOf(jBoxSearch.getText()) == 0) {
                    DLM.addElement(ele.getWord_taget());
                }
            }
        }
        jListWordAction.setModel(DLM);

    }//GEN-LAST:event_jBoxSearchKeyReleased

    private void jListWordActionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListWordActionMouseClicked
        // TODO add your handling code here:
        for (Word ele : Dictionary.listWord) {
            if (jListWordAction.getSelectedValue().equals(ele.getWord_taget())) {
                jFormattedTextFieldVoca.setText(ele.getWord_taget());
                jLabelPrce.setText("Phát âm");
                jLabelExpl.setText(ele.getWord_explain());
                break;
            }
        }
    }//GEN-LAST:event_jListWordActionMouseClicked

    private void jLabelLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLogoutMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == java.awt.event.MouseEvent.BUTTON1) {
            jLabelLogout.setBorder(BorderFactory.createEmptyBorder());
            Login log = new Login();
            this.dispose();
            log.setVisible(true);
        }

    }//GEN-LAST:event_jLabelLogoutMouseClicked

    private void jLabelExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == java.awt.event.MouseEvent.BUTTON1) {
            jLabelExit.setBorder(BorderFactory.createEmptyBorder());
            System.exit(0);
        }
    }//GEN-LAST:event_jLabelExitMouseClicked

    private void jLabelSpeakerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSpeakerMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == java.awt.event.MouseEvent.BUTTON1) {
            jLabelSpeaker.setBorder(BorderFactory.createEmptyBorder());
            if (jListWordAction.isSelectionEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Chọn một từ");
            } else {
                Synthesiser synthesizer = new Synthesiser();
                Thread thread = new Thread(() -> {
                    try {
                        AdvancedPlayer player = new AdvancedPlayer(synthesizer.getMP3Data(jListWordAction.getSelectedValue()));
                        player.play();
                    } catch (IOException | JavaLayerException e) {
                        JOptionPane.showMessageDialog(rootPane, "Lỗi");
                    }
                });
                thread.setDaemon(false);
                thread.start();
            }
        }

    }//GEN-LAST:event_jLabelSpeakerMouseClicked

    private void jLabelSpeakerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSpeakerMouseExited
        // TODO add your handling code here:
        jLabelSpeaker.setBorder(BorderFactory.createRaisedBevelBorder());
    }//GEN-LAST:event_jLabelSpeakerMouseExited

    private void jFormattedTextFieldVocaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldVocaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldVocaActionPerformed

    private void jLabelEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == java.awt.event.MouseEvent.BUTTON1) {
            if (jListWordAction.isSelectionEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Chọn từ cần sửa");
            } else {
                jLabelEdit.setBorder(BorderFactory.createEmptyBorder());
                Edit ed = new Edit();
                ed.setVisible(true);
                ed.getjFormattedTextField1().setText(jListWordAction.getSelectedValue());
            }
        }
    }//GEN-LAST:event_jLabelEditMouseClicked

    private void jLabelEditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelEditMouseExited
        // TODO add your handling code here:
        jLabelEdit.setBorder(BorderFactory.createRaisedBevelBorder());
    }//GEN-LAST:event_jLabelEditMouseExited

    private void jLabelDelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDelMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == java.awt.event.MouseEvent.BUTTON1) {
            jLabelDel.setBorder(BorderFactory.createEmptyBorder());
            if (jListWordAction.isSelectionEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Chọn một từ");
            } else {
                String get = jListWordAction.getSelectedValue();
                int response = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa ???", "Warning!!!",
                        JOptionPane.YES_NO_OPTION);
                switch (response) {
                    case JOptionPane.NO_OPTION:
                        break;
                    case JOptionPane.YES_OPTION:
                        dicMana.deleteInList(get);
                        dicMana.deleteInSQL(get);
                        JOptionPane.showMessageDialog(rootPane, "Xóa thành công");
                        jFormattedTextFieldVoca.setText("Từ vựng");
                        jLabelExpl.setText("Nghĩa của từ");
                        DLM.clear();
                        jBoxSearch.requestFocusInWindow();
                        break;
                    case JOptionPane.CLOSED_OPTION:
                        break;
                    default:
                        break;
                }
            }
        }
    }//GEN-LAST:event_jLabelDelMouseClicked

    private void jLabelDelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelDelMouseExited
        // TODO add your handling code here:
        jLabelDel.setBorder(BorderFactory.createRaisedBevelBorder());
    }//GEN-LAST:event_jLabelDelMouseExited

    private void jLabelAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAddMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == java.awt.event.MouseEvent.BUTTON1) {
            jLabelAdd.setBorder(BorderFactory.createEmptyBorder());
            new Add().setVisible(true);
        }
    }//GEN-LAST:event_jLabelAddMouseClicked

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//
//                new Admin().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JFormattedTextField jBoxSearch;
    private javax.swing.JFormattedTextField jFormattedTextFieldVoca;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelAdd;
    private javax.swing.JLabel jLabelDel;
    private javax.swing.JLabel jLabelEdit;
    private javax.swing.JLabel jLabelExit;
    private javax.swing.JLabel jLabelExpl;
    private javax.swing.JLabel jLabelLogout;
    private javax.swing.JLabel jLabelPrce;
    private javax.swing.JLabel jLabelSpeaker;
    private javax.swing.JList<String> jListWordAction;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
