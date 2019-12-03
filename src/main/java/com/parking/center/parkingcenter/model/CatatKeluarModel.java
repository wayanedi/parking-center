/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parking.center.parkingcenter.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author yanedi
 */
public class CatatKeluarModel {
    
    private int hargaperjam;
    private int hargaSetHari;
    private int hargaPerhari;
    private String waktuMasuk;
    private String waktuKeluar;
    private String jenisKendaraan;
    private int totalHarga;
    private String plat;
    
   
    
    /**
     *
     * @param waktuMasuk
     * @param hargaperjam
     * @param hargaSetHari
     * @param hargaPerhari
     */
    public CatatKeluarModel(String waktuMasuk, int hargaperjam, int hargaSetHari, int hargaPerhari, String jenisKendaraan){
        
        this.waktuMasuk = waktuMasuk;
        this.hargaperjam = hargaperjam;
        this.hargaSetHari = hargaSetHari;
        this.hargaPerhari = hargaPerhari;
        this.jenisKendaraan = jenisKendaraan;
        
    }
    
    
    public CatatKeluarModel(String waktuKeluar, int totalHarga, String plat){
        
        this.totalHarga = totalHarga;
        this.waktuKeluar = waktuKeluar;
        this.plat = plat;
    }

    /**
     * @return the hargaperjam
     */
    public int getHargaperjam() {
        return hargaperjam;
    }

    /**
     * @param hargaperjam the hargaperjam to set
     */
    public void setHargaperjam(int hargaperjam) {
        this.hargaperjam = hargaperjam;
    }

    /**
     * @return the hargaSetHari
     */
    public int getHargaSetHari() {
        return hargaSetHari;
    }

    /**
     * @param hargaSetHari the hargaSetHari to set
     */
    public void setHargaSetHari(int hargaSetHari) {
        this.hargaSetHari = hargaSetHari;
    }

    /**
     * @return the hargaPerhari
     */
    public int getHargaPerhari() {
        return hargaPerhari;
    }

    /**
     * @param hargaPerhari the hargaPerhari to set
     */
    public void setHargaPerhari(int hargaPerhari) {
        this.hargaPerhari = hargaPerhari;
    }

    /**
     * @return the waktuMasuk
     */
    public String getWaktuMasuk() {
        return waktuMasuk;
    }

    /**
     * @param waktuMasuk the waktuMasuk to set
     */
    public void setWaktuMasuk(String waktuMasuk) {
        this.waktuMasuk = waktuMasuk;
    }

    /**
     * @return the totalHarga
     */
    public int getTotalHarga() {
        return totalHarga;
    }

    /**
     * @param totalHarga the totalHarga to set
     */
    public void setTotalHarga(int totalHarga) {
        this.totalHarga = totalHarga;
    }

    /**
     * @return the waktuKeluar
     */
    public String getWaktuKeluar() {
        return waktuKeluar;
    }

    /**
     * @param waktuKeluar the waktuKeluar to set
     */
    public void setWaktuKeluar(String waktuKeluar) {
        this.waktuKeluar = waktuKeluar;
    }

    /**
     * @return the jenisKendaraan
     */
    public String getJenisKendaraan() {
        return jenisKendaraan;
    }

    /**
     * @param jenisKendaraan the jenisKendaraan to set
     */
    public void setJenisKendaraan(String jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
    }

    /**
     * @return the plat
     */
    public String getPlat() {
        return plat;
    }

    /**
     * @param plat the plat to set
     */
    public void setPlat(String plat) {
        this.plat = plat;
    }
    
    
    
    
    
}
