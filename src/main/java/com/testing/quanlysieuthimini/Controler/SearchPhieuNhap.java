/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.testing.quanlysieuthimini.Controler;

import com.testing.quanlysieuthimini.DAO.PhieuNhapDAO;
import com.testing.quanlysieuthimini.DTO.PhieuNhapDTO;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author NeON
 */
public class SearchPhieuNhap {
    public static SearchPhieuNhap getInstance() {
        return new SearchPhieuNhap();
    }

    public ArrayList<PhieuNhapDTO> searchTatCa(String text) {
        ArrayList<PhieuNhapDTO> result = new ArrayList<>();
        ArrayList<PhieuNhapDTO> armt = PhieuNhapDAO.getInstance().selectAll();
        for (var pn : armt) {
            if ((""+pn.getMaphieunhap()).toLowerCase().contains(text.toLowerCase())
                    || pn.getTenncc().toLowerCase().contains(text.toLowerCase())
                    || pn.getTennvnhap().toLowerCase().contains(text.toLowerCase())
                    || (""+pn.getThoigian()).toLowerCase().contains(text.toLowerCase())
                    || (""+pn.getTongtien()).toLowerCase().contains(text.toLowerCase()))
             {
                result.add(pn);
            }
        }
        return result;
    }

    public ArrayList<PhieuNhapDTO> searchTenNCC(String text) {
        ArrayList<PhieuNhapDTO> result = new ArrayList<>();
        ArrayList<PhieuNhapDTO> armt = PhieuNhapDAO.getInstance().selectAll();
        for (var pn : armt) {
            if (pn.getTenncc().toLowerCase().contains(text.toLowerCase())) {
                result.add(pn);
            }
        }
        return result;
    }

    public ArrayList<PhieuNhapDTO> searchMaphieunhap(String text) {
        ArrayList<PhieuNhapDTO> result = new ArrayList<>();
        ArrayList<PhieuNhapDTO> armt = PhieuNhapDAO.getInstance().selectAll();
        for (var pn : armt) {
            if ((""+pn.getMaphieunhap()).toLowerCase().contains(text.toLowerCase())) {
                result.add(pn);
            }
        }
        return result;
    }

    public ArrayList<PhieuNhapDTO> searchTennvnhap(String text) {
        ArrayList<PhieuNhapDTO> result = new ArrayList<>();
        ArrayList<PhieuNhapDTO> armt = PhieuNhapDAO.getInstance().selectAll();
        for (var pn : armt) {
            if (pn.getTennvnhap().toLowerCase().contains(text.toLowerCase())) {
                result.add(pn);
            }
        }
        return result;
    }

    public ArrayList<PhieuNhapDTO> searchThoigian(String text) {
        ArrayList<PhieuNhapDTO> result = new ArrayList<>();
        ArrayList<PhieuNhapDTO> armt = PhieuNhapDAO.getInstance().selectAll();
        for (var pn : armt) {
            if ((""+pn.getThoigian()).toLowerCase().contains(text.toLowerCase())) {
                result.add(pn);
            }
        }
        return result;
    }
    
    public ArrayList<PhieuNhapDTO> searchTongtien(String text) {
        ArrayList<PhieuNhapDTO> result = new ArrayList<>();
        ArrayList<PhieuNhapDTO> armt = PhieuNhapDAO.getInstance().selectAll();
        for (var pn : armt) {
            if ((""+pn.getTongtien()).toLowerCase().contains(text.toLowerCase())) {
                result.add(pn);
            }
        }
        return result;
    }
    
    
    public ArrayList<PhieuNhapDTO> searchDate(Date fromDate, Date toDate) {
        ArrayList<PhieuNhapDTO> result = new ArrayList<>();
        ArrayList<PhieuNhapDTO> armt = PhieuNhapDAO.getInstance().selectAll();
        for (var pn : armt) {
            Date date = (Date)pn.getThoigian();
            if ((date.before(fromDate) && date.after(toDate)) || 
                (date.equals(fromDate) && date.equals(toDate))) {
                result.add(pn);
            }
        }
        return result;
    }
    
    public ArrayList<PhieuNhapDTO> searchTien(long fromMoney, long toMoney) {
        ArrayList<PhieuNhapDTO> result = new ArrayList<>();
        ArrayList<PhieuNhapDTO> armt = PhieuNhapDAO.getInstance().selectAll();
        for (var pn : armt) {
            long money = (long)pn.getTongtien();
            if (money >= fromMoney && money <= toMoney) {
                result.add(pn);
            }
        }
        return result;
    }
}
