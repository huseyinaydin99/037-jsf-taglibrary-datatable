/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siteadi;

import java.util.Arrays;
import java.util.Comparator;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;

/**
 *
 * @author husey
 */
public class DataModelSiralamasi<T> extends DataModel<T>{

    /**
     * Creates a new instance of DataModelSiralamasi
     */
    DataModel<T> dataModel;
    private Integer[] satirlar;
    public DataModelSiralamasi(DataModel<T> dataModel) {
        this.dataModel = dataModel;
        satirlariAl();
        System.out.println("ÇALIŞTI");
    }
    
    public void satirlariAl(){
        int satirSayisi = dataModel.getRowCount();
        if(satirSayisi != -1){
            this.satirlar = new Integer[satirSayisi];
            for(int i = 0; i<satirSayisi; i++){
                satirlar[i] = i;
            }
        }
        System.out.println("satır sayısı : " + satirSayisi);
    }
    
    public void sirala(final Comparator<T> comparator){
        Comparator<Integer> satirKarsilastirmasi = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                T t1 = getData(o1);
                T t2 = getData(o2);
                
                System.out.println("Girdi.! ");
                return comparator.compare(t1, t2);
            }
        };
        Arrays.sort(satirlar,satirKarsilastirmasi);
    }
    
    private T getData(int satir){
        int orginalSatirIndexi = dataModel.getRowIndex();
        dataModel.setRowIndex(satir);
        
        T newRowData = dataModel.getRowData();
        dataModel.setRowIndex(orginalSatirIndexi);
        return newRowData;
    }
    
    @Override
    public void setRowIndex(int satirIndexi) {
        if(0 <= satirIndexi && satirIndexi <satirlar.length){
            dataModel.setRowIndex(satirlar[satirIndexi]);
        }
        else{
            dataModel.setRowIndex(satirIndexi);
        }
    }

    @Override
    public boolean isRowAvailable() {
        return dataModel.isRowAvailable();
    }

    @Override
    public int getRowCount() {
        return dataModel.getRowCount();
    }

    @Override
    public T getRowData() {
        return dataModel.getRowData();
    }

    @Override
    public int getRowIndex() {
        return dataModel.getRowIndex();
    }

    @Override
    public Object getWrappedData() {
        return dataModel.getWrappedData();
    }

    @Override
    public void setWrappedData(Object o) {
        dataModel.setWrappedData(o);
        satirlariAl();
    }

    public DataModel<T> getDataModel() {
        return dataModel;
    }

    public void setDataModel(DataModel<T> dataModel) {
        this.dataModel = dataModel;
    }

    public Integer[] getSatirlar() {
        return satirlar;
    }

    public void setSatirlar(Integer[] satirlar) {
        this.satirlar = satirlar;
    }
}
