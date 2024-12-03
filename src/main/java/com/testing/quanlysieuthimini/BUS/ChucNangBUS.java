/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.testing.quanlysieuthimini.BUS;

import com.testing.quanlysieuthimini.DAO.ChucNangDAO;
import com.testing.quanlysieuthimini.DTO.ChucNangDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
@RestController
@RequestMapping("/api/ChucNangBUS")
public class ChucNangBUS {
    
    private final ChucNangDAO cnDAO = new ChucNangDAO();
    private ArrayList<ChucNangDTO> cnList = new ArrayList<>();
    
    public ChucNangBUS() {
        this.cnList = cnDAO.selectAll();
    }
    
    public ArrayList<ChucNangDTO> getAll() {
        return this.cnList;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getIndexByID/{id}")
    public int getIndexByID(@PathVariable int id) {
        for(int i=0; i<cnList.size(); i++) {
            if(cnList.get(i).getMachucnang() == id)
                return i;
//            System.out.println("qwdbwhef"+ id);
        }
        return -1;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getNameByID/{id}")
    public String getNameByID(@PathVariable int id) {
        return cnList.get(getIndexByID(id)).getTenchucnang();
    }
    
}
