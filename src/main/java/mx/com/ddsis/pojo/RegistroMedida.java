package mx.com.ddsis.pojo;

import java.io.Serializable;
import java.util.Date;

public class RegistroMedida implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3904698018793846105L;
	private double idRegistro;
	private double idMagnitud;
	private Date fhRegistro;
	private Date fhSensada;
	private String valorMagnitud;
	private String idDispositivo;
	public double getIdRegistro() {
		return idRegistro;
	}
	public void setIdRegistro(double idRegistro) {
		this.idRegistro = idRegistro;
	}
	public double getIdMagnitud() {
		return idMagnitud;
	}
	public void setIdMagnitud(double idMagnitud) {
		this.idMagnitud = idMagnitud;
	}
	public Date getFhRegistro() {
		return fhRegistro;
	}
	public void setFhRegistro(Date fhRegistro) {
		this.fhRegistro = fhRegistro;
	}
	public Date getFhSensada() {
		return fhSensada;
	}
	public void setFhSensada(Date fhSensada) {
		this.fhSensada = fhSensada;
	}
	
	public String getValorMagnitud() {
		return valorMagnitud;
	}
	public void setValorMagnitud(String valorMagnitud) {
		this.valorMagnitud = valorMagnitud;
	}
	public String getIdDispositivo() {
		return idDispositivo;
	}
	public void setIdDispositivo(String idDispositivo) {
		this.idDispositivo = idDispositivo;
	}
	
	
	
}
