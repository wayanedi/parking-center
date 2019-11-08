package com.parking.center.parkingcenter;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class MainApp extends Application {
    private double x,y;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
        root.setFocusTraversable(true);
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        root.setOnMousePressed(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                x=event.getSceneX();
                y=event.getSceneY();
            }
        });
        
//        root.setOnMouseDragged(new EventHandler<MouseEvent>(){
//            @Override
//            public void handle(MouseEvent event){
//                stage.setX(event.getSceneX()-x);
//                stage.setY(event.getSceneY()-y);
//            }
//        });
//        stage.initStyle(StageStyle.TRANSPARENT);
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
