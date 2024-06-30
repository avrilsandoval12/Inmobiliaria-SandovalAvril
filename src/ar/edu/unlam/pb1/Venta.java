package ar.edu.unlam.pb1;

import java.time.LocalDate;

public class Venta implements Operacion {

	private Propiedad propiedad;
	private Cliente vendedor;
	private Cliente comprador;
	private LocalDate fecha;

	public Venta(Propiedad propiedad, Cliente vendedor, Cliente comprador, LocalDate fecha) {
		this.propiedad = propiedad;
		this.vendedor = vendedor;
		this.comprador = comprador;
		this.fecha = fecha;
	}

	
	@Override
	public void realizarOperacion(Propiedad propiedad, Propiedad propiedad2, Cliente comprador, Cliente cliente2,
			LocalDate fecha) {
		throw new IllegalArgumentException("La operación de venta solo debe involucrar una propiedad y un comprador");

	}

	@Override
	public void realizarOperacion(Propiedad propiedad, Cliente comprador, LocalDate fecha)
			throws PropiedadNoDisponibleException {
		if (propiedad.estaDisponiblePara(TipoDeOperacion.VENTA)) {
			comprador.getPropiedadesCompradas().add(propiedad);
			propiedad.setPropietario(comprador);
			propiedad.setEstaDisponible(false);
			this.fecha = fecha;
		} else {
			throw new PropiedadNoDisponibleException(
					"La propiedad que está intentando comprar no se encuentra disponible");
		}
	}

	@Override
	public String toString() {
		return "Venta de propiedad (Código: " + propiedad.getCodigo() + ")\nDetalles de la propiedad:\n"
				+ propiedad.toString() + "\nVendedor: " + vendedor.toString() + "\nComprador: " + comprador.toString()
				+ "\nFecha: " + fecha.toString();
	}

	@Override
	public Propiedad getPropiedad() {
		return this.propiedad;
	}
}
