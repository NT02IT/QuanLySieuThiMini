/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.testing.quanlysieuthimini.BUS;

import com.testing.quanlysieuthimini.DTO.LoaiSanPhamDTO;
import com.testing.quanlysieuthimini.DAO.LoaiSanPhamDAO;
import java.util.ArrayList;

public class LoaiSanPhamBUS {

    public final LoaiSanPhamDAO lspDAO = new LoaiSanPhamDAO();
    private ArrayList<LoaiSanPhamDTO> listLSP = new ArrayList<LoaiSanPhamDTO>();

    public LoaiSanPhamBUS() {
        listLSP = lspDAO.selectAll();
    }

    public ArrayList<LoaiSanPhamDTO> getAll() {
        return this.listLSP;
    }

    public LoaiSanPhamDTO getByIndex(int index) {
        return this.listLSP.get(index);
    }

    public int getIndexByMaLH(int ma) {
        int i = 0;
        int vitri = -1;
        while (i < this.listLSP.size() && vitri == -1) {
            if (listLSP.get(i).getMaloai() == ma) {
                vitri = i;
            } else {
                i++;
            }
        }
        return vitri;
    }

    public Boolean add(LoaiSanPhamDTO lsp) {
        boolean check = lspDAO.insert(lsp) != 0;
        if (check) {
            this.listLSP.add(lsp);
        }
        return check;
    }

    public Boolean delete(LoaiSanPhamDTO lh) {
        boolean check = lspDAO.delete(lh) != 0;
        if (check) {
            this.listLSP.remove(lh);
        }
        return check;
    }

    public Boolean update(LoaiSanPhamDTO lsp) {
        boolean check = lspDAO.update(lsp) != 0;
        if (check) {
            this.listLSP.set(getIndexByMaLH(lsp.getMaloai()), lsp);
        }
        return check;
    }

    public ArrayList<LoaiSanPhamDTO> search(String text) {
        text = text.toLowerCase();
        ArrayList<LoaiSanPhamDTO> result = new ArrayList<>();
        for (LoaiSanPhamDTO i : this.listLSP) {
            if (Integer.toString(i.getMaloai()).toLowerCase().contains(text) || i.getTenloai().toLowerCase().contains(text)) {
                result.add(i);
            }
        }
        return result;
    }

    public String[] getArrTenLoai() {
        int size = listLSP.size();
        String[] result = new String[size];
        for (int i = 0; i < size; i++) {
            result[i] = listLSP.get(i).getTenloai();
        }
        return result;
    }

    public String getTenLoai(int maloai) {
        return this.listLSP.get(this.getIndexByMaLH(maloai)).getTenloai();
    }

    public boolean checkDup(String name) {
        boolean check = true;
        int i = 0;
        while (i <= this.listLSP.size() && check == true) {
            if (this.listLSP.get(i).getTenloai().toLowerCase().contains(name.toLowerCase())) {
                check = false;
            } else {
                i++;
            }
        }
        return check;
    }
}
