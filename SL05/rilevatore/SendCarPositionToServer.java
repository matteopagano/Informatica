/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rilevatore;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matteo.pagano
 */
public class SendCarPositionToServer implements Runnable {
	DatagramSocket rilevatore;
	public SendCarPositionToServer(DatagramSocket rilevatore) {
		this.rilevatore=rilevatore;
	}

	@Override
	public void run() {
		while(true){
			String toSend="Latitudine: "+new Random().nextFloat()*100+" Longitudine: "+new Random().nextFloat()*100+" Targa: "+rilevatore.getLocalAddress()+" Data: "+new Date();
			try {
				rilevatore.send(new DatagramPacket(toSend.getBytes(),0,toSend.getBytes().length));
				
			} catch (Exception ex) {
			
			}
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException ex) {
			
			}
		}
	}
	
}
