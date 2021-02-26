package dhbw.vs.uebungsblatt2client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@FeignClient(name="service2", url="http://localhost:8081")
public interface BankInterface {
    @GetMapping
    double getBaukreditzinssatz();

}