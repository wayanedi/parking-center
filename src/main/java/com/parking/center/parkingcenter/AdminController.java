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
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
    
    @FXML
    private TableView<JenisKendaraanModel> table_setup_parkir;

    @FXML
    private TableColumn<JenisKendaraanModel, Integer> col_harga_perhari;

    @FXML
    private TableColumn<JenisKendaraanModel, Integer> col_harga_perjam;

    @FXML
    private TableColumn<JenisKendaraanModel, Integer> col_harga_setengah;

    @FXML
    private TableColumn<JenisKendaraanModel, String> col_nama_kendaraan;

    @FXML
    private TableColumn<JenisKendaraanModel, Integer> col_slot;

    @FXML
    private TableColumn<JenisKendaraanModel, Button> col_update;
    
    @FXML
    private TableColumn<JenisKendaraanModel, Button> col_hapus;
    
    
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
            
//        System.out.println(nama);
//        System.out.println(txtSetengah);
//        System.out.println(txtPerHari);
//        System.out.println(txtSlot);
        
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
//            System.out.println(Integer.parseInt(txtPerJam));
            JenisKendaraanModel jenisKendaraanModel = new JenisKendaraanModel(nama, Integer.parseInt(txtPerJam), Integer.parseInt(txtSetengah), Integer.parseInt(txtPerHari), Integer.parseInt(txtSlot));
            JenisKendaraanDAO.insertJenisKendaraan(jenisKendaraanModel);
            alert.setHeaderText(null);
            alert.setHeaderText("Data berhasil dimasukan!");
        }
        alert.showAndWait();
    }
    
    private void initTable(){
        initCols();
    }
    
    private void initCols(){
        col_nama_kendaraan.setCellValueFactory(new PropertyValueFactory("namaKendaraan"));
        col_harga_perjam.setCellValueFactory(new PropertyValueFactory("hargaPerJam"));
        col_harga_setengah.setCellValueFactory(new PropertyValueFactory("hargaPerSetHari"));
        col_harga_perhari.setCellValueFactory(new PropertyValueFactory("hargaPerHari"));
        col_slot.setCellValueFactory(new PropertyValueFactory("slot"));
//        col_nama_kendaraan.setCellValueFactory(new PropertyValueFactory("namaKendaraan"));
//        col_nama_kendaraan.setCellValueFactory(new PropertyValueFactory("namaKendaraan"));
        
        ObservableList<JenisKendaraanModel> data;
        try {
            data = JenisKendaraanDAO.getAlls();
            table_setup_parkir.setItems(data);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    
//    private void editTableCols(){
//        
//    }
    
    
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
         initTable();
        
        kosongPane.setVisible(true);
        tambah_Staff.setVisible(false);
        setup_Parkir.setVisible(false);
        edit_profile_admin.setVisible(false);
        daftar_Staff.setVisible(false);
    }    

}
