package ar.edu.unlam.pb1;

public interface Operacion {
	
	void realizarOperacion(Propiedad propiedad1, Propiedad propiedad2, Cliente cliente1, Cliente cliente2) throws PropiedadNoDisponibleException;
	
	void realizarOperacion(Propiedad propiedad1, Cliente cliente1) throws PropiedadNoDisponibleException;

}

