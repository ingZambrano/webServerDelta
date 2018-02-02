package mx.com.ddsis.dao;


import mx.com.ddsis.pojo.RegistroBruto;
import mx.com.ddsis.pojo.RegistroMedida;

public interface AlmacenData {
	
	public int guardaRegistroBruto(RegistroBruto regBruto);
	public int guardaRegistroMedida(RegistroMedida regMedida);
}
