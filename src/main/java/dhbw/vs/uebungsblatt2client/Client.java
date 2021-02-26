package dhbw.vs.uebungsblatt2client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class Client implements CommandLineRunner {

    @Autowired
    Interface service;
    @Override
    public void run(String... args) throws Exception {
        double kreditbetrag = Double.parseDouble(args[0]);
        double zinssatz = Double.parseDouble(args[1]);
        double rueckzahlung = Integer.parseInt(args[2]);
// mit GET-Aufruf Laufzeit berechnen
        double laufzeitInMonate = service.berechneLaufzeitInMonaten(kreditbetrag, zinssatz, rueckzahlung);
        System.out.println("Monate: " + laufzeitInMonate);
        System.out.println();
// mit GET-Aufruf Rückzahlungsplan berechnen
        Collection<Double> rueckzahlungsplan = service.rueckzahlungsplan(kreditbetrag, zinssatz, rueckzahlung);
        for (int i = 0; i < rueckzahlungsplan.size() ; i++) {
            System.out.println("Monat: "+i+ "Restbetrag: "+ service.getRestbetrag(kreditbetrag, zinssatz, rueckzahlung));
            System.out.println();
        }

    }
}