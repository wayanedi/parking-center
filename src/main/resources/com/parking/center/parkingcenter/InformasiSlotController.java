/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parking.center.parkingcenter;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author rut febrianty
 */
public class InformasiSlotController implements Initializable {

    @FXML
    private TableView<?> tabel_info;
    @FXML
    private TableColumn<?, ?> no_info;
    @FXML
    private TableColumn<?, ?> jenis_info;
    @FXML
    private TableColumn<?, ?> sisa_slot;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
