/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.testing.quanlysieuthimini.DTO;

/**
 *
 * @author Bao Phan
 */
public class NhaCungCapDTO {

    private int mancc;
    private String tenncc;
    private String diachi;
    private String email;
    private String sdt;
    private int trangthai;

    public NhaCungCapDTO() {
    }

    public NhaCungCapDTO(int mancc, String tenncc, String diachi, String email, String sdt, int trangthai) {
        this.mancc = mancc;
        this.tenncc = tenncc;
        this.diachi = diachi;
        this.email = email;
        this.sdt = sdt;
        this.trangthai = trangthai;
    }

    public NhaCungCapDTO(int mancc,String tenncc, String diachi, String email, String sdt) {
        this.mancc = mancc;
        this.tenncc = tenncc;
        this.diachi = diachi;
        this.email = email;
        this.sdt = sdt;
    }

    public void setMancc(int mancc) {
        this.mancc = mancc;
    }

    public void setTenncc(String tenncc) {
        this.tenncc = tenncc;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getMancc() {
        return mancc;
    }

    public String getTenncc() {
        return tenncc;
    }

    public String getDiachi() {
        return diachi;
    }

    public String getEmail() {
        return email;
    }

    public String getSdt() {
        return sdt;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

}
