/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parking.center.parkingcenter.model;

/**
 *
 * @author yanedi
 */
public class SisaSlotModel {
    
    private String namaKendaraan;
    private int slot;
    
    public SisaSlotModel(String namaKendaraan, int slot){
        this.namaKendaraan = namaKendaraan;
        this.slot = slot;
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
