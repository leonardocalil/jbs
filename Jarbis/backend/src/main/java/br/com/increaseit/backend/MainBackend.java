package br.com.increaseit.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


//@SpringBootApplication
//@ComponentScan("br.com.increaseit.backend.*")
public class MainBackend{
	public static void main (String[] args) {
        SpringApplication.run(MainBackend.class, args);
    }
}
