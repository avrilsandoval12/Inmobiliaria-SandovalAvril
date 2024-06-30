package ar.edu.unlam.pb1;

import java.util.Comparator;

public class OrdenarPropiedadesPorLocalidad implements Comparator<Propiedad>{
	
	//implementa Comparator (metodo compare) para comparar por otro criterio y ordenar
	//se pasa al momento de crear el treeSet
	
	@Override
	public int compare(Propiedad propiedad1, Propiedad propiedad2) {
		return propiedad1.getLocalidad().compareTo(propiedad2.getLocalidad());
	}
}
