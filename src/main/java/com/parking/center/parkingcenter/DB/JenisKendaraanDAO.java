/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parking.center.parkingcenter.DB;

import com.parking.center.parkingcenter.model.JenisKendaraanModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

/**
 *
 * @author asus
 */
public class JenisKendaraanDAO {
    
    public static int getTotalSlot() throws SQLException, ClassNotFoundException{
        String query = "SELECT sum(slot) as 'total' FROM jenis_kendaraan";
        DBUtil db = DBUtil.getInstance();
        db.dbConnect();
        PreparedStatement preparedStatement;
        preparedStatement = db.conn.prepareStatement(query);
        ResultSet rs = db.dbExecuteQuery(preparedStatement);
        
        int hasil = 0;
        
        if(rs.next()){
            hasil = rs.getInt("total");
        }
        
        return hasil;
    }
    
        public static ArrayList<JenisKendaraanModel> getAllData() throws SQLException, ClassNotFoundException{
        
        String query = "SELECT * FROM jenis_kendaraan";
        DBUtil db = DBUtil.getInstance();
        db.dbConnect();
        PreparedStatement preparedStatement;
        preparedStatement = db.conn.prepareStatement(query);
        ResultSet rs = db.dbExecuteQuery(preparedStatement);
        
        ArrayList<JenisKendaraanModel> jenisKendaraanModel = new ArrayList<JenisKendaraanModel>();
        JenisKendaraanModel jenisKendaraanModel1 = null;
        
        if(rs.next()){
            jenisKendaraanModel1 = new JenisKendaraanModel();
            jenisKendaraanModel1.setIdJenisKendaraan(rs.getInt("id_jenis_kendaraan"));
            jenisKendaraanModel1.setNamaKendaraan(rs.getString("nama_kendaraan"));
            jenisKendaraanModel1.setHargaPerJam(rs.getInt("harga_perjam"));
            jenisKendaraanModel1.setHargaPerSetHari(rs.getInt("harga_set_hari"));
            jenisKendaraanModel1.setHargaPerHari(rs.getInt("harga_perhari"));
            jenisKendaraanModel1.setSlot(rs.getInt("slot"));
            jenisKendaraanModel.add(jenisKendaraanModel1);
        }
        return jenisKendaraanModel;
    }
    
    public static void insertJenisKendaraan(JenisKendaraanModel jenisKendaraanModel) throws SQLException, ClassNotFoundException{
        System.out.println(jenisKendaraanModel.getHargaPerJam());
        String query = "INSERT INTO jenis_kendaraan (nama_kendaraan, harga_perjam, harga_set_hari, harga_perhari, slot) VALUES(?,?,?,?,?)";
        DBUtil db = DBUtil.getInstance();
        db.dbConnect();
        PreparedStatement preparedStatement;
        preparedStatement = db.conn.prepareStatement(query);
        preparedStatement.setString(1, jenisKendaraanModel.getNamaKendaraan());
        preparedStatement.setInt(2, jenisKendaraanModel.getHargaPerJam());
        preparedStatement.setInt(3, jenisKendaraanModel.getHargaPerSetHari());
        preparedStatement.setInt(4, jenisKendaraanModel.getHargaPerHari());
        preparedStatement.setInt(5, jenisKendaraanModel.getSlot());
        ResultSet rs = db.dbExecuteQuery(preparedStatement);
        System.out.println("berhasil");
    }
    
    public static void updateData(int id, String namaKendaraan, int hargaPerJam, int hargaPerSet, int hargaPerHari, int slot) throws SQLException, ClassNotFoundException {
        String query = "UPDATE jenis_kendaraan set nama_kendaraan=?, harga_perjam=?, harga_set_hari=?, harga_perhari = ?, slot = ? where id_jenis_kendaraan = '"+id+"'";
        System.out.println(query);
        DBUtil db = DBUtil.getInstance();
        db.dbConnect();
        PreparedStatement preparedStatement;
        preparedStatement = db.conn.prepareStatement(query);
        preparedStatement.setString(1, namaKendaraan);
        preparedStatement.setInt(2, hargaPerJam);
        preparedStatement.setInt(3, hargaPerSet);
        preparedStatement.setInt(4, hargaPerHari);
        preparedStatement.setInt(5, slot);
        ResultSet rs = db.dbExecuteQuery(preparedStatement);
        System.out.println("terupdate");
    }
    
    public static void deleteData(int id) throws SQLException, ClassNotFoundException {
        String query = "DELETE FROM jenis_kendaraan where id_jenis_kendaraan = ?";
        DBUtil db = DBUtil.getInstance();
        db.dbConnect();
        PreparedStatement preparedStatement;
        preparedStatement = db.conn.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet rs = db.dbExecuteQuery(preparedStatement);
        System.out.println("terhapus");
    }
    
    public static ObservableList<JenisKendaraanModel> getAlls() throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM jenis_kendaraan";
        try {
            DBUtil db = DBUtil.getInstance();
            db.dbConnect();
            PreparedStatement preparedStatement;
            preparedStatement = db.conn.prepareStatement(selectStmt);
            ResultSet rs = db.dbExecuteQuery(preparedStatement);
            ObservableList<JenisKendaraanModel> jenisKendaraanModels = getKendaraanList(rs);
            return jenisKendaraanModels;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e); //Return exception
            throw e;
        }
        
    }
    
    private static ObservableList<JenisKendaraanModel> getKendaraanList(ResultSet rs) throws SQLException, ClassNotFoundException {
        ObservableList<JenisKendaraanModel> kendaraanList = FXCollections.observableArrayList();
        while (rs.next()) {
            
            JenisKendaraanModel jenisKendaraanModel = new JenisKendaraanModel();
            jenisKendaraanModel.setIdJenisKendaraan(rs.getInt("id_jenis_kendaraan"));
            jenisKendaraanModel.setNamaKendaraan(rs.getString("nama_kendaraan"));
            jenisKendaraanModel.setHargaPerJam(rs.getInt("harga_perjam"));
            jenisKendaraanModel.setHargaPerSetHari(rs.getInt("harga_set_hari"));
            jenisKendaraanModel.setHargaPerHari(rs.getInt("harga_perhari"));
            jenisKendaraanModel.setSlot(rs.getInt("slot"));
            jenisKendaraanModel.setUpdate(new Button("Update"));
            jenisKendaraanModel.setDelete(new Button("Hapus"));
            kendaraanList.add(jenisKendaraanModel);
        }
        return kendaraanList;
    }
}
