package listaconcatenata;

/**
 *
 * @author matteo.pagano
 */
public class ListaConcatenata <T>{
	
	private Nodo testa;
	private int size=0;
	
	public ListaConcatenata(){
		this.size=0;
	}
	public ListaConcatenata(T [] array){
		for (int i = 0; i < array.length; i++) {
			this.add(array[i]);
		}
	}
	public void add(T valore){
		Nodo n = new Nodo(valore);
		Nodo questo = this.testa;
		while(questo.getNext()!=null){
			questo=questo.getNext();
		}
		questo.setProssimo(n);
		this.size++;
	}
	public void remove(int pos){
		Nodo questo = this.testa;
		for (int i = 0; i < pos-1; i++) {
			questo=questo.getNext();
		}
		questo.setProssimo(questo.getNext().getNext());
		this.size--;
	}
	public Nodo get(int pos){
		Nodo questo = this.testa;
		for (int i = 0; i < pos; i++) {
			questo= questo.getNext();
		}
		return questo;
	}
	public void addHead(T val){
		Nodo saved = this.testa;
		Nodo nuovo= new Nodo(val);
		this.testa=nuovo;
		nuovo.setProssimo(saved);
		this.size++;
	}
	public void addTail(T elem){
		Nodo questo = this.testa;
		Nodo nuovo = new Nodo(elem);
		while(questo.getNext()!=null){
			questo=questo.getNext();
		}
		questo.setProssimo(nuovo);
		this.size++;
	}
	public void removeHead(){
		this.testa=this.testa.getNext();
	}
	public void removeTail(){
		Nodo questo = this.testa;
		for (int i = 0; i < this.size-1; i++) {
			questo=questo.getNext();
		}
		questo.setProssimo(null);
		this.size--;
	}
	
}
