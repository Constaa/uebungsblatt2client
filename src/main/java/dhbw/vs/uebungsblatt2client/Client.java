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
        double kreditbetrag = 150000;
        double zinssatz = 0.9;
        double rueckzahlung = 1500;
// mit GET-Aufruf Laufzeit berechnen
        double laufzeitInMonate = service.berechneLaufzeitInMonaten(kreditbetrag, zinssatz, rueckzahlung);
        System.out.println("Monate: " + laufzeitInMonate);
        System.out.println();
// mit GET-Aufruf Rückzahlungsplan berechnen
        Collection<Double> rueckzahlungsplan = service.rueckzahlungsplan(kreditbetrag, zinssatz, rueckzahlung);
        System.out.println(rueckzahlungsplan);
        int i = 0;
        for (double d: rueckzahlungsplan) {
            System.out.println("Monat: "+i +" "+ "Restbetrag: "+ d);
            i++;
        }
    }
}