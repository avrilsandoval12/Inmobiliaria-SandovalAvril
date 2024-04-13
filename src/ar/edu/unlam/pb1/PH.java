package ar.edu.unlam.pb1;

public class PH {
	//prueba git

	private static Integer contador = 1;
	private String codigo;
	private String calle;
	private Integer numero;
	private String localidad;
	private Double precio;
	private Boolean estaDisponible;
	private TipoDeOperacion tipoDeOperacion;
	private Integer numeroDePH;
	
	public PH(String calle, Integer numero, String localidad, Integer numeroDePH, Double precio, Boolean estaDisponible,
			TipoDeOperacion tipoDeOperacion) {
		this.codigo= "PH" + contador++;
		this.calle = calle;
		this.numero = numero;
		this.localidad = localidad;
		this.numeroDePH = numeroDePH;
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

	public Integer getNumeroDePH() {
		return numeroDePH;
	}

	public void setNumeroDePH(Integer numeroDePH) {
		this.numeroDePH = numeroDePH;
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
