package demobottone;

public class DemoBottoneMVC {

	public static void main(String[] args) {

		Contatore modello = new Contatore(0);
		FrameContatore f = new FrameContatore("Prova MVC contatore",modello);
		f.setVisible(true);
		
	}
}