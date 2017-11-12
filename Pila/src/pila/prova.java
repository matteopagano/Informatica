/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pila;

/**
 *
 * @author matteo.pagano
 */
public class prova {
	public static void main(String[] args) {
		Pila a = new Pila(4);
		a.push('c');
                a.push('i');
                a.push('a');
                a.push('o');
                a.stampaPila();
                a.invertiPila();
                a.stampaPila();
                
	}
}
