/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parking.center.parkingcenter.DB;

import com.parking.center.parkingcenter.model.PetugasModel;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author yanedi
 */
public class PetugasDAO {
    
    /**
     *
     * @param petugas
     * @param id
     */
    public static void insertPetugas(PetugasModel petugas) throws SQLException, ClassNotFoundException{
        
        String query;
        query = "INSERT INTO petugas(nama_petugas, email, no_ktp, no_tlp, jenis_kelamin, id_user) "
                + "VALUES('"+petugas.getNama_petugas()+"', '"+petugas.getEmail()+"', '"+petugas.getNo_ktp()+"', "
                + "'"+petugas.getNo_telp()+"', '"+petugas.getJenis_kelamin()+"', '"+petugas.getId_user()+"')";
        
        DBUtil.getInstance().dbExecuteUpdate(query);
        
    }
}
