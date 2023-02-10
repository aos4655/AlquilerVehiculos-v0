package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Turismo {
	private static final String ER_MARCA = "([A-Z][a-z]+([ -]?[A-Z][a-z]+)?)|[A-Z]+";
	private static final String ER_MATRICULA = "[0-9]{4}[^AEIOU|^a-z]{3}";
	private String marca;
	private String modelo;
	private int cilindrada;
	private String matricula;

	public Turismo(String marca, String modelo, int cilindrada, String matricula) {
		setMarca(marca);
		setCilindrada(cilindrada);
		setMatricula(matricula);
		setModelo(modelo);
	}

	public Turismo(Turismo turismo) {
		if (turismo == null) {
			throw new NullPointerException("ERROR: No es posible copiar un turismo nulo.");
		}
		setMarca(turismo.marca);
		setCilindrada(turismo.cilindrada);
		setMatricula(turismo.matricula);
		setModelo(turismo.modelo);
	}

	public String getMarca() {
		return marca;
	}

	private void setMarca(String marca) {
		if (marca == null) {
			throw new NullPointerException("ERROR: La marca no puede ser nula.");
		}
		if (marca.matches(ER_MARCA)) {
			this.marca = marca;
		} else {
			throw new IllegalArgumentException("ERROR: La marca no tiene un formato válido.");
		}
	}

	public String getModelo() {
		return modelo;
	}

	private void setModelo(String modelo) {
		if (modelo == null) {
			throw new NullPointerException("ERROR: El modelo no puede ser nulo.");
		}
		if (modelo.isBlank()) {
			throw new IllegalArgumentException("ERROR: El modelo no puede estar en blanco.");
		} else {
			this.modelo = modelo;

		}

	}

	public int getCilindrada() {
		return cilindrada;
	}

	private void setCilindrada(int cilindrada) {
		if (cilindrada < 5000 && cilindrada > 0) {
			this.cilindrada = cilindrada;
		} else {
			throw new IllegalArgumentException("ERROR: La cilindrada no es correcta.");
		}
	}

	public String getMatricula() {
		return matricula;
	}

	private void setMatricula(String matricula) {
		if (matricula == null) {
			throw new NullPointerException("ERROR: La matrícula no puede ser nula.");
		}
		if (!matricula.matches(ER_MATRICULA)) {
			throw new IllegalArgumentException("ERROR: La matrícula no tiene un formato válido.");
		} else {
			this.matricula = matricula;
		}
	}

	public static Turismo getTurismoConMatricula(String matricula) {
		Turismo t;
		if (matricula == null) {
			throw new NullPointerException("ERROR: La matrícula no puede ser nula.");
		}
		if (!matricula.matches(ER_MATRICULA)) {
			throw new IllegalArgumentException("ERROR: La matrícula no tiene un formato válido.");
		}else {
			t = new Turismo("Land Rover", "Seat", 500, matricula);
		}
		
		return t;
	}

	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turismo other = (Turismo) obj;
		return Objects.equals(matricula, other.matricula);
	}

	@Override
	public String toString() {
		return marca + " " + modelo + " (" + cilindrada + "CV) - "
				+ matricula ;
	}
	
	
}
