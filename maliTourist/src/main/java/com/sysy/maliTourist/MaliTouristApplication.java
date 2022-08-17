package com.sysy.maliTourist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/* Permet d'indiquer que la classes principale est une classe spring boot
 et elle introduit le concept de l'auto configuration */
@SpringBootApplication
@EnableSwagger2

public class MaliTouristApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaliTouristApplication.class, args);
	}



}
