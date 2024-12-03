package com.testing.quanlysieuthimini.BUS;

import com.testing.quanlysieuthimini.DAO.PhieuXuatDAO;
import com.testing.quanlysieuthimini.DTO.PhieuXuatDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author robot
 */
@RestController
@RequestMapping("/api/PhieuXuatBUS")
public class PhieuXuatBUS {

    public final PhieuXuatDAO phieuXuatDAO = new PhieuXuatDAO();

    private final ArrayList<PhieuXuatDTO> listPhieuXuat;

    NhanVienBUS nvBUS = new NhanVienBUS();
    KhachHangBUS khBUS = new KhachHangBUS();

    public PhieuXuatBUS() {
        this.listPhieuXuat = phieuXuatDAO.selectAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getAll")
    public ArrayList<PhieuXuatDTO> getAll() {
        return this.listPhieuXuat;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getSelect/{index}")
    public PhieuXuatDTO getSelect(@PathVariable int index) {
        return listPhieuXuat.get(index);
    }

//    public void cancel(int px) {
//        phieuXuatDAO.cancel(px);
//    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/remove/{px}")
    public void remove(@PathVariable int px) {
        listPhieuXuat.remove(px);
    }

    public boolean delete(PhieuXuatDTO phieuXuat, int index) {
        boolean check = phieuXuatDAO.delete(phieuXuat) != 0;
        if (check) {
            this.listPhieuXuat.remove(index);
        }
        return check;
    }


    public boolean update(PhieuXuatDTO phieuXuat) {
        boolean check = phieuXuatDAO.update(phieuXuat) != 0;
        if (check) {
            this.listPhieuXuat.set(getIndexByMaphieuxuat(phieuXuat.getMaphieuxuat()), phieuXuat);
        }
        return check;
    }
    public void updateTongTien(PhieuXuatDTO phieuXuat) {
        try {
            phieuXuatDAO.updateTongTien(phieuXuat);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/getIndexByMaphieuxuat/{mapx}")
    public int getIndexByMaphieuxuat(@PathVariable int mapx) {
        int i = 0;
        int vitri = -1;
        while (i < this.listPhieuXuat.size() && vitri == -1) {
            if (listPhieuXuat.get(i).getMaphieuxuat() == mapx) {
                vitri = i;
                break;
            } else {
                i++;
            }
        }
        return vitri;
    }
    
//    public void insert(PhieuXuatDTO px, ArrayList<ChiTietPhieuDTO> ct) {
//        phieuXuatDAO.insert(px);
//        chiTietPhieuXuatDAO.insert(ct);
//    }
//
//    public ArrayList<ChiTietPhieuDTO> selectCTP(int maphieu) {
//        return chiTietPhieuXuatDAO.selectAll(Integer.toString(maphieu));
//    }
//
//    public ArrayList<PhieuXuatDTO> fillerPhieuXuat(int type, String input, int makh, int manv, Date time_s, Date time_e, String price_minnn, String price_maxxx) {
//        Long price_min = !price_minnn.equals("") ? Long.valueOf(price_minnn) : 0L;
//        Long price_max = !price_maxxx.equals("") ? Long.valueOf(price_maxxx) : Long.MAX_VALUE;
//        Timestamp time_start = new Timestamp(time_s.getTime());
//
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTimeInMillis(time_e.getTime());
//
//        // Đặt giá trị cho giờ, phút, giây và mili giây của Calendar
//        calendar.set(Calendar.HOUR_OF_DAY, 23);
//        calendar.set(Calendar.MINUTE, 59);
//        calendar.set(Calendar.SECOND, 0);
//        calendar.set(Calendar.MILLISECOND, 0);
//
//        Timestamp time_end = new Timestamp(calendar.getTimeInMillis());
//
//        ArrayList<PhieuXuatDTO> result = new ArrayList<>();
//        for (PhieuXuatDTO phieuXuat : getAll()) {
//            boolean match = false;
//            switch (type) {
//                case 0 -> {
//                    if (Integer.toString(phieuXuat.getMaphieu()).contains(input)
//                            || khBUS.getTenKhachHang(phieuXuat.getMakh()).toLowerCase().contains(input)
//                            || nvBUS.getNameById(phieuXuat.getManguoitao()).toLowerCase().contains(input)) {
//                        match = true;
//                    }
//                }
//                case 1 -> {
//                    if (Integer.toString(phieuXuat.getMaphieu()).contains(input)) {
//                        match = true;
//                    }
//                }
//                case 2 -> {
//                    if (khBUS.getTenKhachHang(phieuXuat.getMakh()).toLowerCase().contains(input)) {
//                        match = true;
//                    }
//                }
//                case 3 -> {
//                    if (nvBUS.getNameById(phieuXuat.getManguoitao()).toLowerCase().contains(input)) {
//                        match = true;
//                    }
//                }
//            }
//
//            if (match
//                    && (manv == 0 || phieuXuat.getManguoitao() == manv) && (makh == 0 || phieuXuat.getMakh() == makh)
//                    && (phieuXuat.getThoigiantao().compareTo(time_start) >= 0)
//                    && (phieuXuat.getThoigiantao().compareTo(time_end) <= 0)
//                    && phieuXuat.getTongTien() >= price_min
//                    && phieuXuat.getTongTien() <= price_max) {
//                result.add(phieuXuat);
//            }
//        }
//
//        return result;
//    }

}
