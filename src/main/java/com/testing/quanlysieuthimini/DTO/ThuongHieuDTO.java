/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.testing.quanlysieuthimini.DTO;

/**
 *
 * @author Bao Phan
 */
public class ThuongHieuDTO {

    private int mathuonghieu;
    private String tenthuonghieu;
    private int trangthai;

    public ThuongHieuDTO() {
    }

    public ThuongHieuDTO(int mathuonghieu, String tenthuonghieu, int trangthai) {
        this.mathuonghieu = mathuonghieu;
        this.tenthuonghieu = tenthuonghieu;
        this.trangthai = trangthai;
    }

    public ThuongHieuDTO(int mathuonghieu, String tenthuonghieu) {
        this.mathuonghieu = mathuonghieu;
        this.tenthuonghieu = tenthuonghieu;
    }

    public int getMathuonghieu() {
        return mathuonghieu;
    }

    public void setMathuonghieu(int mathuonghieu) {
        this.mathuonghieu = mathuonghieu;
    }

    public String getTenthuonghieu() {
        return tenthuonghieu;
    }

    public void setTenthuonghieu(String tenthuonghieu) {
        this.tenthuonghieu = tenthuonghieu;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

}
