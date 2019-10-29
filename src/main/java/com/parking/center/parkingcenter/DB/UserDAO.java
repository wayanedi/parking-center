/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parking.center.parkingcenter.DB;

import com.parking.center.parkingcenter.model.PetugasModel;
import com.parking.center.parkingcenter.model.UserModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author yanedi
 */
public class UserDAO {
    
    /**
     *
     * @param username
     * @param pass
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static UserModel cekLogin(String username, String pass) throws SQLException, ClassNotFoundException{
        
        String query = "SELECT * FROM user WHERE username='"+username+"' AND password = '"+pass+"'";
        
        ResultSet rs = DBUtil.getInstance().dbExecuteQuery(query);
        
        UserModel userModel = null;
        
        if(rs.next()){
            userModel = new UserModel();
            userModel.setId(rs.getInt("id_user"));
            userModel.setStatus(rs.getInt("status"));
            userModel.setRole(rs.getString("role"));
            userModel.setUsername("username");
        }
        
        return userModel;
    }
    
    public static void insertUser(UserModel user) throws SQLException, ClassNotFoundException{
           System.out.println("masuk ke fungsi insert user");
        String query = "INSERT INTO user (username, password, role, status) VALUES('"+user.getUsername()+"','"+user.getPassword()+"','"+user.getRole()+"', 0)";
        DBUtil.getInstance().dbExecuteUpdate(query);
        
        System.out.println(query);
        
    }
    
    
    public static int getId() throws SQLException, ClassNotFoundException{
        String query = "SELECT max(id_user) as 'id' FROM user";
        ResultSet rs = DBUtil.getInstance().dbExecuteQuery(query);
        
        int id = 0;
        
        if(rs.next()){
            id = rs.getInt("id");
        }
        
        return id;
    }
    
    public void updateUser(String nama_petugas, String email,  String no_ktp, String no_tlp, String jenis_kelamin, int id_user) throws SQLException, ClassNotFoundException{
        
        String query = "UPDATE petugas SET nama_petugas = '"+nama_petugas+"', email='"+email+"',no_ktp = '"+no_ktp+"', no_tlp = '"+no_tlp+"',jenis_kelamin = '"+jenis_kelamin+"' WHERE id_user = '"+id_user+"'";
        DBUtil.getInstance().dbExecuteUpdate(query);
        
        
    }
}
