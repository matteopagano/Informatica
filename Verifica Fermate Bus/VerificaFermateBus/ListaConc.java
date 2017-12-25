/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificafermatebus;

/**
 *
 * @author matteo
 */
public class ListaConc<T> {

    NodoConc <T> testa;
    private int lunghezza;

    public ListaConc() {
        this.lunghezza = 0;
    }

    public void add(T info) {
        NodoConc temp=testa;
        int n=0;
        if(testa==null){
            testa=new NodoConc(info,null);
        }else{
            while(temp.next!=null){
                temp=temp.next;
                n++;
            }
            temp.next=new NodoConc(info,null);
            
        }
        lunghezza++;
    }
    
    public T get(){
        return testa.info;
    }
}
