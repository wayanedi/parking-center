/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parking.center.parkingcenter.DB;

import com.parking.center.parkingcenter.model.PetugasModel;
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
                + "VALUES('"+petugas.getNama_petugas()+"', '"+petugas.getEmail()+"', '"+petugas.getNo_ktp()+"', "
                + "'"+petugas.getNo_telp()+"', '"+petugas.getJenis_kelamin()+"', '"+petugas.getId_user()+"')";
        
        DBUtil.getInstance().dbExecuteUpdate(query);
        
    }
    
     public static PetugasModel selectPetugas(int id) throws SQLException, ClassNotFoundException{
        PetugasModel petugasModel = new PetugasModel();
        String query;
        
        query = "SELECT * FROM petugas where id_user='"+id+"'";
         System.out.println(query);
         
        ResultSet rs = DBUtil.getInstance().dbExecuteQuery(query);
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
        
        String query = "UPDATE petugas SET nama_petugas = '"+nama_petugas+"', email='"+email+"',no_ktp = '"+no_ktp+"', no_tlp = '"+no_tlp+"',jenis_kelamin = '"+jenis_kelamin+"' WHERE id_user = '"+id_user+"'";
        DBUtil.getInstance().dbExecuteUpdate(query);
        
        
    }
    
    public static ObservableList<PetugasModel> getAllData() throws SQLException, ClassNotFoundException{
        
        String query = "SELECT * FROM petugas";
        
        ResultSet rs = DBUtil.getInstance().dbExecuteQuery(query);
        
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
