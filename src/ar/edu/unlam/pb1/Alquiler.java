package ar.edu.unlam.pb1;

public class Alquiler implements Operacion {
	
    @Override
    public void realizarOperacion(Propiedad propiedad, Propiedad propiedad2, Cliente inquilino, Cliente cliente2) {
        if (propiedad2 != null || cliente2 != null) {
            throw new IllegalArgumentException("La operación de alquiler solo debe involucrar una propiedad y un inquilino");
        }
        if (propiedad.estaDisponiblePara(TipoDeOperacion.ALQUILER)) {
            inquilino.getPropiedadesAlquiladas().add(propiedad);
            propiedad.setInquilino(inquilino);
            propiedad.setEstaDisponible(false);
            System.out.println("La propiedad ha sido alquilada exitosamente.");
        } else {
            System.out.println("La propiedad no está disponible para alquilar.");
        }
    }
    
}
