package com.testing.quanlysieuthimini.DAO;

import com.testing.quanlysieuthimini.config.JDBC;
import com.testing.quanlysieuthimini.DTO.TaiKhoanDTO;
import com.testing.quanlysieuthimini.GUI.taikhoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TaiKhoanDAO implements DAOinterface<TaiKhoanDTO> {

    public static TaiKhoanDAO getInstance() {
        return new TaiKhoanDAO();
    }

    @Override
    public int insert(TaiKhoanDTO account) {
        int result = 0;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "INSERT INTO `taikhoan`(`manv`,`tendangnhap`,`matkhau`,`manhomquyen`,`trangthai`) VALUES (?,?,?,?,?)";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);

            pst.setInt(1, account.getStaffId());
            pst.setString(2, account.getUsername());
            pst.setString(3, account.getPassword());
            pst.setInt(4, account.getRoleId());
            pst.setInt(5, account.getStatus());

            result = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException e) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, "SQL error", e);
        }
        return result;
    }

    @Override
    public int update(TaiKhoanDTO account) {
        int result = 0;
        try {
            Connection con = JDBC.getConnection();
            String sql = "UPDATE `taikhoan` SET `tendangnhap`=?, `matkhau`=?, `manhomquyen`=?, `trangthai`=? WHERE manv=?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, account.getUsername());
            pst.setString(2, account.getPassword());
            pst.setInt(3, account.getRoleId());
            pst.setInt(4, account.getStatus());
            pst.setInt(5, account.getStaffId());

            result = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException e) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, "SQL error", e);
        }
        return result;
    }

    public int delete(int manv) {
        int result = 0;
        try {
            Connection conn = (Connection) JDBC.getConnection();
            String query = "UPDATE `taikhoan` SET `trangthai`=0 WHERE `manv`=?";
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
            pst.setInt(1, manv);
            result = pst.executeUpdate();
            JDBC.closeConnection(conn);
        } catch (SQLException e) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, "SQL error", e);
        }
        return result;
    }

    @Override
    public ArrayList<TaiKhoanDTO> selectAll() {
        ArrayList<TaiKhoanDTO> result = new ArrayList<>();
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT * FROM taikhoan";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                int accountId = rs.getInt("mataikhoan");
                int staffId = rs.getInt("manv");
                String username = rs.getString("tendangnhap");
                String password = rs.getString("matkhau");
                int role = rs.getInt("manhomquyen");
                int status = rs.getInt("trangthai");

                TaiKhoanDTO tk = new TaiKhoanDTO(accountId, staffId, username, password, role, status);
                result.add(tk);
            }
            JDBC.closeConnection(con);
        } catch (SQLException e) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, "SQL error", e);
        }
        return result;
    }

    @Override
    public TaiKhoanDTO selectById(String s) {
        TaiKhoanDTO result = null;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT * FROM taikhoan WHERE mataikhoan=?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, s);
            ResultSet rs = (ResultSet) pst.executeQuery();
            if (rs.next()) {
                int accountId = rs.getInt("mataikhoan");
                int staffId = rs.getInt("manv");
                String username = rs.getString("tendangnhap");
                String password = rs.getString("matkhau");
                int role = rs.getInt("manhomquyen");
                int status = rs.getInt("trangthai");

                result = new TaiKhoanDTO(accountId,staffId, username, password, role, status);
            }
            JDBC.closeConnection(con);
        } catch (SQLException e) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, "SQL error", e);
        }
        return result;
    }

    public TaiKhoanDTO selectByUsername(String s) {
        TaiKhoanDTO result = null;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT * FROM taikhoan WHERE tendangnhap=?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, s);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                int staff = rs.getInt("manv");
                String username = rs.getString("tendangnhap");
                String password = rs.getString("matkhau");
                int role = rs.getInt("manhomquyen");
                int status = rs.getInt("trangthai");

                result = new TaiKhoanDTO(staff, username, password, role, status);
            }
            JDBC.closeConnection(con);
        } catch (SQLException e) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, "SQL error", e);
        }
        return result;
    }

    public void insert(taikhoan tk) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getAutoIncrement() {
        int result = -1;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT `AUTO_INCREMENT` FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'sieuthimini' AND   TABLE_NAME   = 'taikhoan'";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs2 = pst.executeQuery(sql);
            if (!rs2.isBeforeFirst()) {
                System.out.println("No data");
            } else {
                while (rs2.next()) {
                    result = rs2.getInt("AUTO_INCREMENT");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Data Error");
        }
        return result;
    }

    @Override
    public int delete(TaiKhoanDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int delete(String toString) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
