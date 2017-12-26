import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author matteo.pagano
 */
public class ListaConcatenata<T> {

    private NodoConc<T> testa;
    private int size = 0;
    //Oggetti per iterabile

    public ListaConcatenata() {
        this.size = 0;
    }

    public ListaConcatenata(T[] array) {
        this.testa = new NodoConc(null);
        for (int i = 0; i < array.length; i++) {
            this.add(array[i]);
        }
    }

    public int getSize() {
        return size;
    }

    public void add(T valore) {
        if (testa == null) {
            this.testa = new NodoConc(valore);
            this.size++;
        } else {
            NodoConc<T> n = new NodoConc(valore);
            NodoConc questo = this.testa;
            while (questo.getNext() != null) {
                questo = questo.getNext();
            }
            questo.setNext(n);
            this.size++;
        }
    }

    public void remove(int pos) {
        try {
            if (pos == 0) {
                this.testa = this.testa.getNext();
            } else {
                NodoConc<T> questo = this.testa;
                for (int i = 0; i < pos - 1; i++) {
                    questo = questo.getNext();
                }
                questo.setNext(questo.getNext().getNext());
                this.size--;
            }
        } catch (NullPointerException e) {
            e.getMessage();
        }
    }

    public T get(int pos) {
        try {
            NodoConc<T> questo = this.testa;
            for (int i = 0; i < pos; i++) {
                questo = questo.getNext();
            }
            return (T) questo.getInfo();
        } catch (NullPointerException e) {
            e.getMessage();
        }
        return (T) (String) "errore";
    }

    public void set(int pos, T elem) {
        NodoConc<T> questo = this.testa;
        try {
            for (int i = 0; i < pos; i++) {
                questo = questo.getNext();
            }
            questo.setInfo(elem);
        } catch (NullPointerException e) {
            e.getMessage();
        }
    }

    public void addHead(T val) {
        try {
            NodoConc<T> salvo = this.testa;
            NodoConc<T> nuovo = new NodoConc(val);
            this.testa = nuovo;
            nuovo.setNext(salvo);
            this.size++;
        } catch (NullPointerException e) {
            e.getMessage();
        }
    }

    public void addTail(T elem) {
        try {
            NodoConc<T> questo = this.testa;
            NodoConc<T> nuovo = new NodoConc(elem);
            while (questo.getNext() != null) {
                questo = questo.getNext();
            }
            questo.setNext(nuovo);
            this.size++;
        } catch (NullPointerException e) {
            e.getMessage();
        }
    }

    public void removeHead() {
        try {
            if (this.size != 1) {
                this.testa = this.testa.getNext();
                size--;
            } else {
                this.testa = null;
                size--;
            }
        } catch (NullPointerException e) {
            e.getMessage();
        }

    }

    public void removeTail() {
        if (size != 0) {
            NodoConc<T> questo = this.testa;
            for (int i = 0; i < this.size - 3; i++) {
                questo = questo.getNext();
            }
            questo.setNext(null);
            this.size--;
        }
    }

    public void inserisciElementiFile(String pathFile) {
        Scanner scan = null;
        File file = new File(pathFile);
        try {
            scan = new Scanner(file);
            while (scan.hasNextLine()) {
                add((T) (Comparable) scan.nextLine());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File non trovato");
        }
    }

    public Visitatore<T> getIterator() {

        return new IteratoreListaConc();
    }
    @Override
    public String toString() {
        if (size != 0) {
            String ret = "";
            NodoConc<T> questo = this.testa;
            while (questo.getNext() != null) {
                ret += questo.getInfo() + "\n";
                questo = questo.getNext();
            }
            ret += questo.getInfo();
            questo = questo.getNext();
            return ret;
        } else {
            return "";
        }
    }

    private class IteratoreListaConc implements Visitatore {
        private NodoConc n = testa;
        private int l1;

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
    }
}

