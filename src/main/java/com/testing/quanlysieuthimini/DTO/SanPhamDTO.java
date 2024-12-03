/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.testing.quanlysieuthimini.DTO;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Bao Phan
 */
public class SanPhamDTO {

    private int masp;
    private LoaiSanPhamDTO loaisp = new LoaiSanPhamDTO();
    private int maloai;
    private String tensp;
    private String hinhanh;
    private XuatXuDTO xuatxu = new XuatXuDTO();
    private int maxuatxu;
    private Date NSX;
    private Date HSD;
    private ThuongHieuDTO thuonghieu = new ThuongHieuDTO();
    private int mathuonghieu;
    private double gianhap;
    private double giaban;
    private int soluongton;
    private int trangthai;

    public SanPhamDTO() {

    }

    public SanPhamDTO(int masp, double gianhap, double giaban) {
        this.masp = masp;
        this.gianhap = gianhap;
        this.giaban = giaban;
    }

    public SanPhamDTO(int masp, int maloai, String tensp, String hinhanh, Date NSX, Date HSD, int maxuatxu, int mathuonghieu, int soluongton, double gianhap, double giaban, int trangthai) {
        this.masp = masp;
        this.maloai = maloai;
        this.tensp = tensp;
        this.hinhanh = hinhanh;
        this.NSX = NSX;
        this.HSD = HSD;
        this.mathuonghieu = mathuonghieu;
        this.maxuatxu = maxuatxu;
        this.gianhap = gianhap;
        this.giaban = giaban;
        this.soluongton = soluongton;
        this.trangthai = trangthai;

    }

    public SanPhamDTO(int masp, int maloai, String tensp, String hinhanh, Date NSX, Date HSD, int maxuatxu, int mathuonghieu, int soluongton, double gianhap, int trangthai) {
        this.masp = masp;
        this.maloai = maloai;
        this.tensp = tensp;
        this.hinhanh = hinhanh;
        this.NSX = NSX;
        this.HSD = HSD;
        this.mathuonghieu = mathuonghieu;
        this.maxuatxu = maxuatxu;
        this.gianhap = gianhap;
        this.soluongton = soluongton;
        this.trangthai = trangthai;

    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public LoaiSanPhamDTO getLoaisp() {
        return loaisp;
    }

    public void setLoaisp(LoaiSanPhamDTO loaisp) {
        this.loaisp = loaisp;
    }

    public int getMaloai() {
        return maloai;
    }

    public void setMaloai(int maloai) {
        this.maloai = maloai;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public XuatXuDTO getXuatxu() {
        return xuatxu;
    }

    public void setXuatxu(XuatXuDTO xuatxu) {
        this.xuatxu = xuatxu;
    }

    public int getMaxuatxu() {
        return maxuatxu;
    }

    public void setMaxuatxu(int maxuatxu) {
        this.maxuatxu = maxuatxu;
    }

    public Date getNSX() {
        return NSX;
    }

    public void setNSX(Date NSX) {
        this.NSX = NSX;
    }

    public Date getHSD() {
        return HSD;
    }

    public void setHSD(Date HSD) {
        this.HSD = HSD;
    }

    public ThuongHieuDTO getThuonghieu() {
        return thuonghieu;
    }

    public void setThuonghieu(ThuongHieuDTO thuonghieu) {
        this.thuonghieu = thuonghieu;
    }

    public int getMathuonghieu() {
        return mathuonghieu;
    }

    public void setMathuonghieu(int mathuonghieu) {
        this.mathuonghieu = mathuonghieu;
    }

    public double getGianhap() {
        return gianhap;
    }

    public void setGianhap(double gianhap) {
        this.gianhap = gianhap;
    }

    public double getGiaban() {
        return giaban;
    }

    public void setGiaban(double giaban) {
        this.giaban = giaban;
    }

    public int getSoluongton() {
        return soluongton;
    }

    public void setSoluongton(int soluongton) {
        this.soluongton = soluongton;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.masp);
        hash = 79 * hash + Objects.hashCode(this.loaisp);
        hash = 79 * hash + Objects.hashCode(this.tensp);
        hash = 79 * hash + Objects.hashCode(this.hinhanh);
        hash = 79 * hash + Objects.hashCode(this.xuatxu);
        hash = 79 * hash + Objects.hashCode(this.NSX);
        hash = 79 * hash + Objects.hashCode(this.HSD);
        hash = 79 * hash + Objects.hashCode(this.thuonghieu);
        hash = 79 * hash + Objects.hashCode(this.soluongton);

        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SanPhamDTO other = (SanPhamDTO) obj;
        return true;
    }

    @Override
    public String toString() {
        return "SanPham{" + "masp=" + masp + ", maloai=" + loaisp + ", tensp="
                + tensp + ", hinhanh=" + hinhanh + "xuatxu=" + xuatxu + "NSX=" + NSX + "gianhap=" + gianhap + "giaban=" + giaban + "thuonghieu=" + thuonghieu + "soluongton=" + soluongton + '}';
    }

}
