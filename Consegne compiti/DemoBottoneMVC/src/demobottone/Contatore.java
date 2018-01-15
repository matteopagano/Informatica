package demobottone;

public class Contatore {

   private int cont;

	public Contatore(int cont) {
		this.cont = cont;
	}

	public int getCont() {
		return cont;
	}

	public void setCont(int valore) {
		this.cont = valore;
	}
   
	public void incremento() {
		cont++;
	}
	
	public void decremento() {
		cont--;
	}
}
