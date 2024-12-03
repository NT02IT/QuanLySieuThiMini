package com.testing.quanlysieuthimini.GUI;

import com.testing.quanlysieuthimini.BUS.NhanVienBUS;
import com.testing.quanlysieuthimini.Controler.SearchTaiKhoan;
import com.testing.quanlysieuthimini.BUS.TaiKhoanBUS;
import com.testing.quanlysieuthimini.DAO.TaiKhoanDAO;
import com.testing.quanlysieuthimini.DTO.NhanVienDTO;
import com.testing.quanlysieuthimini.DTO.TaiKhoanDTO;
import com.testing.quanlysieuthimini.GUI.add.addTaiKhoan;
import com.testing.quanlysieuthimini.GUI.update.updateTaiKhoan;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class taikhoan extends javax.swing.JPanel {

    private final DefaultTableModel tblModel;
    private ArrayList<TaiKhoanDTO> accounts = new ArrayList<>();
    private final Map<Integer, String> listNhanVien = new HashMap<>();
    private final TaiKhoanBUS tkbus = new TaiKhoanBUS();
    private final NhanVienBUS nhanVienBUS = new NhanVienBUS();

    public taikhoan() {
        initComponents();
        accounts = TaiKhoanDAO.getInstance().selectAll();
        tblModel = (DefaultTableModel) tblTaiKhoan.getModel();
        loadDataDSNV();
        loadDataToTable(accounts);
        tblTaiKhoan.setDefaultEditor(Object.class, null);
    }

    public void loadDataToTable(ArrayList<TaiKhoanDTO> list) {
        tblModel.setRowCount(0);
        for (TaiKhoanDTO taiKhoanDTO : list) {
            String trangthaiString = "";
            switch (taiKhoanDTO.getStatus()) {
                case 1 -> {
                    trangthaiString = "Đang hoạt động";
                }
                case 0 -> {
                    trangthaiString = "Ngưng hoạt động";
                }
            }

            String roleString = "";
            switch (taiKhoanDTO.getRoleId()) {
                case 1 ->
                    roleString = "Admin";
                case 2 ->
                    roleString = "Nhân viên nhập hàng";
                case 3 ->
                    roleString = "Nhân viên xuất hàng";
            }
            tblModel.addRow(new Object[]{
                taiKhoanDTO.getAccountId(),
                listNhanVien.get(taiKhoanDTO.getStaffId()),
                taiKhoanDTO.getUsername(),
                taiKhoanDTO.getPassword(),
                roleString,
                trangthaiString
            });
        }
    }

    public TaiKhoanDTO getSelectedAccount() {
        int selectedRowIndex = tblTaiKhoan.getSelectedRow();
        if (selectedRowIndex == -1) {
            return null;
        }
        String accountId = tblTaiKhoan.getValueAt(selectedRowIndex, 0).toString();
        return TaiKhoanDAO.getInstance().selectById(accountId);
    }

    public void loadDataDSNV() {
        ArrayList<NhanVienDTO> listNV = nhanVienBUS.getAll();
        for (NhanVienDTO nv : listNV) {
            listNhanVien.put(nv.getManv(), nv.getHoten());
        }
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTaiKhoan = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        cbxLuachon = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        jButton20 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1150, 792));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(232, 254, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1150, 792));

        tblTaiKhoan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblTaiKhoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Họ tên", "Tên đăng nhập", "Mật khẩu", "Vai trò", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTaiKhoan.setRowHeight(50);
        tblTaiKhoan.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblTaiKhoan);
        if (tblTaiKhoan.getColumnModel().getColumnCount() > 0) {
            tblTaiKhoan.getColumnModel().getColumn(0).setResizable(false);
            tblTaiKhoan.getColumnModel().getColumn(1).setResizable(false);
            tblTaiKhoan.getColumnModel().getColumn(2).setResizable(false);
            tblTaiKhoan.getColumnModel().getColumn(3).setResizable(false);
            tblTaiKhoan.getColumnModel().getColumn(4).setResizable(false);
            tblTaiKhoan.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setPreferredSize(new java.awt.Dimension(1110, 90));

        jToolBar2.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar2.setBorder(null);
        jToolBar2.setRollover(true);

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        btnThem.setText("THÊM");
        btnThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThem.setFocusable(false);
        btnThem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jToolBar2.add(btnThem);

        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit.png"))); // NOI18N
        btnSua.setText("SỬA");
        btnSua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSua.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSua.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSua.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnSuaFocusLost(evt);
            }
        });
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jToolBar2.add(btnSua);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        cbxLuachon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả", "ID", "Tên đăng nhập", "Vai trò", "Trạng thái" }));
        cbxLuachon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbxLuachon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxLuachonActionPerformed(evt);
            }
        });

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        jButton20.setText("Làm mới");
        jButton20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbxLuachon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jButton20)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxLuachon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel3.getAccessibleContext().setAccessibleName("Tìm Kiếm"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void cbxLuachonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxLuachonActionPerformed
        loadDataToTable(accounts);
    }//GEN-LAST:event_cbxLuachonActionPerformed

    private void btnSuaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnSuaFocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_btnSuaFocusLost

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        tblTaiKhoan.setEnabled(true);
        int i = tblTaiKhoan.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 tài khoản muốn sửa");
            return;
        }
        String isChoose = (String) tblModel.getValueAt(i, 2);
        if (isChoose.equals("admin")) {
            JOptionPane.showMessageDialog(this, "Tài khoản admin không thể được chỉnh sửa!!!");
            return;
        }
        updateTaiKhoan up = new updateTaiKhoan(this, (JFrame) SwingUtilities.getWindowAncestor(this), true);
        up.setVisible(true);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String choice = (String) cbxLuachon.getSelectedItem();
        String searchContent = txtSearch.getText();
        ArrayList<TaiKhoanDTO> result = new ArrayList<>();
        if (searchContent.isEmpty()) {
            loadDataToTable(TaiKhoanDAO.getInstance().selectAll());
            return;
        }
        switch (choice) {
            case "Tất Cả" ->
                result = SearchTaiKhoan.getInstance().searchTatCaAcc(searchContent);
            case "ID" ->
                result = SearchTaiKhoan.getInstance().searchIdAccount(searchContent);
            case "Tên đăng nhập" ->
                result = SearchTaiKhoan.getInstance().searchUserName(searchContent);
            case "Vai trò" ->
                result = SearchTaiKhoan.getInstance().searchRole(searchContent);
            case "Trạng thái" ->
                result = SearchTaiKhoan.getInstance().searchStatus(searchContent);
        }
        loadDataToTable(result);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        addTaiKhoan add = new addTaiKhoan(null, true);
        add.setVisible(true);
        loadDataToTable(tkbus.tkDAO.selectAll());
    }//GEN-LAST:event_btnThemActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
        txtSearch.setText("");
        cbxLuachon.setSelectedIndex(0);
        loadDataToTable(tkbus.tkDAO.selectAll());
    }//GEN-LAST:event_jButton20ActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed

    }//GEN-LAST:event_txtSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JComboBox<String> cbxLuachon;
    private javax.swing.JButton jButton20;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JTable tblTaiKhoan;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

}
