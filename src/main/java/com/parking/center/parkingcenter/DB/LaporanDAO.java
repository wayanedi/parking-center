/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parking.center.parkingcenter.DB;

import com.parking.center.parkingcenter.model.CatatKeluarModel;
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
    
    public static CatatKeluarModel getLaporanKendaraan(String plat) throws SQLException, ClassNotFoundException{
        
        String query;
        CatatKeluarModel catat = null;
        query = "SELECT laporan.waktu_masuk, jenis_kendaraan.harga_perhari, jenis_kendaraan.harga_perjam, jenis_kendaraan.harga_set_hari from laporan INNER JOIN jenis_kendaraan on laporan.jenis_kendaraan = jenis_kendaraan.id_jenis_kendaraan where plat_nomor='abc'";
        System.out.println(query);
         
        ResultSet rs = DBUtil.getInstance().dbExecuteQuery(query);
        System.out.println("2");
        if(rs.next()){
            System.out.println("ada datanya");
            catat = new CatatKeluarModel(rs.getString("waktu_masuk"), rs.getInt("harga_perjam"), rs.getInt("harga_set_hari"), rs.getInt("harga_perhari"));
            
        }

        return catat;
        
    }
    
    public static void updateLaporan(CatatKeluarModel catat) throws SQLException, ClassNotFoundException{
        
        String query = "UPDATE laporan SET total_harga='"+catat.getTotalHarga()+"', waktu_keluar='"+catat.getWaktuKeluar()+"', status_kendaraan='"+1+"'";
        DBUtil.getInstance().dbExecuteUpdate(query);
        
    }
    
    public static void insertLaporan(LaporanModel laporan, int id) throws SQLException, ClassNotFoundException{
        
        String query;
        query = "INSERT INTO laporan (plat_nomor, id_petugas, jenis_kendaraan, waktu_masuk, status_kendaraan)"
                + "VALUES('"+laporan.getPlatNomor()+"', '"+id+"', '"+laporan.getJenisKendaraan()+"', '"+laporan.getWaktuMasuk()+"', '"+0+"')";
               
        DBUtil.getInstance().dbExecuteUpdate(query);
    }
    
    public static ObservableList<SisaSlotModel> getSisaSlot() throws SQLException, ClassNotFoundException{
        
        
        String query;
        
        query = "SELECT nama_kendaraan, id_jenis_kendaraan, slot-count(laporan.jenis_kendaraan) as 'sisa' from laporan inner join jenis_kendaraan on laporan.jenis_kendaraan = jenis_kendaraan.id_jenis_kendaraan where status_kendaraan = '0' GROUP by nama_kendaraan";
        System.out.println(query);
         
        ResultSet rs = DBUtil.getInstance().dbExecuteQuery(query);
        
        ObservableList<SisaSlotModel> sisa = getListSlot(rs);
        
        return sisa;
        
    }
    
    private static ObservableList<SisaSlotModel>getListSlot(ResultSet rs) throws SQLException{
        
        ObservableList<SisaSlotModel> sisa = FXCollections.observableArrayList();
        
        SisaSlotModel sisaSlot=  null;
        
        while(rs.next()){
            
            sisaSlot = new SisaSlotModel(rs.getString("nama_kendaraan"), rs.getInt("sisa"),rs.getInt("id_jenis_kendaraan"));
            sisa.add(sisaSlot);
        }
        
        return sisa;
        
    }
    
}
