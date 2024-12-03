package com.testing.quanlysieuthimini.DAO;

import com.testing.quanlysieuthimini.DTO.ChiTietPhieuNhapDTO;
import com.testing.quanlysieuthimini.config.JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

public class ChiTietPhieuNhapDAO implements DAOinterface<ChiTietPhieuNhapDTO> {

    public static ChiTietPhieuNhapDAO getInstance() {
        return new ChiTietPhieuNhapDAO();
    }

    @Override
    public int insert(ChiTietPhieuNhapDTO t) {
        int result = 0;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "INSERT INTO `ctphieunhap`(`maphieunhap`, `masp`, `makhuvuc`,`soluong`, `gianhap`) VALUES (?,?,?,?,?)";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, t.getMaphieunhap());
            pst.setInt(2, t.getMasp());
            pst.setInt(3, t.getMakhuvukho());
            pst.setInt(4, t.getSoluong());
            pst.setDouble(5, t.getDongia());
            result = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietPhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return result;
    }

    @Override
    public int update(ChiTietPhieuNhapDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ChiTietPhieuNhapDTO selectById(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getAutoIncrement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(ChiTietPhieuNhapDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<ChiTietPhieuNhapDTO> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
