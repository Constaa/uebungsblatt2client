package dhbw.vs.uebungsblatt2client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.Map;

@FeignClient(name="service", url="http://localhost:8080/zinsen")
public interface Interface {
    @GetMapping("/laufzeit")
    int berechneLaufzeitInMonaten(
            @RequestParam double kreditbetrag,
            @RequestParam double zinssatz,
            @RequestParam double rueckzahlung);
    @GetMapping(path = "/rueckzahlungsplan")
    Collection<Double> rueckzahlungsplan(
            @RequestParam double kreditbetrag,
            @RequestParam double zinssatz,
            @RequestParam double rueckzahlung);

}



