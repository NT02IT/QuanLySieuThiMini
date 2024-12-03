package com.testing.quanlysieuthimini.GUI;

import com.testing.quanlysieuthimini.Controler.SearchPhieuNhap;
import com.testing.quanlysieuthimini.BUS.PhieuNhapBUS;
import com.testing.quanlysieuthimini.DTO.NhanVienDTO;
import com.testing.quanlysieuthimini.DTO.PhieuNhapDTO;
import com.testing.quanlysieuthimini.GUI.add.addphieunhap;
import com.testing.quanlysieuthimini.GUI.details.detailsphieunhap;
import com.testing.quanlysieuthimini.helper.FormatPrice;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NeON
 */
public final class phieunhap extends javax.swing.JPanel {
    private NhanVienDTO nhanVienDTO;
    private FormatPrice formatPrice;
    private int maQuyen;
    ArrayList<PhieuNhapDTO> list = new ArrayList<PhieuNhapDTO>();
    JpanelLoader jp = new JpanelLoader();
    PhieuNhapBUS pnBUS = new PhieuNhapBUS();
    int current = 0;

    public phieunhap(NhanVienDTO nhanVienDTO, int maQuyen) {
        initComponents();
        formatPrice = new FormatPrice();
        this.nhanVienDTO = nhanVienDTO;
        this.maQuyen = maQuyen;
        cbxAllDisplay();
        cbNccDisplay();
        cbHotenDisplay();
//        SearchDate();
        list = pnBUS.phieunhapDAO.selectAll();
        displaytoTable(list);
        tblphieunhap.setDefaultEditor(Object.class, null);
    }
    
    public void cbxAllDisplay() {
        cbxAll.addItem("Tất cả");
        int count = tblphieunhap.getColumnCount();
        for (int i = 1; i < count; i++)
            cbxAll.addItem("" + tblphieunhap.getColumnName(i));
    }
    
    public void cbNccDisplay() {
        cbncc.addItem("Tất cả");
        ArrayList<String> listncc = pnBUS.phieunhapDAO.selectAllNcc();
        int count = listncc.size();
        for (int i = 0; i < count; i++)
            cbncc.addItem("" + listncc.get(i));
    }
    
    public void cbHotenDisplay() {
        cbnvien.addItem("Tất cả");
        ArrayList<String> listhoten = pnBUS.phieunhapDAO.selectAllHoten();
        int count = listhoten.size();
        for (int i = 0; i < count; i++)
            cbnvien.addItem("" + listhoten.get(i));
    }
    
