package com.example.demo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelloController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField l1;

    @FXML
    private TextField l2;

    @FXML
    private TextField l3;

    @FXML
    private TextField l4;

    @FXML
    private Button submit;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void initialize() {
        assert l1 != null : "fx:id=\"l1\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert l2 != null : "fx:id=\"l2\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert l3 != null : "fx:id=\"l3\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert l4 != null : "fx:id=\"l4\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert submit != null : "fx:id=\"submit\" was not injected: check your FXML file 'hello-view.fxml'.";



    }
    /*
    public void switchToScene2(ActionEvent event) throws IOException {
       String text = l1.getText();
        System.out.println(text);
        Parent root = FXMLLoader.load(getClass().getResource("second.fxml"));
        ResultsController resultsController = new ResultsController();


        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        stage.show();
    }*/
    public void login(ActionEvent event) throws IOException {

        String username = l1.getText();
        String username1 = l2.getText();
        String username2 = l3.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("second.fxml"));
        root = loader.load();

        ResultsController scene2Controller = loader.getController();
        scene2Controller.displayName1(username);
        scene2Controller.displayName2(username1);
        scene2Controller.displayName3(username2);

        //root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }



}