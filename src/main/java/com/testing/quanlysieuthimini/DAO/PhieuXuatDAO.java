package com.testing.quanlysieuthimini.DAO;

import com.testing.quanlysieuthimini.DTO.PhieuXuatDTO;
import com.testing.quanlysieuthimini.DTO.ChiTietPhieuXuatDTO;
import com.testing.quanlysieuthimini.config.JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PhieuXuatDAO implements DAOinterface<PhieuXuatDTO> {

    public static PhieuXuatDAO getInstance() {
        return new PhieuXuatDAO();
    }

    @Override
    public int insert(PhieuXuatDTO t) {
        int result = 0;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "INSERT INTO `phieuxuat`(`maphieuxuat`, `thoigian`, `tongtien`, `soluong`, `manv`, `makh`, `magiamgia`, `trangthai`) VALUES (?,?,?,?,?,?,?,1)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMaphieuxuat());
            pst.setDate(2, t.getThoigian());
            pst.setLong(3, t.getTongtien());
            pst.setInt(4, t.getSoluong());
            pst.setInt(5, t.getManv());
            pst.setInt(6, t.getMakh());
            pst.setInt(7, t.getMagiamgia());
            result = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(PhieuXuatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int insertCtpx(ChiTietPhieuXuatDTO t) {
        int result = 0;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = " INSERT INTO `ctphieuxuat` (`maphieuxuat`, `masp`, `soluong`, `dongia`) VALUES (?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMaphieuxuat());
            pst.setInt(2, t.getMasp());
            pst.setInt(3, t.getSoluong());
            pst.setDouble(4, t.getDongia());
            result = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(PhieuXuatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int update(PhieuXuatDTO t) {
        int result = 0;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "UPDATE `phieuxuat` SET `thoigian`=?, `tongtien`=?, `soluong`=?, `manv`=?, `makh`=?, `magiamgia`=? WHERE `maphieuxuat`=?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setDate(1, t.getThoigian());
            pst.setLong(2, t.getTongtien());
            pst.setInt(3, t.getSoluong());
            pst.setInt(4, t.getManv());
            pst.setInt(5, t.getMakh());
            pst.setInt(6, t.getMagiamgia());
            pst.setInt(7, t.getMaphieuxuat());
            result = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(PhieuXuatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int updateTongTien(PhieuXuatDTO t) {
        int result = 0;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "UPDATE `phieuxuat` SET `tongtien`=? WHERE `maphieuxuat`=?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setLong(1, t.getTongtien());
            pst.setInt(2, t.getMaphieuxuat());
            result = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(PhieuXuatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int delete(PhieuXuatDTO t) {
        int result = 0;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "UPDATE phieuxuat SET trangthai = 0 WHERE maphieuxuat = ?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, "" + t.getMaphieuxuat());
            result = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(PhieuXuatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public ArrayList<PhieuXuatDTO> selectAll() {
        ArrayList<PhieuXuatDTO> result = new ArrayList<>();
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = " SELECT phieuxuat.maphieuxuat, khachhang.tenkhachhang, nhanvien.hoten, phieuxuat.thoigian, phieuxuat.tongtien,phieuxuat.magiamgia FROM phieuxuat"
                    + "                                   JOIN nhanvien ON phieuxuat.manv = nhanvien.manv"
                    + "                                   JOIN khachhang ON phieuxuat.makh = khachhang.makh"
                    + "                                   WHERE phieuxuat.trangthai = 1";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                int maphieu = rs.getInt("maphieuxuat");
                String tenkh = rs.getString("tenkhachhang");
                String tennvnhap = rs.getString("hoten");
                Date thoigiantao = rs.getDate("thoigian");
                long tongtien = rs.getLong("tongtien");
                PhieuXuatDTO phieuxuat = new PhieuXuatDTO(maphieu, tenkh, tennvnhap, thoigiantao, tongtien);
                result.add(phieuxuat);
            }
            JDBC.closeConnection(con);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    public ArrayList<PhieuXuatDTO> selectAllCtpx() {
        ArrayList<PhieuXuatDTO> result = new ArrayList<>();
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = " SELECT px.maphieuxuat, ctp.masp, ctp.soluong, ctp.dongia"
                    + " FROM phieuxuat px"
                    + " JOIN ctphieuxuat ctp ON px.maphieuxuat = ctp.maphieuxuat";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                int maphieu = rs.getInt("maphieuxuat");
                int masp = rs.getInt("masp");
                int sl = rs.getInt("soluong");
                double dongia = rs.getDouble("dongia");
               
                PhieuXuatDTO phieuxuat = new PhieuXuatDTO(maphieu, masp, sl, dongia);
                result.add(phieuxuat);
            }
            JDBC.closeConnection(con);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    public ArrayList<String> selectAllNhanvien() {
        ArrayList<String> result = new ArrayList<>();
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = " SELECT DISTINCT nv.hoten AS ten_nhanvien"
                    + " FROM phieuxuat px"
                    + " JOIN nhanvien nv ON px.manv = nv.manv";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                String tenncc = rs.getString("ten_nhanvien");
                result.add(tenncc);
            }
            JDBC.closeConnection(con);
        } catch (SQLException e) {
        }
        return result;
    }

    public ArrayList<String> selectAllKhachhang() {
        ArrayList<String> result = new ArrayList<>();
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = " SELECT DISTINCT kh.tenkhachhang AS ten_khachhang"
                    + " FROM phieuxuat px"
                    + " JOIN khachhang kh ON px.makh = kh.makh";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                String tenncc = rs.getString("ten_khachhang");
                result.add(tenncc);
            }
            JDBC.closeConnection(con);
        } catch (SQLException e) {
        }
        return result;
    }
// bao sua select by id

    @Override
    public PhieuXuatDTO selectById(String t) {
        PhieuXuatDTO result = null;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT * FROM phieuxuat WHERE maphieuxuat=?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                int maphieuxuat = rs.getInt("maphieuxuat");
                Date thoigian = rs.getDate("thoigian");
                long tongtien = rs.getLong("tongtien");
                int makh = rs.getInt("Makhachhang");
                int manv = rs.getInt("Manhanvien");
                int soluong = rs.getInt("soluong");
                int magiamgia = rs.getInt("giamgia");
                result = new PhieuXuatDTO(maphieuxuat, thoigian, tongtien, soluong, manv, makh, magiamgia);
            }
            JDBC.closeConnection(con);
        } catch (Exception e) {
        }
        return result;
    }

    public int deletePhieu(int t) {
        int result = 0;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "DELETE FROM `phieuxuat` WHERE maphieuxuat = ?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, t);
            result = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(PhieuXuatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int getAutoIncrement() {
        int result = -1;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT `AUTO_INCREMENT` FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'sieuthimini' AND TABLE_NAME   = 'phieuxuat'";
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
            Logger.getLogger(PhieuXuatDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
