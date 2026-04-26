package com.lorenzo.backend.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principal que inicializa a aplicação Spring Boot de backend de login.
 *
 * @author Lorenzo Bruscato
 */
@SpringBootApplication
public class BackendLoginApplication {


    /**
     * Ponto de entrada da aplicação.
     *
     * @param args argumentos de linha de comando
     */
    public static void main(String[] args) {
        SpringApplication.run(BackendLoginApplication.class, args);
    }

}