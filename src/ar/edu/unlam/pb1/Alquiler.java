package ar.edu.unlam.pb1;

import java.time.LocalDate;

public class Alquiler implements Operacion {

	private Propiedad propiedad;
	private Cliente propietario;
	private Cliente inquilino;
	private LocalDate fecha;

	public Alquiler(Propiedad propiedad, Cliente propietario, Cliente inquilino, LocalDate fecha) {
		this.propiedad = propiedad;
		this.propietario = propietario;
		this.inquilino = inquilino;
		this.fecha = fecha;
	}

	@Override
	public void realizarOperacion(Propiedad propiedad, Propiedad propiedad2, Cliente comprador, Cliente cliente2,
			LocalDate fecha) {
		throw new IllegalArgumentException(
				"La operación de alquiler solo debe involucrar una propiedad y un inquilino");

	}

	@Override
	public void realizarOperacion(Propiedad propiedad, Cliente inquilino, LocalDate fecha)
			throws PropiedadNoDisponibleException {
		if (propiedad.estaDisponiblePara(TipoDeOperacion.ALQUILER)) {
			inquilino.getPropiedadesAlquiladas().add(propiedad);
			propiedad.setInquilino(inquilino);
			propiedad.setEstaDisponible(false);
			this.fecha = fecha;
		} else {
			throw new PropiedadNoDisponibleException(
					"La propiedad que está intentando alquilar no se encuentra disponible");
		}
	}

	@Override
	public String toString() {
		return "Alquiler de propiedad (Código: " + propiedad.getCodigo() + ")\nDetalles de la propiedad:\n"
				+ propiedad.toString() + "\nDueño: " + propietario.toString() + "\nInquilino: " + inquilino.toString()
				+ "\nFecha: " + fecha.toString();
	}

	@Override
	public Propiedad getPropiedad() {
		return this.propiedad;
	}
}
