package mx.com.ddsis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import mx.com.ddsis.comunes.Utilerias;
import mx.com.ddsis.dao.AlmacenData;
import mx.com.ddsis.pojo.RegistroBruto;
import mx.com.ddsis.pojo.RegistroMedida;

@Service("almacenServ")
public class AlmacenServImp implements AlmacenServ {

	@Autowired
	@Qualifier("almacenData")
	AlmacenData almacenData;
	
	@Override
	public int guardaRegistroBruto(RegistroBruto regBruto) {
				
		int ret = almacenData.guardaRegistroBruto(regBruto);
		
		List<RegistroMedida> listMedidas = Utilerias.parserTrama(regBruto);
		
		for(RegistroMedida r: listMedidas){
			ret += almacenData.guardaRegistroMedida(r);
		}
		
		
		return ret;
	}

}
