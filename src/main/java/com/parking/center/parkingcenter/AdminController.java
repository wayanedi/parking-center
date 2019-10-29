/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.parking.center.parkingcenter;

import com.parking.center.parkingcenter.DB.JenisKendaraanDAO;
import com.parking.center.parkingcenter.DB.PetugasDAO;
import com.parking.center.parkingcenter.DB.UserDAO;
import com.parking.center.parkingcenter.model.JenisKendaraanModel;
import com.parking.center.parkingcenter.model.PetugasModel;
import com.parking.center.parkingcenter.model.UserModel;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

/**
 * FXML Controller class
 *
 * @author yanedi
 */

   
        
public class AdminController implements Initializable {
   
    private static int petugasId;
    
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
    public TableView<JenisKendaraanModel> table_setup_parkir;
    
    @FXML
    public TableView<PetugasModel> table_daftar_staff;
    
    @FXML
    private TableColumn<PetugasModel, String> col_nama_pengguna;
    
    @FXML
    private TableColumn<PetugasModel, String> col_email;
    
    @FXML
    private TableColumn<PetugasModel, String> col_nomor_ktp;
    
    @FXML
    private TableColumn<PetugasModel, String> col_nomor_telp;
    
    @FXML
    private Label label_name;
    
    @FXML
    private TableColumn<PetugasModel, String> col_jenis_kelamin;
    
    @FXML
    private TableColumn<PetugasModel, Button> col_updateStaff;
    
    @FXML
    private TableColumn<PetugasModel, Button> col_hapusStaff;
//    @FXML
//    public static TableView<JenisKendaraanModel> table_setup_parkir2;

    @FXML
    private TableColumn<JenisKendaraanModel, Integer> col_harga_perhari;

    @FXML
    private TableColumn<JenisKendaraanModel, Integer> col_harga_perjam;

    @FXML
    private TableColumn<JenisKendaraanModel, Integer> col_harga_setengah;

    @FXML
    private TableColumn<JenisKendaraanModel, String> col_nama_kendaraan;

    @FXML
    private Label totalSlotParkir;
    
    @FXML
    private TableColumn<JenisKendaraanModel, Integer> col_slot;

    @FXML
    private TableColumn<JenisKendaraanModel, Button> col_update;
    
    @FXML
    private TableColumn<JenisKendaraanModel, Button> col_hapus;
    
    //========== selector input user ====================
    @FXML
    private ComboBox comboBox_role;
    public static ObservableList<JenisKendaraanModel> data;
    public static ObservableList<PetugasModel> petugas;
    
    PetugasModel petugasModel = new PetugasModel();
    
    @FXML
    private ComboBox comboBox_jenisKelamin;
    
    @FXML
    private Button button_addUser;
    
    @FXML
    private TextField textField_namaPetugas;
    
    @FXML
    private TextField textField_noKtp;
    
    @FXML
    private TextField textField_username;
    
    @FXML
    private TextField textField_password;
    
    @FXML
    private TextField textField_email;
    
    @FXML
    private TextField textField_nomorTelp;
    
    @FXML
    private Label label_nama;
    
    //===========fungsi untuk user management=================
    
