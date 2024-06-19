package ar.edu.unlam.pb1;

public class Venta implements Operacion {
	
	@Override
	public void realizarOperacion(Propiedad propiedad, Propiedad propiedad2, Cliente comprador, Cliente cliente2) {
		throw new IllegalArgumentException("La operación de venta solo debe involucrar una propiedad y un comprador");
		
	}

	@Override
	public void realizarOperacion(Propiedad propiedad, Cliente comprador) throws PropiedadNoDisponibleException {
		if (propiedad.estaDisponiblePara(TipoDeOperacion.VENTA)) {
			comprador.getPropiedadesCompradas().add(propiedad);
			propiedad.setPropietario(comprador);
			propiedad.setEstaDisponible(false);
		} else {
			throw new PropiedadNoDisponibleException("La propiedad que está intentando comprar no se encuentra disponible");
		}		
	}
}
