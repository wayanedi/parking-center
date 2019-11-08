/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parking.center.parkingcenter.model;

import java.util.Date;

/**
 *
 * @author yanedi
 */
public class LaporanModel {
    
    private String platNomor;
    private String jenisKendaraan;
    private Date waktuMasuk;
    private int totalHarga;
    private int statusKendaraan;
    
    /**
     * @return the platNomor
     */
    public String getPlatNomor() {
        return platNomor;
    }

    /**
     * @param platNomor the platNomor to set
     */
    public void setPlatNomor(String platNomor) {
        this.platNomor = platNomor;
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
     * @return the waktuMasuk
     */
    public Date getWaktuMasuk() {
        return waktuMasuk;
    }

    /**
     * @param waktuMasuk the waktuMasuk to set
     */
    public void setWaktuMasuk(Date waktuMasuk) {
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
     * @return the statusKendaraan
     */
    public int getStatusKendaraan() {
        return statusKendaraan;
    }

    /**
     * @param statusKendaraan the statusKendaraan to set
     */
    public void setStatusKendaraan(int statusKendaraan) {
        this.statusKendaraan = statusKendaraan;
    }
    
    
    
}
