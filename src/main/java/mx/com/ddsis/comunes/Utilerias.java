package mx.com.ddsis.comunes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mx.com.ddsis.pojo.RegistroBruto;
import mx.com.ddsis.pojo.RegistroMedida;

public class Utilerias {
	
	private static final DateFormat df = new SimpleDateFormat("d/M/yyyy H:m:s");
	
	private static final int ID_MAGNITUD_TEM_INT = 1;
	private static final int ID_MAGNITUD_TEM_EXT = 2;
	private static final int ID_MAGNITUD_CORRIENTE = 3;
	private static final int ID_MAGNITUD_VOLTAJE = 4;
	
	public static List<RegistroMedida> parserTrama(RegistroBruto rb){
		List<RegistroMedida> ret = new ArrayList<RegistroMedida>();
		
		//17:1:2018:19:3:19,A0001,110.10,3.00,19.38,1.124
		String[] cadena = rb.getTramaEntrante().split(",");
		String[] cadenaFecha = cadena[0].split(":");
		Date fhSensada = null;
		Date fhRegistro = null;
		String idDispositivo = null;
		
		StringBuilder fechaBuild = new StringBuilder();
		fechaBuild.append(cadenaFecha[0]);
		fechaBuild.append("/");
		fechaBuild.append(cadenaFecha[1]);
		fechaBuild.append("/");
		fechaBuild.append(cadenaFecha[2]);		
		fechaBuild.append(" ");
		fechaBuild.append(cadenaFecha[3]);
		fechaBuild.append(":");
		fechaBuild.append(cadenaFecha[4]);
		fechaBuild.append(":");
		fechaBuild.append(cadenaFecha[5]);		
		try {
			fhSensada = df.parse(fechaBuild.toString());
			fhRegistro = rb.getFhEntrada();			
			idDispositivo = cadena[1];
		} catch (ParseException e) {
			e.printStackTrace();
		}	
		
		RegistroMedida medidaVoltaje = new RegistroMedida();
		RegistroMedida medidaCorriente = new RegistroMedida();
		RegistroMedida medidaTempInt = new RegistroMedida();
		RegistroMedida medidaTempExt = new RegistroMedida();
		
		//Guardamos el valor del voltaje
		medidaVoltaje.setFhRegistro(fhRegistro);
		medidaVoltaje.setFhSensada(fhSensada);
		medidaVoltaje.setIdDispositivo(idDispositivo);
		medidaVoltaje.setIdMagnitud(ID_MAGNITUD_VOLTAJE);
		medidaVoltaje.setValorMagnitud(cadena[2]);
		//Guardamos el valor de la corriente
		medidaCorriente.setFhRegistro(fhRegistro);
		medidaCorriente.setFhSensada(fhSensada);
		medidaCorriente.setIdDispositivo(idDispositivo);
		medidaCorriente.setIdMagnitud(ID_MAGNITUD_CORRIENTE);
		medidaCorriente.setValorMagnitud(cadena[5]);
		//Guardamos el valor de la temperatura externa
		medidaTempExt.setFhRegistro(fhRegistro);
		medidaTempExt.setFhSensada(fhSensada);
		medidaTempExt.setIdDispositivo(idDispositivo);
		medidaTempExt.setIdMagnitud(ID_MAGNITUD_TEM_EXT);
		medidaTempExt.setValorMagnitud(cadena[4]);		
		//Guardamos el valor de la temperatura interna
		medidaTempInt.setFhRegistro(fhRegistro);
		medidaTempInt.setFhSensada(fhSensada);
		medidaTempInt.setIdDispositivo(idDispositivo);
		medidaTempInt.setIdMagnitud(ID_MAGNITUD_TEM_INT);
		medidaTempInt.setValorMagnitud(cadena[3]);
		
		ret.add(medidaVoltaje);
		ret.add(medidaCorriente);
		ret.add(medidaTempExt);
		ret.add(medidaTempInt);
		
		return ret;
	}
	
	

}
