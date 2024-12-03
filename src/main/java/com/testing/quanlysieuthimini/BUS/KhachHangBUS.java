package com.testing.quanlysieuthimini.BUS;

import com.testing.quanlysieuthimini.DAO.KhachHangDAO;
import com.testing.quanlysieuthimini.DTO.KhachHangDTO;
import java.util.ArrayList;

public class KhachHangBUS {

    public KhachHangDAO khDAO = new KhachHangDAO();
    public ArrayList<KhachHangDTO> listKhachHang = new ArrayList<>();

    public KhachHangBUS() {
        listKhachHang = khDAO.selectAll();
    }

    public ArrayList<KhachHangDTO> getAll() {
        return this.listKhachHang;
    }

    public KhachHangDTO getByIndex(int index) {
        return this.listKhachHang.get(index);
    }

    public int getIndexByMaDV(int makhachhang) {
        int i = 0;
        int vitri = -1;
        while (i < this.listKhachHang.size() && vitri == -1) {
            if (listKhachHang.get(i).getMaKH() == makhachhang) {
                vitri = i;
            } else {
                i++;
            }
        }
        return vitri;
    }

    public Boolean add(KhachHangDTO kh) {
        boolean check = khDAO.insert(kh) != 0;
        if (check) {
            this.listKhachHang.add(kh);
        }
        return check;
    }

    public Boolean delete(KhachHangDTO kh) {
        boolean check = khDAO.delete(kh) != 0;
        if (check) {
            this.listKhachHang.remove(getIndexByMaDV(kh.getMaKH()));
        }
        return check;
    }

    public Boolean update(KhachHangDTO kh) {
        boolean check = khDAO.update(kh) != 0;
        if (check) {
            this.listKhachHang.set(getIndexByMaDV(kh.getMaKH()), kh);
        }
        return check;
    }

    public String getTenKhachHang(int makh) {
        String name = "";
        for (KhachHangDTO khachHangDTO : listKhachHang) {
            if (khachHangDTO.getMaKH() == makh) {
                name = khachHangDTO.getHoten();
            }
        }
        return name;
    }

    public String[] getArrTenKhachHang() {
        int size = listKhachHang.size();
        String[] result = new String[size];
        for (int i = 0; i < size; i++) {
            result[i] = listKhachHang.get(i).getHoten();
        }
        return result;
    }

    public KhachHangDTO selectKh(int makh) {
        return khDAO.selectById(makh + "");
    }

    public ArrayList<KhachHangDTO> searchTatCa(String text) {
        ArrayList<KhachHangDTO> result = new ArrayList<>();
        ArrayList<KhachHangDTO> armt = KhachHangDAO.getInstance().selectAll();
        for (var kh : armt) {
            if (("" + kh.getMaKH()).toLowerCase().contains(text.toLowerCase())
                    || kh.getHoten().toLowerCase().contains(text.toLowerCase())
                    || kh.getDiachi().toLowerCase().contains(text.toLowerCase())
                    || kh.getGioitinh().toLowerCase().contains(text.toLowerCase())
                    || (kh.getSdt() + "").contains(text)
                    || (kh.getNgaythamgia() + "").contains(text)) {
                result.add(kh);
            }
        }
        return result;
    }

    public ArrayList<KhachHangDTO> searchSdt(String text) {
        ArrayList<KhachHangDTO> result = new ArrayList<>();
        ArrayList<KhachHangDTO> armt = KhachHangDAO.getInstance().selectAll();
        for (var nv : armt) {
            if (nv.getSdt().toLowerCase().contains(text.toLowerCase())) {
                result.add(nv);
            }
        }
        return result;
    }

    public boolean isPhoneNumberExists(String phoneNumber) {
        for (KhachHangDTO kh : this.listKhachHang) {
            if (kh.getSdt().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }
}
