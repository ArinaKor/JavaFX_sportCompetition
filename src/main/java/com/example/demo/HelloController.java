package com.example.demo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.*;

import client_server.Client;
import client_server.Server;
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
   // private Server server;
    //private Client client;
    @FXML
    void initialize() {
        assert l1 != null : "fx:id=\"l1\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert l2 != null : "fx:id=\"l2\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert l3 != null : "fx:id=\"l3\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert l4 != null : "fx:id=\"l4\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert submit != null : "fx:id=\"submit\" was not injected: check your FXML file 'hello-view.fxml'.";
       /* try{
            //server = new Server(new ServerSocket(2525));
            //client  = new Client(new Socket("localhost", 2525));
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("Error creating server!");
        }*/



    }

    public void login(ActionEvent event) throws IOException {
        HashMap<Integer, String> competitions = new HashMap<>();
        competitions.put(1, "Бубликова");
        competitions.put(2, "Серебряков");
        competitions.put(3, "Трамп");
        competitions.put(4, "Лукошкина");

        String username = l1.getText();
        String username1 = l2.getText();
        String username2 = l3.getText();
        String username3 = l4.getText();

        ArrayList<Integer> list = new ArrayList<>();
        list.add(Integer.valueOf(username));
        list.add(Integer.valueOf(username1));
        list.add(Integer.valueOf(username2));
        list.add(Integer.valueOf(username3));
        Collections.sort(list);
        Collections.reverse(list);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("second.fxml"));
        root = loader.load();
        ResultsController scene2Controller = loader.getController();

        TreeMap<Integer, String> competishions1 = new TreeMap<>(Collections.reverseOrder());
        competishions1.put(Integer.valueOf(username), "Бубликова");
        competishions1.put(Integer.valueOf(username1), "Серебряков");
        competishions1.put(Integer.valueOf(username2), "Трамп");
        competishions1.put(Integer.valueOf(username3), "Лукошкина");
        System.out.println(competishions1);

        scene2Controller.displayName1(competishions1.get(list.get(0)));
        scene2Controller.displayName2(competishions1.get(list.get(1)));
        scene2Controller.displayName3(competishions1.get(list.get(2)));
        /*scene2Controller.displayName1(list.get(0).toString());
        scene2Controller.displayName2(list.get(1).toString());
        scene2Controller.displayName3(list.get(2).toString());*/

        //root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }



}