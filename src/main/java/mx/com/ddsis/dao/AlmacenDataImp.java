package mx.com.ddsis.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.com.ddsis.comunes.Utilerias;
import mx.com.ddsis.pojo.RegistroBruto;
import mx.com.ddsis.pojo.RegistroMedida;

@Repository("almacenData")
public class AlmacenDataImp implements AlmacenData {
	


	private DataSource dataSource;	

	@Autowired
	protected JdbcTemplate jdbcT;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcT = new JdbcTemplate(this.dataSource);
	}

	
	private final DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	@Override
	@Transactional
	public int guardaRegistroBruto(RegistroBruto regBruto) {
		int ret = -1;
		
		String fhEntrada = df.format(regBruto.getFhEntrada());
		String tramaEntrante = regBruto.getTramaEntrante();
		String qUpdate = 
				"INSERT INTO delta.registro_bruto(FH_ENTRADA, TRAMA_ENTRANTE) "
				+ "VALUES(STR_TO_DATE(?, '%Y/%m/%d %H:%i:%s'),?) ";		
		
		
		ret = jdbcT.update(qUpdate, fhEntrada, tramaEntrante);
		
		return ret;	
	}

	@Override
	@Transactional
	public int guardaRegistroMedida(RegistroMedida regMedida) {
		int ret = -1;
		
		String qUpdate = 
				"INSERT INTO delta.registro_medida(ID_MAGNITUD, FH_REGISTRO, FH_SENSADA, VALOR_MAGNITUD, ID_DISPOSITIVO) "
				+ "VALUES(?, STR_TO_DATE(?, '%Y/%m/%d %H:%i:%s'), STR_TO_DATE(?, '%Y/%m/%d %H:%i:%s'), ?, ?) ";
		
		String fhRegistro = df.format(regMedida.getFhRegistro());
		String fhSensada = df.format(Utilerias.sumarRestarHorasFecha(regMedida.getFhSensada(),-6));
		
		ret = jdbcT.update(qUpdate, regMedida.getIdMagnitud(), fhRegistro, 
				fhSensada, regMedida.getValorMagnitud(), regMedida.getIdDispositivo());
		
		return ret;	}

}
