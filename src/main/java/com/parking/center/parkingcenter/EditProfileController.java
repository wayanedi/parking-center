package com.parking.center.parkingcenter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.parking.center.parkingcenter.DB.PetugasDAO;
import com.parking.center.parkingcenter.model.PetugasModel;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class EditProfileController implements Initializable {

    @FXML
    private Font x1;
    @FXML
    private TextField nama_edit;
    @FXML
    private TextField username_edit;
    @FXML
    private TextField password_edit;
    @FXML
    private TextField email_edit;
    @FXML
    private TextField noktp_edit;
    @FXML
    private TextField notelp_edit;
    @FXML
    private ComboBox jeniskelamin_combo;
    @FXML
    private Button btn_simpan;
    
    private PetugasModel petugasModel;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            this.petugasModel = PetugasDAO.selectPetugas(UserController.petugasId);
        } catch (SQLException ex) {
            Logger.getLogger(EditProfileController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }
        jeniskelamin_combo.getItems().removeAll(jeniskelamin_combo.getItems());
        jeniskelamin_combo.getItems().addAll("Laki-Laki", "Perempuan");
        System.out.println("ini init"+petugasModel.getNama_petugas());
        nama_edit.setText(petugasModel.getNama_petugas());
        email_edit.setText(petugasModel.getEmail());
        noktp_edit.setText(petugasModel.getNo_ktp());
        notelp_edit.setText(petugasModel.getNo_telp());
        jeniskelamin_combo.getSelectionModel().select(petugasModel.getJenis_kelamin());
    }    

    @FXML
    private void onUpdate(ActionEvent event) {
        
        String nama = nama_edit.getText();
        String email = email_edit.getText();
        String noKTP = noktp_edit.getText();
        String notelp= notelp_edit.getText();
        String jeniskelamin = jeniskelamin_combo.getValue().toString();
        
        try {
            PetugasDAO.updateUser(nama,email,noKTP,notelp,jeniskelamin,UserController.petugasId);
            Alert alert;
            alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Update Information");
            alert.setHeaderText(null);
            alert.setContentText("Update Success !");
            alert.showAndWait();
        } catch (SQLException ex) {
            Logger.getLogger(EditProfileController.class.getName()).log(Level.SEVERE, null, ex);
            Alert alert;
            alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Update Information");
            alert.setHeaderText(null);
            alert.setContentText("Update failed !");
            alert.showAndWait();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditProfileController.class.getName()).log(Level.SEVERE, null, ex);
            Alert alert;
            alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Update Information");
            alert.setHeaderText(null);
            alert.setContentText("Update failed !");
            alert.showAndWait();
        }
    }
    
}
