package com.parking.center.parkingcenter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.parking.center.parkingcenter.DB.UserDAO;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author rut febrianty
 */
public class ChangePasswordController implements Initializable {

    @FXML
    private Button simpan_password;
    @FXML
    private Font x1;
    @FXML
    private PasswordField lastPassword;
    @FXML
    private PasswordField newPassword;
    @FXML
    private PasswordField reNewPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        System.out.println(lastPassword.getText().isEmpty());
    }    

    @FXML
    private void onUpdate(ActionEvent event) {
        if(lastPassword.getText().isEmpty() || newPassword.getText().isEmpty() || reNewPassword.getText().isEmpty()){
            String msg = "Field tidak boleh kosong!";
            showAlert(msg);
        }else if(!newPassword.getText().equals(reNewPassword.getText())){
            String msg = "Password baru tidak sama";
            showAlert(msg);
        }else
        
            try {
            if(UserDAO.cekPassword(UserController.petugasId, lastPassword.getText().toString())){
                UserDAO.changePassword(UserController.petugasId, newPassword.getText().toString());
                String msg = "Update Password Success!";
                showAlert(msg);
            }else{
                String msg = "Password lama tidak sama!";
                showAlert(msg);
            }
                
        } catch (SQLException ex) {
            Logger.getLogger(ChangePasswordController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ChangePasswordController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void showAlert(String msg){
        Alert alert;
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Change Password Information");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
    
}
