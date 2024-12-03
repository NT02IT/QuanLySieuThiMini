package com.testing.quanlysieuthimini.BUS;

import com.testing.quanlysieuthimini.DAO.ChiTietPhieuNhapDAO;
import com.testing.quanlysieuthimini.DAO.PhieuNhapDAO;
import com.testing.quanlysieuthimini.DTO.ChiTietPhieuNhapDTO;
import com.testing.quanlysieuthimini.DTO.PhieuNhapDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

@RestController
@RequestMapping("/api/PhieuNhapBUS")
public class PhieuNhapBUS {

    public final PhieuNhapDAO phieunhapDAO = new PhieuNhapDAO();
    public final ChiTietPhieuNhapDAO ctPhieuNhapDAO = new ChiTietPhieuNhapDAO();
    NhaCungCapBUS nccBUS = new NhaCungCapBUS();
    NhanVienBUS nvBUS = new NhanVienBUS();

    ArrayList<PhieuNhapDTO> listPhieuNhap;
    ArrayList<ChiTietPhieuNhapDTO> listCtpn;

    public PhieuNhapBUS() {
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    public ArrayList<PhieuNhapDTO> getAll() {
        this.listPhieuNhap = phieunhapDAO.selectAll();
        return this.listPhieuNhap;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getAllList")
    public ArrayList<PhieuNhapDTO> getAllList() {
        return this.listPhieuNhap;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getAllCtpn")
    public ArrayList<PhieuNhapDTO> getAllCtpn() {
        return this.phieunhapDAO.selectAllCtpn();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public Boolean add(@RequestBody PhieuNhapDTO pn) {
        boolean check = phieunhapDAO.insert(pn) != 0;
        if (check) {
            this.listPhieuNhap.add(pn);
        }
        return check;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addCtpn")
    public Boolean addCtpn(@RequestBody ChiTietPhieuNhapDTO ctpn) {
        boolean check = ctPhieuNhapDAO.insert(ctpn) != 0;
        if (check) {
            this.listCtpn.add(ctpn);
        }
        return check;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public Boolean update(@RequestBody PhieuNhapDTO pn) {
        boolean check = phieunhapDAO.update(pn) != 0;
        if (check) {
            phieunhapDAO.update(pn);
        }
        return check;
    }

    public boolean delete(PhieuNhapDTO phieuNhap, int index) {
        boolean check = phieunhapDAO.delete(phieuNhap) != 0;
        if (check) {
            phieunhapDAO.delete(phieuNhap);
        }
        return check;
    }
}
