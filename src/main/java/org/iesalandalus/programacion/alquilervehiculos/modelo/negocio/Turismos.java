package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

public class Turismos {

	private List<Turismo> coleccionTurismos;

	public Turismos() {
		coleccionTurismos = new ArrayList<Turismo>();
	}

	public List<Turismo> get() {
		return new ArrayList<Turismo>(coleccionTurismos);
	}

	public int getCantidad() {
		return coleccionTurismos.size();
	}

	public void insertar(Turismo turismo) throws OperationNotSupportedException {
		if (turismo == null) {
			throw new NullPointerException("ERROR: No se puede insertar un turismo nulo.");
		}
		if (buscar(turismo) != null) {
			throw new OperationNotSupportedException("ERROR: Ya existe un turismo con esa matrícula.");
		} else {
			coleccionTurismos.add(turismo);
		}
	}

	public void borrar(Turismo turismo) throws OperationNotSupportedException {
		if (turismo == null) {
			throw new NullPointerException("ERROR: No se puede borrar un turismo nulo.");
		}
		if (buscar(turismo) == null) {
			throw new OperationNotSupportedException("ERROR: No existe ningún turismo con esa matrícula.");
		} else {
			coleccionTurismos.remove(turismo);
		}
	}

	public Turismo buscar(Turismo cliente) {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede buscar un turismo nulo.");
		}
		return coleccionTurismos.indexOf(cliente) != -1 ? coleccionTurismos.get(coleccionTurismos.indexOf(cliente)) : null;
	}


}
