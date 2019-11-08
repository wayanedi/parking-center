/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parking.center.parkingcenter.DB;

import com.parking.center.parkingcenter.model.LaporanModel;
import com.parking.center.parkingcenter.model.SisaSlotModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author yanedi
 */
public class LaporanDAO {
    
    public static void insertLaporan(LaporanModel laporan, int id) throws SQLException, ClassNotFoundException{
        
        String query;
        query = "INSERT INTO laporan (plat_nomor, id_petugas, jenis_kendaraan, waktu_masuk, status_kendaraan)"
                + "VALUES('"+laporan.getPlatNomor()+"', '"+id+"', '"+laporan.getJenisKendaraan()+"', '"+laporan.getWaktuMasuk()+"', '"+0+"')";
               
        DBUtil.getInstance().dbExecuteUpdate(query);
    }
    
    public static ObservableList<SisaSlotModel> getSisaSlot() throws SQLException, ClassNotFoundException{
        
        
        String query;
        
        query = "﻿SELECT nama_kendaraan, jenis_kendaraan.slot -count(laporan.jenis_kendaraan) as 'sisa' from laporan inner join jenis_kendaraan on laporan.jenis_kendaraan = jenis_kendaraan.id_jenis_kendaraan where status_kendaraan = \"0\" GROUP by nama_kendaraan";
         System.out.println(query);
         
        ResultSet rs = DBUtil.getInstance().dbExecuteQuery(query);
        
        ObservableList<SisaSlotModel> sisa = getListSlot(rs);
        
        return sisa;
        
    }
    
    private static ObservableList<SisaSlotModel>getListSlot(ResultSet rs) throws SQLException{
        
        ObservableList<SisaSlotModel> sisa = FXCollections.observableArrayList();
        
        SisaSlotModel sisaSlot=  null;
        
        while(rs.next()){
            
            sisaSlot = new SisaSlotModel(rs.getString("nama_kendaraan"), rs.getInt("slot"));
            sisa.add(sisaSlot);
        }
        
        return sisa;
        
    }
    
}
