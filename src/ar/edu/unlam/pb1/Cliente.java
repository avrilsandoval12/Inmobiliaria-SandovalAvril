package ar.edu.unlam.pb1;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import javax.print.attribute.standard.DateTimeAtCompleted;

public class Cliente {

	private Integer dni;
	private String nombre;
	private String apellido;
	private TiposDePropiedades tipoPropiedadInteres;
	private Boolean poseePropiedadParaPermuta;
	private ArrayList<Propiedad> propiedadesCompradas;
	private ArrayList<Propiedad> propiedadesAlquiladas;

	public Cliente(Integer dni, String nombre, String apellido, TiposDePropiedades tipoPropiedadInteres,
			Boolean poseePropiedadParaPermuta) {
		if (dni == null) {
			throw new IllegalArgumentException("El DNI no puede ser nulo");
		}
		if (nombre == null || nombre.isEmpty()) {
			throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
		}
		if (apellido == null || apellido.isEmpty()) {
			throw new IllegalArgumentException("El apellido no puede ser nulo o vacío");
		}
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoPropiedadInteres = tipoPropiedadInteres;
		this.poseePropiedadParaPermuta = poseePropiedadParaPermuta;
		this.propiedadesCompradas = new ArrayList<>();
		this.propiedadesAlquiladas = new ArrayList<>();
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public TiposDePropiedades getTipoPropiedadInteres() {
		return tipoPropiedadInteres;
	}

	public void setTipoPropiedadInteres(TiposDePropiedades tipoPropiedadInteres) {
		this.tipoPropiedadInteres = tipoPropiedadInteres;
	}

	public Boolean getPoseePropiedadParaPermuta() {
		return poseePropiedadParaPermuta;
	}

	public void setPoseePropiedadParaPermuta(Boolean poseePropiedadParaPermuta) {
		this.poseePropiedadParaPermuta = poseePropiedadParaPermuta;
	}
	
	public ArrayList<Propiedad> getPropiedadesCompradas() {
		return propiedadesCompradas;
	}

	public void setPropiedadesCompradas(ArrayList<Propiedad> propiedadesCompradas) {
		this.propiedadesCompradas = propiedadesCompradas;
	}

	public ArrayList<Propiedad> getPropiedadesAlquiladas() {
		return propiedadesAlquiladas;
	}

	public void setPropiedadesAlquiladas(ArrayList<Propiedad> propiedadesAlquiladas) {
		this.propiedadesAlquiladas = propiedadesAlquiladas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(dni, other.dni);
	}

	@Override
	public String toString() {
		return "Cliente: DNI: " + dni + "\nNombre Completo: " + apellido + nombre + "\nTipo de propiedad de interés: "
				+ tipoPropiedadInteres + "\nPosee propiedad para permutar:" + poseePropiedadParaPermuta
				+ "\nPropiedades compradas: " + propiedadesCompradas + "\nPropiedades alquiladas="
				+ propiedadesAlquiladas;
	}

}
