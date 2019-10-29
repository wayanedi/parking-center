/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parking.center.parkingcenter.model;

/**
 *
 * @author asus
 */
public class JenisKendaraanModel {
    private int idJenisKendaraan;
    private String namaKendaraan;
    private int hargaPerJam;
    private int hargaPerSetHari;
    private int hargaPerHari;
    private int slot;
    
    public JenisKendaraanModel(int idJenisKendaraan, String namaKendaraan, int hargaPerJam, int hargaPerSetHari, int hargaPerHari, int slot){
        this.idJenisKendaraan= idJenisKendaraan;
        this.namaKendaraan = namaKendaraan;
        this.hargaPerSetHari = hargaPerSetHari;
        this.hargaPerHari = hargaPerHari;
        this.slot = slot;
    }
    
    public JenisKendaraanModel(String namaKendaraan, int hargaPerJam, int hargaPerSetHari, int hargaPerHari, int slot){
        this.namaKendaraan = namaKendaraan;
        this.hargaPerJam = hargaPerJam;
        this.hargaPerSetHari = hargaPerSetHari;
        this.hargaPerHari = hargaPerHari;
        this.slot = slot;
    }
    
    public JenisKendaraanModel(){
        
    }
    
    /**
     * @return the idJenisKendaraan
     */
    public int getIdJenisKendaraan() {
        return idJenisKendaraan;
    }

    /**
     * @param idJenisKendaraan the idJenisKendaraan to set
     */
    public void setIdJenisKendaraan(int idJenisKendaraan) {
        this.idJenisKendaraan = idJenisKendaraan;
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
     * @return the hargaPerJam
     */
    public int getHargaPerJam() {
        return hargaPerJam;
    }

    /**
     * @param hargaPerJam the hargaPerJam to set
     */
    public void setHargaPerJam(int hargaPerJam) {
        this.hargaPerJam = hargaPerJam;
    }

    /**
     * @return the hargaPerSetHari
     */
    public int getHargaPerSetHari() {
        return hargaPerSetHari;
    }

    /**
     * @param hargaPerSetHari the hargaPerSetHari to set
     */
    public void setHargaPerSetHari(int hargaPerSetHari) {
        this.hargaPerSetHari = hargaPerSetHari;
    }

    /**
     * @return the hargaPerHari
     */
    public int getHargaPerHari() {
        return hargaPerHari;
    }

    /**
     * @param hargaPerHari the hargaPerHari to set
     */
    public void setHargaPerHari(int hargaPerHari) {
        this.hargaPerHari = hargaPerHari;
    }

    /**
     * @return the slot
     */
    public int getSlot() {
        return slot;
    }

    /**
     * @param slot the slot to set
     */
    public void setSlot(int slot) {
        this.slot = slot;
    }
   
}
