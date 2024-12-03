package com.testing.quanlysieuthimini.GUI.update;

import com.testing.quanlysieuthimini.BUS.TaiKhoanBUS;
import com.testing.quanlysieuthimini.DTO.TaiKhoanDTO;
import com.testing.quanlysieuthimini.GUI.taikhoan;
import com.testing.quanlysieuthimini.helper.Validation;
import java.awt.HeadlessException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class updateTaiKhoan extends javax.swing.JDialog {

    private final Map<String, Integer> listQuyen = new HashMap<>();
    private final taikhoan parent;
    private final TaiKhoanBUS taiKhoanBUS = new TaiKhoanBUS();
    Validation v = new Validation();

    public updateTaiKhoan(taikhoan parent, javax.swing.JFrame owner, boolean modal) {
        super(owner, modal);
        this.parent = (taikhoan) parent;
        initComponents();
        loadDataDSQuyen();
        display();
        setLocationRelativeTo(null);
    }

    public void loadDataDSQuyen() {
        listQuyen.put("Nhân viên nhập hàng", 2);
        listQuyen.put("Nhân viên xuất hàng", 3);
    }

    public void display() {
        TaiKhoanDTO taiKhoanSelected = parent.getSelectedAccount();
        txtTenDangNhap.setText(taiKhoanSelected.getUsername());
        txtMatKhau.setText(taiKhoanSelected.getPassword());
        cbbNhomQuyen.setSelectedItem(taiKhoanBUS.getNhomQuyenDTO(taiKhoanSelected.getRoleId()).getTennhomquyen());
        String trangthaiString = "";
        switch (taiKhoanSelected.getStatus()) {
            case 1 -> {
                trangthaiString = "Đang hoạt động";
            }
            case 2 -> {
                trangthaiString = "Ngưng hoạt động";
            }
        }
        cbbTrangThai.setSelectedItem(trangthaiString);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtTenDangNhap = new javax.swing.JTextField();
        cbbTrangThai = new javax.swing.JComboBox<>();
        cbbNhomQuyen = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel7.setBackground(new java.awt.Color(153, 255, 255));
        jPanel7.setForeground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("CẬP NHẬT THÔNG TIN");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel7)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setText("Tên Đăng Nhập");

        txtTenDangNhap.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtTenDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenDangNhapActionPerformed(evt);
            }
        });

        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ngưng hoạt động", "Đang hoạt động" }));

        cbbNhomQuyen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân viên nhập hàng", "Nhân viên xuất hàng" }));

        btnSave.setBackground(new java.awt.Color(0, 204, 0));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Lưu");
        btnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        btnSave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSaveKeyPressed(evt);
            }
        });

        btnHuy.setBackground(new java.awt.Color(204, 0, 51));
        btnHuy.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnHuy.setText("Hủy");
        btnHuy.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });
        btnHuy.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnHuyKeyPressed(evt);
            }
        });

        jLabel11.setText("Vai trò");

        jLabel12.setText("Mật khẩu");

        jLabel9.setText("Trạng thái");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(cbbTrangThai, 0, 270, Short.MAX_VALUE)
                    .addComponent(jLabel8)
                    .addComponent(txtTenDangNhap)
                    .addComponent(cbbNhomQuyen, 0, 270, Short.MAX_VALUE)
                    .addComponent(txtMatKhau))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addGap(1, 1, 1)
                .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbNhomQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            int accountId = parent.getSelectedAccount().getAccountId();
            int staffId = parent.getSelectedAccount().getStaffId();
            String username = txtTenDangNhap.getText().trim();
            String password = txtMatKhau.getText().trim();
            int roleId = cbbNhomQuyen.getSelectedIndex() + 2;
            int status = cbbTrangThai.getSelectedIndex();

            TaiKhoanDTO currentAccount = parent.getSelectedAccount();

            if (v.isValidUsername(username) != null) {
                JOptionPane.showMessageDialog(this, v.isValidUsername(username), "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                txtTenDangNhap.requestFocus();
            } else if (!username.equals(currentAccount.getUsername()) && taiKhoanBUS.isUsernameExists(username)) {
                JOptionPane.showMessageDialog(this, "Tên đăng nhập đã tồn tại! Vui lòng nhập tên đăng nhập khác khác.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                txtTenDangNhap.requestFocus();
            } else {
                if (v.isValidPassword(password) != null) {
                    JOptionPane.showMessageDialog(this, v.isValidPassword(password), "Cảnh báo", JOptionPane.WARNING_MESSAGE);
                    txtMatKhau.requestFocus();
                } else {
                    boolean hasChanges = !username.equals(currentAccount.getUsername())
                            || !password.equals(currentAccount.getPassword())
                            || roleId != currentAccount.getRoleId()
                            || status != currentAccount.getStatus();
                    if (!hasChanges) {
                        JOptionPane.showMessageDialog(null, "Không có thay đổi nào mới để sửa!");
                        return;
                    }
                    TaiKhoanDTO tk = new TaiKhoanDTO(accountId, staffId, username, password, roleId, status);
                    if (taiKhoanBUS.update(tk)) {
                        JOptionPane.showMessageDialog(this, "Sửa tài khoản thành công!");
                        dispose();
                        parent.loadDataToTable(taiKhoanBUS.tkDAO.selectAll());
                    } else {
                        JOptionPane.showMessageDialog(null, "Sửa tài khoản thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi không xác định!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn hủy bỏ thao tác sửa tài khoản?", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_btnHuyActionPerformed

    private void txtTenDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenDangNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenDangNhapActionPerformed

    private void btnSaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSaveKeyPressed
        btnSaveActionPerformed(new java.awt.event.ActionEvent(evt.getSource(), evt.getID(), "Enter Key Pressed"));

    }//GEN-LAST:event_btnSaveKeyPressed

    private void btnHuyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnHuyKeyPressed
        btnHuyActionPerformed(new java.awt.event.ActionEvent(evt.getSource(), evt.getID(), "Enter Key Pressed"));
    }//GEN-LAST:event_btnHuyKeyPressed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbbNhomQuyen;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtTenDangNhap;
    // End of variables declaration//GEN-END:variables
}
