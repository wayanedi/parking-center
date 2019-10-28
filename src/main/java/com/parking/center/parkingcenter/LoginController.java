/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parking.center.parkingcenter;


import com.parking.center.parkingcenter.DB.UserDAO;
import com.parking.center.parkingcenter.model.UserModel;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author asus
 */
public class LoginController implements Initializable{
    
    
    
    @FXML
    private TextField username;
    
    @FXML
    private PasswordField password;
    
    @FXML
    private void loginButton(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        String user = username.getText();
        String pass = password.getText();
        
        System.out.println("masuk");
        
        UserModel hasil;
        hasil = UserDAO.cekLogin(user, pass);
        
        if(hasil !=null){
            System.out.println("berhasil");
            Alert alert;
            alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Login Information");
            alert.setHeaderText(null);
            alert.setContentText("Congratulation !");
            
            alert.showAndWait();
            Parent root = null;
            if(hasil.getRole().equals("user")){
                
                root = FXMLLoader.load(getClass().getResource("/fxml/User.fxml"));

            }
            else{
                
                root = FXMLLoader.load(getClass().getResource("/fxml/Admin.fxml"));
            }
            
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        }
        else{
            System.out.println("gagal");
            Alert alert;
            alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Login Information");
            alert.setHeaderText(null);
            alert.setContentText("username or password is incorret!");
            
            alert.showAndWait();
            
        }

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //
    }    
    
}
