package ar.edu.unlam.pb1;

public class PH extends Propiedad{

	private static Integer contador = 1;
	private Integer numeroDePH;
	
	public PH(String calle, Integer numero, String localidad, Integer numeroDePH, Double precio, Boolean estaDisponible,
			TipoDeOperacion tipoDeOperacion, Cliente propietario) {
		super(calle, numeroDePH, localidad, precio, estaDisponible, tipoDeOperacion, TiposDePropiedades.PH, propietario);
		setCodigo("PH" + contador++);
		this.numeroDePH = numeroDePH;
	}

	public Integer getNumeroDePH() {
		return numeroDePH;
	}

	public void setNumeroDePH(Integer numeroDePH) {
		this.numeroDePH = numeroDePH;
	}

	@Override
	public String toString() {
		return "Código: " + getCodigo() + "\nDirección: " + getCalle() + getNumero()
				+ ", " + getLocalidad() + "\nPrecio: " + getPrecio() + "\nEstá disponible: "
				+ getEstaDisponible() + "\nTipo de operación: " + getTipoDeOperacion() + "\nNúmero del ph: " + getNumeroDePH();
	}
}
