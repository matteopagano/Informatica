/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author matteo.pagano
 */
public class Client extends Application {
	DatagramSocket client;
	@Override
	public void start(Stage stage) throws Exception {
		initComponents(stage);
		client= new DatagramSocket();
		client.connect(InetAddress.getLocalHost(),8080);
	}

	public static void main(String[] args) {
		launch(args);
	}

	private void initComponents(Stage stage) {
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
			Scene scene = new Scene(root);
			stage.setTitle("Server");
			stage.setScene(scene);
			stage.show();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}
}
