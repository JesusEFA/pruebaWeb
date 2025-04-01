package com.hermandad_virgenesperanza.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration.class})
@SpringBootApplication
public class WebFinalEsperanzaApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebFinalEsperanzaApplication.class, args);
	}

}
