package coda;

/**
 *
 * @author matteo.pagano
 */
public class Pila <T>{

    private int top;
    private final int MAX;
    private T elem[];

    /**
     * Assegna alla coda e alla testa l'indice 0 mentre a MAX uguale al
     * parametro.
     *
     * @param val Lunghezza massima della pila.
     */
    public Pila(int val) {
        top = 0;
        this.MAX = val + 1;
        elem = (T[]) new Object[this.MAX];
    }

    /**
     * @return Vero se la pila è piena mentre falso se non lo è.
     */
    public boolean isFull() {
        if (top + 1 == MAX) {
            System.out.println("Non puoi inserire altri elementi perchè la pila è piena");
        }
        return top + 1 == MAX;
    }

    /**
     * @return Vero se la pila è vuota e falso se non lo è.
     */
    public boolean isEmpty() {
        if (top == 0) {
            System.out.println("Non puoi estrarre elementi perchè la pila è vuota");
        }
        return top == 0;
    }

    /**
     * Inserisce nella testa il paramentro.
     *
     * @param val Valore da inserire nella pila.
     */
    public void push(T val) {
        if (isFull() == false) {
            this.top++;
            elem[top] = val;
        } else {

        }
    }

    /**
     * Restituisce la lunghezza della pila.
     *
     * @return Lunghezza della pila.
     */
    public int getLength() {
        return elem.length;
    }

    /**
     * Estrae l'elemento in cima alla pila.
     *
     * @return Elemento in cima alla pila.
     */
    public T pop() {
        T val = elem[top];
        if (isEmpty() == false) {
            top--;
        }
        return val;
    }

    /**
     * Restituisce l'elemento in cima alla pila
     *
     * @return Elemento in cima alla pila
     */
    public T top() {
        if (isEmpty() == false) {
            return elem[top];
        } else {
            return null;
        }
    }

    /**
     * Stampa la coda.
     */
    @Override
    public String toString() {
        String string="";
        for (int i = top; i > 0; i--) {
            string+="\n"+elem[i];
        }
        return string;
    }

    /**
     *
     * @return Vero se la frase dentro la pila è palindroma falso se non lo è.
     */
    public boolean isPalindrome() {
        Pila a = new Pila(MAX - 1);
        Pila b = new Pila(MAX - 1);
        boolean cond = false;
        for (int i = 1; i < getLength(); i++) {
            a.push(elem[i]);
        }
        for (int i = getLength() - 1; i > 0; i--) {
            b.push(elem[i]);
        }
        for (int i = 1; i < getLength(); i++) {
            if (a.pop() != b.pop()) {
                cond = false;
                return cond;
            } else {
                cond = true;
            }

        }

        return cond;
    }
    /**
     * Inverte la Pila.
     */
    public void invertiPila() {
        Coda q = new Coda(this.MAX);
        for (int i = 1; i <getLength(); i++) {
            q.enQueue(pop());
        }
        for (int i = 0; i < MAX-1; i++) {
            push((T) q.deQueue());
        }
    }
    /**
     * Modifica elem uguale a newElem.
     * @param newElem Elemento che modifica elem.
     */
    private void setElem(T[] newElem){
        elem=newElem;
    }
    /**
     * Restituisce elem della Pila.
     * @return Elem
     */
    private T[] getElem(){
        return elem;
    }
}
