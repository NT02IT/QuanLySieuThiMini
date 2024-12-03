package com.testing.quanlysieuthimini.BUS;

import com.testing.quanlysieuthimini.DAO.NhanVienDAO;
import com.testing.quanlysieuthimini.DTO.NhanVienDTO;
import java.util.ArrayList;

public class NhanVienBUS {

    public NhanVienDAO nvDAO = new NhanVienDAO();
    public ArrayList<NhanVienDTO> listNv = NhanVienDAO.getInstance().selectAll();
    public NhanVienDAO nhanVienDAO = NhanVienDAO.getInstance();

    public NhanVienBUS() {
        listNv = nvDAO.selectAll();
    }

    public ArrayList<NhanVienDTO> getAll() {
        return this.listNv;
    }

    // Lấy danh sách nhân viên chưa có tài khoản
    public ArrayList<NhanVienDTO> getListNVNoAccount() {
        ArrayList<NhanVienDTO> list = nvDAO.getListNVNoAccount();
        return (list != null) ? list : new ArrayList<>();
    }

    public NhanVienDTO getNhanVienByMaNv(int maNV) {
        for (NhanVienDTO i : listNv) {
            if (i.getManv() == maNV) {
                return i;
            }
        }
        return null;
    }

    public NhanVienDTO getByIndex(int index) {
        return this.listNv.get(index);
    }

    public int getIndexById(int manv) {
        int i = 0;
        int vitri = -1;
        int size = this.listNv.size();
        while (i < size && vitri == -1) {
            if (this.listNv.get(i).getManv() == manv) {
                vitri = i;
            } else {
                i++;
            }
        }
        return vitri;
    }

    public Boolean add(NhanVienDTO nv) {
        boolean check = nvDAO.insert(nv) != 0;
        if (check) {
            this.listNv.add(nv);
        }
        return check;
    }

    public String getNameById(int manv) {
        return nhanVienDAO.selectById(manv + "").getHoten();
    }

    public String[] getArrTenNhanVien() {
        int size = listNv.size();
        String[] result = new String[size];
        for (int i = 0; i < size; i++) {
            result[i] = listNv.get(i).getHoten();
        }
        return result;
    }

    public boolean update(NhanVienDTO nv) {
        boolean check = nvDAO.update(nv) != 0;
        if (check) {
            this.listNv.set(getIndexById(nv.getManv()), nv);
        }
        return check;
    }

    public Boolean delete(NhanVienDTO nv) {
        boolean check = nvDAO.delete(nv) != 0;
        if (check) {
            this.listNv.remove(nv);
        }
        return check;
    }

    public ArrayList<NhanVienDTO> searchTatCa(String text) {
        ArrayList<NhanVienDTO> result = new ArrayList<>();
        ArrayList<NhanVienDTO> armt = NhanVienDAO.getInstance().selectAll();
        for (var nv : armt) {
            if (("" + nv.getManv()).toLowerCase().contains(text.toLowerCase())
                    || nv.getHoten().toLowerCase().contains(text.toLowerCase())
                    || nv.getEmail().toLowerCase().contains(text.toLowerCase())
                    || nv.getSdt().contains(text)
                    || nv.getGioitinh().toLowerCase().contains(text.toLowerCase())
                    || (nv.getNgaysinh() + "").contains(text)) {
                result.add(nv);
            }
        }
        return result;
    }

    public ArrayList<NhanVienDTO> searchTenNv(String text) {
        ArrayList<NhanVienDTO> result = new ArrayList<>();
        ArrayList<NhanVienDTO> armt = NhanVienDAO.getInstance().selectAll();
        for (var nv : armt) {
            if (nv.getHoten().toLowerCase().contains(text.toLowerCase())) {
                result.add(nv);
            }
        }
        return result;
    }

    public ArrayList<NhanVienDTO> searchMaNv(String text) {
        ArrayList<NhanVienDTO> result = new ArrayList<>();
        ArrayList<NhanVienDTO> armt = NhanVienDAO.getInstance().selectAll();
        for (var nv : armt) {
            if (("" + nv.getManv()).toLowerCase().contains(text.toLowerCase())) {
                result.add(nv);
            }
        }
        return result;
    }

    public ArrayList<NhanVienDTO> searchSdt(String text) {
        ArrayList<NhanVienDTO> result = new ArrayList<>();
        ArrayList<NhanVienDTO> armt = NhanVienDAO.getInstance().selectAll();
        for (var nv : armt) {
            if (nv.getSdt().toLowerCase().contains(text.toLowerCase())) {
                result.add(nv);
            }
        }
        return result;
    }

    public ArrayList<NhanVienDTO> searchEmail(String text) {
        ArrayList<NhanVienDTO> result = new ArrayList<>();
        ArrayList<NhanVienDTO> armt = NhanVienDAO.getInstance().selectAll();
        for (var nv : armt) {
            if (nv.getEmail().toLowerCase().contains(text.toLowerCase())) {
                result.add(nv);
            }
        }
        return result;
    }

    public boolean isEmailExists(String email) {
        for (NhanVienDTO nv : this.listNv) {
            if (nv.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPhoneNumberExists(String phoneNumber) {
        for (NhanVienDTO nv : this.listNv) {
            if (nv.getSdt().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }
}
