package mx.com.ddsis.controller;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.com.ddsis.pojo.RegistroBruto;
import mx.com.ddsis.service.AlmacenServ;

@RestController
public class Controller {
	
	private final static Logger logger = Logger.getLogger(Controller.class);
	
	@Autowired
	@Qualifier("almacenServ")
	AlmacenServ almacenServ;
	
	
	@RequestMapping("/")
	public int gatherer(@RequestParam(required = true)String data){
	 
		logger.info("Data:\n"+data);
		RegistroBruto rb = new RegistroBruto();
		rb.setFhEntrada(new Date());
		rb.setTramaEntrante(data);		
		int ret = almacenServ.guardaRegistroBruto(rb);
	 
		return ret;
	}

}
