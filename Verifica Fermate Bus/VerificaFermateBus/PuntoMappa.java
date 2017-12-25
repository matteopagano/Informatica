package verificafermatebus;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author matteo
 */
public class PuntoMappa {

    String stop_id;
    String stop_name;
    double stop_lat, stop_lon;

    public PuntoMappa(String stop_id, String stop_name, double stop_lat, double stop_lon) {
        this.stop_id = stop_id;
        this.stop_name = stop_name;
        this.stop_lat = stop_lat;
        this.stop_lon = stop_lon;
    }
    public void stampaPuntoMappa(){
        System.out.println("ID fermata : "+this.stop_id+" \nNome fermata : "+this.stop_name+" \nLatitudine fermata : "+this.stop_lat+" \nLongitudine fermata : "+this.stop_lon);
    }
}
