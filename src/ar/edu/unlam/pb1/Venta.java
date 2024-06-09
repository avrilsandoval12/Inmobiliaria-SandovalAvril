package ar.edu.unlam.pb1;

public class Venta implements Operacion {
	
	@Override
	public void realizarOperacion(Propiedad propiedad, Propiedad propiedad2, Cliente comprador, Cliente cliente2) {
		if (propiedad2 != null || cliente2 != null) {
			throw new IllegalArgumentException(
					"La operación de venta solo debe involucrar una propiedad y un comprador");
		}
		if (propiedad.estaDisponiblePara(TipoDeOperacion.VENTA)) {
			comprador.getPropiedadesCompradas().add(propiedad);
			propiedad.setPropietario(comprador);
			propiedad.setEstaDisponible(false);
			System.out.println("La propiedad ha sido comprada exitosamente.");
		} else {
			System.out.println("La propiedad no está disponible para venta.");
		}
	}
}