    public void displaytoTable(ArrayList<PhieuNhapDTO> list) {
        try {
            DefaultTableModel dt = (DefaultTableModel) tblphieunhap.getModel();
            int index = 1;
            dt.setRowCount(0);
            for (PhieuNhapDTO i : list) {
                dt.addRow(new Object[] {
                    index, i.getMaphieunhap(), i.getTenncc(), i.getTennvnhap(), i.getThoigian(), formatPrice.formatCurrency(i.getTongtien())
                });
                index++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public PhieuNhapDTO getPhieuNhapSelect() {
        int i_row = tblphieunhap.getSelectedRow();
        PhieuNhapDTO ncc = pnBUS.phieunhapDAO.selectAll().get(i_row);
        return ncc;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        resetBtn = new javax.swing.JButton();
        txttimkiem = new javax.swing.JTextField();
        cbxAll = new javax.swing.JComboBox<>();
        jToolBar3 = new javax.swing.JToolBar();
        btnThem = new javax.swing.JButton();
        btnChiTiet = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbncc = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbnvien = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblphieunhap = new javax.swing.JTable();

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel5.setPreferredSize(new java.awt.Dimension(1110, 90));

        resetBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        resetBtn.setText("Làm mới");
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });

        txttimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttimkiemActionPerformed(evt);
            }
        });
        txttimkiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttimkiemKeyReleased(evt);
            }
        });

        cbxAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxAllActionPerformed(evt);
            }
        });

        jToolBar3.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar3.setBorder(null);
        jToolBar3.setRollover(true);

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        btnThem.setText("THÊM");
        btnThem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jToolBar3.add(btnThem);

        btnChiTiet.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnChiTiet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/detail.png"))); // NOI18N
        btnChiTiet.setText("XEM CHI TIẾT");
        btnChiTiet.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnChiTiet.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietActionPerformed(evt);
            }
        });
        jToolBar3.add(btnChiTiet);
        jToolBar3.add(jSeparator3);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbxAll, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(resetBtn)
                .addGap(22, 22, 22))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxAll, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Nhà cung cấp");

        cbncc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbnccItemStateChanged(evt);
            }
        });

        jLabel2.setText("Nhân viên nhập");

        cbnvien.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbnvienItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(cbncc, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(cbnvien, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(704, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbncc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbnvien, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        tblphieunhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã phiếu nhập", "Nhà cung cấp", "Nhân viên nhập", "Thời gian", "Tổng tiền"
            }
        ));
        tblphieunhap.setRowHeight(50);
        jScrollPane2.setViewportView(tblphieunhap);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 1097, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbxAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxAllActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxAllActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        addphieunhap apn = new addphieunhap(nhanVienDTO);
        if (maQuyen == 1) {
            jp.jPanelLoader(admin.panel_load, apn);
        } else {
            jp.jPanelLoader(nvnhaphang.panel_load, apn);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void txttimkiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttimkiemKeyReleased
        // TODO add your handling code here:
        ArrayList<PhieuNhapDTO> result = new ArrayList<>();
        String text = txttimkiem.getText();
        String choose = (String)cbxAll.getSelectedItem();
        switch(choose) {
            case "Tất cả":
                result = SearchPhieuNhap.getInstance().searchTatCa(text);
                break;
            case "Mã phiếu nhập":
                result = SearchPhieuNhap.getInstance().searchMaphieunhap(text);
                break;
            case "Tên nhà cung cấp":
                result = SearchPhieuNhap.getInstance().searchTenNCC(text);
                break;
            case "Nhân viên nhập":
                result = SearchPhieuNhap.getInstance().searchTennvnhap(text);
                break;
            case "Thời gian":
                result = SearchPhieuNhap.getInstance().searchThoigian(text);
                break;
            case "Tổng tiền":
                result = SearchPhieuNhap.getInstance().searchTongtien(text);
        }
        displaytoTable(result);
    }//GEN-LAST:event_txttimkiemKeyReleased

    private void cbnccItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbnccItemStateChanged
        // TODO add your handling code here:
        ArrayList<PhieuNhapDTO> result = new ArrayList<>();
        String choose = (String)cbncc.getSelectedItem();
        if (choose.equals("Tất cả")) {
            result = pnBUS.phieunhapDAO.selectAll();
        } else {
            result = SearchPhieuNhap.getInstance().searchTenNCC(choose);
        }
        displaytoTable(result);
    }//GEN-LAST:event_cbnccItemStateChanged

    private void cbnvienItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbnvienItemStateChanged
        // TODO add your handling code here:
        ArrayList<PhieuNhapDTO> result = new ArrayList<>();
        String choose = (String)cbnvien.getSelectedItem();
        if (choose.equals("Tất cả")) {
            result = pnBUS.phieunhapDAO.selectAll();
        } else {
            result = SearchPhieuNhap.getInstance().searchTennvnhap(choose);
        }
        displaytoTable(result);
    }//GEN-LAST:event_cbnvienItemStateChanged

    private void btnChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietActionPerformed
        // TODO add your handling code here:
        if (tblphieunhap.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn phiếu nhập để xem");
        } else {
            detailsphieunhap a = new detailsphieunhap(this, (JFrame) SwingUtilities.getWindowAncestor(this), true);
            a.setVisible(true);
        }
    }//GEN-LAST:event_btnChiTietActionPerformed

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        // TODO add your handling code here:
        cbxAll.setSelectedIndex(0);
        txttimkiem.setText("");
        cbncc.setSelectedIndex(0);
        cbnvien.setSelectedIndex(0);
        displaytoTable(list);
    }//GEN-LAST:event_resetBtnActionPerformed

    private void txttimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttimkiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttimkiemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChiTiet;
    private javax.swing.JButton btnThem;
    private javax.swing.JComboBox<String> cbncc;
    private javax.swing.JComboBox<String> cbnvien;
    private javax.swing.JComboBox<String> cbxAll;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JButton resetBtn;
    private javax.swing.JTable tblphieunhap;
    private javax.swing.JTextField txttimkiem;
    // End of variables declaration//GEN-END:variables
}
