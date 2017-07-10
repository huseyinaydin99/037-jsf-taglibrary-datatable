/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siteadi;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Comparator;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ArrayDataModel;

/**
 *
 * @author husey
 */
@ManagedBean
@SessionScoped
public class YonetimliBean implements Serializable {

    /**
     * Creates a new instance of YonetimliBean
     */

    private DataModelSiralamasi<Personel> dataModelSiralamasi;
    private final static Personel[] personels = {
        new Personel("1993", "Hüseyin Aydın", new BigDecimal(5000), 50),
        new Personel("1994", "Eren Ertaş", new BigDecimal(3000), 45),
        new Personel("1995", "Tatar Ramazan", new BigDecimal(1500), 35),
        new Personel("1996", "Abdullah At", new BigDecimal(2300), 35)
    };
    
    
    public YonetimliBean() {
        dataModelSiralamasi = new DataModelSiralamasi<Personel>(new ArrayDataModel<Personel>(personels));
        System.out.println("hazırlayıcı çalıştı");
    }

    public DataModelSiralamasi<Personel> getDataModelSiralamasi() {
        return dataModelSiralamasi;
    }

    public void setDataModelSiralamasi(DataModelSiralamasi<Personel> dataModelSiralamasi) {
        this.dataModelSiralamasi = dataModelSiralamasi;
    }

    public boolean isArtanSiralama() {
        return artanSiralama;
    }

    public void setArtanSiralama(boolean artanSiralama) {
        this.artanSiralama = artanSiralama;
    }

    public String kayitDuzenle(Personel personel) {
        personel.setDuzenle(true);
        return null;
    }

    public String degisikligiKaydet() {
        for (Personel personel : personels) {
            personel.setDuzenle(false);
        }
        return null;
    }

    private boolean artanSiralama = true;

    public String siralamaPersonelAdiSoyadi() {
        if (artanSiralama) {
            dataModelSiralamasi.sirala(new Comparator<Personel>() {
                @Override
                public int compare(Personel o1, Personel o2) {
                    return o1.getAdiSoyadi().compareTo(o2.getAdiSoyadi());
                }
            });
            artanSiralama = false;
        } else {
            dataModelSiralamasi.sirala(new Comparator<Personel>() {
                @Override
                public int compare(Personel o1, Personel o2) {
                    return o2.getAdiSoyadi().compareTo(o1.getAdiSoyadi());
                }
            });
            artanSiralama = true;
        }
        return null;
    }

    public String siralamaPersonelMaasi() {
        if (artanSiralama) {
            dataModelSiralamasi.sirala(new Comparator<Personel>() {
                @Override
                public int compare(Personel o1, Personel o2) {
                    return o1.getMaasi().compareTo(o2.getMaasi());
                }
            });
            artanSiralama = false;
        } else {
            dataModelSiralamasi.sirala(new Comparator<Personel>() {
                @Override
                public int compare(Personel o1, Personel o2) {
                    return o2.getMaasi().compareTo(o1.getMaasi());
                }
            });
            artanSiralama = true;
        }
        return null;
    }

    public Personel[] getPersonels() {
        return personels;
    }

}
