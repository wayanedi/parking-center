/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parking.center.parkingcenter;

import java.awt.TextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
/**
 * FXML Controller class
 *
 * @author asus
 */
public class LoginController implements Initializable{
    
    Database database = new Database();
    
    //@FXML
    //private TextField username;
    
    //@FXML
    //private PasswordField password;
    
    @FXML
    private void loginButton(ActionEvent event) throws SQLException {
        //String user = username.getText();
        //String pass = password.getText();
        //System.out.println(username_f.getText());
        //System.out.println(pass);
        //database.userQuery(user, pass);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
