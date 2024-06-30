package ar.edu.unlam.pb1;

import java.time.LocalDate;

public interface Operacion {

	void realizarOperacion(Propiedad propiedad1, Propiedad propiedad2, Cliente cliente1, Cliente cliente2, LocalDate fechaOperacion)
			throws PropiedadNoDisponibleException;

	void realizarOperacion(Propiedad propiedad1, Cliente cliente1, LocalDate fechaOperacion) throws PropiedadNoDisponibleException;
	
	String toString();
	
	Propiedad getPropiedad();
}
