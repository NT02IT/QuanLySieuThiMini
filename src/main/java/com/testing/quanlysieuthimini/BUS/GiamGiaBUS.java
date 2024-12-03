/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.testing.quanlysieuthimini.BUS;

import com.testing.quanlysieuthimini.DTO.GiamGiaDTO;
import com.testing.quanlysieuthimini.DAO.GiamGiaDAO;
import java.util.ArrayList;

public class GiamGiaBUS {

    public final GiamGiaDAO ggDAO = new GiamGiaDAO();
    private ArrayList<GiamGiaDTO> listGG = new ArrayList<GiamGiaDTO>();

    public GiamGiaBUS() {
        listGG = ggDAO.selectAll();
    }

    public ArrayList<GiamGiaDTO> getAll() {
        return this.listGG;
    }

    public GiamGiaDTO getByIndex(int index) {
        return this.listGG.get(index);
    }

    public int getIndexByMaGG(int ma) {
        int i = 0;
        int vitri = -1;
        while (i < this.listGG.size() && vitri == -1) {
            if (listGG.get(i).getMagiamgia() == ma) {
                vitri = i;
            } else {
                i++;
            }
        }
        return vitri;
    }
    
    public GiamGiaDTO getGiamGiaByID(int magg) {
        for (GiamGiaDTO gg : listGG) {
            if (gg.getMagiamgia() == magg) {
                return gg;
            }
        }
        return null;
    }

    public Boolean add(GiamGiaDTO gg) {
        boolean check = ggDAO.insert(gg) != 0;
        if (check) {
            this.listGG.add(gg);
        }
        return check;
    }

    public Boolean delete(GiamGiaDTO gg) {
        boolean check = ggDAO.delete(gg) != 0;
        if (check) {
            this.listGG.remove(gg);
        }
        return check;
    }

    public Boolean update(GiamGiaDTO gg) {
        boolean check = ggDAO.update(gg) != 0;
        if (check) {
            this.listGG.set(getIndexByMaGG(gg.getMagiamgia()), gg);
        }
        return check;
    }

    public ArrayList<GiamGiaDTO> search(String text) {
        text = text.toLowerCase();
        ArrayList<GiamGiaDTO> result = new ArrayList<>();
        for (GiamGiaDTO i : this.listGG) {
            if (Integer.toString(i.getMagiamgia()).toLowerCase().contains(text) || i.getTenctgiamgia().toLowerCase().contains(text)) {
                result.add(i);
            }
        }
        return result;
    }

    public String[] getArrTenGiamgia() {
        int size = listGG.size();
        String[] result = new String[size];
        for (int i = 0; i < size; i++) {
            result[i] = listGG.get(i).getTenctgiamgia();
        }
        return result;
    }

    public String getTenGiamGia(int magiamgia) {
        return this.listGG.get(this.getIndexByMaGG(magiamgia)).getTenctgiamgia();
    }

    public boolean checkDup(String name) {
        boolean check = true;
        int i = 0;
        while (i <= this.listGG.size() && check == true) {
            if (this.listGG.get(i).getTenctgiamgia().toLowerCase().contains(name.toLowerCase())) {
                check = false;
            } else {
                i++;
            }
        }
        return check;
    }
}
