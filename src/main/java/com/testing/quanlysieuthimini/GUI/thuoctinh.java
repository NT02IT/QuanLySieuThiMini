package com.testing.quanlysieuthimini.GUI;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import com.testing.quanlysieuthimini.GUI.thuoctinhsanpham.thuonghieu;
import com.testing.quanlysieuthimini.GUI.thuoctinhsanpham.xuatxu;
import com.testing.quanlysieuthimini.GUI.thuoctinhsanpham.loaisanpham;
import com.testing.quanlysieuthimini.GUI.thuoctinhsanpham.giamgia;

public class thuoctinh extends javax.swing.JPanel {

    /**
     *
     */
    public thuoctinh() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        btnThuonghieu = new javax.swing.JButton();
        btnLoaisanpham = new javax.swing.JButton();
        btnXuatxu = new javax.swing.JButton();
        btnGiamgia = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1100, 900));
        setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(1100, 800));

        btnThuonghieu.setBackground(new java.awt.Color(153, 255, 153));
        btnThuonghieu.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        btnThuonghieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/brand_100px.png"))); // NOI18N
        btnThuonghieu.setText("           Thương hiệu");
        btnThuonghieu.setAlignmentX(0.5F);
        btnThuonghieu.setBorder(null);
        btnThuonghieu.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnThuonghieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThuonghieuActionPerformed(evt);
            }
        });

        btnLoaisanpham.setBackground(new java.awt.Color(204, 204, 255));
        btnLoaisanpham.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        btnLoaisanpham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/classification (1).png"))); // NOI18N
        btnLoaisanpham.setText("            Loại sản phẩm");
        btnLoaisanpham.setBorder(null);
        btnLoaisanpham.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnLoaisanpham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoaisanphamActionPerformed(evt);
            }
        });

        btnXuatxu.setBackground(new java.awt.Color(255, 204, 204));
        btnXuatxu.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        btnXuatxu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/factory_100px.png"))); // NOI18N
        btnXuatxu.setText("             Xuất xứ");
        btnXuatxu.setBorder(null);
        btnXuatxu.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnXuatxu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatxuActionPerformed(evt);
            }
        });

        btnGiamgia.setBackground(new java.awt.Color(255, 255, 204));
        btnGiamgia.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        btnGiamgia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/coupon (1).png"))); // NOI18N
        btnGiamgia.setText("             Giảm giá");
        btnGiamgia.setBorder(null);
        btnGiamgia.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnGiamgia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiamgiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnThuonghieu, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoaisanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnXuatxu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGiamgia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXuatxu, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThuonghieu, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoaisanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGiamgia, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(235, Short.MAX_VALUE))
        );

        add(jPanel5, java.awt.BorderLayout.CENTER);
        jPanel5.getAccessibleContext().setAccessibleName("Thuộc tính sản phẩm");
    }// </editor-fold>//GEN-END:initComponents

    private void btnThuonghieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThuonghieuActionPerformed
        thuonghieu th = new thuonghieu((JFrame) SwingUtilities.getWindowAncestor(this), true);
        th.setVisible(true);


    }//GEN-LAST:event_btnThuonghieuActionPerformed

    private void btnXuatxuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatxuActionPerformed
        xuatxu xx = new xuatxu((JFrame) SwingUtilities.getWindowAncestor(this), true);
        xx.setVisible(true);
    }//GEN-LAST:event_btnXuatxuActionPerformed

    private void btnLoaisanphamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoaisanphamActionPerformed
        // TODO add your handling code here:
        loaisanpham lsp = new loaisanpham((JFrame) SwingUtilities.getWindowAncestor(this), true);
        lsp.setVisible(true);
    }//GEN-LAST:event_btnLoaisanphamActionPerformed

    private void btnGiamgiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiamgiaActionPerformed
        // TODO add your handling code here:
        giamgia gg = new giamgia((JFrame) SwingUtilities.getWindowAncestor(this), true);
        gg.setVisible(true);
    }//GEN-LAST:event_btnGiamgiaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGiamgia;
    private javax.swing.JButton btnLoaisanpham;
    private javax.swing.JButton btnThuonghieu;
    private javax.swing.JButton btnXuatxu;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
