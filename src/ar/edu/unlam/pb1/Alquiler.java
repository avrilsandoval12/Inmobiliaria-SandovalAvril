package ar.edu.unlam.pb1;

public class Alquiler implements Operacion {

	@Override
	public void realizarOperacion(Propiedad propiedad, Propiedad propiedad2, Cliente comprador, Cliente cliente2) {
		throw new IllegalArgumentException("La operación de alquiler solo debe involucrar una propiedad y un inquilino");

	}

	@Override
	public void realizarOperacion(Propiedad propiedad, Cliente inquilino) throws PropiedadNoDisponibleException {
		if (propiedad.estaDisponiblePara(TipoDeOperacion.ALQUILER)) {
			inquilino.getPropiedadesAlquiladas().add(propiedad);
			propiedad.setInquilino(inquilino);
			propiedad.setEstaDisponible(false);
		} else {
			throw new PropiedadNoDisponibleException();
		}
	}
}
