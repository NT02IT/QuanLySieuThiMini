/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.testing.quanlysieuthimini.DAO;

import java.sql.ResultSet;
import com.testing.quanlysieuthimini.DTO.ThuongHieuDTO;
import com.testing.quanlysieuthimini.config.JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Bao Phan
 */
public class ThuongHieuDAO implements DAOinterface<ThuongHieuDTO> {

    public static ThuongHieuDAO getInstance() {
        return new ThuongHieuDAO();
    }

    @Override
    public int insert(ThuongHieuDTO t) {
        int ketQua = 0;
        try {
            java.sql.Connection con = JDBC.getConnection();
            String sql = "INSERT INTO thuonghieu  VALUES (?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMathuonghieu());
            pst.setString(2, t.getTenthuonghieu());
            pst.setInt(3, 1);
            ketQua = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thêm được thương hiệu "
                    + t.getMathuonghieu(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(ThuongHieuDTO t) {
        int ketQua = 0;
        try {
            java.sql.Connection con = JDBC.getConnection();
            String sql = "UPDATE thuonghieu SET  tenthuonghieu=? WHERE mathuonghieu=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getTenthuonghieu());
            pst.setInt(2, t.getMathuonghieu());
            ketQua = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<ThuongHieuDTO> selectAll() {
        ArrayList<ThuongHieuDTO> result = new ArrayList<ThuongHieuDTO>();
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT * FROM thuonghieu WHERE `trangthai`=1";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                int mathuonghieu = rs.getInt("mathuonghieu");
                String tenthuonghieu = rs.getString("tenthuonghieu");
                int trangthai = rs.getInt("trangthai");
                ThuongHieuDTO lh = new ThuongHieuDTO(mathuonghieu, tenthuonghieu, trangthai);
                result.add(lh);
            }
            JDBC.closeConnection(con);
        } catch (Exception e) {
        }
        return result;
    }

    @Override
    public ThuongHieuDTO selectById(String t) {
        ThuongHieuDTO ketQua = null;
        try {
            java.sql.Connection con = JDBC.getConnection();
            String sql = "SELECT * FROM thuonghieu WHERE mathuonghieu=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                int mathuonghieu = rs.getInt("mathuonghieu");
                String tenthuonghieu = rs.getString("tenthuonghieu");

                ketQua = new ThuongHieuDTO(mathuonghieu, tenthuonghieu);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    public ThuongHieuDTO selectByName(String t) {
        ThuongHieuDTO ketQua = null;
        try {
            java.sql.Connection con = JDBC.getConnection();
            String sql = "SELECT * FROM thuonghieu WHERE tenthuonghieu=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                int mathuonghieu = rs.getInt("mathuonghieu");
                String tenthuonghieu = rs.getString("tenthuonghieu");

                ketQua = new ThuongHieuDTO(mathuonghieu, tenthuonghieu);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int getAutoIncrement() {
        int result = -1;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT `AUTO_INCREMENT` FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'sieuthimini' AND TABLE_NAME = 'thuonghieu'";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs2 = pst.executeQuery(sql);
            if (!rs2.isBeforeFirst()) {
                System.out.println("No data");
            } else {
                while (rs2.next()) {
                    result = rs2.getInt("AUTO_INCREMENT");
                    //ALTER TABLE thuonghieu AUTO_INCREMENT = ? đặt lại chỉ số auto 
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int delete(ThuongHieuDTO t) {
        int result = 0;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "Update thuonghieu set `trangthai` = -1 WHERE mathuonghieu = ?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, ""+t.getMathuonghieu());
            result = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(ThuongHieuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
