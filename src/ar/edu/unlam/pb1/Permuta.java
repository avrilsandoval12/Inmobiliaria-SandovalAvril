package ar.edu.unlam.pb1;

public class Permuta implements Operacion {
	
	@Override
    public void realizarOperacion(Propiedad propiedad1, Propiedad propiedad2, Cliente cliente1, Cliente cliente2) {
        if (propiedad1.estaDisponiblePara(TipoDeOperacion.PERMUTA) && propiedad2.estaDisponiblePara(TipoDeOperacion.PERMUTA)) {
            cliente1.getPropiedadesCompradas().remove(propiedad1);
            cliente1.getPropiedadesCompradas().add(propiedad2);
            cliente2.getPropiedadesCompradas().remove(propiedad2);
            cliente2.getPropiedadesCompradas().add(propiedad1);

            propiedad1.setPropietario(cliente2);
            propiedad2.setPropietario(cliente1);

            System.out.println("Las propiedades han sido permutadas exitosamente.");
        } else {
            System.out.println("Una o ambas propiedades no están disponibles para permuta.");
        }
    }
}

