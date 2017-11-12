package nodoconc;

public class NodoConc <T>{
    
    T info;
    NodoConc <T> next;
    NodoConc(T info ,NodoConc <T> next){
        this.info=info;
        this.next=next;
    }
    
}


