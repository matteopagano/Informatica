/**
 *
 * @author matteo.pagano
 */
public class main {

    public static void main(String[] args) {
        ListaConcatenata <Integer> l=new ListaConcatenata();
            l.add(1);
            l.add(2);
            l.add(3);
            l.add(4);
            l.add(5);
            l.addHead(5555);
            l.addTail(1111);
            l.removeHead();
            l.removeTail();
            l.remove(0);
            l.set(0, 32);
            System.out.println(l.get(0));
            System.out.println(l.toString());

        ListaConcatenata<Integer> b = new ListaConcatenata();
        ListaConcatenata<String> a = new ListaConcatenata();
        a.inserisciElementiFile("C:\\Users\\matteo\\Desktop\\Informatica\\AlberoBinDiRicerca\\src\\alberobindiricerca\\Name");
        b.inserisciElementiFile("C:\\Users\\matteo\\Desktop\\Informatica\\AlberoBinDiRicerca\\src\\alberobindiricerca\\numeri");

        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(b.get(11));
        System.out.println(a.get(5));
        Visitatore it=a.getIterator();
        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.goTesta());
    }
}
