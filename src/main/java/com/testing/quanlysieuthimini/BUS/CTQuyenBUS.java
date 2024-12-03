/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.testing.quanlysieuthimini.BUS;

import com.testing.quanlysieuthimini.DAO.ChiTietQuyenDAO;
import com.testing.quanlysieuthimini.DTO.ChiTietQuyenDTO;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class CTQuyenBUS {
    
    private final ChiTietQuyenDAO ctqDAO = new ChiTietQuyenDAO();
    private ArrayList<ChiTietQuyenDTO> ctqList;
    

    public CTQuyenBUS(String t) {

        this.ctqList = ctqDAO.selectAll(t);
    }


    public CTQuyenBUS() {
      
        this.ctqList = new ArrayList<>();
    }
    

    public ArrayList<ChiTietQuyenDTO> getAll() {
        return this.ctqList;
    }
    
    public ArrayList<ChiTietQuyenDTO> getAllByQuyenId(int idQuyen) {
        ArrayList<ChiTietQuyenDTO> result = new ArrayList<>();
        for(ChiTietQuyenDTO i : this.ctqList) {
            if(i.getManhomquyen() == idQuyen)
                result.add(i);
        }
        return result;
    }
     
}
