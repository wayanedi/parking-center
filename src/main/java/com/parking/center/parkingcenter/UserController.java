package com.parking.center.parkingcenter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author rut febrianty
 */
public class UserController implements Initializable {
    @FXML
    private Button catatBtn;
    
    @FXML
    private Button catatKeluarBtn;
    
    @FXML
    private Button editProfileBtn;
    
    @FXML
    private Pane cetakKeluar;
    
    @FXML
    private Pane cetakMasuk;
    
    @FXML
    private Pane editProfile;
    
    @FXML
    private void getCatat(ActionEvent event) {
        cetakMasuk.setVisible(true);
        cetakKeluar.setVisible(false);
        editProfile.setVisible(false);
        
        catatBtn.setStyle("-fx-background-color: #4bb0de;-fx-text-fill: #fff; -fx-font-weight: bold;");
        catatKeluarBtn.setStyle("-fx-background-color: #57caff;-fx-text-fill: #fff;");
        editProfileBtn.setStyle("-fx-background-color: #57caff;-fx-text-fill: #fff;");
    }
    
    @FXML
    private void getCatatKeluar(ActionEvent event) {
        cetakMasuk.setVisible(false);
        cetakKeluar.setVisible(true);
        editProfile.setVisible(false);
        catatKeluarBtn.setStyle("-fx-background-color: #4bb0de;-fx-text-fill: #fff; -fx-font-weight: bold;");
        catatBtn.setStyle("-fx-background-color: #57caff;-fx-text-fill: #fff;");
        editProfileBtn.setStyle("-fx-background-color: #57caff;-fx-text-fill: #fff;");
    }
    
     @FXML
    private void getEdit(ActionEvent event) {
        cetakMasuk.setVisible(false);
        cetakKeluar.setVisible(false);
        editProfile.setVisible(true);
        editProfileBtn.setStyle("-fx-background-color: #4bb0de;-fx-text-fill: #fff; -fx-font-weight: bold;");
        catatBtn.setStyle("-fx-background-color: #57caff;-fx-text-fill: #fff;");
        catatKeluarBtn.setStyle("-fx-background-color: #57caff;-fx-text-fill: #fff;");
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
