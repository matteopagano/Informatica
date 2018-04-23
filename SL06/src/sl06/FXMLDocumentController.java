/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sl06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author matteo.pagano
 */
public class FXMLDocumentController implements Initializable {
	Socket client;
	DataInputStream in;
	DataOutputStream out;
	@FXML
	private TextField port = new TextField();
	@FXML
	private TextField ip = new TextField();
	@FXML
	private TextField name = new TextField();
	@FXML
	private TextField password = new TextField();
	@FXML
	private AnchorPane paginaServer=new AnchorPane();
	@FXML
	private AnchorPane paginaLogin=new AnchorPane();

	@FXML
	private void connect(ActionEvent event) throws IOException {
		String ipTesto = ip.getText();
		int portTesto = Integer.parseInt(port.getText());
		String serverFound = "";
		try {
			client = new Socket(ipTesto, portTesto);
			in = new DataInputStream(client.getInputStream());
			out = new DataOutputStream(client.getOutputStream());
			serverFound = in.readLine();
			paginaServer.setVisible(false);
			paginaServer.setVisible(false);
			paginaLogin.setVisible(true);
			paginaLogin.getParent().setVisible(true);
			System.out.println(serverFound);
		} catch (IOException ex) {
			System.err.println("Server non trovato");
		}
	}
	@FXML
	private void login(ActionEvent event) throws IOException {
		String nameTesto="USER "+name.getText()+"\n";
		String passwordTesto="USER "+password.getText()+"\n";
		out.writeBytes(nameTesto);
		String nameAccept=in.readLine();
		System.out.println(nameAccept);
		out.writeBytes(passwordTesto);
		String passwordAccept=in.readLine();
		System.out.println(nameAccept);
		
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		paginaServer.setVisible(true);
		paginaLogin.setVisible(false);
		password.setVisible(false);
		name.setVisible(false);
	}

}
