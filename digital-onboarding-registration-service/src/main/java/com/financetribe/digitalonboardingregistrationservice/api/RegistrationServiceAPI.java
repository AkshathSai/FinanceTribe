package com.financetribe.digitalonboardingregistrationservice.api;

import com.financetribe.digitalonboardingregistrationservice.model.FormData;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class RegistrationServiceAPI {

    private final Environment environment;

    public RegistrationServiceAPI(Environment environment) {
        this.environment = environment;
    }

    @EventListener({
            ApplicationReadyEvent.class,
            RefreshScopeRefreshedEvent.class
    })
    public void onEvent() {
        System.out.println("New value: " + this.readValue());
    }

    @GetMapping("/value")
    String read() {
        return this.readValue();
    }

    public String readValue() {
        //return this.environment.getProperty("spring.mail.username");
        return this.environment.getProperty("cnj.message");
    }

    @PostMapping("/register")
    public void createUser(@RequestBody FormData formData) {
        System.out.println(formData);
    }

}
