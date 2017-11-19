/*titolo tema B: pizzeria da Peppiniello

Alla pizzeria da Peppiniello vi sono 12 posti; in pizzerie tutti i clienti vengono serviti in un tempo che per ragioni pratiche sia fra i 40'' ed il minuto - lo si decida a piacere.
Ogni 12'' arrivano dei clienti in numero random; il totale dei clienti sarà 14, questi mangeranno la loro pizza in un tempo random che va fra i 5' ed i 7'.
Una cameriera, all'inizio di un turno a caso, passerà per vedere quanti clienti ci sono producendone un elenco.
A terminale vanno dati opportuni messaggi per leggere sinteticamente l'evoluzione del sistema.
package pizzeriea.peppiniello;
 */
package pizzeriea.peppiniello;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author matteo
 */
public class Pizzeria extends Thread {

    Semaphore posti;
    int postiTotali;
    int numeroEntrateRimanenti = 14;
    int tempoDiServizio = 40;
    int tempoPerMangiare = 5;
    int numeroTurni = tempoDiServizio / tempoPerMangiare;
    int personeEntrate;
    int numCaricoGlobale;
    int conteggioPersoneDentro;
    int controlloCameriera;

    /**
     * Crea un Oggetto di tipo Pizzeria;
     *
     * @param postiTotali Numero tot. dei posti a sedere;
     */
    public Pizzeria(int postiTotali) {
        this.posti = new Semaphore(postiTotali);
        this.postiTotali = postiTotali;
    }

    /**
     * Diminuisce il numero dei posti liberi;
     *
     * @param nClienti numero dei clienti entrati;
     * @throws InterruptedException
     */
    public void clientiEntrati(int nClienti) throws InterruptedException {
        if (this.posti.availablePermits() == 0) {
            System.out.println("Pizzeria piena");

        } else if (nClienti + postiOccupati() > this.postiTotali) {
            System.out.println(nClienti - this.postiTotali + " persona/e dovrà restare fuori perchè il numero totali dei posti a sedere è " + this.postiTotali);
            nClienti = this.postiTotali - postiOccupati();
        }
        for (int i = 0; i < nClienti; i++) {
            this.posti.acquire();
        }

    }

    /**
     * Aumenta il numero dei posti liberi;
     *
     * @param nClienti numero dei clienti usciti;
     * @throws InterruptedException
     */
    public void clientiUsciti(int nClienti) {
        this.posti.release(nClienti);
    }

    /**
     * Esecuzione del Thread;
     */
    @Override
    public void run() {

        try {
            for (int i = 1; numeroEntrateRimanenti != 0; i++) {
                this.tempoPerMangiare=numRandom(5,7);
                numCaricoGlobale = i;
                controlloCameriera = numRandom(1, 3);
                System.out.println("-----------------------------------------------------------------------------------\n" + numCaricoGlobale + "° carico di persone");
                personeEntrate = numRandom(1, this.numeroEntrateRimanenti);
                this.numeroEntrateRimanenti -= personeEntrate;
                new Pizzeria.Cliente().start();
                System.out.println("");
                TimeUnit.SECONDS.sleep(tempoDiServizio);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Pizzeria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return Ritorna il numero totale dei posti liberi;
     */
    public int postiLiberi() {
        return posti.availablePermits();
    }

    /**
     * @return Ritorna il numero totale dei posti occupati;
     */
    public int postiOccupati() {
        return this.postiTotali - posti.availablePermits();
    }

    public class Cliente extends Thread {

        int nPersoneEntrateThread = personeEntrate;

        @Override
        public void run() {
            try {
                if (nPersoneEntrateThread > 12) {
                    this.nPersoneEntrateThread = 12;
                }
                int tempoPerMangiare = numRandom(5, 7);
                int nCaricoThread = numCaricoGlobale;

                clientiEntrati(nPersoneEntrateThread);

                if (nPersoneEntrateThread == 1) {
                    System.out.println("Del carico " + nCaricoThread + " - " + nPersoneEntrateThread + " persona entrata.");
                } else if (nPersoneEntrateThread > 12) {
                    System.out.println("Del carico " + nCaricoThread + " - " + (nPersoneEntrateThread - 1) + " persona entrata.");
                } else {
                    System.out.println("Del Carico " + nCaricoThread + " - " + nPersoneEntrateThread + " persone entrate.");
                }

                if (postiLiberi() != 1) {
                    System.out.println("Del Carico " + nCaricoThread + " - " + "I clienti hanno iniziato a mangiare.");
                } else {
                    System.out.println("Del Carico " + nCaricoThread + " - " + "Il cliente ha iniziato a mangiare.");
                }
                TimeUnit.SECONDS.sleep(tempoPerMangiare);

                if (postiLiberi() != 1) {
                    System.out.println("Del Carico " + nCaricoThread + " - " + "I clienti hanno finito di mangiare.");
                } else {
                    System.out.println("Del Carico " + nCaricoThread + " - " + "Il cliente ha finito di mangiare.");
                }
                clientiUsciti(personeEntrate);
                System.out.println("Del Carico " + nCaricoThread + " - " + nPersoneEntrateThread + " persone uscite.");
                if (controlloCameriera == 2) {
                    conteggioPersoneDentro += personeEntrate;
                    Cameriera a = new Pizzeria.Cameriera(conteggioPersoneDentro, 12 - conteggioPersoneDentro);
                    a.start();
                    a.join();
                    conteggioPersoneDentro -= personeEntrate;
                }

            } catch (InterruptedException ex) {
                Logger.getLogger(Pizzeria.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public class Cameriera extends Thread {

        int postiOccupati, postiLiberi;

        private Cameriera(int postiOccupati, int postiLiberi) {
            this.postiLiberi = postiLiberi;
            this.postiOccupati = postiOccupati;
        }

        @Override
        public void run() {

            System.out.println("");
            System.out.println("Visita della cameriera:");
            System.out.println("- Lista persone: tot. persone = " + this.postiOccupati + ".");
            System.out.println("                 tot. posti liberi = " + this.postiLiberi + ".");
            System.out.println("");
        }
    }

    /**
     * Ritorna un numero randomtra i due parametri;
     *
     * @param min numero minimo compreso;
     * @param max numero massimo compreso;
     * @return
     */
    private int numRandom(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }

    public static void main(String[] args) {
        Pizzeria Peppiniello = new Pizzeria(12);
        Peppiniello.start();
    }
}
