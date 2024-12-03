package com.testing.quanlysieuthimini.DAO;

import com.testing.quanlysieuthimini.DTO.ChiTietPhieuXuatDTO;
import com.testing.quanlysieuthimini.config.JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ChiTietPhieuXuatDAO implements DAOinterface<ChiTietPhieuXuatDTO> {

    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM ctphieuxuat WHERE maphieuxuat=?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM ctphieuxuat";

    @Override
    public ChiTietPhieuXuatDTO selectById(String maphieuxuat) {
        ChiTietPhieuXuatDTO result = null;
        try (Connection con = JDBC.getConnection();
             PreparedStatement pst = con.prepareStatement(SELECT_BY_ID_QUERY)) {
            pst.setString(1, maphieuxuat);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    int masp = rs.getInt("masp");
                    int soluong = rs.getInt("soluong");
                    int dongia = rs.getInt("dongia");
                    result = new ChiTietPhieuXuatDTO(Integer.parseInt(maphieuxuat), masp, soluong, dongia);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<ChiTietPhieuXuatDTO> selectAll() {
        ArrayList<ChiTietPhieuXuatDTO> result = new ArrayList<>();
        try (Connection con = JDBC.getConnection();
             PreparedStatement pst = con.prepareStatement(SELECT_ALL_QUERY);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                int maphieuxuat = rs.getInt("maphieuxuat");
                int masp = rs.getInt("masp");
                int soluong = rs.getInt("soluong");
                int dongia = rs.getInt("dongia");
                ChiTietPhieuXuatDTO chiTiet = new ChiTietPhieuXuatDTO(maphieuxuat, masp, soluong, dongia);
                result.add(chiTiet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int insert(ChiTietPhieuXuatDTO t) {
        throw new UnsupportedOperationException("Insert method is not supported yet.");
    }

    @Override
    public int update(ChiTietPhieuXuatDTO t) {
        throw new UnsupportedOperationException("Update method is not supported yet.");
    }

    @Override
    public int delete(ChiTietPhieuXuatDTO t) {
        throw new UnsupportedOperationException("Delete method is not supported yet.");
    }

    @Override
    public int getAutoIncrement() {
        throw new UnsupportedOperationException("Get auto increment method is not supported yet.");
    }
}
