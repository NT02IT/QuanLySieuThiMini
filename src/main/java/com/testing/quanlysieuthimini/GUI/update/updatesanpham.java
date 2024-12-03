package com.testing.quanlysieuthimini.GUI.update;

import com.testing.quanlysieuthimini.DTO.SanPhamDTO;
import com.testing.quanlysieuthimini.GUI.sanpham;
import java.util.Date;
import javax.swing.JFrame;
import com.testing.quanlysieuthimini.BUS.XuatXuBUS;
import com.testing.quanlysieuthimini.BUS.ThuongHieuBUS;
import com.testing.quanlysieuthimini.BUS.LoaiSanPhamBUS;
import com.testing.quanlysieuthimini.BUS.SanPhamBUS;
import com.testing.quanlysieuthimini.DTO.LoaiSanPhamDTO;
import com.testing.quanlysieuthimini.DTO.ThuongHieuDTO;
import com.testing.quanlysieuthimini.DTO.XuatXuDTO;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Bao Phan
 */
public class updatesanpham extends javax.swing.JDialog {

    XuatXuBUS xxBUS = new XuatXuBUS();
    ThuongHieuBUS thBUS = new ThuongHieuBUS();
    LoaiSanPhamBUS lspBUS = new LoaiSanPhamBUS();
    SanPhamBUS spBUS = new SanPhamBUS();
    private SanPhamDTO sanPhamDTO;
    private sanpham parent; 
    String imagePath;

    public updatesanpham(sanpham parent, javax.swing.JFrame owner, boolean modal, SanPhamDTO sp) {
        super(owner, modal);
        this.parent = (sanpham) parent;
        this.sanPhamDTO = sp;
        initComponents();
        setLocationRelativeTo(null);
        setThuongHieuCbx();
        setXuatXuCbx();
        setLoaiSanPhamCbx();
        displayInfo();
    }

    private updatesanpham(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void displayInfo() {
        
        // Kiểm tra xem đường dẫn hình ảnh có tồn tại không
        if (sanPhamDTO.getHinhanh() != null && !sanPhamDTO.getHinhanh().isEmpty()) {
            // Tạo một đối tượng ImageIcon từ đường dẫn hình ảnh
            ImageIcon imageIcon = new ImageIcon(imagePath);
            lbimg.setIcon(imageIcon);
        } else {
            imagePath = "src/GUI/imageSanPham/comingsoon.jpg";
            ImageIcon imageIcon = new ImageIcon(imagePath);
            lbimg.setIcon(imageIcon);
        }
        txttensp.setText("" + sanPhamDTO.getTensp());
        cbxxuatxu.setSelectedItem("" + sanPhamDTO.getXuatxu());
        cbxthuonghieu.setSelectedItem("" + sanPhamDTO.getThuonghieu());
        cbxloaisp.setSelectedItem("" + sanPhamDTO.getMaloai());

    }

    public final void setThuongHieuCbx() {
        ArrayList<ThuongHieuDTO> listth = thBUS.thDAO.selectAll();
        if (listth != null) {
            for (ThuongHieuDTO th : listth) {
                cbxthuonghieu.addItem(th.getTenthuonghieu());
            }
        } else {
            System.out.println("Lỗi");
        }
    }

    public final void setLoaiSanPhamCbx() {
        ArrayList<LoaiSanPhamDTO> listlsp = lspBUS.lspDAO.selectAll();
        if (listlsp != null) {
            for (LoaiSanPhamDTO lsp : listlsp) {
                cbxloaisp.addItem(lsp.getTenloai());
            }
        } else {
            System.out.println("Lỗi");
        }
    }

    public final void setXuatXuCbx() {
        ArrayList<XuatXuDTO> listxx = xxBUS.xxDAO.selectAll();
        if (listxx != null) {
            for (XuatXuDTO th : listxx) {
                cbxxuatxu.addItem(th.getTenxuatxu());
            }
        } else {
            System.out.println("Lỗi");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txttensp = new javax.swing.JTextField();
        cbxthuonghieu = new javax.swing.JComboBox<>();
        cbxloaisp = new javax.swing.JComboBox<>();
        btnLuu = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        cbxxuatxu = new javax.swing.JComboBox<>();
        lbimg = new javax.swing.JLabel();
        btnChooseImage = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setText("Xuất Xứ");

        jLabel3.setText("Tên Sản Phẩm");

        jLabel4.setText("Loại Sản Phẩm");

        jLabel10.setText("Thương Hiệu");

        txttensp.setBackground(new java.awt.Color(204, 204, 204));
        txttensp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txttensp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        txttensp.setEnabled(false);
        txttensp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttenspActionPerformed(evt);
            }
        });

