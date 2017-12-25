package coda;


/**
 *
 * @author matteo.pagano
 */
public class Coda<T>{
    int testa, coda;
    private int MAX;
    private T[] elem;
    /**
     * Assegna alla coda e alla testa l'indice 0 mentre a MAX uguale al parametro.
     * @param val Lunghezza massima della coda.
     */
    public Coda(int val) {
        testa=coda=0;
        elem=(T[]) new Object[val];
        this.MAX=val;
    }
    /**
     * @return Vero se la coda è piena mentre falso se non lo è.
     */
    public boolean isFull(){
        return testa == MAX;
    }
    /**
     * Restituisce il numero massimo degli elementi della coda.
     * @return Valore MAX
     */
    public int getMax(){
        return this.MAX;
    }
    /**
     * @return Vero se la coda è vuota e falso se non lo è.
     */
    public boolean isEmpty(){
        return testa == coda;
    }
    /**
     * Inserisce nell'ultimo posto di coda il parametro scalando tutti gli elementi davanti.
     * @param val Valore da inserire nella coda.
     */
    public void enQueue(T val){
        if(isEmpty()){
            elem[coda]=val;
            testa++;
        }
        else if(isFull()==false){
            testa++;
            for (int i = testa-1; i >0; i--) {
                elem[i]=elem[i-1];
            }
            elem[coda]=val;
        }else{
            System.out.println("La coda è piena,non puoi aggiungere l'elemento "+val);
        }
    }
    /**
     * Toglie di coda il primo elemento scalando tutti quelli dietro in una posione in avanti.
     * @return Elemento di testa.
     */
    public T deQueue(){
        T ele=null;
        if(isEmpty()==false){
            ele=elem[testa-1];
            coda++;
            for (int i = testa-2; i >= coda-1; i--) {
                elem[i+1]=elem[i];
            }
            elem[coda-1]=null;
        }
        return ele;
    }
    /**
     * Stampa la coda.
     */
    @Override
    public String toString(){
        String string="";
        for (int i = 0; i < this.testa; i++) {
            if(this.elem[i]!=null){
            string+="\n"+elem[i];
            }
        }
        return string;
    }
    
    /**
     * Restituisce la posizione di testa.
     * @return Indice di testa.
     */
    public int getTesta(){
        return testa;
    }
    /**
     * Restituisce la posizione di coda.
     * @return Indice di coda.
     */
    public int getCoda(){
        return coda;
    }
    /**
     * Restituisce l'elemento di testa senza rimuoverlo.
     * @return Elemento di testa
     */
    public T peek(){
        return elem[testa-1];
    }
    /**
     * Restituisce la lunghezza della coda
     * @return Lunghezza della coda.
     */
    public int getLength(){
        return elem.length;
    }
    /**
     * @return Vero se la frase dentro la coda è palindroma falso se non lo è.
     */
    public boolean isPalindrome() {
        Coda a = new Coda(MAX);
        Coda b = new Coda(MAX);
        boolean cond=false;
        for (int i = 0; i < getLength(); i++) {
            a.enQueue(elem[i]);
        }
        for (int i = getLength() -1; i >= 0; i--) {
            b.enQueue(elem[i]);
        }
        for (int i = 0; i <= getLength(); i++) {
            if (a.deQueue() != b.deQueue()) {
                cond = false;
                return cond;
            } else {
                cond = true;
            }
        }
        return cond;
    }
    /**
     * Inverte la coda.
     */
    public void invertiCoda(){
        Pila s=new Pila(this.MAX);
        Coda d=new Coda(this.MAX);
        
        for (int i = 0; i < getLength(); i++) {
            s.push(deQueue());
        }
        for (int i = 0; i < MAX; i++) {
            d.enQueue(s.pop());
        }
        setElem((T[]) d.getElem());
    }
    /**
     * Modifica elem uguale a newElem.
     * @param newElem Elemento che modifica elem.
     */
    private void setElem(T[] newElem){
        elem=newElem;
    }
    /**
     * Restituisce elem della Coda.
     * @return Elem
     */
    private T[] getElem(){
        return elem;
    }
}