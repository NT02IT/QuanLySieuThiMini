package com.testing.quanlysieuthimini.DTO;

public class ChiTietPhieuNhapDTO {
    private int maphieunhap;
    private int masp;
    private int makhuvukho;
    private String tensp;
    private int soluong;
    private double dongia;

    public ChiTietPhieuNhapDTO() {
    }

    public ChiTietPhieuNhapDTO(int maphieunhap, int masp, int makhuvukho, String tensp, int soluong, double dongia) {
        this.maphieunhap = maphieunhap;
        this.masp = masp;
        this.makhuvukho = makhuvukho;
        this.tensp = tensp;
        this.soluong = soluong;
        this.dongia = dongia;
    }
    
    public ChiTietPhieuNhapDTO(int maphieunhap, int masp, int soluong, double dongia) {
        this.maphieunhap = maphieunhap;
        this.masp = masp;
        this.soluong = soluong;
        this.dongia = dongia;
    }
    
    public ChiTietPhieuNhapDTO(int masp, String tensp, int soluong, double dongia) {
        this.masp = masp;
        this.tensp = tensp;
        this.soluong = soluong;
        this.dongia = dongia;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getMaphieunhap() {
        return maphieunhap;
    }

    public int getMakhuvukho() {
        return makhuvukho;
    }

    public void setMakhuvukho(int makhuvukho) {
        this.makhuvukho = makhuvukho;
    }

    public void setMaphieunhap(int maphieunhap) {
        this.maphieunhap = maphieunhap;
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

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }
}