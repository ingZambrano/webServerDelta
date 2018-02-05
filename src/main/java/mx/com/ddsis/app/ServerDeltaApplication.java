package mx.com.ddsis.app;

import mx.com.ddsis.comunes.ConexionesBD;

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
		
		if(ServerDeltaApplication.testConexion("localhost", "3306", 
				"root", "lebrucita")){
			logger.info("Conexion a BD exitosa");
		}else{
			logger.info("No se pudo conectar a la base de datos");
			logger.info("Se termina la ejecucion");
			System.exit(0);
		}
		
		
		
		SpringApplication.run(ServerDeltaApplication.class, args);
	}
	
	private static boolean testConexion(String host, String port, String usr, String pass){
		return ConexionesBD.testConexionBD(host, port, usr, pass);
	}
	
}
