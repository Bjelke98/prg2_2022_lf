import javax.swing.*;

public class Oppgave1B {
    private static int detteÅret = 2022;

    public static void main(String[] args) {
        Bilde[] bildeTab = new Bilde[]{
                new Bilde("Solnedgang", "Meg", Bilde.MALERI, 2000, new Dimensjon(100, 70), true),
                new Bilde("IkkeNedgang", "Deg", Bilde.TEGNING, 1992, new Dimensjon(99, 99), false),
                new Bilde("oppsolgang", "Meg", Bilde.MALERI, 2001, new Dimensjon(100, 70), true),
                new Bilde("IkkeNedgang", "Deg", Bilde.TEGNING, 1992, new Dimensjon(99, 99), false),
                new Bilde("tosol", "Meg", Bilde.MALERI, 1780, new Dimensjon(90, 200), true),
                new Bilde("IkkeNedgang", "Deg", Bilde.TEGNING, 1992, new Dimensjon(99, 99), false),
        };

        String ut = "Bilder som inneholder <<sol>>, er større enn 100cm i en retning og har ramme som ikke er eldre enn 25 år\n";
        for (Bilde bilde : bildeTab){
            if(
                    bilde.tittel.toLowerCase().contains("sol")&&
                    detteÅret-bilde.årstall<=25&&
                    (bilde.dimensjon.getBredde()>=100||bilde.dimensjon.getHøyde()>=100)&&
                    bilde.ramme
            ){
                ut+=bilde+"\n";
            }
        }
        JOptionPane.showMessageDialog(null, ut);
    }
}
