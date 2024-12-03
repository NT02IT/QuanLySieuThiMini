package com.testing.quanlysieuthimini.BUS;

import com.testing.quanlysieuthimini.DTO.XuatXuDTO;
import com.testing.quanlysieuthimini.DAO.XuatXuDAO;
import java.util.ArrayList;
public class XuatXuBUS {
    public final XuatXuDAO xxDAO = new XuatXuDAO();
    private ArrayList<XuatXuDTO> listXX = new ArrayList<>();
    
    public XuatXuBUS() {
        listXX = xxDAO.selectAll();
    }

    public ArrayList<XuatXuDTO> getAll() {
        return this.listXX;
    }

    public XuatXuDTO getByIndex(int index) {
        return this.listXX.get(index);
    }

    public int getIndexByMaXX(int ma) {
        int i = 0;
        int vitri = -1;
        while (i < this.listXX.size() && vitri == -1) {
            if (listXX.get(i).getMaxuatxu()== ma) {
                vitri = i;
            } else {
                i++;
            }
        }
        return vitri;
    }

    public Boolean add(XuatXuDTO xx) {
       
        boolean check = xxDAO.insert(xx) != 0;
        if (check) {
            this.listXX.add(xx);
        }
        return check;
    }

    public Boolean delete(XuatXuDTO xx) {
        boolean check = xxDAO.delete(xx) != 0;
        if (check) {
            this.listXX.remove(xx);
        }
        return check;
    }

    public Boolean update(XuatXuDTO xx) {
        boolean check = xxDAO.update(xx) != 0;
        if (check) {
            this.listXX.set(getIndexByMaXX(xx.getMaxuatxu()), xx);
        }
        return check;
    }

    public ArrayList<XuatXuDTO> search(String text) {
        text = text.toLowerCase();
        ArrayList<XuatXuDTO> result = new ArrayList<>();
        for (XuatXuDTO i : this.listXX) {
            if (Integer.toString(i.getMaxuatxu()).toLowerCase().contains(text) || i.getTenxuatxu().toLowerCase().contains(text)) {
                result.add(i);
            }
        }
        return result;
    }

    public String[] getArrTenXuatXu() {
        int size = listXX.size();
        String[] result = new String[size];
        for (int i = 0; i < size; i++) {
            result[i] = listXX.get(i).getTenxuatxu();
        }
        return result;
    }

    public String getXuatXu(int maxuatxu) {
        return this.listXX.get(this.getIndexByMaXX(maxuatxu)).getTenxuatxu();
    }

    public boolean checkDup(String name) {
        boolean check = true;
        int i = 0;
        while (i <= this.listXX.size() && check == true) {
            if (this.listXX.get(i).getTenxuatxu().toLowerCase().contains(name.toLowerCase())) {
                check = false;
            } else {
                i++;
            }
        }
        return check;
    }
}
