package ar.edu.unlam.pb1;

public class Terreno extends Propiedad{

	private static Integer contador = 1;
	private Double metrosCuadrados;

	public Terreno(String calle, Integer numero, String localidad, Double metrosCuadrados,
			 Double precio, Boolean estaDisponible, TipoDeOperacion tipoDeOperacion) {
		super(calle, numero, localidad, precio, estaDisponible, tipoDeOperacion);
		setCodigo("T" + contador++);
		this.metrosCuadrados = metrosCuadrados;
	}

	public Double getMetrosCuadrados() {
		return metrosCuadrados;
	}

	public void setMetrosCuadrados(Double metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}

}
