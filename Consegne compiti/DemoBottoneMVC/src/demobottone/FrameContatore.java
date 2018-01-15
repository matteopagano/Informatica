package demobottone;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameContatore extends Frame implements ActionListener, ItemListener {

	Contatore modContatore;

	Button btIncr;
	Button btDecr;
	Button btReset;
	TextField txtContatore;
	Label lbIsZero;

	public FrameContatore(String titolo, Contatore modContatore) {
		super(titolo);
		this.modContatore = modContatore;

		btIncr = new Button("+1");
		btDecr = new Button("-1");
		btReset = new Button("Reset");
		txtContatore = new TextField();
		lbIsZero = new Label(modContatore.getCont() == 0 ? "is Zero" : "");
		txtContatore.setText("" + modContatore.getCont());
		Choice scelta = new Choice();
		scelta.add("Prima scelta");
		scelta.add("Seconda scelta");
		scelta.add("Terza scelta");
		scelta.add("Quarta scelta");

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		}
		);

		setSize(200, 200);
		setLayout(new FlowLayout());
		//addWindowListener(this);
		add(btIncr);
		add(btDecr);
		add(btReset);
		add(txtContatore);
		add(lbIsZero);
		btIncr.setBackground(Color.red);
		btReset.setBackground(Color.green);
		btIncr.addActionListener(this);
		btDecr.addActionListener(this);
		btReset.addActionListener(this);
		txtContatore.addActionListener(this);
		scelta.addItemListener(this);
		add(scelta);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btIncr) {
			modContatore.incremento();
			txtContatore.setText("" + modContatore.getCont());
		} else if (e.getSource() == btReset) {
			modContatore.setCont(0);
			txtContatore.setText("" + modContatore.getCont());
		} else if (e.getSource() == txtContatore) {
			modContatore.setCont(Integer.parseInt(txtContatore.getText()));
//			txtContatore.setText("" + modContatore.getCont());
		} else if (e.getSource() == btDecr) {
			modContatore.decremento();
			txtContatore.setText("" + modContatore.getCont());
		}
		if (modContatore.getCont() == 0) {
			lbIsZero.setText("is Zero");
		} else {
			lbIsZero.setText("");
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		System.out.println(e.getItem());
	}
}
