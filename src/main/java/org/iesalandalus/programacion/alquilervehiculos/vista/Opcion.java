package org.iesalandalus.programacion.alquilervehiculos.vista;

public enum Opcion {
	SALIR("Salir"),
	INSERTAR_CLIENTE("Insertar Cliente"),
	INSERTAR_TURISMO("Insertar Turismo"),
	INSERTAR_ALQUILER("Insertar Alquiler"),
	BUSCAR_CLIENTE("Buscar Cliente"),
	BUSCAR_TURISMO("Buscar Turismo"),
	BUSCAR_ALQUILER("Buscar Alquiler"),
	MODIFICAR_CLIENTE("Modificar Cliente"),
	DEVOLVER_ALQUILER("Devolver Alquiler"),
	BORRAR_CLIENTE("Borrar Cliente"),
	BORRAR_TURISMO("Borrar Turismo"),
	BORRAR_ALQUILER("Borrar Alquiler"),
	LISTAR_CLIENTES("Listar Clientes"),
	LISTAR_TURISMOS("Listar Turismos"),
	LISTAR_ALQUILERES("Listar Alquileres"),
	LISTAR_ALQUILERES_CLIENTE("Listar Alquileres Cliente"),
	LISTAR_ALQUILERES_TURISMO("Listar Alquileres Turismo");
	
	private String cadenaAMostrar;

	private static boolean esOrdinalValido(int ordinal) {
		boolean comprobar = false;
		if(ordinal < Opcion.values().length && ordinal >= 0) {
			comprobar = true;
		}
		return comprobar;
	}
	public static Opcion get(int ordinal) {
		Opcion op = null;
		if(esOrdinalValido(ordinal)) {
			op = Opcion.values()[ordinal];
		}
		return null;
	}
	private Opcion(String cadenaAMostrar) {
		this.cadenaAMostrar = cadenaAMostrar;
	}
	
	public String toString() {
		return String.format("% %s", ordinal(), cadenaAMostrar);
	}
}
