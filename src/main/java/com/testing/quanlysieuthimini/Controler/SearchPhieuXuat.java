/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.testing.quanlysieuthimini.Controler;

import com.testing.quanlysieuthimini.BUS.PhieuXuatBUS;
import com.testing.quanlysieuthimini.DAO.PhieuXuatDAO;
import com.testing.quanlysieuthimini.DTO.PhieuXuatDTO;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author NeON
 */
public class SearchPhieuXuat {
    PhieuXuatBUS pxbus =new PhieuXuatBUS();

    public static SearchPhieuXuat getInstance() {
        return new SearchPhieuXuat();
    }

    public ArrayList<PhieuXuatDTO> searchTatCa(String text) {
        ArrayList<PhieuXuatDTO> result = new ArrayList<>();
        ArrayList<PhieuXuatDTO> armt = PhieuXuatDAO.getInstance().selectAll();
        for (var pn : armt) {
            if (("" + pn.getMaphieuxuat()).toLowerCase().contains(text.toLowerCase())
                    || pn.getTenkhachhang().toLowerCase().contains(text.toLowerCase())
                    || pn.getTennvnhap().toLowerCase().contains(text.toLowerCase())
                    || ("" + pn.getThoigian()).toLowerCase().contains(text.toLowerCase())
                    || ("" + pn.getTongtien()).toLowerCase().contains(text.toLowerCase())) {
                result.add(pn);
            }
        }
        return result;
    }

    public ArrayList<PhieuXuatDTO> searchTenkhachhang(String text) {
        ArrayList<PhieuXuatDTO> result = new ArrayList<>();
        ArrayList<PhieuXuatDTO> armt = PhieuXuatDAO.getInstance().selectAll();
        for (var pn : armt) {
            if (pn.getTenkhachhang().toLowerCase().contains(text.toLowerCase())) {
                result.add(pn);
            }
        }
        return result;
    }

    public ArrayList<PhieuXuatDTO> searchMaphieuxuat(String text) {
        ArrayList<PhieuXuatDTO> result = new ArrayList<>();
        ArrayList<PhieuXuatDTO> armt = PhieuXuatDAO.getInstance().selectAll();
        for (var pn : armt) {
            if (("" + pn.getMaphieuxuat()).toLowerCase().contains(text.toLowerCase())) {
                result.add(pn);
            }
        }
        return result;
    }


    public ArrayList<PhieuXuatDTO> searchTennvnhap(String text) {
        ArrayList<PhieuXuatDTO> result = new ArrayList<>();
        ArrayList<PhieuXuatDTO> armt = PhieuXuatDAO.getInstance().selectAll();
        for (var pn : armt) {
            if (pn.getTennvnhap().toLowerCase().contains(text.toLowerCase())) {
                result.add(pn);
            }
        }
        return result;
    }

    public ArrayList<PhieuXuatDTO> searchThoigian(String text) {
        ArrayList<PhieuXuatDTO> result = new ArrayList<>();
        ArrayList<PhieuXuatDTO> armt = PhieuXuatDAO.getInstance().selectAll();
        for (var pn : armt) {
            if (("" + pn.getThoigian()).toLowerCase().contains(text.toLowerCase())) {
                result.add(pn);
            }
        }
        return result;
    }

    public ArrayList<PhieuXuatDTO> searchTongtien(String text) {
        ArrayList<PhieuXuatDTO> result = new ArrayList<>();
        ArrayList<PhieuXuatDTO> armt = PhieuXuatDAO.getInstance().selectAll();
        for (var pn : armt) {
            if (("" + pn.getTongtien()).toLowerCase().contains(text.toLowerCase())) {
                result.add(pn);
            }
        }
        return result;
    }

    public ArrayList<PhieuXuatDTO> searchDate(Date fromDate, Date toDate) {
        ArrayList<PhieuXuatDTO> result = new ArrayList<>();
        ArrayList<PhieuXuatDTO> armt = PhieuXuatDAO.getInstance().selectAll();
        for (var pn : armt) {
            Date date = (Date) pn.getThoigian();
            if ((date.before(fromDate) && date.after(toDate))
                    || (date.equals(fromDate) && date.equals(toDate))) {
                result.add(pn);
            }
        }
        return result;
    }

    public ArrayList<PhieuXuatDTO> searchTien(long fromMoney, long toMoney) {
        ArrayList<PhieuXuatDTO> result = new ArrayList<>();
        ArrayList<PhieuXuatDTO> armt = PhieuXuatDAO.getInstance().selectAll();
        for (var pn : armt) {
            long money = (long) pn.getTongtien();
            if (money >= fromMoney && money <= toMoney) {
                result.add(pn);
            }
        }
        return result;
    }
}
