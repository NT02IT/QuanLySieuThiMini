package com.testing.quanlysieuthimini.DTO;

import java.sql.Date;

/**
 *
 * @author NeON
 */
public class PhieuNhapDTO {
    private int maphieunhap;
    private int mancc;
//    private int makhuvuc;
    private int manv;
    private Date thoigian;
    private long tongtien;
    private String tenncc;
    private String tennvnhap;
    
    private int masp;
    private String tensp;
    private String tenkhuvuc;
    private int soluong;
    private long dongia;
            
    
    public PhieuNhapDTO() {}

    public PhieuNhapDTO(int maphieunhap, int mancc, int manv, Date thoigian, long tongtien, String tenncc, String tennvnhap, int masp, String tensp, String tenkhuvuc, int soluong, long dongia) {
        this.maphieunhap = maphieunhap;
        this.mancc = mancc;
        this.manv = manv;
        this.thoigian = thoigian;
        this.tongtien = tongtien;
        this.tenncc = tenncc;
        this.tennvnhap = tennvnhap;
        this.masp = masp;
        this.tensp = tensp;
        this.tenkhuvuc = tenkhuvuc;
        this.soluong = soluong;
        this.dongia = dongia;
    }
    
    public PhieuNhapDTO(int maphieunhap, int mancc, int makhuvuc, int manv, Date thoigian, long tongtien) {
        this.maphieunhap = maphieunhap;
        this.mancc = mancc;
//        this.makhuvuc = makhuvuc;
        this.manv = manv;
        this.thoigian = thoigian;
        this.tongtien = tongtien;
    }
    
    public PhieuNhapDTO(int maphieunhap, String tenncc, String tennvnhap, Date thoigian, long tongtien) {
        this.maphieunhap = maphieunhap;
        this.tenncc = tenncc;
        this.tennvnhap = tennvnhap;
        this.thoigian = thoigian;
        this.tongtien = tongtien;
    }

    public PhieuNhapDTO(int maphieunhap, int masp, int soluong, long dongia) {
        this.maphieunhap = maphieunhap;
        this.masp = masp;
        this.soluong = soluong;
        this.dongia = dongia;
    }
    
    // Bảng chi tiết sản phẩm nhập
    public PhieuNhapDTO(int maphieunhap, int masp, String tensp, int soluong, long dongia, String tenkhuvuc) {
        this.maphieunhap = maphieunhap;
        this.masp = masp;
        this.tensp = tensp;
        this.tensp = tensp;
        this.soluong = soluong;
        this.dongia = dongia;
        this.tenkhuvuc = tenkhuvuc;
    }

    public PhieuNhapDTO(int maphieunhap, int mancc, int manv, Date thoigian, long tongtien) {
        this.maphieunhap = maphieunhap;
        this.mancc = mancc;
        this.manv = manv;
        this.thoigian = thoigian;
        this.tongtien = tongtien;
    }
    
    

    public int getMaphieunhap() {
        return maphieunhap;
    }

    public void setMaphieunhap(int maphieunhap) {
        this.maphieunhap = maphieunhap;
    }

    public int getMancc() {
        return mancc;
    }

    public void setMancc(int mancc) {
        this.mancc = mancc;
    }


    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public Date getThoigian() {
        return thoigian;
    }

    public void setThoigian(Date thoigian) {
        this.thoigian = thoigian;
    }

    public long getTongtien() {
        return tongtien;
    }

    public void setTongtien(long tongtien) {
        this.tongtien = tongtien;
    }

    public String getTenncc() {
        return tenncc;
    }

    public void setTenncc(String tenncc) {
        this.tenncc = tenncc;
    }

    public String getTennvnhap() {
        return tennvnhap;
    }

    public void setTennvnhap(String tennvnhap) {
        this.tennvnhap = tennvnhap;
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public long getDongia() {
        return dongia;
    }

    public void setDongia(long dongia) {
        this.dongia = dongia;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getTenkhuvuc() {
        return tenkhuvuc;
    }

    public void setTenkhuvuc(String tenkhuvuc) {
        this.tenkhuvuc = tenkhuvuc;
    }
    
    
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + maphieunhap;
        result = prime * result + mancc;
        result = prime * result + manv;
        result = prime * result + ((thoigian == null) ? 0 : thoigian.hashCode());
        result = prime * result + (int) (tongtien ^ (tongtien >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PhieuNhapDTO other = (PhieuNhapDTO) obj;
        if (maphieunhap != other.maphieunhap)
            return false;
        if (mancc != other.mancc)
            return false;
        if (manv != other.manv)
            return false;
        if (thoigian == null) {
            if (other.thoigian != null)
                return false;
        } else if (!thoigian.equals(other.thoigian))
            return false;
        if (tongtien != other.tongtien)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PhieuNhapDTO{" + "maphieunhap=" + maphieunhap + ", mancc=" + mancc + ", manv="
                + manv + ", thoigian=" + thoigian + ", tongtien=" + tongtien + "}";
    }
}
