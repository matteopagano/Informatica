import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws FileNotFoundException {
       try {
            File inFile = new File("parole.txt");

            Scanner reader = new Scanner(inFile);
            AlberoBin<String> dizionario = new AlberoBin<String>();
            dizionario.inserisciElementiFile("parole.txt");

           System.out.println(dizionario.visitaSimmetrica());
        } catch (Exception e) {
            System.err.println("File not found");
        }
    }
}

