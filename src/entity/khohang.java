/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author asus
 */
public class khohang {
    String malh;
    String tenlh;
    int soluongton;
    
    @Override
    public String toString() {
        return this.tenlh;
    }

    public String getMalh() {
        return malh;
    }

    public void setMalh(String malh) {
        this.malh = malh;
    }

    public String getTenlh() {
        return tenlh;
    }

    public void setTenlh(String tenlh) {
        this.tenlh = tenlh;
    }

    public int getSoluongton() {
        return soluongton;
    }

    public void setSoluongton(int soluongton) {
        this.soluongton = soluongton;
    }
    
    
}
