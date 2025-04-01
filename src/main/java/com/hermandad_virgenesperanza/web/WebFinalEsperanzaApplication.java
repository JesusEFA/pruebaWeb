package com.hermandad_virgenesperanza.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {HibernateJpaAutoConfiguration.class})
public class WebFinalEsperanzaApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebFinalEsperanzaApplication.class, args);
	}

}
