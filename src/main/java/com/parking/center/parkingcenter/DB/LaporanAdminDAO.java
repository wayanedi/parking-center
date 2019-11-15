/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parking.center.parkingcenter.DB;

import com.parking.center.parkingcenter.model.KategoriModel;
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
