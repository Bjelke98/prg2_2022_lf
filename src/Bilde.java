import java.util.Objects;

public class Bilde {

    public static final String MALERI = "maleri",
                               AKVARELL = "akvarell",
                               GRAFIKK  = "grafikk",
                               FOTO     = "foto",
                               TEGNING  = "tegning";

    public String tittel;
    public String kunstner;
    public String type;
    public int årstall;
    public Dimensjon dimensjon;
    public boolean ramme;

    public Bilde(String tittel, String kunstner, String type, int årstall, Dimensjon dimensjon, boolean ramme) {
        this.tittel = tittel;
        this.kunstner = kunstner;
        this.type = type;
        this.årstall = årstall;
        this.dimensjon = dimensjon;
        this.ramme = ramme;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bilde bilde = (Bilde) o;
        return årstall == bilde.årstall &&
                ramme == bilde.ramme &&
                tittel.equals(bilde.tittel) &&
                kunstner.equals(bilde.kunstner) &&
                type.equals(bilde.type) &&
                dimensjon.equals(bilde.dimensjon);
    }

    @Override
    public String toString() {
        return tittel+
                " - Kunstner: "+kunstner+
                ", Type: "+type+
                ", Årstall: "+årstall+
                ", Dimensjon: "+dimensjon.toString()+"cm"+
                ", Har ramme: "+(ramme?"Ja":"Nei");
    }
    public String toCsv(){
        return tittel+";"+kunstner+";"+type+";"+årstall+";"+dimensjon+";"
                +(ramme?"innrammet":"uten ramme");
    }
}
