/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.testing.quanlysieuthimini.DTO;

/**
 *
 * @author Bao Phan
 */
public class LoaiSanPhamDTO {

    private int maloai;
    private String tenloai;
    private int trangthai;

    public LoaiSanPhamDTO() {
    }

    public LoaiSanPhamDTO(int maloai, String tenloai, int trangthai) {
        this.maloai = maloai;
        this.tenloai = tenloai;
        this.trangthai = trangthai;
    }

    public LoaiSanPhamDTO(int maloai, String tenloai) {
        this.maloai = maloai;
        this.tenloai = tenloai;
    }

    public void setMaloai(int maloai) {
        this.maloai = maloai;
    }

    public String getTenloai() {
        return tenloai;
    }

    public void setTenloai(String tenloai) {
        this.tenloai = tenloai;
    }

    public int getMaloai() {
        return maloai;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

}
