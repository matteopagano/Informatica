package nodoconc;
import nodoconc.NodoConc;

/**
 *
 * @author matteo
 */
public class Pila <T>{
    public NodoConc <T> [] dati;
    private int testa=0;
    
    public Pila(int n){
        this.dati = new NodoConc [n];
        testa=0;
    }
    public boolean isEmpty(){
        return testa==0;
    }
    public void push(T info,NodoConc next){
        if(isEmpty()){
        dati[testa]=next;
        testa++;
        }else{
            dati[testa]=next;
            testa++;
        }
    }
    public NodoConc top(){
        return dati[testa];
    }
    public void pop(){
        testa--;
    }
    public boolean isFull(){
        return testa==dati.length;
    }
    public void stampaPila(){
        for (int i = 0; i < testa; i++) {
            System.out.println(dati[i].info);
        }
    }
}
