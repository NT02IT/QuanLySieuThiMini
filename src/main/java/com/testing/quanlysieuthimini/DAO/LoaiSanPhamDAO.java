package com.testing.quanlysieuthimini.DAO;

import com.testing.quanlysieuthimini.DTO.LoaiSanPhamDTO;
import com.testing.quanlysieuthimini.config.JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Bao Phan
 */
public class LoaiSanPhamDAO implements DAOinterface<LoaiSanPhamDTO> {

    public static LoaiSanPhamDAO getInstance() {
        return new LoaiSanPhamDAO();
    }

    @Override
    public int insert(LoaiSanPhamDTO t) {
        int ketQua = 0;
        try {
            java.sql.Connection con = JDBC.getConnection();
            String sql = "INSERT INTO loaisanpham  VALUES (?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMaloai());
            pst.setString(2, t.getTenloai());
            pst.setInt(3, 1);
            ketQua = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thêm được loại sản phẩm "
                    + t.getMaloai(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(LoaiSanPhamDTO t) {
        int ketQua = 0;
        try {
            java.sql.Connection con = JDBC.getConnection();
            String sql = "UPDATE loaisanpham SET  tenloai=? WHERE maloai=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getTenloai());
            pst.setInt(2, t.getMaloai());
            ketQua = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

   
   
    @Override
    public ArrayList<LoaiSanPhamDTO> selectAll() {
        ArrayList<LoaiSanPhamDTO> result = new ArrayList<LoaiSanPhamDTO>();
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT * FROM loaisanpham where `trangthai` = 1 ";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                int maloai = rs.getInt("maloai");
                String tenloai = rs.getString("tenloai");
                LoaiSanPhamDTO lh = new LoaiSanPhamDTO(maloai, tenloai);
                result.add(lh);
            }
            JDBC.closeConnection(con);
        } catch (Exception e) {
        }
        return result;
    }

    @Override
    public LoaiSanPhamDTO selectById(String t) {
        LoaiSanPhamDTO ketQua = null;
        try {
            java.sql.Connection con = JDBC.getConnection();
            String sql = "SELECT * FROM loaisanpham WHERE maloai like ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                int maloai = rs.getInt("maloai");
                String tenloai = rs.getString("tenloai");

                ketQua = new LoaiSanPhamDTO(maloai, tenloai);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    public LoaiSanPhamDTO selectByName(String t) {
        LoaiSanPhamDTO ketQua = null;
        try {
            Connection con = JDBC.getConnection();
            String sql = "SELECT * FROM loaisanpham WHERE tenloai=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                int maloai = rs.getInt("maloai");
                String tenloai = rs.getString("tenloai");
                ketQua = new LoaiSanPhamDTO(maloai, tenloai);
            }
        } catch (SQLException e) {
            // Xử lý ngoại lệ một cách cụ thể, ví dụ: ghi log
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int getAutoIncrement() {
        int result = -1;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT `AUTO_INCREMENT` FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'sieuthimini' AND TABLE_NAME = 'loaisanpham'";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs2 = pst.executeQuery(sql);
            if (!rs2.isBeforeFirst()) {
                System.out.println("No data");
            } else {
                while (rs2.next()) {
                    result = rs2.getInt("AUTO_INCREMENT");
                    //ALTER TABLE loaisanpham AUTO_INCREMENT = ? đặt lại chỉ số auto 
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int delete(LoaiSanPhamDTO t) {
        int ketQua = 0;
        try {
            java.sql.Connection con = JDBC.getConnection();
            String sql = "update loaisanpham set trangthai = 0 WHERE maloai=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, ""+t.getMaloai());
            ketQua = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return ketQua;
    }
}
