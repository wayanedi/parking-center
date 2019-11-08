/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parking.center.parkingcenter;

import com.parking.center.parkingcenter.DB.JenisKendaraanDAO;
import com.parking.center.parkingcenter.model.JenisKendaraanModel;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

    private ArrayList<JenisKendaraanModel> jenisKendaraanList = new ArrayList<JenisKendaraanModel>(); 
            
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
            jenisKendaraanList = JenisKendaraanDAO.getAllData();
            for(int i=0;i<jenisKendaraanList.size();i++)
            cmb_jenisKendaraan.getItems().add(jenisKendaraanList.get(i).getNamaKendaraan());
        } catch (SQLException ex) {
            Logger.getLogger(CatatMasukController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CatatMasukController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    

    @FXML
    private void addBtn(ActionEvent event) {
        if(txt_plat.getText().matches(checkSymbol))System.out.println("ada symbol");
        else System.out.println("tidak ada symbol");
    }
    
}
