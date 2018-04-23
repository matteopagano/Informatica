/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sl07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author matteo.pagano
 */
public class SL07 {

	static ArrayList<String> paroleItalianeInglesi = new ArrayList<>();

	public static void main(String[] args) throws FileNotFoundException {
		File f = new File("C:\\Users\\matteo.pagano.LAP.000\\Documents\\NetBeansProjects\\SL07\\src\\sl07\\inglese_italiano.txt");
		Scanner in = new Scanner(f, "ISO-8859-1");
		Scanner i = new Scanner(System.in);
		while (in.hasNextLine()) {
			paroleItalianeInglesi.add(in.nextLine());
		}
		System.out.println("ITA inserisci una parola");
		String key=i.nextLine();
		System.out.println(ricercaIta(key));
		System.out.println("EN Insert a key");
		key=i.nextLine();
		System.out.println(ricercaEn(key));
	}

	public static String ricercaIta(String key) {
		int i = 0;
		while (i <= paroleItalianeInglesi.size()) {
			if (paroleItalianeInglesi.get(i).toUpperCase().equals(key.toUpperCase())) 
				return ""+paroleItalianeInglesi.get(i-1);
			i++;
		}
		return "Nessuna corrispondenza";
	}
	
	public static String ricercaEn(String key) {
		int i = 0;
		while (i <= paroleItalianeInglesi.size()) {
			if (paroleItalianeInglesi.get(i).toUpperCase().equals(key.toUpperCase())) 
				return ""+paroleItalianeInglesi.get(i+1);
			i++;
		}
		return "Not Found";
	}

}
