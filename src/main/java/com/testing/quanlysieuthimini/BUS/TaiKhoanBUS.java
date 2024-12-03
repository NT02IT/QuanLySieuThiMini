package com.testing.quanlysieuthimini.BUS;

import com.testing.quanlysieuthimini.DAO.NhomQuyenDAO;
import com.testing.quanlysieuthimini.DAO.TaiKhoanDAO;
import com.testing.quanlysieuthimini.DTO.NhomQuyenDTO;
import com.testing.quanlysieuthimini.DTO.TaiKhoanDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/TaiKhoanBUS")
public class TaiKhoanBUS {

    private final ArrayList<TaiKhoanDTO> listTaiKhoan;
    public final TaiKhoanDAO tkDAO = new TaiKhoanDAO();
    private final ArrayList<NhomQuyenDTO> listNhomQuyen;
    private final NhomQuyenDAO nhomQuyenDAO = NhomQuyenDAO.getInstance();

    public TaiKhoanBUS() {
        this.listTaiKhoan = TaiKhoanDAO.getInstance().selectAll();
        this.listNhomQuyen = NhomQuyenDAO.getInstance().selectAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getNhomQuyenDTO/{manhom}")
    public NhomQuyenDTO getNhomQuyenDTO(@PathVariable int manhom) {
        return nhomQuyenDAO.selectById(manhom + "");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getTaiKhoanAll")
    public ArrayList<TaiKhoanDTO> getTaiKhoanAll() {
        return listTaiKhoan;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getTaiKhoan")
    public TaiKhoanDTO getTaiKhoan(@RequestParam int index) {
        return listTaiKhoan.get(index);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getMaNVbyUsername")
    public int getMaNVbyUsername(@RequestParam String username) {
        int i = 0;
        for (TaiKhoanDTO tk : this.listTaiKhoan) {
            if (tk.getUsername().equals(username)) {
                return i = tk.getAccountId();
            }
        }
        return i;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/isUsernameExists")
    public Boolean isUsernameExists(@RequestParam String username) {
        for (TaiKhoanDTO tk : this.listTaiKhoan) {
            if (tk.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public Boolean add(@RequestBody TaiKhoanDTO tk) {
        boolean check = tkDAO.insert(tk) != 0;
        if (check) {
            this.listTaiKhoan.add(tk);
        }
        return check;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public Boolean delete(@RequestBody TaiKhoanDTO tk) {
        boolean check = tkDAO.delete(tk.getAccountId()) != 0;
        if (check) {
            this.listTaiKhoan.remove(tk);
        }
        return check;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/findAccountByAccountId/{accountId}")
    public int findAccountByAccountId(@PathVariable int accountId) {
        for (int i = 0; i < this.listTaiKhoan.size(); i++) {
            if (listTaiKhoan.get(i).getAccountId() == accountId) {
                return i;
            }
        }
        return -1;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public Boolean update(@RequestBody TaiKhoanDTO tk) {
        boolean check = tkDAO.update(tk) != 0;
        if (check) {
            this.listTaiKhoan.set(findAccountByAccountId(tk.getAccountId()), tk);
        }
        return check;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search/{type}")
    public ArrayList<TaiKhoanDTO> search(@RequestParam String txt,@PathVariable String type) {
        ArrayList<TaiKhoanDTO> result = new ArrayList<>();
        txt = txt.toLowerCase();
        switch (type) {
            case "Tất cả" -> {
                for (TaiKhoanDTO i : listTaiKhoan) {
                    if (Integer.toString(i.getAccountId()).contains(txt) || i.getUsername().contains(txt)) {
                        result.add(i);
                    }
                }
            }
            case "Mã nhân viên" -> {
                for (TaiKhoanDTO i : listTaiKhoan) {
                    if (Integer.toString(i.getAccountId()).contains(txt)) {
                        result.add(i);
                    }
                }
            }
            case "Username" -> {
                for (TaiKhoanDTO i : listTaiKhoan) {
                    if (i.getUsername().toLowerCase().contains(txt)) {
                        result.add(i);
                    }
                }
            }
        }
        return result;
    }

}
