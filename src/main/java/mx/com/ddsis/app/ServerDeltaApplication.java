package mx.com.ddsis.app;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages="mx.com.ddsis")
public class ServerDeltaApplication {
	private final static Logger logger = Logger.getLogger(ServerDeltaApplication.class);
	
	
	public static void main(String[] args) {
		logger.info("Inicia el servicio");
		
		SpringApplication.run(ServerDeltaApplication.class, args);
	}
}
