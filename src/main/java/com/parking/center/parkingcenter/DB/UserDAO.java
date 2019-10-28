/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parking.center.parkingcenter.DB;

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
    public static ArrayList<String> cekLogin(String username, String pass) throws SQLException, ClassNotFoundException{
        
        String query = "SELECT * FROM user WHERE username='"+username+"' AND password = '"+pass+"'";
        
        ResultSet rs = DBUtil.getInstance().dbExecuteQuery(query);
        
        ArrayList<String> hasil = new ArrayList<String>();
        
        if(rs.next()){
            hasil.add("true");
            hasil.add(rs.getString("role")); 
        }
        else{
            hasil.add("false");
        }
        
        
        return hasil;
    }
    
    public boolean insertUser(){
        
        
        return false;
        
    }
    
}
