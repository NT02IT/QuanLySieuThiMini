package com.testing.quanlysieuthimini.GUI;

import com.testing.quanlysieuthimini.Controler.SearchKhoHang;
import com.testing.quanlysieuthimini.BUS.KhoHangBUS;
import com.testing.quanlysieuthimini.BUS.SanPhamBUS;
import com.testing.quanlysieuthimini.DTO.KhoHangDTO;
import com.testing.quanlysieuthimini.DTO.SanPhamDTO;
import com.testing.quanlysieuthimini.GUI.add.addkho;
import com.testing.quanlysieuthimini.GUI.details.detailskho;
import com.testing.quanlysieuthimini.GUI.update.updatekho;
import com.testing.quanlysieuthimini.helper.FormatPrice;
import java.awt.Dimension;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author NeON
 */
public class khohang extends javax.swing.JPanel {
    
    ArrayList<KhoHangDTO> list = new ArrayList<KhoHangDTO>();
    private FormatPrice formatPrice;
    public KhoHangBUS khBUS = new KhoHangBUS();
    public SanPhamBUS spBUS = new SanPhamBUS();
    public ArrayList<KhoHangDTO> listKVK = khBUS.getAll();
    public ArrayList<SanPhamDTO> listSP = spBUS.getAll();
    int current = 0;

