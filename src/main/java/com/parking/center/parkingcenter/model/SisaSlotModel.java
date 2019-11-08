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
    private int id;
    
    public SisaSlotModel(String namaKendaraan, int slot, int id){
        this.namaKendaraan = namaKendaraan;
        this.slot = slot;
        this.id = id;
    }

    @Override
    public String toString(){
        return this.getNamaKendaraan();
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

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
