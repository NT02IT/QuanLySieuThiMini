/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.testing.quanlysieuthimini.BUS;

import com.testing.quanlysieuthimini.DAO.ThuongHieuDAO;
import com.testing.quanlysieuthimini.DTO.ThuongHieuDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 *
 * @author 84907
 */
@RestController
@RequestMapping("/api/ThuongHieuBUS")
public class ThuongHieuBUS {

    public final ThuongHieuDAO thDAO = new ThuongHieuDAO();
    private ArrayList<ThuongHieuDTO> listTH = new ArrayList<>();

    public ThuongHieuBUS() {
        listTH = thDAO.selectAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    public ArrayList<ThuongHieuDTO> getAll() {
        return this.listTH;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getByIndex")
    public ThuongHieuDTO getByIndex(@RequestParam int index) {
        return this.listTH.get(index);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getIndexByMaLH")
    public int getIndexByMaLH(@RequestParam int ma) {
        int i = 0;
        int vitri = -1;
        while (i < this.listTH.size() && vitri == -1) {
            if (listTH.get(i).getMathuonghieu() == ma) {
                vitri = i;
            } else {
                i++;
            }
        }
        return vitri;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public Boolean add(@RequestBody ThuongHieuDTO th) {

        boolean check = thDAO.insert(th) != 0;
        if (check) {
            this.listTH.add(th);
        }
        return check;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public Boolean delete(@RequestBody ThuongHieuDTO lh) {
        boolean check = thDAO.delete(lh) != 0;
        if (check) {
            this.listTH.remove(lh);
        }
        return check;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public Boolean update(@RequestBody ThuongHieuDTO th) {
        boolean check = thDAO.update(th) != 0;
        if (check) {
            this.listTH.set(getIndexByMaLH(th.getMathuonghieu()), th);
        }
        return check;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search/{text}")
    public ArrayList<ThuongHieuDTO> search(@PathVariable String text) {
        text = text.toLowerCase();
        ArrayList<ThuongHieuDTO> result = new ArrayList<>();
        for (ThuongHieuDTO i : this.listTH) {
            if (Integer.toString(i.getMathuonghieu()).toLowerCase().contains(text) || i.getTenthuonghieu().toLowerCase().contains(text)) {
                result.add(i);
            }
        }
        return result;
    }

    public String[] getArrTenThuongHieu() {
        int size = listTH.size();
        String[] result = new String[size];
        for (int i = 0; i < size; i++) {
            result[i] = listTH.get(i).getTenthuonghieu();
        }
        return result;
    }

    public String getTenThuongHieu(int mathuonghieu) {
        return this.listTH.get(this.getIndexByMaLH(mathuonghieu)).getTenthuonghieu();
    }

    public boolean checkDup(String name) {
        boolean check = true;
        int i = 0;
        while (i <= this.listTH.size() && check == true) {
            if (this.listTH.get(i).getTenthuonghieu().toLowerCase().contains(name.toLowerCase())) {
                check = false;
            } else {
                i++;
            }
        }
        return check;
    }
}
