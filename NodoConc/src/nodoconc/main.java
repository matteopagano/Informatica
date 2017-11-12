package nodoconc;

/**
 *
 * @author matteo
 */
public class main {
    public static void main(String[] args) {
    NodoConc <String> a=new NodoConc("aa",null);
    NodoConc <String> b=new NodoConc("bb",a);
    NodoConc <String> c=new NodoConc("cc",b);
    Pila <String> pila =new Pila(5);
    
    pila.push(a.info, a);
    pila.push(b.info, b);
    pila.push(c.info, c);
    pila.stampaPila();
    
    pila.pop();
    pila.stampaPila();
    
    
    }
}
