/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.testing.quanlysieuthimini.DTO;

import java.util.Objects;


public class ChucNangDTO {
    private int machucnang;
    private String tenchucnang;

    public ChucNangDTO() {
    }

    public ChucNangDTO(int machucnang, String tenchucnang) {
        this.machucnang = machucnang;
        this.tenchucnang = tenchucnang;
    }

    public int getMachucnang() {
        return machucnang;
    }

    public void setMachucnang(int machucnang) {
        this.machucnang = machucnang;
    }

    public String getTenchucnang() {
        return tenchucnang;
    }

    public void setTenchucnang(String tenchucnang) {
        this.tenchucnang = tenchucnang;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.machucnang;
        hash = 29 * hash + Objects.hashCode(this.tenchucnang);
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
        final ChucNangDTO other = (ChucNangDTO) obj;
        if (this.machucnang != other.machucnang) {
            return false;
        }
        return Objects.equals(this.tenchucnang, other.tenchucnang);
    }

    @Override
    public String toString() {
        return "ChucNangDTO{" + "machucnang=" + machucnang + ", tenchucnang=" + tenchucnang + '}';
    }

 
}
