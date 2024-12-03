package com.testing.quanlysieuthimini.BUS;

import com.testing.quanlysieuthimini.DAO.ChiTietQuyenDAO;
import com.testing.quanlysieuthimini.DAO.NhomQuyenDAO;
import com.testing.quanlysieuthimini.DTO.ChiTietQuyenDTO;
import com.testing.quanlysieuthimini.DTO.NhomQuyenDTO;
import java.util.ArrayList;

public class NhomQuyenBUS {
    private NhomQuyenDAO qDAO;
    private ChiTietQuyenDAO ctqDAO = new ChiTietQuyenDAO();
    private ArrayList<NhomQuyenDTO> quyenList = new ArrayList<>();
    
    public NhomQuyenBUS() {
        qDAO = new NhomQuyenDAO();
    }
    
    public void loadData() {
        quyenList = qDAO.selectAll();
    }
    
    public ArrayList<NhomQuyenDTO> getArrNhomQuyen() {
        loadData();
        return quyenList;
    }
    
    public NhomQuyenDTO getByIndex(int index) {
        return this.quyenList.get(index);
    }
    
    public NhomQuyenDTO getObjectById(int id) {
        for(NhomQuyenDTO i : quyenList) {
            if(i.getManhomquyen() == id)
                return i;
        }
        return null;
    }
    
    public int getIndexById(int id) {
        for(int i=0; i<quyenList.size(); i++) {
            if(quyenList.get(i).getManhomquyen() == id)
                return i;
        }
        return -1;
    }
    
    public String getNameById(int id) {
        return quyenList.get(getIndexById(id)).getTennhomquyen();
    }
    
    public String[] getStringList() {
        String[] result = new String[quyenList.size()];
        for(int i=0; i<quyenList.size(); i++) {
            result[i] = quyenList.get(i).getTennhomquyen();
        }
        return result;
    }
    
    
    public ArrayList<ChiTietQuyenDTO> getChiTietQuyen(String manhomquyen) {
        return ctqDAO.selectAll(manhomquyen);
    }
    
    public boolean checkChucNang(ArrayList<ChiTietQuyenDTO> ctqList,int idCN) {
        for(ChiTietQuyenDTO i : ctqList)
            if(i.getMachucnang() == idCN)
                return true;
        return false;
    }
    
    public boolean checkQuyen(ArrayList<ChiTietQuyenDTO> ctqList, int idCN, String hanhDong) {
        for(ChiTietQuyenDTO i : ctqList)
            if(i.getMachucnang() == idCN)
                if(i.getHanhdong().equals(hanhDong))
                    return true;
        return false;
    }
    

    
 
    public boolean add(NhomQuyenDTO t, ArrayList<ChiTietQuyenDTO> ctqList) {
    if(qDAO.insert(t) != 0) {
        ctqDAO.insert(ctqList);
        quyenList.add(t);
        return true;
    }
    return false;
}

public boolean update(NhomQuyenDTO t, ArrayList<ChiTietQuyenDTO> ctqList) {
    if(qDAO.update(t) != 0) {
        String quyenId = Integer.toString(t.getManhomquyen());
        ctqDAO.update(ctqList, quyenId);
        quyenList.set(getIndexById(t.getManhomquyen()), t);
        return true;
    }
    return false;
}
public boolean delete(NhomQuyenDTO t) {
    String quyenId = Integer.toString(t.getManhomquyen());
    if(ctqDAO.delete(quyenId) >= 0) {
        qDAO.delete(quyenId);
        quyenList.remove(t);
        return true;
    }
    return false;
}   
    
    
    public ArrayList<NhomQuyenDTO> search(String text, String type){
        ArrayList<NhomQuyenDTO> result = new ArrayList<>();
        text = text.toLowerCase();
        switch (type) {
            case "Tất cả":
                for(NhomQuyenDTO i : quyenList){
                    if(Integer.toString(i.getManhomquyen()).toLowerCase().contains(text) || i.getTennhomquyen().toLowerCase().contains(text))
                        result.add(i);
                }
                break;
            case "Mã":
                for(NhomQuyenDTO i : quyenList){
                    if(Integer.toString(i.getManhomquyen()).toLowerCase().contains(text))
                        result.add(i);
                }
                break;
            case "Tên quyền":
                for(NhomQuyenDTO i : quyenList){
                    if(i.getTennhomquyen().toLowerCase().contains(text))
                        result.add(i);
                }
                break;
            default:
                throw new AssertionError();
        }
        return result;
    }
    
}
