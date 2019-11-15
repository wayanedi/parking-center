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
    private String namaKendaraan;
    private String namaPetugas;
    private String jenisKendaraan;
    private String waktuMasuk;
    private String waktuKeluar;
    private int totalHarga;
    private int statusKendaraan;
    
    
    public LaporanModel(){}
    
    
    public LaporanModel(String namaKendaraan, String platNomor, String namaPetugas, String jenisKendaraan, String waktuMasuk, String waktuKeluar, int totalHarga){
        this.namaKendaraan = namaKendaraan;
        this.platNomor = platNomor;
        this.namaPetugas = namaPetugas;
        this.jenisKendaraan = jenisKendaraan;
        this.waktuMasuk = waktuMasuk;
        this.waktuKeluar = waktuKeluar;
        this.totalHarga = totalHarga;
        
    }
    
    
    
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

    /**
     * @return the namaKendaraan
     */
    public String getNamaKendaraan() {
        return namaKendaraan;
    }

    /**
     * @param namaKendaraan the namaKendaraan to set
     */
    public void setNamaKendaraan(String namaKendaraan) {
        this.namaKendaraan = namaKendaraan;
    }

    /**
     * @return the namaPetugas
     */
    public String getNamaPetugas() {
        return namaPetugas;
    }

    /**
     * @param namaPetugas the namaPetugas to set
     */
    public void setNamaPetugas(String namaPetugas) {
        this.namaPetugas = namaPetugas;
    }

    /**
     * @return the waktukeluar
     */
    public String getWaktuKeluar() {
        return waktuKeluar;
    }

    /**
     * @param waktukeluar the waktukeluar to set
     */
    public void setWaktuKeluar(String waktukeluar) {
        this.waktuKeluar = waktukeluar;
    }
    
    
    
}
