/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alberobindiricerca;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author matteo.pagano
 */
public class AlberoBin {

    private NodoConcDopp<Comparable> root;

    public AlberoBin(Comparable a) {
        this.root = new NodoConcDopp(a);
    }

    public AlberoBin(String a) {
        this.root = new NodoConcDopp();
        inserisciElementiFile(a);
    }

    public AlberoBin() {
        this.root = new NodoConcDopp();
    }

    public void add(Comparable a) {
        if (isEmpty()) {
            root = new NodoConcDopp(a);
            return;
        }
        NodoConcDopp<Comparable> padre = (NodoConcDopp<Comparable>) root;
        boolean destra = a.compareTo(padre.info) > 0;
        while ((destra ? padre.right : padre.left) != null) {
            padre = destra ? padre.right : padre.left;
            destra = a.compareTo(padre.info) > 0;
        }
        if (destra) {
            padre.right = new NodoConcDopp(a);
        } else {
            padre.left = new NodoConcDopp(a);
        }
    }

    public boolean isEmpty() {
        return root.getInfo() == null;
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

    public void inserisciElementiFile(String pathFile) {
        Scanner scan = null;
        File file = new File(pathFile);
        try {
            scan = new Scanner(file);
            while (scan.hasNextLine()) {
                add((Comparable) scan.nextLine());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File non trovato");
        }

    }

    public NodoConcDopp<Comparable> getRoot() {
        return root;
    }
    


    public class NodoConcDopp<Comparable> {

        public Comparable info;
        public NodoConcDopp<Comparable> left;
        public NodoConcDopp<Comparable> right;

        public NodoConcDopp() {
            this.info = null;
            this.left = null;
            this.right = null;
        }

        public NodoConcDopp(Comparable info, NodoConcDopp left, NodoConcDopp right) {
            this.info = info;
            this.left = left;
            this.right = right;
        }

        public NodoConcDopp(Comparable info) {
            this.info = info;
            this.left = null;
            this.right = null;
        }

        public void setInfo(Comparable info) {
            this.info = info;
        }

        public Comparable getInfo() {
            return info;
        }

        public NodoConcDopp<Comparable> getLeft() {
            return left;
        }

        public NodoConcDopp<Comparable> getRight() {
            return right;
        }
    }
}
