package ar.edu.unlam.pb1;

public class Campo extends Propiedad{

	private static Integer contador = 1;
	private Double hectareas;

	public Campo(String calle, String localidad, Double hectareas, Double precio, Boolean estaDisponible,
			TipoDeOperacion tipoDeOperacion, Integer numero) {
		super(calle, numero, localidad, precio, estaDisponible, tipoDeOperacion);
		this.hectareas = hectareas;
	}

	public Double getHectareas() {
		return hectareas;
	}

	public void setHectareas(Double hectareas) {
		this.hectareas = hectareas;
	}
	
	@Override
	public String toString() {
		return "Código: " + getCodigo() + "\nDirección: " + getCalle() + getNumero()
				+ ", " + getLocalidad() + "\nPrecio: " + getPrecio() + "\nEstá disponible: "
				+ getEstaDisponible() + "\nTipo de operación: " + getTipoDeOperacion() + "\nHectáreas: " + getHectareas();
	}

}
