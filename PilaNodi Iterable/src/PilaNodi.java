import java.util.Iterator;

public class PilaNodi <T> implements Iterator<T> {


    private Nodo testa;
    private int lunghezza;
    public int l1=0;
    public Nodo n=testa;


    public PilaNodi(Nodo testa) {
        this.testa = testa;
    }

    PilaNodi() {
        this(null);
    }

    public void push(T valore) {
        Nodo daAggiungere = new Nodo(valore);
        if (lunghezza == 0) {
            testa = daAggiungere;
        } else {
            daAggiungere.setNext(testa);
            testa = daAggiungere;
        }
        lunghezza++;
        l1=lunghezza;
        n=testa;
    }

    public int getLunghezza() {
        return lunghezza;
    }

    public T pop() {
        Nodo testaAttuale = null;
        if (lunghezza == 0) {
            return null;
        } else {
            testaAttuale = this.testa;
            this.testa = this.testa.getNext();
        }
        lunghezza--;
        l1=lunghezza;
        n=testa;
        return (T) testaAttuale.getInfo();
    }

    public T top() {
        if (lunghezza == 0) {
            return null;
        } else {
            return (T) this.testa.getInfo();
        }

    }

    @Override
    public boolean hasNext() {
        return l1>0;
    }

    @Override
    public T next() {
        if(hasNext()) {
            l1--;
            T temp = (T) n.getInfo();
            n = n.getNext();
            return temp;
        }
        return null;
    }

    public T goTesta(){
        n=testa;
        l1=lunghezza;
        T temp= (T) n.getInfo();
        return temp;

    }


    public class Nodo<T>  {
    private T info;
    private Nodo<T> next;

    public Nodo(T info, Nodo<T> next) {
        this.info = info;
        this.next = next;
    }

    public Nodo(T info) {
        this.info = info;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Nodo<T> getNext() {
        return next;
    }

    public void setNext(Nodo<T> next) {
        this.next = next;
    }

}
    }





