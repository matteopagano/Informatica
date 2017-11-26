package alberobindiricerca;

import alberobindiricerca.AlberoBin.NodoConcDopp;





/**
 *
 * @author matteo.pagano
 */
public class AlberoBinDiRicerca {

    AlberoBin albero;

    public AlberoBinDiRicerca(AlberoBin a) {
        this.albero = a;
    }

    public boolean search(Comparable e) {
        return searchRic(albero.getRoot(), e);
    }

    private static boolean searchRic(NodoConcDopp a, Comparable e) {
        if (a == null) {
            return false;
        } else if (a.info.equals(e)) {
            return true;
        } else if (e.compareTo(a.info) < 0) {
            return searchRic(a.left, e);
        } else {
            return searchRic(a.right, e);
        }
    }

    public static void main(String[] args){
        AlberoBin a=new AlberoBin();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        AlberoBinDiRicerca b=new AlberoBinDiRicerca(a);
        System.out.println(b.search(3));
        System.out.println(b.search(5));
        
    }
}
