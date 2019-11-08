package com.parking.center.parkingcenter;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.parking.center.parkingcenter.DB.LaporanDAO;
import com.parking.center.parkingcenter.model.LaporanModel;
import com.parking.center.parkingcenter.model.PetugasModel;
import com.parking.center.parkingcenter.model.SisaSlotModel;
import com.sun.istack.internal.logging.Logger;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

/**
 * FXML Controller class
 *
 * @author rut febrianty
 */
public class InformasiSlotController implements Initializable {

    ObservableList<SisaSlotModel> sisaSlotModel;
    @FXML
    private TableView<SisaSlotModel> tabel_info;
    
    @FXML
    private TableColumn<SisaSlotModel,String> jenis_info;
    @FXML
    private TableColumn <SisaSlotModel,Integer> sisa_slot;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            initTable();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(InformasiSlotController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InformasiSlotController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    
   
   
    private void initTable() throws SQLException, ClassNotFoundException{
        initColsInfo();
    }
        
    private void initColsInfo() throws SQLException,ClassNotFoundException{
  
            jenis_info.setCellValueFactory(new PropertyValueFactory("namaKendaraan"));
            sisa_slot.setCellValueFactory(new PropertyValueFactory("slot"));
            
            jenis_info.setCellFactory(TextFieldTableCell.forTableColumn());
//            sisa_slot.setCellFactory(TextFieldTableCell.forTableColumn());
            
            
            
            //tabel_info.setItems(sisaSlotModel);
            
            
        try {
            sisaSlotModel = LaporanDAO.getSisaSlot();
            System.out.println(sisaSlotModel.size());;
            tabel_info.setItems(sisaSlotModel);
        } catch (SQLException | ClassNotFoundException ex) {
           // Logger.getLogger(InformasiSlotController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
            
            
     }

 
    
}
