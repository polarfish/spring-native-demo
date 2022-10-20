package com.example.nativedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportRuntimeHints;

@SpringBootApplication
@ImportRuntimeHints(NativeDemoHintsRegistrar.class)
public class NativeDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(NativeDemoApplication.class, args);
    }

}
