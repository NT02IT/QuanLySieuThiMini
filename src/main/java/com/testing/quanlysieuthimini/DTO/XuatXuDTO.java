/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Bao Phan
 */
package com.testing.quanlysieuthimini.DTO;

public class XuatXuDTO {

    private int maxuatxu;
    private String tenxuatxu;
    private int trangthai;

    public XuatXuDTO() {
    }

    public XuatXuDTO(int maxuatxu, String tenxuatxu) {
        this.maxuatxu = maxuatxu;
        this.tenxuatxu = tenxuatxu;
    }

    public XuatXuDTO(int maxuatxu, String tenxuatxu, int trangthai) {
        this.maxuatxu = maxuatxu;
        this.tenxuatxu = tenxuatxu;
        this.trangthai = trangthai;
    }

    public int getMaxuatxu() {
        return maxuatxu;
    }

    public void setMaxuatxu(int maxuatxu) {
        this.maxuatxu = maxuatxu;
    }

    public String getTenxuatxu() {
        return tenxuatxu;
    }

    public void setTenxuatxu(String tenxuatxu) {
        this.tenxuatxu = tenxuatxu;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

}
