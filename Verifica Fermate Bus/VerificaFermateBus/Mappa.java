/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificafermatebus;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author matteo
 */
public class Mappa<T> {

    ListaConc<PuntoMappa> lista = new ListaConc();

    public void load(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scan = new Scanner(file);
        scan.useDelimiter(",");
        scan.nextLine();
        while (scan.hasNextLine()) {
            try {
                String id = scan.next();
                scan.next();
                String name = scan.next();
                scan.next();
                double lat = Double.parseDouble(scan.next());
                double lon = Double.parseDouble(scan.next());
                lista.add(new PuntoMappa(id, name, lat, lon));
                scan.nextLine();
            } catch (NumberFormatException e) {
            }
        }
    }

    public PuntoMappa search(double lat, double lon) {
        double distanza = 0;
        ListaConc<PuntoMappa> temp = lista;
        distanza = Math.sqrt(Math.pow(temp.testa.info.stop_lat - lat, 2) + Math.pow(temp.testa.info.stop_lon - lon, 2));
        String id = null;
        String nome = null;
        double lat1 = 0;
        double lon1 = 0;
        for (temp = lista; temp.testa.next != null; temp.testa = temp.testa.next) {
            if (distanza > Math.sqrt(Math.pow(temp.testa.info.stop_lat - lat, 2) + Math.pow(temp.testa.info.stop_lon - lon, 2))) {
                distanza = Math.sqrt(Math.pow(temp.testa.info.stop_lat - lat, 2) + Math.pow(temp.testa.info.stop_lon - lon, 2));
                id = temp.testa.info.stop_id;
                nome = temp.testa.info.stop_name;
                lat1 = temp.testa.info.stop_lat;
                lon1 = temp.testa.info.stop_lon;
            }
        }
        return new PuntoMappa(id, nome, lat1, lon1);
    }
}
