package com.testing.quanlysieuthimini.GUI.add;

import com.testing.quanlysieuthimini.BUS.SanPhamBUS;
import com.testing.quanlysieuthimini.DTO.SanPhamDTO;
import com.testing.quanlysieuthimini.BUS.PhieuXuatBUS;
import com.testing.quanlysieuthimini.DTO.PhieuXuatDTO;
import com.testing.quanlysieuthimini.DTO.ChiTietPhieuXuatDTO;
import com.testing.quanlysieuthimini.BUS.GiamGiaBUS;
import com.testing.quanlysieuthimini.DTO.GiamGiaDTO;
import com.testing.quanlysieuthimini.BUS.KhachHangBUS;
import com.testing.quanlysieuthimini.DTO.KhachHangDTO;
import com.testing.quanlysieuthimini.BUS.NhanVienBUS;
import com.testing.quanlysieuthimini.DTO.NhanVienDTO;
import com.testing.quanlysieuthimini.GUI.admin;
import com.testing.quanlysieuthimini.helper.FormatPrice;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NeON
 */
public class addphieuxuat extends javax.swing.JPanel {

    ArrayList<SanPhamDTO> list = new ArrayList<>();
    private final NhanVienDTO nhanVienDTO;
    private final FormatPrice formatPrice;
    SanPhamBUS spBUS = new SanPhamBUS();
    PhieuXuatBUS pxBUS = new PhieuXuatBUS();
    GiamGiaBUS ggBUS = new GiamGiaBUS();
    KhachHangBUS khBUS = new KhachHangBUS();
    NhanVienBUS nvBUS = new NhanVienBUS();

    public addphieuxuat(NhanVienDTO nv) {
        initComponents();
        formatPrice = new FormatPrice();
        comboctgiamgiaDisplay();
        combohotenDisplay();
        this.nhanVienDTO = nv;
        txtsdt.setEditable(false);
        txtdiachi.setEditable(false);
        txtTenNhanVien.setText(nhanVienDTO.getHoten());
        list = spBUS.spDAO.selectAll();
        displaytoTable1(list);
        tblphieuxuatin.setDefaultEditor(Object.class, null);
        tblphieuxuatout.setDefaultEditor(Object.class, null);
    }

