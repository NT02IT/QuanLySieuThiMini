package com.testing.quanlysieuthimini.Controler;

import com.testing.quanlysieuthimini.BUS.NhanVienBUS;
import com.testing.quanlysieuthimini.DAO.TaiKhoanDAO;
import com.testing.quanlysieuthimini.DTO.NhanVienDTO;
import java.util.ArrayList;
import com.testing.quanlysieuthimini.DTO.TaiKhoanDTO;

public class SearchTaiKhoan {

    public static SearchTaiKhoan getInstance() {
        return new SearchTaiKhoan();
    }

    public ArrayList<TaiKhoanDTO> searchTatCaAcc(String text) {
        ArrayList<TaiKhoanDTO> result = new ArrayList<>();
        ArrayList<TaiKhoanDTO> armt = TaiKhoanDAO.getInstance().selectAll();
        NhanVienBUS nhanVienBUS = new NhanVienBUS();
        ArrayList<NhanVienDTO> nvList = nhanVienBUS.getAll();
        for (var tk : armt) {
            String role = "";
            switch (tk.getRoleId()) {
                case 1 ->
                    role = "admin";
                case 2 ->
                    role = "Nhân viên nhập hàng";
                case 3 ->
                    role = "Nhân viên xuất hàng";
            }

            String fullName = "";
            for (NhanVienDTO nv : nvList) {
                if (nv.getManv() == tk.getStaffId()) {
                    fullName = nv.getHoten();
                    break;
                }
            }

            String status = (tk.getStatus() == 1) ? "Đang hoạt động" : "Ngưng hoạt động";

            if ((tk.getAccountId() + "").contains(text)
                    || fullName.toLowerCase().contains(text.toLowerCase())
                    || tk.getUsername().toLowerCase().contains(text.toLowerCase())
                    || role.toLowerCase().contains(text.toLowerCase())
                    || String.valueOf(status).toLowerCase().contains(text.toLowerCase())) {
                result.add(tk);
            }
        }
        return result;
    }

    public ArrayList<TaiKhoanDTO> searchIdAccount(String text) {
        ArrayList<TaiKhoanDTO> result = new ArrayList<>();
        ArrayList<TaiKhoanDTO> armt = TaiKhoanDAO.getInstance().selectAll();
        for (var tk : armt) {
            if ((tk.getAccountId() + "").contains(text)) {
                result.add(tk);
            }
        }
        return result;
    }

    public ArrayList<TaiKhoanDTO> searchUserName(String text) {
        ArrayList<TaiKhoanDTO> result = new ArrayList<>();
        ArrayList<TaiKhoanDTO> armt = TaiKhoanDAO.getInstance().selectAll();
        for (var tk : armt) {
            if (tk.getUsername().toLowerCase().contains(text.toLowerCase())) {
                result.add(tk);
            }
        }
        return result;
    }

    public ArrayList<TaiKhoanDTO> searchRole(String text) {
        ArrayList<TaiKhoanDTO> result = new ArrayList<>();
        ArrayList<TaiKhoanDTO> armt = TaiKhoanDAO.getInstance().selectAll();
        for (var tk : armt) {
            if ((tk.getRoleId() + "").toLowerCase().contains(text.toLowerCase())) {
                result.add(tk);
            }
        }
        return result;
    }

    public ArrayList<TaiKhoanDTO> searchStatus(String text) {
        ArrayList<TaiKhoanDTO> result = new ArrayList<>();
        ArrayList<TaiKhoanDTO> armt = TaiKhoanDAO.getInstance().selectAll();
        for (var tk : armt) {
            if ((tk.getStatus() + " ").toLowerCase().contains(text.toLowerCase())) {
                result.add(tk);
            }
        }
        return result;
    }
}
