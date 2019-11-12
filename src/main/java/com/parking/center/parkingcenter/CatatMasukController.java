/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parking.center.parkingcenter;

import com.parking.center.parkingcenter.DB.JenisKendaraanDAO;
import com.parking.center.parkingcenter.DB.LaporanDAO;
import com.parking.center.parkingcenter.model.JenisKendaraanModel;
import com.parking.center.parkingcenter.model.LaporanModel;
import com.parking.center.parkingcenter.model.SisaSlotModel;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class CatatMasukController implements Initializable {
    private static int petugasId;
    private ObservableList<SisaSlotModel> jenisKendaraanList;
            
    @FXML
    private ComboBox cmb_jenisKendaraan;

    @FXML
    private TextField txt_plat;
    @FXML
    private Font x1;
    @FXML
    private Button catatBtn;
    
    private String checkSymbol = "\\W+";
    @FXML
    private ComboBox id_jenis;
    
    private static final DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    @FXML
    private ComboBox slotParkir;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        clearComboItem();
        isiComboItem();
        slotParkir.setVisible(false);
        System.out.println(UserController.petugasId);
    }    

    @FXML
    private void addBtn(ActionEvent event) throws SQLException, ClassNotFoundException {
        Alert alert;
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Catat Masuk");
        if(txt_plat.getText().isEmpty() || cmb_jenisKendaraan.getSelectionModel().isEmpty()){
            alert.setHeaderText(null);
            alert.setContentText("Plat nomor atau jenis kendaraan tidak boleh kosong!");
            alert.showAndWait();
        }
        else if(Pattern.matches(checkSymbol, txt_plat.getText().toString())|| txt_plat.getText().isEmpty()){
            alert.setHeaderText(null);
            alert.setContentText("Plat nomor tidak boleh kosong atau ada symbol!");
            alert.showAndWait();
        }else if(Integer.parseInt(slotParkir.getSelectionModel().getSelectedItem().toString()) <1){
            alert.setHeaderText(null);
            alert.setContentText("Slot tidak tersedia");
            alert.showAndWait();
        }
        else{
            LaporanModel laporanModel = new LaporanModel();
            laporanModel.setJenisKendaraan(id_jenis.getSelectionModel().getSelectedItem().toString());
            laporanModel.setPlatNomor(txt_plat.getText());
            Date date = new Date();
            System.out.println(sdf.format(date));
            laporanModel.setWaktuMasuk(sdf.format(date));
            LaporanDAO.insertLaporan(laporanModel, UserController.petugasId);
            clearComboItem();
            isiComboItem();

//            txt_plat.getText()
        }
    }
    
    private void isiComboItem(){
        id_jenis.setVisible(false);
        try {
            jenisKendaraanList = LaporanDAO.getSisaSlot();
            System.out.println(jenisKendaraanList.size());
            for(int i=0;i<jenisKendaraanList.size();i++){
                cmb_jenisKendaraan.getItems().add(jenisKendaraanList.get(i).getNamaKendaraan() + " - sisa "  +jenisKendaraanList.get(i).getSlot());
                System.out.println(jenisKendaraanList.get(i).getNamaKendaraan());
                id_jenis.getItems().add(jenisKendaraanList.get(i).getId());
                slotParkir.getItems().add(jenisKendaraanList.get(i).getSlot());
            }
                
        } catch (SQLException ex) {
            Logger.getLogger(CatatMasukController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CatatMasukController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void clearComboItem(){
        cmb_jenisKendaraan.getItems().clear();
        id_jenis.getItems().clear();
        slotParkir.getItems().clear();
    }

    @FXML
    private void selected(ActionEvent event) {
        int idx= cmb_jenisKendaraan.getSelectionModel().getSelectedIndex();
        id_jenis.getSelectionModel().select(idx);
        slotParkir.getSelectionModel().select(idx);
    }
    
    public void getData(int id){
        this.petugasId=id;
    }
    
}
