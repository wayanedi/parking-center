/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parking.center.parkingcenter;

import com.parking.center.parkingcenter.DB.JenisKendaraanDAO;
import com.parking.center.parkingcenter.DB.LaporanAdminDAO;
import com.parking.center.parkingcenter.DB.PetugasDAO;
import com.parking.center.parkingcenter.DB.UserDAO;
import com.parking.center.parkingcenter.model.JenisKendaraanModel;
import com.parking.center.parkingcenter.model.KategoriModel;
import com.parking.center.parkingcenter.model.LaporanModel;
import com.parking.center.parkingcenter.model.PetugasModel;
import com.parking.center.parkingcenter.model.UserModel;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

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
    private TableColumn<PetugasModel, String> col_jenis_kelamin;

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
    private BorderPane borderPane;

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
    private Font x1;
    @FXML
    private Font x3;
    @FXML
    private Font x2;

    @FXML
    private void button_addUser(ActionEvent event) throws SQLException, ClassNotFoundException {

        String checkNum = "\\d+";
        int id = UserDAO.getId();
        id += 1;
        System.out.println("masuk");
        UserModel user = new UserModel();
        PetugasModel petugasModel = new PetugasModel();

        user.setPassword(textField_password.getText());
        user.setUsername(textField_username.getText());
        user.setRole(comboBox_role.getValue().toString());

        petugasModel.setEmail(textField_email.getText());
        petugasModel.setId_user(id);
        petugasModel.setJenis_kelamin(comboBox_jenisKelamin.getValue().toString());
        petugasModel.setNama_petugas(textField_namaPetugas.getText());
        petugasModel.setNo_ktp(textField_noKtp.getText());
        petugasModel.setNo_telp(textField_nomorTelp.getText());

        Alert alert;
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("User Management");

        if (textField_password.getText().isEmpty() || textField_username.getText().isEmpty()
                || textField_email.getText().isEmpty() || textField_namaPetugas.getText().isEmpty() || !textField_noKtp.getText().matches(checkNum)
                || !textField_nomorTelp.getText().matches(checkNum)) {

            alert.setHeaderText(null);
            alert.setHeaderText("masukan format yang sesuai atau data tidak boleh kosong!");

        } else {

            if (UserDAO.isExis(user.getUsername())) {

                alert.setHeaderText(null);
                alert.setHeaderText("usernane telah di gunakan, silahkan Gunakan username yang lain!");
                alert.showAndWait();
                return;
            }

            UserDAO.insertUser(user);
            PetugasDAO.insertPetugas(petugasModel);

            alert.setHeaderText(null);
            alert.setHeaderText("Data berhasil dimasukan!");
            petugas = PetugasDAO.getAllData();
            table_daftar_staff.setItems(petugas);

        }

        alert.showAndWait();
    }

    //========== fungsi untuk setup parkir ===================
    @FXML
    private void refresh_data_setup(ActionEvent event) throws ClassNotFoundException, SQLException {
        data = JenisKendaraanDAO.getAlls();
        table_setup_parkir.setItems(data);

        int hasil = 0;
        try {
            hasil = JenisKendaraanDAO.getTotalSlot();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        totalSlotParkir.setText(Integer.toString(hasil));
    }

    @FXML
    private void addSetupParkir(ActionEvent event) throws ClassNotFoundException, SQLException {
        String nama = namaKendaraan.getText();
        String txtPerJam = hargaPerjam.getText();
        String txtSetengah = hargaSetengah.getText();
        String txtPerHari = hargaPerhari.getText();
        String txtSlot = slotParkir.getText();

        boolean perJam = true;
        boolean perSetengah = true;
        boolean perHari = true;
        boolean slot = true;

        Alert alert;
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Setup Information");

//        System.out.println(nama);
//        System.out.println(txtSetengah);
//        System.out.println(txtPerHari);
//        System.out.println(txtSlot);
        String checkNum = "\\d+";

        if (!txtPerJam.matches(checkNum)) {
            perJam = false;
            System.out.println("format1 salah");
        }

        if (!txtSetengah.matches(checkNum)) {
            perSetengah = false;
            System.out.println("format2 salah");
        }

        if (!txtPerHari.matches(checkNum)) {
            perHari = false;
            System.out.println("format3 salah");
        }

        if (!txtSlot.matches(checkNum)) {
            slot = false;
            System.out.println("format4 salah");
        }

        if (!perJam && !perSetengah && !perHari && !slot) {
            alert.setHeaderText(null);
            alert.setContentText("Format harga atau slot parkir harus berupa angka dan tidak boleh kosong!");
        } else {
//            System.out.println(Integer.parseInt(txtPerJam));
            JenisKendaraanModel jenisKendaraanModel = new JenisKendaraanModel(nama, Integer.parseInt(txtPerJam), Integer.parseInt(txtSetengah), Integer.parseInt(txtPerHari), Integer.parseInt(txtSlot));
            JenisKendaraanDAO.insertJenisKendaraan(jenisKendaraanModel);
            alert.setHeaderText(null);
            alert.setHeaderText("Data berhasil dimasukan!");
            data = JenisKendaraanDAO.getAlls();
            table_setup_parkir.setItems(data);
            
            int hasil = 0;
            try {
                hasil = JenisKendaraanDAO.getTotalSlot();
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
            totalSlotParkir.setText(Integer.toString(hasil));
        }
        alert.showAndWait();
    }

    private void initTable() {
        initCols();
    }
    public static int TOTAL=0;
    private void initColsStaff() throws SQLException, ClassNotFoundException {

        col_nama_pengguna.setCellValueFactory(new PropertyValueFactory("nama_petugas"));
        col_email.setCellValueFactory(new PropertyValueFactory("email"));
        col_nomor_ktp.setCellValueFactory(new PropertyValueFactory("no_ktp"));
        col_nomor_telp.setCellValueFactory(new PropertyValueFactory("no_telp"));
        col_jenis_kelamin.setCellValueFactory(new PropertyValueFactory("jenis_kelamin"));
//        col_updateStaff.setCellValueFactory(new PropertyValueFactory("update"));
//        col_hapusStaff.setCellValueFactory(new PropertyValueFactory("delete"));

        col_nama_pengguna.setCellFactory(TextFieldTableCell.forTableColumn());
        col_email.setCellFactory(TextFieldTableCell.forTableColumn());
        col_nomor_ktp.setCellFactory(TextFieldTableCell.forTableColumn());
        col_nomor_telp.setCellFactory(TextFieldTableCell.forTableColumn());
        col_jenis_kelamin.setCellFactory(TextFieldTableCell.forTableColumn());

        petugas = PetugasDAO.getAllData();
        table_daftar_staff.setItems(petugas);

    }

    private void namaPenggunaOnEdit(TableColumn.CellEditEvent<PetugasModel, String> cell) {
        PetugasModel petugasmodel = table_daftar_staff.getSelectionModel().getSelectedItem();
        petugasmodel.setNama_petugas(cell.getNewValue());

        System.out.println("edited");
    }

    private void initCols() {
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

    private void namaKendaraanOnEdit(TableColumn.CellEditEvent<JenisKendaraanModel, String> cell) {
        JenisKendaraanModel jenisKendaraanModel = table_setup_parkir.getSelectionModel().getSelectedItem();
        jenisKendaraanModel.setNamaKendaraan(cell.getNewValue());
    }

    private void hargaPerJamOnEdit(TableColumn.CellEditEvent<JenisKendaraanModel, Integer> cell) {
        JenisKendaraanModel jenisKendaraanModel = table_setup_parkir.getSelectionModel().getSelectedItem();
        jenisKendaraanModel.setHargaPerJam(cell.getNewValue());
    }

    private void hargaPerHariOnEdit(TableColumn.CellEditEvent<JenisKendaraanModel, Integer> cell) {
        JenisKendaraanModel jenisKendaraanModel = table_setup_parkir.getSelectionModel().getSelectedItem();
        jenisKendaraanModel.setHargaPerHari(cell.getNewValue());
    }

    private void slotOnEdit(TableColumn.CellEditEvent<JenisKendaraanModel, Integer> cell) {
        JenisKendaraanModel jenisKendaraanModel = table_setup_parkir.getSelectionModel().getSelectedItem();
        jenisKendaraanModel.setSlot(cell.getNewValue());
    }

    private void hargaSetengahOnEdit(TableColumn.CellEditEvent<JenisKendaraanModel, Integer> cell) {
        JenisKendaraanModel jenisKendaraanModel = table_setup_parkir.getSelectionModel().getSelectedItem();
        jenisKendaraanModel.setHargaPerSetHari(cell.getNewValue());
    }

    //============== batas untuk fungsi bagian setup parkir ================
    @FXML
    private void addStaff(ActionEvent event) {
        kosongPane.setVisible(false);
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
        kosongPane.setVisible(false);
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
        kosongPane.setVisible(false);
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
        kosongPane.setVisible(false);
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
        kosongPane.setVisible(true);
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

    @FXML
    public ComboBox combokategori;

    @FXML
    public DatePicker dateFrom;

    @FXML
    public DatePicker dateTo;

    @FXML
    public ComboBox id_laporan_cmb_kategori;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dateFrom.setConverter(new StringConverter<LocalDate>() {
            private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            @Override
            public String toString(LocalDate localDate) {
                if (localDate == null) {
                    return "";
                }
                return dateTimeFormatter.format(localDate);
            }

            @Override
            public LocalDate fromString(String dateString) {
                if (dateString == null || dateString.trim().isEmpty()) {
                    return null;
                }
                return LocalDate.parse(dateString, dateTimeFormatter);
            }
        });

        dateTo.setConverter(new StringConverter<LocalDate>() {
            private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            @Override
            public String toString(LocalDate localDate) {
                if (localDate == null) {
                    return "";
                }
                return dateTimeFormatter.format(localDate);
            }

            @Override
            public LocalDate fromString(String dateString) {
                if (dateString == null || dateString.trim().isEmpty()) {
                    return null;
                }
                return LocalDate.parse(dateString, dateTimeFormatter);
            }
        });

        try {
            ObservableList<KategoriModel> kategoriModel = LaporanAdminDAO.getKategori();
            combokategori.getItems().add("");
            id_laporan_cmb_kategori.getItems().add("");
            for (int i = 0; i < kategoriModel.size(); i++) {
                combokategori.getItems().add(kategoriModel.get(i).getNamaKendaraan());
                id_laporan_cmb_kategori.getItems().add(kategoriModel.get(i).getId());
            }
            id_laporan_cmb_kategori.getSelectionModel().select(0);
            combokategori.getSelectionModel().select(0);
            id_laporan_cmb_kategori.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }

        table_setup_parkir.setEditable(true);
        int hasil = 0;
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
        System.out.println("ini init" + petugasModel.getNama_petugas());
        if (petugasModel.getNama_petugas() != null) {
            label_nama.setText(petugasModel.getNama_petugas());
        }
        namaPetugas_edit.setText(petugasModel.getNama_petugas());
        email_edit.setText(petugasModel.getEmail());
        noKTP_edit.setText(petugasModel.getNo_ktp());
        notelp_edit.setText(petugasModel.getNo_telp());
        jenisKelamin_combo.getSelectionModel().select(petugasModel.getJenis_kelamin());
        table_daftar_staff.setEditable(false);

        initTable();
        try {
            initColsStaff();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }

        // TODO
        kosongPane.setVisible(false);
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
    private ComboBox<String> jenisKelamin_combo;

    @FXML
    private void update_edit(ActionEvent event) throws SQLException, ClassNotFoundException {
        String nama = namaPetugas_edit.getText();
        String email = email_edit.getText();
        String noKTP = noKTP_edit.getText();
        String notelp = notelp_edit.getText();
        String jenisKelamin = jenisKelamin_combo.getValue();

        PetugasDAO.updateUser(nama, email, noKTP, notelp, jenisKelamin, petugasId);

        System.out.println(nama);
        System.out.println(email);
        System.out.println(noKTP);
        System.out.println(notelp);
        System.out.println(jenisKelamin);

    }

    public void transferMessage(int id) {
        //Display the message
        this.petugasId = id;
    }

    //===============================================================================================
    @FXML
    public TableView<LaporanModel> tableLaporan;

    @FXML
    private TableColumn<LaporanModel, String> col_lap_nama_kendaraan;

    @FXML
    private TableColumn<LaporanModel, String> col_lap_plat;

    @FXML
    private TableColumn<LaporanModel, String> col_lap_nama_petugas;

    @FXML
    private TableColumn<LaporanModel, String> col_lap_jenis_kendaraan;

    @FXML
    private TableColumn<LaporanModel, String> col_lap_waktu_masuk;

    @FXML
    private TableColumn<LaporanModel, String> col_lap_waktu_keluar;

    @FXML
    private TableColumn<LaporanModel, Integer> col_lap_total_harga;
    int idx;

    @FXML
    private Label labelPendapatan;

    public void kategoriOnChangeLaporan(ActionEvent event) {
        idx = combokategori.getSelectionModel().getSelectedIndex();
        id_laporan_cmb_kategori.getSelectionModel().select(idx);

    }
    
    public void saveDataToExcel(ActionEvent event) throws IOException{
        
        if(tableLaporan.getItems().size() ==0){
            
            Alert alert;
            alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Save File Warning !");
            alert.setHeaderText(null);
            alert.setContentText("No Data in Table View");
            alert.showAndWait();
            
            return;
            
        }
        
        LaporanModel laporan = new LaporanModel();
        
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet spreadsheet = workbook.createSheet("creation_from_fx");

        HSSFRow row = spreadsheet.createRow(0);
        HSSFCell cell;

        cell = row.createCell(1);
        cell.setCellValue("Nama Kendaraan");
        cell = row.createCell(2);
        cell.setCellValue("Plat Nomor");
        cell = row.createCell(3);
        cell.setCellValue("Nama Petugas");
        cell = row.createCell(4);
        cell.setCellValue("Jenis Kendaraan");
        cell = row.createCell(5);
        cell.setCellValue("Waktu Masuk");
        cell = row.createCell(6);
        cell.setCellValue("Waktu Keluar");
        cell = row.createCell(7);
        cell.setCellValue("Total Harga");
        
        int total = 0;
        for(int i=0; i<tableLaporan.getItems().size();i++){
            
            laporan = tableLaporan.getItems().get(i);
            row = spreadsheet.createRow(i+1);
            cell = row.createCell(1);
            cell.setCellValue(laporan.getNamaKendaraan());
            cell = row.createCell(2);
            cell.setCellValue(laporan.getPlatNomor());
            cell = row.createCell(3);
            cell.setCellValue(laporan.getNamaPetugas());
            cell = row.createCell(4);
            cell.setCellValue(laporan.getJenisKendaraan());
            cell = row.createCell(5);
            cell.setCellValue(laporan.getWaktuMasuk());
            cell = row.createCell(6);
            cell.setCellValue(laporan.getWaktuKeluar());
            cell = row.createCell(7);
            cell.setCellValue(laporan.getTotalHarga());
            total+=laporan.getTotalHarga();
            
        }
        
        int idx = tableLaporan.getItems().size()+1;
        
        row = spreadsheet.createRow(idx);
        
        cell = row.createCell(6);
        cell.setCellValue("Total Pendapatan");
        cell = row.createCell(7);
        cell.setCellValue(total);
        
        try (FileOutputStream out = new FileOutputStream(new File("laporanParkingCenter.xls"))) {
            workbook.write(out);
            Alert alert;
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Save File Information");
            alert.setHeaderText(null);
            alert.setContentText("Save Success !");
            alert.showAndWait();
        }
        
        
    }

    public void getDataLaporan(ActionEvent event) {
        System.out.println(dateFrom.toString());
        System.out.println(idx);
        try {
            initTableLaporan();
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initTableLaporan() throws SQLException, ClassNotFoundException {
        initColsInfoLaporan();
    }

    private void initColsInfoLaporan() throws SQLException, ClassNotFoundException {
        col_lap_nama_kendaraan.setCellValueFactory(new PropertyValueFactory("namaKendaraan"));
        col_lap_nama_petugas.setCellValueFactory(new PropertyValueFactory("namaPetugas"));
        col_lap_plat.setCellValueFactory(new PropertyValueFactory("platNomor"));
        col_lap_jenis_kendaraan.setCellValueFactory(new PropertyValueFactory("jenisKendaraan"));
        col_lap_waktu_keluar.setCellValueFactory(new PropertyValueFactory("waktuKeluar"));
        col_lap_waktu_masuk.setCellValueFactory(new PropertyValueFactory("waktuMasuk"));
        col_lap_total_harga.setCellValueFactory(new PropertyValueFactory("totalHarga"));
//        SimpleDateFormat sm = new SimpleDateFormat("MM-dd-yyyy");
//        String strDate = sm.format(dateFrom.getValue().toString());
//        System.out.println(dateFrom.getValue().toString().replaceAll("-", "/"));
//         System.out.println(dateFrom.getValue().toString());
        String dateDari = "";
        String dateKe = "";
        
        try {
            dateKe = convertDate(dateTo.getValue().toString());
            dateDari = convertDate(dateFrom.getValue().toString());
            
        } catch (Exception e) {
            System.out.println("error");
            Alert alert;
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Laporan");
            alert.setHeaderText("Tanggal masih kosong!");
            alert.showAndWait();
        }
        
        int a =  dateDari.compareTo(dateKe);
        
        if(a>0){
            Alert alert;
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Laporan");
            alert.setHeaderText("Tanggal tidak valid!");
            alert.showAndWait();
        }
        else{
        ObservableList<LaporanModel> laporanModel = null;
        try {
            this.TOTAL=0;
            if (combokategori.getSelectionModel().getSelectedItem().toString().equals("")) {
                laporanModel = LaporanAdminDAO.getAllLaporan(dateDari, dateKe);
            } else if (!combokategori.getSelectionModel().getSelectedItem().toString().isEmpty()) {
                laporanModel = LaporanAdminDAO.getLaporanKategori(dateDari, dateKe, Integer.parseInt(id_laporan_cmb_kategori.getSelectionModel().getSelectedItem().toString()));
            }

            labelPendapatan.setText(Integer.toString(TOTAL));
            tableLaporan.setItems(laporanModel);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(InformasiSlotController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }

    private String convertDate(String d) {
        if (d.isEmpty()) {
            return "0";
        } else {

            String[] date = d.split("-");
            String year = date[0];
            String month = date[1];
            String day = date[2];

            return year + "/" + month + "/" + day;
        }
    }
}
