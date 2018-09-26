package com.dic;

import com.darkprograms.speech.synthesiser.Synthesiser;
import java.awt.Color;
import java.awt.Cursor;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

public class DictionaryApplication extends javax.swing.JFrame {

    DictionaryManagement dicMana = new DictionaryManagement();
    Dictionary dic = new Dictionary();
    boolean searchMode = true;
    boolean saveMode = false;
    boolean recentMode = false;

    DefaultListModel<String> DLM = new DefaultListModel<>();

    public DictionaryApplication() {
        initComponents();
        setCursor();
        this.setLocationRelativeTo(null);
    }

    void setCursor() {
        jLabelSave.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabelExit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabelLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabelSaveMode.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabelSearchMode.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabelSpeaker.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabelRecentMode.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
        jLabelSearchMode = new javax.swing.JLabel();
        jLabelSaveMode = new javax.swing.JLabel();
        jLabelRecentMode = new javax.swing.JLabel();
        jLabelPrce = new javax.swing.JLabel();
        jLabelExpl = new javax.swing.JLabel();
        jLabelLogout = new javax.swing.JLabel();
        jLabelExit = new javax.swing.JLabel();
        jLabelSave = new javax.swing.JLabel();
        jLabelSpeaker = new javax.swing.JLabel();
        jFormattedTextFieldVoca = new javax.swing.JFormattedTextField();

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

        jLabelSearchMode.setBackground(new java.awt.Color(255, 0, 0));
        jLabelSearchMode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSearchMode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search (1).png"))); // NOI18N
        jLabelSearchMode.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabelSearchMode.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelSearchMode.setOpaque(true);
        jLabelSearchMode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSearchModeMouseClicked(evt);
            }
        });

        jLabelSaveMode.setBackground(new java.awt.Color(28, 199, 208));
        jLabelSaveMode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSaveMode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/favorite.png"))); // NOI18N
        jLabelSaveMode.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabelSaveMode.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelSaveMode.setOpaque(true);
        jLabelSaveMode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSaveModeMouseClicked(evt);
            }
        });

        jLabelRecentMode.setBackground(new java.awt.Color(28, 199, 208));
        jLabelRecentMode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRecentMode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clock.png"))); // NOI18N
        jLabelRecentMode.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabelRecentMode.setOpaque(true);
        jLabelRecentMode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRecentModeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jBoxSearch)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabelSearchMode)
                        .addGap(28, 28, 28)
                        .addComponent(jLabelSaveMode)
                        .addGap(30, 30, 30)
                        .addComponent(jLabelRecentMode)))
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
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelRecentMode, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelSaveMode, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelSearchMode, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addComponent(jBoxSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
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

        jLabelSave.setBackground(new java.awt.Color(0, 174, 255));
        jLabelSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        jLabelSave.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabelSave.setOpaque(true);
        jLabelSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSaveMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelSaveMouseExited(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelPrce, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 47, Short.MAX_VALUE))
                    .addComponent(jLabelExpl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabelLogout))
                    .addComponent(jFormattedTextFieldVoca))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelExit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelSave, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelSpeaker)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelSpeaker, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldVoca, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelPrce, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabelExpl, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelSave, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBoxSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jBoxSearchKeyReleased
        // TODO add your handling code here:
        jFormattedTextFieldVoca.setText("Từ vựng");
        jLabelPrce.setText("Phát âm");
        jLabelExpl.setText("Nghĩa của từ");

        if (searchMode) {
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
        } else if (saveMode) {
            DLM.clear();
            String text = jBoxSearch.getText();
            for (Word ele
                    : Dictionary.myWords) {
                if (ele.getWord_taget().indexOf(jBoxSearch.getText()) == 0) {
                    DLM.addElement(ele.getWord_taget());
                }
            }
            jListWordAction.setModel(DLM);
        } else if (recentMode) {
            DLM.clear();
            String text = jBoxSearch.getText();
            for (Word ele
                    : Dictionary.recentWords) {
                if (ele.getWord_taget().indexOf(jBoxSearch.getText()) == 0) {
                    DLM.addElement(ele.getWord_taget());
                }
            }
            jListWordAction.setModel(DLM);
        }

    }//GEN-LAST:event_jBoxSearchKeyReleased

    private void jListWordActionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListWordActionMouseClicked
        // TODO add your handling code here:
        for (Word ele : Dictionary.listWord) {
            if (jListWordAction.getSelectedValue().equals(ele.getWord_taget())) {
                dicMana.addToRecentWords(new Word(ele));
                jFormattedTextFieldVoca.setText(ele.getWord_taget());
                jLabelPrce.setText("Phát âm");
                jLabelExpl.setText(ele.getWord_explain());
                if (searchMode) {
                    dicMana.addToRecentWords(new Word(jFormattedTextFieldVoca.getText(), jLabelExpl.getText()));
                }
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

    private void jLabelSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSaveMouseClicked
        // TODO add your handling code here:
        if (!saveMode) {
            if (evt.getButton() == java.awt.event.MouseEvent.BUTTON1) {
                jLabelSave.setBorder(BorderFactory.createEmptyBorder());
                if (jListWordAction.isSelectionEmpty()) {
                    JOptionPane.showMessageDialog(rootPane, "Chọn một từ để lưu");
                } else {
                    dicMana.addToMyWords(new Word(jFormattedTextFieldVoca.getText(), jLabelExpl.getText()));
                    JOptionPane.showMessageDialog(rootPane, "Đã Lưu");
                }
            }
        }
    }//GEN-LAST:event_jLabelSaveMouseClicked

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

    private void jLabelSaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSaveMouseExited
        // TODO add your handling code here:
        jLabelSave.setBorder(BorderFactory.createRaisedBevelBorder());
    }//GEN-LAST:event_jLabelSaveMouseExited

    private void jLabelSearchModeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSearchModeMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == java.awt.event.MouseEvent.BUTTON1) {
            jLabelSave.setVisible(true);
            searchMode = true;
            saveMode = false;
            recentMode = false;
            jLabelSearchMode.setBackground(new Color(255, 0, 0));
            jLabelSaveMode.setBackground(new Color(28, 199, 208));
            jLabelRecentMode.setBackground(new Color(28, 199, 208));
            jBoxSearch.requestFocusInWindow();
            jBoxSearch.setText("");
            jFormattedTextFieldVoca.setText("Từ vựng");
            jLabelPrce.setText("Phát âm");
            jLabelExpl.setText("Nghĩa của từ");
            DLM.clear();
        }
    }//GEN-LAST:event_jLabelSearchModeMouseClicked

    private void jLabelSaveModeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSaveModeMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == java.awt.event.MouseEvent.BUTTON1) {
            jLabelSave.setVisible(false);
            searchMode = false;
            saveMode = true;
            recentMode = false;
            jLabelSearchMode.setBackground(new Color(28, 199, 208));
            jLabelSaveMode.setBackground(new Color(255, 0, 0));
            jLabelRecentMode.setBackground(new Color(28, 199, 208));
            jBoxSearch.requestFocusInWindow();
            jBoxSearch.setText("");
            jFormattedTextFieldVoca.setText("Từ vựng");
            jLabelPrce.setText("Phát âm");
            jLabelExpl.setText("Nghĩa của từ");
            DLM.clear();
        }
    }//GEN-LAST:event_jLabelSaveModeMouseClicked

    private void jLabelRecentModeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRecentModeMouseClicked
        // TODO add your handling code here:
        if (evt.getButton() == java.awt.event.MouseEvent.BUTTON1) {
            jLabelSave.setVisible(true);
            searchMode = false;
            saveMode = false;
            recentMode = true;
            jLabelSearchMode.setBackground(new Color(28, 199, 208));
            jLabelSaveMode.setBackground(new Color(28, 199, 208));
            jLabelRecentMode.setBackground(new Color(255, 0, 0));
            jBoxSearch.requestFocusInWindow();
            jBoxSearch.setText("");
            jFormattedTextFieldVoca.setText("Từ vựng");
            jLabelPrce.setText("Phát âm");
            jLabelExpl.setText("Nghĩa của từ");
            DLM.clear();
        }
    }//GEN-LAST:event_jLabelRecentModeMouseClicked

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
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(DictionaryApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DictionaryApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DictionaryApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DictionaryApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//
//                new DictionaryApplication().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JFormattedTextField jBoxSearch;
    private javax.swing.JFormattedTextField jFormattedTextFieldVoca;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelExit;
    private javax.swing.JLabel jLabelExpl;
    private javax.swing.JLabel jLabelLogout;
    private javax.swing.JLabel jLabelPrce;
    private javax.swing.JLabel jLabelRecentMode;
    private javax.swing.JLabel jLabelSave;
    private javax.swing.JLabel jLabelSaveMode;
    private javax.swing.JLabel jLabelSearchMode;
    private javax.swing.JLabel jLabelSpeaker;
    private javax.swing.JList<String> jListWordAction;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
