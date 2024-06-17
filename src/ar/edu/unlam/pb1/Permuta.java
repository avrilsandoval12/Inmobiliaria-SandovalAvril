package ar.edu.unlam.pb1;

public class Permuta implements Operacion {
	
	@Override
	public void realizarOperacion(Propiedad propiedad1, Cliente cliente1){
		throw new IllegalArgumentException("La operación de permuta debe involucrar dos propiedades y dos clientes");
		
	}
	
	@Override
    public void realizarOperacion(Propiedad propiedad1, Propiedad propiedad2, Cliente cliente1, Cliente cliente2) throws PropiedadNoDisponibleException {
        if (propiedad1.estaDisponiblePara(TipoDeOperacion.PERMUTA) && propiedad2.estaDisponiblePara(TipoDeOperacion.PERMUTA)) {
            cliente1.getPropiedadesCompradas().remove(propiedad1);
            cliente1.getPropiedadesCompradas().add(propiedad2);
            cliente2.getPropiedadesCompradas().remove(propiedad2);
            cliente2.getPropiedadesCompradas().add(propiedad1);

            propiedad1.setPropietario(cliente2);
            propiedad2.setPropietario(cliente1);
            propiedad1.setEstaDisponible(false);
            propiedad2.setEstaDisponible(false);

        } else {
			throw new PropiedadNoDisponibleException();
        }
    }

}

