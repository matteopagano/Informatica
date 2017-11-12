/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alberobindiricerca;

/**
 *
 * @author matteo.pagano
 */
public class main {
	public static void main(String[] args){
		AlberoBinDiRicerca classe = new AlberoBinDiRicerca();
                AlberoBinDiRicerca numeri = new AlberoBinDiRicerca();
		classe.inserisciElementiFile("D:\\Tutti i documenti\\Scuola\\Scuola Superiore  Istituto Zuccante\\INFORMATICA\\programmi java\\EserciziFiniti 2017-18\\AlberoBinDiRicerca\\src\\alberobindiricerca\\Name");
		System.out.println(classe.visitaSimmetrica());
                numeri.inserisciElementiFile("D:\\Tutti i documenti\\Scuola\\Scuola Superiore  Istituto Zuccante\\INFORMATICA\\programmi java\\EserciziFiniti 2017-18\\AlberoBinDiRicerca\\src\\alberobindiricerca\\numeri");
                System.out.println(numeri.visitaSimmetrica());
                numeri.search(1);
	}
}
