/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.parking.center.parkingcenter;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * FXML Controller class
 *
 * @author yanedi
 */

   
        
public class AdminController implements Initializable {
   
    /**
     * Initializes the controller class.
     */
    @FXML
    private Button addBtn;
    
    @FXML
    private Button editBtn;
    
    @FXML
    private Button setupBtn;
    
    @FXML
    private Button laporanBtn;
    
    @FXML
    private Button daftarBtn;
             
    @FXML
    private Pane setup_Parkir;
    
    @FXML
    private Pane edit_profile_admin;
    
    @FXML
    private Pane tambah_Staff;
    
    @FXML
    private Pane daftar_Staff;
    
    
    @FXML
    private void addStaff(ActionEvent event) {
        tambah_Staff.setVisible(true);
        setup_Parkir.setVisible(false);
        edit_profile_admin.setVisible(false);
        daftar_Staff.setVisible(false);
        addBtn.setStyle("-fx-background-color: #4bb0de;-fx-text-fill: #fff; -fx-font-weight: bold;");
        editBtn.setStyle("-fx-background-color: #57caff;-fx-text-fill: #fff;");
        setupBtn.setStyle("-fx-background-color: #57caff;-fx-text-fill: #fff;");
        laporanBtn.setStyle("-fx-background-color: #57caff;-fx-text-fill: #fff;");
        daftarBtn.setStyle("-fx-background-color: #57caff;-fx-text-fill: #fff;");
    }
    
    @FXML
    private void setupStaff(ActionEvent event) {
        tambah_Staff.setVisible(false);
        setup_Parkir.setVisible(true);
        edit_profile_admin.setVisible(false);
        daftar_Staff.setVisible(false);
        setupBtn.setStyle("-fx-background-color: #4bb0de;-fx-text-fill: #fff; -fx-font-weight: bold;");
        editBtn.setStyle("-fx-background-color: #57caff;-fx-text-fill: #fff;");
        addBtn.setStyle("-fx-background-color: #57caff;-fx-text-fill: #fff;");
        laporanBtn.setStyle("-fx-background-color: #57caff;-fx-text-fill: #fff;");
        daftarBtn.setStyle("-fx-background-color: #57caff;-fx-text-fill: #fff;");
    }
    
    @FXML
    private void getEdit(ActionEvent event) {
        tambah_Staff.setVisible(false);
        setup_Parkir.setVisible(false);
        edit_profile_admin.setVisible(true);
        daftar_Staff.setVisible(false);
        editBtn.setStyle("-fx-background-color: #4bb0de;-fx-text-fill: #fff; -fx-font-weight: bold;");
        addBtn.setStyle("-fx-background-color: #57caff;-fx-text-fill: #fff;");
        setupBtn.setStyle("-fx-background-color: #57caff;-fx-text-fill: #fff;");
        laporanBtn.setStyle("-fx-background-color: #57caff;-fx-text-fill: #fff;");
        daftarBtn.setStyle("-fx-background-color: #57caff;-fx-text-fill: #fff;");
    }
    
    @FXML
    private void getDaftar(ActionEvent event) {
        tambah_Staff.setVisible(false);
        setup_Parkir.setVisible(false);
        edit_profile_admin.setVisible(false);
        daftar_Staff.setVisible(true);
        daftarBtn.setStyle("-fx-background-color: #4bb0de;-fx-text-fill: #fff; -fx-font-weight: bold;");
        addBtn.setStyle("-fx-background-color: #57caff;-fx-text-fill: #fff;");
        setupBtn.setStyle("-fx-background-color: #57caff;-fx-text-fill: #fff;");
        laporanBtn.setStyle("-fx-background-color: #57caff;-fx-text-fill: #fff;");
        editBtn.setStyle("-fx-background-color: #57caff;-fx-text-fill: #fff;");
    }
    
    @FXML
    private void getLaporan(ActionEvent event) {
        tambah_Staff.setVisible(false);
        setup_Parkir.setVisible(false);
        edit_profile_admin.setVisible(false);
        daftar_Staff.setVisible(false);
        laporanBtn.setStyle("-fx-background-color: #4bb0de;-fx-text-fill: #fff; -fx-font-weight: bold;");
        addBtn.setStyle("-fx-background-color: #57caff;-fx-text-fill: #fff;");
        setupBtn.setStyle("-fx-background-color: #57caff;-fx-text-fill: #fff;");
        daftarBtn.setStyle("-fx-background-color: #57caff;-fx-text-fill: #fff;");
        editBtn.setStyle("-fx-background-color: #57caff;-fx-text-fill: #fff;");
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

}
