package ar.edu.unlam.pb1;

import java.util.Comparator;

public class OrdenarPropiedadesPorLocalidad implements Comparator<Propiedad>{
	
	@Override
	public int compare(Propiedad propiedad1, Propiedad propiedad2) {
		return propiedad1.getLocalidad().compareTo(propiedad2.getLocalidad());
	}
}
