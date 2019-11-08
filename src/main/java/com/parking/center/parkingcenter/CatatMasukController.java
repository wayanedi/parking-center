/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parking.center.parkingcenter;

import com.parking.center.parkingcenter.DB.JenisKendaraanDAO;
import com.parking.center.parkingcenter.DB.LaporanDAO;
import com.parking.center.parkingcenter.model.JenisKendaraanModel;
import com.parking.center.parkingcenter.model.SisaSlotModel;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    private ObservableList<SisaSlotModel> jenisKendaraanList;
            
    @FXML
    private ComboBox<String> cmb_jenisKendaraan;

    @FXML
    private TextField txt_plat;
    @FXML
    private Font x1;
    @FXML
    private Button catatBtn;
    
    private String checkSymbol = "\\W+";
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            jenisKendaraanList = LaporanDAO.getSisaSlot();
            for(int i=0;i<jenisKendaraanList.size();i++)
//                System.out.println(jenisKendaraanList.get(i).getNamaKendaraan());
                cmb_jenisKendaraan.getItems().add(jenisKendaraanList.get(i).getNamaKendaraan() + " - sisa"  +jenisKendaraanList.get(i).getSlot());
        } catch (SQLException ex) {
            Logger.getLogger(CatatMasukController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CatatMasukController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    

    @FXML
    private void addBtn(ActionEvent event) {
        Alert alert;
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Catat Masuk");
        if(txt_plat.getText().matches(checkSymbol)){
            alert.setHeaderText(null);
            alert.setContentText("Tidak boleh ada symbol!");
            alert.showAndWait();
        }
        else{
//            txt_plat.getText()
        }
    }
    
}
