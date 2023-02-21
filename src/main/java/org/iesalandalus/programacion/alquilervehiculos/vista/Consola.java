package org.iesalandalus.programacion.alquilervehiculos.vista;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Turismos;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
	private static final String PATRON_FECHA = "dd/MM/yyyy";
	private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern(PATRON_FECHA);

	private Consola() {

	}

	public static void mostrarCabecera(String mensaje) {
		System.out.println("\n"+mensaje);
		String cadena = "";
		for (int i = 0; i < mensaje.length(); i++) {
			cadena += "-";
		}
		System.out.println(cadena);
	}

	public static void mostrarMenu() {
		mostrarCabecera("Gestion Alquileres");
		System.out.println("Menu de opciones");
		for (int i = 0; i < Opcion.values().length; i++) {
			System.out.println(Opcion.values()[i]);
		}
		
	}

	private static String leerCadena(String mensaje) {
		System.out.print(mensaje);
		return Entrada.cadena();
	}

	private static Integer leerEntero(String mensaje) {
		System.out.print(mensaje);
		return Entrada.entero();
	}

	private static LocalDate leerFecha(String mensaje) {
		LocalDate fechaLeida = LocalDate.parse(leerCadena(mensaje + " (" + PATRON_FECHA +") "), FORMATO_FECHA);
		return fechaLeida;
	}

	public static Opcion elegirOpcion() {
		int numOpcion = leerEntero("Elije una opcion: ");
		Opcion op = Opcion.get(numOpcion);
		while (op == null) {
			numOpcion = leerEntero("Elije una opcion: ");
			op = Opcion.get(numOpcion);
		}
		return op;
	}

	public static Cliente leerCliente() {
		return new Cliente(leerNombre(), leerCadena("Introduce un dni: "), leerTelefono());
	}

	public static Cliente leerClienteDni() {
		return Cliente.getClienteConDni(leerCadena("Introduce dni del cliente: "));
	}

	public static String leerNombre() {
		return leerCadena("Introduce nombre del cliente: ");
	}

	public static String leerTelefono() {
		return leerCadena("Introduce telefono del cliente: ");
	}

	public static Turismo leerTurismo() {
		return new Turismo(leerCadena("Introduce la marca: "), leerCadena("Introduce el modelo: "), leerEntero("Introduce la cilindrada: "), leerCadena("Introduce la matricula :"));
	}

	public static Turismo leerTurismoMatricula() {
		return Turismo.getTurismoConMatricula(leerCadena("Introduce la matricula del turismo: "));
	}

	public static Alquiler leerAlquiler() {
		return new Alquiler(leerClienteDni(), leerTurismoMatricula(), leerFecha("Introduce una fecha de Alquiler"));
	}

	public static LocalDate leerFechaDevolucion() {
		return leerFecha("Introduce la fecha de devolucion: ");
	}
}
