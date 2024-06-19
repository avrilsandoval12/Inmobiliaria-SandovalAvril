package ar.edu.unlam.pb1;

import java.util.Comparator;

public class OrdenarPropiedadesPorPrecio implements Comparator<Propiedad>{
	
	@Override
	public int compare(Propiedad propiedad1, Propiedad propiedad2) {
		return propiedad1.getPrecio().compareTo(propiedad2.getPrecio());
	}

}
