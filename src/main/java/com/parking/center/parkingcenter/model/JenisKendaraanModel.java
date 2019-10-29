/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parking.center.parkingcenter.model;

import com.parking.center.parkingcenter.AdminController;
import com.parking.center.parkingcenter.DB.JenisKendaraanDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

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
    private Button update;
    private Button delete;
    
    
    
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
    
    public JenisKendaraanModel(String namaKendaraan, int hargaPerJam, int hargaPerSetHari, int hargaPerHari, int slot, Button update, Button delete){
        this.namaKendaraan = namaKendaraan;
        this.hargaPerJam = hargaPerJam;
        this.hargaPerSetHari = hargaPerSetHari;
        this.hargaPerHari = hargaPerHari;
        this.slot = slot;
        this.update = update;
        this.delete = delete;
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
   
    /**
     * @return the update
     */
    public Button getUpdate() {
        return update;
    }

    /**
     * @param update the update to set
     */
    public void setUpdate(Button update) {
        this.update = update;
         update.setOnAction(new EventHandler<ActionEvent>() {
    
            @Override
            public void handle(ActionEvent event) {
                try {
                    JenisKendaraanDAO.updateData(idJenisKendaraan,namaKendaraan, hargaPerJam, hargaPerSetHari, hargaPerHari, slot);
                } catch (SQLException ex) {
                    Logger.getLogger(JenisKendaraanModel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(JenisKendaraanModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    public Button getDelete() {
        return delete;
    }

    /**
     * @param update the update to set
     */
    public void setDelete(Button delete) {
        this.delete = delete;
         delete.setOnAction(new EventHandler<ActionEvent>() {
    
            @Override
            public void handle(ActionEvent event) {
                try {
                    JenisKendaraanDAO.deleteData(idJenisKendaraan);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(JenisKendaraanModel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(JenisKendaraanModel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
