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
    int b=0;
    private static boolean searchRic(NodoConcDopp a, Comparable e) {
        if (a == null) {
            return false;
        } else if (a.getInfo().equals(e)) {
            return true;
        } else if (e.compareTo(a.info) < 0) {
            return searchRic(a.left, e);
        } else {
            return searchRic(a.right, e);
        }
    }

    public static void main(String[] args){
        AlberoBin a=new AlberoBin();
        AlberoBin b=new AlberoBin();
        
        a.inserisciElementiFile("C:\\Users\\matteo\\Desktop\\Informatica\\AlberoBinDiRicerca\\src\\alberobindiricerca\\Name");
        b.inserisciElementiFile("C:\\Users\\matteo\\Desktop\\Informatica\\AlberoBinDiRicerca\\src\\alberobindiricerca\\numeri");
        System.out.println(a.toString());
        AlberoBinDiRicerca alb=new AlberoBinDiRicerca(a);
        System.out.print("Ricerca della parola -Argenti Michele- :");System.out.println(alb.search("Argenti Michele"));
        System.out.println("Spostamento attraverso l'utilizzo di un iteratore descitto nell'interfaccia Visitatore: ");
        Visitatore it=a.getVisitatore();
        System.out.println();
        System.out.println(it.goDx());
        System.out.println(it.goDx());
        
        
    }
}
