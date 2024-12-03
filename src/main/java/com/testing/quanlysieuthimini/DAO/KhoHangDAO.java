/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.testing.quanlysieuthimini.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.testing.quanlysieuthimini.config.JDBC;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.testing.quanlysieuthimini.DTO.KhoHangDTO;

public class KhoHangDAO implements DAOinterface<KhoHangDTO> {

    public static KhoHangDAO getInstance() {
        return new KhoHangDAO();
    }

    @Override
    public int insert(KhoHangDTO t) {
        int result = 0;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "INSERT INTO `khuvuckho`(`makhuvuc`, `tenkhuvuc`,`ghichu`,`trangthai`) VALUES (?,?,?,?)";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, t.getMakhuvuc());
            pst.setString(2, t.getTenkhuvuc());
            pst.setString(3, t.getGhichu());
            pst.setInt(4, 1);
            result = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(KhoHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int update(KhoHangDTO t) {
        int result = 0;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "UPDATE `khuvuckho` SET `tenkhuvuc`=?,`ghichu`=? WHERE `makhuvuc`=?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, t.getTenkhuvuc());
            pst.setString(2, t.getGhichu());
            pst.setInt(3, t.getMakhuvuc());
            result = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(KhoHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int delete(KhoHangDTO t) {
        int result = 0;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "UPDATE khuvuckho SET trangthai = 0 WHERE  makhuvuc = ?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, "" + t.getMakhuvuc());
            result = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(KhoHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public ArrayList<KhoHangDTO> selectAll() {
        ArrayList<KhoHangDTO> result = new ArrayList<KhoHangDTO>();
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = " SELECT * FROM `khuvuckho` WHERE `trangthai` = 1";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                KhoHangDTO kh = new KhoHangDTO();
                kh.setMakhuvuc(rs.getInt("makhuvuc"));
                kh.setTenkhuvuc(rs.getString("tenkhuvuc"));
                result.add(kh);
            }
            JDBC.closeConnection(con);
        } catch (Exception e) {
        }
        return result;
    }
    
    public ArrayList<KhoHangDTO> selectAllSanPham() {
        ArrayList<KhoHangDTO> result = new ArrayList<KhoHangDTO>();
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = " SELECT kv.makhuvuc, sp.tensp, sp.soluongton, sp.gianhap" +
                        " FROM khuvuckho kv" +
                        " INNER JOIN ctphieunhap ctpn ON kv.makhuvuc = ctpn.makhuvuc" +
                        " INNER JOIN sanpham sp ON ctpn.masp = sp.masp" +
                        " WHERE kv.trangthai = 1";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                KhoHangDTO kh = new KhoHangDTO();
                kh.setMakhuvuc(rs.getInt("makhuvuc"));
                kh.setTensp(rs.getString("tensp"));
                kh.setSlton(rs.getInt("soluongton"));
                kh.setGia(rs.getLong("gianhap"));
                result.add(kh);
            }
            JDBC.closeConnection(con);
        } catch (Exception e) {
        }
        return result;
    }

    @Override
    public KhoHangDTO selectById(String t) {
        KhoHangDTO result = null;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = " SELECT * FROM khuvuckho WHERE makhuvuc=?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                int makhuvuc = rs.getInt("makhuvuc");
                String tenkhuvuc = rs.getString("tenkhuvuc");
                String ghichu = rs.getString("ghichu");
                result = new KhoHangDTO(makhuvuc, tenkhuvuc, ghichu);
            }
            JDBC.closeConnection(con);
        } catch (Exception e) {
        }
        return result;
    }

    @Override
    public int getAutoIncrement() {
        int result = -1;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT `AUTO_INCREMENT` FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'sieuthimini' AND   TABLE_NAME   = 'khuvuckho'";
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
            Logger.getLogger(KhoHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
