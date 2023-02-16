package org.iesalandalus.programacion.alquilervehiculos.vista;

import java.time.LocalDate;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
	private static final String PATRON_FECHA = "";
	private static final String FORMATO_FECHA = "";

	private Consola() {

	}

	public static void mostrarCabecera(String mensaje) {
		System.out.println(mensaje);
		String cadena = "";
		for (int i = 0; i < mensaje.length(); i++) {
			cadena += "-";
		}
		System.out.println(cadena);
	}

	public static void mostrarMenu() {
		mostrarCabecera("Gestion Alquileres");
		// mostrar opciones
		// llamar en cada opcion a su metodo
	}

	private static String leerCadena(String mensaje) {
		System.out.println(mensaje);
		return Entrada.cadena();
	}

	private static Integer leerEntero(String mensaje) {
		System.out.println(mensaje);
		return Entrada.entero();
	}

	private static LocalDate leerFecha(String mensaje) {
		System.out.println(mensaje);
		String cadena = Entrada.cadena();
		while (cadena.matches(FORMATO_FECHA)) {
			cadena = Entrada.cadena();			
		}
		//LocalDate l = cadena.formatted(PATRON_FECHA);
		return null;
	}

	public static Opcion elegirOpcion(){
	
		Opcion op = Opcion.get(Entrada.entero());
		while (op == null) {
			op.get(Entrada.entero());
		}
	}

	public static Cliente leerCliente() {
		return null;
	}

	public static Cliente leerClienteDni() {
		return null;
	}

	public static String leerNombre() {
		return null;
	}

	public static String leerTelefono() {
		return null;
	}

	public static Turismo leerTurismo() {
		return null;
	}

	public static Turismo leerTurismoMatricula() {
		return null;
	}

	public static Alquiler leerAlquiler() {
		return null;
	}

	public static LocalDate leerFechaDevolucion() {
		return null;
	}
}