    private void displaytoTable1(ArrayList<SanPhamDTO> list) {
        try {
            DefaultTableModel dt = (DefaultTableModel) tblphieuxuatin.getModel();
            dt.setRowCount(0);
            Date currentDate = new Date();
            for (SanPhamDTO i : list) {
                if (i.getHSD().getTime() > currentDate.getTime() && i.getSoluongton() > 0) {
                    dt.addRow(new Object[]{
                        i.getMasp(), i.getTensp(), i.getSoluongton(), i.getGiaban(), i.getHSD()
                    });
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void comboctgiamgiaDisplay() {
        ArrayList<GiamGiaDTO> listgg = ggBUS.ggDAO.selectAll();
        for (GiamGiaDTO gg : listgg) {
            comboctgiamgia.addItem(gg.getTenctgiamgia());
        }
    }

    private void combohotenDisplay() {
        ArrayList<KhachHangDTO> listkh = khBUS.khDAO.selectAll();
        for (KhachHangDTO kh : listkh) {
            combohoten.addItem(kh.getHoten());
        }
    }

    private double totalPrice() {
        DefaultTableModel model = (DefaultTableModel) tblphieuxuatout.getModel();
        int rowCount = model.getRowCount();

        int totalQuantity = 0;
        double totalprice = 0;

        for (int i = 0; i < rowCount; i++) {
            int quantity = (int) model.getValueAt(i, 2);
            double price = (double) model.getValueAt(i, 3);
            totalQuantity += quantity;
            totalprice += quantity * price;
        }
        return totalprice;
    }

    private void updateTotal() {

        // Cập nhật giá trị tổng cộng vào trường văn bản
        lableTongTien.setText(formatPrice.formatCurrency(totalPrice()));
    }

    /**
     * fo This method is called from within the constructor to initialize the
     * form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupGioiTinh = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblphieuxuatin = new javax.swing.JTable();
        btnthemsp = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        comboctgiamgia = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSoLuongXuat = new javax.swing.JTextField();
        txtTenNhanVien = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        btnxuatphieu = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtsdt = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtdiachi = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        rdnam = new javax.swing.JRadioButton();
        rdnu = new javax.swing.JRadioButton();
        combohoten = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblphieuxuatout = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lableTongTien = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tblphieuxuatin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Số lượng", "Giá bán", "HSD"
            }
        ));
        jScrollPane2.setViewportView(tblphieuxuatin);
        if (tblphieuxuatin.getColumnModel().getColumnCount() > 0) {
            tblphieuxuatin.getColumnModel().getColumn(3).setHeaderValue("Giá bán");
        }

        btnthemsp.setBackground(new java.awt.Color(102, 204, 0));
        btnthemsp.setForeground(new java.awt.Color(255, 255, 255));
        btnthemsp.setText("Thêm");
        btnthemsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemspActionPerformed(evt);
            }
        });

        jLabel12.setText("Nhân viên xuất");

        comboctgiamgia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboctgiamgiaActionPerformed(evt);
            }
        });

        jLabel11.setText("Chương trình giảm giá");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Số lượng");

        txtSoLuongXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongXuatActionPerformed(evt);
            }
        });

        txtTenNhanVien.setBackground(new java.awt.Color(204, 204, 204));
        txtTenNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtTenNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        txtTenNhanVien.setEnabled(false);
        txtTenNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenNhanVienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSoLuongXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnthemsp, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(comboctgiamgia, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(111, 111, 111))
                            .addComponent(txtTenNhanVien))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboctgiamgia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSoLuongXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2))
                    .addComponent(btnthemsp, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        btnxuatphieu.setBackground(new java.awt.Color(102, 204, 0));
        btnxuatphieu.setForeground(new java.awt.Color(255, 255, 255));
        btnxuatphieu.setText("Xuất phiếu");
        btnxuatphieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxuatphieuActionPerformed(evt);
            }
        });

        jLabel13.setText("Họ tên KH");

        jLabel14.setText("Số ĐT");

        jLabel15.setText("Địa chỉ");

        jLabel16.setText("Giới tính");

        groupGioiTinh.add(rdnam);
        rdnam.setText("Nam");
        rdnam.setEnabled(false);

        groupGioiTinh.add(rdnu);
        rdnu.setText("Nữ");
        rdnu.setEnabled(false);

        combohoten.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combohotenItemStateChanged(evt);
            }
        });

        tblphieuxuatout.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SP", "Tên SP", "Số lượng", "Giá"
            }
        ));
        jScrollPane3.setViewportView(tblphieuxuatout);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Tổng cộng:");

        lableTongTien.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lableTongTien.setForeground(new java.awt.Color(255, 0, 0));
        lableTongTien.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lableTongTien.setText("0");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13)
                            .addComponent(jLabel15)
                            .addComponent(txtdiachi)
                            .addComponent(combohoten, 0, 191, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(rdnam)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rdnu)))))
                        .addGap(3, 3, 3))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lableTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                        .addGap(31, 31, 31)
                        .addComponent(btnxuatphieu, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combohoten))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdnam)
                            .addComponent(rdnu))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnxuatphieu, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lableTongTien))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void combohotenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combohotenItemStateChanged
        // TODO add your handling code here:
        ArrayList<KhachHangDTO> listkh = khBUS.khDAO.selectAll();
        for (KhachHangDTO i : listkh) {
            if (("" + i.getHoten()).equalsIgnoreCase((String) combohoten.getSelectedItem())) {
                txtsdt.setText("" + i.getSdt());
                txtdiachi.setText("" + i.getDiachi());
                String gender = i.getGioitinh().toLowerCase();
                if (gender.equalsIgnoreCase("nam")) {
                    rdnam.setSelected(true);
                    rdnu.setSelected(false);
                } else {
                    rdnam.setSelected(false);
                    rdnu.setSelected(true);
                }
            }
        }
    }//GEN-LAST:event_combohotenItemStateChanged

    private void btnthemspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemspActionPerformed
        int selectedRow = tblphieuxuatin.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một sản phẩm từ bảng 1.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Lấy dữ liệu sản phẩm từ dòng được chọn
        Object[] rowData = new Object[5];
        for (int i = 0; i < 5; i++) {
            rowData[i] = tblphieuxuatin.getValueAt(selectedRow, i);
        }

        // Lấy số lượng xuất
        int soluong;

        try {
            soluong = Integer.parseInt(txtSoLuongXuat.getText().trim());

            int soLuongTon = (int) rowData[2];
            Date hsd = (Date) rowData[4];
            if (soluong > soLuongTon) {
                JOptionPane.showMessageDialog(this, "Số lượng xuất không được lớn hơn số lượng tồn!.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (soluong <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Thêm thông tin sản phẩm vào bảng 2
        DefaultTableModel dt2 = (DefaultTableModel) tblphieuxuatout.getModel();
        rowData[2] = soluong; // Cập nhật số lượng
        dt2.addRow(rowData);
        updateTotal(); // Tính tổng tiền
    }//GEN-LAST:event_btnthemspActionPerformed

    private void btnxuatphieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxuatphieuActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblphieuxuatout.getModel();
        ArrayList<NhanVienDTO> listnv = nvBUS.getAll();
        ArrayList<KhachHangDTO> listkh = khBUS.getAll();
        ArrayList<GiamGiaDTO> listgg = ggBUS.getAll();

        int rowCount = model.getRowCount();

        int mapx = pxBUS.phieuXuatDAO.getAutoIncrement();
        Date thoigian = new Date(System.currentTimeMillis());
        java.sql.Date sqlDate = new java.sql.Date(thoigian.getTime());
        long tongtien = 0;
        int sumsoluong = 0;
        int manv = nhanVienDTO.getManv();
        String tennv = nhanVienDTO.getHoten();
        int makh = 1;
        String tenkh = "" + combohoten.getSelectedItem();
        for (KhachHangDTO i : listkh) {
            if (tenkh.equalsIgnoreCase(i.getHoten())) {
                makh = i.getMaKH();
                break;
            }
        }
        int magg = 1;
        GiamGiaDTO gg = null;
        for (GiamGiaDTO i : listgg) {
            if (i.getTenctgiamgia().equalsIgnoreCase(("" + comboctgiamgia.getSelectedItem()))) {
                magg = i.getMagiamgia();
                gg = i;
                break;
            }
        }

        PhieuXuatDTO pxAll = new PhieuXuatDTO(mapx, sqlDate, tongtien, sumsoluong, manv, makh, magg);
        pxBUS.phieuXuatDAO.insert(pxAll);

        // Lặp qua các dòng trong bảng tblphieuxuatout
        for (int i = 0; i < rowCount; i++) {
            // Lấy mã sản phẩm và số lượng từ bảng 2
            int masp = (int) model.getValueAt(i, 0);
            int soluong = (int) model.getValueAt(i, 2);
            double dongia = (double) model.getValueAt(i, 3);
            tongtien += soluong * dongia;

            SanPhamDTO sp = spBUS.getByMaSP(masp);
            sp.setSoluongton(sp.getSoluongton() - soluong);
            spBUS.updateSoLuongTon(sp);

            ChiTietPhieuXuatDTO ctpx = new ChiTietPhieuXuatDTO(mapx, masp, soluong, dongia);
            pxBUS.phieuXuatDAO.insertCtpx(ctpx);
        }

        if (gg != null) {
            if (gg.getMocgiamgia() > tongtien) {
                tongtien -= 0;
            } else {
                tongtien = tongtien - gg.getSotienduocgiam();
            }
         
        }

        pxAll = new PhieuXuatDTO(mapx, sqlDate, tongtien, sumsoluong, manv, makh, magg);
        pxBUS.updateTongTien(pxAll);

        // Reset bảng 2 (tblphieuxuatout)
        model.setRowCount(0);
        displaytoTable1(list);

        // Hiển thị thông báo thành công
        JOptionPane.showMessageDialog(this, "Xuất hàng thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnxuatphieuActionPerformed

    private void comboctgiamgiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboctgiamgiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboctgiamgiaActionPerformed

    private void txtSoLuongXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongXuatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongXuatActionPerformed

    private void txtTenNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenNhanVienActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnthemsp;
    private javax.swing.JButton btnxuatphieu;
    private javax.swing.JComboBox<String> comboctgiamgia;
    private javax.swing.JComboBox<String> combohoten;
    private javax.swing.ButtonGroup groupGioiTinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lableTongTien;
    private javax.swing.JRadioButton rdnam;
    private javax.swing.JRadioButton rdnu;
    private javax.swing.JTable tblphieuxuatin;
    private javax.swing.JTable tblphieuxuatout;
    private javax.swing.JTextField txtSoLuongXuat;
    private javax.swing.JTextField txtTenNhanVien;
    private javax.swing.JTextField txtdiachi;
    private javax.swing.JTextField txtsdt;
    // End of variables declaration//GEN-END:variables
}
