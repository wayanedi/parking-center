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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

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
    
    
    @FXML
    private void btnCari(ActionEvent event) throws SQLException, ClassNotFoundException, ParseException{
        
        CatatKeluarModel catat = LaporanDAO.getLaporanKendaraan("abc");
        System.out.println(catat.getWaktuMasuk());
        
        Date date = sdf.parse(catat.getWaktuMasuk());
        
        Date now = new Date();
        
        int selisihTahun = Integer.parseInt(yy.format(now))-Integer.parseInt(yy.format(date));
        int selishBulan = Integer.parseInt(mm.format(now))-Integer.parseInt(mm.format(date)) + selisihTahun*12;
        int selisihHari = Integer.parseInt(dd.format(now))-Integer.parseInt(dd.format(date)) + selishBulan*30;
        
        int selisihJam = Integer.parseInt(hh.format(now))-Integer.parseInt(hh.format(date)) + selisihHari*24;
        int selisihMenit = Integer.parseInt(menit.format(now))-Integer.parseInt(menit.format(date))+ selisihJam*60;
        
        
        System.out.println(selisihHari);
        System.out.println(selisihJam);
        System.out.println(selisihMenit);
        
        double ceil = Math.ceil((double)selisihMenit/60);
        
        selisihJam = (int)ceil;
        
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
        
        CatatKeluarModel keluar = new CatatKeluarModel(sdf.format(now), harga);
        LaporanDAO.updateLaporan(keluar);
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
