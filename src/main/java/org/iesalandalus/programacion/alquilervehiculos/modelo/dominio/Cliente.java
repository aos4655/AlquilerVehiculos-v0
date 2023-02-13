package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Iterator;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cliente {
	private static final String ER_NOMBRE = "[A-Z][a-z]*(\\s[A-Z][a-z]*)?";
	private static final String ER_DNI = "[0-9]{8}[A-Z]";
	private static final String ER_TELEFONO = "[0-9]{9}$";
	private static final char[] LETRAS_DNI = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J',
            'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E' };
	private String nombre;
	private String dni;
	private String telefono;

	public Cliente(String nombre, String dni, String telefono) {
		setNombre(nombre);
		setDni(dni);
		setTelefono(telefono);
	}

	public Cliente(Cliente cliente) {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No es posible copiar un cliente nulo.");
		}
		else {
			setNombre(cliente.nombre);
			setDni(cliente.dni);
			setTelefono(cliente.telefono);
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null) {
			throw new NullPointerException("ERROR: El nombre no puede ser nulo.");
		}
		if (!nombre.matches(ER_NOMBRE)) {
			throw new IllegalArgumentException("ERROR: El nombre no tiene un formato válido.");

		}
		else {
			this.nombre = nombre;
		}
	}

	public String getDni() {
		return dni;
	}

	private void setDni(String dni) {
		if(dni == null) {
			throw new NullPointerException("ERROR: El DNI no puede ser nulo.");
		}
		Pattern patron = Pattern.compile(ER_DNI);
		Matcher matcher = patron.matcher(dni);
		if (matcher.find()) {
			if (comprobarLetraDni(dni)) {
				this.dni = dni;
			}
			else {
				throw new IllegalArgumentException("ERROR: La letra del DNI no es correcta.");
			}
		}
		else {
			throw new IllegalArgumentException("ERROR: El DNI no tiene un formato válido.");
		}
	}

	private static boolean comprobarLetraDni(String dni) {
		Character letra = dni.charAt(8);
		int numDni = Integer.parseInt(dni.substring(0, 8)) % 23;
		Character letraObtenida = LETRAS_DNI[numDni];
		return letra.equals(letraObtenida);
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		if (telefono == null) {
			throw new NullPointerException("ERROR: El teléfono no puede ser nulo.");
		}
		Pattern patron = Pattern.compile(ER_TELEFONO);
		Matcher matcher = patron.matcher(telefono);
		if (matcher.find() && telefono.length() == 9) {
			this.telefono = telefono;
		}
		else {
			throw new IllegalArgumentException("ERROR: El teléfono no tiene un formato válido.");
		}
		
	}

	public static Cliente getClienteConDni(String dni) {
		Cliente cliente;
		if(dni ==null) {
			throw new NullPointerException("ERROR: El DNI no puede ser nulo.");
		}
		if(!dni.matches(ER_DNI)) {
			throw new IllegalArgumentException("ERROR: El DNI no tiene un formato válido.");
			//cliente = new Cliente(getNombre(), dni, telefono);
		}
		else {
			if(!comprobarLetraDni(dni)) {
				throw new IllegalArgumentException("ERROR: La letra del DNI no es correcta.");
			}else {
				cliente = new Cliente("Cliente",dni,"666666666");
			}
		}
		return cliente;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(dni, other.dni);
	}

	@Override
	public String toString() {
		return nombre + " - " + dni + " (" + telefono + ")";
	}

}
