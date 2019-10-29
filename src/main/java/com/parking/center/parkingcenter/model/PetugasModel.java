/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parking.center.parkingcenter.model;

import javafx.scene.control.Button;

/**
 *
 * @author yanedi
 */
public class PetugasModel {
    
    private int id_petugas;
    private String nama_petugas;
    private String email;
    private String no_ktp;
    private String no_telp;
    private String jenis_kelamin;
    private int id_user;
    
    private Button update;
    private Button delete;

    /**
     * @return the id_petugas
     */
    public int getId_petugas() {
        return id_petugas;
    }

    /**
     * @param id_petugas the id_petugas to set
     */
    public void setId_petugas(int id_petugas) {
        this.id_petugas = id_petugas;
    }

    /**
     * @return the nama_petugas
     */
    public String getNama_petugas() {
        return nama_petugas;
    }

    /**
     * @param nama_petugas the nama_petugas to set
     */
    public void setNama_petugas(String nama_petugas) {
        this.nama_petugas = nama_petugas;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the no_ktp
     */
    public String getNo_ktp() {
        return no_ktp;
    }

    /**
     * @param no_ktp the no_ktp to set
     */
    public void setNo_ktp(String no_ktp) {
        this.no_ktp = no_ktp;
    }

    /**
     * @return the no_telp
     */
    public String getNo_telp() {
        return no_telp;
    }

    /**
     * @param no_telp the no_telp to set
     */
    public void setNo_telp(String no_telp) {
        this.no_telp = no_telp;
    }

    /**
     * @return the jenis_kelamin
     */
    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    /**
     * @param jenis_kelamin the jenis_kelamin to set
     */
    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    /**
     * @return the id_user
     */
    public int getId_user() {
        return id_user;
    }

    /**
     * @param id_user the id_user to set
     */
    public void setId_user(int id_user) {
        this.id_user = id_user;
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
    }

    /**
     * @return the delete
     */
    public Button getDelete() {
        return delete;
    }

    /**
     * @param delete the delete to set
     */
    public void setDelete(Button delete) {
        this.delete = delete;
    }
    
    
    
}
