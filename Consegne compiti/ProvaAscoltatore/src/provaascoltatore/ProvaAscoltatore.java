
package provaascoltatore;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.TextField;

public class ProvaAscoltatore {

	public static void main(String[] args) {
		Frame f = new Frame("Bottone con ascoltatore");
		f.setSize(640, 320);
		
		Button bottone = new Button("Bottone");
		bottone.setBackground(Color.red);
	//	bottone.setBounds(320,100,100,50);
		TextField txt = new TextField("");
		
		AscoltatoreBtn btn = new AscoltatoreBtn();
		bottone.addMouseListener(btn);
		txt.addMouseListener(btn);
		
		AscoltatoreWin win = new AscoltatoreWin();
		f.addWindowListener(win);
		
//		f.setLayout(new FlowLayout(FlowLayout.LEFT));
//		f.setLayout(null);
//		f.setLayout(new BorderLayout());
		f.setLayout(new GridLayout(4,3));
	
		f.add(bottone);
		f.add(txt);
		f.setVisible(true);
		
		
	}
	
}
