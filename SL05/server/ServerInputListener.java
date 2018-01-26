package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;

/**
 *
 * @author matteo.pagano
 */
public class ServerInputListener implements Runnable {
	DatagramSocket server;
	ArrayList<String> posizioni;
	public ServerInputListener(DatagramSocket server) {
		this.server=server;
		posizioni=new ArrayList();
	}

	@Override
	public void run() {
		byte[] array= new byte[1024];
		while(true){
			DatagramPacket info =new DatagramPacket(array,0,array.length);
			try {
				server.receive(info);
				String pos = new String(array);
				//si accorge se gli sto inviando una posizione o una richiesta per l'invio delle informazioni
				if(pos.contains("Latitudine")){
					posizioni.add(pos);
					System.out.println(posizioni.get(posizioni.size()-1));
				}else{
					server.connect(InetAddress.getLocalHost(),8080);
					for (int i = 0; i < posizioni.size(); i++) {
						server.send(new DatagramPacket(posizioni.get(i).getBytes(),0,posizioni.get(i).getBytes().length));
					}
					server.disconnect();
				}
			} catch (IOException ex) {
				System.out.println("NON WORKA.");
			}
		}
	}
	
}
