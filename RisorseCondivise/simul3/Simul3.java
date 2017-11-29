package simul3;

import static simul3.Risorsa.semaphore;

/**
 *
 * @author matteo
 */
public class Simul3 {
    public static void main(String[] args) {
        System.out.println("Risorse disponibili di entrambi i thread assieme adesso: " + semaphore.availablePermits());
        Task t2 = new Task("B");
        Task t1 = new Task("A");
        
        t1.start();
        t2.start();
        System.out.println(" : Risorse disponibili di entrambi i thread assieme adesso: " + semaphore.availablePermits());
    }
    
}
