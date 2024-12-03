/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.testing.quanlysieuthimini.BUS;
import com.testing.quanlysieuthimini.DAO.ChiTietPhieuXuatDAO;
import com.testing.quanlysieuthimini.DTO.ChiTietPhieuXuatDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
/**
 *
 * @author Bao Phan
 */
@RestController
@RequestMapping("/api/CTPhieuXuatBUS")
public class CTPhieuXuatBUS {
    public final ChiTietPhieuXuatDAO ctpxDAO = new ChiTietPhieuXuatDAO();
    private ArrayList<ChiTietPhieuXuatDTO> listctpx = new ArrayList<ChiTietPhieuXuatDTO>();

    public CTPhieuXuatBUS() {
        listctpx = ctpxDAO.selectAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    public ArrayList<ChiTietPhieuXuatDTO> getAll() {
        return this.listctpx;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getByIndex/{index}")
    public ChiTietPhieuXuatDTO getByIndex(@PathVariable int index) {
        return this.listctpx.get(index);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getIndexByMaPX/{maphieuxuat}")
    private int getIndexByMaPX(@PathVariable int maphieuxuat) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
