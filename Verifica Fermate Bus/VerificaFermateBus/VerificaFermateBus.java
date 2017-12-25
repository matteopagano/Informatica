package verificafermatebus;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author matteo
 */
public class VerificaFermateBus {
    public static void main(String[] args) throws FileNotFoundException{
        
        String nome_file="stops.csv";
        Mappa Venezia=new Mappa();
        Venezia.load("stops.csv");
        PuntoMappa fermataPiuVicina = Venezia.search(45,12);
        fermataPiuVicina.stampaPuntoMappa();
    }
    
}
