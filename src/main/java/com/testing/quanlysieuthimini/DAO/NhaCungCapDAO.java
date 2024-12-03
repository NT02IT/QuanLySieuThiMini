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
import com.testing.quanlysieuthimini.DTO.NhaCungCapDTO;
import java.sql.Statement;

public class NhaCungCapDAO implements DAOinterface<NhaCungCapDTO> {

    public static NhaCungCapDAO getInstance() {
        return new NhaCungCapDAO();
    }

    @Override
    public int insert(NhaCungCapDTO t) {
        int result = 0;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "INSERT INTO `nhacungcap`(`mancc`, `tenncc`, `diachi`, `email`, `sdt`, `trangthai`) VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, t.getMancc());
            pst.setString(2, t.getTenncc());
            pst.setString(3, t.getDiachi());
            pst.setString(4, t.getEmail());
            pst.setString(5, t.getSdt());
            pst.setInt(6, 1);
            result = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public int update(NhaCungCapDTO t) {
       int result = 0 ;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "UPDATE `nhacungcap` SET `tenncc`=?,`diachi`=?,`email`=?,`sdt`=? WHERE `mancc`= ?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, t.getTenncc());
            pst.setString(2, t.getDiachi());
            pst.setString(3, t.getEmail());
            pst.setString(4, t.getSdt());
            pst.setInt(5, t.getMancc());
            result = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public int delete(NhaCungCapDTO t) {
        int result = 0;
        try {
            Connection con = (Connection) JDBC.getConnection();
             String sql = "Update nhacungcap set `trangthai` = 0 WHERE mancc = ?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, "" + t.getMancc());
            result = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public ArrayList<NhaCungCapDTO> selectAll() {
        ArrayList<NhaCungCapDTO> ketQua = new ArrayList<NhaCungCapDTO>();
        try {
            java.sql.Connection con = JDBC.getConnection();
            Statement s = (Statement) JDBC.getConnection().createStatement();
            ResultSet rs = s.executeQuery(" SELECT * FROM nhacungcap where `trangthai` = 1");
            while (rs.next()) {
                NhaCungCapDTO ncc = new NhaCungCapDTO();
                ncc.setMancc(rs.getInt(1));
                ncc.setTenncc(rs.getString(2));
                ncc.setDiachi(rs.getString(3));
                ncc.setEmail(rs.getString(4));
                ncc.setSdt(rs.getString(5));
                ncc.setTrangthai(rs.getInt(6));
                ketQua.add(ncc);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public NhaCungCapDTO selectById(String t) {
        NhaCungCapDTO result = null;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT * FROM nhacungcap WHERE manhacungcap=?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                int mancc = rs.getInt("manhacungcap");
                String tenncc = rs.getString("tennhacungcap");
                String diachi = rs.getString("diachi");
                String email = rs.getString("diachi");
                String sdt = rs.getString("sdt");
                result = new NhaCungCapDTO(mancc, tenncc, diachi, email, sdt, 1);
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
            String sql = "SELECT `AUTO_INCREMENT` FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'sieuthimini' AND   TABLE_NAME   = 'nhacungcap'";
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
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
