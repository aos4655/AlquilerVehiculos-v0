package org.iesalandalus.programacion.alquilervehiculos.vista;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Alquileres;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Clientes;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Turismos;

public class Vista {

	private Controlador controlador;

	public void setControlador(Controlador controlador) {
		if (controlador != null) {
			this.controlador = controlador;
		}
	}

	public void comenzar() {
		// menu con opciones
		// pedir opcion por consola
		// ejecutar mientras la opcion no sea salir
		System.out.println("Menu de opciones");
		for (int i = 0; i < Opcion.values().length; i++) {
			System.out.println(i + "" + Opcion.values()[i]);
		}
		System.out.println("Elija una opcion");

	}

	public void terminar() {
		System.out.println("Adios!");
	}

	public void ejecutar(Opcion opcion) {
		// Dada una opcion llamar a su metodo
	}

	public void insertar(Cliente cliente) throws OperationNotSupportedException {
		controlador.insertar(cliente);
	}

	public void insertar(Turismo turismo) throws OperationNotSupportedException {
		controlador.insertar(turismo);
	}

	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede realizar un alquiler nulo.");
		}
		Cliente cli = controlador.buscar(alquiler.getCliente());
		if (cli == null) {
			throw new OperationNotSupportedException("ERROR: No existe el cliente del alquiler.");
		}
		Turismo t = controlador.buscar(alquiler.getTurismo());
		if (t == null) {
			throw new OperationNotSupportedException("ERROR: No existe el turismo del alquiler.");
		}
		controlador.insertar(new Alquiler(cli, t, alquiler.getFechaAlquiler()));

	}

	public Cliente buscar(Cliente cliente) {
		return controlador.buscar(cliente);
	}

	public Turismo buscar(Turismo turismo) {
		return controlador.buscar(turismo);
	}

	public Alquiler buscar(Alquiler alquiler) {
		return controlador.buscar(alquiler);
	}

	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {
		controlador.modificar(cliente, nombre, telefono);
	}

	public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws OperationNotSupportedException {
		controlador.devolver(alquiler, fechaDevolucion);
	}

	public void borrar(Cliente cliente) throws OperationNotSupportedException {
		controlador.borrar(cliente);
		;
	}

	public void borrar(Turismo turismo) throws OperationNotSupportedException {
		controlador.borrar(turismo);
	}

	public void borrar(Alquiler alquiler) throws OperationNotSupportedException {
		controlador.borrar(alquiler);
	}

	public void listarClientes() {
		controlador.getClientes();
	}

	public void listarTurismos() {
		controlador.getTurismos();
	}

	public void listarAlquileres() {
		controlador.getAlquileres();
	}

	public void listarAlquileresCliente(Cliente cliente) {
		controlador.getAlquileres(cliente);
	}

	public void listarAlquileresTurismo(Turismo turismo) {
		controlador.getAlquileres(turismo);
	}

}
