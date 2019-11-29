    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parking.center.parkingcenter.DB;

import com.parking.center.parkingcenter.AdminController;
import com.parking.center.parkingcenter.model.KategoriModel;
import com.parking.center.parkingcenter.model.LaporanModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author yanedi
 */
public class LaporanAdminDAO {
   
    
     public static ObservableList<LaporanModel> getLaporanKategori(String from, String to, int id) throws SQLException, ClassNotFoundException {
        
        String query;
        
        query = "SELECT nama_kendaraan, plat_nomor, nama_petugas, nama_kendaraan, waktu_masuk, waktu_keluar, total_harga from laporan INNER JOIN petugas on laporan.id_petugas = petugas.id_petugas INNER JOIN jenis_kendaraan on laporan.jenis_kendaraan = jenis_kendaraan.id_jenis_kendaraan WHERE waktu_keluar between ? and ? AND laporan.jenis_kendaraan =?";
        System.out.println(query);
         
        DBUtil db = DBUtil.getInstance();
        db.dbConnect();
        PreparedStatement preparedStatement;
        preparedStatement = db.conn.prepareStatement(query);
        preparedStatement.setString(1, from);
        preparedStatement.setString(2, to);
        preparedStatement.setInt(3, id);
        ResultSet rs = db.dbExecuteQuery(preparedStatement);
        
        ObservableList<LaporanModel> laporan = getLaporanKategoriList(rs);
        
        return laporan;

    }
    
    private static ObservableList<LaporanModel>getLaporanKategoriList(ResultSet rs) throws SQLException{
        
        ObservableList<LaporanModel> laporan = FXCollections.observableArrayList();
        
        LaporanModel laporanModel = null;
        
        while(rs.next()){
            
            laporanModel = new LaporanModel(rs.getString("nama_kendaraan"), rs.getString("plat_nomor"), rs.getString("nama_petugas"), rs.getString("nama_kendaraan"), rs.getString("waktu_masuk"), rs.getString("waktu_keluar"), rs.getInt("total_harga"));
            AdminController.TOTAL += rs.getInt("total_harga");
            laporan.add(laporanModel); 
       }
        
        return laporan;

    }
    
    public static ObservableList<LaporanModel> getAllLaporan(String from, String to) throws SQLException, ClassNotFoundException {
        
        String query;
        
        query = "SELECT nama_kendaraan, plat_nomor, nama_petugas, nama_kendaraan, waktu_masuk, waktu_keluar, total_harga from laporan INNER JOIN petugas on laporan.id_petugas = petugas.id_petugas INNER JOIN jenis_kendaraan on laporan.jenis_kendaraan = jenis_kendaraan.id_jenis_kendaraan WHERE waktu_keluar between ? and ?";
        System.out.println(query);
         
        DBUtil db = DBUtil.getInstance();
        db.dbConnect();
        PreparedStatement preparedStatement;
        preparedStatement = db.conn.prepareStatement(query);
        preparedStatement.setString(1, from);
        preparedStatement.setString(2, to);
        ResultSet rs = db.dbExecuteQuery(preparedStatement);
        
        ObservableList<LaporanModel> laporan = getAllLaporanList(rs);
        
        return laporan;

    }
    
    private static ObservableList<LaporanModel>getAllLaporanList(ResultSet rs) throws SQLException{
        
        ObservableList<LaporanModel> laporan = FXCollections.observableArrayList();
        
        LaporanModel laporanModel = null;
        
        while(rs.next()){
            
            laporanModel = new LaporanModel(rs.getString("nama_kendaraan"), rs.getString("plat_nomor"), rs.getString("nama_petugas"), rs.getString("nama_kendaraan"), rs.getString("waktu_masuk"), rs.getString("waktu_keluar"), rs.getInt("total_harga"));
            laporan.add(laporanModel);
            AdminController.TOTAL += rs.getInt("total_harga");
        }
        
        return laporan;

    }
    
    
    
    public static ObservableList<KategoriModel> getKategori() throws SQLException, ClassNotFoundException{
        
        String query;
        
        query = "SELECT * FROM jenis_kendaraan";
        System.out.println(query);
         
        DBUtil db = DBUtil.getInstance();
        db.dbConnect();
        PreparedStatement preparedStatement;
        preparedStatement = db.conn.prepareStatement(query);
        ResultSet rs = db.dbExecuteQuery(preparedStatement);
        
        ObservableList<KategoriModel> kategori = getListKategori(rs);
        
        return kategori;
        
    }
    
    private static ObservableList<KategoriModel>getListKategori(ResultSet rs) throws SQLException{
        
        ObservableList<KategoriModel> kategori = FXCollections.observableArrayList();
        
        KategoriModel kategoriModel = null;
        
        while(rs.next()){
            kategoriModel = new KategoriModel(rs.getInt("id_jenis_kendaraan"), rs.getString("nama_kendaraan"));
            kategori.add(kategoriModel);
        }
        
        return kategori;

    }
    
}
