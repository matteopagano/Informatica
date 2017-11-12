package alberobin;

/**
 *
 * @author matteo.pagano
 */
public class main {
	public static void main(String[] args){
			AlberoBin a=new AlberoBin(4, new AlberoBin(9, new AlberoBin (10, null, null), new AlberoBin(8, null, new AlberoBin(6, new AlberoBin(7, null, null), new AlberoBin(5, null, null)))), new AlberoBin(2, new AlberoBin(3, null, null), new AlberoBin(1, null, null)));
		
			
			a.visitaAnticipata();
	}
}
