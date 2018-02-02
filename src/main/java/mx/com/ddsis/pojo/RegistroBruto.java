package mx.com.ddsis.pojo;

import java.io.Serializable;
import java.util.Date;

public class RegistroBruto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -686536930799555517L;
	
	private double idRegistro;
	private Date fhEntrada;
	private String tramaEntrante;
	
	
	public double getIdRegistro() {
		return idRegistro;
	}
	public void setIdRegistro(double idRegistro) {
		this.idRegistro = idRegistro;
	}
	public Date getFhEntrada() {
		return fhEntrada;
	}
	public void setFhEntrada(Date fhEntrada) {
		this.fhEntrada = fhEntrada;
	}
	public String getTramaEntrante() {
		return tramaEntrante;
	}
	public void setTramaEntrante(String tramaEntrante) {
		this.tramaEntrante = tramaEntrante;
	}
	
	
	
}
