package com.testing.quanlysieuthimini.BUS;

import com.testing.quanlysieuthimini.BUS.SanPhamBUS;
import com.testing.quanlysieuthimini.BUS.PhieuNhapBUS;
import com.testing.quanlysieuthimini.DAO.KhoHangDAO;
import com.testing.quanlysieuthimini.DTO.SanPhamDTO;
import com.testing.quanlysieuthimini.DTO.PhieuNhapDTO;
import com.testing.quanlysieuthimini.DTO.KhoHangDTO;
import java.util.ArrayList;

public class KhoHangBUS {

    public final KhoHangDAO kvkDAO = new KhoHangDAO();
    
    private final SanPhamBUS spBUS = new SanPhamBUS();
    private ArrayList<KhoHangDTO> listKVK = new ArrayList<>();
    private ArrayList<SanPhamDTO> listSP = new ArrayList<>();
    private ArrayList<PhieuNhapDTO> listPN = new ArrayList<>();
    
    

    public KhoHangBUS getInstance() {
        return new KhoHangBUS();
    }
    
    public KhoHangBUS() {
        listKVK = kvkDAO.selectAll();
    }

    public ArrayList<KhoHangDTO> getAll() {
        return this.listKVK;
    }

    public KhoHangDTO getByIndex(int index) {
        return this.listKVK.get(index);
    }

    public int getIndexByMaLH(int makhuvuc) {
        int i = 0;
        int vitri = -1;
        while (i < this.listKVK.size() && vitri == -1) {
            if (listKVK.get(i).getMakhuvuc() == makhuvuc) {
                vitri = i;
            } else {
                i++;
            }
        }
        return vitri;
    }

    public boolean add(KhoHangDTO kvk) {
        boolean check = kvkDAO.insert(kvk) != 0;
        if (check) {
            this.listKVK.add(kvk);
        }
        return check;
    }

    public boolean delete(KhoHangDTO kvk, int index) {
        boolean check = kvkDAO.delete(kvk) != 0;
        if (check) {
            this.listKVK.remove(index);
        }
        return check;
    }

    public boolean update(KhoHangDTO kvk) {
        boolean check = kvkDAO.update(kvk) != 0;
        if (check) {
            this.listKVK.set(getIndexByMaKVK(kvk.getMakhuvuc()), kvk);
        }
        return check;
    }

    public int getIndexByMaKVK(int makvk) {
        int i = 0;
        int vitri = -1;
        while (i < this.listKVK.size() && vitri == -1) {
            if (listKVK.get(i).getMakhuvuc() == makvk) {
                vitri = i;
                break;
            } else {
                i++;
            }
        }
        return vitri;
    }

    public ArrayList<KhoHangDTO> search(String txt, String type) {
        ArrayList<KhoHangDTO> result = new ArrayList<>();
        txt = txt.toLowerCase();
        switch (type) {
            case "Tất cả" -> {
                for (KhoHangDTO i : listKVK) {
                    if (Integer.toString(i.getMakhuvuc()).contains(txt) || i.getTenkhuvuc().toLowerCase().contains(txt)){
                        result.add(i);
                    }
                }
            }
            case "Mã khu vực kho" -> {
                for (KhoHangDTO i : listKVK) {
                    if (Integer.toString(i.getMakhuvuc()).contains(txt)) {
                        result.add(i);
                    }
                }
            }
            case "Tên khu vực kho" -> {
                for (KhoHangDTO i : listKVK) {
                    if (i.getTenkhuvuc().toLowerCase().contains(txt)) {
                        result.add(i);
                    }
                }
            }
        }
        return result;
    }
    
    public String[] getArrTenKhuVuc() {
        int size = listKVK.size();
        String[] result = new String[size];
        for(int i = 0; i < size; i++) {
            result[i] = listKVK.get(i).getTenkhuvuc();
        }
        return result;
    }
    
    public String getTenKhuVuc(int makhuvuc) {
        return this.listKVK.get(this.getIndexByMaKVK(makhuvuc)).getTenkhuvuc();
    }
    
    public ArrayList<KhoHangDTO> getByMakhuvuc(int makhuvuc) {
        ArrayList<KhoHangDTO> list = new ArrayList<>();
        ArrayList<KhoHangDTO> newlist = new ArrayList<>();
        newlist.clear();
        list = kvkDAO.selectAllSanPham();
        for (KhoHangDTO i : list) {
            if (i.getMakhuvuc() == makhuvuc) {
                newlist.add(i);
            }
        }
        return newlist;
    }
}
