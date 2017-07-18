package de.miwoe;

import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringbootTxApplication {

	@Bean
	DataFactory dataFactory(){
		return new DataFactory();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootTxApplication.class, args);
	}
}