        @FXML
    private void button_addUser(ActionEvent event) throws SQLException, ClassNotFoundException{
        
        String checkNum = "\\d+";
        int id = UserDAO.getId();
        id +=1;
        System.out.println("masuk");
        UserModel user = new UserModel();
        PetugasModel petugas = new PetugasModel();
        
        user.setPassword(textField_password.getText());
        user.setUsername(textField_username.getText());
        user.setRole(comboBox_role.getValue().toString());
        
        petugas.setEmail(textField_email.getText());
        petugas.setId_user(id);
        petugas.setJenis_kelamin(comboBox_jenisKelamin.getValue().toString());
        petugas.setNama_petugas(textField_namaPetugas.getText());
        petugas.setNo_ktp(textField_noKtp.getText());
        petugas.setNo_telp(textField_nomorTelp.getText());
        
        Alert alert;
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("User Management");
        
        if(textField_password.getText().isEmpty() || textField_username.getText().isEmpty() || 
                textField_email.getText().isEmpty() || textField_namaPetugas.getText().isEmpty() || !textField_noKtp.getText().matches(checkNum)
                || textField_nomorTelp.getText().matches(checkNum)){
            
            alert.setHeaderText(null);
            alert.setHeaderText("masukan format yang sesuai atau data tidak boleh kosong!");
            
        }
        else{
            UserDAO.insertUser(user);
            PetugasDAO.insertPetugas(petugas);
            
            alert.setHeaderText(null);
            alert.setHeaderText("Data berhasil dimasukan!");
        }
        
        alert.showAndWait();
    }
    
    
    //========== fungsi untuk setup parkir ===================
  
    
    @FXML
    private void refresh_data_setup(ActionEvent event) throws ClassNotFoundException, SQLException{
        data = JenisKendaraanDAO.getAlls();
        table_setup_parkir.setItems(data);
    }
 
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
            data = JenisKendaraanDAO.getAlls();
            table_setup_parkir.setItems(data);
        }
        alert.showAndWait();
    }
    
    private void initTable(){
        initCols();
    }
    private void initColsStaff() throws SQLException, ClassNotFoundException{
        
        col_nama_pengguna.setCellValueFactory(new PropertyValueFactory("nama_petugas"));
        col_email.setCellValueFactory(new PropertyValueFactory("email"));
        col_nomor_ktp.setCellValueFactory(new PropertyValueFactory("no_ktp"));
        col_nomor_telp.setCellValueFactory(new PropertyValueFactory("no_telp"));
        col_jenis_kelamin.setCellValueFactory(new PropertyValueFactory("jenis_kelamin"));
//        col_updateStaff.setCellValueFactory(new PropertyValueFactory("update"));
//        col_hapusStaff.setCellValueFactory(new PropertyValueFactory("delete"));
        
        
//        col_nama_pengguna.setCellFactory(TextFieldTableCell.forTableColumn());
//        col_email.setCellFactory(TextFieldTableCell.forTableColumn());
//        col_nomor_ktp.setCellFactory(TextFieldTableCell.forTableColumn());
//        col_nomor_telp.setCellFactory(TextFieldTableCell.forTableColumn());
//        col_jenis_kelamin.setCellFactory(TextFieldTableCell.forTableColumn());
        
        petugas = PetugasDAO.getAllData();
        table_daftar_staff.setItems(petugas);
        
    }
    
    @FXML
    private void namaPenggunaOnEdit(TableColumn.CellEditEvent<PetugasModel, String> cell){
        PetugasModel petugasmodel= table_daftar_staff.getSelectionModel().getSelectedItem();
        petugasmodel.setNama_petugas(cell.getNewValue());

        System.out.println("edited");
    }
    
    private void initCols(){
        col_nama_kendaraan.setCellValueFactory(new PropertyValueFactory("namaKendaraan"));
        col_harga_perjam.setCellValueFactory(new PropertyValueFactory("hargaPerJam"));
        col_harga_setengah.setCellValueFactory(new PropertyValueFactory("hargaPerSetHari"));
        col_harga_perhari.setCellValueFactory(new PropertyValueFactory("hargaPerHari"));
        col_slot.setCellValueFactory(new PropertyValueFactory("slot"));
        col_update.setCellValueFactory(new PropertyValueFactory("update"));
        col_hapus.setCellValueFactory(new PropertyValueFactory("delete"));
        
        col_nama_kendaraan.setCellFactory(TextFieldTableCell.forTableColumn());
        col_harga_perjam.setCellFactory(TextFieldTableCell.<JenisKendaraanModel, Integer>forTableColumn(new IntegerStringConverter()));
        col_harga_setengah.setCellFactory(TextFieldTableCell.<JenisKendaraanModel, Integer>forTableColumn(new IntegerStringConverter()));
        col_harga_perhari.setCellFactory(TextFieldTableCell.<JenisKendaraanModel, Integer>forTableColumn(new IntegerStringConverter()));
        col_slot.setCellFactory(TextFieldTableCell.<JenisKendaraanModel, Integer>forTableColumn(new IntegerStringConverter()));
//        col_nama_kendaraan.setCellValueFactory(new PropertyValueFactory("namaKendaraan"));
        
        
        try {
            data = JenisKendaraanDAO.getAlls();
            table_setup_parkir.setItems(data);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void namaKendaraanOnEdit(TableColumn.CellEditEvent<JenisKendaraanModel, String> cell){
        JenisKendaraanModel jenisKendaraanModel= table_setup_parkir.getSelectionModel().getSelectedItem();
        jenisKendaraanModel.setNamaKendaraan(cell.getNewValue());
    }
    
    @FXML
    private void hargaPerJamOnEdit(TableColumn.CellEditEvent<JenisKendaraanModel, Integer> cell){
        JenisKendaraanModel jenisKendaraanModel= table_setup_parkir.getSelectionModel().getSelectedItem();
        jenisKendaraanModel.setHargaPerJam(cell.getNewValue());
    }
    
    @FXML
    private void hargaPerHariOnEdit(TableColumn.CellEditEvent<JenisKendaraanModel, Integer> cell){
        JenisKendaraanModel jenisKendaraanModel= table_setup_parkir.getSelectionModel().getSelectedItem();
        jenisKendaraanModel.setHargaPerHari(cell.getNewValue());
    }
    
    @FXML
    private void slotOnEdit(TableColumn.CellEditEvent<JenisKendaraanModel, Integer> cell){
        JenisKendaraanModel jenisKendaraanModel= table_setup_parkir.getSelectionModel().getSelectedItem();
        jenisKendaraanModel.setSlot(cell.getNewValue());
    }
    
    @FXML
    private void hargaSetengahOnEdit(TableColumn.CellEditEvent<JenisKendaraanModel, Integer> cell){
        JenisKendaraanModel jenisKendaraanModel= table_setup_parkir.getSelectionModel().getSelectedItem();
        jenisKendaraanModel.setHargaPerSetHari(cell.getNewValue());
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
        table_setup_parkir.setEditable(true);
        int hasil=0;
        try {
            hasil = JenisKendaraanDAO.getTotalSlot();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        totalSlotParkir.setText(Integer.toString(hasil));
        try {
            this.petugasModel = PetugasDAO.selectPetugas(petugasId);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        jenisKelamin_combo.getItems().removeAll(jenisKelamin_combo.getItems());
        jenisKelamin_combo.getItems().addAll("Laki-Laki", "Perempuan");
        System.out.println("ini init"+petugasModel.getNama_petugas());
        if(petugasModel.getNama_petugas() != null) label_nama.setText(petugasModel.getNama_petugas());
        namaPetugas_edit.setText(petugasModel.getNama_petugas());
        email_edit.setText(petugasModel.getEmail());
        noKTP_edit.setText(petugasModel.getNo_ktp());
        notelp_edit.setText(petugasModel.getNo_telp());
        jenisKelamin_combo.getSelectionModel().select(petugasModel.getJenis_kelamin());
        table_daftar_staff.setEditable(true);

        initTable();
        try {
            initColsStaff();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // TODO
        
        kosongPane.setVisible(true);
        tambah_Staff.setVisible(false);
        setup_Parkir.setVisible(false);
        edit_profile_admin.setVisible(false);
        daftar_Staff.setVisible(false);
        
        comboBox_role.getItems().addAll("admin", "user");
        comboBox_role.setValue("user");
        comboBox_jenisKelamin.getItems().addAll("Laki-Laki", "Perempuan");
        comboBox_jenisKelamin.setValue("Perempuan");
        
        
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
    private void update_edit(ActionEvent event) throws SQLException, ClassNotFoundException {
        String nama = namaPetugas_edit.getText();
        String email = email_edit.getText();
        String noKTP = noKTP_edit.getText();
        String notelp= notelp_edit.getText();
        String password = password_edit.getText();
        String jenisKelamin = jenisKelamin_combo.getValue();
        
        PetugasDAO.updateUser(nama,email,noKTP,notelp,jenisKelamin,petugasId);
        
        System.out.println(nama);
        System.out.println(email);
        System.out.println(noKTP);
        System.out.println(notelp);
        System.out.println(password);
        System.out.println(jenisKelamin);
        
    }
    public void transferMessage(int id) {
        //Display the message
        this.petugasId=id;
    }
    
}
