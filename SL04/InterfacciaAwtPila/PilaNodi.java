/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

public class PilaNodi<T> {

    private NodoConc <T> bottom;
    private NodoConc testa;
    private int lunghezza;

    public PilaNodi(NodoConc testa) {
        this.testa = testa;
        this.bottom=testa;
    }

    PilaNodi() {
        this(null);
    }

    public void push(T valore) {
        NodoConc daAggiungere = new NodoConc(valore);
        if (lunghezza == 0) {
            testa = daAggiungere;
            bottom=testa;
        } else {
            daAggiungere.setNext(testa);
            testa = daAggiungere;
        }
        lunghezza++;
        
    }

    public int getLunghezza() {
        return lunghezza;
    }

    public T pop() {
        NodoConc testaAttuale = null;
        if (lunghezza == 0) {
            return null;
        } else {
            testaAttuale = this.testa;
            this.testa = this.testa.getNext();
        }
        lunghezza--;
        return (T) testaAttuale.getInfo();
    }

    public T top() {
        if (lunghezza == 0) {
            return null;
        } else {
            return (T) this.testa.getInfo();
        }

    }

    public void invertiPila() {
        ArrayList<T> array = new ArrayList<T>();
        NodoConc appoggio = testa;
        NodoConc nuovo = testa;
        for (int i = 0; i < lunghezza; i++) {
            array.add((T) appoggio.getInfo());
            appoggio = appoggio.getNext();
        }
        for (int i = array.size(); i >= 1; i--) {
            nuovo.setInfo(array.get(i - 1));
            nuovo = nuovo.getNext();
        }
    }

    public boolean isEmpty(){
        return getLunghezza()==0;
    }
    public Visitatore getIterator() {
        return new IteratorePila();
    }

    @Override
    public String toString() {
        NodoConc<T> appoggio = testa;
        String ret = "";
        for (int i = 0; i < lunghezza; i++) {
            ret += "-" + appoggio.getInfo();

            appoggio = appoggio.getNext();
        }
        return ret;
    }
    private class IteratorePila implements Visitatore{
        public int l1 = 0;
        public NodoConc n = testa;

        @Override
        public boolean hasNext() {
            return n.getNext() != null;
        }

        @Override
        public T next() {
            T ret = (T) "";
            if (n.getNext() != null) {
                n = n.getNext();
                ret = (T) n.getInfo();
            } else {
                ret = (T) "fine della lista";
            }
            return ret;
        }

        @Override
        public T goTesta() {
            n = testa;
            return (T) n.getInfo();
        }

        @Override
        public T goBottom() {
            n=bottom;
            return (T) n.getInfo();
        }
    }
}
