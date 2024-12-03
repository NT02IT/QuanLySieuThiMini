/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.testing.quanlysieuthimini.DTO;

public class NhomQuyenDTO {
    private int manhomquyen;
    private String tennhomquyen;
    private  int trangthai;



    public NhomQuyenDTO() {
    }

    public NhomQuyenDTO(int manhomquyen, String tennhomquyen, int trangthai) {
        this.manhomquyen = manhomquyen;
        this.tennhomquyen = tennhomquyen;
        this.trangthai = trangthai;
    }

    
    public int getManhomquyen() {
        return manhomquyen;
    }

    public void setManhomquyen(int manhomquyen) {
        this.manhomquyen = manhomquyen;
    }

  


    public String getTennhomquyen() {
        return tennhomquyen;
    }

    public void setTennhomquyen(String tennhomquyen) {
        this.tennhomquyen = tennhomquyen;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    @Override
    public String toString() {
        return "NhomQuyenDTO{" + "manhomquyen=" + manhomquyen + ", tennhomquyen=" + tennhomquyen + ", trangthai=" + trangthai + '}';
    }
    

   
  

}
