package ar.edu.unlam.pb1;

public class Departamento {
	//prueba git

	private static Integer contador = 1;
	private String codigo;
	private String calle;
	private Integer numero;
	private String localidad;
	private Double precio;
	private Boolean estaDisponible;
	private TipoDeOperacion tipoDeOperacion;
	private Integer piso; 
	private Character departamento; 
	
	public Departamento(String calle, Integer numero, String localidad, Integer piso, Character departamento,
			Double precio, Boolean estaDisponible, TipoDeOperacion tipoDeOperacion) {
		this.codigo = "D" + contador++;
		this.calle = calle;
		this.numero = numero;
		this.localidad = localidad;
		this.piso = piso;
		this.departamento = departamento;
		this.precio = precio;
		this.estaDisponible = estaDisponible;
		this.tipoDeOperacion = tipoDeOperacion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
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

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Boolean getEstaDisponible() {
		return estaDisponible;
	}

	public void setEstaDisponible(Boolean estaDisponible) {
		this.estaDisponible = estaDisponible;
	}

	public TipoDeOperacion getTipoDeOperacion() {
		return tipoDeOperacion;
	}

	public void setTipoDeOperacion(TipoDeOperacion tipoDeOperacion) {
		this.tipoDeOperacion = tipoDeOperacion;
	}

	public boolean estaDisponibleParaVenta() {
        return estaDisponible && tipoDeOperacion == TipoDeOperacion.VENTA;
    }

    public boolean estaDisponibleParaAlquiler() {
        return estaDisponible && tipoDeOperacion == TipoDeOperacion.ALQUILER;
    }
	
}