/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parking.center.parkingcenter.DB;

import com.parking.center.parkingcenter.model.PetugasModel;
import com.parking.center.parkingcenter.model.UserModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    
    public static boolean isExis(String username) throws SQLException, ClassNotFoundException{
        
        String query = "SELECT * FROM user WHERE username=?";
        DBUtil db = DBUtil.getInstance();
        db.dbConnect();
        PreparedStatement preparedStatement;
        preparedStatement = db.conn.prepareStatement(query);
        preparedStatement.setString(1, username);
        ResultSet rs = db.dbExecuteQuery(preparedStatement);
        
       if(rs.next()){
            return true;
       }
        
        return false;
        
    }
    public static UserModel cekLogin(String username, String pass) throws SQLException, ClassNotFoundException{
        
        String query = "SELECT * FROM user WHERE username=? AND password =?";
        DBUtil db = DBUtil.getInstance();
        db.dbConnect();
        PreparedStatement preparedStatement;
        preparedStatement = db.conn.prepareStatement(query);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, pass);
        ResultSet rs = db.dbExecuteQuery(preparedStatement);
        
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
        String query = "INSERT INTO user (username, password, role, status) VALUES(?,?,?,?)";
        
        DBUtil db = DBUtil.getInstance();
        db.dbConnect();
        PreparedStatement preparedStatement;
        preparedStatement = db.conn.prepareStatement(query);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getRole());
        preparedStatement.setString(4,"0");
        db.dbExecuteUpdate(preparedStatement);
        
        
        System.out.println(query);
        
    }
    
    
    public static int getId() throws SQLException, ClassNotFoundException{
        String query = "SELECT max(id_user) as 'id' FROM user";
        
        DBUtil db = DBUtil.getInstance();
        db.dbConnect();
        PreparedStatement preparedStatement;
        preparedStatement = db.conn.prepareStatement(query);
        ResultSet rs = db.dbExecuteQuery(preparedStatement);
        
        int id = 0;
        
        if(rs.next()){
            id = rs.getInt("id");
        }
        
        return id;
    }
    
    public static void changePassword(int id, String newPass) throws SQLException, ClassNotFoundException{
        String query = "UPDATE user SET password  =? WHERE id_user =?";
        DBUtil db = DBUtil.getInstance();
        db.dbConnect();
        PreparedStatement preparedStatement;
        preparedStatement = db.conn.prepareStatement(query);
        preparedStatement.setString(1, newPass);
        preparedStatement.setInt(2, id);
        db.dbExecuteUpdate(preparedStatement);

    }
    
    public static boolean cekPassword(int id, String oldPass) throws SQLException, ClassNotFoundException{
        
        String query = "SELECT * FROM user WHERE password =? AND id_user =?";
        
        DBUtil db = DBUtil.getInstance();
        db.dbConnect();
        PreparedStatement preparedStatement;
        preparedStatement = db.conn.prepareStatement(query);
        preparedStatement.setString(1, oldPass);
        preparedStatement.setInt(2, id);
        ResultSet rs = db.dbExecuteQuery(preparedStatement);
        
        if(rs.next()){
            return true;
        }
        
        return false;
    }
}
