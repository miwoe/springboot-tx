package de.miwoe;

import org.fluttercode.datafactory.impl.DataFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class SpringbootTxApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringbootTxApplication.class);


	@Bean
	DataFactory dataFactory(){
		return new DataFactory();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootTxApplication.class, args);

		log.info("*** Use http://localhost:8080/test/get to get a foo (and no Lazy Exception if transaction is active.");
	}
}
