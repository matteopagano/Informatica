package coda;

/**
 *
 * @author matteo
 */
public class prova {

    public static void main(String[] args) {
        Coda <Character>q=new Coda(4);
        Pila <Character>s=new Pila(4);
        
        q.enQueue('a');
        q.enQueue('b');
        q.enQueue('c');
        q.enQueue('d');
        q.enQueue('e');
        
        System.out.println(q.toString());
        
        q.deQueue();
        //q.invertiCoda();
        
        System.out.println(q.toString());
        
    }
    
    
}