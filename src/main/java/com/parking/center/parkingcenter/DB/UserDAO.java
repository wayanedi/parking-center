/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parking.center.parkingcenter.DB;

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
            userModel.setRole(rs.getString("role"));
        }
        
        return userModel;
    }
    
    public void insertUser(String username, String pass,  String role) throws SQLException, ClassNotFoundException{
        
        String query = "INSERT INTO user (username, password, role) VALUES('"+username+"','"+pass+"','"+role+"')";
        DBUtil.getInstance().dbExecuteUpdate(query);
    }
    
    public void insertDetailUser(){
        
    }
    
}
