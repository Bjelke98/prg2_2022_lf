import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Oppgave3 extends Application {

    public static final String TITTEL = "Innlogging";
    private static final String SKRIV_INN     = "Skriv inn ditt brukernavn og passord!",
                                FEIL_DATA     = "Du har ikke gitt korrekte innloggingsdata!",
                                GODKJENT      = "Innlogging er godkjent og du sendes videre.",
                                GLEMT_PASSORD = "-------- Tilbakestill passord! --------",
                                FYLL_ALLE_FELDT = "---- Alle feldt må være fylt ut! ----";

    Label etikettInfo = new Label(SKRIV_INN);

    TextField brukernavnInn = new TextField();
    PasswordField passordInn = new PasswordField();

    Button knappLoggInn = new Button("Logg inn");
    Button knappGlemt = new Button("Glemt passord");

    @Override
    public void start(Stage stage) throws Exception {
        Label etikettBrukernavn = new Label("Brukernavn: ");
        Label etikettPassord = new Label("     Passord: ");

        brukernavnInn.setPrefColumnCount(12);
        passordInn.setPrefColumnCount(12);

        knappLoggInn.setOnAction(this::behandleKlikk);
        knappGlemt.setOnAction(this::behandleKlikk);

        FlowPane root = new FlowPane();
        root.setAlignment(Pos.CENTER);
        root.setVgap(10);
        root.setHgap(10);

        root.getChildren().addAll(
                etikettInfo,
                etikettBrukernavn, brukernavnInn,
                etikettPassord, passordInn,
                knappLoggInn, knappGlemt
        );

        Scene scene = new Scene(root, 250, 150);
        stage.setScene(scene);
        stage.setTitle(TITTEL);
        stage.show();
    }

    public void behandleKlikk(ActionEvent e) {
        if ( e.getSource() == knappLoggInn )
            utførLoggInn();
        else if ( e.getSource() == knappGlemt ) {
            etikettInfo.setText(GLEMT_PASSORD);
            endreRegistrering();
        }
    }

    public void utførLoggInn(){
        if(brukernavnInn.getText().length()<1 || passordInn.getText().length()<1){
            etikettInfo.setText(FYLL_ALLE_FELDT);
            return;
        }
        try {
            Scanner scanner = new Scanner(new File("login.txt"));
            while (scanner.hasNextLine()){
                String[] linjeTab = scanner.nextLine().split(";");
                if(
                        brukernavnInn.getText().toLowerCase().equals(linjeTab[0]) &&
                        kode(passordInn.getText()).equals(linjeTab[1]
                )){
                    etikettInfo.setText(GODKJENT);
                    return;
                }
                etikettInfo.setText(FEIL_DATA);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String kode(String ikkeKryptert){
        String kryptert = ikkeKryptert; // Dummy for å late som at passord blri kryptert.
        return kryptert;
    }

    public void endreRegistrering(){
        // Dummy metode for endring av passord.
    }

    public static void main(String[] args) {
        launch(args);
    }
}
