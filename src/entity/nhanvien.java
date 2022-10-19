/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author Thinkpad T490
 */
public class nhanvien {
    String manv;
    String tennv;
    String matkhau;
    boolean vaitro;
    String diachi;
    String sodt;
    Date ngaysinh;
    String email;
    boolean gioitinh;
    boolean trangthai;

//    public nhanvien() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    public nhanvien() {
    }

    public String getManv() {
        return manv;
    }

    public nhanvien(String manv, String tennv, String matkhau, boolean vaitro, String diachi, String sodt, Date ngaysinh, String email, boolean gioitinh, boolean trangthai) {
        this.manv = manv;
        this.tennv = tennv;
        this.matkhau = matkhau;
        this.vaitro = vaitro;
        this.diachi = diachi;
        this.sodt = sodt;
        this.ngaysinh = ngaysinh;
        this.email = email;
        this.gioitinh = gioitinh;
        this.trangthai = trangthai;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public boolean getVaitro() {
        return vaitro;
    }

    public void setVaitro(boolean vaitro) {
        this.vaitro = vaitro;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSodt() {
        return sodt;
    }

    public void setSodt(String sodt) {
        this.sodt = sodt;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getGioitinh() {
        return gioitinh;
    }

    public boolean getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }
    
    
}
