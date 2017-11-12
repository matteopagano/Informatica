package listaconcatenata;

public class Nodo<T>{
    
    T valore;
    Nodo <T> next;
	Nodo(T valore){
		this.valore=valore;
	}
	public void setProssimo(Nodo next){
		this.next=next;
	}

	public Nodo<T> getNext() {
		return next;
	}
	
}
