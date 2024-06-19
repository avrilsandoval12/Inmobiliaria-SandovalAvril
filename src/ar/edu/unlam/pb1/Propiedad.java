package ar.edu.unlam.pb1;

import java.util.Objects;

public abstract class Propiedad {

	private String codigo;
	private String calle;
	private Integer numero;
	private String localidad;
	private Double precio;
	private Boolean estaDisponible;
	private TipoDeOperacion tipoDeOperacion;
	private TiposDePropiedades tipoDePropiedad;
    private Cliente propietario;
    private Cliente inquilino;

	public Propiedad(String calle, Integer numero, String localidad, Double precio,
			Boolean estaDisponible, TipoDeOperacion tipoDeOperacion, TiposDePropiedades tipoDePropiedad, Cliente propietario) {
        if (precio < 0 || precio == null) {
            throw new IllegalArgumentException("El precio no puede ser negativo o nulo.");
        }
		if (tipoDeOperacion == null) {
            throw new IllegalArgumentException("El tipo de operación no puede ser nulo o vacío.");
        }
		this.calle = calle;
		this.numero = numero;
		this.localidad = localidad;
		this.precio = precio;
		this.estaDisponible = estaDisponible;
		this.tipoDeOperacion = tipoDeOperacion;
		this.tipoDePropiedad = tipoDePropiedad;
        this.propietario = propietario;
        this.inquilino = null;
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
	
	public TiposDePropiedades getTipoDePropiedad() {
		return tipoDePropiedad;
	}

	public void setTipoDePropiedad(TiposDePropiedades tipoDePropiedad) {
		this.tipoDePropiedad = tipoDePropiedad;
	}
	
	public Cliente getPropietario() {
        return propietario;
    }

    public void setPropietario(Cliente propietario) {
        this.propietario = propietario;
    }

	public Cliente getInquilino() {
		return inquilino;
	}

	public void setInquilino(Cliente inquilino) {
		this.inquilino = inquilino;
	}
	
    public String toString() {
    	return this.codigo + ("\nDirección: ") + this.calle + (" ") + this.numero;
    }
    
    public Boolean estaDisponiblePara(TipoDeOperacion tipoDeOperacion) {
    	return this.estaDisponible && (this.tipoDeOperacion == tipoDeOperacion);
    }

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Propiedad other = (Propiedad) obj;
		return Objects.equals(codigo, other.codigo);
	}
    
    
}
