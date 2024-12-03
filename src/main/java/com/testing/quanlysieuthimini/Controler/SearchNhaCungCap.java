/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.testing.quanlysieuthimini.Controler;

/**
 *
 * @author Bao Phan
 */
import com.testing.quanlysieuthimini.DAO.NhaCungCapDAO;
import com.testing.quanlysieuthimini.DTO.NhaCungCapDTO;

import java.util.ArrayList;

/**
 *
 * @author sinh
 */
public class SearchNhaCungCap {

    public static SearchNhaCungCap getInstance() {
        return new SearchNhaCungCap();
    }

    public ArrayList<NhaCungCapDTO> searchTatCa(String text) {
        ArrayList<NhaCungCapDTO> result = new ArrayList<>();
        ArrayList<NhaCungCapDTO> armt = NhaCungCapDAO.getInstance().selectAll();

        for (NhaCungCapDTO ncc : armt) {
            if (("" + ncc.getMancc()).toLowerCase().contains(text.toLowerCase())
                    || ncc.getTenncc().toLowerCase().contains(text.toLowerCase())
                    || ncc.getSdt().toLowerCase().contains(text.toLowerCase())
                    || ncc.getDiachi().toLowerCase().contains(text.toLowerCase())
                    || ncc.getEmail().toLowerCase().contains(text.toLowerCase())) {
                result.add(ncc);
            }
        }
        return result;
    }

    public ArrayList<NhaCungCapDTO> searchTenNCC(String text) {
        ArrayList<NhaCungCapDTO> result = new ArrayList<>();
        ArrayList<NhaCungCapDTO> armt = NhaCungCapDAO.getInstance().selectAll();
        for (NhaCungCapDTO ncc : armt) {
            if (ncc.getTenncc().toLowerCase().contains(text.toLowerCase())) {
                result.add(ncc);
            }
        }
        return result;
    }

    public ArrayList<NhaCungCapDTO> searchMaNCC(String text) {
        ArrayList<NhaCungCapDTO> result = new ArrayList<>();
        ArrayList<NhaCungCapDTO> armt = NhaCungCapDAO.getInstance().selectAll();
        for (NhaCungCapDTO ncc : armt) {
            if (("" + ncc.getMancc()).toLowerCase().contains(text.toLowerCase())) {
                result.add(ncc);
            }
        }
        return result;
    }

    public ArrayList<NhaCungCapDTO> searchDiaChi(String text) {
        ArrayList<NhaCungCapDTO> result = new ArrayList<>();
        ArrayList<NhaCungCapDTO> armt = NhaCungCapDAO.getInstance().selectAll();
        for (NhaCungCapDTO ncc : armt) {
            if (ncc.getDiachi().toLowerCase().contains(text.toLowerCase())) {
                result.add(ncc);
            }
        }
        return result;
    }

    public ArrayList<NhaCungCapDTO> searchSdt(String text) {
        ArrayList<NhaCungCapDTO> result = new ArrayList<>();
        ArrayList<NhaCungCapDTO> armt = NhaCungCapDAO.getInstance().selectAll();
        for (NhaCungCapDTO ncc : armt) {
            if (ncc.getSdt().toLowerCase().contains(text.toLowerCase())) {
                result.add(ncc);
            }
        }
        return result;
    }
    public ArrayList<NhaCungCapDTO> searchEmail(String text) {
        ArrayList<NhaCungCapDTO> result = new ArrayList<>();
        ArrayList<NhaCungCapDTO> armt = NhaCungCapDAO.getInstance().selectAll();
        for (var ncc : armt) {
            if (ncc.getEmail().toLowerCase().contains(text.toLowerCase())) {
                result.add(ncc);
            }
        }
        return result;
    }
}
