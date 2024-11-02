package com.example.partegraficalaboratoriosokets.sokets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class JugadorSokets implements Runnable{

    private Socket socket;
    private ObjectOutputStream salida;
    private ObjectInputStream entrada;
    @Override
    public void run() {
        System.out.println("inicioo esto");
        try {
            while (true){
                Object object= entrada.readObject();
                System.out.println("esperando un objeto....");
                if(object instanceof String){
                    String respuesta= (String) object;
                    System.out.println("el mensaje que me llego es: "+ respuesta);
                }
            }
        } catch (IOException e) {
           e.getMessage();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void conectar(String servidorHost, int puertoServidor) {
        try {
            socket = new Socket(servidorHost, puertoServidor);
            salida = new ObjectOutputStream(socket.getOutputStream());
            entrada = new ObjectInputStream(socket.getInputStream());
            new Thread(this).start(); //para activar el metodo run que se encarga de recibir los mensajes del servidor
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cerrarConexion() {
        try {
            if (entrada != null) entrada.close();
            if (salida != null) salida.close();
            if (socket != null) socket.close();
            System.out.println("Se desconectó del servidor");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void enviarMensaje(String mensaje){
        try {
            salida.writeObject(mensaje);
            salida.flush();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
