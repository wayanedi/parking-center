/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parking.center.parkingcenter.DB;

import com.parking.center.parkingcenter.model.PetugasModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

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
                + "VALUES(?,?,?,?,?,?)";
        
        DBUtil db = DBUtil.getInstance();
        db.dbConnect();
        PreparedStatement preparedStatement;
        preparedStatement = db.conn.prepareStatement(query);
        preparedStatement.setString(1, petugas.getNama_petugas());
        preparedStatement.setString(2, petugas.getEmail());
        preparedStatement.setString(3, petugas.getNo_ktp());
        preparedStatement.setString(4, petugas.getNo_telp());
        preparedStatement.setString(5, petugas.getJenis_kelamin());
        preparedStatement.setInt(6, petugas.getId_user());
        db.dbExecuteUpdate(preparedStatement);

        
    }
    
     public static PetugasModel selectPetugas(int id) throws SQLException, ClassNotFoundException{
        PetugasModel petugasModel = new PetugasModel();
        String query;
        
        query = "SELECT * FROM petugas where id_user=?";
         System.out.println(query);
         
        DBUtil db = DBUtil.getInstance();
        db.dbConnect();
        PreparedStatement preparedStatement;
        preparedStatement = db.conn.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet rs = db.dbExecuteQuery(preparedStatement);
        
        if(rs.next()){
            petugasModel.setId_petugas(rs.getInt("id_petugas"));
            petugasModel.setNama_petugas(rs.getString("nama_petugas"));
            petugasModel.setEmail(rs.getString("email"));
            petugasModel.setNo_ktp(rs.getString("no_ktp"));
            petugasModel.setNo_telp(rs.getString("no_tlp"));
            petugasModel.setJenis_kelamin(rs.getString("jenis_kelamin"));
            System.out.println(rs.getString("nama_petugas"));
        }
        
        return petugasModel;
    }
     
     public static void updateUser(String nama_petugas, String email,  String no_ktp, String no_tlp, String jenis_kelamin, int id_user) throws SQLException, ClassNotFoundException{
        
        String query = "UPDATE petugas SET nama_petugas = ?, email=?,no_ktp = ?, no_tlp = ?,jenis_kelamin = ? WHERE id_user = ?";
        DBUtil db = DBUtil.getInstance();
        db.dbConnect();
        PreparedStatement preparedStatement;
        preparedStatement = db.conn.prepareStatement(query);
        preparedStatement.setString(1, nama_petugas);
        preparedStatement.setString(2, email);
        preparedStatement.setString(3, no_ktp);
        preparedStatement.setString(4, no_tlp);
        preparedStatement.setString(5, jenis_kelamin);
        preparedStatement.setInt(6, id_user);
        db.dbExecuteUpdate(preparedStatement);
        
        
    }
    
    public static ObservableList<PetugasModel> getAllData() throws SQLException, ClassNotFoundException{
        
        String query = "SELECT * FROM petugas";
        
        DBUtil db = DBUtil.getInstance();
        db.dbConnect();
        PreparedStatement preparedStatement;
        preparedStatement = db.conn.prepareStatement(query);
        ResultSet rs = db.dbExecuteQuery(preparedStatement);

        
        ObservableList<PetugasModel> PetugasModels = getPetugasList(rs);
            return PetugasModels;

        
    }
    
    private static ObservableList<PetugasModel> getPetugasList(ResultSet rs) throws SQLException{
        
        ObservableList<PetugasModel> petugasList = FXCollections.observableArrayList();
        
        PetugasModel petugasModel = null;
        
        while(rs.next()){
            
            petugasModel = new PetugasModel();
            petugasModel.setNama_petugas(rs.getString("nama_petugas"));
            petugasModel.setEmail(rs.getString("email"));
            petugasModel.setNo_ktp(rs.getString("no_ktp"));
            petugasModel.setNo_telp(rs.getString("no_tlp"));
            petugasModel.setJenis_kelamin(rs.getString("jenis_kelamin"));
//            petugasModel.setDelete(new Button("Hapus"));
//            petugasModel.setUpdate(new Button("Update"));
            petugasList.add(petugasModel);
            
        }
        
        return petugasList;
        
    }
}
