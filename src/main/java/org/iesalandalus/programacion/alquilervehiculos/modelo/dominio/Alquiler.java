package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

import javax.naming.OperationNotSupportedException;

public class Alquiler {
	static DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static int PRECIO_DIA = 29;//// EL PROFESOR PONE QUE ES 20 Y EL TEST DICE 29
	private LocalDate fechaAlquiler;
	private LocalDate fechaDevolucion;
	private Cliente cliente;
	private Turismo turismo;

	public LocalDate getFechaAlquiler() {
		return fechaAlquiler;
	}

	public void setFechaAlquiler(LocalDate fechaAlquiler) {
		if (fechaAlquiler == null) {
			throw new NullPointerException("ERROR: La fecha de alquiler no puede ser nula.");
		}
		if (fechaAlquiler.compareTo(LocalDate.now()) > 0) {
			throw new IllegalArgumentException("ERROR: La fecha de alquiler no puede ser futura.");
		}
		this.fechaAlquiler = fechaAlquiler;
	}

	public Alquiler(Cliente cliente, Turismo turismo, LocalDate fechaAlquiler) {
		setCliente(cliente);
		setFechaAlquiler(fechaAlquiler);
		setTurismo(turismo);
	}

	public Alquiler(Alquiler alquiler) {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No es posible copiar un alquiler nulo.");
		} else {
			setCliente(new Cliente(alquiler.cliente.getNombre(), alquiler.cliente.getDni(),
					alquiler.cliente.getTelefono()));
			setFechaAlquiler(alquiler.fechaAlquiler);
			setTurismo(new Turismo(alquiler.turismo.getMarca(), alquiler.turismo.getModelo(),
					alquiler.turismo.getCilindrada(), alquiler.turismo.getMatricula()));
			setFechaDevolucion(alquiler.getFechaDevolucion());
		}

	}

	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}

	private void setFechaDevolucion(LocalDate fechaDevolucion) {
		if (fechaDevolucion == null) {
			throw new NullPointerException("ERROR: La fecha de devolución no puede ser nula.");
		}
		if (fechaDevolucion.compareTo(LocalDate.now()) == 1) {
			throw new IllegalArgumentException("ERROR: La fecha de devolución no puede ser futura.");
		}
		if (fechaDevolucion.compareTo(getFechaAlquiler()) <= 0) {
			throw new IllegalArgumentException(
					"ERROR: La fecha de devolución debe ser posterior a la fecha de alquiler.");
		}
		this.fechaDevolucion = fechaDevolucion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	private void setCliente(Cliente cliente) {
		if (cliente == null) {
			throw new NullPointerException("ERROR: El cliente no puede ser nulo.");
		}
		this.cliente = cliente;
		// this.cliente = new Cliente(cliente.getNombre(), cliente.getDni(),
		// cliente.getTelefono());
	}

	public Turismo getTurismo() {
		return turismo;
	}

	private void setTurismo(Turismo turismo) {
		if (turismo == null) {
			throw new NullPointerException("ERROR: El turismo no puede ser nulo.");
		}
		this.turismo = turismo;
		// this.turismo = new Turismo(turismo.getMarca(),
		// turismo.getModelo(),turismo.getCilindrada(),turismo.getMatricula());
	}

	public void devolver(LocalDate fechaDevolucion) throws OperationNotSupportedException {
		if (getFechaDevolucion() != null) {
			throw new OperationNotSupportedException("ERROR: La devolución ya estaba registrada.");
		} else {
			setFechaDevolucion(fechaDevolucion);
		}
	}

	public int getPrecio() {
		long dias;
		// .get(getFechaAlquiler());
		if (getFechaDevolucion() == null) {
			dias = 0;
		} else {
			dias = ChronoUnit.DAYS.between(getFechaAlquiler(), getFechaDevolucion());
		}
		return PRECIO_DIA * (int) dias;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, fechaAlquiler, fechaDevolucion, turismo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alquiler other = (Alquiler) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(fechaAlquiler, other.fechaAlquiler)
				&& Objects.equals(fechaDevolucion, other.fechaDevolucion) && Objects.equals(turismo, other.turismo);
	}

	@Override
	public String toString() {
		String cadena;
		if (getFechaDevolucion() == null) {
			cadena = cliente + " <---> " + turismo + ", " + getFechaAlquiler().format(FORMATO_FECHA)
					+ " - Aún no devuelto (" + 0 + "€)";
		} else {
			cadena = cliente + " <---> " + turismo + ", " + getFechaAlquiler().format(FORMATO_FECHA) + " - "
					+ getFechaDevolucion().format(FORMATO_FECHA) + " (" + getPrecio() + "€)";
		}
		return cadena;
	}

}
