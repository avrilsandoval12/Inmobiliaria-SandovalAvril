package ar.edu.unlam.pb1;

public class Departamento extends Propiedad{

	private static Integer contador = 1;
	private Integer piso; 
	private Character departamento; 
	
	public Departamento(String calle, Integer numero, String localidad, Integer piso, Character departamento,
			Double precio, Boolean estaDisponible, TipoDeOperacion tipoDeOperacion) {
		super(calle, numero, localidad, precio, estaDisponible, tipoDeOperacion);
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
	
}