package provaascoltatore;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class AscoltatoreWin extends WindowAdapter {

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("Chiusura");
	//	System.exit(0);
		((Frame) e.getComponent()).dispose();
	}
	
}
