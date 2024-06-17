package ar.edu.unlam.pb1;

public class Casa extends Propiedad {
	
    private static Integer contador = 1;

    public Casa(String calle, Integer numero, String localidad, Double precio, Boolean estaDisponible,
    		TipoDeOperacion tipoDeOperacion, Cliente propietario) {
        super(calle, numero, localidad, precio, estaDisponible, tipoDeOperacion, TiposDePropiedades.CASA, propietario);
        setCodigo("CS" + contador++);
    }
    
	@Override
	public String toString() {
		return "Código: " + getCodigo() + "\nDirección: " + getCalle() + getNumero()
				+ ", " + getLocalidad() + "\nPrecio: " + getPrecio() + "\nEstá disponible: "
				+ getEstaDisponible() + "\nTipo de operación: " + getTipoDeOperacion();
	}
       
}