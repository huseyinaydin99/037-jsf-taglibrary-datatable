/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siteadi;

import java.math.BigDecimal;

/**
 *
 * @author husey
 */
public class Personel {
   private String numarasi,adiSoyadi;
   private BigDecimal maasi;
   private int yasi;
   private boolean duzenle;

    public Personel(String numarasi, String adiSoyadi, BigDecimal maasi, int yasi) {
        this.numarasi = numarasi;
        this.adiSoyadi = adiSoyadi;
        this.maasi = maasi;
        this.yasi = yasi;
    }

    public String getNumarasi() {
        return numarasi;
    }

    public void setNumarasi(String numarasi) {
        this.numarasi = numarasi;
    }

    public String getAdiSoyadi() {
        return adiSoyadi;
    }

    public void setAdiSoyadi(String adiSoyadi) {
        this.adiSoyadi = adiSoyadi;
    }

    public BigDecimal getMaasi() {
        return maasi;
    }

    public void setMaasi(BigDecimal maasi) {
        this.maasi = maasi;
    }

    public int getYasi() {
        return yasi;
    }

    public void setYasi(int yasi) {
        this.yasi = yasi;
    }

    public boolean isDuzenle() {
        return duzenle;
    }

    public void setDuzenle(boolean duzenle) {
        this.duzenle = duzenle;
    }
   
    
   
}