        cbxthuonghieu.setBorder(null);
        cbxthuonghieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxthuonghieuActionPerformed(evt);
            }
        });

        cbxloaisp.setBorder(null);

        btnLuu.setBackground(new java.awt.Color(51, 204, 0));
        btnLuu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLuu.setForeground(new java.awt.Color(255, 255, 255));
        btnLuu.setText("LƯU THAY ĐỔI");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnHuy.setBackground(new java.awt.Color(255, 0, 0));
        btnHuy.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnHuy.setText("HỦY BỎ");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel11.setText(
                "                                                                                 THAY ĐỔI THÔNG TIN SẢN PHẨM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                .addContainerGap()));

        cbxxuatxu.setBorder(null);

        lbimg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204), 3));

        btnChooseImage.setText("Hình minh họa");
        btnChooseImage.setBorder(null);
        btnChooseImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseImageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel2Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                        .addComponent(jLabel2)
                                                                        .addGap(98, 98, 98))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                        jPanel2Layout.createSequentialGroup()
                                                                                .addComponent(jLabel3,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        80,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(
                                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                jPanel2Layout.createSequentialGroup()
                                                                        .addComponent(jLabel10)
                                                                        .addGap(18, 18, 18)))
                                                .addGroup(jPanel2Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txttensp, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(cbxthuonghieu,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 212,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(123, 123, 123)
                                                                .addComponent(cbxxuatxu,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 236,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(424, 424, 424)
                                                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(196, 196, 196)
                                                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 139,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jLabel4)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(cbxloaisp,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 236,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbimg, javax.swing.GroupLayout.PREFERRED_SIZE, 270,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(886, Short.MAX_VALUE)
                                .addComponent(btnChooseImage, javax.swing.GroupLayout.PREFERRED_SIZE, 94,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(108, 108, 108)));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(btnChooseImage, javax.swing.GroupLayout.PREFERRED_SIZE, 24,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbimg, javax.swing.GroupLayout.PREFERRED_SIZE, 310,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(16, 16, 16)
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jLabel3,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                16,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txttensp,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                40,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel4)
                                                                        .addComponent(cbxloaisp,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                40,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGap(84, 84, 84)
                                                .addGroup(jPanel2Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(jPanel2Layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(cbxthuonghieu,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel10))
                                                        .addGroup(jPanel2Layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(cbxxuatxu,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel6)))))
                                .addGap(40, 40, 40)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 42,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 42,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(13, Short.MAX_VALUE)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap()));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLuuActionPerformed

        try {

            if (txttensp.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập tên sản phẩm");
                return;
            }
            if (txttensp.getText().matches("^[^a-zA-Z]+$")) {
                JOptionPane.showMessageDialog(this, "Tên sản phẩm chỉ được chứa chữ cái");
                return;
            }

            String tensp = txttensp.getText();
            int maxuatxu = xxBUS.getAll().get(cbxxuatxu.getSelectedIndex()).getMaxuatxu();
            int mathuonghieu = thBUS.getAll().get(cbxthuonghieu.getSelectedIndex()).getMathuonghieu();
            int maloai = lspBUS.getAll().get(cbxloaisp.getSelectedIndex()).getMaloai();
            double gianhap = parent.getSanPhamSelect().getGianhap();

            int masp = parent.getSanPhamSelect().getMasp();
            int soluongton = parent.getSanPhamSelect().getSoluongton();
            Date nsx = parent.getSanPhamSelect().getNSX();
            Date hsd = parent.getSanPhamSelect().getHSD();
            SanPhamDTO result = new SanPhamDTO(masp, maloai, tensp, imagePath, nsx, hsd, maxuatxu, mathuonghieu,
                    soluongton, gianhap, 1);
            spBUS.spDAO.update(result);
            JOptionPane.showMessageDialog(this, "Sửa thành công !");
            this.dispose();
            parent.loadDataToTable(spBUS.spDAO.selectAll());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Thất bại !");
        }
    }// GEN-LAST:event_btnLuuActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnHuyActionPerformed
        this.dispose();
    }// GEN-LAST:event_btnHuyActionPerformed

    private void btnChooseImageActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnChooseImageActionPerformed
        try {
            JFileChooser fileChooser = new JFileChooser();

            // Thiết lập thư mục mặc định cho file chooser
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir"), "src/GUI/imageSanPham"));

            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                // Lấy đường dẫn tương đối của hình ảnh được chọn
                File selectedFile = fileChooser.getSelectedFile();
                imagePath = "src/GUI/imageSanPham/" + selectedFile.getName();
                // Hiển thị hình ảnh trong JLabel với kích thước phù hợp
                ImageIcon imageIcon = new ImageIcon(imagePath);
                Image image = imageIcon.getImage().getScaledInstance(260, 300, Image.SCALE_DEFAULT);
                lbimg.setIcon(new ImageIcon(image));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }// GEN-LAST:event_btnChooseImageActionPerformed

    private void cbxthuonghieuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbxthuonghieuActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_cbxthuonghieuActionPerformed

    private void txttenspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttenspActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttenspActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                updatesanpham dialog = new updatesanpham(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnChooseImage;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLuu;
    private javax.swing.JComboBox<String> cbxloaisp;
    private javax.swing.JComboBox<String> cbxthuonghieu;
    private javax.swing.JComboBox<String> cbxxuatxu;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbimg;
    private javax.swing.JTextField txttensp;
    // End of variables declaration//GEN-END:variables
}
