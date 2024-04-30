package ar.edu.unlam.pb1;

public class Casa extends Propiedad {
	
    private static Integer contador = 1;

    public Casa(String calle, Integer numero, String localidad, Double precio, Boolean estaDisponible,
                TipoDeOperacion tipoDeOperacion) {
        super(calle, numero, localidad, precio, estaDisponible, tipoDeOperacion);
        setCodigo("CS" + contador++);
    }
   
}