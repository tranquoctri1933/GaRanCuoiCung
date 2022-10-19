/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Thinkpad T490
 */
public class khachhang {
    String Idkh;
    String Hoten;
    String Diachi;
    String Sdt;
    String Email;
    boolean Gioitinh;
    String Mota;

    public khachhang(String Idkh, String Hoten, String Diachi, String Sdt, String Email, boolean Gioitinh, String Mota) {
        this.Idkh = Idkh;
        this.Hoten = Hoten;
        this.Diachi = Diachi;
        this.Sdt = Sdt;
        this.Email = Email;
        this.Gioitinh = Gioitinh;
        this.Mota = Mota;
    }
    public khachhang(){
        
    }
    public String getIdkh() {
        return Idkh;
    }

    public void setIdkh(String Idkh) {
        this.Idkh = Idkh;
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public boolean isGioitinh() {
        return Gioitinh;
    }

    public void setGioitinh(boolean Gioitinh) {
        this.Gioitinh = Gioitinh;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String Mota) {
        this.Mota = Mota;
    }


    
    
}
