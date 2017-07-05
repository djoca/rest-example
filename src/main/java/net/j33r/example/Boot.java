package net.j33r.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Esta classe e responsavel por iniciar a aplicacao.
 *
 * @author Jose Antonio
 */
@SpringBootApplication
@ComponentScan(basePackages = "net.j33r.example")
public class Boot {

	public static void main(final String[] args) {
		SpringApplication.run(Boot.class, args);
	}
}
