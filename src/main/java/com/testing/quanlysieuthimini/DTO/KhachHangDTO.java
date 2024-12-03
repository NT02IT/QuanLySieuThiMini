/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.testing.quanlysieuthimini.DTO;

import java.util.Date;

public class KhachHangDTO {

    private int makh;
    private String hoten;
    private String sdt;
    private String diachi;
    private String gioitinh;
    private Date ngaythamgia;
    private int trangthai;

    public KhachHangDTO() {
    }

    public KhachHangDTO(int makh, String hoten, String diachi, String gioitinh, String sdt, int trangthai) {
        this.makh = makh;
        this.hoten = hoten;
        this.sdt = sdt;
        this.diachi = diachi;
        this.gioitinh = gioitinh;
    }

    public KhachHangDTO(int makh, String hoten, String diachi, String gioitinh, String sdt, Date ngaythamgia, int trangthai) {
        this.makh = makh;
        this.hoten = hoten;
        this.sdt = sdt;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.ngaythamgia = ngaythamgia;
        this.trangthai = trangthai;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public Date getNgaythamgia() {
        return ngaythamgia;
    }

    public void setNgaythamgia(Date ngaythamgia) {
        this.ngaythamgia = ngaythamgia;
    }

    public int getMaKH() {
        return makh;
    }

    public void setMaKH(int makh) {
        this.makh = makh;
    }
    
    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
    
    
}
