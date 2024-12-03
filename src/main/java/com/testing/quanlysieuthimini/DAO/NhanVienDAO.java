package com.testing.quanlysieuthimini.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.testing.quanlysieuthimini.config.JDBC;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.testing.quanlysieuthimini.DTO.NhanVienDTO;
import java.sql.Statement;

public class NhanVienDAO implements DAOinterface<NhanVienDTO> {

    public static NhanVienDAO getInstance() {
        return new NhanVienDAO();
    }

    // Hàm lấy danh sách nhân viên chưa có tài khoản
    public ArrayList<NhanVienDTO> getListNVNoAccount() {
        ArrayList<NhanVienDTO> list = new ArrayList<>();
        try {
            Statement s = (Statement) JDBC.getConnection().createStatement();
            ResultSet rs = s.executeQuery(" SELECT * FROM nhanvien nv LEFT JOIN taikhoan tk ON nv.manv = tk.manv where tk.manv IS NULL AND nv.manv IN (SELECT manv from nhanvien where trangthai = 1)");
            while (rs.next()) {
                NhanVienDTO nv = new NhanVienDTO();
                nv.setManv(rs.getInt("manv"));
                nv.setHoten(rs.getString("hoten"));
                nv.setGioitinh(rs.getString("gioitinh"));
                nv.setNgaysinh(rs.getDate("ngaysinh"));
                nv.setSdt(rs.getString("sdt"));
                nv.setEmail(rs.getString("email"));
                nv.setTrangthai(rs.getInt("trangthai"));
                list.add(nv);
            }
        } catch (SQLException e) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, "SQL getListNVNoAccount error", e);
        }
        return list;
    }

    @Override
    public int insert(NhanVienDTO t) {
        int result = 0;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "INSERT INTO `nhanvien`(`hoten`, `gioitinh`,`ngaysinh`,`sdt`,`email`,`trangthai`) VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, t.getHoten());
            pst.setString(2, t.getGioitinh());
            pst.setDate(3, (Date) (t.getNgaysinh()));
            pst.setString(4, t.getSdt());
            pst.setString(5, t.getEmail());
            pst.setInt(6, 1);
            result = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int update(NhanVienDTO t) {
        int result = 0;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "UPDATE `nhanvien` SET`hoten`=?,`gioitinh`=?,`ngaysinh`=?,`sdt`=?, `trangthai`=?, `email`=?  WHERE `manv`=?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, t.getHoten());
            pst.setString(2, t.getGioitinh());
            pst.setDate(3, (Date) t.getNgaysinh());
            pst.setString(4, t.getSdt());
            pst.setInt(5, t.getTrangthai());
            pst.setString(6, t.getEmail());
            pst.setInt(7, t.getManv());
            result = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int delete(NhanVienDTO t) {
        int result = 0;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "Update nhanvien set `trangthai` = 0 WHERE manv = ?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, "" + t.getManv());
            result = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public ArrayList<NhanVienDTO> selectAll() {
        ArrayList<NhanVienDTO> result = new ArrayList<>();
        try {
            Statement s = (Statement) JDBC.getConnection().createStatement();
            ResultSet rs = s.executeQuery(" SELECT * FROM nhanvien WHERE trangthai = '1' ");
            while (rs.next()) {
                NhanVienDTO nv = new NhanVienDTO();
                nv.setManv(rs.getInt("manv"));
                nv.setHoten(rs.getString("hoten"));
                nv.setGioitinh(rs.getString("gioitinh"));
                nv.setNgaysinh(rs.getDate("ngaysinh"));
                nv.setSdt(rs.getString("sdt"));
                nv.setEmail(rs.getString("email"));
                nv.setTrangthai(rs.getInt("trangthai"));
                
                result.add(nv);
            }
        } catch (SQLException e) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }

    public ArrayList<NhanVienDTO> selectAllNV() {
        ArrayList<NhanVienDTO> result = new ArrayList<>();
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT * FROM nhanvien nv where nv.trangthai = 1 and not EXISTS(SELECT * FROM taikhoan tk WHERE nv.manv=tk.manv)";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                int manv = rs.getInt("manv");
                String hoten = rs.getString("hoten");
                String gioitinh = rs.getString("gioitinh");
                Date ngaysinh = rs.getDate("ngaysinh");
                String sdt = rs.getString("sdt");
                int trangthai = rs.getInt("trangthai");
                String email = rs.getString("email");
                NhanVienDTO nv = new NhanVienDTO(manv, hoten, gioitinh, ngaysinh, sdt, email, trangthai);
                result.add(nv);
            }
            JDBC.closeConnection(con);
        } catch (SQLException e) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }

    @Override
    public NhanVienDTO selectById(String t) {
        NhanVienDTO result = null;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT * FROM nhanvien WHERE manv=?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                int manv = rs.getInt("manv");
                String hoten = rs.getString("hoten");
                String gioitinh = rs.getString("gioitinh");
                Date ngaysinh = rs.getDate("ngaysinh");
                String sdt = rs.getString("sdt");
                int trangthai = rs.getInt("trangthai");
                String email = rs.getString("email");

                result = new NhanVienDTO(manv, hoten, gioitinh, ngaysinh, sdt, email, trangthai);
            }
            JDBC.closeConnection(con);
        } catch (SQLException e) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return result;
    }

    @Override
    public int getAutoIncrement() {
        int result = -1;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT `AUTO_INCREMENT` FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'sieuthimini' AND TABLE_NAME = 'nhanvien'";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            if (!rs.isBeforeFirst()) {
                System.out.println("No data");
            } else {
                while (rs.next()) {
                    result = rs.getInt("AUTO_INCREMENT");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
}
