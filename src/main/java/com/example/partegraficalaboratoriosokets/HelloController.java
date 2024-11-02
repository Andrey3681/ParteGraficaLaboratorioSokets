package com.example.partegraficalaboratoriosokets;
import com.example.partegraficalaboratoriosokets.sokets.JugadorSokets;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    private  int puerto=8081;
    private String host="localhost";
    JugadorSokets jugadorSokets;
    @FXML
    private void initialize(){
        jugadorSokets= new JugadorSokets();
        jugadorSokets.conectar(host,8081);


        System.out.println("se debio concectar al servidor en el puerto "+ puerto);
    }

    @FXML
    private TextField capturadorMensaje;

    @FXML
    private Label welcomeText;

    @FXML
    void enviarMensaje(ActionEvent event) {
        if(capturadorMensaje.getText()!=null&&!capturadorMensaje.getText().isBlank()){
            jugadorSokets.enviarMensaje(capturadorMensaje.getText());
            System.out.println("se ha enviado un mensaje ");
        }

    }

}
