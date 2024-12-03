/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.testing.quanlysieuthimini.DAO;

import com.testing.quanlysieuthimini.DTO.GiamGiaDTO;
import com.testing.quanlysieuthimini.config.JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class GiamGiaDAO implements DAOinterface<GiamGiaDTO> {

    public static GiamGiaDAO getInstance() {
        return new GiamGiaDAO();
    }

    @Override
    public int insert(GiamGiaDTO t) {
        int ketQua = 0;
        try {
            java.sql.Connection con = JDBC.getConnection();
            String sql = "INSERT INTO giamgia  VALUES (?,?,?,?,1)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getMagiamgia());
            pst.setString(2, t.getTenctgiamgia());
            pst.setInt(3, t.getMocgiamgia());
            pst.setInt(4, t.getSotienduocgiam());
            ketQua = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thêm được loại sản phẩm "
                    + t.getMagiamgia(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public int update(GiamGiaDTO t) {
        int ketQua = 0;
        try {
            java.sql.Connection con = JDBC.getConnection();
            String sql = "UPDATE giamgia SET  tenctgiamgia=?,mocgiamgia=?,sotienduocgiam=? WHERE magiamgia=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, t.getTenctgiamgia());
            pst.setInt(2, t.getMocgiamgia());
            pst.setInt(3, t.getSotienduocgiam());
            pst.setInt(4, t.getMagiamgia());
            ketQua = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }

  
    

    @Override
    public ArrayList<GiamGiaDTO> selectAll() {
        ArrayList<GiamGiaDTO> result = new ArrayList<GiamGiaDTO>();
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT * FROM giamgia";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                int magiamgia = rs.getInt("magiamgia");
                String tenctgiamgia = rs.getString("tenctgiamgia");
                int mocgiamgia = rs.getInt("mocgiamgia");
                int sotienduocgiam = rs.getInt("sotienduocgiam");
                int trangThai = rs.getInt("trangthai");
                GiamGiaDTO gg = new GiamGiaDTO(magiamgia, tenctgiamgia, mocgiamgia, sotienduocgiam, trangThai);
                result.add(gg);
            }
            JDBC.closeConnection(con);
        } catch (Exception e) {
        }
        return result;
    }

    @Override
    public GiamGiaDTO selectById(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getAutoIncrement() {
        int result = -1;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT `AUTO_INCREMENT` FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'sieuthimini' AND TABLE_NAME = 'giamgia'";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs2 = pst.executeQuery(sql);
            if (!rs2.isBeforeFirst()) {
                System.out.println("No data");
            } else {
                while (rs2.next()) {
                    result = rs2.getInt("AUTO_INCREMENT");
                    //ALTER TABLE giamgia AUTO_INCREMENT = ? đặt lại chỉ số auto 
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
                                                                                        
    @Override
    public int delete(GiamGiaDTO t) {
        int ketQua = 0;
        try {
            java.sql.Connection con = JDBC.getConnection();
            String sql = "UPDATE giamgia set trangthai = 0 WHERE magiamgia=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, ""+t.getMagiamgia());
            ketQua = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return ketQua;
    }

}
