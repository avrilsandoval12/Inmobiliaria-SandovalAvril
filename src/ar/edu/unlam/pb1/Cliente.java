package ar.edu.unlam.pb1;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import javax.print.attribute.standard.DateTimeAtCompleted;

public class Cliente {
	//arreglar los metodos

	private Integer dni;
	private String nombre;
	private String apellido;
	private TiposDePropiedades tipoPropiedadInteres;
	private Boolean poseePropiedadParaPermuta;
	private ArrayList<Propiedad> propiedadesCompradas;
	private ArrayList<Propiedad> propiedadesAlquiladas;


	public Cliente(Integer dni, String nombre, String apellido, TiposDePropiedades tipoPropiedadInteres,
			Boolean poseePropiedadParaPermuta) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoPropiedadInteres = tipoPropiedadInteres;
		this.poseePropiedadParaPermuta = poseePropiedadParaPermuta;
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

	public void comprarPropiedad(Propiedad propiedad) {
		if (propiedad.estaDisponiblePara(TipoDeOperacion.VENTA)) {
			this.propiedadesCompradas.add(propiedad);
			
			propiedad.setEstaDisponible(false);
			System.out.println("La propiedad ha sido comprada exitosamente.");
		} else {
			System.out.println("La propiedad no está disponible para venta.");
		}
	}
	
	public void alquilarPropiedad(Propiedad propiedad) {
		if (propiedad.estaDisponiblePara(TipoDeOperacion.ALQUILER)) {
			this.propiedadesAlquiladas.add(propiedad);
			
			propiedad.setEstaDisponible(false);
			System.out.println("La propiedad ha sido alquilada exitosamente.");
		} else {
			System.out.println("La propiedad no está disponible para alquilar.");
		}
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
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", tipoPropiedadInteres="
				+ tipoPropiedadInteres + ", poseePropiedadParaPermuta=" + poseePropiedadParaPermuta
				+ ", propiedadesCompradas=" + propiedadesCompradas + ", propiedadesAlquiladas=" + propiedadesAlquiladas
				+ "]";
	}
	
	

}
