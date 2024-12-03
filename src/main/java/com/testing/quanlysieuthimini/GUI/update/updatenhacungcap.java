/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.testing.quanlysieuthimini.GUI.update;

import com.testing.quanlysieuthimini.BUS.NhaCungCapBUS;
import com.testing.quanlysieuthimini.DTO.NhaCungCapDTO;
import com.testing.quanlysieuthimini.GUI.nhacungcap;
import com.testing.quanlysieuthimini.helper.Validation;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Bao Phan
 */
public class updatenhacungcap extends javax.swing.JDialog {

    private nhacungcap parent; // Assuming nhacungcap is the type of the parent frame
    NhaCungCapBUS nccBUS = new NhaCungCapBUS();
    Validation v = new Validation();

    public updatenhacungcap(nhacungcap parent, javax.swing.JFrame owner, boolean modal) {
        super(owner, modal);
        this.parent = (nhacungcap) parent;
        initComponents();
        setLocationRelativeTo(null);
        displayInfo();
        getRootPane().setDefaultButton(btnLuu);
        btnLuu.setBackground(new Color(51, 204, 0));
         getRootPane().setDefaultButton(btnHuy);
        btnHuy.setBackground(new Color(255, 0, 0));
    }

    updatenhacungcap() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private updatenhacungcap(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void displayInfo() {
        NhaCungCapDTO a = parent.getNhaCungCapSelect();
        txtdiachi.setText("" + a.getDiachi());
        txttenncc.setText("" + a.getTenncc());
        txtsodt.setText("" + a.getSdt());
        txtemail.setText("" + a.getEmail());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtsodt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txttenncc = new javax.swing.JTextField();
        btnLuu = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtdiachi = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Tên nhà cung cấp");

        txtsodt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsodtActionPerformed(evt);
            }
        });

        jLabel4.setText("Số điện thoại");

        jLabel5.setText("Địa chỉ ");

        txttenncc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttennccActionPerformed(evt);
            }
        });

        btnLuu.setBackground(new java.awt.Color(51, 153, 0));
        btnLuu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLuu.setForeground(new java.awt.Color(255, 255, 255));
        btnLuu.setText("LƯU");
        btnLuu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLuu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLuuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLuuMouseExited(evt);
            }
        });
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnHuy.setBackground(new java.awt.Color(255, 0, 0));
        btnHuy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnHuy.setText("HỦY");
        btnHuy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHuy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHuyMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHuyMouseExited(evt);
            }
        });
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(153, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("                                                               CẬP NHẬT NHÀ CUNG CẤP");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
        );

        jLabel6.setText("Email ");

        txtdiachi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdiachiKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txttenncc, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                            .addComponent(txtsodt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(147, 147, 147)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 176, Short.MAX_VALUE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txttenncc, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(txtemail))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsodt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(119, 119, 119))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        int output = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn hủy thay đổi dữ liệu không?", "Xác nhận hùy thay đổi dữ liệu", JOptionPane.YES_NO_OPTION);
        if (output == JOptionPane.YES_OPTION) {
            txtdiachi.setText(parent.getNhaCungCapSelect().getDiachi());
            txttenncc.setText(parent.getNhaCungCapSelect().getTenncc());
            txtsodt.setText(parent.getNhaCungCapSelect().getSdt());
            txtemail.setText(parent.getNhaCungCapSelect().getEmail());
        }

    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed

        try {
            String tennhacungcap = txttenncc.getText();
            String diachincc = txtdiachi.getText();
            String emailncc = txtemail.getText();
            String sdtncc = txtsodt.getText();
            int manhacungcap = parent.getNhaCungCapSelect().getMancc();
            String nameNCCError = v.isValidFullname(txttenncc.getText());
            String emailError = v.isValidEmail(txtemail.getText());
            String phoneNumberError = v.isValidPhoneNumber(txtsodt.getText());

            if (nameNCCError != null) {
                JOptionPane.showMessageDialog(this, nameNCCError, "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                txttenncc.requestFocus();
            } else {
                if (emailError != null) {
                    JOptionPane.showMessageDialog(this, emailError, "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                    txtemail.requestFocus();
                } else if (nccBUS.isEmailExists(emailncc) && !emailncc.equals(parent.getNhaCungCapSelect().getEmail())) {
                    JOptionPane.showMessageDialog(this, "Email đã tồn tại! Vui lòng nhập email khác.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                    txtemail.requestFocus();
                } else {
                    if (phoneNumberError != null) {
                        JOptionPane.showMessageDialog(this, phoneNumberError, "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                        txtsodt.requestFocus();
                    } else if (nccBUS.isPhoneNumberExists(sdtncc) && !sdtncc.equals(parent.getNhaCungCapSelect().getSdt())) {
                        JOptionPane.showMessageDialog(this, "Số điện thoại đã tồn tại! Vui lòng nhập số điện thoại khác", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                        txtsodt.requestFocus();
                    } else {
                        if (txtdiachi.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                            txtdiachi.requestFocus();
                        } else {
                            int output = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn lưu dữ liệu vừa thay đổi không?", "Xác nhận lưu dữ liệu vừa thay đổi", JOptionPane.YES_NO_OPTION);
                            if (output == JOptionPane.YES_OPTION) {
                                NhaCungCapDTO ncc = new NhaCungCapDTO(manhacungcap, tennhacungcap, diachincc, emailncc, sdtncc, 1);
                                nccBUS.update(ncc);
                                JOptionPane.showMessageDialog(this, "Sửa thành công");
                                this.dispose();
                            }

                        }
                    }
                }
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Thất bại !");
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void txttennccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttennccActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttennccActionPerformed

    private void txtsodtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsodtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsodtActionPerformed

    private void btnLuuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLuuMouseEntered
        btnLuu.setBackground(Color.BLUE); // Màu khi di chuột vào

    }//GEN-LAST:event_btnLuuMouseEntered

    private void btnHuyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyMouseEntered
        btnHuy.setBackground(Color.BLUE); // Màu khi di chuột vào

    }//GEN-LAST:event_btnHuyMouseEntered

    private void btnLuuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLuuMouseExited
        btnLuu.setBackground(Color.GREEN); // Màu khi di chuột vào
    }//GEN-LAST:event_btnLuuMouseExited

    private void btnHuyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHuyMouseExited
        btnHuy.setBackground(Color.RED); // Màu khi di chuột vào
    }//GEN-LAST:event_btnHuyMouseExited

    private void txtdiachiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdiachiKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) { // Kiểm tra xem phím Enter có được nhấn không
            btnLuuActionPerformed(null); // Gọi phương thức xử lý của nút
        }
    }//GEN-LAST:event_txtdiachiKeyPressed

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
            java.util.logging.Logger.getLogger(updatenhacungcap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updatenhacungcap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updatenhacungcap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updatenhacungcap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                updatenhacungcap dialog = new updatenhacungcap(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLuu;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtdiachi;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtsodt;
    private javax.swing.JTextField txttenncc;
    // End of variables declaration//GEN-END:variables
}
