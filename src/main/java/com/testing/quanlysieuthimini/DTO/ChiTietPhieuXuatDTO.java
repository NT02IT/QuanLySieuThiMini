package com.testing.quanlysieuthimini.DTO;

public class ChiTietPhieuXuatDTO {

    private int maphieuxuat;
    private int masp;
    private int soluong;
    private double dongia;

    public ChiTietPhieuXuatDTO() {
    }

    public ChiTietPhieuXuatDTO(int maphieuxuat, int masp, int soluong, double dongia) {
        this.maphieuxuat = maphieuxuat;
        this.masp = masp;
        this.soluong = soluong;
        this.dongia = dongia;
    }

    public int getMaphieuxuat() {
        return maphieuxuat;
    }

    public void setMaphieuxuat(int maphieuxuat) {
        this.maphieuxuat = maphieuxuat;
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
