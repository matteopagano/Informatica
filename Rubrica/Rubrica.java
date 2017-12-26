import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Rubrica {
    ListaConcatenata<Contatto> contatti =new ListaConcatenata<>();

    File file;
    File perElim=new File("Rubrica.txt");

    public Rubrica() throws IOException, InterruptedException {
        if(perElim.exists()){
            Scanner in=new Scanner(System.in);
            System.out.println("Sono presenti dei salvataggi, vuoi caricarli?[s,n]");

            String risposta=in.nextLine();
            switch(risposta){
                case"s":
                    System.out.print("Caricamento salvataggi rubrica");
                    TimeUnit.MILLISECONDS.sleep(500);
                    System.out.print(".");
                    TimeUnit.MILLISECONDS.sleep(500);
                    System.out.print(".");
                    TimeUnit.MILLISECONDS.sleep(500);
                    System.out.print(".");
                    TimeUnit.MILLISECONDS.sleep(500);
                    System.out.println();
                    TimeUnit.SECONDS.sleep(2);
                    reloadFile();break;
                case"n":deleteFile();break;
            }
        }else{
            System.out.println("Non sono presenti salvataggi;");
            System.out.print("Inizzializzazione rubrica");
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.print(".");
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.print(".");
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.print(".");
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println();
            TimeUnit.SECONDS.sleep(2);
        }
    }

    public void addContatto(){
        Scanner in = new Scanner(System.in);
        System.out.print("Inserisci nome Contatto: ");
        String nome=in.nextLine();
        System.out.print("Inserisci cognome Contatto: ");
        String cognome=in.nextLine();
        System.out.print("Inserisci numero Contatto: ");
        String n=in.nextLine();
        long numero=Long.parseLong(n);
        System.out.print("Inserisci e-mail Contatto: ");
        String email=in.nextLine();
        System.out.print("Inserisci indirizzo Contatto: ");
        String indirizzo=in.nextLine();
        Contatto nuovo=new Contatto(nome,cognome,numero,email,indirizzo);
        this.contatti.add(nuovo);
    }
    public void editContatto(){
        Scanner in = new Scanner(System.in);
        System.out.println("Quale contatto vuoi modificare: [numero contatto]");
        String n=in.nextLine();
        int numCont=Integer.parseInt(n)-1;
        System.out.print("Cosa vuoi modificare:[n,c,num,mail,ind] ");
        String risposta=in.nextLine();
        risposta.toLowerCase();
        switch(risposta){
            case "n":
                System.out.print("Inserisci nome Contatto: ");
                String nome=in.nextLine();
                contatti.get(numCont).setName(nome);
                ;break;
            case "c":
                System.out.print("Inserisci cognome Contatto: ");
                String cognome=in.nextLine();
                contatti.get(numCont).setSurname(cognome);
                ;break;
            case "num":
                System.out.print("Inserisci numero Contatto: ");
                String num=in.nextLine();
                contatti.get(numCont).setNumber(Integer.parseInt(num));
                ;break;
            case "mail":
                System.out.print("Inserisci e-mail Contatto: ");
                String email=in.nextLine();
                contatti.get(numCont).setEmail(email);
                ;break;
            case "ind":
                System.out.print("Inserisci indirizzo Contatto: ");
                String indirizzo=in.nextLine();
                contatti.get(numCont).setAddress(indirizzo);
                ;break;
        }
    }
    public void deleteContatto(){
        Scanner in = new Scanner(System.in);
        System.out.println("Quale contatto vuoi eliminare: [numero contatto]");
        String n=in.nextLine();
        contatti.remove(Integer.parseInt(n)-1);
    }
    public void showList(){
        System.out.print(contatti.toString());
    }
    public void saveFile() throws IOException {
        perElim.delete();
        file = new File("Rubrica.txt");
        PrintStream scrivi = new PrintStream(file);
        scrivi.println("Nome,Cognome,Numero di telefono,E-mail,Indirizzo");
        for (int i=0;i<contatti.getSize();i++){
            scrivi.println((i+1)+"° "+contatti.get(i));
        }
    }
    public void reloadFile() throws FileNotFoundException {
        file = perElim;
        System.out.println(file.toString());
        String n,cog,email,indir;
        long num;
        Scanner scan =new Scanner(perElim);
        scan.useDelimiter(";");
        while (scan.hasNextLine()) {
            try {
                scan.nextLine();
                scan.next();
                n=scan.next();
                cog=scan.next();
                num=Long.parseLong(scan.next());
                email=scan.next();
                indir=scan.next();
                Contatto nuovo=new Contatto(n,cog,num,email,indir);
                contatti.add(nuovo);
            } catch (NoSuchElementException e) {
            }
        }
    }
    public void deleteFile(){
        file = perElim;
        file.delete();
    }
}
