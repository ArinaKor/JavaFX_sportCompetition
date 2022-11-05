package com.example.demo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ResultsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView image;

    @FXML
    private AnchorPane l5;
    @FXML
    Label txt1;
    @FXML
    Label lbl2;
    @FXML
    Label lbl3;

    @FXML
    void initialize() {
    }

    public void displayName1(String text) {
        txt1.setText("Первое место: " + text);
    }
    public void displayName2(String text2) {
        lbl2.setText("Второе место: " + text2);
    }
    public void displayName3(String text3) {
        lbl3.setText("Третье место: " + text3);
    }

}
