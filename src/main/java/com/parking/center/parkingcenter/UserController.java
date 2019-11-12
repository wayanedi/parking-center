package com.parking.center.parkingcenter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.parking.center.parkingcenter.DB.PetugasDAO;
import com.parking.center.parkingcenter.model.PetugasModel;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author rut febrianty
 */
public class UserController implements Initializable {
    
    public static int petugasId;
    
    @FXML
    private Button catatBtn;
    
    @FXML
    private Button catatKeluarBtn;
    
    @FXML
    private Button editProfileBtn;
    
    @FXML
    private Button infoSlotBtn;
    
    @FXML
    private BorderPane borderPane;
    
    @FXML
    private Font x3;
    private PetugasModel petugasModel;
    @FXML
    private Button editPassword;
    @FXML
    private Label greetingTxt;
    
    @FXML
    private void getCatat(ActionEvent event) {
       loadUI("CatatMasuk");
        
        catatBtn.setStyle("-fx-background-color: #4bb0de;-fx-text-fill: #fff; -fx-font-weight: bold;");
        catatKeluarBtn.setStyle("-fx-background-color: #57caff;-fx-text-fill: #fff;");
        editProfileBtn.setStyle("-fx-background-color: #57caff;-fx-text-fill: #fff;");
        infoSlotBtn.setStyle("-fx-background-color: #57caff;-fx-text-fill: #fff;");
        editPassword.setStyle ("-fx-background-color: #57caff;-fx-text-fill: #fff;");
    }
    
    @FXML
    private void getCatatKeluar(ActionEvent event) {
        loadUI("CatatKeluar");
        catatKeluarBtn.setStyle("-fx-background-color: #4bb0de;-fx-text-fill: #fff; -fx-font-weight: bold;");
        catatBtn.setStyle("-fx-background-color: #57caff;-fx-text-fill: #fff;");
        editProfileBtn.setStyle("-fx-background-color: #57caff;-fx-text-fill: #fff;");
        infoSlotBtn.setStyle("-fx-background-color: #57caff;-fx-text-fill: #fff;");
        editPassword.setStyle ("-fx-background-color: #57caff;-fx-text-fill: #fff;");
        
    }
    
     @FXML
    private void getEdit(ActionEvent event) {
        loadUI("EditProfile");
        editProfileBtn.setStyle("-fx-background-color: #4bb0de;-fx-text-fill: #fff; -fx-font-weight: bold;");
        catatBtn.setStyle("-fx-background-color: #57caff;-fx-text-fill: #fff;");
        catatKeluarBtn.setStyle("-fx-background-color: #57caff;-fx-text-fill: #fff;");
        infoSlotBtn.setStyle("-fx-background-color: #57caff;-fx-text-fill: #fff;");
        editPassword.setStyle ("-fx-background-color: #57caff;-fx-text-fill: #fff;");
    }
    
    @FXML
    private void getInfo(ActionEvent event){
        loadUI("Informasi");
        infoSlotBtn.setStyle("-fx-background-color:#4bb0de;-fx-text-fill: #fff; -fx-font-weight:bold;");
        catatBtn.setStyle("-fx-background-color: #57caff;-fx-text-fill: #fff;");
        catatKeluarBtn.setStyle("-fx-background-color: #57caff;-fx-text-fill: #fff;");
        editProfileBtn.setStyle ("-fx-background-color: #57caff;-fx-text-fill: #fff;");
        editPassword.setStyle ("-fx-background-color: #57caff;-fx-text-fill: #fff;");
    }
    private void loadUI(String ui){
        Parent root = null;
        try {    
            root=FXMLLoader.load(getClass().getResource("/fxml/"+ui+".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        borderPane.setCenter(root);
    }
    
    @FXML
    private void getEditPassword(ActionEvent event) {
        loadUI("ChangePassword");
        infoSlotBtn.setStyle("-fx-background-color: #57caff;-fx-text-fill: #fff;");
        catatBtn.setStyle("-fx-background-color: #57caff;-fx-text-fill: #fff;");
        catatKeluarBtn.setStyle("-fx-background-color: #57caff;-fx-text-fill: #fff;");
        editProfileBtn.setStyle ("-fx-background-color: #57caff;-fx-text-fill: #fff;");
        editPassword.setStyle("-fx-background-color:#4bb0de;-fx-text-fill: #fff; -fx-font-weight:bold;");
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        try {
            this.petugasModel = PetugasDAO.selectPetugas(petugasId);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("ini init"+petugasModel.getNama_petugas());  
        System.out.println(petugasId);
        greetingTxt.setText(greetingTxt.getText() + petugasModel.getNama_petugas());
    }    
    public void getData(int id){
        this.petugasId=id;
    }

   
}
