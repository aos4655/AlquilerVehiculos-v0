package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

public class Turismo {
	private static final String ER_MARCA;
	private static final String ER_MATRICULA;
	private String marca;
	private String modelo;
	private int cilindrada;
	private String matricula;

	public Turismo(String marca, String modelo, int cilindrada, String matricula) {

	}

	public Turismo(Turismo turismo) {

	}

	public String getMarca() {
		return marca;
	}

	private void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	private void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	private void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}

	public String getMatricula() {
		return matricula;
	}

	private void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getTurismoConMatricula(String matricula) {
		return null;
	}
}