    public khohang() {
        initComponents();
        cbxAllDisplay();
        list = khBUS.kvkDAO.selectAll();
        formatPrice = new FormatPrice();
        displaytoTable(list);
        tblkho.setFocusable(false);
        tblkho.setDefaultEditor(Object.class, null);
        tblsanpham.setDefaultEditor(Object.class, null);

        tblkho.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int index = tblkho.getSelectedRow();
                if (index != -1) {
                    ArrayList<KhoHangDTO> listSP = khBUS.getByMakhuvuc(listKVK.get(index).getMakhuvuc());
                    ListCustomersInDePot(listSP);
                }
            }
        });
    }
    
    public void cbxAllDisplay() {
        cbxAll.addItem("Tất cả");
        int count = tblkho.getColumnCount();
        for (int i = 0; i < count; i++)
            cbxAll.addItem("" + tblkho.getColumnName(i));
    }
    
    public void displaytoTable(ArrayList<KhoHangDTO> list) {
        try {
            DefaultTableModel dt = (DefaultTableModel) tblkho.getModel();
            dt.setRowCount(0);
            for (KhoHangDTO i : list) {
                dt.addRow(new Object[] {
                    i.getMakhuvuc(), i.getTenkhuvuc(), i.getGhichu()
                });
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void ListCustomersInDePot(ArrayList<KhoHangDTO> result) {
        try {
            DefaultTableModel dt = (DefaultTableModel) tblsanpham.getModel();
            dt.setRowCount(0);
            int i = 0;
            for (KhoHangDTO sp : result) {
                if (sp.getSlton() != 0) {
                    dt.addRow(new Object[] {
                        sp.getTensp(), sp.getSlton(), formatPrice.formatCurrency(sp.getGia())
                    });
                    i++;
                }
            }

            if (i == 0) {
                if (result.isEmpty()) {
                    JLabel lblIcon = new JLabel("Không có sản phẩm");
                    lblIcon.setPreferredSize(new Dimension(380, 300));
                    lblIcon.setHorizontalTextPosition(SwingConstants.CENTER);
                    lblIcon.setVerticalTextPosition(SwingConstants.TOP);
                    tblsanpham.add(lblIcon);
                }
            }
            tblsanpham.repaint();
            tblsanpham.validate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public KhoHangDTO getKhoHangSelect() {
        int i_row = tblkho.getSelectedRow();
        KhoHangDTO ncc = khBUS.kvkDAO.selectAll().get(i_row);
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

        jPanel2 = new javax.swing.JPanel();
        btnreset = new javax.swing.JButton();
        txttimkiem = new javax.swing.JTextField();
        cbxAll = new javax.swing.JComboBox<>();
        jToolBar2 = new javax.swing.JToolBar();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnchitiet = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        exportExcel = new javax.swing.JButton();
        importExcel = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblsanpham = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblkho = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setPreferredSize(new java.awt.Dimension(1110, 90));

        btnreset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        btnreset.setText("Làm mới");
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
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

        jToolBar2.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar2.setBorder(null);
        jToolBar2.setRollover(true);

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
        jToolBar2.add(btnThem);

        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit.png"))); // NOI18N
        btnSua.setText("SỬA");
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

        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        btnXoa.setText("XÓA");
        btnXoa.setFocusable(false);
        btnXoa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnXoa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jToolBar2.add(btnXoa);

        btnchitiet.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnchitiet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/detail.png"))); // NOI18N
        btnchitiet.setText("XEM CHI TIẾT");
        btnchitiet.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnchitiet.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnchitiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchitietActionPerformed(evt);
            }
        });
        jToolBar2.add(btnchitiet);
        jToolBar2.add(jSeparator2);

        exportExcel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        exportExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/import_excel.png"))); // NOI18N
        exportExcel.setText("XUẤT EXCEL");
        exportExcel.setFocusable(false);
        exportExcel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        exportExcel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        exportExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportExcelActionPerformed(evt);
            }
        });
        jToolBar2.add(exportExcel);

        importExcel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        importExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/import_excel.png"))); // NOI18N
        importExcel.setText("NHẬP EXCEL");
        importExcel.setFocusable(false);
        importExcel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        importExcel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        importExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importExcelActionPerformed(evt);
            }
        });
        jToolBar2.add(importExcel);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 237, Short.MAX_VALUE)
                .addComponent(cbxAll, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnreset)
                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxAll, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnreset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Danh sách sản phẩm trong kho");

        tblsanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tên sản phẩm", "Số lượng tồn kho", "Giá nhập"
            }
        ));
        tblsanpham.setRowHeight(50);
        jScrollPane1.setViewportView(tblsanpham);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE))
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel7)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tblkho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã khu vực", "Tên khu vực", "Ghi chú"
            }
        ));
        tblkho.setRowHeight(50);
        jScrollPane2.setViewportView(tblkho);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Danh sách kho");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1098, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbxAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxAllActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxAllActionPerformed

    private void btnSuaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnSuaFocusLost
        // TODO add your handling code here
    }//GEN-LAST:event_btnSuaFocusLost

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        if (tblkho.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khu vực kho muốn sửa");
        } else {
            updatekho up = new updatekho(this, (JFrame) SwingUtilities.getWindowAncestor(this), true);
            up.setVisible(true);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        if (tblkho.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khu vực kho muốn xoá");
        } else {
            int output = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xoá khu vực kho", "Xác nhận xoá khu vực kho", JOptionPane.YES_NO_OPTION);
            if (output == JOptionPane.YES_OPTION) {
                khBUS.delete(getKhoHangSelect(), tblkho.getSelectedRow());
                JOptionPane.showMessageDialog(this, "Xóa thành công !");
                displaytoTable(khBUS.kvkDAO.selectAll());
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
       addkho a = new addkho((JFrame) SwingUtilities.getWindowAncestor(this), true);
       a.setVisible(true);
       displaytoTable(khBUS.kvkDAO.selectAll());
    }//GEN-LAST:event_btnThemActionPerformed

    private void txttimkiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttimkiemKeyReleased
        // TODO add your handling code here:
        ArrayList<KhoHangDTO> result = new ArrayList<>();
        String text = txttimkiem.getText();
        String choose = (String)cbxAll.getSelectedItem();
        switch(choose) {
            case "Tất cả":
                result = SearchKhoHang.getInstance().searchTatCa(text);
                break;
            case "Mã khu vực":
                result = SearchKhoHang.getInstance().searchMakhuvuc(text);
                break;
            case "Tên khu vực":
                result = SearchKhoHang.getInstance().searchTenkhuvuc(text);
                break;
            case "Ghi chú":
                result = SearchKhoHang.getInstance().searchGhichu(text);
                break;
        }
        displaytoTable(result);
    }//GEN-LAST:event_txttimkiemKeyReleased

    private void btnchitietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchitietActionPerformed
        // TODO add your handling code here:
        if (tblkho.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khu vực kho để xem");
        } else {
            detailskho a = new detailskho(this, (JFrame) SwingUtilities.getWindowAncestor(this), true);
            a.setVisible(true);
        }
    }//GEN-LAST:event_btnchitietActionPerformed

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        // TODO add your handling code here:
        cbxAll.setSelectedIndex(0);
        txttimkiem.setText("");
    }//GEN-LAST:event_btnresetActionPerformed

    private void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    private void exportExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportExcelActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.showSaveDialog(this);
            File saveFile = jFileChooser.getSelectedFile();
            if (saveFile != null) {
                saveFile = new File(saveFile.toString() + ".xlsx");
                Workbook wb = new XSSFWorkbook();
                Sheet sheet = wb.createSheet("Storage");

                // Định nghĩa các cột cố định
                String[] columnHeaders = {"Mã khu vực", "Tên khu vực", "Ghi chú"};

                // Tạo dòng đầu tiên cho các cột
                Row headerRow = sheet.createRow(0);
                for (int i = 0; i < columnHeaders.length; i++) {
                    Cell cell = headerRow.createCell(i);
                    cell.setCellValue(columnHeaders[i]);
                }

                // Thêm dữ liệu từ bảng vào các dòng tiếp theo
                for (int j = 0; j < Math.min(tblkho.getRowCount(), list.size()); j++) {
                    Row row = sheet.createRow(j + 1);

                    // Thêm dữ liệu từ bảng vào các cột
                    for (int k = 0; k < tblkho.getColumnCount(); k++) {
                        Cell cell = row.createCell(k);
                        if (tblkho.getValueAt(j, k) != null) {
                            cell.setCellValue(tblkho.getValueAt(j, k).toString());
                        }
                    }
                }
                FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
                wb.write(out);
                wb.close();
                out.close();
                openFile(saveFile.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_exportExcelActionPerformed

    private void importExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importExcelActionPerformed
        // TODO add your handling code here:
        File excelFile;
        FileInputStream excelFIS = null;
        BufferedInputStream excelBIS = null;
        XSSFWorkbook excelJTableImport = null;
        ArrayList<KhoHangDTO> listAccExcel = new ArrayList<KhoHangDTO>();
        JFileChooser jf = new JFileChooser();
        jf.setCurrentDirectory(new File(System.getProperty("user.dir"), "src/Excel"));
        int result = jf.showOpenDialog(null);
        jf.setDialogTitle("Open file");
        Workbook workbook = null;
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                excelFile = jf.getSelectedFile();
                excelFIS = new FileInputStream(excelFile);
                excelBIS = new BufferedInputStream(excelFIS);
                excelJTableImport = new XSSFWorkbook(excelBIS);
                XSSFSheet excelSheet = excelJTableImport.getSheetAt(0);
                int stt = khBUS.kvkDAO.getAutoIncrement();
                // Khởi tạo một DataFormatter

                for (int row = 1; row <= excelSheet.getLastRowNum(); row++) {
                    XSSFRow excelRow = excelSheet.getRow(row);
                    int makhuvuc = stt++;
                    String tenkhuvuc = (excelRow.getCell(1)).getStringCellValue();
                    String ghichu = (excelRow.getCell(2)).getStringCellValue();

                    KhoHangDTO kh = new KhoHangDTO(makhuvuc, tenkhuvuc, ghichu, 1);

                    listAccExcel.add(kh);
                    DefaultTableModel table_acc = (DefaultTableModel) tblkho.getModel();
                    table_acc.setRowCount(0);
                    displaytoTable(listAccExcel);
                }

            } catch (FileNotFoundException ex) {
                Logger.getLogger(sanpham.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(sanpham.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        for (int i = 0; i < listAccExcel.size(); i++) {

            KhoHangDTO kh = listAccExcel.get(i);
            KhoHangDTO newkh;
            newkh = new KhoHangDTO(kh.getMakhuvuc(), kh.getTenkhuvuc(), kh.getGhichu());
            khBUS.kvkDAO.insert(newkh);

        }
    }//GEN-LAST:event_importExcelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnchitiet;
    private javax.swing.JButton btnreset;
    private javax.swing.JComboBox<String> cbxAll;
    private javax.swing.JButton exportExcel;
    private javax.swing.JButton importExcel;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JTable tblkho;
    private javax.swing.JTable tblsanpham;
    private javax.swing.JTextField txttimkiem;
    // End of variables declaration//GEN-END:variables
}
