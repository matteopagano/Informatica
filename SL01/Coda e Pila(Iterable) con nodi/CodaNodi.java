/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author matteo
 */
public class CodaNodi<T> {

    private NodoConc testa;
    private int lunghezza;

    public CodaNodi(NodoConc testa) {
        this.testa = testa;
    }

    public CodaNodi() {
    }

    public int getLunghezza() {
        return lunghezza;
    }
 
    public void enqueue(T x) {
        NodoConc nuovo = new NodoConc(x);
        NodoConc viagg = testa;
        if (lunghezza == 0) {
            testa = nuovo;
        } else {
            for (int i = 0; i < lunghezza - 1; i++) {
                viagg = viagg.getNext();
            }
            viagg.setNext(nuovo);
        }
        lunghezza++;
    }

    public boolean isEmpty() {
        return lunghezza == 0;
    }

    public T front() {
      
        return (T) testa.getInfo();
        
    
    }

    public void dequeue() {
       
            testa = testa.getNext();
            lunghezza--;
        
    }
}
