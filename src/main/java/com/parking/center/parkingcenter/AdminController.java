/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.parking.center.parkingcenter;

import com.parking.center.parkingcenter.DB.JenisKendaraanDAO;
import com.parking.center.parkingcenter.model.JenisKendaraanModel;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

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
    private Pane kosongPane;
    
    
    //========= Selector bagian setup parkir ================
    @FXML
    private TextField namaKendaraan;
    
    @FXML
    private TextField hargaPerjam;
    
    @FXML
    private TextField hargaSetengah;
    
    @FXML
    private TextField hargaPerhari;
    
    @FXML
    private TextField slotParkir;
    
    
    //========== fungsi untuk setup parkir ===================
    
    @FXML
    private void addSetupParkir(ActionEvent event) throws ClassNotFoundException, SQLException{
        String nama = namaKendaraan.getText();
        String txtPerJam = hargaPerjam.getText();
        String txtSetengah = hargaSetengah.getText();
        String txtPerHari = hargaPerhari.getText();
        String txtSlot = slotParkir.getText();
        
        boolean perJam=true;
        boolean perSetengah=true;
        boolean perHari=true;
        boolean slot=true;
        
        Alert alert;
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Setup Information");
            
        System.out.println(nama);
        System.out.println(txtPerJam);
        System.out.println(txtSetengah);
        System.out.println(txtPerHari);
        System.out.println(txtSlot);
        String checkNum = "\\d+";
        
        if(!txtPerJam.matches(checkNum)){
            perJam=false;
            System.out.println("format1 salah");
        }
        
        if(!txtSetengah.matches(checkNum)){
            perSetengah=false;
            System.out.println("format2 salah");
        }
        
        if(!txtPerHari.matches(checkNum)){
            perHari=false;
            System.out.println("format3 salah");
        }
        
        if(!txtSlot.matches(checkNum)){
            slot=false;
            System.out.println("format4 salah");
        }
        
        if(!perJam && !perSetengah && !perHari && !slot){
            alert.setHeaderText(null);
            alert.setContentText("Format harga atau slot parkir harus berupa angka dan tidak boleh kosong!");
        }else{
            JenisKendaraanModel jenisKendaraanModel = new JenisKendaraanModel(nama, Integer.parseInt(txtPerJam), Integer.parseInt(txtSetengah), Integer.parseInt(txtPerHari), Integer.parseInt(txtSlot));
            JenisKendaraanDAO.insertJenisKendaraan(jenisKendaraanModel);
            alert.setHeaderText(null);
            alert.setHeaderText("Data berhasil dimasukan!");
        }
        alert.showAndWait();
    }
    
    
    //============== batas untuk fungsi bagian setup parkir ================
    
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
        jenisKelamin_combo.getItems().removeAll(jenisKelamin_combo.getItems());
        jenisKelamin_combo.getItems().addAll("Laki-laki", "Perempuan");
        jenisKelamin_combo.getSelectionModel().select("");
        kosongPane.setVisible(true);
        tambah_Staff.setVisible(false);
        setup_Parkir.setVisible(false);
        edit_profile_admin.setVisible(false);
        daftar_Staff.setVisible(false);
    }    
    
    @FXML
    private TextField namaPetugas_edit;
      
    @FXML
    private TextField email_edit;
       
    @FXML
    private TextField noKTP_edit;
        
    @FXML
    private TextField notelp_edit;
         
            
    @FXML
    private TextField password_edit;
      
    @FXML
    private ComboBox<String> jenisKelamin_combo;
    
     @FXML
    private void update_edit(ActionEvent event) {
        String nama = namaPetugas_edit.getText();
        String email = email_edit.getText();
        String noKTP = noKTP_edit.getText();
        String notelp= notelp_edit.getText();
        String password = password_edit.getText();
        String jenisKelamin = jenisKelamin_combo.getValue();
        
        
        System.out.println(nama);
        System.out.println(email);
        System.out.println(noKTP);
        System.out.println(notelp);
        System.out.println(password);
        System.out.println(jenisKelamin);
        
        
        
    }
     
     
    
}
