/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parking.center.parkingcenter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author asus
 */
public class Database {
    private  Connection conn = null;
    
    public void connect() {
       
        try {
            // db parameters
            String url = "jdbc:sqlite:database\\parkingCenter.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public void userQuery(String username, String password) throws SQLException{
        connect();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT username FROM user WHERE username "+username+" and password="+password+"");
        if(rs.next()) {
            System.out.println("ada");
        }else{
            System.out.println("tidak ada");
        }
    }
}
