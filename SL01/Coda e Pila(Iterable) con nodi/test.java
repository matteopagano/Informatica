/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author matteo
 */
public class test {
    public static void main(String[] args){
        PilaNodi p=new PilaNodi();
        p.push("a");
        p.push("b");
        p.push("c");
        p.push("d");
        p.push("e");
        
        System.out.println(p.toString());
        p.invertiPila();
        System.out.println(p.toString());
        Visitatore it=p.getIterator();
        System.out.println(it.next());
    }
}
