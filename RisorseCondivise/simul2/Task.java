/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simul2;

import static simul2.Risorsa.semaphore;

/**
 *
 * @author matteo
 */
public class Task extends Thread{
    String name = "";

        Task(String name) {
            this.name = name;
        }

        public void run() {

            try {

                System.out.println(name + " : Acquisizione Risorsa");
                System.out.println(name + " : Risorse disponibili : " + semaphore.availablePermits());

                semaphore.acquire();
                
                System.out.println(name + " : Permesso accettato");

                try {
                    System.out.println(name +" : Acquisizione seconda risorsa");
                    semaphore.acquire();
                    System.out.println(name + " : Permesso seconda risorsa accettato");
                    
                    for (int i = 1; i <= 2; i++) {

                        System.out.println(name + " : Sta svolgendo l'operazione " + i + ", Risolrse disponibili : " + semaphore.availablePermits());
                        
                        // Dormi un secondo
                        Thread.sleep(1000);

                    }

                } finally {

                    // chiama release() finito acquire()
                    System.out.println(name + " : Rilascio Risorse 1 e 2..");
                    semaphore.release();
                    semaphore.release();
                    System.out.println(name + " : Risorse disponibili adesso: " + semaphore.availablePermits());

                }

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

        }

    }
