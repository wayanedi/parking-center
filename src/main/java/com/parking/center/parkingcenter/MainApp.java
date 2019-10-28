package com.parking.center.parkingcenter;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class MainApp extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Parking Center");
        stage.setScene(scene);
        stage.setResizable(false);
//        stage.initStyle(StageStyle.UTILITY);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
