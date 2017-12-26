import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException, InterruptedException {
        Rubrica rubrica = new Rubrica();
        System.out.println("Questa è la nuova rubrica.\n -------------------------------------");
        boolean cond=true;
        while (cond) {
            Scanner in = new Scanner(System.in);
            System.out.print("Inserisci cosa vuoi fare: [agg,elim,mod,visita,salva,esci]");
            String risposta = in.nextLine().toLowerCase();
            switch (risposta) {
                case "agg":
                    rubrica.addContatto();
                    break;
                case "elim":
                    rubrica.deleteContatto();
                    break;
                case "mod":
                    rubrica.editContatto();
                    break;
                case "visita":
                    rubrica.showList();
                    break;
                case "esci":
                    cond=false;
                    break;
                case "salva":
                    rubrica.saveFile();
            }
        }
    }
}
