/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import com.testing.quanlysieuthimini.DTO.KhachHangDTO;
import java.time.LocalDate;

public class KhachHangDAO implements DAOinterface<KhachHangDTO> {

    public static KhachHangDAO getInstance() {
        return new KhachHangDAO();
    }

    @Override
    public int insert(KhachHangDTO t) {
        int result = 0;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "INSERT INTO `khachhang`(`tenkhachhang`, `diachi`, `gioitinh`, `sdt`, `ngaythamgia`, `trangthai`) VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, t.getHoten());
            pst.setString(2, t.getDiachi());
            pst.setString(3, t.getGioitinh());
            pst.setString(4, t.getSdt());
            Date currentDate = Date.valueOf(LocalDate.now());
            pst.setDate(5, currentDate);
            pst.setInt(6,1);
            result = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int update(KhachHangDTO t) {
        int result = 0;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "UPDATE `khachhang` SET `tenkhachhang`=?, `diachi`=?, `gioitinh`=?, `sdt`=?, `ngaythamgia`=?, `trangthai`=? WHERE makh=?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, t.getHoten());
            pst.setString(2, t.getDiachi());
            pst.setString(3, t.getGioitinh());
            pst.setString(4, t.getSdt());
            pst.setDate(5, (Date) t.getNgaythamgia());
            pst.setInt(6, t.getTrangthai());
            pst.setInt(7, t.getMaKH());
            
            result = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int delete(KhachHangDTO t) {
        int result = 0;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "UPDATE  `khachhang` SET `trangthai` = 0 WHERE `makh` = ?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, "" + t.getMaKH());
            result = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public ArrayList<KhachHangDTO> selectAll() {
        ArrayList<KhachHangDTO> result = new ArrayList<KhachHangDTO>();
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT * FROM khachhang WHERE trangthai=1";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while(rs.next()){
                KhachHangDTO kh = new KhachHangDTO();
                kh.setMaKH(rs.getInt("makh"));
                kh.setHoten(rs.getString("tenkhachhang"));
                kh.setGioitinh(rs.getString("gioitinh"));
                kh.setDiachi(rs.getString("diachi"));
                kh.setSdt(rs.getString("sdt"));
                kh.setNgaythamgia(rs.getDate("ngaythamgia"));
                result.add(kh);
            }
            JDBC.closeConnection(con);
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
    
    public ArrayList<String> selectAllTenkh() {
        ArrayList<String> result = new ArrayList<String>();
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT DISTINCT tenkhachhang FROM khachhang WHERE trangthai=1";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while(rs.next()){
                String tenkh = rs.getString("tenkhachhang");
                result.add(tenkh);
            }
            JDBC.closeConnection(con);
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    @Override
    public KhachHangDTO selectById(String t) {
        KhachHangDTO result = null;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT * FROM khachhang WHERE makh=?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while(rs.next()){
                int makh = rs.getInt("makh");
                String tenkhachhang = rs.getString("tenkhachhang");
                String diachi = rs.getString("diachi");
                String gioitinh = rs.getString("gioitinh");
                String sdt = rs.getString("sdt");
                Date ngaythamgia = rs.getDate("ngaythamgia");
                int trangthai = rs.getInt("trangthai");
                result = new KhachHangDTO(makh, tenkhachhang, diachi, gioitinh, sdt, ngaythamgia, trangthai);
            }
            JDBC.closeConnection(con);
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
    
    @Override
    public int getAutoIncrement() {
        int result = -1;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT `AUTO_INCREMENT` FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'quanlikhohang' AND   TABLE_NAME   = 'khachhang'";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs2 = pst.executeQuery(sql);
            if (!rs2.isBeforeFirst() ) {
                System.out.println("No data");
            } else {
                while ( rs2.next() ) {
                    result = rs2.getInt("AUTO_INCREMENT");
                    
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
