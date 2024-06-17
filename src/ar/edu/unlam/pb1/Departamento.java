package ar.edu.unlam.pb1;

public class Departamento extends Propiedad{

	private static Integer contador = 1;
	private Integer piso; 
	private Character departamento; 
	
	public Departamento(String calle, Integer numero, String localidad, Integer piso, Character departamento,
			Double precio, Boolean estaDisponible, TipoDeOperacion tipoDeOperacion, Cliente propietario) {
		super(calle, numero, localidad, precio, estaDisponible, tipoDeOperacion, TiposDePropiedades.DEPARTAMENTO, propietario);
		setCodigo("D" + contador++);
		this.piso = piso;
		this.departamento = departamento;
	}

	public Integer getPiso() {
		return piso;
	}

	public void setPiso(Integer piso) {
		this.piso = piso;
	}

	public Character getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Character departamento) {
		this.departamento = departamento;
	}
	
	@Override
	public String toString() {
		return "Código: " + getCodigo() + "\nDirección: " + getCalle() + getNumero()
				+ ", " + getLocalidad() + "\nPrecio: " + getPrecio() + "\nEstá disponible: "
				+ getEstaDisponible() + "\nTipo de operación: " + getTipoDeOperacion() + "\nPiso: " + getPiso() + ", departamento: " + getDepartamento();
	}
	
	
}