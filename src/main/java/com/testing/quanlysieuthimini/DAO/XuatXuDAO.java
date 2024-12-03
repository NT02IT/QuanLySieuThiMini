/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.testing.quanlysieuthimini.DAO;

import com.testing.quanlysieuthimini.config.JDBC;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.testing.quanlysieuthimini.DTO.XuatXuDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bao Phan
 */
public class XuatXuDAO implements DAOinterface<XuatXuDTO> {

    public static XuatXuDAO getInstance() {
        return new XuatXuDAO();
    }

    @Override
    public int insert(XuatXuDTO t) {
        int ketQua = 0;
        try {
            java.sql.Connection con = JDBC.getConnection();
            String sql = "INSERT INTO xuatxu  VALUES (?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMaxuatxu());
            pst.setString(2, t.getTenxuatxu());
            pst.setInt(3, 1);
            ketQua = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thêm được nơi xuất xứ "
                    + t.getMaxuatxu(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(XuatXuDTO t) {
        int ketQua = 0;
        try {
            java.sql.Connection con = JDBC.getConnection();
            String sql = "UPDATE xuatxu SET  tenxuatxu=? WHERE maxuatxu=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getTenxuatxu());
            pst.setInt(2, t.getMaxuatxu());
            ketQua = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

   

    @Override
    public ArrayList<XuatXuDTO> selectAll() {
        ArrayList<XuatXuDTO> result = new ArrayList<XuatXuDTO>();
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT * FROM xuatxu WHERE `trangthai`=1";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                int maxuatxu = rs.getInt("maxuatxu");
                String tenxuatxu = rs.getString("tenxuatxu");

                XuatXuDTO xuatxu = new XuatXuDTO(maxuatxu, tenxuatxu);
                result.add(xuatxu);
            }
            JDBC.closeConnection(con);
        } catch (Exception e) {
        }
        return result;
    }

    @Override
    public XuatXuDTO selectById(String t) {
        XuatXuDTO ketQua = null;
        try {
            java.sql.Connection con = JDBC.getConnection();
            String sql = "SELECT * FROM xuatxu WHERE maxuatxu=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                int maxuatxu = rs.getInt("maxuatxu");
                String tenxuatxu = rs.getString("tenxuatxu");

                ketQua = new XuatXuDTO(maxuatxu, tenxuatxu);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

    public XuatXuDTO selectByName(String t) {
        XuatXuDTO ketQua = null;
        try {
            java.sql.Connection con = JDBC.getConnection();
            String sql = "SELECT * FROM xuatxu WHERE tenxuatxu=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                int maxuatxu = rs.getInt("maxuatxu");
                String tenxuatxu = rs.getString("tenxuatxu");

                ketQua = new XuatXuDTO(maxuatxu, tenxuatxu);
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
            String sql = "SELECT `AUTO_INCREMENT` FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'sieuthimini' AND TABLE_NAME = 'xuatxu'";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs2 = pst.executeQuery(sql);
            if (!rs2.isBeforeFirst()) {
                System.out.println("No data");
            } else {
                while (rs2.next()) {
                    result = rs2.getInt("AUTO_INCREMENT");
                    //ALTER TABLE xuatxu AUTO_INCREMENT = ? đặt lại chỉ số auto 
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int delete(XuatXuDTO t) {
        int result = 0;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "Update xuatxu set `trangthai` = -1 WHERE maxuatxu = ?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, ""+t.getMaxuatxu());
            result = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(XuatXuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
