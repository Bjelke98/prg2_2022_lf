import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Oppgave2 {
    public static void main(String[] args) {
        Bilde[] bildeTab = hentBilderFraFil("bilder.txt");
        skrivBilderTilFilFraÅr(bildeTab, 2008);
//        System.out.println(Arrays.toString(bildeTab));
    }
    //Oppgave A
    public static Bilde[] hentBilderFraFil(String filnavn){
        int antallRader = 0;
        try {
            Scanner scanner = new Scanner(new File(filnavn));
            while (scanner.hasNextLine()){
                scanner.nextLine();
                antallRader++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Bilde[] bildeTab = new Bilde[antallRader];
        try {
            Scanner scanner = new Scanner(new File(filnavn));
            for (int i = 0; i < antallRader; i++) {
                String[] linjeTab = scanner.nextLine().split(";");
                String[] dimensjonTab = linjeTab[4].split("x");
                Dimensjon dimensjon = new Dimensjon(Integer.parseInt(dimensjonTab[0]), Integer.parseInt(dimensjonTab[1]));
                boolean ramme = linjeTab[5].equals("innrammet");
                bildeTab[i] = new Bilde(linjeTab[0], linjeTab[1], linjeTab[2], Integer.parseInt(linjeTab[3]), dimensjon, ramme);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return bildeTab;
    }

    //Oppgave B
    public static void skrivBilderTilFilFraÅr(Bilde[] bildeTab, int årstall){
        try {
            PrintWriter pw = new PrintWriter(årstall+".txt");
            for (Bilde bilde : bildeTab){
                if(bilde.årstall==årstall){
                    System.out.println(bilde.toCsv());
                    pw.println(bilde.toCsv());
                }
            }
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
