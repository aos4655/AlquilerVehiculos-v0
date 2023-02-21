package org.iesalandalus.programacion.alquilervehiculos.vista;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
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

	public void comenzar() throws OperationNotSupportedException {
		Consola.mostrarMenu();
		ejecutar(Consola.elegirOpcion());
	}

	public void terminar() {
		System.out.println("Adios!");
	}

	public void ejecutar(Opcion opcion) throws OperationNotSupportedException {
		while (opcion != Opcion.SALIR) {
			switch (opcion) {
				case INSERTAR_CLIENTE: {
					insertarCliente();
					break;
				}
				case INSERTAR_TURISMO: {
					insertarTurismo();
					break;
				}
				case INSERTAR_ALQUILER: {
					insertarAlquiler();
					break;
				}
				case BUSCAR_CLIENTE: {
					buscarCliente();
					break;
				}
				case BUSCAR_TURISMO: {
					buscarTurismo();
					break;
				}
				case BUSCAR_ALQUILER: {
					buscarAlquiler();
					break;
				}
				case MODIFICAR_CLIENTE: {
					modificarCliente();
					break;
				}
				case DEVOLVER_ALQUILER: {
					devolverAlquiler();
					break;
				}
				case BORRAR_CLIENTE: {
					borrarCliente();
					break;
				}
				case BORRAR_TURISMO: {
					borrarTurismo();
					break;
				}
				case BORRAR_ALQUILER: {
					borrarAlquiler();
					break;
				}
				case LISTAR_CLIENTES: {
					listarClientes();
					break;
				}
				case LISTAR_TURISMOS: {
					listarTurismos();
					break;
				}
	
				case LISTAR_ALQUILERES: {
					listarAlquileres();
					break;
				}
				case LISTAR_ALQUILERES_CLIENTE: {
					listarAlquileresCliente();
					break;
				}
				case LISTAR_ALQUILERES_TURISMO: {
					listarAlquileresTurismo();
					break;
				}
			}
			comenzar();

		}

		controlador.terminar();

	}

	public void insertarCliente() throws OperationNotSupportedException {
		Consola.mostrarCabecera("Insertar Cliente");
		try {
			controlador.insertar(Consola.leerCliente());
			System.out.println("Cliente insertado correctamente");
		} catch (IllegalArgumentException | NullPointerException | OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
	}

	public void insertarTurismo() throws OperationNotSupportedException {
		try {
			Consola.mostrarCabecera("Insertar Turismo");
			controlador.insertar(Consola.leerTurismo());
			System.out.println("Turismo insertado correctamente");
		} catch (IllegalArgumentException | NullPointerException | OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
	}

	public void insertarAlquiler() throws OperationNotSupportedException {
		try {
			Alquiler alquiler = Consola.leerAlquiler();
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
		
			Consola.mostrarCabecera("Insertar alquiler");
			controlador.insertar(new Alquiler(cli, t, alquiler.getFechaAlquiler()));
			System.out.println("Alquiler insertado correctamente");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void buscarCliente() {
		try {
			Consola.mostrarCabecera("Buscar cliente");
			System.out.println(controlador.buscar(Consola.leerClienteDni()));
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}

	public void buscarTurismo() {
		try {
			Consola.mostrarCabecera("Buscar turismo");
			System.out.println(controlador.buscar(Consola.leerTurismoMatricula()));
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}

	public void buscarAlquiler() {
		try {
			Consola.mostrarCabecera("Buscar alquiler");
			
			Alquiler alquiler = Consola.leerAlquiler();
			System.out.println(alquiler);
			
			System.out.println(controlador.buscar(alquiler));
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}

	public void modificarCliente() throws OperationNotSupportedException {
		try {
			Consola.mostrarCabecera("Modificar cliente");
			controlador.modificar(Consola.leerClienteDni(), Consola.leerNombre(), Consola.leerTelefono());
			System.out.println("Cliente modificado correctamente");
		} catch (IllegalArgumentException | NullPointerException | OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
	}

	public void devolverAlquiler() throws OperationNotSupportedException {
		try {
			Consola.mostrarCabecera("Devolver alquiler");
			controlador.devolver(Consola.leerAlquiler(), Consola.leerFechaDevolucion());
		} catch (IllegalArgumentException | NullPointerException | OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
	}

	public void borrarCliente() throws OperationNotSupportedException {
		try {
			Consola.mostrarCabecera("Borrar cliente");
			controlador.borrar(Consola.leerClienteDni());
			System.out.println("Cliente borrado correctamente");
		} catch (IllegalArgumentException | NullPointerException | OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}

	}

	public void borrarTurismo() throws OperationNotSupportedException {
		try {
			Consola.mostrarCabecera("Borrar turismo");
			controlador.borrar(Consola.leerTurismoMatricula());
			System.out.println("Turismo borrado correctamente");
		} catch (IllegalArgumentException | NullPointerException | OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
	}

	public void borrarAlquiler() throws OperationNotSupportedException {
		try {
			Consola.mostrarCabecera("Borrar alquiler");
			controlador.borrar(Consola.leerAlquiler());
			System.out.println("Alquiler borrado correctamente");
		} catch (IllegalArgumentException | NullPointerException | OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
	}

	public void listarClientes() {
		try {
			Consola.mostrarCabecera("Listado Clientes");
			System.out.println(controlador.getClientes());
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}

	public void listarTurismos() {
		try {
			Consola.mostrarCabecera("Listado Turismos");
			System.out.println(controlador.getTurismos());
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}

	public void listarAlquileres() {
		try {
			Consola.mostrarCabecera("Listado Alquileres");
			System.out.println(controlador.getAlquileres());
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}

	public void listarAlquileresCliente() {
		try {
			Cliente cliente = Consola.leerClienteDni();
			Consola.mostrarCabecera("Listado Alquileres del cliente con dni " + cliente.getDni());
			System.out.println(controlador.getAlquileres(cliente));
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}

	public void listarAlquileresTurismo() {
		try {
			Turismo turismo = Consola.leerTurismoMatricula();
			Consola.mostrarCabecera("Listado Alquileres del turismo con matricula " + turismo.getMatricula());
			System.out.println(controlador.getAlquileres(turismo));
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}

}
