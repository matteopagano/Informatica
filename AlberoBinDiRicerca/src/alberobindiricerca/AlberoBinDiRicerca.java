package alberobindiricerca;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author matteo.pagano
 */
public class AlberoBinDiRicerca {
    private NodoConcDopp<Comparable> root;

    public void add(Comparable arg) {
        if (root == null) {
            root = new NodoConcDopp(arg, null, null);
            return;
        }
        NodoConcDopp<Comparable> tmp = root;
        boolean destra = arg.compareTo(tmp.info) > 0;
        while ((destra ? tmp.right : tmp.left) != null) {
            tmp = destra ? tmp.right : tmp.left;
            destra = arg.compareTo(tmp.info) > 0;
        }
        if (destra) {
            tmp.right = new NodoConcDopp(arg, null, null);
        } else {
            tmp.left = new NodoConcDopp(arg, null, null);
        }
    }

    public boolean isEmpty() {
        return root.info == null;
    }

    public ArrayList<Comparable> visitaAnticipata() {
        ArrayList<Comparable> results = new ArrayList();
        visitaAnticipata(results, root);
        return results;
    }

    public void visitaAnticipata(ArrayList<Comparable> results, NodoConcDopp<Comparable> nodo) {
        if (!isEmpty()) {
            results.add(nodo.info);
            if (nodo.left != null) {
                visitaAnticipata(results, nodo.left);
            }
            if (nodo.right != null) {
                visitaAnticipata(results, nodo.right);
            }
        }
    }

    public ArrayList<Comparable> visitaDifferita() {
        ArrayList<Comparable> results = new ArrayList();
        visitaDifferita(results, root);
        return results;
    }

    public void visitaDifferita(ArrayList<Comparable> results, NodoConcDopp<Comparable> nodo) {
        if (!isEmpty()) {
            if (nodo.right != null) {
                visitaDifferita(results, nodo.right);
            }
            if (nodo.left != null) {
                visitaDifferita(results, nodo.left);
            }
            results.add(nodo.info);
        }
    }

    public ArrayList<Comparable> visitaSimmetrica() {
        ArrayList<Comparable> results = new ArrayList();
        visitaSimmetrica(results, root);
        return results;
    }

    private void visitaSimmetrica(ArrayList<Comparable> results, NodoConcDopp<Comparable> nodo) {
        if (!isEmpty()) {
            if (nodo.left != null) {
                visitaSimmetrica(results, nodo.left);
            }
            results.add(nodo.info);
            if (nodo.right != null) {
                visitaSimmetrica(results, nodo.right);
            }
        }
    }

    public void search(Object x) {
        boolean t = false;
        ArrayList a = visitaSimmetrica();
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) == x) {
                t = true;
            }
        }
        if (t) {
            System.out.println("There is " + x);
        } else {
            System.out.println("There isn't " + x);
        }
    }

    public void inserisciElementiFile(String pathFile) {
        Scanner scan = null;
        File file = new File(pathFile);
        try {
            scan = new Scanner(file);
            while (scan.hasNextLine()) {
                add(scan.nextLine());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File non trovato");
        }

    }
}

