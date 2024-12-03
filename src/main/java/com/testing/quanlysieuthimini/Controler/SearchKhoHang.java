/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.testing.quanlysieuthimini.Controler;

import com.testing.quanlysieuthimini.DAO.KhoHangDAO;
import com.testing.quanlysieuthimini.DTO.KhoHangDTO;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.*;

/**
 *
 * @author NeON
 */
@RestController
@RequestMapping("/api")
public class SearchKhoHang {
    public static SearchKhoHang getInstance() {
        return new SearchKhoHang();
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/searchTatCa/{text}")
    public ArrayList<KhoHangDTO> searchTatCa(@PathVariable String text) {
        ArrayList<KhoHangDTO> result = new ArrayList<>();
        ArrayList<KhoHangDTO> armt = KhoHangDAO.getInstance().selectAll();
        for (var pn : armt) {
            if ((""+pn.getMakhuvuc()).toLowerCase().contains(text.toLowerCase())
                    || pn.getTenkhuvuc().toLowerCase().contains(text.toLowerCase())
                    || pn.getGhichu().toLowerCase().contains(text.toLowerCase()))
             {
                result.add(pn);
            }
        }
        return result;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/searchMakhuvuc/{text}")
    public ArrayList<KhoHangDTO> searchMakhuvuc(@PathVariable String text) {
        ArrayList<KhoHangDTO> result = new ArrayList<>();
        ArrayList<KhoHangDTO> armt = KhoHangDAO.getInstance().selectAll();
        for (var pn : armt) {
            if ((""+pn.getMakhuvuc()).toLowerCase().contains(text.toLowerCase())) {
                result.add(pn);
            }
        }
        return result;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/searchTenkhuvuc/{text}")
    public ArrayList<KhoHangDTO> searchTenkhuvuc(@PathVariable String text) {
        ArrayList<KhoHangDTO> result = new ArrayList<>();
        ArrayList<KhoHangDTO> armt = KhoHangDAO.getInstance().selectAll();
        for (var pn : armt) {
            if (pn.getTenkhuvuc().toLowerCase().contains(text.toLowerCase())) {
                result.add(pn);
            }
        }
        return result;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/searchGhichu/{text}")
    public ArrayList<KhoHangDTO> searchGhichu(@PathVariable String text) {
        ArrayList<KhoHangDTO> result = new ArrayList<>();
        ArrayList<KhoHangDTO> armt = KhoHangDAO.getInstance().selectAll();
        for (var pn : armt) {
            if (pn.getGhichu().toLowerCase().contains(text.toLowerCase())) {
                result.add(pn);
            }
        }
        return result;
    }
}
