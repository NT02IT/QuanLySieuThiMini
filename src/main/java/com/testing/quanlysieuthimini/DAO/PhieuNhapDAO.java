package com.testing.quanlysieuthimini.DAO;

import com.testing.quanlysieuthimini.DTO.PhieuNhapDTO;
import com.testing.quanlysieuthimini.config.JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PhieuNhapDAO implements DAOinterface<PhieuNhapDTO> {

    public static PhieuNhapDAO getInstance() {
        return new PhieuNhapDAO();
    }
    
    
    @Override
    public int insert(PhieuNhapDTO t) {
        int result = 0;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "INSERT INTO `phieunhap`(`maphieunhap`, `mancc`, `manv`, `thoigian`, `tongtien`, `trangthai`) VALUES (?,?,?,?,?,1)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMaphieunhap());
            pst.setInt(2, t.getMancc());
            pst.setInt(3, t.getManv());
            pst.setDate(4, t.getThoigian());
            pst.setLong(5, t.getTongtien());
            result = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public int insertCtpn(PhieuNhapDTO t) {
        int result = 0;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "INSERT INTO `ctphieunhap`(`maphieunhap`, `masp`, `soluong`, `gianhap`) VALUES (?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, getAutoIncrementCtpn());
            pst.setInt(2, t.getMasp());
            pst.setInt(3, t.getSoluong());
            pst.setLong(4, t.getDongia());
            result = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int update(PhieuNhapDTO t) {
        int result = 0;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "UPDATE `phieunhap` SET `mancc`=?, `manv`=?, `thoigian`=?, `tongtien`=? WHERE `maphieunhap`=?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, t.getMancc());
            pst.setInt(2, t.getManv());
            pst.setDate(3, t.getThoigian());
            pst.setLong(4, t.getTongtien());
            pst.setInt(5, t.getMaphieunhap());
            result = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int delete(PhieuNhapDTO t) {
        int result = 0;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "UPDATE phieunhap SET trangthai = 0 WHERE maphieunhap = ?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, "" + t.getMaphieunhap());
            result = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public ArrayList<PhieuNhapDTO> selectAll() {
        ArrayList<PhieuNhapDTO> result = new ArrayList<>();
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = " SELECT phieunhap.maphieunhap, nhacungcap.tenncc, nhanvien.hoten, phieunhap.thoigian, phieunhap.tongtien FROM phieunhap" +
                            " JOIN nhacungcap ON phieunhap.mancc = nhacungcap.mancc" +
                            " JOIN nhanvien ON phieunhap.manv = nhanvien.manv" +
                            " WHERE phieunhap.trangthai = 1";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                int maphieu = rs.getInt("maphieunhap");
                String tenncc = rs.getString("tenncc");
                String tennvnhap = rs.getString("hoten");
                Date thoigiantao = rs.getDate("thoigian");
                long tongtien = rs.getLong("tongtien");
                PhieuNhapDTO phieunhap = new PhieuNhapDTO(maphieu, tenncc, tennvnhap, thoigiantao, tongtien);
                result.add(phieunhap);
            }
            JDBC.closeConnection(con);
        } catch (SQLException e) {
        }
        return result;
    }
    
    public ArrayList<PhieuNhapDTO> selectAllCtpn() {
        ArrayList<PhieuNhapDTO> result = new ArrayList<>();
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = " SELECT * FROM ctphieunhap WHERE trangthai = 1";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                int maphieu = rs.getInt("maphieunhap");
                int masp = rs.getInt("masp");
                int sl = rs.getInt("soluong");
                long dongia = rs.getLong("dongia");
                PhieuNhapDTO chitietphieunhap = new PhieuNhapDTO(maphieu, masp, sl, dongia);
                result.add(chitietphieunhap);
            }
            JDBC.closeConnection(con);
        } catch (SQLException e) {
        }
        return result;
    }
    
    public ArrayList<PhieuNhapDTO> selectAllDetailsCtpn() {
        ArrayList<PhieuNhapDTO> result = new ArrayList<>();
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = " SELECT pn.maphieunhap, ctp.masp, sp.tensp, ctp.soluong, ctp.gianhap, kv.tenkhuvuc" +
                        " FROM phieunhap pn" +
                        " JOIN ctphieunhap ctp ON pn.maphieunhap = ctp.maphieunhap" +
                        " JOIN sanpham sp ON ctp.masp = sp.masp" +
                        " JOIN khuvuckho kv ON ctp.makhuvuc = kv.makhuvuc";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                int mapn = rs.getInt("maphieunhap");
                int masp = rs.getInt("masp");
                String tensp = rs.getString("tensp");
                int sl = rs.getInt("soluong");
                long gianhap = rs.getLong("gianhap");
                String tenkhuvuc = rs.getString("tenkhuvuc");
                PhieuNhapDTO chitietphieunhap = new PhieuNhapDTO(mapn, masp, tensp, sl, gianhap, tenkhuvuc);
                result.add(chitietphieunhap);
            }
            JDBC.closeConnection(con);
        } catch (SQLException e) {
        }
        return result;
    }
    
    public ArrayList<String> selectAllNcc() {
        ArrayList<String> result = new ArrayList<>();
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = " SELECT DISTINCT nc.tenncc AS ten_nhacungcap" +
                        " FROM phieunhap pn" +
                        " JOIN nhacungcap nc ON pn.mancc = nc.mancc";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                String tenncc = rs.getString("ten_nhacungcap");
                result.add(tenncc);
            }
            JDBC.closeConnection(con);
        } catch (SQLException e) {
        }
        return result;
    }
    
    public ArrayList<String> selectAllMancc() {
        ArrayList<String> result = new ArrayList<>();
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = " SELECT DISTINCT nc.mancc AS ma_nhacungcap" +
                        " FROM phieunhap pn" +
                        " JOIN nhacungcap nc ON pn.mancc = nc.mancc";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                String tenncc = rs.getString("ma_nhacungcap");
                result.add(tenncc);
            }
            JDBC.closeConnection(con);
        } catch (SQLException e) {
        }
        return result;
    }
    
    public ArrayList<String> selectAllNccCtpn() {
        ArrayList<String> result = new ArrayList<>();
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = " SELECT DISTINCT nhacungcap.tenncc FROM nhacungcap WHERE nhacungcap.trangthai = 1";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                String tenncc = rs.getString("tenncc");
                result.add(tenncc);
            }
            JDBC.closeConnection(con);
        } catch (SQLException e) {
        }
        return result;
    }
    
    public ArrayList<String> selectAllHoten() {
        ArrayList<String> result = new ArrayList<>();
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = " SELECT DISTINCT nv.hoten AS ten_nhanvien" +
                        " FROM phieunhap pn" +
                        " JOIN nhanvien nv ON pn.manv = nv.manv";
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
    
    public ArrayList<String> selectAllKvkCtpn() {
        ArrayList<String> result = new ArrayList<>();
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = " SELECT DISTINCT khuvuckho.makhuvuc FROM khuvuckho WHERE trangthai = 1";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                String tenncc = rs.getString("makhuvuc");
                result.add(tenncc);
            }
            JDBC.closeConnection(con);
        } catch (SQLException e) {
        }
        return result;
    }
    
    

    @Override
    public PhieuNhapDTO selectById(String t) {
        PhieuNhapDTO result = null;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT * FROM phieunhap WHERE maphieunhap=?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                int maphieu = rs.getInt("maphieunhap");
                String tenncc = rs.getString("tenncc");
                String tennvnhap = rs.getString("hoten");
                Date thoigiantao = rs.getDate("thoigian");
                long tongtien = rs.getLong("tongtien");
                result = new PhieuNhapDTO(maphieu, tenncc, tennvnhap, thoigiantao, tongtien);
            }
            JDBC.closeConnection(con);
        } catch (Exception e) {
        }
        return result;
    }
    
    public boolean checkCancelPn(int mp){
        ArrayList<PhieuNhapDTO> result = new ArrayList<>();
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT * FROM ctsanpham WHERE maphieunhap=?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, mp);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                int maphieu = rs.getInt("maphieunhap");
                String tenncc = rs.getString("tenncc");
                String tennvnhap = rs.getString("hoten");
                Date thoigiantao = rs.getDate("thoigian");
                long tongtien = rs.getLong("tongtien");
                PhieuNhapDTO phieunhap = new PhieuNhapDTO(maphieu, tenncc, tennvnhap, thoigiantao, tongtien);
                result.add(phieunhap);
            }
            JDBC.closeConnection(con);
        } catch (SQLException e) {
            System.out.println(e);
        }
        for (PhieuNhapDTO pn : result) {
            if(pn.getMaphieunhap()!=0){
                return false;
            }
        }
        return true;
    }
    

    @Override
    public int getAutoIncrement() {
        int result = -1;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT `AUTO_INCREMENT` FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'sieuthimini' AND TABLE_NAME   = 'phieunhap'";
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
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public int getAutoIncrementCtpn() {
        int result = -1;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT `AUTO_INCREMENT` FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'sieuthimini' AND TABLE_NAME   = 'ctphieunhap'";
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
            Logger.getLogger(PhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
