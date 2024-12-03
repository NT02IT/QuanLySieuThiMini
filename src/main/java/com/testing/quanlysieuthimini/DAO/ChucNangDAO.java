/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.testing.quanlysieuthimini.DAO;

import com.testing.quanlysieuthimini.DTO.ChucNangDTO;
import com.testing.quanlysieuthimini.config.JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ChucNangDAO {

    public static ChucNangDAO getInstance() {
        return new ChucNangDAO();
    }

    public ArrayList<ChucNangDTO> selectAll() {
        ArrayList<ChucNangDTO> result = new ArrayList<>();
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT * FROM danhmucchucnang";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while (rs.next()) {
                int machucnang = rs.getInt("machucnang");
                String tenchucnang = rs.getString("tenchucnang");
                ChucNangDTO dvt = new ChucNangDTO(machucnang, tenchucnang);
                result.add(dvt);
            }
            JDBC.closeConnection(con);
        } catch (Exception e) {
        }
        return result;
    }
}
