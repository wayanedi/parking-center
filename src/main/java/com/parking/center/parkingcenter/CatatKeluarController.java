/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parking.center.parkingcenter;

import com.parking.center.parkingcenter.DB.LaporanDAO;
import com.parking.center.parkingcenter.model.CatatKeluarModel;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class CatatKeluarController implements Initializable {
    
    private static final DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private static final DateFormat dd = new SimpleDateFormat("dd");
    private static final DateFormat mm = new SimpleDateFormat("MM");
    private static final DateFormat yy = new SimpleDateFormat("yyyy");
    private static final DateFormat hh = new SimpleDateFormat("HH");
    private static final DateFormat menit = new SimpleDateFormat("mm");
    
    private CatatKeluarModel catat;
    
    @FXML
    private Label jenisKendaraan;
    
    @FXML
    private TextField textFieldPlatNomor;
    
    @FXML
    private Label labelTotalHarga;
    
    @FXML
    private TextField textFieldBayar;
    
     @FXML
    private TextField fieldbayar;
     
     @FXML
     private Label textFieldkembalian;
     
     @FXML
    void btnCatatKeluar(ActionEvent event) throws SQLException, ClassNotFoundException {
        
        Alert alert;
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("catat keluar");
        alert.setHeaderText(null);
        if(textFieldkembalian.getText().toString().equals("-")){
            alert.setContentText("silahkan input nominal uang pembayaran");
        }
        else if(Integer.parseInt(textFieldkembalian.getText().toString())>=0){
            
            LaporanDAO.updateLaporan(catat);
            jenisKendaraan.setText("-");
            textFieldPlatNomor.setText("");
            fieldbayar.setText("");
            labelTotalHarga.setText("-");
            textFieldkembalian.setText("-");
            alert.setContentText("berhasil");
        }
        else{

            alert.setContentText("uang tidak cukup");

        }
        
        alert.showAndWait();
    }
     
    @FXML
    private void btnCari(ActionEvent event) throws SQLException, ClassNotFoundException, ParseException{
        
        catat = LaporanDAO.getLaporanKendaraan(textFieldPlatNomor.getText().trim().toUpperCase());
        
        if(catat == null){
            Alert alert;
            alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("search Information");
            alert.setHeaderText(null);
            alert.setContentText("plat nomor tidak ditemukan");
            alert.showAndWait();
            return;
        }
        System.out.println(catat.getWaktuMasuk());
        jenisKendaraan.setText(catat.getJenisKendaraan());
        
        Date date = sdf.parse(catat.getWaktuMasuk());
        
        Date now = new Date();
        
        int selisihTahun = Integer.parseInt(yy.format(now))-Integer.parseInt(yy.format(date));
        int selishBulan = Integer.parseInt(mm.format(now))-Integer.parseInt(mm.format(date)) + selisihTahun*12;
        int selisihHari = Integer.parseInt(dd.format(now))-Integer.parseInt(dd.format(date)) + selishBulan*30;
        
        int selisihJam = Integer.parseInt(hh.format(now))-Integer.parseInt(hh.format(date)) + selisihHari*24;
        int selisihMenit = Integer.parseInt(menit.format(now))-Integer.parseInt(menit.format(date))+ selisihJam*60;
        
        
        System.out.println("seliih hari " + selisihHari);
        System.out.println("seliih jam " +selisihJam);
        System.out.println("seliih menit " +selisihMenit);
        
        double ceil = Math.ceil((double)selisihMenit/60);
        
        selisihJam = (int)ceil;
        if(selisihJam ==0) selisihJam=1;
        System.out.println(selisihJam);
        
        int harga = 0;
        if(selisihHari > 0){
            
            harga = selisihHari * catat.getHargaPerhari();
            
        }
        else if(selisihJam >=12){
            
            harga = catat.getHargaSetHari();
            
        }
        else{
            
            harga = selisihJam * catat.getHargaperjam();
        }
        
        
        System.out.println("harga: " + harga);
        labelTotalHarga.setText(Integer.toString(harga));
        catat = new CatatKeluarModel(sdf.format(now), harga);

    }

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        fieldbayar.textProperty().addListener((ObservableValue<? extends String> observableValue, String s, String s2) -> {
            if (!s2.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                fieldbayar.setText(s);
            }
            else{
                if(labelTotalHarga.getText().toString().equals("-")){
                    
                    Alert alert;
                    alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("catat keluar");
                    alert.setHeaderText(null);
                    alert.setContentText("silahkan masukan plat nomor yang benar");
                    alert.showAndWait();
                    return;
            
                }
                if(!fieldbayar.getText().isEmpty() && !fieldbayar.getText().equals("")){
                    int bayar = Integer.parseInt(fieldbayar.getText().toString());
                    int harga = Integer.parseInt(labelTotalHarga.getText().toString());
                    int kembalian = bayar - harga;

                    textFieldkembalian.setText(Integer.toString(kembalian));
                }
                
            }
        });
        // TODO
    }    
    
}
