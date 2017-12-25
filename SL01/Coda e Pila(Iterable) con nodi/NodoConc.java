/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author matteo
 */
public class NodoConc<T> {
    private T info;
    private NodoConc<T> next;

    public NodoConc(T info, NodoConc<T> next) {
        this.info = info;
        this.next = next;
    }

    public NodoConc(T info) {
        this.info = info;
    }

    NodoConc() {
        
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NodoConc<T> getNext() {
        return next;
    }

    public void setNext(NodoConc<T> next) {
        this.next = next;
    }
    
}

