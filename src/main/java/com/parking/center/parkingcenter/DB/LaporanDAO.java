/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parking.center.parkingcenter.DB;

import com.parking.center.parkingcenter.model.CatatKeluarModel;
import com.parking.center.parkingcenter.model.LaporanModel;
import com.parking.center.parkingcenter.model.SisaSlotModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

/**
 *
 * @author yanedi
 */
public class LaporanDAO {
    
    public static CatatKeluarModel getLaporanKendaraan(String plat) throws SQLException, ClassNotFoundException{
        
        String query;
        CatatKeluarModel catat = null;
        query = "SELECT laporan.waktu_masuk, jenis_kendaraan.nama_kendaraan, jenis_kendaraan.harga_perhari, jenis_kendaraan.harga_perjam, jenis_kendaraan.harga_set_hari from laporan INNER JOIN jenis_kendaraan on laporan.jenis_kendaraan = jenis_kendaraan.id_jenis_kendaraan where plat_nomor=? AND status_kendaraan='0'";
        System.out.println(query);
         
        DBUtil db = DBUtil.getInstance();
        db.dbConnect();
        PreparedStatement preparedStatement;
        preparedStatement = db.conn.prepareStatement(query);
        preparedStatement.setString(1, plat);
        ResultSet rs = db.dbExecuteQuery(preparedStatement);
        if(rs.next()){
            System.out.println("ada datanya");
            catat = new CatatKeluarModel(rs.getString("waktu_masuk"), rs.getInt("harga_perjam"), rs.getInt("harga_set_hari"), rs.getInt("harga_perhari"), rs.getString("nama_kendaraan"));
            
        }

        return catat;
        
    }
    
    public static void updateLaporan(CatatKeluarModel catat) throws SQLException, ClassNotFoundException{
        
        String query = "UPDATE laporan SET total_harga=?, waktu_keluar=?, status_kendaraan='"+1+"'";
        DBUtil db = DBUtil.getInstance();
        db.dbConnect();
        PreparedStatement preparedStatement;
        preparedStatement = db.conn.prepareStatement(query);
        preparedStatement.setInt(1, catat.getTotalHarga());
        preparedStatement.setString(2, catat.getWaktuKeluar());
        db.dbExecuteUpdate(preparedStatement);
        
    }
    
    public static void insertLaporan(LaporanModel laporan, int id) throws SQLException, ClassNotFoundException{
        
        String query;
        try {
        query = "INSERT INTO laporan (plat_nomor, id_petugas, jenis_kendaraan, waktu_masuk, status_kendaraan)"
                + "VALUES(?, ?, ?, ?, '"+0+"')";
               System.out.println(query);
            DBUtil db = DBUtil.getInstance();
            db.dbConnect();
            PreparedStatement preparedStatement;
            preparedStatement = db.conn.prepareStatement(query);
            preparedStatement.setString(1, laporan.getPlatNomor());
            preparedStatement.setInt(2, id);
            preparedStatement.setString(3, laporan.getJenisKendaraan());
            preparedStatement.setString(4, laporan.getWaktuMasuk());
            
            db.dbExecuteUpdate(preparedStatement);  
            Alert alert;
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Catat Masuk");   
            alert.setHeaderText(null);
            alert.setContentText("Data berhasil di masukkan!");
            alert.showAndWait();
        } catch (Exception e) {
            Alert alert;
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Catat Masuk");
            alert.setHeaderText(null);
            alert.setContentText("Data tidak berhasil di masukkan!");
            alert.showAndWait();
        }
        
    }
    
    public static ObservableList<SisaSlotModel> getSisaSlot() throws SQLException, ClassNotFoundException{
        
        
        String query;
        
        query = "SELECT nama_kendaraan, id_jenis_kendaraan, slot from jenis_kendaraan";
        System.out.println(query);
         
        DBUtil db = DBUtil.getInstance();
        db.dbConnect();
        PreparedStatement preparedStatement;
        preparedStatement = db.conn.prepareStatement(query);
        ResultSet rs = db.dbExecuteQuery(preparedStatement);
        
        ObservableList<SisaSlotModel> sisa = getListSlot(rs);
        
        return sisa;
        
    }
    
    private static ObservableList<SisaSlotModel>getListSlot(ResultSet rs) throws SQLException, ClassNotFoundException{
        
        ObservableList<SisaSlotModel> sisa = FXCollections.observableArrayList();
        
        SisaSlotModel sisaSlot=  null;
        
        while(rs.next()){
            
            sisaSlot = new SisaSlotModel(rs.getString("nama_kendaraan"), rs.getInt("slot"), rs.getInt("id_jenis_kendaraan"));
            sisa.add(sisaSlot);
        }
        
        
        String query2;
        query2 = "SELECT count(jenis_kendaraan) as slot from laporan where status_kendaraan='0' group by jenis_kendaraan";
        System.out.println(query2);
        int count =0;
        DBUtil db = DBUtil.getInstance();
            db.dbConnect();
        PreparedStatement preparedStatement;
        preparedStatement = db.conn.prepareStatement(query2);

        ResultSet rs2 = db.dbExecuteQuery(preparedStatement);
        while(rs2.next()){
            System.out.println("");
            sisa.get(count).setSlot(sisa.get(count).getSlot()-rs2.getInt("slot"));
            count++;
        }
        
        return sisa;
        
    }
    
    public static boolean checkPlat(String plat) throws SQLException, ClassNotFoundException{
        String query = "SELECT * from laporan where plat_nomor=? AND status_kendaraan=?";
         
        DBUtil db = DBUtil.getInstance();
        db.dbConnect();
        PreparedStatement preparedStatement;
        preparedStatement = db.conn.prepareStatement(query);
        preparedStatement.setString(1, plat);
        preparedStatement.setString(2, "0");
        ResultSet rs = db.dbExecuteQuery(preparedStatement);
        
        if(rs.next()){
           return true;  
        }
        
        return false;
    }
}
